package producer.consumer.wait.notify;

import java.util.LinkedList;
import java.util.Queue;

public class Consumer implements Runnable {
	private Queue<Integer> queue = new LinkedList<>();

	public Consumer(Queue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				if (queue.size() == 0) {
					try {
						System.out.println("Queue is empty, consumer waiting..");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					Integer number = queue.remove();
					System.out.println("consumed: " + number);
					queue.notifyAll();
				}
			}
		}
	}
}
