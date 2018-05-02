package threading;

public class ProducerConsumerTest {

	public static void main(String[] args) {

		CubbyHole c = new CubbyHole();

		Producer1 p1 = new Producer1(c, 1);

		Consumer1 c1 = new Consumer1(c, 1);

		p1.start();

		c1.start();

	}

}

class CubbyHole {

	private int contents;

	private boolean available = true;

	public synchronized int get() {

		int count = 0;

		while (available == false) {

			try {

				count++;

				System.out.println("consume " + count);

				wait();

			} catch (InterruptedException e) {

			}

		}

		System.out.println("change available" + count);

		available = false;

		notifyAll();

		return contents;

	}

	public synchronized void put(int value) {

		int count = 0;

		while (available == true) {

			try {

				count++;

				System.out.println("produce " + count);

				wait();

			} catch (InterruptedException e) {

			}

		}

		contents = value;

		available = true;

		notifyAll();

	}

}

class Consumer1 extends Thread {

	private CubbyHole cubbyhole;

	private int number;

	public Consumer1(CubbyHole c, int number) {

		cubbyhole = c;

		this.number = number;

	}

	public void run() {

		int value = 0;

		for (int i = 1; i <= 10; i++) {

			value = cubbyhole.get();

			System.out.println("Consumer1 #" + this.number + " got: " + value);

		}

	}

}

class Producer1 extends Thread {

	private CubbyHole cubbyhole;

	private int number;

	public Producer1(CubbyHole c, int number) {

		cubbyhole = c;

		this.number = number;

	}

	public void run() {

		for (int i = 1; i <= 10; i++) {

			cubbyhole.put(i);

			System.out.println("Producer1 #" + this.number + " put: " + i);

			try {

				sleep((int) (Math.random() * 100));

			} catch (InterruptedException e) {

			}

		}

	}

}
