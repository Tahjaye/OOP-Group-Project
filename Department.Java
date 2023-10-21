package domain;

public class Department {
	private int deptCode;
	private String deptName;
	private double regRate;
	private double overtimeRate;
	
	//Default/Parameterless Constructor
	public Department() {
		this.deptCode = 0;
		this.deptName = " ";
		this.regRate = 0.0;
		this.overtimeRate = 0.0;
	}
	//Primary Constructor
	public Department(int deptCode, String deptName, double regRate, double overtimeRate) {
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.regRate = regRate;
		this.overtimeRate = overtimeRate;
	}
	//Copy Constructor
	public Department(Department obj) {
		this.deptCode = obj.deptCode;
		this.deptName = obj.deptName;
		this.regRate = obj.regRate;
		this.overtimeRate = obj.overtimeRate;
	}
	
	
	@Override
	public String toString() {
		return "deptCode: " + deptCode + "\ndeptName: " + deptName + "\nregRate: " + regRate
				+ "\novertimeRate: " + overtimeRate ;
	}
	//Acessors
	public int getDeptCode() {
		return deptCode;
	}
	public double getRegRate() {
		return regRate;
	}
	public double getOvertimeRate() {
		return overtimeRate;
	}
	public String getDeptName() {
		return deptName;
	}
	
	//Mutators
	public void setDeptCode(int deptCode) {
		this.deptCode = deptCode;
	}
	public void setRegRate(double regRate) {
		this.regRate = regRate;
	}
	public void setOvertimeRate(double overtimeRate) {
		this.overtimeRate = overtimeRate;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


}
