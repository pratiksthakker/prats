package threading;

class Producer implements Runnable {

	A a;

	public Producer(A a) {

		this.a = a;

	}

	@Override
	public void run() {

		try {

			while (true) {

				a.produce();

			}

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

}

class Consumer implements Runnable {

	A a;

	public Consumer(A a) {

		this.a = a;

	}

	@Override
	public void run() {

		try {

			while (true) {

				a.consume();

			}

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

}

class A {

	int i;

	boolean flag = false;

	public synchronized void produce() throws Exception {

		// notify();

		// notifyAll();

		if (i != 0)

			wait();

		i++;

		System.out.println("produced " + i);

		// }

		Thread.sleep(500);

		// wait();

		notify();// signal leak

	}

	public synchronized void consume() throws Exception {

		// notify();

		wait();

		if (i != 0)

			System.out.println("consumed " + i);

		// }

		Thread.sleep(500);

		// wait();

		notify();

	}

}

public class ProducerConsumer {

	public static void main(String[] args) {

		// signal miss

		A obj = new A();

		Producer prod = new Producer(obj);

		Consumer cons = new Consumer(obj);

		Thread t1 = new Thread(prod);

		Thread t2 = new Thread(cons);

		// t1.start();

		t2.start();

		t1.start();

	}

}
