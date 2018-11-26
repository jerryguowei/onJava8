package jerry.concurrency;

import java.util.Random;

public class Consumer implements Runnable {
	private Drop drop;
	public Consumer(Drop drop) {
		this.drop = drop;
	}
	@Override
	public void run() {
		Random rand = new Random();
		for(String message = drop.take();!message.equals("DONE"); message = drop.take()) {
			System.out.format("Message Received: %s%n",message);
			try {
				Thread.sleep(rand.nextInt(5000));
			}catch (InterruptedException e) {
			}
		}
	}

}
