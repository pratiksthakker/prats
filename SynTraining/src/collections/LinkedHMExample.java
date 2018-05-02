package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;

import employee.Employee;

public class LinkedHMExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LinkedHashMap<Employee,Employee> linkedHM = new LinkedHashMap<Employee, Employee>();
		Employee emp1 = new Employee(2, "ABC");
		linkedHM.put(emp1,emp1);
		Employee emp2 = new Employee(4, "XYZ");
		linkedHM.put(emp2,emp2);
		Employee emp3 = new Employee(3, "ABC");
		linkedHM.put(emp3,emp3);
		//System.out.println(linkedHM);
		linkedHM.containsKey(emp3);
		linkedHM.get(emp3);
		
		HashMap<Employee, Employee> empHM = new HashMap<Employee, Employee>();
		empHM.put(emp1,emp1);
		empHM.put(emp2,emp2);
		empHM.put(emp3,emp3);
		System.out.println(linkedHM);
		
		LinkedHashMap<Employee,Employee> linkedHM1 = new LinkedHashMap<Employee, Employee>(2, .75f, true);
		linkedHM1.put(emp1,emp1);
		linkedHM1.put(emp2,emp2);
		linkedHM1.put(emp3,emp3);
		//System.out.println(linkedHM);
		linkedHM1.get(emp2);
		//System.out.println(linkedHM);
		

	}

}
