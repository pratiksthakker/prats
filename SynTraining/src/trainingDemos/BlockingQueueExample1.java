package trainingDemos;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class BlockingQueueExample1 {

	public static void main(String[] args) throws Exception {

		//BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1024);
		BlockingQueue queue = new SynchronousQueue();

		Producer1 producer = new Producer1(queue);
		Consumer1 consumer = new Consumer1(queue);

		new Thread(producer).start();
		new Thread(consumer).start();

		Thread.sleep(4000);
	}
}
