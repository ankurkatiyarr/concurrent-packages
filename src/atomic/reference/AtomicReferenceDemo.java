package atomic.reference;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {
	private AtomicReference<Integer> studentAtomicReference = new AtomicReference<>(0);
	
	public void increment() {
		int result = studentAtomicReference.updateAndGet((val) -> {
			return val + 10;
		});
		System.out.println("result: " + result);
	}
	
	public static void main(String[] args) {
		AtomicReferenceDemo atomicReferenceDemo = new AtomicReferenceDemo();
		atomicReferenceDemo.increment();
		atomicReferenceDemo.increment();
	}
}
