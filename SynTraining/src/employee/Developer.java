package employee;

public class Developer extends Employee {

	public int integer = 20;
	
	/*public static void print()
	{
		System.out.println("Hello");
	}*/
	
	/*
	 * Non static Print method will not be allowed since It will give an error  
	 * 	overrides employee.Employee.print
		- This instance method cannot override the static method from 
	 * 
	 */
	/* public void print()
	{
		System.out.println("Hello");
	}*/
	//*/

	public int getInteger() {
		return integer;
	}

	public void setInteger(int integer) {
		this.integer = integer;
	}

	public Developer(Integer id, String name, int integer) {
		super(id, name);
		this.integer = integer;
	}

	@Override
	public void printState() {
		System.out.println("Developer : " + this.getInteger()
				+ " Printing State of Parent : ");
		super.printState();
	}
	
	public void justDevMethod()
	{
		System.out.println("I Am just available in Dev");
	}
	
	

}
