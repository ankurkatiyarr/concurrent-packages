package lock.reentrant.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyCounter {
	private int counter = 0;
	Lock lock = new ReentrantLock();
	
	public void increment() {
		lock.lock();
		counter = counter + 1;
		lock.unlock();
	}
	
	public int getCounter() {
		return counter;
	}
}
