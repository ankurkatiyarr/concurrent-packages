package producer.consumer.wait.notify;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerRunner {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		int maxCapacity = 1;
		
		new Thread(new Producer(queue, maxCapacity)).start();
		new Thread(new Consumer(queue)).start();
	}
}
