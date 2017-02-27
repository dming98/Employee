package dming98.Employee;


public class Hourly extends Employee {
	private float hoursWorked;
	private float hourlyRate;
	private boolean overtime;
	
	/**
	 * Default constructor for an hourly employee.
	 */
	public Hourly(){
		super();
		hoursWorked = 0.0f;
		hourlyRate = 0.0f;
		overtime = false;
	}
	
	/**
	 * Nondefault constructor for an hourly employee.
	 * 
	 * @param ID		ID of the employee
	 * @param first		First name of employee
	 * @param last		Last name of employee
	 * @param title		Title of employee
	 * @param newHourlyRate	Wage of employee
	 * @param checkOvertime Boolean of overtime status
	 */
	public Hourly(int ID, String first, String last, String title, float newHourlyRate, boolean checkOvertime){
		super(ID, first, last, title);
		hourlyRate = newHourlyRate;
		overtime = checkOvertime;
	}
	
	/**
	 * Gets the hours worked of an employee.
	 * 
	 * @return hoursWorked Employee's hours
	 */
	public float getHoursWorked(){
		return hoursWorked;
	}
	
	/**
	 * Gets the wage of an employee.
	 * 
	 * @return hourlyRate Employee's wage
	 */
	public float getHourlyRate(){
		return hourlyRate;
	}

	/**
	 * Gets the of status of overtime for an employee.
	 * 
	 * @return overtime	boolean of overtime
	 */
	public boolean getOvertime(){
		return overtime;
	}
	
	/**
	 * Sets the hours worked of an employee.
	 * 
	 * @param  newHours	Employee's hours
	 */
	public void setHoursWorked(float newHours){
		hoursWorked = newHours;
	}
	
	/**
	 * Calculates the total pay for this employee.
	 */
	public void calculatePay(){
		float totalPay;
		
		if(overtime == true)
			totalPay = (float) ((hourlyRate * 80) + (1.5 * hourlyRate * (hoursWorked - 80)));
		else
			totalPay = (hourlyRate * hoursWorked);
			
		this.setTotalPay(totalPay);
	}
	
	/**
	 * Prints the attributes of an employee.
	 */
	public void print(){
		String overTime = "No";
		if(this.getOvertime()){
			overTime = "Yes";
		}
		
		System.out.printf("Hourly\t\t%-10s\t%-15s\t\t%4d\t$%.2f\t%.2f\t%s\t$%.2f\n",
				this.getTitle(), this.getFirstName() + " " + this.getLastName(), this.getID() , hourlyRate, hoursWorked, overTime, this.getTotalPay());
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
		
		if(otherEmployee instanceof Hourly ){
			if(this.getID() == otherEmployee.getID())
				return yes;
		}
		return no;	
	}
}

