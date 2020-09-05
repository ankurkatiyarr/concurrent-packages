package blocking.queue.delayed.queue;

import java.util.concurrent.DelayQueue;

public class QueueImpl {
	DelayQueue<DelayedElement> delayQueue = new DelayQueue<>();
	
	public void produce(DelayedElement delayedElement) {
		System.out.println("producing.." + delayedElement);
		delayQueue.put(delayedElement);
	}
	
	public void consume() {
		try {
			DelayedElement element = delayQueue.take();
			System.out.println("consumed: " + element);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
