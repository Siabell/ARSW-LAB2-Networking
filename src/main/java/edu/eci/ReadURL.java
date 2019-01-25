package edu.eci;

import java.net.*;

/**
 * Hello world!
 *
 */
public class ReadURL 
{
    public static void main( String[] args ) throws MalformedURLException
    {
    	try {
    		URL eci =  new URL("http://campusvirtual.escuelaing.edu.co:80/moodle/course/view.php?id=304#");
    		System.out.println("protocolo= "+eci.getProtocol());
    		System.out.println("authority= "+eci.getAuthority());
    		System.out.println("hostname= "+eci.getHost());
    		System.out.println("puerto= "+eci.getPort());
    		System.out.println("path= "+eci.getPath());
    		System.out.println("query= "+eci.getQuery());
    		System.out.println("File= "+eci.getFile());
    		System.out.println("reference= "+eci.getRef());
    		

    		
    	} catch (MalformedURLException e) {
    		e.printStackTrace();
    	}
    	
       
    }
}
