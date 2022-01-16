package section7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task1 implements Runnable {
	
	private int id;
	
	Task1(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Task with with id "+id+" is in work - thread id "+Thread.currentThread().getName());
		
		try {
			for(int i=0;i<10000;i++) {
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Task with with id "+id+" has completed work - thread id "+Thread.currentThread().getName());
	}
}

class Task2 implements Runnable {
	
	private int id;
	
	Task2(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Task with with id "+id+" is in work - thread id "+Thread.currentThread().getName());
		
		try {
			for(int i=0;i<100;i++) {
				Thread.sleep(10000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Task with with id "+id+" has completed work - thread id "+Thread.currentThread().getName());
	}
}
public class Lt36 {

	public static void main(String[] args) {
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(new Task1(1));
		service.execute(new Task1(2));

	}

}
