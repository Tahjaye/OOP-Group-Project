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
        iii. Employee Payroll
        iv. When the exit option is selected the application should close.
//-------------------------------------------------------------------------------
Additionally, extra marks should be alloted for:
    + 5 marks – Awarded for use of extended ASCII codes and function keys (e.g., F1 –
    F12, Arrow Keys).

    + 5 marks – Awarded for use of colour and graphics to enhance the look and feel of 
    the program.
 */
//-------------------------------------------------------------------------------

import java.util.Scanner;


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
        System.out.println(YELLOW_TEXT + "\n\n1. Department Rates Data" + DEFAULT); //This concatenates the color to the string text, then sets the color to default again
        System.out.println(GREEN + "2. Employee Data" + DEFAULT);
        System.out.println(BLUE + "3. Employee Payroll" + DEFAULT);
        System.out.println(RED + "4. Exit" + DEFAULT);
        
    }
//-------------------------------------------------------------------------------
    // Display the menu for department rates
    public void displayDepartmentRatesMenu() {
        
        System.out.println(YELLOW_TEXT + "\nDEPARTMENT RATE MENU\n" + DEFAULT);
        System.out.println("1. " + YELLOW_TEXT + "ADD: " + DEFAULT + "\t| add new department rates record to the system");
        System.out.println("2. " + YELLOW_TEXT + "UPDATE:" + DEFAULT + "\t| update an existing department record.");
        System.out.println("3. " + YELLOW_TEXT + "VIEW:" + DEFAULT + "\t| view a single department record.");
        System.out.println("4. " + YELLOW_TEXT + "VIEW ALL:" + DEFAULT + "\t| view all department records");
        System.out.println(RED + "5. Back to Main Menu" + DEFAULT);
    }
//-------------------------------------------------------------------------------
    //Display the menu 
    public void displayEmployeeDataMenu(){
        System.out.println(GREEN + "\nEMPLOYEE DATA MENU\n" + DEFAULT);
        System.out.println("1. " + GREEN + "ADD: " + DEFAULT + "\t| add a new employee record");
        System.out.println("2. " + GREEN + "UPDATE:" + DEFAULT + "\t| update an existing employee record");
        System.out.println("3. " + GREEN + "VIEW:" + DEFAULT + "\t| view a single employee record");
        System.out.println("4. " + GREEN + "VIEW ALL:" + DEFAULT + "\t| view all employees records");
        System.out.println(RED + "5. DELETE \t| delete an employee record");
        System.out.println(RED + "6. Back to Main Menu" + DEFAULT);
    }
//-------------------------------------------------------------------------------
    public void displayPayrollProcessingMenu(){
        System.out.println(BLUE + "\nPAYROLL PROCESSING MENU\n" + DEFAULT);
        System.out.println("1. " + BLUE + "Process Payroll: " + DEFAULT + "\t\t| calculates payroll and generates File");
        System.out.println("2. " + BLUE + "View Payroll:  " + DEFAULT + "\t\t| view a single employee payroll record");
        System.out.println("3. " + BLUE + "View Department Payroll:" + DEFAULT + "\t| view all employee payroll records for a specific department.");
        System.out.println(RED + "4. Back to Main Menu" + DEFAULT);
    }

//-------------------------------------------------------------------------------

    public static void main(String[] args){
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        //I'll continue later lol
        // test menus
        menu.displayDepartmentRatesMenu();

        scanner.close();
        
    }
}