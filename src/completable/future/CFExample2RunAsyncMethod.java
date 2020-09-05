package completable.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * Running asynchronous computation using runAsync()
 *
 */
public class CFExample2RunAsyncMethod {
	public static void runAsyncExampleWithForkJoinPool() {
		CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
			System.out.println("run method of runnable started..");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("run method of runnable completed..");
		});
		
		try {
			completableFuture.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	public static void runAsyncExampleWithExecutorService() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		try {
			CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
				System.out.println("run method of runnable started..");
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("run method of runnable completed..");
			}, executorService);
			
			try {
				completableFuture.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		} finally {
			executorService.shutdown();
			try {
				executorService.awaitTermination(30, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("shutting down executor service..");
		}
	}
	
	public static void main(String[] args) {
//		runAsyncExampleWithForkJoinPool();
		runAsyncExampleWithExecutorService();
	}
}
