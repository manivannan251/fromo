package section6;

import java.util.concurrent.atomic.AtomicInteger;

public class Lt30_AtI {
	private static AtomicInteger counter = new AtomicInteger(0);
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				increment();
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				increment();
				
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("The counter variable is "+counter);

	}
	
	public static void increment() {
		for(int i=0;i<10000;i++) {
			counter.getAndIncrement();
			
			
					}
	}

}
