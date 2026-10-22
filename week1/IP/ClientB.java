package week1.IP;

import java.io.DataOutputStream;
import java.net.Socket;

public class ClientB {
	public static void main(String[] args) {
		String aIp = ClientA.HOST;
		int port = ClientA.PORT;

		try {
			Socket socket = new Socket(aIp, port);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			String msg = "hello world from ClientB";
			output.writeUTF(msg);
			output.flush();
			System.out.println("[B] Sent: " + msg);

			output.close();
			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
