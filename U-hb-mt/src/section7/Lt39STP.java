package section7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Lt39Task1 implements Runnable {
	
	private int id;
	
	Lt39Task1(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Task with with id "+id+" is in work - thread id "+Thread.currentThread().getName());
		long duration = (long) (Math.random() * 5);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			System.out.println("Trying to interrupt the current thread");
		}
		System.out.println("Task with with id "+id+" has completed work - thread id "+Thread.currentThread().getName());
	}
}
public class Lt39STP {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		for(int i=0;i<100;i++) {
			service.execute(new Lt39Task1(i));
		}
		
		service.shutdown();
		System.out.println("Called shutdown method");
		
		try {
			if(!service.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
				service.shutdownNow();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			service.shutdownNow();
		}

	}

}
