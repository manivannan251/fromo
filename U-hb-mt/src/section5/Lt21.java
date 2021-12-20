package section5;

import java.util.ArrayList;
import java.util.List;

class Lt21Processor {
	private List<Integer> list = new ArrayList<>();
	private int UPPER_LIMIT = 5;
	private int LOWER_LIMIT = 0;
	private int value = 0;
	private Object lock = new Object();

	public void produce() throws InterruptedException {
		synchronized (lock) {
			while (true) {
				if (list.size() == UPPER_LIMIT) {
					System.out.println("Waiting for removing items");
					lock.wait();
				} else {
					System.out.println("Adding item to list :" + value);
					list.add(value);
					value++;
					lock.notify();

				}
				Thread.sleep(500);
			}

		}
	}

	public void consume() throws InterruptedException {
		synchronized (lock) {
			while (true) {
				if (list.size() == LOWER_LIMIT) {
					System.out.println("Waiting for adding items");
					value = 0;
					lock.wait();
				} else {
					System.out.println("Removing list from list :" + list.remove(list.size() - 1));

					lock.notify();

				}
				Thread.sleep(500);
			}

		}
	}
}

public class Lt21 {

	public static void main(String[] args) {
		Lt21Processor process = new Lt21Processor();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					process.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					process.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		t1.start();
		t2.start();

	}

}
