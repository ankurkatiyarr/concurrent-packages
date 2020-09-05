package blocking.queue.linked.blocking.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueImpl {
	BlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();
	
	public void produce(int number) {
		System.out.println("producing.." + number);
		try {
			linkedBlockingQueue.put(number);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void consume() {
		try {
			System.out.println("Consuming.." + linkedBlockingQueue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
