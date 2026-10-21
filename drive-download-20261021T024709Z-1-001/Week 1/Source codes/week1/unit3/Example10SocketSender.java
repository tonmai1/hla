package week1.unit3;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Example10SocketSender {
	public static void main(String[] args) {
		// Slides 9-11: Client B. Run AFTER Example09SocketReceiver.
		String aIp = "127.0.0.1";
		int port = 5000;
		try (Socket socket = new Socket(aIp, port);
				DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {
			String msg = "hello world from ClientB";
			output.writeUTF(msg);
			output.flush();
			System.out.println("[B] Sent: " + msg);
		} catch (IOException e) {
			System.err.println("[B] Error: " + e.getMessage());
		}
	}
}
