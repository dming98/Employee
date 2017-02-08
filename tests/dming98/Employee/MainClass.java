package dming98.Employee;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args){
		Employee[] empList = null;
		Scanner console = new Scanner(System.in);
		
		System.out.println("Please input the data file containing the employee data: ");
		String dataFile = console.next();
		System.out.println("Please input the number of employees: ");
		int numEmp = console.nextInt();
		
		empList = EmployeeDataAnalyzer.employeeReader(dataFile, numEmp);
		EmployeeDataAnalyzer.sortEmployees(empList);
	}
}
