package edu.eci.ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente432 {
	public static void main(String[] args) throws IOException {
		Socket echoSocket = null;
		  PrintWriter out = null;
		  BufferedReader in = null;
		  
		  try {
			echoSocket = new Socket("127.0.0.1", 35008);
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
			out = new PrintWriter(echoSocket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		  
		  BufferedReader stdIn = new BufferedReader( new InputStreamReader(System.in));
		  String userInput;
		try {
			while ((userInput = stdIn.readLine()) != null) {
				
				out.println(userInput);
				System.out.println(in.readLine());
			}
			echoSocket.close();
		} catch (IOException e) {
			echoSocket.close();
			e.printStackTrace();
		}
		
	}
}
