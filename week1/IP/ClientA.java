package week1.IP;

import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientA {
	public static final String HOST = "127.0.0.1";
	public static final int PORT = 5555;

	public static void main(String[] args) {
		try {
			// Bind to this computer only. Port 5000 is often used by macOS AirPlay.
			ServerSocket serverSocket = new ServerSocket(PORT, 1, InetAddress.getByName(HOST));
			System.out.println("[A] waiting on " + HOST + ":" + PORT + " ...");
			Socket socket = serverSocket.accept();
			System.out.println("[A] connected...");
			DataInputStream input = new DataInputStream(socket.getInputStream());
			String msg = input.readUTF();
			System.out.println("[A] Received: " + msg);

			input.close();
			socket.close();
			serverSocket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
