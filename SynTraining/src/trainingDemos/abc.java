package trainingDemos;

class Employee{
	private int Eid;
	private String fName;
	@Override
	public int hashCode() {
		//return Eid;
		return 1555;
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + Eid;
//		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
//		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (Eid != other.Eid)
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		return true;
	}
}
public class abc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "aaaa";
		System.out.println(str.hashCode());

	}

}
