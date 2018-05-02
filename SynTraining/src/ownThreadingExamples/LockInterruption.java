package ownThreadingExamples;

import java.util.concurrent.locks.ReentrantLock;

class criticalClass {
	ReentrantLock rlock = new ReentrantLock();
	ReentrantLock rlock1 = new ReentrantLock();
	Integer in;

	public void updateInt(int i) {
		try {
			int count = 0;
			System.out.println(Thread.currentThread().getName()
					+ " Trying to acquire Lock");
			rlock.lockInterruptibly();
			System.out.println("Lock acquired by Thread : "
					+ Thread.currentThread().getName());
			while (true) {
				count++;
				if (count > 1000000) {
					break;
				}
			}
			System.out.println(Thread.currentThread().getName()
					+ " Trying to acquire Lock1");
			rlock1.lockInterruptibly();
			System.out.println("Lock1 acquired by Thread : "
					+ Thread.currentThread().getName());
			System.out.println("Value getting initialized by  "
					+ Thread.currentThread().getName());
			in = i;
		} catch (InterruptedException e) {
			System.out.println("Lock interrupted for : "
					+ Thread.currentThread().getName());
		} finally {
			System.out.println("Lock1 Released by : "
					+ Thread.currentThread().getName());
			rlock1.unlock();
			System.out.println("Lock Released by : "
					+ Thread.currentThread().getName());
			rlock.unlock();
		}
	}
	public void updateInt1(int i) {
		try {
			int count = 0;
			System.out.println(Thread.currentThread().getName()
					+ " Trying to acquire Lock1");
			rlock1.lockInterruptibly();
			System.out.println("Lock1 acquired by Thread : "
					+ Thread.currentThread().getName());
			while (true) {
				count++;
				if (count > 1000000) {
					break;
				}
			}
			System.out.println(Thread.currentThread().getName()
					+ " Trying to acquire Lock");
			rlock.lockInterruptibly();
			System.out.println("Lock acquired by Thread : "
					+ Thread.currentThread().getName());
			System.out.println("Value getting initialized by  "
					+ Thread.currentThread().getName());
			in = i;
		} catch (InterruptedException e) {
			System.out.println("Lock interrupted for : "
					+ Thread.currentThread().getName());
		} finally {
			System.out.println("Lock Released by : "
					+ Thread.currentThread().getName());
			rlock.unlock();
			System.out.println("Lock1 Released by : "
					+ Thread.currentThread().getName());
			rlock1.unlock();
		}
	}
}

class interruption implements Runnable {

	criticalClass ccObj;
	int value;

	public interruption(criticalClass ccObj,int i) {
		super();
		value=i;
		this.ccObj = ccObj;
	}

	@Override
	public void run() {
		System.out.println("In run() Method "
				+ Thread.currentThread().getName());
		ccObj.updateInt(value);
	}

}
class interruption1 implements Runnable {

	criticalClass ccObj;
	int value;

	public interruption1(criticalClass ccObj,int i) {
		super();
		value=i;
		this.ccObj = ccObj;
	}

	@Override
	public void run() {
		System.out.println("In run() Method1 "
				+ Thread.currentThread().getName());
		ccObj.updateInt1(value);
	}

}

public class LockInterruption {
	
	public static void main(String args[])
	{
		criticalClass ccObj = new criticalClass();
		interruption in = new interruption(ccObj, 200);
		Thread t1 = new Thread(in, "T1");
		interruption1 in1 = new interruption1(ccObj, 500);
		Thread t2 = new Thread(in, "T2");
		t1.start();
		t2.start();
		t1.interrupt();
		
	}

}
