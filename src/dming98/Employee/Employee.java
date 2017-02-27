package dming98.Employee;


public abstract class Employee implements Comparable<Employee>{
	private int ID;
	private String firstName;
	private String lastName;
	private String title;
	private float totalPay;
	
	/**
	 * Default constructor for an Employee.
	 */
	public Employee(){
		ID = 0;
		firstName = "Unknown";
		lastName = "Unknown";
		title = "Unknown";
	}
	
	/**
	 * Nondefault constructor for an Employee.
	 * 
	 * @param newID		ID of the employee
	 * @param newFirst	First name of employee
	 * @param newLast	Last name of employee
	 * @param newTitle	Title of employee
	 */
	public Employee(int newID, String newFirst, String newLast, String newTitle){
		ID = newID;
		firstName = newFirst;
		lastName = newLast;
		title = newTitle;
	}
	
	
	/**
	 * Gets the ID number of an employee.
	 * 
	 * @return ID	Employees identification #
	 */
	public int getID(){
		return ID;
	}
	
	/**
	 * Gets the first name of an employee.
	 * 
	 * @return firstName	First name of employee
	 */
	public String getFirstName(){
		return firstName;
	}
	
	/**
	 * Gets the last name of an employee.
	 * 
	 * @return lastName	Last name of employee
	 */
	public String getLastName(){
		return lastName;
	}
	
	/**
	 * Gets the title of an employee.
	 * 
	 * @return title	Employee's job title
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * Gets the total pay of an employee.
	 * 
	 * @return totalPay	Employee's total pay
	 */
	public float getTotalPay(){
		return totalPay;
	}
	
	/**
	 * Sets the total pay of an employee.
	 * 
	 * @param newPay	Employee's new total pay
	 */
	public void setTotalPay(float newPay){
		totalPay=newPay;
	}
	
	/**
	 * Compares the current employee to another employee
	 * 
	 * @param otherEmployee	Employee to be compared to
	 * @return 1 if true	-1 if false
	 */
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
	
	/**
	 * Calculates pay of an employee.
	 */
	public abstract void calculatePay();
	
	/**
	 * Prints the attributes of an employee.
	 */
	public abstract void print();
	
	
}
