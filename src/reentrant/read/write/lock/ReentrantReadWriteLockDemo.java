package reentrant.read.write.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ReentrantReadWriteLockDemo {
	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		MyCounter myCounter = new MyCounter();
		
		for (int i = 0; i < 1000000; i++) {
			executorService.execute(() -> {
				myCounter.increment();
			});
		}
		
		executorService.awaitTermination(5, TimeUnit.SECONDS);
		System.out.println(myCounter.getCounter());
		
		executorService.shutdown();
	}
}
