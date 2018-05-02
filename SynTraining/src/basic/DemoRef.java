package basic;


class person
{
	private String name;
	private int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		
		return "Person Id : "+getId()+" Person Name : "+getName();
	}
	
	
}
public class DemoRef {
	
	public static void main(String args[])
	{
		person p1 = new person();
		p1.setId(2);
		p1.setName("JACK");
		System.out.println("After creation : "+p1);
		changePerson(p1);
		System.out.println("After changePerson : "+p1);
		changePersonVar(p1);
		System.out.println("After changePersonVar : "+p1);
		
	}
	
	public static void changePerson(person p)
	{
		person p1 = new person();
		p1.setId(4);
		p1.setName("JILL");
		p=p1;
	}
	
	public static void changePersonVar(person p)
	{
		p.setId(3);
		p.setName("JIM");
	}

}
