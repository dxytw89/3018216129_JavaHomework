package cn.tju.lab1;

public class Computer {
	//������Ե����ԣ����ƣ��ܼۣ�������������������
	private String name;
	private int totalPrice;
	public static final int componentNum = 4;
	private Component[] component;
	
	public Computer() {
		name = "Tom";
		totalPrice = 0;
		component = new Component[componentNum];
		for(int i = 0; i < componentNum; i++) {
			component[i] = null;
		}
	}
	
	public Computer(String name, Component[] component) {
		this();
		this.name = name;
		this.component = component;
		//�����ܼ�
		for(int i = 0; i < componentNum; i++) {
			totalPrice += component[i].getPrice(); 
		}
	}
	
	//��ȡ��ǰ����ʵ���ľ�����Ϣ
	public void getDescription() {
		System.out.println("���ƣ� " + name);
		System.out.println("�ܼ�: " + totalPrice+"Ԫ");
		System.out.println("��ϸ��Ϣ: ");
		System.out.println("-------------------------------");
		for(int i = 0; i < componentNum; i++) {
			if(component[i] != null) {
				component[i].description();
				System.out.print("����״̬��");
				component[i].workMethod();
			}
		}
		System.out.println("-------------------------------");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
}
