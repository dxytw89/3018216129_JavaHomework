package cn.tju.lab1;

public class Computer {
	//定义电脑的属性：名称，总价，组件的数量，组件数组
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
		//计算总价
		for(int i = 0; i < componentNum; i++) {
			totalPrice += component[i].getPrice(); 
		}
	}
	
	//获取当前电脑实例的具体信息
	public void getDescription() {
		System.out.println("名称： " + name);
		System.out.println("总价: " + totalPrice+"元");
		System.out.println("详细信息: ");
		System.out.println("-------------------------------");
		for(int i = 0; i < componentNum; i++) {
			if(component[i] != null) {
				component[i].description();
				System.out.print("工作状态：");
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
