package completable.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 
 * Transforming and acting on a CompletableFuture
 *
 */
public class CFExample4ThenApplyMethod {
	public static void thenApplyExample() {
		CompletableFuture<String> firstNameCF = CompletableFuture.supplyAsync(() -> {
			System.out.println("Inside supplier get method..");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Supplier get method completed..");
			return "Ankur";
		});
		
		CompletableFuture<String> lastNameCF = firstNameCF.thenApply(firstName -> {
			System.out.println("Inside function apply method..");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Function apply method completed..");
			return firstName + " Katiyar";
		});
		
		try {
			String result = lastNameCF.get();
			System.out.println("result: " + result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void thenApplyExample2() {
		CompletableFuture<String> firstNameCF = CompletableFuture.supplyAsync(() -> {
			System.out.println("Inside supplier get method..");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Supplier get method completed..");
			return "Ankur";
		}).thenApply(firstName -> {
			return firstName + " Katiyar";
		}).thenApply(fullName -> {
			return "Hello " + fullName;
		});
		
		try {
			String result = firstNameCF.get();
			System.out.println("result: " + result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
//		thenApplyExample();
		thenApplyExample2();
	}
}
