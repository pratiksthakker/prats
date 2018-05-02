package concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueDemo {
	
	public static void main(String[] args)
	{
		BlockingQueue<Integer> bQueue = new ArrayBlockingQueue<Integer>(2);
		
		producer prodobj = new producer(bQueue);
		consumer consObj = new consumer(bQueue);
		
		Thread prodT = new Thread(prodobj);
		Thread conT = new Thread(consObj);
		
		prodT.start();
		conT.start();
	}
	
}
