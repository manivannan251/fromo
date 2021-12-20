package section4;
class Runner1lt9 implements Runnable {
	
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Runner1 -"+i);
		}
	}
}
class Runner2lt9 implements Runnable {
	
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Runner2 -"+i);
		}
	}
}

public class Lt9_pa {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runner1lt9());
		Thread t2 = new Thread(new Runner2lt9());
		t1.start();
		t2.start();

	}

}
