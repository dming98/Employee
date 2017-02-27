package dming98.Employee;


public class Hourly extends Employee {
	private float hoursWorked;
	private float hourlyRate;
	private boolean overtime;
	
	public Hourly(){
		super();
		hoursWorked = 0.0f;
		hourlyRate = 0.0f;
		overtime = false;
	}
	
	public Hourly(int ID, String first, String last, String title, float newHourlyRate, boolean checkOvertime){
		super(ID, first, last, title);
		hourlyRate = newHourlyRate;
		overtime = checkOvertime;
	}
	
	public float getHoursWorked(){
		return hoursWorked;
	}
	
	public float getHourlyRate(){
		return hourlyRate;
	}
	
	public boolean getOvertime(){
		return overtime;
	}
	
	public void setHoursWorked(float newHours){
		hoursWorked = newHours;
	}
	
	public void calculatePay(){
		float totalPay;
		
		if(overtime == true)
			totalPay = (float) ((hourlyRate * 80) + (1.5 * hourlyRate * (hoursWorked - 80)));
		else
			totalPay = (hourlyRate * hoursWorked);
			
		this.setTotalPay(totalPay);
	}
	
	public void print(){
		String overTime = "No";
		if(this.getOvertime()){
			overTime = "Yes";
		}
		
		System.out.printf("Hourly\t\t%-10s\t%-15s\t\t%4d\t$%.2f\t%.2f\t%s\t$%.2f\n",
				this.getTitle(), this.getFirstName() + " " + this.getLastName(), this.getID() , hourlyRate, hoursWorked, overTime, this.getTotalPay());
	}
	
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

