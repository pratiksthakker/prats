package collections;

import java.util.HashMap;
import java.util.Map;

import employee.EmployeeHM;

/**
 * 
 * @author pratik.thakker do visit http://ganeshrashinker.blogspot.in/
 * 
 *         Detailed working of hashmap
 */
public class HashMapDemo {

	// Writing the Hash and indexFor methods of hashMap as it is to show the
	// working
	static int hash(int h) {
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	/**
	 * Returns index for hash code h.
	 */
	static int indexFor(int h, int length) {
		return h & (length - 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Map<EmployeeHM, EmployeeHM> empMap = new HashMap<EmployeeHM, EmployeeHM>();
		EmployeeHM emp1 = new EmployeeHM(2, "ABC");
		System.out.println("HashCode of Emp1 : " + emp1.hashCode());
		System.out.println("Hash of Emp1 : " + hash(emp1.hashCode()));
		System.out.println("Bucket index of Emp1 : "
				+ indexFor(hash(emp1.hashCode()), 16));
		empMap.put(emp1, emp1);
		EmployeeHM emp2 = new EmployeeHM(4, "XYZ");
		System.out.println("HashCode of Emp2 : " + emp2.hashCode());
		System.out.println("Hash of Emp2 : " + hash(emp2.hashCode()));
		System.out.println("Bucket index of Emp2 : "
				+ indexFor(hash(emp2.hashCode()), 16));
		empMap.put(emp2, emp2);// Here since We have overriden the HashCode
								// function in Employee class so for both 2 and
								// 4 hashcode will be same so the same bucket
								// will be allocated.
		System.out.println(empMap);

		
		//--------------NOW LETS SEE WHAT WILL HAPPEN WITHOUT THE HASH FUNCTION -------------//
		
		 int hashcode1 = 1;
		 int hashcode2 = 17;
		 int hashcode3 = 33;
		 int hashcode4 = 65;
		 System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		 System.out.println("Binary value of hashcode1 " + Integer.toBinaryString(hashcode1));
		 System.out.println("Binary value of hashcode1 " + Integer.toBinaryString(hashcode2));
		 System.out.println("Binary value of hashcode1 " + Integer.toBinaryString(hashcode3));
		 System.out.println("Binary value of hashcode1 " + Integer.toBinaryString(hashcode4));
		 System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		 System.out.println("Finding the bucket number on the basis of hashcode directly");
		 System.out.println("Bucket number for hashcode1: " + indexFor(hashcode1, 16));
		 System.out.println("Bucket number for hashcode2: " + indexFor(hashcode2, 16));
		 System.out.println("Bucket number for hashcode3: " + indexFor(hashcode3, 16));
		 System.out.println("Bucket number for hashcode4: " + indexFor(hashcode4, 16));
		 System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		 System.out.println("Finding the hash value on the basis of hash function");
		 System.out.println("hash value for hashcode1: " + hash(hashcode1));
		 System.out.println("hash value for hashcode2: " + hash(hashcode2));
		 System.out.println("hash value for hashcode3: " + hash(hashcode3));
		 System.out.println("hash value for hashcode4: " + hash(hashcode4));
		 System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		 System.out.println("Finding the bucket number on the basis of hash function");
		 System.out.println("Bucket number for hashcode1: " + indexFor(hash(hashcode1), 16));
		 System.out.println("Bucket number for hashcode2: " + indexFor(hash(hashcode2), 16));
		 System.out.println("Bucket number for hashcode3: " + indexFor(hash(hashcode3), 16));
		 System.out.println("Bucket number for hashcode4: " + indexFor(hash(hashcode4), 16));
		 System.out.println("+++++++++++++++++++++++++++++++++++++++++");
	}

}
