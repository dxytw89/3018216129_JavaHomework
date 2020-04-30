package cn.tju.lab4;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Main extends Thread{

	private double[][] matrix_A;
	private double[][] matrix_B;
	private int index;
	private int gap;
	private double[][] result;
	private CountDownLatch countDownLatch;
	private static final int NUMBER_OF_THREAD = 10;
 
	public Main(double[][] matrix_A, double[][] matrix_B, int index, int gap, double[][] result, CountDownLatch countDownLatch) {
		this.matrix_A = matrix_A;
		this.matrix_B = matrix_B;
		this.index = index;
		this.gap = gap;
		this.result = result;
		this.countDownLatch = countDownLatch;
	}
 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = index * gap; i < (index + 1) * gap; i++)
			for (int j = 0; j < matrix_B[0].length; j++) {
				for (int k = 0; k < matrix_B.length; k++)
					result[i][j] += matrix_A[i][k] * matrix_B[k][j];
			}
		countDownLatch.countDown();
	}
 
	public static void main(String[] args) throws InterruptedException {
		
		long startTime;//起始时间
		long endTime;//结束时间
		
		System.out.print("请输入所需要的矩阵1的行和列：");
		Scanner inputMatrix_A = new Scanner(System.in);
		int row_A = inputMatrix_A.nextInt();
    	int col_A= inputMatrix_A.nextInt();
    
		System.out.print("请输入所需要的矩阵2的行和列：");
		Scanner inputMatrix_B = new Scanner(System.in);
		int row_B = inputMatrix_B.nextInt();     
    	int col_B= inputMatrix_B.nextInt(); 
    	
		double[][] matrix_A = MatrixGenerator.create_Matrix(row_A, col_A);
		double[][] matrix_B = MatrixGenerator.create_Matrix(row_B, col_B);
		
        // 并行计算
		double[][] parallel = new double[matrix_A.length][matrix_B[0].length];
		
        // 串行计算
		double[][] serial = new double[matrix_A.length][matrix_B[0].length];
		
        // 子线程的分片
		int gap = matrix_A.length / NUMBER_OF_THREAD;
		CountDownLatch countDownLatch = new CountDownLatch(NUMBER_OF_THREAD);
		
		// 并行
		startTime = System.currentTimeMillis();
		for (int i = 0; i < NUMBER_OF_THREAD; i++) {
			Main ct = new Main(matrix_A, matrix_B, i, gap, parallel, countDownLatch);
			ct.start();
		}
		countDownLatch.await();
		endTime = System.currentTimeMillis();
		System.out.println("并行计算运行时间:" + (endTime - startTime)+" ms");
 
		// 串行
		startTime = System.currentTimeMillis();
		for (int i = 0; i < matrix_A.length; i++) {
			for (int j = 0; j < matrix_B[0].length; j++) {
				for (int k = 0; k < matrix_A[0].length; k++)
					serial[i][j] += matrix_A[i][k] * matrix_B[k][j];
			}
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("串行计算运行时间:" + (endTime - startTime) + " ms");
		
		inputMatrix_A.close();
		inputMatrix_B.close();
	}

}
