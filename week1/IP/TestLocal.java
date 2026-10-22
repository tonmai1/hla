package week1.IP;

public class TestLocal {
	public static void main(String[] args) throws InterruptedException {
		Thread receiver = new Thread(() -> ClientA.main(new String[0]));
		receiver.start();
		Thread.sleep(400);
		ClientB.main(new String[0]);
		receiver.join();
	}
}
