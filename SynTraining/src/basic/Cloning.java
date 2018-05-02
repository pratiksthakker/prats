package basic;

import employee.Employee;
import employee.EmployeeClone;

public class Cloning {

	/**
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		
		
		/*Employee e1= new Employee(1,"Jack");
		//Employee e2 = e1. //Here if the clone method is not overridden you cannot call the clone method directly since it is protected in Object class. 
		
		 * ---------Overridden clone method just by calling super.clone
		 
		Employee e2 = (Employee)e1.clone(); //After this we had to add clone not supportedException
		
		System.out.println("e1.Equals(e1) : "+e1.equals(e2));
		if(e1==e2)
		{
			System.out.println("  e1==e2 : True");
		}else
		{
			System.out.println("  e1==e2 : False");
		}
		
		*The Above Code throws a CloneNotSupportedException since the Employee class doesnot impletment the cloneable interface
		*/
		
		EmployeeClone ec1 = new EmployeeClone(2,"Jack");
		
		/*
		 * ---------Overridden clone method just by calling super.clone
		 * Here a Deep copy will be created and not a shallow copy.
		 */		
		EmployeeClone ec2 = (EmployeeClone)ec1.clone(); //After this we had to add clone not supportedException
		
		System.out.println("ec1.Equals(ec1) : "+ec1.equals(ec2)); //This will give you true since I have overriden the equals function in the EmployeeClone class but if there is not equals method overrdden
																//then it will return false since then it will compare the references
		if(ec1==ec2) //will return false since deep copy is created
		{
			System.out.println("  ec1==ec2 : True");
		}else
		{
			System.out.println("  ec1==ec2 : False");
		}
		//EmployeeClone ec2 = ec1.clone() //Even if your Class is implementing the clonnable interface you will have to override the clone method to call it .
		

	}

}
