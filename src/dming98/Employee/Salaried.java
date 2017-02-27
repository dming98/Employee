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
		System.out.printf("Salaried\t%-10s\t%-18s\t%4d\t$%.2f\t$%.2f\n",
				this.getTitle(), this.getFirstName() + " " + this.getLastName(), this.getID() ,salary, this.getTotalPay());
	
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
