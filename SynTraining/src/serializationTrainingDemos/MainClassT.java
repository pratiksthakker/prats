package serializationTrainingDemos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.imageio.stream.FileImageInputStream;

/*class Empt implements Serializable {
 private String name;
 private int age;
 //private int weight = 50;
 public Empt(){}
 public Empt(String name, int age) {
 super();
 this.name = name;
 this.age = age;
 }
 public String getName() {
 return name;
 }
 public void setName(String name) {
 this.name = name;
 }
 public int getAge() {
 return age;
 }
 public void setAge(int age) {
 this.age = age;
 }
 @Override
 public String toString() {
 return "Empt [age=" + age + ", name=" + name + "]";
 }

 }
 class Empdet extends Empt  {
 private int date;

 public Empdet(int date) {
 this.date = date;
 }

 public int getDate() {
 return date;
 }

 public void setDate(int date) {
 this.date = date;
 }

 }*/
class Empt implements Serializable {
	private String name;
	private int age;

	// private int weight = 50;

	public Empt(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Empt [age=" + age + ", name=" + name + "]";
	}

	class Empdet implements Serializable {
		private int date;

		public Empdet(int date) {
			this.date = date;
		}

		public int getDate() {
			return date;
		}

		public void setDate(int date) {
			this.date = date;
		}

	}

}

public class MainClassT {
	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		// Empdet obj = new Empdet(55);
		Empt obj = new Empt("aa", 22);
		//Empt.Empdet obj = new Empt("ssss",55).new Empdet(55);
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(
				"D:\\fiiil19"));
		os.writeObject(obj);
		System.out.println("done");
		/*
		 * ObjectInputStream os = new ObjectInputStream(new
		 * FileInputStream("D:\\fiiil1")); Object o = os.readObject(); Empt
		 * object = (Empt)o; System.out.println(object);
		 */
	}
}
