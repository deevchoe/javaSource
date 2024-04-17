package pack3;

public class Ex19Manager extends Ex19Regular{

	private double incentive;
	
	public Ex19Manager(String irum, int nai, int salary) {
		super(irum, nai, salary);
		// TODO Auto-generated constructor stub
		if(salary >= 2500000) {
			incentive = salary * 0.6;
		} else if(salary >= 2000000) {
			incentive = salary * 0.5;
		} else if(salary < 2000000) {
			incentive = salary * 0.4;
		}
	}
	
	@Override
	public double pay() {
		return super.pay() + incentive;
	}
	@Override
	public void print() {
		display();
		System.out.println(", 수령액 : " + pay());
	}
}
