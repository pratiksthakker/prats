package serializationTrainingDemos;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;


class Employee implements Externalizable {
	public String name;
	public int age;
	public int weight;

	/*public Employee() {
		age = 55;
	}

	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}*/

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		name = (String) in.readObject();
		age = in.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(age);
	}
}

public class MainClass3 {
	public static void main(String[] args) {
		//Employee emp = new Employee("Abu", 25);
		Employee emp = new Employee();
		emp.name="11";
		emp.age = 11;
		// serialize 
		try {
			FileOutputStream fo = new FileOutputStream("D:\\EmpData2");
			ObjectOutputStream so = new ObjectOutputStream(fo);
			so.writeObject(emp);
			so.flush();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("done");

		// de-serialize
		try {
			FileInputStream fi = new FileInputStream("D:\\EmpData2");
			ObjectInputStream si = new ObjectInputStream(fi);
			Employee emp1 = (Employee) si.readObject();
			System.out.println(emp1.name + emp1.age);
		} catch (Exception e) {
			//System.out.println(e);
			e.printStackTrace();
		}

	}
}
