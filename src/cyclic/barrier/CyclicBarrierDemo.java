package cyclic.barrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Problem Statement: A cab will wait until all 4 passengers have arrived.
 * 
 */
public class CyclicBarrierDemo {
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

		Passenger passenger1 = new Passenger("Ankur", 1000, cyclicBarrier);
		Passenger passenger2 = new Passenger("Shalu", 2000, cyclicBarrier);
		Passenger passenger3 = new Passenger("Rajat", 4000, cyclicBarrier);
		Passenger passenger4 = new Passenger("Shivam", 8000, cyclicBarrier);
		
		Passenger passenger5 = new Passenger("Rishabh", 2000, cyclicBarrier);
		Passenger passenger6 = new Passenger("Simran", 3000, cyclicBarrier);
		Passenger passenger7 = new Passenger("Sonam", 4000, cyclicBarrier);
		Passenger passenger8 = new Passenger("Chintu", 5000, cyclicBarrier);
		
		passenger1.start();
		passenger2.start();
		passenger3.start();
		passenger4.start();
		passenger5.start();
		passenger6.start();
		passenger7.start();
		passenger8.start();
	}
}
