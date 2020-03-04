package cn.tju.lab1;

abstract public class MotherBoard extends Component {
	
	private int speed;
	
	public MotherBoard(String name, int speed, int price) {
		super(name,price);
		this.speed = speed;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}

class Asus extends MotherBoard{
	public Asus(String name, int volumn, int price) {
		super(name,volumn,price);
	}
	
	@Override
	public void workMethod() {
		// TODO Auto-generated method stub
		System.out.println(super.getName() + "work" + '\n');
	}

	@Override
	public void description() {
		// TODO Auto-generated method stub
		System.out.println("MotherBoard信息如下:");
		System.out.println("名称:  " + super.getName() + "\n"
						  +"品牌: " + this.getClass().getName() + '\n'
						  +"速度: " + super.getSpeed() + "\n"+"GHz"
						  +"价格:  " + super.getPrice()+"元");
	}
}

class Gigabyte extends MotherBoard{
	public Gigabyte(String name, int volumn, int price) {
		super(name,volumn,price);
	}
	
	@Override
	public void workMethod() {
		// TODO Auto-generated method stub
		System.out.println(super.getName() + "work" + '\n');
	}

	@Override
	public void description() {
		// TODO Auto-generated method stub
		System.out.println("MotherBoard信息如下:");
		System.out.println("名称:  " + super.getName() + "\n"
						  +"品牌: " + this.getClass().getName() + '\n'
						  +"速度: " + super.getSpeed() + "\n"+"GHz"
						  +"价格:  " + super.getPrice() + "元");
	}
}