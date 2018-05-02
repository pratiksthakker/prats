package serializationTrainingDemos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * 
 * @author Ganesh.Rashinker
 *
 */

class ParEmp{
	int a1;
	int a2;
	public ParEmp(){}
	public ParEmp(int a1, int a2) {
		super();
		this.a1 = a1;
		this.a2 = a2;
	}
	
}
class Emp extends ParEmp implements Serializable {
//{
	int x;
	int y ;
	static int z=55;
	transient int k;
	/*public Emp(){
		x = 3;
		y = 4;
	}*/
	public Emp(int x, int y) {
		super(21 , 31);
		this.x = x;
		this.y = y;
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		System.out.println("writeObject");
		out.writeInt(a1);
		out.writeInt(a2);//out.wr
		out.writeInt(z);
	}

	private void readObject(java.io.ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();
		System.out.println("readObject");
		a1 = in.readInt(); 
		a2 = in.readInt();
		z = in.readInt();
	}

	@Override
	public String toString() {
		return "Emp [x=" + x + ", y=" + y + "]" + z + " "  + a1 + a2;
	}
	

}

public class MainClass2 {
	public static void main(String[] args) throws IOException {

		Emp e1 = new Emp(11,99);
		//e1.x = 55;
		//e1.y = 44;
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("D:\\today"));
			oos.writeObject(e1);
			System.out.println("write " + e1);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null)
				oos.close();
		}

		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("D:\\today"));
			Object o = ois.readObject();
			Emp e2 = (Emp) o;
			System.out.println(e2);
			//System.out.println("Read object " + e2.x + e2.y + e2.z + e2.a1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				ois.close();
			}
		}

	}
}
