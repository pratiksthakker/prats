package threading;

class Servees {

	private int contents;

	private boolean available = false;

	public synchronized int get() {

		while (available == false) {

			try {

				wait();

			} catch (InterruptedException e) {

			}

		}

		available = false;

		notifyAll();

		return contents;

	}

	public synchronized void put(int value) {

		while (available == true) {

			try {

				wait();

			} catch (InterruptedException e) {

			}

		}

		contents = value;

		available = true;

		notifyAll();

	}

}

class Producer3 extends Thread {

	private Servees Servees;

	private int number;

	public Producer3(Servees c, int number) {

		Servees = c;

		this.number = number;

	}

	public void run() {

		for (int i = 1; i <= 10; i++) {

			Servees.put(i);

			System.out.println("Producer #" + this.number + " put: " + i);

			/*
			 * 
			 * try { sleep(500); } catch (InterruptedException e) { }
			 */

		}

	}

}

class Consumer3 extends Thread {

	private Servees Servees;

	private int number;

	public Consumer3(Servees c, int number) {

		Servees = c;

		this.number = number;

	}

	public void run() {

		int value = 0;

		for (int i = 1; i <= 10; i++) {

			value = Servees.get();

			System.out.println("Consumer #" + this.number + " got: " + value);

		}

	}

}

public class ProdConsumWay3 {

	public static void main(String[] args) {

		Servees c = new Servees();

		Producer3 p1 = new Producer3(c, 1);

		Consumer3 c1 = new Consumer3(c, 1);

		p1.start();

		c1.start();

	}

}
