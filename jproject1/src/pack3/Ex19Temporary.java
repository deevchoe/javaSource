package pack3;

public class Ex19Temporary extends Ex19Employee{

	private int ilsu;
	private int ildang;
	
	public Ex19Temporary(String irum, int nai, int ilsu, int ildang) {
		super(irum, nai);
		this.ilsu = ilsu;
		this.ildang = ildang;
	}
	
	@Override
	public double pay() {
		return this.ilsu * this.ildang;
	}
						
	@Override
	public void print() {
		display();
		System.out.println(", 급여 : " + this.pay());
		
	}
}
