package ba.bitcamp.lectures;

import java.util.concurrent.CountDownLatch;

public class LatchExample {

	private static CountDownLatch latch = new CountDownLatch(3);

	public static void startExample() {

		new Thread(new Runnable() {
			public void run() {
				try {
					latch.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("The waiting thread can work");
			}
		}).start();

		latch.countDown();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		latch.countDown();
		latch.countDown();
		

	}

}
