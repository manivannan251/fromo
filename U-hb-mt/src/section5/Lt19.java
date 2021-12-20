package section5;

class ProcessLt19 {
	
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Running the produce method..");
			wait();
			System.out.println("Again in the produce method..");
		}
	}
	
	public void consume() throws InterruptedException {
		Thread.sleep(1000);
		synchronized (this) {
			System.out.println("Consume method is executed");
			notify();
			Thread.sleep(5000);
		}
	}
}
public class Lt19 {

	public static void main(String[] args) {
		ProcessLt19 process = new ProcessLt19();
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
