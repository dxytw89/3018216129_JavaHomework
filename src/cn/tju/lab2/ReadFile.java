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

//����ִ�н���洢��./result/lab2��

public class ReadFile {
	
	public static void main(String args[]) throws Exception {
		File file1 = new File("E:" + File.separator + "Windows" + 
				File.separator+"Homework"+File.separator+"�����ϰ"+File.separator+"writeroutput.txt");
		
		ReadFile rf1 = new ReadFile();
		rf1.bfMethod(file1);
		
		ReadFile rf2 = new ReadFile();
		rf2.isMethod(file1);
	}
	
	
	/*
	 * ͨ��BufferedReader�������ļ�
	 */
	public void bfMethod(File file) throws Exception {
		
		TreeMap<String,Integer> hm = new TreeMap<>();
		//��ȡ�ļ�
		readInByBufferedReader(hm,file);
		
		//����
		List<Entry<String,Integer>> list = sortByValue(hm);
		
		//����ļ�
		
		output(hm,list,"bfOutputStream.txt");
		

	}
	
	private void readInByBufferedReader(Map<String,Integer> hm, File file) throws Exception {
		BufferedReader is = new BufferedReader(new FileReader(file));
		String text = null;
		
		while((text = is.readLine()) != null) {
			//������ȡ�����ַ������Ѿ��ӷָ�Ϊ����
			StringTokenizer st = new StringTokenizer(text," ,?.!:\\\"\\\"''\\n#");
			while(st.hasMoreElements()) {
				String tempStr = st.nextToken().toLowerCase(); 
				//ͳ�Ƶ���Ƶ��
				if(hm.containsKey(tempStr)) {
					// ��������Ѵ���map��
					hm.put(tempStr, hm.get(tempStr)+1);
				}else {
					hm.put(tempStr,1);
				}
			}
		}
		is.close();
	}
	
	
	/*
	 * ͨ��InputStream�����ļ�
	 */
	
	public void isMethod(File file) throws Exception{
		TreeMap<String,Integer> hm = new TreeMap<>();
		//��ȡ�ļ�
		readInByInputStream(hm,file);
		
		//����
		List<Entry<String,Integer>> list = sortByValue(hm);
		
		//����ļ�
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
	 * ��Ƶ������
	 */
	private List<Entry<String,Integer>> sortByValue(Map<String,Integer> hm) {
		List<Entry<String,Integer>> list = new ArrayList<Entry<String,Integer>>(hm.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            //��������
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
		return list;
	}
	
	/*
	 * ����ļ�
	 */
	private void output(Map<String,Integer> hm, List<Entry<String,Integer>> list, String file) throws IOException {	
		File outputFile = new File("E:" + File.separator + "Windows" + File.separator + 
				"Homework" + File.separator + "JavaHomework" + File.separator+
				"Java����" + File.separator + "Lab2" + File.separator + file);
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
