package dming98.Employee;


public class Salaried extends Employee{
	private float salary;
	
	/**
	 * Default constructor for a salaried employee.
	 */
	public Salaried(){
		super();
		salary = 0.0f;
	}

	/**
	 * Nondefault constructor for a salaried employee.
	 * 
	 * @param ID		ID of the employee
	 * @param first		First name of employee
	 * @param last		Last name of employee
	 * @param title		Title of employee
	 * @param newSalary	Salary of employee
	 */
	public Salaried(int ID, String first, String last, String title, float newSalary){
		super(ID, first, last, title);
		salary = newSalary;
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
	 * Calculates the total pay for this employee.
	 */
	public void calculatePay(){
		float totalPay = (salary/24);
		this.setTotalPay(totalPay);
	}
	
	/**
	 * Prints the attributes of an employee.
	 */
	public void print(){
		System.out.printf("Salaried\t%-10s\t%-18s\t%4d\t$%.2f\t$%.2f\n",
				this.getTitle(), this.getFirstName() + " " + this.getLastName(), this.getID() ,salary, this.getTotalPay());
	
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
		
		if(otherEmployee instanceof Salaried ){
			if(this.getID() == otherEmployee.getID())
				return yes;
		}
		return no;	
	}
}
