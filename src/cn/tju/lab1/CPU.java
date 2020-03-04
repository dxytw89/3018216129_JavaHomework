package cn.tju.lab1;

abstract public class CPU extends Component{

	private int coreNum;
	
	public CPU(String name, int coreNum, int price) {
		super(name,price);
		this.coreNum = coreNum;
	}

	public int getCoreNum() {
		return coreNum;
	}

	public void setCoreNum(int coreNum) {
		this.coreNum = coreNum;
	}
	
	
}

class Intel extends CPU{
	public Intel(String name, int coreNum, int price) {
		super(name,coreNum,price);
	}
	
	//ʵ��function�ӿ�
	public void workMethod() {
		System.out.println(super.getName() + " work" + '\n');
	}
	
	public void description() {
		System.out.println("CPU��Ϣ����:");
		System.out.println("����:  " + super.getName() + "\n"
				 +"Ʒ��: " + this.getClass().getName() + '\n'
						  +"������: " + super.getCoreNum() + "\n"
						  +"�۸�:  " + super.getPrice() + "Ԫ");
	}
}

class AMD extends CPU{
	public AMD(String name, int coreNum, int price) {
		super(name,coreNum,price);
	}
	
	//ʵ��function�ӿ�
	public void workMethod() {
		System.out.println(super.getName() + " work");
	}
	
	public void description() {
		System.out.println("CPU��Ϣ����:");
		System.out.println("����:  " + super.getName() + "\n"
				 +"Ʒ��: " + this.getClass().getName() + '\n'
						  +"������: " + super.getCoreNum() + "\n"
						  +"�۸�:  " + super.getPrice() + "Ԫ");
	}

}
