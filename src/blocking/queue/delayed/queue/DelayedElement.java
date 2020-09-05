package blocking.queue.delayed.queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedElement implements Delayed {
	public int number;
	public long expireTime;

	public DelayedElement(int number, long delayTime) {
		this.number = number;
		expireTime = System.currentTimeMillis() + delayTime;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long t = expireTime - System.currentTimeMillis();
		return unit.convert(t, TimeUnit.MILLISECONDS);
	}

	@Override
	public int compareTo(Delayed o) {
		if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
			return -1;
		} else if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "DelayedElement [number=" + number + "]";
	}
}
