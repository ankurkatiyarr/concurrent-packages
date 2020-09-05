package lock.reentrant.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ReentrantLockDemo {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		MyCounter myCounter = new MyCounter();

		System.out.println("starting..");
		for (int i = 0; i < 1000000; i++) {
			executorService.execute(() -> {
				myCounter.increment();
			});
		}
		
		try {
			executorService.awaitTermination(5000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(myCounter.getCounter());
		executorService.shutdown();
	}
}
