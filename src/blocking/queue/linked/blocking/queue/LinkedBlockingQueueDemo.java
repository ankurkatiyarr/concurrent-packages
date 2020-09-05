package blocking.queue.linked.blocking.queue;

import java.util.Random;

public class LinkedBlockingQueueDemo {
	public static void main(String[] args) {
		LinkedBlockingQueueImpl linkedBlockingQueueImpl = new LinkedBlockingQueueImpl();
		
		// producer
		new Thread(() -> {
			while (true) {
				Random random = new Random();
				linkedBlockingQueueImpl.produce(random.nextInt());
			}
		}).start();
		
		// consumer
		new Thread(() -> {
			while(true) {
				linkedBlockingQueueImpl.consume();
			}
		}).start();
	}
}
