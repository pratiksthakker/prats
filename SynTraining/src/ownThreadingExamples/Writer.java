package ownThreadingExamples;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Writer implements Runnable {
	
	ReadWriteLock rwLock = new ReentrantReadWriteLock();
	int i;
	
	public Writer(ReadWriteLock rwLock, int i) {		
		this.rwLock = rwLock;
		this.i = i;
	}

	@Override
	public void run() {
		
		System.out.println("Writer " +i+" trying to get the lock ......");
		rwLock.writeLock().lock();
		System.out.println("Writer "+i+" got the lock .... writing now ......");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Writer " +i+" completed writing ....");
		rwLock.writeLock().unlock();

	}

}
