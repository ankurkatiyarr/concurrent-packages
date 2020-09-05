package count.down.latch;

import java.util.concurrent.CountDownLatch;

public class DeveloperThread implements Runnable {
	CountDownLatch countDownLatch;
	long sleepTime;

	public DeveloperThread(CountDownLatch countDownLatch, long sleepTime) {
		this.countDownLatch = countDownLatch;
		this.sleepTime = sleepTime;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " started working at " + System.currentTimeMillis());
			Thread.sleep(sleepTime);
			countDownLatch.countDown();
			System.out.println(Thread.currentThread().getName() + " finished working at " + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
