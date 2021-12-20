package section5;

public class Lt17 {
	
	public static int count1 = 0;
	public static int count2 = 0;
	
	public static final Object obj1 = new Object();
	
	public static final Object obj2 = new Object();
	
	public static void increment1() {
		synchronized (obj1) {
			System.out.println("Entering increment1");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count1++;
		}
		
	}
	
	public static void increment2() {
		synchronized (obj2) {
			System.out.println("Entering increment2");
			count2++;
		}
	}

	public static void proces() {
			Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1;i<=100;i++) {
					increment1();
				}
				
			}
		});
			Thread t2 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int i=1;i<=100;i++) {
						increment2();
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
			System.out.println("The value of counter1 is " + count1);
			System.out.println("The value of counter2 is " + count2);
			
	}

	
	public static void main(String[] args) {
		
		proces();
	}

}
