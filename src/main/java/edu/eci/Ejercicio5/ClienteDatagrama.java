package edu.eci.Ejercicio5;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDatagrama implements Runnable{

	public static void main(String[] args) {
		ClienteDatagrama ds= new ClienteDatagrama();
		ds.run();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (;;) {
			byte[] sendBuf = new byte[256];
			try {
				DatagramSocket socket = new DatagramSocket();
				byte[] buf = new byte[256];
				InetAddress address = InetAddress.getByName("127.0.0.1");
				DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
				socket.send(packet);
		
				packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				String received = new String(packet.getData(), 0, packet.getLength());
				System.out.println("Date: " + received);
				
			} catch (SocketException ex) {
				Logger.getLogger(ClienteDatagrama.class.getName()).log(Level.SEVERE, null, ex);
			} catch (UnknownHostException ex) {
				Logger.getLogger(ClienteDatagrama.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IOException ex) {
				Logger.getLogger(ClienteDatagrama.class.getName()).log(Level.SEVERE, null, ex);
			}
			 
		}
	}
}
