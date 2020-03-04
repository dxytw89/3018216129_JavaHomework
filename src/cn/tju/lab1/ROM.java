package cn.tju.lab1;

abstract public class ROM extends Component {

	private int volumn;
	
	public ROM(String name, int volumn, int price) {
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

class Seagate extends ROM{
	public Seagate(String name, int volumn, int price) {
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
		System.out.println("ROM��Ϣ����:");
		System.out.println("����:  " + super.getName() + "\n"
				 +"Ʒ��: " + this.getClass().getName() + '\n'
						  +"��С: " + super.getVolumn() + "\n"+"G"
						  +"�۸�:  " + super.getPrice() + "Ԫ");
	}
}

class WestDigitals extends ROM{
	public WestDigitals(String name, int volumn, int price) {
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
		System.out.println("ROM��Ϣ����:");
		System.out.println("����:  " + super.getName() + "\n"
				 +"Ʒ��: " + this.getClass().getName() + '\n'	
						  +"��С: " + super.getVolumn() + "\n"+"G"
						  +"�۸�:  " + super.getPrice() + "Ԫ");
	}
}