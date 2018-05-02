package threading;

public class ThreadState {

	public static void main(String[] args) {

		Message message = new Message("Msg update sequece");

		Waiter waiter1 = new Waiter(message);

		Waiter waiter2 = new Waiter(message);

		Waiter waiter3 = new Waiter(message);

		Thread waiterThread1 = new Thread(waiter1, "waiterThread1");

		waiterThread1.start();

		Thread waiterThread2 = new Thread(waiter2, "waiterThread2");

		waiterThread2.start();

		Thread waiterThread3 = new Thread(waiter3, "waiterThread3");

		waiterThread3.start();

		Notifier notifier = new Notifier(message);

		Thread notifierThread = new Thread(notifier, "notifierThread");

		notifierThread.start();

		while (true) {

			try {

				Thread.sleep(50);

			} catch (InterruptedException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

			System.out.println("Waiter thread1 ->" + waiterThread1.getState());

			System.out.println("Waiter thread2 ->" + waiterThread2.getState());

			System.out.println("Waiter thread3 ->" + waiterThread3.getState()

			+ "\n");

		}

	}

}

class Message {

	private String text;

	public Message(String text) {

		this.text = text;

	}

	public String getText() {

		return text;

	}

	public void setText(String text) {

		this.text = text;

	}

}

class Waiter implements Runnable {

	Message message;

	public Waiter(Message message) {

		this.message = message;

	}

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName() + " started");

		synchronized (message) {

			try {

				message.wait();

				// ???

				System.out.println(Thread.currentThread().getName()

				+ " after wait ");

				System.out.println(Thread.currentThread().getName()

				+ message.getText());

				message.setText(message.getText() + " -> "

				+ Thread.currentThread().getName());

				Thread.currentThread().sleep(500);// timed waiting

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}

		System.out.println(Thread.currentThread().getName() + " Completed\n");

	}

}

class Notifier implements Runnable {

	Message message;

	public Notifier(Message message) {

		this.message = message;

	}

	@Override
	public void run() {

		System.out.println("i am notifier");

		System.out.println(Thread.currentThread().getName() + " started");

		try {

			Thread.currentThread().sleep(1000);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

		synchronized (message) {

			try {

				Thread.currentThread().sleep(1000);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

			message.setText(message.getText() + " : "

			+ Thread.currentThread().getName());

			message.notifyAll();

			// message.notify();

		}

		System.out.println("nn" + Thread.currentThread().getName()

		+ " Completed");

		System.out.println("notifyall completed");

	}

}
