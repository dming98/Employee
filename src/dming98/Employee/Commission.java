package dming98.Employee;


public class Commission extends Employee {
	private float salary;
	private float commissionRate;
	private float commissionSales;
	private float threshold;
	
	public Commission(){
		super();
		salary = 0.0f;
		commissionRate = 0.0f;
		threshold = 0.0f;
	}
	public Commission(int ID, String first, String last, String title, float newSalary, float newThreshold, float newRate){
		super(ID, first, last, title);
		salary = newSalary;
		threshold = newThreshold;
		commissionRate = newRate;
	}
	
	public float getSalary(){
		return salary;
	}
	
	public float getCommissionRate(){
		return commissionRate;
	}
	
	public float getCommissionSales(){
		return commissionSales;
	}
	
	public float getThreshold(){
		return threshold;
	}
	
	public void setCommissionSales(float newSales){
		commissionSales = newSales;
	}
	
	public void calculatePay(){
		float totalPay;
		if (commissionSales > threshold) 
			totalPay = (salary/ 24) + ((commissionSales - threshold) * commissionRate);
		else 
			totalPay = (salary/24);
		
		this.setTotalPay(totalPay);

	}
	
	public void print(){
		System.out.print("Commission: The " + this.getTitle() + " " + this.getFirstName() + " " + this.getLastName() + ", ID: " + this.getID() + ", earns a salary of " + this.getSalary() +  " with a commsion rate of " + this.getCommissionRate() + " and made " + this.getCommissionSales() + " sales with a threshold of " + this.getThreshold() + ".");
	}
	
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
	
