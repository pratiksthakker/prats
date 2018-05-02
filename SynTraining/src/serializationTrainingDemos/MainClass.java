package serializationTrainingDemos;

import java.io.*;



class Person implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String firstName;
	public String lastName;
	private String password;//readresolve
	public String newVar;
	transient Thread worker;

	public Person(String firstName, String lastName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public String toString() {
		return new String(lastName + ", " + firstName +worker+newVar);
	}
}

public class MainClass {
	public static void main(String[] args) throws IOException {
		/*Person p = new Person("Tom", "Jobing", "Syntosticato");
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("D:\\a3.ser"));
			oos.writeObject(p);
			oos.flush();
		} catch (Exception e) {
			//e.printStackTrace();
		} finally {
			//if (oos != null)
				//oos.close();
		}
System.out.println("done");*/
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("D:\\a3.ser"));
			Object o = ois.readObject();
			System.out.println("Read object " + o);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				ois.close();
			}
		}
	}
}
