 package domain;

//-------------------------------------------------------------------------------
//Importing of neccessary library files used throughout the file
//-------------------------------------------------------------------------------
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.util.*;


public class Driver {
	static Menu menu = new Menu();//create an instance of the Main Menu class
	static Scanner input = new Scanner(System.in);//Using a global scanner object to help curve NSuchElementException which arises when multiple scanner objects are instantiated with the system.in input stream
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
				PayrollOption();
				
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
	public static void PayrollOption() {
		menu.displayPayrollProcessingMenu();
		
		
	}
	public static void addDeparment() {
		 int deptCode;
		 String deptName;
		 double regRate;
		 double overtimeRate;
		

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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 	}

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
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("\nDepartment Created Succesfully\n");
        //System.out.println("-------------------------------------------------------------------------------");
        System.out.println("+----------------------+----------------------+-----------------+------------------+\n" +
	              "| Department Code      | Department Name      | Regular Rate    | Overtime Rate    |\n" +dept.toString(7));
        //System.out.println("-------------------------------------------------------------------------------");
		dept.store();
		System.out.println("Returning to Main Menu");
		menu.pause();
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
					//System.out.println("-------------------------------------------------------------------------------");
					System.out.println("+----------------------+----------------------+-----------------+------------------+\n" +
				              "| Department Code      | Department Name      | Regular Rate    | Overtime Rate    |\n" +dept1.toString(7)); 
					//System.out.println("-------------------------------------------------------------------------------");
					
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
			e.printStackTrace();
		}	
		menu.pause();
		departmentOption();
		
	}
	public static void veiwDeparment() {
		int searchId;
			// Validate and set department code
			while (true) {
				System.out.print("Enter department code you wish to VEIW: ");
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
				//System.out.println("-------------------------------------------------------------------------------");
				System.out.println("+----------------------+----------------------+-----------------+------------------+\n" +
			              "| Department Code      | Department Name      | Regular Rate    | Overtime Rate    |\n" +dept1.toString(7) );
				//System.out.println("-------------------------------------------------------------------------------");
				break;
			}
		}
		if (!found) {
			System.err.println("Department not found\n");
		}
		sInFile.close();
		menu.pause();
		departmentOption();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
				
				//System.out.println("-------------------------------------------------------------------------------");
				System.out.println(String.format("| %-20s | %-20s | %-15.2f | %-15.2f  |\n", deptCode, deptName, regRate, overtimeRate) +
			              "+----------------------+----------------------+-----------------+------------------+" );
				//System.out.println("-------------------------------------------------------------------------------");
			
			}
			
			sInFile.close();
			menu.pause();
			departmentOption();
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
		
	}
	public static void addEmployee() {
		int empID, taxRegistrationNumber, nisNumber, deptCode, birthDay, birthMonth, birthYear, hireDay, hireMonth, hireYear;
        String firstName, lastName, position;
        double hoursWorked;

        // Validate and get empID
        while (true) {
	        System.out.print("Enter employee ID: ");
	        while (!input.hasNextInt()) {
	            System.err.println("Invalid input. Please enter a valid integer for employee ID.");
	            System.out.print("Enter employee ID: ");
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
						System.out.println("-------------------------------------------------------------------------------");
						System.out.println("Empoyee ID: " + empIDInFile + "\nTRN: " + taxRegistrationNumberInFile + "\nNIS: " + nisNumberInFile 
								+ "\nFirstName: " + firstNameInFile + "\nLastName: " + lastNameInFile + "\nDepartment Code: " + deptCodeInFile + "\nPosition: " 
								+ positionInFile + "\nHours Worked: " + hoursWorkedInFile  + "\nDate Of Birth: " + birthDayInFile + "/" + birthMonthInFile + "/" + birthYearInFile 
								+ "\nDate Of Hire: " + hireDayInFile + "/" + hireMonthInFile + "/" + hireYearInFile);
						System.out.println("-------------------------------------------------------------------------------");
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
				e.printStackTrace();
			}
        
        }
        
        System.out.println("-------------------------------------------------------------------------------");
        // Validate and get taxRegistrationNumber
        System.out.print("Enter tax registration number: ");
        while (!input.hasNextInt()) {
            System.err.println("Invalid input. Please enter a valid integer for tax registration number.");
            System.out.print("Enter tax registration number: ");
            input.next(); // Consume the invalid input
        }
        taxRegistrationNumber = input.nextInt();
        
        System.out.println("-------------------------------------------------------------------------------");
        // Validate and get nisNumber
        System.out.print("Enter NIS number: ");
        while (!input.hasNextInt()) {
            System.err.println("Invalid input. Please enter a valid integer for NIS number.");
            System.out.print("Enter NIS number: ");
            input.next(); // Consume the invalid input
        }
        nisNumber = input.nextInt();

        System.out.println("-------------------------------------------------------------------------------");
        // Validate and get firstName
        while(true) {
	        System.out.print("Enter first name: ");
	        firstName = input.next();
	        if (!firstName.isEmpty()) {
		        break;
		    } else {
		        System.err.println("Invalid input. Department name cannot be empty.");
		    }
        }
        if (firstName.contains(" ")) {
			firstName = firstName.replace(" ", "-"); // Replace space with (-)
		}
        System.out.println("-------------------------------------------------------------------------------");
        // Validate and get lastName
        while(true) {
	        System.out.print("Enter last name: ");
	        lastName = input.next();
	        if (!lastName.isEmpty()) {
		        break;
		    } else {
		        System.err.println("Invalid input. Department name cannot be empty.");
		    }
        }
        if (lastName.contains(" ")) {
			lastName = lastName.replace(" ", "-"); // Replace space with (-)
		}
        
        System.out.println("-------------------------------------------------------------------------------");
        // Validate and get deptCode
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	}

        System.out.println("-------------------------------------------------------------------------------");
        // Validate and get position
        while(true) {
	        System.out.print("Enter position: ");
	        position = input.next();
	        if (!position.isEmpty()) {
		        break;
		    } else {
		        System.err.println("Invalid input. Department name cannot be empty.");
		    }
        }
        if (position.contains(" ")) {
			position = position.replace(" ", "-"); // Replace space with (-)
		}
        
        System.out.println("-------------------------------------------------------------------------------");
        // Validate and get hoursWorked
        System.out.print("Enter hours worked: ");
        while (!input.hasNextDouble()) {
            System.err.println("Invalid input. Please enter a valid double for hours worked.");
            System.out.print("Enter hours worked: ");
            input.next(); // Consume the invalid input
        }
        hoursWorked = input.nextDouble();

        
        
        System.out.println("-------------------------------------------------------------------------------");
        // Validate and get birthYear
        while(true) {
	        System.out.print("Enter birth year: ");
	        while (!input.hasNextInt()) {
	            System.err.println("Invalid input. Please enter a valid integer for birth year.");
	            System.out.print("Enter birth year: ");
	            input.next(); // Consume the invalid input
	        }
	        birthYear = input.nextInt();
	        
	        if(birthYear>= 1907 && birthYear<= 2006) {
	        	break;
	        }else {
	        	System.err.println("Invalid YEAR try again..birthDay.");
	        }
        }
        
        System.out.println("-------------------------------------------------------------------------------");
        // Validate and get birthMonth
        while (true) {
	        System.out.print("Enter birth month: ");
	        while (!input.hasNextInt()) {
	            System.out.println("Invalid input. Please enter a valid integer for birth month.");
	            System.out.print("Enter birth month: ");
	            input.next(); // Consume the invalid input
	        }
	        birthMonth = input.nextInt();
	        
	        if (birthMonth >= 1 && birthMonth <= 12) {
	        	break;
	        }else {
	        	System.err.println("Invalid MONTH try again..birthDay.");
	        }
        }
        
        System.out.println("-------------------------------------------------------------------------------");
        // Validate and get birthDay
        while (true) {
	        System.out.print("Enter birth day: ");
	        while (!input.hasNextInt()) {
	            System.err.println("Invalid input. Please enter a valid integer for birth day.");
	            System.out.print("Enter birth day: ");
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
	        	System.err.println("Invalid DAY try again..birthDay.");
	        }
        }
        
        
        System.out.println("-------------------------------------------------------------------------------");
	    // Validate and get hireYear
        while (true) {
	        
	        System.out.print("Enter hire year: ");
	        while (!input.hasNextInt()) {
	            System.err.println("Invalid input. Please enter a valid integer for hire year.");
	            System.out.print("Enter hire year: ");
	            input.next(); // Consume the invalid input
	        }
	        hireYear = input.nextInt();
	        
	        if(hireYear>= 1924 && hireYear<= 2024) {
	        	break;
	        }else {
	        	System.err.println("Invalid YEAR try again..birthDay.");
	        }
        }
       
        System.out.println("-------------------------------------------------------------------------------");
        // Validate and get hireMonth
        while (true) {
	        System.out.print("Enter hire month: ");
	        while (!input.hasNextInt()) {
	            System.err.println("Invalid input. Please enter a valid integer for hire month.");
	            System.out.print("Enter hire month: ");
	            input.next(); // Consume the invalid input
	        }
	        hireMonth = input.nextInt();
	        if (hireMonth >= 1 && hireMonth <= 12) {
	        	break;
	        }else {
	        	System.err.println("Invalid MONTH try again..birthDay.");
	        }
        }
        
        
        System.out.println("-------------------------------------------------------------------------------");
        // Validate and get hireDay
        while (true) {
	        System.out.print("Enter hire day: ");
	        while (!input.hasNextInt()) {
	            System.err.println("Invalid input. Please enter a valid integer for hire day.");
	            System.out.print("Enter hire day: ");
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
	        	System.err.println("Invalid DAY try again..birthDay.");
	        }
	        
        }
        
        Entity emp1 = new Employee(empID, firstName, lastName, deptCode, position, hoursWorked, taxRegistrationNumber, nisNumber, new Date(birthDay, birthMonth, birthYear),   new Date(hireDay, hireMonth, hireYear));
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("\nEmployee Created Succesfully\n");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(emp1.toString());
        System.out.println("-------------------------------------------------------------------------------");
		emp1.store();
		System.out.println("Returning to Main Menu");
		menu.pause();
		employeeOption();

	}
	public static void updateEmployee() {
		
		employeeOption();
		
	}
	public static void veiwEmployee() {
		int searchId;

			// Validate and set department code
			while (true) {
				System.out.print("Enter Employee ID you wish to VEIW: ");
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
			e.printStackTrace();
		}	
		employeeOption();
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
			

				System.out.println("-------------------------------------------------------------------------------");
				System.out.println("Empoyee ID: " + empID + "\nTRN: " + taxRegistrationNumber + "\nNIS: " + nisNumber 
						+ "\nFirstName: " + firstName + "\nLastName: " + lastName + "\nDepartment Code" + deptCode + "\nPosition: " 
						+ position + "\nHours Worked: " + hoursWorked  + "\nDate Of Birth: " + birthDay + "/" + birthMonth + "/" + birthYear 
						+ "\nDate Of Hire: " + hireDay + "/" + hireMonth + "/" + hireYear);
				System.out.println("-------------------------------------------------------------------------------");

			}
	
			sInFile.close();
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
		employeeOption();
	}
	
	public static void deleteEmployee() {
		
		employeeOption();
		
	}



}
