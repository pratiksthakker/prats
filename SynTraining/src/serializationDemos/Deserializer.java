package serializationDemos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializer {
	
	ObjectInputStream oi;
	FileInputStream fi;
	
	public static void main(String args[])
	{
		Deserializer deSer = new Deserializer();
		//deSer.deserializeSerializableEmployee();
		//deSer.deserializeSerializableManager();
		deSer.deserializeNormalManager();
	}
	
	public void deserializeSerializableEmployee()
	{
		try {
			fi = new FileInputStream("/pratik/serEmp");
			ObjectInputStream oi = new ObjectInputStream(fi);
			SerializableEmployee se = (SerializableEmployee)oi.readObject();
			System.out.println(se);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deserializeSerializableManager()
	{
		try {
			fi = new FileInputStream("/pratik/serMan");
			ObjectInputStream oi = new ObjectInputStream(fi);
			SerializableManager sm = (SerializableManager)oi.readObject();
			System.out.println(sm);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deserializeNormalManager()
	{

		try {
			fi = new FileInputStream("/pratik/serNorMan");
			ObjectInputStream oi = new ObjectInputStream(fi);
			NormalManager nm = (NormalManager)oi.readObject();
			System.out.println(nm);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
}
