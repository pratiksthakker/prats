package collections;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

import employee.Employee;

public class HashMapExample {

	public static void main(String[] args) {

		Map<Employee, Employee> empMap = new HashMap<Employee, Employee>();//uses the equals method to compare key
		Map<Employee, Employee> empIMap = new IdentityHashMap<Employee, Employee>();//uses == to compare key
		Employee emp1 = new Employee(2, "ABC");
		empMap.put(emp1, emp1);
		empIMap.put(emp1, emp1);
		Employee emp2 = new Employee(4, "XYZ");
		empMap.put(emp2, emp2);// Here since We have overriden the HashCode
								// function in Employee class so for both 2 and
								// 4 hashcode will be same so the same bucket
								// will be allocated.
		empIMap.put(emp2, emp2);
		System.out.println(empMap);
		System.out.println(empIMap);
		System.out.println(empMap.get(emp1));
		System.out.println(empIMap.get(emp1));
		emp1.setId(5);
		System.out.println(empMap);
		System.out.println(empIMap);
		System.out.println(empMap.get(emp1));
		System.out.println(empIMap.get(emp1));
	}

}
