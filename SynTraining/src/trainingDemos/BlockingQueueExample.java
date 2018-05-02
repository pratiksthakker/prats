package trainingDemos;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

	public static void main(String[] args) throws Exception {

		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1024);

		Producer1 producer = new Producer1(queue);
		Consumer1 consumer = new Consumer1(queue);

		new Thread(producer).start();
		new Thread(consumer).start();

		Thread.sleep(4000);
	}
}

class Producer implements Runnable {

	protected BlockingQueue queue = null;

	public Producer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				queue.put(i);				
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Consumer implements Runnable {

	protected BlockingQueue queue = null;

	public Consumer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			// while (true)
			for (int i = 0; i < 10; i++) {
				System.out.println(queue.take());
				if (i == 4)
					Thread.sleep(5000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
