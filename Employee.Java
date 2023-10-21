package domain;

public class Employee {
	private int empID;
	private String firstName;
	private String lastName;
	private int deptCode;
	private String position;
	private double hoursWorked;
	private int taxRegistrationNumber;
	private int nisNumber;
	private DOB dateOfBirth;
	private DOB dateOfHire;
	
	
	//Primary Constructor
	public Employee() {
		this.empID = 0;
		this.firstName = " ";
		this.lastName = " ";
		this.deptCode = 0;
		this.position = " ";
		this.hoursWorked = 0.0;
		this.taxRegistrationNumber = 0;
		this.nisNumber = 0;
		this.dateOfBirth = null;
		this.dateOfHire = null;
	}
	
	//Primary Constructor
	public Employee(int empID, String firstName, String lastName, int deptCode, String position, double hoursWorked,
			int taxRegistrationNumber, int nisNumber, DOB dateOfBirth, DOB dateOfHire) {

		this.empID = empID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.deptCode = deptCode;
		this.position = position;
		this.hoursWorked = hoursWorked;
		this.taxRegistrationNumber = taxRegistrationNumber;
		this.nisNumber = nisNumber;
		this.dateOfBirth = dateOfBirth;
		this.dateOfHire = dateOfHire;
	}
	//Primary Constructor
	public Employee(Employee obj) {
		this.empID = obj.empID;
		this.firstName = obj.firstName;
		this.lastName = obj.lastName;
		this.deptCode = obj.deptCode;
		this.position = obj.position;
		this.hoursWorked = obj.hoursWorked;
		this.taxRegistrationNumber = obj.taxRegistrationNumber;
		this.nisNumber = obj.nisNumber;
		this.dateOfBirth = obj.dateOfBirth;
		this.dateOfHire = obj.dateOfHire;
	}
	@Override
	public String toString() {
		return "empID: " + empID + "\nfirstName: " + firstName + "\nlastName: " + lastName + "\ndeptCode: "
				+ deptCode + "\nposition: " + position + "\nhoursWorked: " + hoursWorked + "\ntaxRegistrationNumber: "
				+ taxRegistrationNumber + "\nnisNumber: " + nisNumber + "\ndateOfBirth: " + dateOfBirth + "\ndateOfHire: "
				+ dateOfHire ;
	}
	
	
	//Acessors
	public int getEmpID() {
		return empID;
	}
	public String getLastName() {
		return lastName;
	}
	public int getDeptCode() {
		return deptCode;
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
	public void setDeptCode(int deptCode) {
		this.deptCode = deptCode;
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
