package exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
	public static void main(String[] args) {
		Exchanger<Integer> exchanger = new Exchanger<>();
		new Thread(new ExchangerProducer(exchanger)).start();
		new Thread(new ExchangerConsumer(exchanger)).start();
	}
}
