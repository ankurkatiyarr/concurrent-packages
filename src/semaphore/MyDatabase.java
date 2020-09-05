package semaphore;

import java.util.concurrent.Semaphore;

public class MyDatabase {
	private static MyDatabase INSTANCE = new MyDatabase();
	private int numberOfConnections;
	private Semaphore semaphore = new Semaphore(10, true);
	
	public static MyDatabase getConnnection() {
		return INSTANCE;
	}
	
	public void connect(String threadName) {
		try {
			semaphore.acquire();
			synchronized (this) {
				numberOfConnections = numberOfConnections + 1;
				System.out.println(threadName + " acquired connection, numberOfConnections now: "  + numberOfConnections);
			}
			Thread.sleep(1500);
			
			synchronized (this) {
				numberOfConnections = numberOfConnections - 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (semaphore != null) {
				semaphore.release();
			}
		}
	}
}
