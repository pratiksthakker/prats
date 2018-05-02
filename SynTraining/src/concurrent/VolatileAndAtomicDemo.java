package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Atomic implements Runnable {

	public AtomicInteger atomicInt = new AtomicInteger(0);
	
	@Override
	public void run() {
		int sum= 0;
		Double sqrt;
		for (int i = 0; i < 500000; i++) {
			sum+=i;
			sqrt = Math.sqrt(Double.valueOf(sum));
			atomicInt.incrementAndGet();
		}
		//System.out.println("Atomic Thread "+Thread.currentThread().getName()+"completed .. count is : "+atomicInt);
	}

}

class Volatil implements Runnable {

	public volatile int count; 
	
	@Override
	public void run() {
		int sum= 0;
		Double sqrt;
		for (int i = 0; i < 500000; i++) {
			sum+=i;
			sqrt = Math.sqrt(Double.valueOf(sum));
			count++;
		}
		//System.out.println("Volatil Thread "+Thread.currentThread().getName()+"completed .. count is : "+count);
	}

}

public class VolatileAndAtomicDemo {

	public static void main(String args[]) throws InterruptedException {

		ExecutorService threadpool = Executors.newFixedThreadPool(5);
		Atomic AtomicObj = new Atomic();
		threadpool.submit(AtomicObj);
		threadpool.submit(AtomicObj);
		threadpool.submit(AtomicObj);
		threadpool.submit(AtomicObj);
		threadpool.submit(AtomicObj);
		/*Thread AtomicT = new Thread(AtomicObj,"AtomicT");
		Thread AtomicT1 = new Thread(AtomicObj,"AtomicT1");
		Thread AtomicT2 = new Thread(AtomicObj,"AtomicT2");
		Thread AtomicT3 = new Thread(AtomicObj,"AtomicT3");
		Thread AtomicT4 = new Thread(AtomicObj,"AtomicT4");
		AtomicT.start();
		AtomicT1.start();
		AtomicT2.start();
		AtomicT3.start();
		AtomicT4.start();*/
		Volatil volatilObj = new Volatil();
		threadpool.submit(volatilObj);
		threadpool.submit(volatilObj);
		threadpool.submit(volatilObj);
		threadpool.submit(volatilObj);
		threadpool.submit(volatilObj);
		threadpool.shutdown();
		threadpool.awaitTermination(10L, TimeUnit.SECONDS);
		System.out.println("Value of volatile should be 250000 and is : "+volatilObj.count);
		System.out.println("Value of Atomic should be 250000 and is  : "+AtomicObj.atomicInt.get());
		/*Thread Volatil = new Thread(volatilObj,"VolatileT");
		Thread Volatil1 = new Thread(volatilObj,"VolatileT1");
		Thread Volatil2 = new Thread(volatilObj,"VolatileT2");
		Thread Volatil3 = new Thread(volatilObj,"VolatileT3");
		Thread Volatil4 = new Thread(volatilObj,"VolatileT4");
		Volatil.start();
		Volatil1.start();
		Volatil2.start();
		Volatil3.start();
		Volatil4.start();*/
	}

	
	/*
	 * Output -
	 * Value of volatile should be 250000 and is : 204216
     * Value of Atomic should be 250000 and is  : 250000
	 */
}

