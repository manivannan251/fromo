package section4;
class Runner1 {
	
	public void execute() {
		for(int i=0;i<5;i++) {
			System.out.println("Runner1"+i);
		}
	}
}
class Runner2 {
	
	public void execute() {
		for(int i=0;i<5;i++) {
			System.out.println("Runner2"+i);
		}
	}
}
public class Lt8_seq {

	public static void main(String[] args) {
		Runner1 runner = new Runner1();
		Runner2 runner2 = new Runner2();
		runner.execute();
		runner2.execute();
		

	}

}
