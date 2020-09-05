package count.down.latch;

public class QAThread implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " started working at " + System.currentTimeMillis());
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " finished working at " +  + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
