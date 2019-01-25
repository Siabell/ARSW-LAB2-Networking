package edu.eci.ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Servidor431 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		try {
			
			serverSocket = new ServerSocket(35000);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.err.println("Could not listen on port: 35000.");
		    System.exit(1);
			
		}
		
		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
			int inNumero = Integer.parseInt(in.readLine());
			int outNumero = inNumero*inNumero;
			out.println(outNumero);
			
			out.close(); in .close();
			   clientSocket.close();
			   serverSocket.close();
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
