package domain;

public class DOB {
	private int day;
	private int month;
	private int year;
	
	//Default Constructor
	public DOB() {
		this.day = 0;
		this.month = 0;
		this.year = 0;
	}
	//Primary Constructor
	public DOB(int day, int  month, int year) {
		this.day = day;
		this.month = month;
		this.year = year ;
	}
	//Copy Constructor
	public DOB(DOB obj) {
		this.day = obj.day;
		this.month = obj.month;
		this.year = obj.year ;
	}
	
	@Override
	public String toString() {
		return "day: " + day + "\n month: " + month + "\n year:" + year;
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
