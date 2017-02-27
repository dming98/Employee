package dming98.Employee;

import javax.swing.border.TitledBorder;

public class Commission extends Employee {
	private float salary;
	private float commissionRate;
	private float commissionSales;
	private float threshold;
	
	/**
	 * Default constructor for a commissioned employee.
	 */
	public Commission(){
		super();
		salary = 0.0f;
		commissionRate = 0.0f;
		threshold = 0.0f;
	}
	
	/**
	 * Nondefault constructor for a commissioned employee.
	 * 
	 * @param ID		ID of the employee
	 * @param first		First name of employee
	 * @param last		Last name of employee
	 * @param title		Title of employee
	 * @param newSalary	Salary of the employee
	 * @param newThreshold	Threshold of the employee
	 * @param newRate	Commission rate for employee
	 */
	public Commission(int ID, String first, String last, String title, float newSalary, float newThreshold, float newRate){
		super(ID, first, last, title);
		salary = newSalary;
		threshold = newThreshold;
		commissionRate = newRate;
	}
	
	
	/**
	 * Gets the salary of an employee.
	 * 
	 * @return salary Employee's salary
	 */
	public float getSalary(){
		return salary;
	}
	
	/**
	 * Gets the commission rate of an employee.
	 * 
	 * @return commissionRate	Employee's commission rate
	 */
	public float getCommissionRate(){
		return commissionRate;
	}
	
	/**
	 * Gets the sales of an employee.
	 * 
	 * @return commissionSales	Employee's sales
	 */
	public float getCommissionSales(){
		return commissionSales;
	}
	
	/**
	 * Gets the threshold of an employee.
	 * 
	 * @return threshold Employee's threshold
	 */
	public float getThreshold(){
		return threshold;
	}
	
	/**
	 * Sets the sales of an employee.
	 * 
	 * @param  newSales	Employee's sales
	 */
	public void setCommissionSales(float newSales){
		commissionSales = newSales;
	}
	
	/**
	 * Calculates the total pay for this employee.
	 */
	public void calculatePay(){
		float totalPay;
		if (commissionSales > threshold) 
			totalPay = (salary/ 24) + ((commissionSales - threshold) * (commissionRate/100));
		else 
			totalPay = (salary/24);
		
		this.setTotalPay(totalPay);

	}
	
	/**
	 * Prints the attributes this employee.
	 */
	public void print(){
		System.out.printf("Commission\t%-10s\t%-15s\t\t%d\t$%.2f\t%.2f\t%.0f\t%.0f\t$%.2f.\n",
				this.getTitle(), this.getFirstName() + " " + this.getLastName(), this.getID() ,salary, commissionRate, commissionSales, threshold, this.getTotalPay());
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
		}
		return no;
	}
}
	
