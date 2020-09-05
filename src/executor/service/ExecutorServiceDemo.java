package executor.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
	static ExecutorService executorService1 = null;
	static ExecutorService executorService2 = null;
	
	public static void main(String[] args) {
		try {
			executorService1 = Executors.newFixedThreadPool(10);
			executorService2 = Executors.newFixedThreadPool(300);
			
			for (int i = 0; i < 300; i++) {
				String threadName = "Thread" + i;
				executorService2.execute(() -> {
					executorService1.execute(() -> {
						System.out.println(threadName + " started running..");
						try {
							Thread.sleep(1500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					});
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			executorService1.shutdown();
			executorService2.shutdown();
		}
	}
}
