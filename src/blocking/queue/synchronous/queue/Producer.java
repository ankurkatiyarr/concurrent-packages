package blocking.queue.synchronous.queue;

import java.util.Random;

public class Producer implements Runnable {
	Exchange exchange;

	public Producer(Exchange exchange) {
		this.exchange = exchange;
	}

	@Override
	public void run() {
		while (true) {
			Random random = new Random();
			int number = random.nextInt();
			exchange.produce(number);
		}
	}
}
