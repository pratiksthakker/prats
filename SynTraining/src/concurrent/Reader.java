package concurrent;

import java.util.concurrent.ConcurrentHashMap;

import employee.Employee;

public class Reader implements Runnable {

	OwnCHM<Employee, String> chm = new OwnCHM<Employee, String>();
	String threadName;

	public Reader(OwnCHM<Employee, String> chm, String threadName) {
		this.chm = chm;
		this.threadName = threadName;
	}

	@Override
	public void run() {

		System.out.println("Reader " + this.threadName + " trying to get entries ......");
		try {
			Employee emp;
			for (int i = 0; i < 10; i++) {
				emp = new Employee(i+2, "Jack"+i);
				System.out.println("For "+ emp + this.threadName +" Got : "+chm.get(emp));
				Thread.sleep(3);
			}
			System.out.println("Reader " + this.threadName
					+ " Finished Reading ......");	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
