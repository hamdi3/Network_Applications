package TCP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public Client() throws Exception {
		Socket socket = new Socket("localhost", 2021);
		System.out.println("Successful connection to the server");

		// I/O buffers:
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

		String message = in_socket.readLine();//Receiving the message
		System.out.println("Server says: " + message);//printing it 
		out_socket.println("Thanks!");

		socket.close();
		System.out.println("Socket Closed.");
	}

	public static void main(String[] args) {
		try {
			new Client();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
