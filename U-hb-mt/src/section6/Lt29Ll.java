package section6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lt29Ll {
	private Lock lock1 = new ReentrantLock();
	
	private Lock lock2 = new ReentrantLock();
	
	public static void main(String[] args) {
		Lt29Ll ll = new Lt29Ll();
		
		new Thread(ll::lworker1,"worker1").start();
		new Thread(ll::lworker2,"worker2").start();

	}
	
	public void lworker1() {
		while(true) {
			try {
				lock1.tryLock(50, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Worker1 acquired lock 1");
			System.out.println("Worker1 tries to acquire lock2");
			try {
				if(lock2.tryLock()) {
					System.out.println("Worker1 acquired lock2");
					lock2.unlock();
				} else {
					System.out.println("Worker1 cannot acquire lock2");
					
					continue;
				}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
		lock1.unlock();
		lock2.unlock();
	}
	
	
	public void lworker2() {
		while(true) {
			try {
				lock2.tryLock(50, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Worker2 acquired lock 2");
			System.out.println("Worker2 tries to acquire lock1");
			try {
				if(lock1.tryLock()) {
					System.out.println("Worker2 acquired lock1");
					lock1.unlock();
				} else {
					System.out.println("Worker2 cannot acquire lock1");
					
					continue;
				}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
		lock1.unlock();
		lock2.unlock();
		
	}

}
