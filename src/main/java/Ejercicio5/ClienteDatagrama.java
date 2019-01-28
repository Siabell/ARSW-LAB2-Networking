package Ejercicio5;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDatagrama {
	
	DatagramSocket socket;

	public ClienteDatagrama() {
		try {
			socket = new DatagramSocket(4445);
		} catch (SocketException ex) {
			Logger.getLogger(ClienteDatagrama.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	

}
