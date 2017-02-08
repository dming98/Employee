package dming98.Employee;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class EmployeeDataAnalyzer {
	
	public static Employee[] employeeReader(String dataFile, int numEmployees){
		Employee[] employees = new Employee[numEmployees];
	
		
		for(int employeeCount = 0; employeeCount < numEmployees; employeeCount++){
			Scanner in = null;
			try {
				in = new Scanner(new FileReader(dataFile));
			} catch (FileNotFoundException e) {
				
			}
			String type = in.next();
			
			if (type.compareTo("C")==0){
				int ID = in.nextInt();
				String first = in.next();
				String last = in.next();
				String title = in.next();
				float salary = in.nextFloat();
				float commissionRate = in.nextFloat();
				float threshold = in.nextFloat();
				float commissionSales = in.nextFloat();
				 
				employees[employeeCount] = new Commission(ID, first, last, title, salary, commissionRate, threshold); 
				
			}else if (type.compareTo("S")==0){
				int ID = in.nextInt();
				String first = in.next();
				String last = in.next();
				String title = in.next();
				float salary = in.nextFloat();
				
				employees[employeeCount] = new Salaried(ID, first, last, title, salary);
				
			}else if (type.compareTo("H")==0){
				boolean getsOvertime;
				int ID = in.nextInt();
				String first = in.next();
				String last = in.next();
				String title = in.next();
				float hourlyRate = in.nextFloat();
				String overtime = in.next();
				if(overtime.compareTo("Y")==0)
					getsOvertime = true;
				else
					getsOvertime = false;
				float hoursWorked= in.nextFloat();
				
				employees[employeeCount] = new Hourly(ID, first, last, title, hourlyRate, getsOvertime); 
				
			}
		}
		
		
		return employees;
	}
	
	public static void sortEmployees(Employee[] employees){
		
		
	}
}

