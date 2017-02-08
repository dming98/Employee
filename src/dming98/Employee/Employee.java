package dming98.Employee;


public abstract class Employee implements Comparable<Employee>{
	private int ID;
	private String firstName;
	private String lastName;
	private String title;
	private float totalPay;
	
	public Employee(){
		ID = 0;
		firstName = "Unknown";
		lastName = "Unknown";
		title = "Unknown";
	}
	
	public Employee(int newID, String newFirst, String newLast, String newTitle){
		ID = newID;
		firstName = newFirst;
		lastName = newLast;
		title = newTitle;
	}
	
	public int getID(){
		return ID;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getTitle(){
		return title;
	}
	
	public float getTotalPay(){
		return totalPay;
	}
	
	public void setTotalPay(float newPay){
		totalPay=newPay;
	}
	
	public int compareTo(Employee otherEmployee){
		int yes = 1;
		int no = -1;
		
		if(otherEmployee instanceof Commission ){
			if(this.getID() == otherEmployee.getID())
				return yes;
		} else if(otherEmployee instanceof Salaried ){
			if(this.getID() == otherEmployee.getID())
				return yes;
		} else if(otherEmployee instanceof Hourly ){
			if(this.getID() == otherEmployee.getID())
				return yes;
		}
		return no;
	}
	
	public abstract void calculatePay();
	
	public abstract void print();
	
	
}
