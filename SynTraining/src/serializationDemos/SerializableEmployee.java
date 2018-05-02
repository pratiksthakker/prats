package serializationDemos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableEmployee implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer Id;
	private String Name;
	public static int integer = 10;// Since this is static this will not be
									// serialized
									// And when the object will be deserialized
									// the value will be displayed as 10 itself
	public transient String trans = "Default";
	public static String LastName = "DefaultLastName";

	public int getInteger() {
		return integer;
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

	public SerializableEmployee(Integer id, String name) {
		setId(id);
		setName(name);
	}

	public SerializableEmployee() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SerializableEmployee [Id=" + Id + ", Name=" + Name + ", trans="
				+ trans + " , Static integer=" + integer + ", Static LastName=" +LastName + "]";
	}

	/*
	 * This method allows us serialize the static objects or any specific
	 * variables that might not get serialized generally
	 * 
	 * NOTE:- This methods need to be private if you want the compiler to invoke
	 * this writeObject method instead of the built-in one .
	 */

	private void writeObject(ObjectOutputStream o) {
		try {
			o.defaultWriteObject();
			System.out.println("private write obj called...");
			o.writeInt(this.getInteger());
			o.writeObject(LastName); // Serializing your Static LastName feild
			//o.writeObject(trans);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void readObject(ObjectInputStream oi)
	{
		//SerializableEmployee se = new SerializableEmployee();
		try{
			oi.defaultReadObject();
			System.out.println("private Read obj called...");
			integer = oi.readInt();
			LastName = String.valueOf(oi.readObject());// DeSerializing your Static LastName feild
			//trans = String.valueOf(oi.readObject());
		}catch(IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return se;
	}
	

}
