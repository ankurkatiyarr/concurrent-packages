package lock.condition;

import java.util.Random;
import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerImpl {
	Stack<Integer> stack = new Stack<>();
	Random random = new Random();
	Lock lock = new ReentrantLock();
	Condition stackEmptyCondition = lock.newCondition();
	Condition stackFullCondition = lock.newCondition();
	int capacity = 1;
	
	public void produce() throws InterruptedException {
		try {
			lock.lock();
			if (stack.size() == capacity) {
				stackFullCondition.await();
			}
			
			int number = random.nextInt();
			System.out.println("produced: " + number);
			stack.push(number);
			
			stackEmptyCondition.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	public void consume() throws InterruptedException {
		try {
			lock.lock();
			
			if (stack.size() == 0) {
				stackEmptyCondition.await();
			}
			
			int number = stack.pop();
			System.out.println("consumed: " + number);
			
			stackFullCondition.signalAll();
//			Thread.sleep(100);
		} finally {
			lock.unlock();
		}
	}
}
