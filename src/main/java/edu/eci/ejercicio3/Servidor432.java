package edu.eci.ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor432 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		try {
			
			serverSocket = new ServerSocket(35008);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.err.println("Could not listen on port: 35001.");
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
			int inNumero = 0;
			
			String inputLine;
			
			String funcionActual = "cos";
			while ((inputLine = in .readLine()) != null) {
				
				boolean isNumeric = inputLine.chars().allMatch( Character::isDigit );
				
				if(inputLine.equals("fun:cos")) {
					funcionActual = "cos";
				}else if(inputLine.equals("fun:sin")) {
					funcionActual = "sin";
				}else if(inputLine.equals("fun:tan")) {
					funcionActual = "tan";
				}else if(isNumeric) {
					inNumero =  Integer.parseInt(inputLine);
				}else System.out.println("no es valido");
				out.println(calcularOperacion(funcionActual,inNumero));
			 }
			
			
			out.close(); in .close();
			clientSocket.close();
			serverSocket.close();
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static double calcularOperacion(String operacion,int numero) {
		
		switch (operacion) {
		case "cos":
			System.out.println("Cos");
			return Math.cos((double)numero);
		case "sin":
			
			return Math.sin((double)numero);
		case "tan":	
			return Math.tan((double)numero);
		}
		
		return 0;
		
	}

}
