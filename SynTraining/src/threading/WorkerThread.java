package threading;

import java.util.Map;

/**
 * WorkerThread
 * 
 * 
 */
public class WorkerThread implements Runnable {

	private Map<String, Integer> map = null;

	public WorkerThread(Map<String, Integer> assignedMap) {
		this.map = assignedMap;

	}

	@Override
	public void run() {

		for (int i = 0; i < 5000; i++) {
			// Return 2 integers between 1-1000000 inclusive
			Integer newInteger1 = (int) Math.ceil(Math.random() * 1000000);
			Integer newInteger2 = (int) Math.ceil(Math.random() * 1000000);

			// 1. Attempt to retrieve a random Integer element
			System.out.println("Trying to get");
			Integer retrievedInteger = map.get(String.valueOf(newInteger1));
			System.out.println("Got : "+retrievedInteger);

			// 2. Attempt to insert a random Integer element
			System.out.println("Trying to set");
			map.put(String.valueOf(newInteger2), newInteger2);
			System.out.println("set Completed");
		}
	}

}