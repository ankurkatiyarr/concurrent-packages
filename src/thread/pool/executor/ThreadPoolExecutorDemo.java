package thread.pool.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorDemo {
	public static void main(String[] args) {
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
		
		Future<String> future = threadPoolExecutor.submit(() -> {
			System.out.println("random blah..");
			return "random blah..";
		});
		
		try {
			System.out.println("result: " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		threadPoolExecutor.shutdown();
	}
}
