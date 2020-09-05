package lock.condition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConditionDemo {
	public static void main(String[] args) {
		ProducerConsumerImpl producerConsumerImpl = new ProducerConsumerImpl();
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		while (true) {
			// producer thread
			executorService.execute(() -> {
				try {
					producerConsumerImpl.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
			
			// consumer thread
			executorService.execute(() -> {
				try {
					producerConsumerImpl.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}

	}
}
