 package domain;

//-------------------------------------------------------------------------------
//Importing of necessary library files used throughout the file
//-------------------------------------------------------------------------------
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Driver {
	static Menu menu = new Menu();//create an instance of the Main Menu class
	static Scanner input = new Scanner(System.in);//Using a global scanner object to help curve NoSuchElementException which arises when multiple scanner objects are instantiated with the System.in input stream
	
	public static void main(String[] args) {

		//-------------------------------------------------------------------------------
		//Error handling/Exception is performed for the main menu/ start screen menu 
		//-------------------------------------------------------------------------------
        try {
			int menuChoice = -1;
			boolean validInput =false;
			while (!validInput) {
			    try {
			    	 while (true){
			    		 while (true) {
			    			 menu.MainMenu();
			    		 
				    		 if (input.hasNextInt()) {
				    			 menuChoice = input.nextInt();
							     break;
							 } else {
							     System.err.println("Invalid input. Please enter an Integer.");
							     input.next(); // Consume the invalid input
							 }
			    		 }     
			             if (menuChoice>=0 && menuChoice<4) {
			             	break;
			             }else {
			             	System.err.println("Invalid Choice Try again..:(");
			             	menu.pause();
			             	menu.clrScr(8);
			             	System.out.flush();
			             }
			    	 }
			    	 validInput = true; // If no exception is thrown, the input is valid
			        
			    } catch (InputMismatchException e) {
			        System.err.println("Invalid input. Please enter an integer.");
			        input.next(); // Clear the invalid input from the scanner
			    }
			}
			input.nextLine(); // Clear the input from the scanner
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			//-------------------------------------------------------------------------------
			// Call methods based on user input
			//-------------------------------------------------------------------------------
			switch(menuChoice) {
			case 1:
				departmentOption();
   
				break;
			case 2:
				employeeOption();
				
				break;
			case 3:
				payrollOption();
				
				break;
			case 0:
				System.out.println("Program Exited...");
				// Terminate the program
			    System.exit(0);
				
				break;
			default:
				System.err.println("Something went Wrong:(");

			}
        }finally {
        	
        }
        
	}
	
	
	
	public static void departmentOption() {
		
			int dptChoice = 1;
			boolean validInput =false;
			while (!validInput) {
			    try {
			    	 while (true){
			    		 menu.displayDepartmentRatesMenu();
			    		 
			    		 while (true) {
				    		 if (input.hasNextInt()) {
				    			 
				    			 dptChoice = input.nextInt();
							     break;
							 } else {
							     System.err.println("Invalid input. Please enter an Integer.");
							     input.next(); // Consume the invalid input
							 }
			    		 }
			    		 
			             if (dptChoice>=0 && dptChoice<5) {
			             	break;
			             }else {
			             	System.err.println("Invalid Choice Try again..:(Department");
			             	menu.pause();
			             	menu.clrScr(8);
			             	System.out.flush();
			             }
			    	 }
			    	 validInput = true; // If no exception is thrown, the input is valid
			        
			    } catch (InputMismatchException e) {
			        System.err.println("Invalid input. Please enter an integer.");
			        input.next(); // Clear the invalid input from the scanner
			    }
			}
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			//-------------------------------------------------------------------------------
			// Call methods based on user input
			//-------------------------------------------------------------------------------
			switch(dptChoice) {
			case 1:
				addDeparment();
   
				break;
			case 2:
				updateDeparment();
				
				break;
			case 3:
				veiwDeparment();
				
				break;
			case 4:
				veiwAllDeparment();
				
				break;
			case 0:
				System.out.println("Returning to Main Menu");
				menu.pause();
				main(null);//returns to main
				
				break;
			default:
				System.err.println("Something went Wrong:(");

			}

		
	}
	
	public static void addDeparment() {
		 int deptCode;
		 String deptName;
		 double regRate;
		 double overtimeRate;
		

		 System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			// Validate and set department code
		 	while(true) {
				while (true) {
				    System.out.print("Enter department code: ");
				    if (input.hasNextInt()) {
				        deptCode = input.nextInt();
				        break;
				    } else {
				        System.err.println("Invalid input. Please enter an integer for department code.");
				        input.next(); // Consume the invalid input
				    }
				}
				try(Scanner sInFile = new Scanner(new File("DepartmentRates.txt"))){
					int deptCodeInFile;
					String deptNameInFile;
					double regRateInFile, overtimeRateInFile;
					boolean found = false;
					while(sInFile.hasNext()){
						deptCodeInFile = sInFile.nextInt();
						deptNameInFile = sInFile.next();
						regRateInFile = sInFile.nextDouble();
						overtimeRateInFile = sInFile.nextDouble();
						
						if(deptCodeInFile == deptCode){
							found = true;
							//System.out.println("-------------------------------------------------------------------------------");
							System.err.println("Department already Exists\n");
							System.out.println("+----------------------+----------------------+-----------------+------------------+\n" +
						              "| Department Code      | Department Name      | Regular Rate    | Overtime Rate    |\n" +
						              "+----------------------+----------------------+-----------------+------------------+\n" 
									+String.format("| %-20s | %-20s | %-15.2f | %-15.2f  |\n", deptCodeInFile, deptNameInFile, regRateInFile, overtimeRateInFile) +
						              "+----------------------+----------------------+-----------------+------------------+" );
							//System.out.println("-------------------------------------------------------------------------------");
							break;
						}
					}
					if (!found) {
						break;
					}
					sInFile.close();
				} catch (FileNotFoundException e) {
					System.err.println("File not Found...Returning to Department Menu");
					menu.pause();
					departmentOption();
				}
		 	}

		 	System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			// Validate and set department name
			input.nextLine(); // Consume newline character
			while (true) {
			    System.out.print("Enter department name: ");
			    deptName = input.nextLine();
			    if (!deptName.isEmpty()) {
			        break;
			    } else {
			        System.err.println("Invalid input. Department name cannot be empty.");
			    }
			}
			if (deptName.contains(" ")) {
				deptName = deptName.replace(" ", "-"); // Replace space with (-)
			}
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			// Validate and set regular rate
			while (true) {
			    System.out.print("Enter regular rate: ");
			    if (input.hasNextDouble()) {
			        regRate = input.nextDouble();
			        break;
			    } else {
			        System.err.println("Invalid input. Please enter a valid double for regular rate.");
			        input.next(); // Consume the invalid input
			    }
			}
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			// Validate and set overtime rate
			while (true) {
			    System.out.print("Enter overtime rate: ");
			    if (input.hasNextDouble()) {
			        overtimeRate = input.nextDouble();
			        input.nextLine(); // Consume the invalid input

			        break;
			    } else {
			        System.err.println("Invalid input. Please enter a valid double for overtime rate.");
			        input.next(); // Consume the invalid input
			    }
			}

        Entity dept = new Department(deptCode, deptName, regRate, overtimeRate);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nDepartment Created Succesfully\n");
        System.out.println("+----------------------+----------------------+-----------------+------------------+\n" +
	              "| Department Code      | Department Name      | Regular Rate    | Overtime Rate    |\n" +dept.toString(7));
		dept.store();
		System.out.println("Returning to Main Menu");
		menu.pause();
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		departmentOption();
		//main(null);//returns to main
		
	}
	public static void updateDeparment() {
		int searchId;
			// Validate and set department code
			while (true) {
				System.out.print("Enter department code you wish to UPDATE: ");
				if (input.hasNextInt()) {
					searchId = input.nextInt();
				    break;
				} else {
				    System.err.println("Invalid input. Please enter an integer for department code.");
				    input.next(); // Consume the invalid input
				}
			}
		
		try(Scanner sInFile = new Scanner(new File("DepartmentRates.txt"))){
			int deptCode;
			String deptName;
			double regRate, overtimeRate;
			boolean found = false;
			int count= 0;
			ArrayList<Entity> updatedDepartments = new ArrayList<Entity>();
			while(sInFile.hasNext()){
				deptCode = sInFile.nextInt();
				deptName = sInFile.next();
				regRate = sInFile.nextDouble();
				overtimeRate = sInFile.nextDouble();
				
				Department dept1 = new Department(deptCode, deptName, regRate, overtimeRate);
				
				if(dept1.getDeptCode() == searchId){
					found = true;
					System.out.println("+----------------------+----------------------+-----------------+------------------+\n" +
				              "| Department Code      | Department Name      | Regular Rate    | Overtime Rate    |\n" +dept1.toString(7)); 
					
					// Validate and set department name
					input.nextLine(); // Consume newline character
					while (true) {
					    System.out.print("Enter UPDATED department name: ");
					    deptName = input.nextLine();
					    dept1.setDeptName(deptName);
					    
					    if (!deptName.isEmpty()) {
					        break;
					    } else {
					        System.err.println("Invalid input. Department name cannot be empty.");
					    }
					}
					if (deptName.contains(" ")) {
						deptName = deptName.replace(" ", "-"); // Replace space with  (-)
					}
					// Validate and set regular rate
					while (true) {
					    System.out.print("Enter UPDATED regular rate: ");
					    if (input.hasNextDouble()) {
					        regRate = input.nextDouble();
					        dept1.setRegRate(regRate);
					        break;
					    } else {
					        System.err.println("Invalid input. Please enter a valid double for regular rate.");
					        input.next(); // Consume the invalid input
					    }
					}

					// Validate and set overtime rate
					while (true) {
					    System.out.print("Enter UPDATED overtime rate: ");
					    if (input.hasNextDouble()) {
					        overtimeRate = input.nextDouble();
					        dept1.setOvertimeRate(overtimeRate);
					        input.nextLine(); // Consume the invalid input

					        break;
					    } else {
					        System.err.println("Invalid input. Please enter a valid double for overtime rate.");
					        input.next(); // Consume the invalid input
					    }
					}
				}
				//System.out.println("+----------------------+----------------------+-----------------+------------------+\n" +
			             // "| Department Code      | Department Name      | Regular Rate    | Overtime Rate    |\n" +dept1.toString(7));
				updatedDepartments.add(dept1);
				count++;
			}
			if (!found) {
				System.err.println("Department not found\n");
			}else {
				
				FileWriter outFileStream = null;
				try {
					outFileStream = new FileWriter(new File("DepartmentRates.txt"),false);
					outFileStream.close();
				} catch (IOException e){
					e.printStackTrace();
				}
				
				System.out.println("+----------------------+----------------------+-----------------+------------------+\n" +
			              "| Department Code      | Department Name      | Regular Rate    | Overtime Rate    |\n" +
			              "+----------------------+----------------------+-----------------+------------------+" );
				for (int i = 0; i < count; i++) {
					System.out.println(updatedDepartments.get(i).toString(7));
					updatedDepartments.get(i).store();
				}
			}
			
			sInFile.close();
			
		} catch (FileNotFoundException e) {
			System.err.println("File not Found...Returning to Department Menu");
			menu.pause();
			departmentOption();
		}	
		menu.pause();
		departmentOption();
		
	}
	public static void veiwDeparment() {
		int searchId;
			// Validate and set department code
			while (true) {
				System.out.print("Enter department code you wish to VIEW: ");
				if (input.hasNextInt()) {
					searchId = input.nextInt();
				    break;
				} else {
				    System.out.println("Invalid input. Please enter an integer for department code.");
				    input.next(); // Consume the invalid input
				}
			}
		
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
			
			Entity dept1 = new Department(deptCode, deptName, regRate, overtimeRate);
			if(dept1.getDeptCode() == searchId){
				found = true;
				System.out.println("+----------------------+----------------------+-----------------+------------------+\n" +
			              "| Department Code      | Department Name      | Regular Rate    | Overtime Rate    |\n" +dept1.toString(7) );
				break;
			}
		}
		if (!found) {
			System.err.println("Department not found\n");
		}
		sInFile.close();
		
		} catch (FileNotFoundException e) {
			System.err.println("File not Found...Returning to Department Menu");
			
		}finally {
			menu.pause();
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			departmentOption();
		}
	}
	public static void veiwAllDeparment() {
		try(Scanner sInFile = new Scanner(new File("DepartmentRates.txt"))){
			int deptCode;
			String deptName;
			double regRate, overtimeRate;
			System.out.println("+----------------------+----------------------+-----------------+------------------+\n" +
			              "| Department Code      | Department Name      | Regular Rate    | Overtime Rate    |\n" +
			              "+----------------------+----------------------+-----------------+------------------+" );
			while(sInFile.hasNext()){
				deptCode = sInFile.nextInt();
				deptName = sInFile.next();
				regRate = sInFile.nextDouble();
				overtimeRate = sInFile.nextDouble();

				System.out.println(String.format("| %-20s | %-20s | %-15.2f | %-15.2f  |\n", deptCode, deptName, regRate, overtimeRate) +
			              "+----------------------+----------------------+-----------------+------------------+" );
			}
			
			sInFile.close();
			
			} catch (FileNotFoundException e) {
				System.err.println("File not Found...Returning to Department Menu");
				
			}finally {
				menu.pause();
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				departmentOption();
			}
	}
	
	
	
	public static void employeeOption() {
		

		int empChoice=-1;
		boolean validInput =false;
		while (!validInput) {
		    try {
		    	 while (true){
		    		 menu.displayEmployeeDataMenu();
		    		 empChoice = input.nextInt();
		    		 input.nextLine();
		    		 
		             if (empChoice>=0 && empChoice<6) {
		             	break;
		             }else {
		             	System.err.println("Invalid Choice Try again..:(Employee");
		             	menu.pause();
		             	menu.clrScr(8);
		             	System.out.flush();
		             }
		    	 }
		    	 validInput = true; // If no exception is thrown, the input is valid
		        
		    } catch (InputMismatchException e) {
		        System.err.println("Invalid input. Please enter an integer.");
		        input.next(); // Clear the invalid input from the scanner
		    }
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		//-------------------------------------------------------------------------------
		// Call methods based on user input
		//-------------------------------------------------------------------------------
		switch(empChoice) {
		case 1:
			
			addEmployee();

			break;
		case 2:
			
			updateEmployee();
			
			break;
		case 3:
			
			veiwEmployee();
			
			break;
		case 4:
			veiwAllEmployee();
			
			break;
		case 5:
			deleteEmployee();
			
			break;
		case 0:
			System.out.println("Returning to Main Menu");
			menu.pause();
			main(null);//returns to main
			
			break;
		default:
			System.err.println("Something went Wrong:(");

		}

	
	}
	
	public static void addEmployee() {
		int empID, taxRegistrationNumber, nisNumber, deptCode, birthDay, birthMonth, birthYear, hireDay, hireMonth, hireYear;
        String firstName, lastName, position;
        double hoursWorked;
        String[] months= {"January","Feburary", "March","April","May", "June","July","August", "September","October","November", "December"};
        // Validate and get empID
        while (true) {
	        System.out.print("Enter employee ID: ");
	        while (!input.hasNextInt()) {
	            System.err.println("Invalid input. Please enter a valid integer for employee ID.");
	            System.out.println("Enter employee ID: ");
	            input.next(); // Consume the invalid input
	        }
	        empID = input.nextInt();
	        
	        try(Scanner sInFile = new Scanner(new File("EmployeePayroll.txt"))){
	    		
				int empIDInFile, deptCodeInFile, taxRegistrationNumberInFile, nisNumberInFile;
				String firstNameInFile, lastNameInFile, positionInFile;
				double hoursWorkedInFile;
				int birthMonthInFile, birthDayInFile, birthYearInFile, hireMonthInFile, hireDayInFile, hireYearInFile;
			
				boolean found = false;
				while(sInFile.hasNext()){
					
					empIDInFile = sInFile.nextInt();
					taxRegistrationNumberInFile = sInFile.nextInt();
					nisNumberInFile = sInFile.nextInt();
					firstNameInFile = sInFile.next();
					lastNameInFile = sInFile.next();
					deptCodeInFile = sInFile.nextInt();
					positionInFile = sInFile.next();
					hoursWorkedInFile = sInFile.nextDouble();
					birthDayInFile = sInFile.nextInt();
					birthMonthInFile = sInFile.nextInt();
					birthYearInFile = sInFile.nextInt();
					hireDayInFile = sInFile.nextInt();
					hireMonthInFile = sInFile.nextInt();
					hireYearInFile = sInFile.nextInt();
				
					if(empIDInFile == empID){
						found = true;
						System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
						System.out.println("Empoyee ID: " + empIDInFile + "\nTRN: " + taxRegistrationNumberInFile + "\nNIS: " + nisNumberInFile 
								+ "\nFirstName: " + firstNameInFile + "\nLastName: " + lastNameInFile + "\nDepartment Code: " + deptCodeInFile + "\nPosition: " 
								+ positionInFile + "\nHours Worked: " + hoursWorkedInFile  + "\nDate Of Birth: " + birthDayInFile + "/" + birthMonthInFile + "/" + birthYearInFile 
								+ "\nDate Of Hire: " + hireDayInFile + "/" + hireMonthInFile + "/" + hireYearInFile);
						System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
						break;
					}
				}
				if (found) {
					System.err.println("Employee already Exists try again...\n");
				}else {
					break;
				}
				sInFile.close();
			
			} catch (FileNotFoundException e) {
				System.err.println("File not Found...Returning to Employee Menu");
				menu.pause();
				employeeOption();
			}
        
        }
        
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        // Validate and get taxRegistrationNumber
        System.out.print("Enter Tax Registration Number: ");
        while (!input.hasNextInt()) {
            System.err.println("Invalid input. Please enter a valid integer for TRN.");
            System.out.print("Enter Tax Registration Number: ");
            input.next(); // Consume the invalid input
        }
        taxRegistrationNumber = input.nextInt();
        
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
        // Validate and get nisNumber
        System.out.print("Enter NIS number: ");
        while (!input.hasNextInt()) {
            System.err.println("Invalid input. Please enter a valid integer for NIS number.");
            System.out.print("Enter NIS number: ");
            input.next(); // Consume the invalid input
        }
        nisNumber = input.nextInt();

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        // Validate and get firstName
        while(true) {
	        System.out.print("Enter EMPLOYEE First Name: ");
	        firstName = input.next();
	        if (!firstName.isEmpty()) {
		        break;
		    } else {
		        System.err.println("Invalid input. First Name cannot be empty.");
		    }
        }
        if (firstName.contains(" ")) {
			firstName = firstName.replace(" ", "-"); // Replace space with (-)
		}
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        // Validate and get lastName
        while(true) {
	        System.out.print("Enter EMPLOYEE Last Name: ");
	        lastName = input.next();
	        if (!lastName.isEmpty()) {
		        break;
		    } else {
		        System.err.println("Invalid input. last Name cannot be empty.");
		    }
        }
        if (lastName.contains(" ")) {
			lastName = lastName.replace(" ", "-"); // Replace space with (-)
		}
        
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        // Validate and get deptCode
        while(true) {
			while (true) {
			    System.out.print("Enter DEPARTMENT Code: ");
			    if (input.hasNextInt()) {
			        deptCode = input.nextInt();
			        break;
			    } else {
			        System.err.println("Invalid input. Please enter an integer for department code.");
			        input.next(); // Consume the invalid input
			    }
			}
			try(Scanner sInFile = new Scanner(new File("DepartmentRates.txt"))){
				int deptCodeInFile;
				String deptNameInFile;
				double regRateInFile, overtimeRateInFile;
				boolean found = false;
				while(sInFile.hasNext()){
					deptCodeInFile = sInFile.nextInt();
					deptNameInFile = sInFile.next();
					regRateInFile = sInFile.nextDouble();
					overtimeRateInFile = sInFile.nextDouble();
					
					if(deptCodeInFile == deptCode){
						found = true;
						System.out.println("+----------------------+----------------------+-----------------+------------------+\n" +
					              "| Department Code      | Department Name      | Regular Rate    | Overtime Rate    |\n" +
					              "+----------------------+----------------------+-----------------+------------------+\n" 
								+String.format("| %-20s | %-20s | %-15.2f | %-15.2f  |\n", deptCodeInFile, deptNameInFile, regRateInFile, overtimeRateInFile) +
					              "+----------------------+----------------------+-----------------+------------------+" );
						break;
					}
				}
				if (found) {
					break;
				}else {
					System.err.println("Department not found try again..");
				}
				sInFile.close();
			} catch (FileNotFoundException e) {
				System.err.println("File not Found...Returning to Employee Menu");
				menu.pause();
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				employeeOption();
			}
	 	}
      
        position = input.nextLine(); 
        
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        // Validate and get position
        while(true) {
	        System.out.print("Enter Position: ");
	        position = input.nextLine();
	        if (!position.isEmpty()) {
		        break;
		    } else {
		        System.err.println("Invalid input. Position cannot be empty.");
		    }
        }
        if (position.contains(" ")) {
			position = position.replace(" ", "-"); // Replace space with (-)
		}
        
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        // Validate and get hoursWorked
        System.out.print("Enter Hours Worked: ");
        while (!input.hasNextDouble()) {
            System.err.println("Invalid input. Please enter a valid double for Hours Worked.");
            System.out.print("Enter Hours Worked: ");
            input.next(); // Consume the invalid input
        }
        hoursWorked = input.nextDouble();
        
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        // Validate and get birthYear
        while(true) {
	        System.out.print("Enter Birth Year (1907-2006): ");
	        while (!input.hasNextInt()) {
	            System.err.println("Invalid input. Please enter a valid integer for birth year.");
	            System.out.print("Enter Birth Year: ");
	            input.next(); // Consume the invalid input
	        }
	        birthYear = input.nextInt();
	        
	        if(birthYear>= 1907 && birthYear<= 2006) {
	        	break;
	        }else {
	        	System.err.println("Invalid BIRTH YEAR try again... Enter a year between 1907-2006");
	        }
        }
        
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        // Validate and get birthMonth
        while (true) {
	        System.out.print("Enter Birth Month: ");
	        while (!input.hasNextInt()) {
	            System.err.println("Invalid input. Please enter a valid integer for birth month.");
	            System.out.print("Enter Birth Month: ");
	            input.next(); // Consume the invalid input
	        }
	        birthMonth = input.nextInt();
	        
	        if (birthMonth >= 1 && birthMonth <= 12) {
	        	break;
	        }else {
	        	System.err.println("Invalid MONTH try again... Enter a month between 1-12");
	        }
        }
        
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        // Validate and get birthDay
        while (true) {
	        System.out.print("Enter Birth Day: ");
	        while (!input.hasNextInt()) {
	            System.err.println("Invalid input. Please enter a valid integer for birth day.");
	            System.out.print("Enter Birth Day: ");
	            input.next(); // Consume the invalid input
	        }
	        birthDay = input.nextInt();
	        // validates the date to make sure they are real dates
	        if ((birthMonth == 1 || birthMonth == 3 || birthMonth == 5 || birthMonth == 7 || birthMonth == 8 || birthMonth == 10 || birthMonth == 12) && birthDay >= 1 && birthDay <= 31) {
	        	break;
	        }else if ((birthMonth == 4 || birthMonth == 6 || birthMonth == 9 || birthMonth == 11) && birthDay >= 1 && birthDay <= 30) {
	        	break;
	        }else if (birthMonth == 2 && (birthYear%4 != 0) && birthDay >= 1 && birthDay <= 28) {
	        	break;
	        }else if (birthMonth == 2 && (birthYear%4 == 0) && birthDay >= 1 && birthDay <= 29) {//Leap year 
	        	break;
	        }else {
	        	System.err.println("Invalid DAY try again... Enter a valid Day for " + months[birthMonth-1] + birthYear );
	        }
        }
        
        
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	    // Validate and get hireYear
        while (true) {
	        
	        System.out.print("Enter Hire Year (1924-2024): ");
	        while (!input.hasNextInt()) {
	            System.err.println("Invalid input. Please enter a valid integer for Hire Year.");
	            System.out.print("Enter Hire Year: ");
	            input.next(); // Consume the invalid input
	        }
	        hireYear = input.nextInt();
	        
	        if(hireYear>= 1924 && hireYear<= 2024) {
	        	break;
	        }else {
	        	System.err.println("Invalid YEAR try again... Enter a year between 1924-2024");
	        }
        }
       
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        // Validate and get hireMonth
        while (true) {
	        System.out.print("Enter Hire Month: ");
	        while (!input.hasNextInt()) {
	            System.err.println("Invalid input. Please enter a valid integer for Hire Month.");
	            System.out.print("Enter Hire Month: ");
	            input.next(); // Consume the invalid input
	        }
	        hireMonth = input.nextInt();
	        if (hireMonth >= 1 && hireMonth <= 12) {
	        	break;
	        }else {
	        	System.err.println("Invalid MONTH try again...  Enter a Month between 1-12");
	        }
        }
        
        
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        // Validate and get hireDay
        while (true) {
	        System.out.print("Enter Hire Day: ");
	        while (!input.hasNextInt()) {
	            System.err.println("Invalid input. Please enter a valid integer for Hire Day.");
	            System.out.print("Enter Hire Day: ");
	            input.next(); // Consume the invalid input
	        }
	        hireDay = input.nextInt();
	        
	     // validates the date to make sure they are real dates
	        if ((hireMonth == 1 || hireMonth == 3 || hireMonth == 5 || hireMonth == 7 || hireMonth == 8 || hireMonth == 10 || hireMonth == 12) && hireDay >= 1 && hireDay <= 31) {
	        	break;
	        }else if ((hireMonth == 4 || hireMonth == 6 || hireMonth == 9 || hireMonth == 11) && hireDay >= 1 && hireDay <= 30) {
	        	break;
	        }else if (hireMonth == 2 && (hireYear%4 != 0) && hireDay >= 1 && hireDay <= 28) {
	        	break;
	        }else if (hireMonth == 2 && (hireYear%4 == 0) && hireDay >= 1 && hireDay <= 29) {//Leap year 
	        	break;
	        }else {
	        	System.err.println("Invalid DAY try again... Enter a valid Day for " + months[hireMonth-1] + hireYear );
	        }
	        
        }
        
        Entity emp1 = new Employee(empID, firstName, lastName, deptCode, position, hoursWorked, taxRegistrationNumber, nisNumber, new Date(birthDay, birthMonth, birthYear),   new Date(hireDay, hireMonth, hireYear));
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nEmployee Created Succesfully\n");
        //System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(emp1.toString());
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		emp1.store();
		System.out.println("Returning to Main Menu");
		menu.pause();
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		employeeOption();

	}
	public static void updateEmployee() {
		int searchId;
        String[] months= {"January","Feburary", "March","April","May", "June","July","August", "September","October","November", "December"};
        // Validate and set department code
		while (true) {
			System.out.print("Enter Employee ID you wish to UPDATE: ");
			if (input.hasNextInt()) {
				searchId = input.nextInt();
			    break;
			} else {
			    System.err.println("Invalid input. Please enter an integer for Employee ID.");
			    input.next(); // Consume the invalid input
			}
		}
		
		try(Scanner sInFile = new Scanner(new File("EmployeePayroll.txt"))){
			
			int empID, deptCode, taxRegistrationNumber, nisNumber;
			String firstName, lastName, position;
			double hoursWorked;
			int birthMonth, birthDay, birthYear, hireMonth, hireDay, hireYear;
		
			boolean found = false;
			int count= 0;
			ArrayList<Entity> updatedEmployees = new ArrayList<Entity>();
			while(sInFile.hasNext()){
				
				empID = sInFile.nextInt();
				taxRegistrationNumber = sInFile.nextInt();
				nisNumber = sInFile.nextInt();
				firstName = sInFile.next();
				lastName = sInFile.next();
				deptCode = sInFile.nextInt();
				position = sInFile.next();
				hoursWorked = sInFile.nextDouble();
				birthDay = sInFile.nextInt();
				birthMonth = sInFile.nextInt();
				birthYear = sInFile.nextInt();
				hireDay = sInFile.nextInt();
				hireMonth = sInFile.nextInt();
				hireYear = sInFile.nextInt();
			
				Employee emp1 = new Employee(empID, firstName, lastName, deptCode, position, hoursWorked, taxRegistrationNumber, nisNumber, new Date(birthDay, birthMonth, birthYear),   new Date(hireDay, hireMonth, hireYear));
				if(emp1.getEmpID() == searchId){
					found = true;
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Empoyee ID: " + empID + "\nTRN: " + taxRegistrationNumber + "\nNIS: " + nisNumber 
							+ "\nFirstName: " + firstName + "\nLastName: " + lastName + "\nDepartment Code: " + deptCode + "\nPosition: " 
							+ position + "\nHours Worked: " + hoursWorked  + "\nDate Of Birth: " + birthDay + "/" + birthMonth + "/" + birthYear 
							+ "\nDate Of Hire: " + hireDay + "/" + hireMonth + "/" + hireYear);
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					
					
			        // Validate and get taxRegistrationNumber
			        System.out.print("Enter tax registration number: ");
			        while (!input.hasNextInt()) {
			            System.err.println("Invalid input. Please enter a valid integer for tax registration number.");
			            System.out.print("Enter tax registration number: ");
			            input.next(); // Consume the invalid input
			        }
			        taxRegistrationNumber = input.nextInt();
			        emp1.setTaxRegistrationNumber(taxRegistrationNumber);
			        
			        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			        // Validate and get nisNumber
			        System.out.print("Enter NIS number: ");
			        while (!input.hasNextInt()) {
			            System.err.println("Invalid input. Please enter a valid integer for NIS number.");
			            System.out.print("Enter NIS number: ");
			            input.next(); // Consume the invalid input
			        }
			        nisNumber = input.nextInt();
			        emp1.setNisNumber(nisNumber);
			        
			        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			        // Validate and get firstName
			        while(true) {
				        System.out.print("Enter EMPLOYEE First Name: ");
				        firstName = input.nextLine();
				        if (!firstName.isEmpty()) {
					        break;
					    } else {
					        System.err.println("Invalid input. First Name cannot be empty.");
					    }
			        }
			        if (firstName.contains(" ")) {
						firstName = firstName.replace(" ", "-"); // Replace space with (-)
					}
			        emp1.setFirstName(firstName);
			        
			        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			        // Validate and get lastName
			        while(true) {
				        System.out.print("Enter EMPLOYEE Last Name: ");
				        lastName = input.nextLine();
				        if (!lastName.isEmpty()) {
					        break;
					    } else {
					        System.err.println("Invalid input. last Name cannot be empty.");
					    }
			        }
			        if (lastName.contains(" ")) {
						lastName = lastName.replace(" ", "-"); // Replace space with (-)
					}
			        
			        emp1.setLastName(lastName);
			        
			        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			        // Validate and get deptCode
			        while(true) {
						while (true) {
						    System.out.print("Enter DEPARTMENT Code: ");
						    if (input.hasNextInt()) {
						        deptCode = input.nextInt();
						        break;
						    } else {
						        System.err.println("Invalid input. Please enter an integer for department code.");
						        input.next(); // Consume the invalid input
						    }
						}
						try(Scanner dptINFile = new Scanner(new File("DepartmentRates.txt"))){
							int deptCodeInFile;
							String deptNameInFile;
							double regRateInFile, overtimeRateInFile;
							boolean deptfound = false;
							while(dptINFile.hasNext()){
								deptCodeInFile = dptINFile.nextInt();
								deptNameInFile = dptINFile.next();
								regRateInFile = dptINFile.nextDouble();
								overtimeRateInFile = dptINFile.nextDouble();
								
								if(deptCodeInFile == deptCode){
									deptfound = true;
									System.out.println("+----------------------+----------------------+-----------------+------------------+\n" +
								              "| Department Code      | Department Name      | Regular Rate    | Overtime Rate    |\n" +
								              "+----------------------+----------------------+-----------------+------------------+\n" 
											+String.format("| %-20s | %-20s | %-15.2f | %-15.2f  |\n", deptCodeInFile, deptNameInFile, regRateInFile, overtimeRateInFile) +
								              "+----------------------+----------------------+-----------------+------------------+" );
									break;
								}
							}
							if (deptfound) {
								break;
							}else {
								System.err.println("Department not found try again..");
							}
							dptINFile.close();
						} catch (FileNotFoundException e) {
						
							System.err.println("File not Found...Returning to Employee Menu");
							menu.pause();
							System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
							employeeOption();
						}
				 	}
			        emp1.setDeptCode(deptCode);

			        position = input.nextLine(); 
			        
			        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			        // Validate and get position
			        while(true) {
				        System.out.print("Enter Position: ");
				        position = input.nextLine();
				        if (!position.isEmpty()) {
					        break;
					    } else {
					        System.err.println("Invalid input. Position cannot be empty.");
					    }
			        }
			        if (position.contains(" ")) {
						position = position.replace(" ", "-"); // Replace space with (-)
					}
			        
			        emp1.setPosition(position);
			        
			        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			        // Validate and get hoursWorked
			        System.out.print("Enter Hours Worked: ");
			        while (!input.hasNextDouble()) {
			            System.err.println("Invalid input. Please enter a valid double for Hours Worked.");
			            System.out.print("Enter Hours Worked: ");
			            input.next(); // Consume the invalid input
			        }
			        hoursWorked = input.nextDouble();

			        emp1.setHoursWorked(hoursWorked);
			        
			        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			        // Validate and get birthYear
			        while(true) {
				        System.out.print("Enter Birth Year (1907-2006): ");
				        while (!input.hasNextInt()) {
				            System.err.println("Invalid input. Please enter a valid integer for birth year.");
				            System.out.print("Enter Birth Year: ");
				            input.next(); // Consume the invalid input
				        }
				        birthYear = input.nextInt();
				        
				        if(birthYear>= 1907 && birthYear<= 2006) {
				        	break;
				        }else {
				        	System.err.println("Invalid BIRTH YEAR try again... Enter a year between 1907-2006");
				        }
			        }
			        
			        
			        
			        
			        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			        // Validate and get birthMonth
			        while (true) {
				        System.out.print("Enter Birth Month: ");
				        while (!input.hasNextInt()) {
				            System.err.println("Invalid input. Please enter a valid integer for birth month.");
				            System.out.print("Enter Birth Month: ");
				            input.next(); // Consume the invalid input
				        }
				        birthMonth = input.nextInt();
				        
				        if (birthMonth >= 1 && birthMonth <= 12) {
				        	break;
				        }else {
				        	System.err.println("Invalid MONTH try again... Enter a month between 1-12");
				        }
			        }
			        
			        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			        // Validate and get birthDay
			        while (true) {
				        System.out.print("Enter Birth Day: ");
				        while (!input.hasNextInt()) {
				            System.err.println("Invalid input. Please enter a valid integer for birth day.");
				            System.out.print("Enter Birth Day: ");
				            input.next(); // Consume the invalid input
				        }
				        birthDay = input.nextInt();
				        // validates the date to make sure they are real dates
				        if ((birthMonth == 1 || birthMonth == 3 || birthMonth == 5 || birthMonth == 7 || birthMonth == 8 || birthMonth == 10 || birthMonth == 12) && birthDay >= 1 && birthDay <= 31) {
				        	break;
				        }else if ((birthMonth == 4 || birthMonth == 6 || birthMonth == 9 || birthMonth == 11) && birthDay >= 1 && birthDay <= 30) {
				        	break;
				        }else if (birthMonth == 2 && (birthYear%4 != 0) && birthDay >= 1 && birthDay <= 28) {
				        	break;
				        }else if (birthMonth == 2 && (birthYear%4 == 0) && birthDay >= 1 && birthDay <= 29) {//Leap year 
				        	break;
				        }else {
				        	System.err.println("Invalid DAY try again... Enter a valid Day for " + months[birthMonth-1] + birthYear );
				        }
			        }
			        
			        emp1.setDateOfBirth(new Date(birthDay, birthMonth, birthYear));
			        
			        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				    // Validate and get hireYear
			        while (true) {
				        
				        System.out.print("Enter Hire Year (1924-2024): ");
				        while (!input.hasNextInt()) {
				            System.err.println("Invalid input. Please enter a valid integer for Hire Year.");
				            System.out.print("Enter Hire Year: ");
				            input.next(); // Consume the invalid input
				        }
				        hireYear = input.nextInt();
				        
				        if(hireYear>= 1924 && hireYear<= 2024) {
				        	break;
				        }else {
				        	System.err.println("Invalid YEAR try again... Enter a year between 1924-2024");
				        }
			        }
			       
			        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			        // Validate and get hireMonth
			        while (true) {
				        System.out.print("Enter Hire Month: ");
				        while (!input.hasNextInt()) {
				            System.err.println("Invalid input. Please enter a valid integer for Hire Month.");
				            System.out.print("Enter Hire Month: ");
				            input.next(); // Consume the invalid input
				        }
				        hireMonth = input.nextInt();
				        if (hireMonth >= 1 && hireMonth <= 12) {
				        	break;
				        }else {
				        	System.err.println("Invalid MONTH try again...  Enter a Month between 1-12");
				        }
			        }
			        
			        
			        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			        
			        // Validate and get hireDay
			        while (true) {
				        System.out.print("Enter Hire Day: ");
				        while (!input.hasNextInt()) {
				            System.err.println("Invalid input. Please enter a valid integer for Hire Day.");
				            System.out.print("Enter Hire Day: ");
				            input.next(); // Consume the invalid input
				        }
				        hireDay = input.nextInt();
				        
				        // validates the date to make sure they are real dates
				        if ((hireMonth == 1 || hireMonth == 3 || hireMonth == 5 || hireMonth == 7 || hireMonth == 8 || hireMonth == 10 || hireMonth == 12) && hireDay >= 1 && hireDay <= 31) {
				        	break;
				        }else if ((hireMonth == 4 || hireMonth == 6 || hireMonth == 9 || hireMonth == 11) && hireDay >= 1 && hireDay <= 30) {
				        	break;
				        }else if (hireMonth == 2 && (hireYear%4 != 0) && hireDay >= 1 && hireDay <= 28) {
				        	break;
				        }else if (hireMonth == 2 && (hireYear%4 == 0) && hireDay >= 1 && hireDay <= 29) {//Leap year 
				        	break;
				        }else {
				        	System.err.println("Invalid DAY try again... Enter a valid Day for " + months[hireMonth-1] + hireYear );
				        }
				        
			        }
			        emp1.setDateOfHire(new Date(hireDay, hireMonth, hireYear));
			        emp1.toString();
				}
				updatedEmployees.add(emp1);
				count++;
		
			}
			if (!found) {
				System.err.println("Employee not found\n");
			}else {
				
				FileWriter outFileStream = null;
				try {
					outFileStream = new FileWriter(new File("EmployeePayroll.txt"),false);
					outFileStream.close();
				} catch (IOException e){
					e.printStackTrace();
				}
				
				for (int i = 0; i < count; i++) {
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println(updatedEmployees.get(i).toString());
					updatedEmployees.get(i).store();
				}
			}
			sInFile.close();
		
		} catch (FileNotFoundException e) {
			System.err.println("File not Found...Returning to Employee Menu");
			
		}finally {
			menu.pause();
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			employeeOption();
		}
		
		
		
	}
	public static void veiwEmployee() {
		int searchId;
			while (true) {
				System.out.print("Enter Employee ID you wish to VIEW: ");
				if (input.hasNextInt()) {
					searchId = input.nextInt();
				    break;
				} else {
				    System.err.println("Invalid input. Please enter an integer for Employee ID.");
				    input.next(); // Consume the invalid input
				}
			}

		
		try(Scanner sInFile = new Scanner(new File("EmployeePayroll.txt"))){
		
			int empID, deptCode, taxRegistrationNumber, nisNumber;
			String firstName, lastName, position;
			double hoursWorked;
			int birthMonth, birthDay, birthYear, hireMonth, hireDay, hireYear;
		
			boolean found = false;
			while(sInFile.hasNext()){
				
				empID = sInFile.nextInt();
				taxRegistrationNumber = sInFile.nextInt();
				nisNumber = sInFile.nextInt();
				firstName = sInFile.next();
				lastName = sInFile.next();
				deptCode = sInFile.nextInt();
				position = sInFile.next();
				hoursWorked = sInFile.nextDouble();
				birthDay = sInFile.nextInt();
				birthMonth = sInFile.nextInt();
				birthYear = sInFile.nextInt();
				hireDay = sInFile.nextInt();
				hireMonth = sInFile.nextInt();
				hireYear = sInFile.nextInt();
			
				if(empID == searchId){
					found = true;
					System.out.println("-------------------------------------------------------------------------------");
					System.out.println("Empoyee ID: " + empID + "\nTRN: " + taxRegistrationNumber + "\nNIS: " + nisNumber 
							+ "\nFirstName: " + firstName + "\nLastName: " + lastName + "\nDepartment Code: " + deptCode + "\nPosition: " 
							+ position + "\nHours Worked: " + hoursWorked  + "\nDate Of Birth: " + birthDay + "/" + birthMonth + "/" + birthYear 
							+ "\nDate Of Hire: " + hireDay + "/" + hireMonth + "/" + hireYear);
					System.out.println("-------------------------------------------------------------------------------");
					break;
				}
			}
			if (!found) {
				System.err.println("Employee not found\n");
			}
			sInFile.close();
		
		} catch (FileNotFoundException e) {
			System.err.println("File not Found...Returning to Employee Menu");
		}finally {
			menu.pause();
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			employeeOption();
		}
	}
	public static void veiwAllEmployee() {
		try(Scanner sInFile = new Scanner(new File("EmployeePayroll.txt"))){
			
			int empID, deptCode, taxRegistrationNumber, nisNumber;
			String firstName, lastName, position;
			double hoursWorked;
			int birthMonth, birthDay, birthYear, hireMonth, hireDay, hireYear;
	
			while(sInFile.hasNext()){
				
				empID = sInFile.nextInt();
				taxRegistrationNumber = sInFile.nextInt();
				nisNumber = sInFile.nextInt();
				firstName = sInFile.next();
				lastName = sInFile.next();
				deptCode = sInFile.nextInt();
				position = sInFile.next();
				hoursWorked = sInFile.nextDouble();
				birthDay = sInFile.nextInt();
				birthMonth = sInFile.nextInt();
				birthYear = sInFile.nextInt();
				hireDay = sInFile.nextInt();
				hireMonth = sInFile.nextInt();
				hireYear = sInFile.nextInt();

				//System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("Empoyee ID: " + empID + "\nTRN: " + taxRegistrationNumber + "\nNIS: " + nisNumber 
						+ "\nFirstName: " + firstName + "\nLastName: " + lastName + "\nDepartment Code" + deptCode + "\nPosition: " 
						+ position + "\nHours Worked: " + hoursWorked  + "\nDate Of Birth: " + birthDay + "/" + birthMonth + "/" + birthYear 
						+ "\nDate Of Hire: " + hireDay + "/" + hireMonth + "/" + hireYear);
			}
	
			sInFile.close();
			
			} catch (FileNotFoundException e) {
				System.err.println("File not Found Returning....to Employee Menu");
			}finally {	
				menu.pause();
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				employeeOption();
			}
		
	}
	public static void deleteEmployee() {
		
		int searchId;

		// Validate and set department code
		while (true) {
			System.out.print("Enter Employee ID you wish to DELETE: ");
			if (input.hasNextInt()) {
				searchId = input.nextInt();
			    break;
			} else {
			    System.err.println("Invalid input. Please enter an integer for Employee ID.");
			    input.next(); // Consume the invalid input
			}
		}

	
		try(Scanner sInFile = new Scanner(new File("EmployeePayroll.txt"))){
		
			int empID, deptCode, taxRegistrationNumber, nisNumber;
			String firstName, lastName, position;
			double hoursWorked;
			int birthMonth, birthDay, birthYear, hireMonth, hireDay, hireYear;
		
			boolean found = false;
			int count= 0;
			ArrayList<Entity> updatedEmployees = new ArrayList<Entity>();
			while(sInFile.hasNext()){
				
				empID = sInFile.nextInt();
				taxRegistrationNumber = sInFile.nextInt();
				nisNumber = sInFile.nextInt();
				firstName = sInFile.next();
				lastName = sInFile.next();
				deptCode = sInFile.nextInt();
				position = sInFile.next();
				hoursWorked = sInFile.nextDouble();
				birthDay = sInFile.nextInt();
				birthMonth = sInFile.nextInt();
				birthYear = sInFile.nextInt();
				hireDay = sInFile.nextInt();
				hireMonth = sInFile.nextInt();
				hireYear = sInFile.nextInt();
				
				Employee emp1 = new Employee(empID, firstName, lastName, deptCode, position, hoursWorked, taxRegistrationNumber, nisNumber, new Date(birthDay, birthMonth, birthYear),   new Date(hireDay, hireMonth, hireYear));
				if(emp1.getEmpID() == searchId){
					found = true;
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Empoyee ID: " + empID + "\nTRN: " + taxRegistrationNumber + "\nNIS: " + nisNumber 
							+ "\nFirstName: " + firstName + "\nLastName: " + lastName + "\nDepartment Code: " + deptCode + "\nPosition: " 
							+ position + "\nHours Worked: " + hoursWorked  + "\nDate Of Birth: " + birthDay + "/" + birthMonth + "/" + birthYear 
							+ "\nDate Of Hire: " + hireDay + "/" + hireMonth + "/" + hireYear);
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				}else {
					updatedEmployees.add(emp1);
					count++;
				}
			}
			if (!found) {
				System.err.println("Employee not found\n");
			}else {
				
				FileWriter outFileStream = null;
				try {
					outFileStream = new FileWriter(new File("EmployeePayroll.txt"),false);
					outFileStream.close();
				} catch (IOException e){
					e.printStackTrace();
				}
				
				
				for (int i = 0; i < count; i++) {
					
					System.out.println(updatedEmployees.get(i).toString());
					updatedEmployees.get(i).store();
				}
			}
			sInFile.close();
		
		} catch (FileNotFoundException e) {
			System.err.println("File not Found...Returning to Employee Menu");
	
		}finally {
			menu.pause();
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			employeeOption();	
		}
		
	}
	
	
	
	public static void payrollOption() {
		
		int payrollChoice = 1;
		boolean validInput =false;
		while (!validInput) {
		    try {
		    	 while (true){
		    		 menu.displayPayrollProcessingMenu();
		    		 
		    		 while (true) {
			    		 if (input.hasNextInt()) {
			    			 
			    			 payrollChoice = input.nextInt();
						     break;
						 } else {
						     System.err.println("Invalid input. Please enter an Integer.");
						     input.next(); // Consume the invalid input
						 }
		    		 }
		    		 
		             if (payrollChoice>=0 && payrollChoice<4) {
		             	break;
		             }else {
		             	System.err.println("Invalid Payroll Choice Try again..:(");
		             	menu.pause();
		             	menu.clrScr(8);
		             	System.out.flush();
		             }
		    	 }
		    	 validInput = true; // If no exception is thrown, the input is valid
		        
		    } catch (InputMismatchException e) {
		        System.err.println("Invalid input. Please enter an integer.");
		        input.next(); // Clear the invalid input from the scanner
		    }
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		//-------------------------------------------------------------------------------
		// Call methods based on user input
		//-------------------------------------------------------------------------------
		switch(payrollChoice) {
		case 1:
			
			processPayroll();

			break;
		case 2:
			
			veiwPayroll();
			
			break;
		case 3:
			
			veiwDeparmentPayroll();
			
			break;
		case 0:
			System.out.println("Returning to Main Menu");
			menu.pause();
			main(null);//returns to main
			
			break;
		default:
			System.err.println("Something went Wrong:(");

		}
	
	}
	
	public static void processPayroll() {
		ArrayList<ProcessedPayroll> payroll = new ArrayList<ProcessedPayroll>();
		
		FileWriter outFileStream = null;
		try {
			outFileStream = new FileWriter(new File("ProcessedPayroll.txt"),false);
			outFileStream.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		try(Scanner sInFile = new Scanner(new File("EmployeePayroll.txt"))){
			
			int empID, deptCode, taxRegistrationNumber, nisNumber;
			String firstName, lastName, position;
			double hoursWorked;
			int birthMonth, birthDay, birthYear, hireMonth, hireDay, hireYear;
			int count = 0;
			while(sInFile.hasNext()){
				
				empID = sInFile.nextInt();
				taxRegistrationNumber = sInFile.nextInt();
				nisNumber = sInFile.nextInt();
				firstName = sInFile.next();
				lastName = sInFile.next();
				deptCode = sInFile.nextInt();
				position = sInFile.next();
				hoursWorked = sInFile.nextDouble();
				birthDay = sInFile.nextInt();
				birthMonth = sInFile.nextInt();
				birthYear = sInFile.nextInt();
				hireDay = sInFile.nextInt();
				hireMonth = sInFile.nextInt();
				hireYear = sInFile.nextInt();
			
				Employee emp1 = new Employee(empID, firstName, lastName, deptCode, position, hoursWorked, taxRegistrationNumber, nisNumber, new Date(birthDay, birthMonth, birthYear),   new Date(hireDay, hireMonth, hireYear));
				payroll.add(new ProcessedPayroll(emp1));
				payroll.get(count).calculatePay();
				payroll.get(count).store();
				count++;
			}
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("\nPayroll Processed...........");
			sInFile.close();
			
		} catch (FileNotFoundException e) {
			System.err.println("File not Found Returning....to Employee Menu");
		}finally {
			menu.pause();
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			payrollOption();
		}
	}
	public static void veiwPayroll() {
		int searchId;
		while (true) {
			System.out.print("Enter Employee ID you wish to VIEW: ");
			if (input.hasNextInt()) {
				searchId = input.nextInt();
			    break;
			} else {
			    System.err.println("Invalid input. Please enter an integer for Employee ID.");
			    input.next(); // Consume the invalid input
			}
		}
		
		try(Scanner sInFile = new Scanner(new File("ProcessedPayroll.txt"))){
			int deptCodeInFile, empIDInFile;
			String chequeNumberInFile, firstNameInFile, lastNameInFile, positionInFile;
			double hoursWorkedInFile, regularPayInFile, overtimePayInFile, grossPayInFile;
			boolean found = true;
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
				
				
				if(searchId == empIDInFile){
					found = true;
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Cheque Number: " + chequeNumberInFile + "\nEmployee ID: " +empIDInFile + "\nFirstName: " +firstNameInFile + "\nLastName: " + lastNameInFile + "\nDepartment Code: " + deptCodeInFile + "\nPosition: " + positionInFile + "\nHours Worked: " + hoursWorkedInFile + "\nRegular Pay: " + regularPayInFile + "\nOvertime Pay: " + overtimePayInFile + "\nGross Pay: " + grossPayInFile );
					break;
				}
			}
			if (!found) {
				System.err.println("Employee not found\n");
			}
			sInFile.close();
		
		} catch (FileNotFoundException e) {
			System.err.println("File not Found...");
			
		}finally {
			menu.pause();
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			payrollOption();
		}
	}
	public static void veiwDeparmentPayroll() {
		int searchId;
		while (true) {
			System.out.print("Enter DEPARTMENT CODE you wish to VIEW: ");
			if (input.hasNextInt()) {
				searchId = input.nextInt();
			    break;
			} else {
			    System.err.println("Invalid input. Please enter an integer for Employee ID.");
			    input.next(); // Consume the invalid input
			}
		}
		
		try(Scanner sInFile = new Scanner(new File("ProcessedPayroll.txt"))){
			int deptCodeInFile, empIDInFile;
			String chequeNumberInFile, firstNameInFile, lastNameInFile, positionInFile;
			double hoursWorkedInFile, regularPayInFile, overtimePayInFile, grossPayInFile;
			boolean found = true;
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
				
				
				if(searchId == deptCodeInFile){
					found = true;
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Cheque Number: " + chequeNumberInFile + "\nEmployee ID: " +empIDInFile + "\nFirstName: " +firstNameInFile + "\nLastName: " + lastNameInFile + "\nDepartment Code: " + deptCodeInFile + "\nPosition: " + positionInFile + "\nHours Worked: " + hoursWorkedInFile + "\nRegular Pay: " + regularPayInFile + "\nOvertime Pay: " + overtimePayInFile + "\nGross Pay: " + grossPayInFile );
					
				}
			}
			if (!found) {
				System.err.println("Employee not found\n");
			}
			sInFile.close();
		
		} catch (FileNotFoundException e) {
			System.err.println("File not Found...");
			
		}finally {
			menu.pause();
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			payrollOption();
		}
	}


}
