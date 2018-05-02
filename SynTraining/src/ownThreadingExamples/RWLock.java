package ownThreadingExamples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWLock {
	
	ReadWriteLock rwLock = new ReentrantReadWriteLock();
	
	
	public static void main(String args[])
	{
		ExecutorService exec = Executors.newFixedThreadPool(4);
		RWLock lockObj = new RWLock();
		for(int i=0;i<10;i++)
		{
			exec.submit(new Reader(lockObj.rwLock, i));
			exec.submit(new Writer(lockObj.rwLock, i));
		}
		exec.shutdown();
	}

}
