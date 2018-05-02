package concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class ConcurrentDemo {

	public static void main(String[] args) {
		
		BlockingQueue<Integer> bQueue = new LinkedBlockingQueue<Integer>();
		
		producer prodobj = new producer(bQueue);
		consumer consObj = new consumer(bQueue);
		
		Thread prodT = new Thread(prodobj);
		Thread conT = new Thread(consObj);
		
		prodT.start();
		conT.start();
		
	}

}

class producer implements Runnable{

	BlockingQueue<Integer> bQueue;
	public producer(BlockingQueue<Integer> bQueue)
	{
		this.bQueue = bQueue;
	}
	@Override
	public void run() {
		for(int i = 0;i<10;i++){
			System.out.println("Trying to add ......"+i);
			try {
				bQueue.put(i);//Over here if you do bQueue.add(i) and if the queue is full then we will get IllegalStateExceptio
								//The reason is same as the reason mentioned below in remove method .
				System.out.println("Added ......"+i);
				if(i==5)
				{
					Thread.sleep(300);
				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
		
	
}

class consumer implements Runnable{

	BlockingQueue<Integer> bQueue;
	public consumer(BlockingQueue<Integer> bQueue)
	{
		this.bQueue = bQueue;
	}
	@Override
	public void run() {
		for(int i = 0;i<10;i++){
			System.out.println("Trying to Take ......");
			try {
				System.out.println("Took ......"+bQueue.take());//if your use bQueue.remove over here then if there is not element Exception will be thrown since no await is called if Queue is empty inside the remove method
																//but inside take we call await if Queue is empty
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
