package domain;
/*
//------------------------------------------------------------------------------------------------------------------------------------------------------------------
NOTES:
Date: 10/15/2023
Author: Tahjaye Edwards
//------------------------------------------------------------------------------------------------------------------------------------------------------------------
This file pertains to the source code segment: 
	i. Implementation of Inheritance in the program  
	ii. Implementation of Polymorphism in the program  
	iii. Implementation of Method Overriding and Overloading in the program

The Employee class encapsulates the core features and functionalities essential for managing individual employees within the system. 

//------------------------------------------------------------------------------------------------------------------------------------------------------------------

*/

public abstract class Entity {//this serves as the parent class for the other main entities 
	private int deptCode;
	
	public Entity() {
		this.deptCode = 0;
	}
	public Entity(int deptCode) {
		this.deptCode = deptCode;
	}

	public int getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(int deptCode) {
		this.deptCode = deptCode;
	}
	
	public abstract String fileData();
	public abstract void display();
	public abstract void store();
	public abstract String toString(int i);
}
