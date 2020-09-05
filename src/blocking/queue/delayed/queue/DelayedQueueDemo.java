package blocking.queue.delayed.queue;

import java.util.Random;

public class DelayedQueueDemo {
	public static void main(String[] args) {
		QueueImpl queueImpl = new QueueImpl();
		
		// producer
		new Thread(() -> {
			while(true) {
				Random random = new Random();
				DelayedElement element = new DelayedElement(random.nextInt(), 4000);
				queueImpl.produce(element);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		// consumer
		new Thread(() -> {
			while(true) {
				queueImpl.consume();
			}
		}).start();
	}
}
