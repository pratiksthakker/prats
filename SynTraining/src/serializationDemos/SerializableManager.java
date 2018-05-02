package serializationDemos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Here since the parent class is not seriliazable if we serialize object of this class , the parent 
 * Object State will not be serialized and again here we will have to write the WriteObject and ReadObject
 * methods for explicitly serializing the variables of the parent class
 * 
 * Also the Parent Class has to have a default constructor here else we will get an error while deserializing this 
 */

public class SerializableManager extends NormalEmp implements Serializable {

	private static final long serialVersionUID = 1L;
	private String projName;
	private int cabinLoc;

	public String getProjName() {
		return projName;
	}

	public SerializableManager(Integer id, String name, String projName,
			int cabinLoc) {
		super(id, name);
		this.projName = projName;
		this.cabinLoc = cabinLoc;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public int getCabinLoc() {
		return cabinLoc;
	}

	public void setCabinLoc(int cabinLoc) {
		this.cabinLoc = cabinLoc;
	}

	@Override
	public String toString() {
		return "SerializableManager [projName=" + projName + ", cabinLoc="
				+ cabinLoc + ", toString()=" + super.toString() + "]";
	}

	/*
	 * This method allows us serialize the Parent Class Object State as well
	 * since it is not serializable we will explicitly serialize it.
	 * 
	 * NOTE:- This methods need to be private if you want the compiler to invoke
	 * this writeObject method instead of the built-in one .
	 */

	private void writeObject(ObjectOutputStream o) {
		try {
			o.defaultWriteObject();
			System.out.println("private write obj called...");
			o.writeInt(this.getId());
			o.writeObject(this.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void readObject(ObjectInputStream oi) {
		try {
			oi.defaultReadObject();
			System.out.println("private Read obj called...");
			this.setId(oi.readInt());
			this.setName(String.valueOf(oi.readObject()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
