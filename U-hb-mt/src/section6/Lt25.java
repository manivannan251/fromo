package section6;
class WorkerLt25 implements Runnable {
	private volatile boolean isTerminated;

	@Override
	public void run() {
		while(!isTerminated) {
			System.out.println("Worker is running");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public boolean isTerminated() {
		return isTerminated;
	}
	
	public void setTerminated(boolean terminated) {
		isTerminated = terminated;
	}
	
	
}
public class Lt25 {

	public static void main(String[] args) throws InterruptedException {
		WorkerLt25 wk = new WorkerLt25();
		Thread t1 = new Thread(wk);
		t1.start();
		Thread.sleep(3000);
		wk.setTerminated(true);
		System.out.println("Worker is terminated");

	}

}
