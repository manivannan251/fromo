package section6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lt28_Dl {
	private Lock lock1 = new ReentrantLock();
	
	private Lock lock2 = new ReentrantLock();
	
	public static void main(String[] args) {
		
		Lt28_Dl deadLockExample = new Lt28_Dl();
		// TODO Auto-generated method stub
		
		new Thread(deadLockExample::worker1,"worker1").start();
		new Thread(deadLockExample::worker2,"worker2").start();

	}
	
	public void worker1() {
		lock1.lock();
		System.out.println("Worker1 acquired lock 1");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lock2.lock();
		System.out.println("Worker1 acquired lock 2");
		lock1.unlock();
		lock2.unlock();
	}
	
	
	public void worker2() {
		lock2.lock();
		System.out.println("Worker2 acquired lock 2");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lock1.lock();
		System.out.println("Worker2 acquired lock 1");
		lock2.unlock();
		lock1.unlock();
		
	}

}
