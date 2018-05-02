package ownThreadingExamples;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


class MyPrivateTask implements Runnable {

	String Name;

	public MyPrivateTask(String Name) {
		System.out.println("Creating Task with Name : "+Name);
		this.Name = Name;
	}

	@Override
	public void run() {
		try {
			System.out.println("Started Task : " + Name);
			Thread.sleep(500);
			System.out.println("Resumed Task : " + Name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("completed Task : " + Name);
	}
}

public class ScheduledThreadPoolExecutordemo {
	
	public static void main(String args[])
	{
		//ScheduledExecutorService ses ;
		ScheduledThreadPoolExecutor ses = new ScheduledThreadPoolExecutor(1);
		
		MyPrivateTask task1 = new MyPrivateTask("Task1");
		MyPrivateTask task2 = new MyPrivateTask("Task2");
		
		ses.scheduleAtFixedRate(task1, 100l, 100l, TimeUnit.MILLISECONDS);
		ses.scheduleAtFixedRate(task2, 100l, 100l, TimeUnit.MILLISECONDS);
		ses.scheduleAtFixedRate(task1, 100l, 100l, TimeUnit.MILLISECONDS);
		ses.scheduleAtFixedRate(task2, 100l, 100l, TimeUnit.MILLISECONDS);
		
		
		/*ses.scheduleWithFixedDelay(task1, 100l, 100l, TimeUnit.MILLISECONDS);
		ses.scheduleWithFixedDelay(task2, 100l, 100l, TimeUnit.MILLISECONDS);
		ses.scheduleWithFixedDelay(task1, 100l, 100l, TimeUnit.MILLISECONDS);
		ses.scheduleWithFixedDelay(task2, 100l, 100l, TimeUnit.MILLISECONDS);*/
	}
	

}
