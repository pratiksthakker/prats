package ownThreadingExamples;


class A1 implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread " + Thread.currentThread().getName()
				+ " in Run....");
		int j = 0;
		while (j < 1000) {
			for (int i = 0; i < 100000; i++) {
				double sum = Math.sqrt(Double.valueOf(i));
			}
			if (Thread.interrupted()) {
				System.out.println("Thread " + Thread.currentThread().getName()
						+ " interuppted" + " The valud og J is : " + j);
				return;
			}
			j++;
		}
		System.out.println("Thread " + Thread.currentThread().getName()
				+ " leaving normaly" + " The valud og J is : " + j);

	}

}

class B1 implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread " + Thread.currentThread().getName()
				+ " in Run....");
		int j = 0;
		while (j < 1000) {
			for (int i = 0; i < 100000; i++) {
				double sum = Math.sqrt(Double.valueOf(i));
			}
			if (j == 500) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					System.out.println("Thread "
							+ Thread.currentThread().getName() + " interuppted"
							+ " The valud of J is : " + j);
					return;
				}
			}
			j++;
		}
		System.out.println("Thread " + Thread.currentThread().getName()
				+ " leaving normaly" + " The valud of J is : " + j);

	}

}

public class ThreadInterrupti {

	public static void main(String[] ars) {
		A1 objA = new A1();
		//B1 objB = new B1();
		Thread t1 = new Thread(objA, "T1");
		//Thread t2 = new Thread(objB, "T2");
		t1.start();
		//t2.start();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main Thread  interrupting");
		t1.interrupt();
		//t2.interrupt();
		System.out.println("Main Thread  proceeding");

	}

}
