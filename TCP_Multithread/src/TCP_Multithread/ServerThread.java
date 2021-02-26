package TCP_Multithread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {
	private Socket socket;
	private ServerMain server_main;

	public ServerThread(Socket socket, ServerMain server_main) {
		this.socket = socket;
		this.server_main = server_main;
	}

	@Override
	public void run() {
		try {

			int client_number = server_main.getClientNumber();

			System.out.println("Client" + client_number + ". has connected");

			// I/O buffers:
			BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream())); // From
																											// Client to
																											// Server
																											// (input
																											// data)
			PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);// Outgoing
																												// data
																												// (Server
																												// ->
																												// Client)

			out_socket.println("Welcome client " + client_number + "!" + "What's your name ?"); // Send Welcome to the
																								// Client
			String message = in_socket.readLine();
			System.out.println("Client" + client_number + message); // display Client's message in console

			// Closing the socket
			socket.close();
			System.out.println("Client" + client_number + ". has disconnected");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
