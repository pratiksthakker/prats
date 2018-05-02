package collections;

import java.util.HashSet;

import employee.Employee;

public class HashSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * HashSet is Nothing but just an Set which internally uses hashMap and it will not allow you to store any duplicate values in it .
		 * Basically whatever values you add in the HashSet are added as Keys of the HashMap.
		 * Since there cannot be duplicate Keys in the  HashMap we cannot have duplicate elements in the
		 * HashSet
		 */
		
		HashSet<Employee> strSet = new HashSet<Employee>();
		Employee emp1 = new Employee(2, "ABC");
		strSet.add(emp1);
		Employee emp2 = new Employee(4, "XYZ");
		strSet.add(emp2);
		//If you see the HashCode function in Employee , it is very ineficient since it will increase collision . Here too both the objects will have the same hashcode 
		//and in the HashMap internally they will be stored in the same bucket in a singly linked list manner. 
		System.out.println(strSet);
		Employee emp2copy = new Employee(4, "XYZ");
		System.out.println(strSet.add(emp2copy));//This will return false since we are trying to enter duplicate elements . Here the actual comparison will be done using the equals method in Employee class

	}

}
