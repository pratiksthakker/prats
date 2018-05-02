package ownThreadingExamples;

class dominant implements Runnable {

	Thread workerT;

	public dominant(Thread workerT) {
		super();
		this.workerT = workerT;
	}

	@Override
	public void run() {

		for (int i = 0; i < 200; i++) {
			System.out.println("Dominant Thread Count - " + i);
			if (i == 2) {
				System.out.println("Dominant Thread interrupting......");
				workerT.interrupt();
			}
		}
		System.out.println("Dominant Thread Ended......");
	}

}

class worker implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i < 1000; i++) {
			System.out.println("worker Thread Count - " + i);
			if (Thread.interrupted()) {
				System.out.println("Worker Thread interrupted......");
				return;
			}
		}
		System.out.println("Worker Thread Ended......");
	}

}

public class ThreadInterruption {

	public static void main(String args[]) {

		Thread workerT = new Thread(new worker());

		Thread domThread = new Thread(new dominant(workerT));
		domThread.start();
		workerT.start();
	}

}
