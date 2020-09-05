package exchanger;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ExchangerProducer implements Runnable {
	private Exchanger<Integer> exchanger;
	
	public ExchangerProducer(Exchanger<Integer> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		try {
			Random random = new Random();
			int val = random.nextInt();
			System.out.println("producing: " + val);
			exchanger.exchange(random.nextInt());
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
