package dming98.Employee;

import javax.swing.border.TitledBorder;

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
			totalPay = (salary/ 24) + ((commissionSales - threshold) * (commissionRate/100));
		else 
			totalPay = (salary/24);
		
		this.setTotalPay(totalPay);

	}
	
	public void print(){
		System.out.printf("Commission\t%-10s\t%-15s\t\t%d\t$%.2f\t%.2f\t%.0f\t%.0f\t$%.2f.\n",
				this.getTitle(), this.getFirstName() + " " + this.getLastName(), this.getID() ,salary, commissionRate, commissionSales, threshold, this.getTotalPay());
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
	
