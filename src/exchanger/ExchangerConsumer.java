package exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerConsumer implements Runnable {
	private Exchanger<Integer> exchanger;
	
	public ExchangerConsumer(Exchanger<Integer> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		try {
			Integer consumedMsg = exchanger.exchange(1);
			System.out.println("consumedMsg: " + consumedMsg);
			Integer consumedMsg2 = exchanger.exchange(1);
			System.out.println("consumedMsg2: " + consumedMsg2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
}
