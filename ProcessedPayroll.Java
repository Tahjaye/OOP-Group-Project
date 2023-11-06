package domain;




public class ProcessedPayroll extends Entity{
	private double regularPay;
	private double grossPay;
	
	@Override
	public String toString() {
		return "ProcessedPayroll [regularPay=" + regularPay + ", grossPay=" + grossPay + "]";
	}
	public String toString(int i) {
	      return "";
	}
	public ProcessedPayroll(double regularPay, double grossPay) {
		super();
		this.regularPay = regularPay;
		this.grossPay = grossPay;
	}
	public double getRegularPay() {
		return regularPay;
	}
	public void setRegularPay(double regularPay) {
		this.regularPay = regularPay;
	}
	public double getGrossPay() {
		return grossPay;
	}
	public void setGrossPay(double grossPay) {
		this.grossPay = grossPay;
	}
	
	
	@Override
	public String fileData() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void store() {
		// TODO Auto-generated method stub
		
	}
}

