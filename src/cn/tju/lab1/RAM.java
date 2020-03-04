package cn.tju.lab1;

abstract public class RAM extends Component{

	private int volumn;
	
	public RAM(String name, int volumn, int price) {
		super(name,price);
		this.volumn = volumn;
	}

	
	public int getVolumn() {
		return volumn;
	}


	public void setVolumn(int volumn) {
		this.volumn = volumn;
	}
}

class Samsung extends RAM{
	public Samsung(String name, int volumn, int price) {
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
		System.out.println("RAM��Ϣ����:");
		System.out.println("����:  " + super.getName() + "\n"
						  +"Ʒ��: " + this.getClass().getName() + '\n'
						  +"��С: " + super.getVolumn() + "\n"+"G"
						  +"�۸�:  " + super.getPrice() + "Ԫ");
	}
}

class Kingston extends RAM{
	public Kingston(String name, int volumn, int price) {
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
		System.out.println("RAM��Ϣ����:");
		System.out.println("����:  " + super.getName() + "\n"
				 +"Ʒ��: " + this.getClass().getName() + '\n'
						  +"��С: " + super.getVolumn() + "\n" +"G"
						  +"�۸�:  " + super.getPrice() + "Ԫ");
	}
}