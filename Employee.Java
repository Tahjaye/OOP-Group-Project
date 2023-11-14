package domain;

/*
//------------------------------------------------------------------------------------------------------------------------------------------------------------------
NOTES:
Date: 10/15/2023
Author: Tahjaye Edwards
//------------------------------------------------------------------------------------------------------------------------------------------------------------------
This file pertains to Questions 4 which states:
The user should maintain the Employee data via a menu with the options: 
	i. Add: which allows the user to add a new employee record to the system. 
	ii. Update: which allows the user to update an existing employee record. 
	iii. View: which allows the user to view a single employee record. 
	iv. View All in Department: which allows the user to view all employee records  for a specified department. 
	v. Delete: which allows the user to delete an employee record. 
 
The Employee class encapsulates the core features and functionalities essential for managing individual employees within the system. 

//------------------------------------------------------------------------------------------------------------------------------------------------------------------

*/


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Employee extends Entity{
	private int empID;
	private String firstName;
	private String lastName;
	private String position;
	private double hoursWorked;
	private int taxRegistrationNumber;
	private int nisNumber;
	private Date dateOfBirth;
	private Date dateOfHire;
	
	
	//Default Constructor
	public Employee() {
		super();
		this.empID = 0;
		this.firstName = " ";
		this.lastName = " ";
		this.position = " ";
		this.hoursWorked = 0.0;
		this.taxRegistrationNumber = 0;
		this.nisNumber = 0;
		this.dateOfBirth = null;
		this.dateOfHire = null;
	}
	
	//Primary Constructor
	public Employee(int empID, String firstName, String lastName, int deptCode, String position, double hoursWorked,
			int taxRegistrationNumber, int nisNumber, Date dateOfBirth, Date dateOfHire) {
		
		super(deptCode);
		this.empID = empID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.hoursWorked = hoursWorked;
		this.taxRegistrationNumber = taxRegistrationNumber;
		this.nisNumber = nisNumber;
		this.dateOfBirth = dateOfBirth;
		this.dateOfHire = dateOfHire;
	}
	
	//Copy Constructor
	public Employee(Employee obj) {
		super(obj.getDeptCode());
		this.empID = obj.empID;
		this.firstName = obj.firstName;
		this.lastName = obj.lastName;
		this.position = obj.position;
		this.hoursWorked = obj.hoursWorked;
		this.taxRegistrationNumber = obj.taxRegistrationNumber;
		this.nisNumber = obj.nisNumber;
		this.dateOfBirth = obj.dateOfBirth;
		this.dateOfHire = obj.dateOfHire;
	}
	@Override
	public String toString() {
		return "Employee ID: " + empID + "\nTRN: " + taxRegistrationNumber + "\nNIS: " + nisNumber 
				+ "\nFirstName: " + firstName + "\nLastName: " + lastName + "\nDepartment Code: " + this.getDeptCode() + "\nPosition: " 
				+ position + "\nHours Worked: " + hoursWorked  + "\nDate Of Birth: " + dateOfBirth.toString() 
				+ "\nDate Of Hire: " + dateOfHire.toString();
	}
	public String toString(int i) {
	      return "";
	   }
	
	
	//Acessors
	public int getEmpID() {
		return empID;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public int getTaxRegistrationNumber() {
		return taxRegistrationNumber;
	}
	public double getHoursWorked() {
		return hoursWorked;
	}
	public String getPosition() {
		return position;
	}
	public int getNisNumber() {
		return nisNumber;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public Date getDateOfHire() {
		return dateOfHire;
	}
	
	
	
	
	//Mutators
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setTaxRegistrationNumber(int taxRegistrationNumber) {
		this.taxRegistrationNumber = taxRegistrationNumber;
	}
	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setNisNumber(int nisNumber) {
		this.nisNumber = nisNumber;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setDateOfHire(Date dateOfHire) {
		this.dateOfHire = dateOfHire;
	}

	public void display() {
		System.out.println(this.toString());
	}
	
	public void display(Employee obj) {
		System.out.println(obj.toString());
	}
	
	@Override
	public String fileData() {
		return  empID + "\t" + taxRegistrationNumber + "\t" + nisNumber 
				+ "\t" + firstName + "\t" + lastName + "\t" + this.getDeptCode() + "\t" 
				+ position + "\t" + hoursWorked  + "\t" + dateOfBirth.getDay()
				+ "\t" +dateOfBirth.getMonth()+ "\t"+dateOfBirth.getYear()
				+ "\t" +dateOfHire.getDay()+ "\t" +dateOfHire.getMonth()+ "\t" +dateOfHire.getYear() + "\n";
	}

	@Override
	public void store() {
		FileWriter outFileStream = null;
		
		try {
			outFileStream = new FileWriter(new File("EmployeePayroll.txt"),true);
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
