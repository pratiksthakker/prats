package mapsAndThreads;

import java.util.concurrent.TimeUnit;

class Employee {
	private int id;
	private String name;

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		// final int prime = 31;
		// int result = 1;
		// result = prime * result + id;
		// result = prime * result + ((name == null) ? 0 : name.hashCode());
		return 1;
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
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}

class PutinMap {
	HashMap<Employee, Integer> map;

	public PutinMap(HashMap<Employee, Integer> map) {
		super();
		this.map = map;
	}

	public void doPut(Employee e, Integer data) {
		map.put(e, data);
		// System.out.println(map.put(e, data) + " " + map.size());
		// System.out.println(map);
	}

}

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main Started ");
		// Employee emp1 = new Employee(1, "John");
		// Employee emp2 = new Employee(2, "Roni");
		// Employee emp3 = new Employee(3, "Suzy");
		// Employee emp4 = new Employee(4, "Robert");
		// Employee emp5 = new Employee(5, "Tina");
		// Employee emp6 = new Employee(6, "Lendi");
		// Employee emp7 = new Employee(7, "Brown");
		// Employee emp8 = new Employee(8, "Tista");
		// Employee emp9 = new Employee(9, "Jack");
		// Employee emp10 = new Employee(10, "Lee");
		// Employee emp11 = new Employee(11, "Alister");
		// Employee emp12 = new Employee(12, "Paul");
		final Employee emp13 = new Employee(13, "Jeniffer");
		final Employee emp14 = new Employee(14, "Linda");
		final Employee emp15 = new Employee(15, "Abdul");
		// Employee emp16 = new Employee(16, "Tushar");
		// Employee emp17 = new Employee(17, "Albert");
		// Employee emp18 = new Employee(18, "Seema");
		// Employee emp19 = new Employee(19, "Riya");
		// Employee emp20 = new Employee(20, "Dinesh");
		HashMap<Employee, Integer> map = new HashMap<Employee, Integer>(16);
		Employee emp;
		for (int i = 1; i <= 12; i++) {
			emp = new Employee(i, i + "name");
			map.put(emp, i);
		}
		System.out.println(map);
		final PutinMap object = new PutinMap(map);
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("before 13 put");
				object.doPut(emp13, 13);
				System.out.println("after 13 put");
			}
		});
		t1.start();

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("before 14 put");
				object.doPut(emp14, 14);
				System.out.println("after 14 put");
			}
		});
		t2.start();
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("before 15 put");
				object.doPut(emp15, 15);
				System.out.println("after 15 put");
			}
		});
		t3.start();
		//Thread.sleep(3000);
		/*t1.join();
		t2.join();
		t3.join();*/
		System.out.println("final" + map);
		System.out
				.println("After 3 simultaneous put the size is : " + map.size);
	}

}
