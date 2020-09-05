package producer.consumer.wait.notify;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable {
	private Queue<Integer> queue = new LinkedList<>();
	private int maxCapacity;

	public Producer(Queue<Integer> queue, int maxCapacity) {
		this.queue = queue;
		this.maxCapacity = maxCapacity;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				if (queue.size() == maxCapacity) {
					try {
						System.out.println("Queue is full, producer waiting..");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					Random random = new Random();
					int number = random.nextInt();
					System.out.println("produced: " + number);
					queue.add(number);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					queue.notifyAll();
				}
			}
		}
	}
}
