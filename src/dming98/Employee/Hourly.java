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
		System.out.print("Hourly: The " + this.getTitle() + " " + this.getFirstName() + " " + this.getLastName() + ", ID: " + this.getID() + ", earns a wage of " + this.getHourlyRate() +  " for " + this.getHoursWorked() + " hours this week");
		if(this.getOvertime()==true)
			System.out.println(" and recieves overtime.");
		else
			System.out.println(".");
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

