package serializationDemos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializer {

	ObjectOutputStream oo;
	FileOutputStream fo;
	SerializableEmployee se = new SerializableEmployee(1009, "Pratik");
	SerializableManager sm = new SerializableManager(2, "Manager",
			"MorganStanley", 199);
	NormalManager nm = new NormalManager(4, "NormalManager", "MS", 444);

	public static void main(String args[]) {
		Serializer ser = new Serializer();
		//ser.serializeSerializableEmployee();
		// ser.serializeSerializableManager();
		ser.serializeNormalManager();
	}

	/*
	 * Here to serialize the private feilds we will have to implement the
	 * WriteObject and to deserialize it we will have to implement the
	 * readObject method explicitly in the class which is implmenting
	 * serializable (here - serializableEmployee) and call the
	 * defaultwriteobject and default readobject from the respective methods
	 */
	public void serializeSerializableEmployee() {

		try {
			fo = new FileOutputStream("/pratik/serEmp");
			oo = new ObjectOutputStream(fo);
			se.integer = 1100000001;// This value will not be serialized only
									// since
			// this field is static in employee class
			se.LastName = "Hello World";
			oo.writeObject(se);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void serializeSerializableManager() {

		try {
			fo = new FileOutputStream("/pratik/serMan");// If you check this
														// file without the
														// methods
														// Write and Read Object
														// in the
														// Serializableanager
														// class then there will
														// be no feilds of
														// NormalEmployee
														// present there
			oo = new ObjectOutputStream(fo);
			oo.writeObject(sm);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void serializeNormalManager() {

		try {
			fo = new FileOutputStream("/pratik/serNorMan");
			oo = new ObjectOutputStream(fo);
			oo.writeObject(nm);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
