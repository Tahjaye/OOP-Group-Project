package domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Department extends Entity{
	private String deptName;
	private double regRate;
	private double overtimeRate;
	
	//Default/Parameterless Constructor
	public Department() {
		super();
		this.deptName = " ";
		this.regRate = 0.0;
		this.overtimeRate = 0.0;
		
	}
	//Primary Constructor
	public Department(int deptCode, String deptName, double regRate, double overtimeRate) {
		super(deptCode);
		this.deptName = deptName;
		this.regRate = regRate;
		this.overtimeRate = overtimeRate;
		
	}
	//Copy Constructor
	public Department(Department obj) {
		super(obj.getDeptCode());
		this.deptName = obj.deptName;
		this.regRate = obj.regRate;
		this.overtimeRate = obj.overtimeRate;
		//System.out.println("/nDepartment Created");
		//System.out.println(this.toString());
	} 
	
	@Override
	public String toString() {
		return "Department Code: " + this.getDeptCode() + "\nDepartment Name: " + deptName + "\nRegular Rate: " + regRate
				+ "\nOvertime Rate: " + overtimeRate ;
	}
	public String toString(int i) {
	      return "+----------------------+----------------------+-----------------+------------------+\n" +
	              String.format("| %-20s | %-20s | %-15.2f | %-15.2f  |\n", this.getDeptCode(), this.getDeptName(), this.getRegRate(), this.getOvertimeRate()) +
	              "+----------------------+----------------------+-----------------+------------------+";
	   }
	//Acessors
	
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
	
	public void setRegRate(double regRate) {
		this.regRate = regRate;
	}
	public void setOvertimeRate(double overtimeRate) {
		this.overtimeRate = overtimeRate;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public void display() {
		System.out.println(this.toString());
	}
	
	public void display(Department obj) {
		System.out.println(obj.toString());
	}
	public String fileData()  {
		return this.getDeptCode() + "\t" + deptName + "\t" + regRate + "\t" + overtimeRate + "\n";
	}
	
	@Override
	public void store() {
		FileWriter outFileStream = null;
		
		try {
			outFileStream = new FileWriter(new File("DepartmentRates.txt"),true);
			String objData = fileData();
			outFileStream.write(objData);
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				outFileStream.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
