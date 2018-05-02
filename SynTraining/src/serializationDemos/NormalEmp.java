package serializationDemos;


public class NormalEmp {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
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

	public NormalEmp(Integer id, String name) {
		setId(id);
		setName(name);
	}

	public NormalEmp() {
		super();
	}

	@Override
	public String toString() {
		return "Emp Id : " + getId() + " Emp Name : " + getName();
	}

	
	

}
