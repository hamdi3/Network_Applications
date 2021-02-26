package TCP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public Server() throws Exception {
		ServerSocket server_socket = new ServerSocket(2021); //opening a new port
		System.out.println("Port 2021 has been opened");

		Socket socket = server_socket.accept(); //opening a new socket to communicate with the client
		//Waiting till getting a connection from the Client
		System.out.println("Client " + socket.getInetAddress() + " has connected");

		// I/O buffers:
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream())); //From Client to Server (input data)
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);//Outgoing data (Server -> Client)

		out_socket.println("Welcome!"); // Send Welcome to the Client
		String message = in_socket.readLine();
		System.out.println("Client says " + message); // display Client's message in console
		//Closing the socket
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
