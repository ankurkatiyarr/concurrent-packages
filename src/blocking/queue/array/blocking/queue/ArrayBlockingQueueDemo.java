package blocking.queue.array.blocking.queue;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArrayBlockingQueueDemo {
	static QueueImpl queueImpl = new QueueImpl();
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		// producer
		executorService.execute(() -> {
			while (true) {
				Random random = new Random();
				int number = random.nextInt();
				queueImpl.produce(number);
			}
		});
		
		// consumer
		executorService.execute(() -> {
			while (true) 
				queueImpl.consume();
		});
	}
}
