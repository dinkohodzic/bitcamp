package ba.bitcamp.lectures;

import java.util.concurrent.*;

public class ExecutorExample {

	public static void runExample() {

		ExecutorService es = Executors.newFixedThreadPool(5);

		es.submit(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

				}
				es.submit(new Runnable() {
					
					@Override
					public void run() {
						System.out.println("Prvi task");
						
					}
				});
				es.submit(new Runnable() {
					
					@Override
					public void run() {
						System.out.println("Drugi task");
						
					}
				});
				es.shutdown();
			}

		});
	}

}
