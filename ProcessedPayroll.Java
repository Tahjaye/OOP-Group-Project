package domain;

/*
//------------------------------------------------------------------------------------------------------------------------------------------------------------------
NOTES:
Date: 10/15/2023
Author: Tahjaye Edwards
//------------------------------------------------------------------------------------------------------------------------------------------------------------------
This file pertains to Questions 5 which states:
The user shall process the Employee Payroll via a menu with the options: 
	i. Process Payroll: Calculates payroll and generates Processed Payroll File. 
	ii. View Payroll: Allows the user to view a single employee payroll record. 
	iii. View Department Payroll: Allows the user to view all employee payroll  records for a specific department. 

The Payroll class is a comprehensive and dynamic component designed to handle the intricacies of employee compensation within the system.  

//------------------------------------------------------------------------------------------------------------------------------------------------------------------

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class ProcessedPayroll extends Employee{
	private final String chequeNumber = generateChequeNumber();//generates a random unique Cheque number
	private double regularPay;
	private double overtimePay;
	private double grossPay;
	

	
	//Default constructor
	public ProcessedPayroll() {
		super();
		this.regularPay = 0.0;
		this.overtimePay = 0.0;
		this.grossPay = 0.0;
	}
	
	//basic constructor @Overload
	public ProcessedPayroll(double regularPay, double overtimePay, double grossPay) {
		super();
		this.regularPay = regularPay;
		this.overtimePay = overtimePay;
		this.grossPay = grossPay;
	}
	
	//main constructor @Overload
	public ProcessedPayroll(Employee obj) {
		super(obj);
		this.regularPay = 0.0;
		this.overtimePay = 0.0;
		this.grossPay = 0.0;
	}
	
	//setters and getters
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
	public double getOvertimePay() {
		return overtimePay;
	}
	
	public void setOvertimePay(double overtimePay) {
		this.overtimePay = overtimePay;
	}
	
	//notice there is no setter for the Cheque Number
	public String getChequeNumber() {
		return chequeNumber;
	}

	//function used to calculate the Pay for the employee
	public void calculatePay() {
		Department dept1 = null;
		try(Scanner sInFile = new Scanner(new File("DepartmentRates.txt"))){
			int deptCode;
			String deptName;
			double regRate, overtimeRate;
			boolean found = false;
			while(sInFile.hasNext()){
				deptCode = sInFile.nextInt();
				deptName = sInFile.next();
				regRate = sInFile.nextDouble();
				overtimeRate = sInFile.nextDouble();
				
				dept1 = new Department(deptCode, deptName, regRate, overtimeRate);
				if(dept1.getDeptCode() == this.getDeptCode()){
					found = true;
					break;
				}
			}
			if (!found) {
				System.err.println("Department not found\n");
			}
			sInFile.close();
		
			} catch (FileNotFoundException e) {
				System.err.println("File not Found...");
		
			}	
		
		if (this.getHoursWorked()<40.00) {
			this.regularPay = this.getHoursWorked()* dept1.getRegRate();
			this.overtimePay = 0.0;
		}else {
			this.regularPay = 40 * dept1.getRegRate();
			this.overtimePay = (this.getHoursWorked()-40)* dept1.getOvertimeRate();
		}
		this.grossPay = this.regularPay + this.overtimePay;
		
	}
	
	@Override //creates a file writable string 
	public String fileData() {
		
		return this.chequeNumber + "\t"+ this.getEmpID()+ "\t" + this.getFirstName()+ "\t"+ this.getLastName()+ "\t"+ this.getDeptCode()+ "\t"+ this.getPosition()+ "\t"+ this.getHoursWorked()+ "\t"+ this.regularPay+ "\t"+ this.overtimePay+ "\t"+ this.grossPay+ "\n";
	}
	@Override // Displays the info in the object
	public void display() {
		System.out.println(this.toString());
	}
	
	public void display(ProcessedPayroll obj) {
		System.out.println(obj.toString());
	}
	
	@Override //Stores the object to the file 
	public void store() {
		FileWriter outFileStream = null;
		
		try {
			outFileStream = new FileWriter(new File("ProcessedPayroll.txt"),true);
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
	@Override
	public String toString() {
		return "Cheque Number: " + this.chequeNumber + "\nEmployee ID: " + this.getEmpID() + "\nFirstName: " +this.getFirstName() + "\nLastName: " + this.getLastName() +"\nDepartment Code: " + this.getDeptCode() + "\nPosition: " + this.getPosition() + "\nHours Worked: " + this.getHoursWorked() + "\nRegular Pay: $" + this.regularPay + "\nOvertime Pay: $" + this.overtimePay + "\nGross Pay: $" + this.grossPay ;
	}
	
	@Override
	public String toString(int i) {
	      return "";
	}
	
	//function to generate a random unique cheque Number
	public static String generateChequeNumber() {
		boolean found = false;
        //Set the length of the cheque number
        int length = 10; 

        //Characters allowed in the cheque number
        String characters = "0123456789";

        // Create a StringBuilder to store the generated cheque number
        StringBuilder chequeNumber = new StringBuilder();
        while (true){
	        // Get the current time 
	        long currentTimeMillis = System.currentTimeMillis();
	
	        // Seed the Random class with the current time
	        Random random = new Random(currentTimeMillis);
	
	
	        // Generate the cheque number with the specified length
	        for (int i = 0; i < length; i++) {
	            // Get a random index from the characters string
	            int randomIndex = random.nextInt(characters.length());
	
	            // Add the character at the random index to the cheque number
	            chequeNumber.append(characters.charAt(randomIndex));
	        }
	        
	        //Ensure that the number is truly unique by checking the file
	        try(Scanner sInFile = new Scanner(new File("ProcessedPayroll.txt"))){
				int deptCodeInFile, empIDInFile;
				String chequeNumberInFile, firstNameInFile, lastNameInFile, positionInFile;
				double hoursWorkedInFile, regularPayInFile, overtimePayInFile, grossPayInFile;
				
				while(sInFile.hasNext()){
					
					chequeNumberInFile = sInFile.next();
					empIDInFile = sInFile.nextInt();
					firstNameInFile = sInFile.next();
					lastNameInFile = sInFile.next();
					deptCodeInFile = sInFile.nextInt();
					positionInFile = sInFile.next();
					hoursWorkedInFile = sInFile.nextDouble();
					regularPayInFile = sInFile.nextDouble();
					overtimePayInFile = sInFile.nextDouble();
					grossPayInFile = sInFile.nextDouble();
					
					
					if(chequeNumber.toString() == chequeNumberInFile){
						found = true;
						break;
					}
				}
				
				sInFile.close();
			
			} catch (FileNotFoundException e) {
				System.err.println("File not Found...");
			
			}	
	        
	        if (!found) {
	        	break;
			}
	        
        }
        // Return the generated cheque number as a string
        return chequeNumber.toString();
    }
}
