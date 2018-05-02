package concurrent;


import employee.Employee;

public class ConcurrentHMDemo {
	
	public static void main(String args[])
	{
		OwnCHM<Employee, String> chm = new OwnCHM<Employee, String>();
		Writer wt = new Writer(chm, "Writer 1");
		Thread tw1 = new Thread(wt);
		tw1.start();
		Writer wt2 = new Writer(chm, "Writer 2");
		Thread tw2 = new Thread(wt2);
		tw2.start();
		Writer wt3 = new Writer(chm, "Writer 3");
		Thread tw3 = new Thread(wt3);
		tw3.start();
		Reader rd = new Reader(chm, " Reader 1 ");
		Thread tr1 = new Thread(rd);
		tr1.start();		
		Reader rd2 = new Reader(chm, " Reader 2 ");
		Thread tr2 = new Thread(rd2);
		tr2.start();
		Reader rd3 = new Reader(chm, " Reader 3 ");
		Thread tr3 = new Thread(rd3);
		tr3.start();
	}

}
