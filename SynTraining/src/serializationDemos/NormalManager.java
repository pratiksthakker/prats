package serializationDemos;


public class NormalManager extends SerializableEmployee {

	private static final long serialVersionUID = 1L;
	private String projName;
	private int cabinLoc;

	public String getProjName() {
		return projName;
	}

	public NormalManager(Integer id, String name, String projName, int cabinLoc) {
		super(id, name);
		this.projName = projName;
		this.cabinLoc = cabinLoc;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public int getCabinLoc() {
		return cabinLoc;
	}

	public void setCabinLoc(int cabinLoc) {
		this.cabinLoc = cabinLoc;
	}

	@Override
	public String toString() {
		return "SerializableManager [projName=" + projName + ", cabinLoc="
				+ cabinLoc + ", toString()=" + super.toString() + "]";
	}

}
