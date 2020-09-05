package completable.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 
 * Run a task asynchronously and return the result using supplyAsync()
 *
 */
public class CFExample3SupplyAsyncMethod {
	public static void supplyAsyncExample() {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("Inside supplier get method..");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Supplier get method completed..");
			return "MyResult";
		});
		
		String result;
		try {
			result = completableFuture.get();
			System.out.println("result: " + result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		supplyAsyncExample();
	}
}
