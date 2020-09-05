package cyclic.barrier;

import java.util.concurrent.CyclicBarrier;

public class Passenger extends Thread {
	public String name;
	public long waitTime;
	public CyclicBarrier cyclicBarrier;
	
	public Passenger(String name, long waitTime, CyclicBarrier cyclicBarrier) {
		super(name);
		this.name = name;
		this.waitTime = waitTime;
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(waitTime);
			System.out.println(Thread.currentThread().getName() + " has arrived");
			int counter = cyclicBarrier.await();
			
			if (counter == 0) {
				System.out.println("All 4 passengers are onboard, starting the cab..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
