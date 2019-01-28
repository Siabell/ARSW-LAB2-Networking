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
			try {serverSocket.close();}  catch(IOException ei) {}
			e1.printStackTrace();
			System.err.println("Could not listen on port: 35000.");
		    System.exit(1);
			
		}
		
		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e1) {
			try {serverSocket.close(); clientSocket.close();}  catch(IOException ei) {}
			System.err.println("the conection has failed");
			e1.printStackTrace();
		}
		
		try {
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
			double inNumber = 0;
			
			String inputLine;
			
			String actualFunction = "cos";
			while ((inputLine = in .readLine()) != null) {
				
				boolean isNumeric = inputLine.chars().allMatch( Character::isDigit );
				int isDouble = inputLine.indexOf(".");
				System.out.println(isDouble);
				if(inputLine.equals("fun:cos")) {
					actualFunction = "cos";
				}else if(inputLine.equals("fun:sin")) {
					actualFunction = "sin";
				}else if(inputLine.equals("fun:tan")) {
					actualFunction = "tan";
				}else if(isNumeric || isDouble!=-1) {
					inNumber =  Double.parseDouble(inputLine);
					
				}else System.out.println("no es valido");
				out.println(calcularOperacion(actualFunction,inNumber));
			 }
						
			out.close(); in .close();
			clientSocket.close();
			serverSocket.close();
			
		} catch (NumberFormatException | IOException e) {
			try {serverSocket.close(); clientSocket.close();}  catch(IOException ei) {}
			System.err.println("Failed to caluculate the operation");
			e.printStackTrace();
		}
	}
	
	private static double calcularOperacion(String operacion,double numero) {
		
		switch (operacion) {
		case "cos":
			return Math.cos(numero);
		case "sin":
			return Math.sin(numero);
		case "tan":	
			return Math.tan(numero);
		}
		
		return 0;
		
	}

}
