package reentrant.read.write.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyCounter {
	ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private int counter = 0;
	
	public void increment() {
		try {
			readWriteLock.writeLock().lock();
			counter = counter + 1;
		} finally {
			readWriteLock.writeLock().unlock();
		}
	}
	
	public int getCounter() {
		try {
			readWriteLock.readLock().lock();
			return counter;
		} finally {
			readWriteLock.readLock().unlock();
		}
	}
}
