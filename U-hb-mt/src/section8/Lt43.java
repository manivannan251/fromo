package section8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lt43 {

	public static void main(String[] args) {
		
		//List<Integer> nums = new ArrayList<>();
		List<Integer> nums = Collections.synchronizedList(new ArrayList<>());
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<1000;i++)
					nums.add(i);
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<1000;i++)
					nums.add(i);
				
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
		
		System.out.println("The size of the list is "+nums.size());

	}

}
