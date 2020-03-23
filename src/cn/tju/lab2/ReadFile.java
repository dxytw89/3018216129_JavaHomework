package cn.tju.lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

//代码执行结果存储在./result/lab2中

public class ReadFile {
	
	public static void main(String args[]) throws Exception {
		File file1 = new File("E:" + File.separator + "Windows" + 
				File.separator+"Homework"+File.separator+"编程练习"+File.separator+"writeroutput.txt");
		
		ReadFile rf1 = new ReadFile();
		rf1.bfMethod(file1);
		
		ReadFile rf2 = new ReadFile();
		rf2.isMethod(file1);
	}
	
	
	/*
	 * 通过BufferedReader来读入文件
	 */
	public void bfMethod(File file) throws Exception {
		
		TreeMap<String,Integer> hm = new TreeMap<>();
		//读取文件
		readInByBufferedReader(hm,file);
		
		//排序
		List<Entry<String,Integer>> list = sortByValue(hm);
		
		//输出文件
		
		output(hm,list,"bfOutputStream.txt");
		

	}
	
	private void readInByBufferedReader(Map<String,Integer> hm, File file) throws Exception {
		BufferedReader is = new BufferedReader(new FileReader(file));
		String text = null;
		
		while((text = is.readLine()) != null) {
			//解析读取到的字符串，把句子分割为单词
			StringTokenizer st = new StringTokenizer(text," ,?.!:\\\"\\\"''\\n#");
			while(st.hasMoreElements()) {
				String tempStr = st.nextToken().toLowerCase(); 
				//统计单词频次
				if(hm.containsKey(tempStr)) {
					// 如果单词已存在map中
					hm.put(tempStr, hm.get(tempStr)+1);
				}else {
					hm.put(tempStr,1);
				}
			}
		}
		is.close();
	}
	
	
	/*
	 * 通过InputStream读入文件
	 */
	
	public void isMethod(File file) throws Exception{
		TreeMap<String,Integer> hm = new TreeMap<>();
		//读取文件
		readInByInputStream(hm,file);
		
		//排序
		List<Entry<String,Integer>> list = sortByValue(hm);
		
		//输出文件
		output(hm,list,"isOutputFile.txt");
	}
	
	private void readInByInputStream(Map<String,Integer> hm, File file) throws Exception {
		InputStream iso = new FileInputStream(file);
		StringBuffer sb = new StringBuffer();
		int temp = 0;
		do {
			temp = iso.read();
			if(temp!=-1) {
				sb.append((char)temp);
			}
		}while(temp!=-1);
		iso.close();
	
		StringTokenizer st = new StringTokenizer(sb.toString()," ,?.!:\\\"\\\"''\\n#");
		while(st.hasMoreElements()) {
			String tempStr = st.nextToken().toLowerCase(); 
			if(hm.containsKey(tempStr)) {
				hm.put(tempStr, hm.get(tempStr)+1);
			}else {
				hm.put(tempStr,1);
			}
		}	
	}
	
	
	
	
	
	
	
	/*
	 * 按频次排序
	 */
	private List<Entry<String,Integer>> sortByValue(Map<String,Integer> hm) {
		List<Entry<String,Integer>> list = new ArrayList<Entry<String,Integer>>(hm.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            //升序排序
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
		return list;
	}
	
	/*
	 * 输出文件
	 */
	private void output(Map<String,Integer> hm, List<Entry<String,Integer>> list, String file) throws IOException {	
		File outputFile = new File("E:" + File.separator + "Windows" + File.separator + 
				"Homework" + File.separator + "JavaHomework" + File.separator+
				"Java进阶" + File.separator + "Lab2" + File.separator + file);
		if(!outputFile.exists()) {
			outputFile.createNewFile();
		}
		
		OutputStream os = new FileOutputStream(outputFile);
		StringBuffer sb = new StringBuffer();
		for (Entry<String, Integer> e: list) {
			sb.append(e.getKey() + " " + e.getValue()+"\n");
		}
		byte data[] = sb.toString().getBytes();
		os.write(data);
		os.close();
	}
	
}
