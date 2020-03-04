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
	
	//实现function接口
	public void workMethod() {
		System.out.println(super.getName() + " work" + '\n');
	}
	
	public void description() {
		System.out.println("CPU信息如下:");
		System.out.println("名称:  " + super.getName() + "\n"
				 +"品牌: " + this.getClass().getName() + '\n'
						  +"核数量: " + super.getCoreNum() + "\n"
						  +"价格:  " + super.getPrice() + "元");
	}
}

class AMD extends CPU{
	public AMD(String name, int coreNum, int price) {
		super(name,coreNum,price);
	}
	
	//实现function接口
	public void workMethod() {
		System.out.println(super.getName() + " work");
	}
	
	public void description() {
		System.out.println("CPU信息如下:");
		System.out.println("名称:  " + super.getName() + "\n"
				 +"品牌: " + this.getClass().getName() + '\n'
						  +"核数量: " + super.getCoreNum() + "\n"
						  +"价格:  " + super.getPrice() + "元");
	}

}
