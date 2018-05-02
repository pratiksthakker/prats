package ownThreadingExamples;

import java.util.concurrent.locks.ReentrantLock;

class reentLockEx {
	ReentrantLock rl = new ReentrantLock();// when you call the lock method in
											// r1
											// the obj of reentLockEx will not
											// be locked just the
											// r1 reference of that particular
											// obj will be locked

	public void A() {
		System.out.println(Thread.currentThread().getName()+" Trying to get Lock....A.....");
		this.rl.lock();// count - 1
		System.out.println(Thread.currentThread().getName()+"  Inside Lock.....A.....");
		//B();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Hold count After B : " + rl.getHoldCount());
		this.rl.unlock();// If you dont unlock here the lock count for the same
							// thread will remain
							// Since we called B from here and when lock was
							// called on B the count was incremented and on
							// unlock it was decremented but still the count
							// which was incremented in A method will not be
							// decremented
	}

	public void B() {

		System.out.println(Thread.currentThread().getName()+" Trying to get Lock....B.....");
		this.rl.lock();// count - 2
		System.out.println(Thread.currentThread().getName()+" Inside Lock.....B.....");
		//System.out.println("Hold count : " + rl.getHoldCount());
		this.rl.unlock();// count - 1
		//System.out.println("Hold count : " + rl.getHoldCount());// count - 1
	}
}

class readerDemoA implements Runnable {
	reentLockEx obj = new reentLockEx();

	public readerDemoA(reentLockEx obj) {
		this.obj = obj;
	}

	@Override
	public void run() {

		System.out.println("Calling A....");
		obj.A();
		/*System.out.println("Calling B....");
		obj.B();*/

	}

}

class readerDemoB implements Runnable {
	reentLockEx obj = new reentLockEx();

	public readerDemoB(reentLockEx obj) {
		this.obj = obj;
	}

	@Override
	public void run() {

		System.out.println("Calling B....");
		obj.B();
		/*System.out.println("Calling B....");
		obj.B();*/

	}

}

public class ReenLock {

	public static void main(String args[]) {
		reentLockEx reenObj = new reentLockEx();
		readerDemoA redObj = new readerDemoA(reenObj);
		readerDemoB redObjB = new readerDemoB(reenObj);
		Thread t = new Thread(redObj);
		t.start();
		Thread t1 = new Thread(redObjB);
		t1.start();
	}

}
