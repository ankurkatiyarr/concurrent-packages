package completable.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * Using CompletableFuture as a Simple Future
 * source1: https://www.callicoder.com/java-8-completablefuture-tutorial/
 * source2: https://www.baeldung.com/java-completablefuture
 *
 */
public class CFExample1CompleteMethod {
	public static CompletableFuture<String> completeMethodInCompletableFuture() {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		try {
			executorService.submit(() -> {
				System.out.println("Callable call method started..");
				try {
					Thread.sleep(4000);
					completableFuture.complete("Ankur");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Callable call method completed..");
				return null;
			});
		} finally {
			executorService.shutdown();
			try {
				executorService.awaitTermination(30, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("shutting down executor service..");
		}
		return completableFuture;
	}
	
	public static void main(String[] args) {
		CompletableFuture<String> completableFuture = completeMethodInCompletableFuture();
		try {
			String result = completableFuture.get();
			System.out.println("result: " + result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println("further execution in main method..");
	}
}
