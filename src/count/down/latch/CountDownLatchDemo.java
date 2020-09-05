package count.down.latch;

import java.util.concurrent.CountDownLatch;

/**
 * Problem statement:
 * QA thread will wait until two development teams are done with the job.
 *
 */
public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(2);
		
		// payments dev thread
		Thread paymentsThread = new Thread(new DeveloperThread(countDownLatch, 4000));
		paymentsThread.setName("payments dev");
		paymentsThread.start();
		
		// transactions dev thread
		Thread transactionsThread = new Thread(new DeveloperThread(countDownLatch, 8000));
		transactionsThread.setName("transactions dev");
		transactionsThread.start();
		
		countDownLatch.await();
		
		// QA thread
		Thread qaThread = new Thread(new QAThread());
		qaThread.setName("qaThread");
		qaThread.start();
		
	}
}
