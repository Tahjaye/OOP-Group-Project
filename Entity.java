package domain;

public abstract class Entity {
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
