package dming98.Employee;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class EmployeeDataAnalyzer {
	static double totalPayC=0;
	static double totalPayH=0;
	static double totalPayS=0;
	
	/**
	 * Reads in data and creates and instance of the employee type for each item read.
	 * 
	 * @param dataFile	File containing employee data
	 * @param numEmployees Number of employees contained in the file
	 */
	public static Employee[] employeeReader(String dataFile, int numEmployees) throws FileNotFoundException{
		Employee[] employees = new Employee[numEmployees];
		Scanner in = null;
		try {
			in = new Scanner(new FileReader(dataFile));
		} catch (FileNotFoundException e) {
			throw e;
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
	
	/**
	 * Bubble sorts the Employees by ID number.
	 * 
	 * @param employees Employee array of our employees
	 */
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
	
	/**
	 * Swaps employees at two positions.
	 * 
	 * @param employees Employee array of our employees
	 * @param pos1		position of first employee
	 * @param pos2		position of second employee
	 */
	public static void swapEmployees(Employee[] employees, int pos1, int pos2){
		Employee temp = employees[pos1];
		employees[pos1] = employees[pos2];
		employees[pos2] = temp;
	}
	
	/**
	 * Calculates and sums the total pay for the types of employees.
	 * 
	 * @param employees	Employee array of our employees
	 */
	public static void calulatePay(Employee[] employees){
		for(int employeeCount = 0; employeeCount < employees.length; employeeCount++){
			employees[employeeCount].calculatePay();
		}
		for(int employeeCount = 0; employeeCount < employees.length; employeeCount++){
			if(employees[employeeCount] instanceof Commission)
				totalPayC = totalPayC + employees[employeeCount].getTotalPay();
			if(employees[employeeCount] instanceof Salaried)
				totalPayS = totalPayS + employees[employeeCount].getTotalPay();
			if(employees[employeeCount] instanceof Hourly)
				totalPayH = totalPayH + employees[employeeCount].getTotalPay();
		}
	}
	
	/**
	 * Prints the column headings and attributes of all of our employees.
	 * 
	 * @param employees	Employee array of our employees
	 */
	public static void printEmployees(Employee[] employees){
		System.out.println("Type\t\tTitle\t\tName\t\t\tID\tSalary\t\tRate\tSales\tThres\tTotal");
		for(int employeeCount = 0; employeeCount < 9; employeeCount++){
			employees[employeeCount].print();
		}
		System.out.printf("\nThe total pay for Commission is:\t$%.2f\n\n",totalPayC);
		
		System.out.println("Type\t\tTitle\t\tName\t\t\tID\tSalary\t\tTotal");
		for(int employeeCount = 10; employeeCount < 19; employeeCount++){
			employees[employeeCount].print();
		}
		System.out.printf("\nThe total pay for Salaried is:\t\t$%.2f\n\n",totalPayS);
		
		
		System.out.println("Type\t\tTitle\t\tName\t\t\tID\tWage\tHours\tOT\tTotal");
		for(int employeeCount = 20; employeeCount < 29; employeeCount++){
			employees[employeeCount].print();
		}
		System.out.printf("\nThe total pay for Hourly is:\t\t$%.2f\n",totalPayH);
		
		System.out.printf("\n\nThe total pay for all employees is:\t$%.2f\n",(totalPayC+totalPayH+totalPayS));
	}
}

