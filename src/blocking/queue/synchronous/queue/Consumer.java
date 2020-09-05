package blocking.queue.synchronous.queue;

public class Consumer implements Runnable {
	Exchange exchange;

	public Consumer(Exchange exchange) {
		this.exchange = exchange;
	}

	@Override
	public void run() {
		while (true) {
			exchange.consume();
		}
	}
}
