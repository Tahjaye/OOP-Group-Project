package domain;
/*
//-------------------------------------------------------------------------------
NOTES:
Date: 10/25/2023
Author: Angel Pinnock
//-------------------------------------------------------------------------------
This file pertains to Questions 3, 4, 5 and 6 which states:
  The user shall access the system via a menu. Options include:
      i. Department Rates data
      ii. maintain the Employee data
      iii. Employee Payroll.
      iv. When the exit option is selected the application should close.
//-------------------------------------------------------------------------------
Additionally, extra marks should be alloted for:
  + 5 marks – Awarded for use of extended ASCII codes and function keys (e.g., F1 –
  F12, Arrow Keys).

  + 5 marks – Awarded for use of colour and graphics to enhance the look and feel of 
  the program.
*/
//-------------------------------------------------------------------------------


public class Menu {
	// ------------------------------------------------------------------------
    // NOTE:
    // ------------------------------------------------------------------------
    // ANSI Escape Codes for Text Color and Background:
    // - Used \u001B[ followed by an escape code to specify text or background color.
    // - For example, \u001B[43m sets the background color to yellow.
    // ------------------------------------------------------------------------

    public static String DEFAULT = "\u001B[0m";                         //This creats a string called "RESET" that changes the color of text back to default color.
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";   
    public static final String YELLOW_TEXT = "\u001B[33m";
    public static final String YELLOW_BG = "\u001B[43m";                //ANSI Code to hight background yellow
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";



//-------------------------------------------------------------------------------
    public void MainMenu(){
        System.out.println("\nPlease select an option from the menu below:" + DEFAULT);
        System.out.println(YELLOW_TEXT + "\n\n1. Department Data" + DEFAULT); //This concatenates the color to the string text, then sets the color to default again
        System.out.println(GREEN + "2. Employee Data" + DEFAULT);
        System.out.println(MAGENTA + "3. Employee Payroll" + DEFAULT);
        System.out.println(RED + "0. Exit" + DEFAULT);
        
    }
//-------------------------------------------------------------------------------
    // Display the menu for department rates
    public void displayDepartmentRatesMenu() {
        System.out.println(YELLOW_TEXT + "\nDEPARTMENT RATE MENU\n" + DEFAULT);
        System.out.println("1. " + YELLOW_TEXT + "ADD:     " + DEFAULT + "\t| Add New Department Rates Record to the System");
        System.out.println("2. " + YELLOW_TEXT + "UPDATE:  " + DEFAULT + "\t| Update an Existing Department Record.");
        System.out.println("3. " + YELLOW_TEXT + "VIEW:    " + DEFAULT + "\t| View a Single Department Record.");
        System.out.println("4. " + YELLOW_TEXT + "VIEW ALL:" + DEFAULT + "\t| View ALL Department Records");
        System.out.println(RED + "0. Back to Main Menu" + DEFAULT);
    }
//-------------------------------------------------------------------------------
    //Display the menu 
    public void displayEmployeeDataMenu(){
        System.out.println(GREEN + "\nEMPLOYEE DATA MENU\n" + DEFAULT);
        System.out.println("1. " + GREEN + "ADD:     " + DEFAULT + "\t| Add a New Employee Record");
        System.out.println("2. " + GREEN + "UPDATE:  " + DEFAULT + "\t| Update an Existing Employee Record");
        System.out.println("3. " + GREEN + "VIEW:    " + DEFAULT + "\t| View a Single Employee Record");
        System.out.println("4. " + GREEN + "VIEW ALL:" + DEFAULT + "\t| View ALL Employees Records");
        System.out.println(RED + "5. DELETE    | Delete an Employee Record");
        System.out.println(RED + "0. Back to Main Menu" + DEFAULT);
    }
//-------------------------------------------------------------------------------
    public void displayPayrollProcessingMenu(){
        System.out.println(MAGENTA + "\nPAYROLL PROCESSING MENU\n" + DEFAULT);
        System.out.println("1. " + MAGENTA + "Process Payroll:        " + DEFAULT + "\t| Calculates Payroll and Generates File");
        System.out.println("2. " + MAGENTA + "View Payroll:           " + DEFAULT + "\t| View a Single Employee Payroll Record");
        System.out.println("3. " + MAGENTA + "View Department Payroll:" + DEFAULT + "\t| View ALL Employee Payroll Records for a Specific Department.");
        System.out.println(RED + "0. Back to Main Menu" + DEFAULT);
    }

//-------------------------------------------------------------------------------
    public void pause(){
    	
    	try {
			Thread.sleep(2000);//simple pauses the program; used to improve feel
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
	}
//-------------------------------------------------------------------------------
	public void clrScr(int line){
		//Clears Screen in java
		for(int i=0; i<line; i++) {
			System.out.println("");
		}
	}

}
