package section7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Lt41Callable implements Callable<String> {
	
	private int id;
	
	Lt41Callable(int id) {
		this.id=id;
	}
	
	@Override
	public String call() throws Exception {
		Thread.sleep(5000);
		return "ID : "+id;
	}
	
}
public class Lt41Call {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executors = Executors.newFixedThreadPool(2);
		List<Future<String>> futures = new ArrayList<Future<String>>();
		for(int i=0;i<5;++i) {
			Future<String> fut = executors.submit(new Lt41Callable(i));
			futures.add(fut);
		}
		System.out.println("After submit");
		for(Future<String> fut : futures) {
			if(fut.isDone())
				System.out.println(fut.get());
		}
		
		System.out.println("Completed process");

	}

}
