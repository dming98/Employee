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
		String overTime = "";
		if(this.getOvertime()){
			overTime = " and receives overtime";
		}
		
		System.out.printf("Hourly: The %s %s %s, ID: %d , earns a wage of $%.2f for %.2f hours this week%s for a total of $%.2f.\n",
				this.getTitle(), this.getFirstName(), this.getLastName(), this.getID() , hourlyRate, hoursWorked, overTime, this.getTotalPay());
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

