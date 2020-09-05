package callable.future.example;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
	@Override
	public String call() throws Exception {
		System.out.println("submiting callable thread..");
		Thread.sleep(5000);
		return "MyCallable ABC";
	}

}
