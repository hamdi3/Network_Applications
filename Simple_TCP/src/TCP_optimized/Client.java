package TCP_optimized;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public Client() throws Exception {
		Socket socket = new Socket("localhost", 2021);
		System.out.println("Successful connection to the server");

		// I/O buffers:
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		String user_number;
		// repeat as long the number isn't right
		while ((in_socket.readLine()).startsWith("Guess")) {
			System.out.println("Server says : Guess a number 1-10 ");
			user_number = keyboard.nextLine();
			out_socket.println(user_number);
		}

		System.out.println("You got it !!");

		// Closing the socket
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
