package concurrent;

import java.util.concurrent.ConcurrentHashMap;

import employee.Employee;

public class Writer implements Runnable {

	OwnCHM<Employee, String> chm = new OwnCHM<Employee, String>();
	String threadName;

	public Writer(OwnCHM<Employee, String> chm, String threadName) {
		this.chm = chm;
		this.threadName = threadName;
	}

	@Override
	public void run() {

		System.out.println(this.threadName + " trying to Put entries ......");
		try {
			Employee emp;
			for (int i = 0; i < 10; i++) {
				emp = new Employee(i+2, "Jack"+i);
				System.out.println(this.threadName +" Entering for Emp : "+emp);
				chm.put(emp, this.threadName + " Entered " + i);
				System.out.println(this.threadName +" Entered for Emp : "+emp);
				Thread.sleep(100);
			}
			System.out.println(this.threadName
					+ " Finished Writing ......");	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
