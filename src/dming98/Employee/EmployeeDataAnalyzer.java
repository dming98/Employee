package dming98.Employee;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class EmployeeDataAnalyzer {
	
	public static Employee[] employeeReader(String dataFile, int numEmployees){
		Employee[] employees = new Employee[numEmployees];
		Scanner in = null;
		try {
			in = new Scanner(new FileReader(dataFile));
		} catch (FileNotFoundException e) {
			
		}
		
		for(int employeeCount = 0; employeeCount < numEmployees; employeeCount++){
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
				Commission employee = new Commission(ID, first, last, title, salary, threshold, commissionRate);
				employee.setCommissionSales(commissionSales);
				employees[employeeCount] =  employee;
				
			}else if (type.compareTo("S")==0){
				int ID = in.nextInt();
				String first = in.next();
				String last = in.next();
				String title = in.next();
				float salary = in.nextFloat();
				Salaried employee = new Salaried(ID, first, last, title, salary);
				employees[employeeCount] = employee;
				
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
				Hourly employee = new Hourly(ID, first, last, title, hourlyRate, getsOvertime);
				employee.setHoursWorked(hoursWorked);
				employees[employeeCount] = employee; 
				
			}
		}
		
		
		return employees;
	}
	
	public static void sortEmployees(Employee[] employees){
		boolean swapped;
		do{
			swapped = false;
			for(int employeeCount = 0; employeeCount < employees.length-1; employeeCount++){
				if(employees[employeeCount].getID()>employees[employeeCount+1].getID()){
					swapEmployees(employees, employeeCount, employeeCount+1);
					swapped=true;
				}
			}
		} while(swapped);
	}
	public static void swapEmployees(Employee[] employees, int pos1, int pos2){
		Employee temp = employees[pos1];
		employees[pos1] = employees[pos2];
		employees[pos2] = temp;
	}
	
	public static void calulatePay(Employee[] employees){
		for(int employeeCount = 0; employeeCount < employees.length; employeeCount++){
			employees[employeeCount].calculatePay();
		}
	}
	public static void printEmployees(Employee[] employees){
		double totalPayC=0;
		double totalPayH=0;
		double totalPayS=0;
		for(int employeeCount = 0; employeeCount < employees.length; employeeCount++){
			employees[employeeCount].print();
			if(employees[employeeCount] instanceof Commission)
				totalPayC = totalPayC + employees[employeeCount].getTotalPay();
			if(employees[employeeCount] instanceof Salaried)
				totalPayS = totalPayS + employees[employeeCount].getTotalPay();
			if(employees[employeeCount] instanceof Hourly)
				totalPayH = totalPayH + employees[employeeCount].getTotalPay();
		}
		System.out.printf("\n\nThe total pay for Commission is:\t$%.2f\n",totalPayC);
		System.out.printf("The total pay for Salaried is:\t\t$%.2f\n",totalPayS);
		System.out.printf("The total pay for Hourly is:\t\t$%.2f\n",totalPayH);
		
		System.out.printf("The total pay for all employees is:\t$%.2f\n",(totalPayC+totalPayH+totalPayS));
	}
}

