package serializationTrainingDemos;

import java.io.*;

class Par  implements Serializable {
//{
	/**
	 * 
	 */
	// private static final long serialVersionUID = 1L;
	public int id = 25;
	static int z = 25;
	// public String naam;

	public Par(){ id=26; }

	public Par(int id) {
		super();
		this.id = id;
	}

}

class Person1 extends Par  {
	// {
	public String firstName;
	public String lastName;
	private String password;
	transient int val;

	// public Person1(){}
	// public int data;

	public Person1(String firstName, String lastName, String password) {
		super(15);
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;

	}

	public String toString() {
		return new String(lastName + ", " + firstName + "," + id + ","
				+ password + "," + val);
	}
}

public class MainClass1 {
	public static void main(String[] args) throws IOException {

		Person1 p = new Person1("Tom", "Jobing", "Syntosticato");
		// Par p = new Par(2);

		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("D:\\new1.ser"));
			oos.writeObject(p);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null)
				oos.close();
		}

		
		/*ObjectInputStream ois2 = null; try { ois2 = new ObjectInputStream(new
		 FileInputStream("D:\\new1.ser")); Object o2 = ois2.readObject();
		 System.out.println("Read object " + o2); } catch (Exception e) {
		 e.printStackTrace(); } finally { if (ois2 != null) { ois2.close(); }
		 }*/
		 

	}
}
