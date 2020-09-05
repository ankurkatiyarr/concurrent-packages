package thread.local;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class ThreadLocalDemo {
	
	// Here 1000 instances of SimpleDateFormat will be used, too much memory
	public static void example1() {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		for (int i = 0; i < 1000; i++) {
			String threadName = "Thread" + i;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.S");
			
			executorService.execute(() -> {
				System.out.println(threadName + " printed: " + simpleDateFormat.format(new Date()));
			});
		}
		
		executorService.shutdown();
	}

	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.S");

	// Here only one simpleDateFormat is used but it is not thread safe.
	public static void example2() {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		for (int i = 0; i < 1000; i++) {
			String threadName = "Thread" + i;
			executorService.execute(() -> {
				System.out.println(threadName + " printed: " + simpleDateFormat.format(new Date()));
			});
		}
		
		executorService.shutdown();
	}

	// Using thread pool to avoid above problems
	public static void example3() {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
			@Override
			protected SimpleDateFormat initialValue() {
				return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.S");
			}
		};
		
		for (int i = 0; i < 1000; i++) {
			String threadName = "Thread" + i;
			executorService.execute(() -> {
				System.out.println(threadName + " printed: " + threadLocal.get().format(new Date()));
			});
		}
		
		executorService.shutdown();
	}
	
	// Using thread pool with Supplier Functional Interface
	public static void example4() {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(new Supplier<SimpleDateFormat>() {
			@Override
			public SimpleDateFormat get() {
				return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.S");
			}
		});
		
		for (int i = 0; i < 1000; i++) {
			String threadName = "Thread" + i;
			executorService.execute(() -> {
				System.out.println(threadName + " printed: " + threadLocal.get().format(new Date()));
			});
		}
		
		executorService.shutdown();
	}
	
	// Using thread pool with Supplier Functional Interface and lambda
	public static void example5() {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> {
			return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.S");
		});
		
		for (int i = 0; i < 1000; i++) {
			String threadName = "Thread" + i;
			executorService.execute(() -> {
				System.out.println(threadName + " printed: " + threadLocal.get().format(new Date()));
			});
		}
		
		executorService.shutdown();
	}
	
	public static void main(String[] args) {
		example5();
	}
}
