package serializationDemos;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternalizableEmp implements Externalizable {

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

	public ExternalizableEmp(Integer id, String name) {
		setId(id);
		setName(name);
	}

	public ExternalizableEmp() {
		super();
	}

	@Override
	public String toString() {
		return "Emp Id : " + getId() + " Emp Name : " + getName();
	}

	/*
	 * (non-Javadoc)
	 * Here since I am just externalizing the Name Feild so while de-externalizing only that feild will be
	 * deexternalize.
	 */
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		
		out.writeObject(getName());
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		this.setName(String.valueOf(in.readObject()));
		}
}
