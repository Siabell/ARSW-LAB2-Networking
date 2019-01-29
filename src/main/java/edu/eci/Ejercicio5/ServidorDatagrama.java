package edu.eci.Ejercicio5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorDatagrama implements Runnable {

	DatagramSocket socket;

	public ServidorDatagrama() {
		try {
			socket = new DatagramSocket(4445);
		} catch (SocketException ex) {
			Logger.getLogger(ServidorDatagrama.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	
	
	public static void main(String[] args){
		ServidorDatagrama ds = new ServidorDatagrama();
		ds.run();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (;;) {
			byte[] buf = new byte[256];
			try {
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				String dString = new Date().toString();
				buf = dString.getBytes();
				InetAddress address = packet.getAddress();
				int port = packet.getPort();
				packet = new DatagramPacket(buf, buf.length, address, port);
				socket.send(packet);
				Thread.sleep(5000);
			} catch (IOException ex) {
				Logger.getLogger(ServidorDatagrama.class.getName()).log(Level.SEVERE, null, ex);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				socket.close();
				e.printStackTrace();
			}
				//socket.close();
			}
		}
		
	
	
	
}
