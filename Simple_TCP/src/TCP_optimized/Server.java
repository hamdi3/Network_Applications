package TCP_optimized;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public Server() throws Exception {
		ServerSocket server_socket = new ServerSocket(2021); // opening a new port
		System.out.println("Port 2021 has been opened");

		Socket socket = server_socket.accept(); // opening a new socket to communicate with the client
		// Waiting till getting a connection from the Client
		System.out.println("Client " + socket.getInetAddress() + " has connected");

		// I/O buffers:
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream())); // From Client to
																										// Server (input
																										// data)
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);// Outgoing
																											// data
																											// (Server
																											// ->
																											// Client)
		String message;
		int secret_number = (int) (Math.random() * 10 + 1); // a random number between 1-10

		do {
			out_socket.println("Guess a number from 1 to 10");
			message = in_socket.readLine();
		} while (!(Integer.parseInt(message) == secret_number));// as long the number isn't right repeat

		out_socket.println("You got it !");
		System.out.println("Secret number is " + secret_number);

		socket.close();
		System.out.println("Socket is closed.");
	}

	public static void main(String[] args) {
		try {
			new Server();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
