package ownThreadingExamples;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

class incrementer {
	private volatile int count = 0;

	public synchronized int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public synchronized int increment() {
		System.out.println("Before : " + count);
		count++;
		System.out.println("After : " + count);
		return count;
	}
}

class CallableTask implements Callable<Integer> {

	public CallableTask(incrementer inc) {
		super();
		this.inc = inc;
	}

	incrementer inc;

	@Override
	public Integer call() throws Exception {
		return inc.increment();
	}

}

class RunnableTask implements Runnable {

	public RunnableTask(incrementer inc) {
		super();
		this.inc = inc;
	}

	incrementer inc;

	@Override
	public void run() {
		inc.increment();
	}

}

public class CallableDemo {

	public static void main(String args[]) {
		ExecutorService poolexc = Executors.newFixedThreadPool(2);
		incrementer inc = new incrementer();
		Integer val = 0;
		Callable<Integer> callableTsk = new CallableTask(inc);
		Runnable runnableTsk = new RunnableTask(inc);

		try {
			Future<incrementer> fInc = poolexc.submit(runnableTsk, inc);
			System.out.println("After runnable : result " + inc.getCount()
					+ " And Future : " + fInc.get().getCount());
			Future<Integer> fInc1 = poolexc.submit(callableTsk);
			System.out.println("After callable Future : " + fInc1.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		poolexc.shutdown();

	}
}
