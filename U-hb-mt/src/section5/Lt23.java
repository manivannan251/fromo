package section5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Lt23Worker {
	
	private Lock lock = new ReentrantLock();
	
	private Condition condition = lock.newCondition();
	
	public void produce() throws InterruptedException {
		lock.lock();
		System.out.println("Inside Producer Method");
		condition.await();
		System.out.println("Again Inside Producer Mthod");
		lock.unlock();
	}
	
	public void consume() throws InterruptedException {
		Thread.sleep(2000);
		lock.lock();
		System.out.println("Inside Consume method");
		Thread.sleep(3000);
		condition.signal();
		lock.unlock();
	}
}
public class Lt23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lt23Worker process = new Lt23Worker();
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
