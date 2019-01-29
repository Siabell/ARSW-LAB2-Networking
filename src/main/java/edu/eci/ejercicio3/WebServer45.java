package edu.eci.ejercicio3;

import java.net.*;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.plaf.InputMapUIResource;

import java.io.*;

public class WebServer45 {
	private static PrintWriter out = null;
	private static BufferedReader in = null;
	private static BufferedOutputStream dataOut = null;
	private static String fileRequest;
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket =new ServerSocket(35000);
			
		}catch (Exception e) {
			System.err.println("Could not listen on port: 35000.");
			   System.exit(1);
		}
		
		
		for( ; ; ) {
			Socket clientSocket = null;
			try {
				System.out.println("Listo para recibir ...");
				clientSocket = serverSocket.accept();
				
			} catch (IOException e) {
				System.err.println("Accept failed.");
				System.exit(1);
			}
			
			PrintStream out=new PrintStream(new BufferedOutputStream(clientSocket.getOutputStream()));
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			dataOut = new BufferedOutputStream(clientSocket.getOutputStream());
			String inputLine, outputLine;
			inputLine = in.readLine();
			System.out.println(inputLine);
			
			try {
				StringTokenizer st = new StringTokenizer(inputLine);
				String method = st.nextToken();
				
				fileRequest = st.nextToken();
				while ((inputLine = in .readLine()) != null) {
					
					
					System.out.println("Received: " + inputLine);
					if (! in .ready()) {
						break;
					}
				}
				
				if(fileRequest.endsWith("/")) {
					fileRequest = "paginasPrueba/Index.html";
				}else {
					
					fileRequest="paginasPrueba/"+fileRequest.substring(1);
					System.out.println(fileRequest);
				}
				
				InputStream inStream=new FileInputStream(fileRequest);
				
				String mimeType="text/plain";
		        if (fileRequest.endsWith(".html")) mimeType="text/html";
		        else if (fileRequest.endsWith(".jpg") || fileRequest.endsWith(".jpeg"))  mimeType="image/jpeg";
		        
		        out.print("HTTP/1.0 200 OK\r\n"+
		          "Content-type: "+mimeType+"\r\n\r\n");
				
				byte[]fileData = new byte[5000];
				int n;
		        while ((n = inStream.read(fileData))>0) out.write(fileData, 0, n);
		        out.close();
				
				out.close(); in .close();

			} catch (Exception e) {
				out.println("HTTP/1.0 404 Not Found\r\n"+
						"Content-type: text/html\r\n\r\n");
				InputStream inStream=new FileInputStream("paginasPrueba/notFound.html");
				byte[]fileData = new byte[5000];
				int n;
				 while ((n=inStream.read(fileData))>0) out.write(fileData, 0, n);
				 out.close();

			}
		}	
	}

}
