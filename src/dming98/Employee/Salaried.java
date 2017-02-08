package dming98.Employee;


public class Salaried extends Employee{
	private float salary;
	
	public Salaried(){
		super();
		salary = 0.0f;
	}
	
	public Salaried(int ID, String first, String last, String title, float newSalary){
		super(ID, first, last, title);
		salary = newSalary;
	}
	
	public float getSalary(){
		return salary;
	}
	
	public void calculatePay(){
		float totalPay = (salary/24);
		this.setTotalPay(totalPay);
	}
	
	public void print(){
		System.out.println("Salaried: The " + this.getTitle() + " " + this.getFirstName() + " " + this.getLastName() + ", ID: " + this.getID() + ", earns a salary of " + this.getSalary() + "." );
	}
	
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
