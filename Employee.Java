package domain;

public class Employee {
	private int empID;
	private String firstName;
	private String lastName;
	private Department department;
	private String position;
	private double hoursWorked;
	private int taxRegistrationNumber;
	private int nisNumber;
	private DOB dateOfBirth;
	private DOB dateOfHire;
	
	
	//Default Constructor
	public Employee() {
		this.empID = 0;
		this.firstName = " ";
		this.lastName = " ";
		this.department = null;
		this.position = " ";
		this.hoursWorked = 0.0;
		this.taxRegistrationNumber = 0;
		this.nisNumber = 0;
		this.dateOfBirth = null;
		this.dateOfHire = null;
	}
	
	//Primary Constructor
	public Employee(int empID, String firstName, String lastName, Department department, String position, double hoursWorked,
			int taxRegistrationNumber, int nisNumber, DOB dateOfBirth, DOB dateOfHire) {

		this.empID = empID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.position = position;
		this.hoursWorked = hoursWorked;
		this.taxRegistrationNumber = taxRegistrationNumber;
		this.nisNumber = nisNumber;
		this.dateOfBirth = dateOfBirth;
		this.dateOfHire = dateOfHire;
	}
	
	//Copy Constructor
	public Employee(Employee obj) {
		this.empID = obj.empID;
		this.firstName = obj.firstName;
		this.lastName = obj.lastName;
		this.department = obj.department;
		this.position = obj.position;
		this.hoursWorked = obj.hoursWorked;
		this.taxRegistrationNumber = obj.taxRegistrationNumber;
		this.nisNumber = obj.nisNumber;
		this.dateOfBirth = obj.dateOfBirth;
		this.dateOfHire = obj.dateOfHire;
	}
	@Override
	public String toString() {
		return "empID: " + empID + "\ntaxRegistrationNumber: " + taxRegistrationNumber + "\nnisNumber: " + nisNumber 
				+ "\nfirstName: " + firstName + "\nlastName: " + lastName + department.toString() + "\nposition: " 
				+ position + "\nhoursWorked: " + hoursWorked  + "\ndateOfBirth: " + dateOfBirth.toString() 
				+ "\ndateOfHire: " + dateOfHire.toString();
	}
	
	
	//Acessors
	public int getEmpID() {
		return empID;
	}
	public String getLastName() {
		return lastName;
	}
	public Department getDepartment() {
		return department;
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
	public DOB getDateOfBirth() {
		return dateOfBirth;
	}
	public DOB getDateOfHire() {
		return dateOfHire;
	}
	
	
	
	
	//Mutators
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setDepartment(Department department) {
		this.department = department;
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
	public void setDateOfBirth(DOB dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setDateOfHire(DOB dateOfHire) {
		this.dateOfHire = dateOfHire;
	}

	


}
