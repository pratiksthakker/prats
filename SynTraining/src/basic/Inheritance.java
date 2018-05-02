package basic;

import employee.Developer;
import employee.Employee;

public class Inheritance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		//Developer d1 = new Employee(1,"Jack"); Not possible since you are assigning a subclass variable an instance of superClass
		Employee e1 = new Developer(1, "Jack",100);
		
		System.out.println("e1.integer  Value : "+e1.integer); //here the output will be 10 since integer is 10 in Employee class
		System.out.println("e1.integer Value : "+e1.getInteger());//Here the output will be 20 since the getInteger of Deeloper class will be called

	}

}
