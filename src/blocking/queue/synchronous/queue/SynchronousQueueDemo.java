package blocking.queue.synchronous.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * a) SynchronousQueue is a blocking queue with size 0. Direct HandOff
 * b) After putting the element in the queue, producer thread will get blocked because
 * it will wait for the consumer thread to consume the message.
 * c) No peek method because size
 * d) No iterate method
 * 
 */
public class SynchronousQueueDemo {
	static Exchange exchange = new Exchange();
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(new Producer(exchange));
		executorService.execute(new Consumer(exchange));
	}
}
