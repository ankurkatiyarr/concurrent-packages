package blocking.queue.array.blocking.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class QueueImpl {
	ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10, true);
	
	public void produce(int number) {
		System.out.println("producing.." + number);
		try {
			arrayBlockingQueue.put(number);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void consume() {
		try {
			System.out.println("consuming.." + arrayBlockingQueue.take());
 			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
