package ownThreadingExamples;

public class ProducerConsumerOwn {

	public static void main(String[] args) {
		
		Factory objF = new Factory();
		Runnable producer = new producer(objF);
		Runnable consumer = new consumer(objF);
		Thread consT = new Thread(consumer);
		Thread prodT = new Thread(producer);
		
		consT.start();
		prodT.start();
		

	}

}


class Factory{
	
	int a;
	public synchronized void produce() throws InterruptedException
	{
		notify();
		if(a>20)
		{
			System.out.println("producer waiting ");
			wait();
		}
		System.out.println("produced " + ++a);
		Thread.sleep(300);
	}
	
	public synchronized void consume() throws InterruptedException
	{
		notify();
		if(a==0)
		{
			System.out.println("Consumer waiting ");
			wait();
		}
		System.out.println("Consumed " + a--);
		Thread.sleep(300);
		//notify();
	}
}


class producer implements Runnable{

	Factory objF = new Factory();	
	public producer(Factory objF)
	{
		this.objF = objF;
	}
	@Override
	public void run() {
		try {
			while(true)
			{
				objF.produce();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
		
	
}

class consumer implements Runnable{

	Factory objF = new Factory();	
	public consumer(Factory objF)
	{
		this.objF = objF;
	}
	@Override
	public void run() {
		try {
			while(true)
			{
				objF.consume();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
		
	
}
