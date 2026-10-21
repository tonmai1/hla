package week1.unit3;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Example09SocketReceiver {
	public static void main(String[] args) {
		// Slides 9-11: Client A. START THIS FIRST.
		int port = 5000;
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			System.out.println("[A] Waiting on port " + port + "...");
			try (Socket socket = serverSocket.accept();
					DataInputStream input = new DataInputStream(socket.getInputStream())) {
				System.out.println("[A] Connected.");
				String msg = input.readUTF();
				System.out.println("[A] Received: " + msg);
			}
		} catch (IOException e) {
			System.err.println("[A] Error: " + e.getMessage());
		}
	}
}
