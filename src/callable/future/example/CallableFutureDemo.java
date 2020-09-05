package callable.future.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureDemo {
	// Basic example
	public static void example1() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<String> future = executorService.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("submiting callable..");
				Thread.sleep(3000);
				return "ABC";
			}
		});
		
		boolean isCallableDone = future.isDone(); // does not wait for the result, gives the current status
		System.out.println("isCallableDone1: " + isCallableDone);
		
		try {
			System.out.println(future.get()); // will wait for the result
		} catch (InterruptedException | ExecutionException e1) {
			e1.printStackTrace();
		}
		
		executorService.shutdown();
	}

	// Using lambda
	public static void example2() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<String> future = executorService.submit(() -> {
			Thread.sleep(3000);
			return "ABC";
		});
		
		try {
			System.out.println("result: " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		executorService.shutdown();
	}
	
	// custom Callable.Class
	public static void example3() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<String> future = executorService.submit(new MyCallable());
		
		try {
			System.out.println("result: " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		executorService.shutdown();
	}

	// invokeAny Method
	public static void example4() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Set<Callable<String>> callables = new HashSet<>();
		
		Callable<String> callable1 = new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("in callable1");
				return "callable1";
			}
		};
		callables.add(callable1);
		
		Callable<String> callable2 = new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("in callable2");
				return "callable2";
			}
		};
		callables.add(callable2);
		
		Callable<String> callable3 = new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("in callable3");
				return "callable3";
			}
		};
		callables.add(callable3);
		
		try {
			String result = executorService.invokeAny(callables);
			System.out.println("result: " + result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		executorService.shutdown();
	}
	
	// invokeAll Method
	public static void example5() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Set<Callable<String>> callables = new HashSet<>();
		
		Callable<String> callable1 = new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("in callable1");
				Thread.sleep(10000);
				return "callable1";
			}
		};
		callables.add(callable1);
		
		Callable<String> callable2 = new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("in callable2");
				Thread.sleep(1000);
				return "callable2";
			}
		};
		callables.add(callable2);
		
		Callable<String> callable3 = new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("in callable3");
				Thread.sleep(5000);
				return "callable3";
			}
		};
		callables.add(callable3);
		
		List<Future<String>> futures = null;
		try {
			futures = executorService.invokeAll(callables);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (Future<String> future : futures) {
			try {
				System.out.println("result: " + future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		executorService.shutdown();
	}	
	
	public static void main(String[] args) {
//		example1();
//		example2();
//		example3();
//		example4();
		example5();
	}
}
