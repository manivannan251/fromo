package section4;
class DaemonWorker implements Runnable {
	
	public void run() {
		while(true) {
			System.out.println("Daemon Worker executing");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Daemon worker exiting");
			}
		}
		
	}
}
class NormalWorker implements Runnable {
	
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Normal thread finishes execution");
		}
		
}

public class Lt13 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new DaemonWorker());
		Thread t2 = new Thread(new NormalWorker());
		t1.setDaemon(true);
		t1.start();
		t2.start();

	}

}
