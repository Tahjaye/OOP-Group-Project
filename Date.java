package domain;

/*
//------------------------------------------------------------------------------------------------------------------------------------------------------------------
NOTES:
Date: 10/15/2023
Author: Tahjaye Edwards
//------------------------------------------------------------------------------------------------------------------------------------------------------------------
This file pertains to Questions 8 which states:
The company also records the date of birth and date the employee was hired.
Implementation of Composition in the program

//Implemented before I realized there is an built in Date class.
//------------------------------------------------------------------------------------------------------------------------------------------------------------------

*/

public class Date {
	private int day;
	private int month;
	private int year;
	
	//Default Constructor
	public Date() {
		this.day = 0;
		this.month = 0;
		this.year = 0;
	}
	//Primary Constructor
	public Date(int day, int  month, int year) {
		this.day = day;
		this.month = month;
		this.year = year ;
	}
	//Copy Constructor
	public Date(Date obj) {
		this.day = obj.day;
		this.month = obj.month;
		this.year = obj.year ;
	}
	
	@Override
	public String toString() {
		return day + "/" + month + "/" + year;
	}
	//Acessors
	public int getYear() {
		return year;
	}
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	
	//Mutators
	public void setYear(int year) {
		this.year = year;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setDay(int day) {
		this.day = day;
	}

}
