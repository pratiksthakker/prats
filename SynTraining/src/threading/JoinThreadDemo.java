package threading;

public class JoinThreadDemo {

	public static void main(String arg[]) throws InterruptedException {

		A2 a2 = new A2();

		Thread t2 = new Thread(a2, "T2");

		A1 a1 = new A1(t2);

		Thread t1 = new Thread(a1, "T1");

		t1.start();

		Thread.sleep(10);

		t2.start();

	}

}

class A1 implements Runnable {

	Thread t2;

	public A1(Thread t2) {

		this.t2 = t2;

	}

	public void run() {

		for (int i = 0; i < 500; i++) {

			System.out.println("from A1 : " + i);

			try {

				if (t2.isAlive())

					t2.join();

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}

	}

}

class A2 implements Runnable {

	public void run() {

		System.out.println("T2 Started");

		for (int i = 0; i < 500; i++) {

			System.out.println("from A2 : " + i);

		}

	}
}
