package ownThreadingExamples;

import java.util.LinkedList;
import java.util.Queue;

public class MyThreadPool {
	
	public static void main(String args[]) throws InterruptedException
	{
		ThreadPoolDemo threadPool = new ThreadPoolDemo(2);
		int i = 0;
		while(i<10)
		{
			MyTask task = new MyTask("Task"+i);
			threadPool.submitTask(task);
			i++;
			Thread.sleep(300);
		}
	}
}

class ThreadPoolDemo {

	Queue<Runnable> myPool = new LinkedList<Runnable>();

	public ThreadPoolDemo(int poolSize) {
		for (int i = 0; i < poolSize; i++) {
			Runnable worker = new MyWorkerThread(myPool, "worker" + i);
			Thread thread = new Thread(worker);
			thread.start();
		}
	}

	public void submitTask(Runnable task) {
		System.out.println("Task Submitted to pool");
		myPool.add(task);
	}

}

class MyWorkerThread implements Runnable {

	Queue<Runnable> myPool = new LinkedList<Runnable>();
	String Name;

	public MyWorkerThread(Queue<Runnable> myPool, String Name) {
		this.myPool = myPool;
		this.Name = Name;
	}

	@Override
	public void run() {

		while(myPool.size() != 0) {
			Runnable task = myPool.remove();
			System.out.println("Started Task in Thread : " + this.Name);
			task.run();
			System.out.println("Compelted Task in Thread : " + this.Name);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class MyTask implements Runnable {

	String Name;

	public MyTask(String Name) {
		System.out.println("Creating Task with Name : "+Name);
		this.Name = Name;
	}

	@Override
	public void run() {
		System.out.println("Started Task : " + Name);
	}
}
