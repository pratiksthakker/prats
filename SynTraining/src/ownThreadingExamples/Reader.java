package ownThreadingExamples;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Reader implements Runnable {

	ReadWriteLock rwLock = new ReentrantReadWriteLock();
	int i;
	
	public Reader(ReadWriteLock rwLock, int i) {		
		this.rwLock = rwLock;
		this.i = i;
	}
	
	@Override
	public void run() {
		
		System.out.println("Reader " +i+" trying to get the lock ......");
		rwLock.readLock().lock();
		System.out.println("Reader "+i+" got the lock .... reading now ......");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Reader " +i+" completed Reading ....");
		rwLock.readLock().unlock();
				

	}

}
