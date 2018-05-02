package threading;

import java.util.LinkedList;

public class ThreadPoolDemo {

	public static void main(String[] args) {

		// Assign your own thread pool size

		int poolMaxSize = 2;

		// Creating Threadpool with the thread size given above

		MyThreadPool threadPool = new MyThreadPool(poolMaxSize);

		// Creating threadpool Object

		CreatePrcoss obj = new CreatePrcoss();

		int taskNo = 1;

		while (true) {

			Runnable task = obj.startProcess(taskNo);

			threadPool.process(task, taskNo);

			taskNo++;

			if (taskNo > 10)

				break;

		}

		// Finally waiting for all thread to complete its process

		threadPool.join();

		// System.out.println("Main over");

	}

}

// Thread pool logic by extending ThreadGroup

class MyThreadPool extends ThreadGroup {

	private boolean active = false;

	private LinkedList<Runnable> qList = null;

	private static int i;

	private Thread t[];

	public MyThreadPool(int poolMaxSize) {

		super("Pool - " + i++);

		setDaemon(true);

		active = true;

		t = new Thread[poolMaxSize];

		qList = new LinkedList<Runnable>();

		for (int i = 0; i < poolMaxSize; i++) {

			t[i] = new PooledThread(MyThreadPool.this, i + 1);

			// t[i].start();

			try {

				Thread.sleep(1000);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}

		for (int i = 0; i < poolMaxSize; i++) {

			t[i].start();

		}

	}// Constructor End

	public synchronized void process(Runnable task, int taskNo) {

		if (!active) {

			throw new IllegalStateException();

		}

		// Adding Thread in Pool

		if (task != null) {

			try {

				Thread.sleep(100);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

			System.out.println("TaskNo " + taskNo

			+ " is adding to Thread Queue/ThreadPool ");

			qList.add(task);

			notify();// Giving signal to Other Thread done My work

		}

	}

	public synchronized Runnable getTask() throws InterruptedException {

		while (qList.size() == 0) {

			if (!active) {

				return null;

			}

			// Releasing Lock

			wait();

		}

		System.out.println("Getting thread From Queue = "

		+ Thread.currentThread().getName());

		return (Runnable) qList.removeFirst();// Getting stored Runnable Task

		// from Pool

	}

	// Returns total Count of Runnable task in Pool

	protected int getTaskListSize() {

		return qList.size();

	}

	public void join() {

		synchronized (this) {

			active = false;

			notifyAll();

		}

	}

	public synchronized void close() {

		if (active) {

			active = false;

			qList.clear();

			// interrupt();

		}

	}

}// End of class TreadPool guest

// This thread is in the queue

class PooledThread extends Thread {

	// private int tId = 0;

	private MyThreadPool myThreadPool;

	public PooledThread(MyThreadPool classz, int tId) {

		// super(classz, "Runnable Task " + (tId));

		super("Thread No " + tId);

		myThreadPool = classz;

		System.out.println("PooledThread");

	}

	public void run() {

		System.out.println("run->PooledThread");

		while (!isInterrupted()) {

			Runnable process = null;

			try {

				// Getting Runnable Thread/Task From Pool

				process = myThreadPool.getTask();

			} catch (InterruptedException ex) {

			}

			if (process == null) {

				return;

			}

			try {

				// Processing the Task

				process.run();

			} catch (Throwable t) {

				// uncaughtException(this, t);

			}

		}

	}

}

class CreatePrcoss {

	public Runnable startProcess(final int taskID) {

		return new Runnable() {

			public void run() {

				System.out.println("run->CreatePrcoss" + "for taskid: "

				+ taskID);

				System.out.println("Task " + taskID + ": Start");

				// Putting each task to wait for 1000 milliseconds

				System.out.println("Business Logic: Finding double value of "

				+ taskID + " is = " + getTwice(taskID));

				try {

					Thread.sleep(1000);

				} catch (InterruptedException ex) {

				}

				System.out.println("Task " + taskID + ": End");

			}

		};

		// return new Thread();

	}

	private int getTwice(int value) {

		// one left shift will double the value

		value = value << 1;

		return value;

	}

}
