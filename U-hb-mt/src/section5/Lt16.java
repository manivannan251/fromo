package section5;

public class Lt16 {

	public static int count = 0;
	
	public static synchronized void increment() {
		count++;
	}

	public static void proces() {
			Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1;i<=100;i++) {
					increment();
				}
				
			}
		});
			Thread t2 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int i=1;i<=100;i++) {
						increment();
					}
					
				}
			});
			t1.start();
			t2.start();
			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("The value of counter is " + count);
			
	}

	public static void main(String[] args) throws InterruptedException {

		proces();
		
		

	}

}
