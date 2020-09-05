package blocking.queue.synchronous.queue;

import java.util.concurrent.SynchronousQueue;

public class Exchange {
	SynchronousQueue<Integer> queue = new SynchronousQueue<>();

	public void produce(int number) {
		try {
			System.out.println("producing.." + number);
			queue.put(number);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void consume() {
		try {
			System.out.println("consuming.." + queue.take());
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
