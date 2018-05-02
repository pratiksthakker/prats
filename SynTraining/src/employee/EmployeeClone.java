package employee;

public class EmployeeClone implements Cloneable{

	private Integer Id;
	private String Name;
	
	
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
		int hashCode = this.getId()%2;
		return hashCode;
	}
	
	public EmployeeClone(Integer id, String name) {
		setId(id);
		setName(name);		
	}
	
	@Override
	public boolean equals(Object obj) {
		EmployeeClone emp = (EmployeeClone) obj;
		boolean isEqual = false;
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
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
