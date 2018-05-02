package ownThreadingExamples;

class A {
	public synchronized void printA() {
		System.out.println(".........A..........");
		try {
			System.out.println(Thread.currentThread()
					+ ".........Waiting..........");
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void printA1() {
		System.out.println(".........A1..........");
		try {
			System.out.println(Thread.currentThread()
					+ ".........Waiting..........");
			Thread.sleep(300);
			System.out.println(Thread.currentThread()
					+ ".........Waiting Done..........");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printA2() {
		synchronized (this) {
			System.out.println(".........A2..........");
			try {
				System.out.println(Thread.currentThread()
						+ ".........Waiting..........");
				Thread.sleep(300);
				System.out.println(Thread.currentThread()
						+ ".........Waiting Done..........");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void printA3() {
		synchronized (this) {
			System.out.println(".........A3..........");
			try {
				System.out.println(Thread.currentThread()
						+ ".........Waiting..........");
				Thread.sleep(300);
				System.out.println(Thread.currentThread()
						+ ".........Waiting Done..........");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public void printA4() {
		synchronized (A.class) {
			System.out.println(".........A4..........");
			try {
				System.out.println(Thread.currentThread()
						+ ".........Waiting..........");
				Thread.sleep(3000);
				System.out.println(Thread.currentThread()
						+ ".........Waiting Done..........");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void printA5() {
		synchronized (A.class) {
			System.out.println(".........A5..........");
			try {
				System.out.println(Thread.currentThread()
						+ ".........Waiting..........");
				Thread.sleep(300);
				System.out.println(Thread.currentThread()
						+ ".........Waiting Done..........");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

class demoThreadA implements Runnable {

	public A aObj;

	public demoThreadA(A aObj) {
		this.aObj = aObj;
	}

	@Override
	public void run() {
		System.out.println("In demoThreadA");
		//aObj.printA();
		//aObj.printA2();
		aObj.printA4();
		/*
		 * try { Thread.sleep(300); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		// TODO Auto-generated method stub

	}

}

class demoThreadA1 implements Runnable {

	public A aObj;

	public demoThreadA1(A aObj) {
		this.aObj = aObj;
	}

	@Override
	public void run() {
		System.out.println("In demoThreadA1");
		//aObj.printA1();
		//aObj.printA3();
		aObj.printA5();
		/*
		 * try { Thread.sleep(300); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		// TODO Auto-generated method stub

	}

}

public class SyncronizationDemo {

	public static void main(String args[]) {

		A aObj = new A();
		Thread t1 = new Thread(new demoThreadA(aObj), "T1");
		//Thread t2 = new Thread(new demoThreadA1(aObj), "T2");
		t1.start();
		//t2.start();
		A aObj1 = new A();
		Thread t3 = new Thread(new demoThreadA1(aObj1), "T3");
		t3.start();

	}
}
