package ownThreadingExamples;

import java.util.concurrent.locks.ReentrantLock;

class threadMethod implements Runnable {

	ReentrantLock rlock = new ReentrantLock();

	public threadMethod(ReentrantLock rlock) {
		super();
		this.rlock = rlock;
	}

	@SuppressWarnings("finally")
	@Override
	public void run() {
		int j = 0;
		try {
			rlock.lock();
			System.out.println("Thread " + Thread.currentThread().getName()
					+ " in Run...Acquired Lock");
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
		} /*catch (InterruptedException e1) {
			System.out.println("Thread " + Thread.currentThread().getName()
					+ " interuppted");
			return;
		}*/finally{
			System.out.println(Thread.currentThread().getName()+" Releasing the Lock");
			rlock.unlock();
			System.out.println(" The value of J is for Thread "+Thread.currentThread().getName()+ " : " + j);
			return;
		}
	}

}

public class ThreadInterruptMethod {
	public static void main(String args[]) {
		ReentrantLock rlock = new ReentrantLock();
		threadMethod objA = new threadMethod(rlock);
		Thread t1 = new Thread(objA, "T1");
		Thread t2 = new Thread(objA, "T2");
		t1.start();
		/*try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		t2.start();
		t1.interrupt();
		// t2.interrupt();
	}

}
