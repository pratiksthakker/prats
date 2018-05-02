package basic;

import employee.Developer;
import employee.Employee;

public class MainDummyAll {

	public static void main(String[] args)
	{
		/*Employee emp = new Employee(2, "Jack");
		System.out.println(emp);
		emp = null;
		System.out.println(emp);*/
		
		
		/*-----------------------------------*/
		Employee emp1 = new Developer(4, "ABC", 100);  
		emp1.printState();
		Employee emp2 = new Employee(4, "Jill");
		emp2.printState();
		Developer dev = (Developer) new Employee(5, "Error");
		//dev.printState();
		//dev.justDevMethod();
		//dev.justEmpMethod();
		
	}
	
}
