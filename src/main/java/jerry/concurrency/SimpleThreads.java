package jerry.concurrency;

import java.util.concurrent.TimeUnit;

public class SimpleThreads {
	static void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n", threadName, message);
	}
	private static class MessageLoop implements Runnable {

		@Override
		public void run() {
			String importantInfo[] = {
					"Mares eat oats",
					"Does eat oats",
					"Little lambs eat ivy",
					"A kid will eat ivy too"
			};
			try {
				for(int i = 0; i < importantInfo.length; i++) {
					TimeUnit.SECONDS.sleep(4);
					threadMessage(importantInfo[i]);
				}
			} catch(InterruptedException e) {
				threadMessage("I wasn't done!");
			}
		}
	}
	public static void main(String[] args) throws InterruptedException{
		long patient = 1000 * 60 * 60;
		if(args.length > 0) {
			try {
				patient = Long.parseLong(args[0]) * 1000;
			}catch(NumberFormatException e) {
				System.err.println("Argument must be an  integer.");
				System.exit(1);
			}
		}
		
		threadMessage("starting MessageLoop thread");
		long startTime = System.currentTimeMillis();
		Thread t = new Thread(new MessageLoop());
		t.start();
		threadMessage("Waiting for MessageLoop thread to finish");
		while(t.isAlive()) {
			threadMessage("Still waiting ...");
			t.join(1000);
			if(((System.currentTimeMillis() - startTime) > patient) && t.isAlive()) {
				threadMessage("Tired of waiting!");
				t.interrupt();
				t.join();
			}
	    }
		threadMessage("Finally!");
	}
}
