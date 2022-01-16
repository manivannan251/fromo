package lab;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Test1OddEvenPrint {
	private volatile Lock lock = new ReentrantLock();
	
	private volatile Condition condition = lock.newCondition();

	public void printOdd() throws InterruptedException {
	
			for (int i = 1; i < 10; i = i + 2) {
				lock.lock();
					System.out.println("Printing from odd method : " + i);
					condition.await();
					condition.signal();
				
				
			}
			condition.signal();
			lock.unlock();
			
			
		
	}

	public void printEven() throws InterruptedException {
		Thread.sleep(2000);
		
			for (int i = 2; i <= 10; i = i + 2) {
				lock.lock();
				System.out.println("Printing from Even method : " + i);
				condition.signal();
				condition.await();
				

			}
			lock.unlock();
			condition.signal();
		
	}
}

public class Test1OddEven {

	public static void main(String[] args) {
		Test1OddEvenPrint tp = new Test1OddEvenPrint();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					tp.printOdd();
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
					tp.printEven();
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
