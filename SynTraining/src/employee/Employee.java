package employee;

public class Employee {

	private Integer Id;
	private String Name;
	public int integer = 10;
	
	
	public static void print()
	{
		System.out.println("Hello");
	}
	public int getInteger() {
		return integer;
	}
	public void setInteger(int integer) {
		this.integer = integer;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	@Override
	public int hashCode() {
		//int hashCode = this.getId();
		int hashCode = this.getId()%2;
		return hashCode;
	}
	
	public Employee(Integer id, String name) {
		setId(id);
		setName(name);		
	}
	
	@Override
	public boolean equals(Object obj) {
		Employee emp = (Employee) obj;
		boolean isEqual = false;
		//System.out.println("equals method called with Id "+emp.getId()+" For Id : "+getId());
		if(emp.getId().equals(getId()))
		{
			isEqual = true;
		}
		return isEqual;
	}
	
	@Override
	public String toString() {
		return "Emp Id : "+getId()+" Emp Name : "+getName();
	}
	
	/*@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}*/
	
	public void printState()
	{
		System.out.println("Employee : " +toString());
	}
	
	public void justEmpMethod()
	{
		System.out.println("I Am just available in Employee");
	}
	
	private void privateEmpMethod()
	{
		System.out.println("I Am a private method");
	}
}
