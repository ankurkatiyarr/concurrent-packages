package scheduled.executor.service;

public class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("MyRunnable started..");
		System.out.println("MyRunnable completed..");
	}
}
