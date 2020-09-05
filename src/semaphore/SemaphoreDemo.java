package semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Implement Database connection pool with 300 connections trying to connect the
 * database but only 10 threads get access to the database at a time.
 *
 */
public class SemaphoreDemo {
	public static void main(String[] args) {
		ExecutorService executorService = null;
		try {
			executorService = Executors.newFixedThreadPool(300);

			// 300 threads trying to connect to the database
			for (int i = 0; i < 300; i++) {
				String threadName = "Thread" + (i + 1);
				executorService.execute(() -> {
					MyDatabase.getConnnection().connect(threadName);
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (executorService != null) {
				executorService.shutdown();
			}
		}
	}
}
