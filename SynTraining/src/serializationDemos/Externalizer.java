package serializationDemos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Externalizer {

	ObjectInputStream oi;
	FileInputStream fi;
	ObjectOutputStream oo;
	FileOutputStream fo;
	ExternalizableEmp eemp = new ExternalizableEmp(4, "Jack");

	public static void main(String args[]) {

		Externalizer exr = new Externalizer();
		exr.serializeNormalManager();
		exr.deserializeNormalManager();
	}

	public void deserializeNormalManager() {

		try {
			fi = new FileInputStream("/pratik/exrEmp");
			ObjectInputStream oi = new ObjectInputStream(fi);
			ExternalizableEmp nm = (ExternalizableEmp) oi.readObject();
			System.out.println(nm);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void serializeNormalManager() {

		try {
			fo = new FileOutputStream("/pratik/exrEmp");
			oo = new ObjectOutputStream(fo);
			oo.writeObject(eemp);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
