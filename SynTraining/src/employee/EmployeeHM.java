package employee;

public class EmployeeHM {



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
		return getId();
	}
	
	//actual/appropriate would be implementation of hashCode -

/*	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		return result;
		}*/
	
	public EmployeeHM(Integer id, String name) {
		setId(id);
		setName(name);		
	}
	
	@Override
	public boolean equals(Object obj) {
		Employee emp = (Employee) obj;
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

}
