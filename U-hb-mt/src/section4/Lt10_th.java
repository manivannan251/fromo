package section4;
class Runner101 extends Thread{
	
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Runner1-"+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class Runner102 extends Thread {
	
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Runner2-"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class Lt10_th {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Runner101();
		Thread t2 = new Runner102();
		t1.start();
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finished with the threads");
		

	}

}
