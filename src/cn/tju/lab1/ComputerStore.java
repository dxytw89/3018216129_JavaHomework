package cn.tju.lab1;

public class ComputerStore {
	public static void main(String args[]) {
		
		//����ÿ�ֵ��������ÿ��Ʒ�Ƶ�ʵ������ֵΪ�鹹��ֵ��
		CPU cpu1 = new Intel("intel_instance",8,1000);
		CPU cpu2 = new AMD("amd_instance",4,2000);
		
		RAM ram1 = new Samsung("samsung_instance",8,3000);
		RAM ram2 = new Kingston("kingston_instance",4,4000);
		
		ROM rom1 = new Seagate("seagate_instance",1024,5000);
		ROM rom2 = new WestDigitals("westDigitals_instance",1024,6000);
		
		MotherBoard mb1 = new Asus("asus_instance",2,7000);
		MotherBoard mb2 = new Gigabyte("gigabyte_instance",1,8000);
		
		//������������������3�ֲ�ͬ�ĵ���
		Component[] component1 = {cpu1,ram1,rom1,mb1};
		Computer computer1 = new Computer("Mark", component1);
		
		Component[] component2 = {cpu2,ram2,rom2,mb2};
		Computer computer2 = new Computer("Jack", component2);
		
		Component[] component3 = {cpu1,ram1,rom2,mb2};
		Computer computer3 = new Computer("Trump", component3);
		
		Computer[] computer = {computer1,computer2, computer3}; 
		
		//��ӡ�̵���Ϣ
		System.out.println("���깲��3�ֵ��ԣ����ǵ���Ϣ���£�");
		for(int i = 0; i < computer.length; i++) {
			System.out.println();
			System.out.println("��" + (i+1) + "����ԣ�" );
			computer[i].getDescription();
			System.out.println();
		}
	}
}
