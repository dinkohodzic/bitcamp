package ba.bitcamp.exercises;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Task2 {
	static Integer fileCounter = 0;
	static Integer folderCounter = 0;
	private static ArrayList<Worker> workers;
	private static LinkedBlockingQueue<Task> queue;
	private static Object lock = new Object();

	public static void main(String[] args) {
		File f = new File("/Users/dinko.hodzic/");
		queue = new LinkedBlockingQueue<>();
		Task t = new Task(f);
		queue.add(t);

		workers = new ArrayList<>();

		for (int i = 0; i < 8; i++) {
			Worker w = new Worker();
			w.start();
			workers.add(w);
		}

		for (Worker w : workers) {
			try {
				w.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Files: " + fileCounter);
		System.out.println("Folders: " + folderCounter);

	}

	static class Task implements Runnable {

		File root;

		public Task(File root) {
			this.root = root;
		}

		@Override
		public void run() {
			try {
				for (File f : root.listFiles()) {
					if (f.isFile()) {
						synchronized (lock) {
							fileCounter++;
						}

					}
					if (f.isDirectory()) {
						synchronized (lock) {
							folderCounter++;
						}

						queue.add(new Task(f));

					}
				}
			} catch (NullPointerException e) {
				return;
			}
		}
	}

	static class Worker extends Thread {
		@Override
		public void run() {
			while (!queue.isEmpty()) {
				try {
					Task t = queue.take();
					t.run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
