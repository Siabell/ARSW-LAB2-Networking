package edu.eci.ejercicio3;

import java.io.*;
import java.net.*;

public class Cliente431 {

	public static void main(String[] args) {
		Socket echoSocket = null;
		  PrintWriter out = null;
		  BufferedReader in = null;
		  
		  try {
			echoSocket = new Socket("127.0.0.1", 35000);
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
			out = new PrintWriter(echoSocket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  BufferedReader stdIn = new BufferedReader( new InputStreamReader(System.in));
		  String userInput;
		try {
			userInput = stdIn.readLine();
			out.println(userInput);
			System.out.println(in.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
