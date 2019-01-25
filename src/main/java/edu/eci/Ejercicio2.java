package edu.eci;

import java.io.*;
import java.net.*;
public class Ejercicio2 {
  public static void main(String[] args) throws Exception {
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
   URL google = new URL(br.readLine());
   File archivo=new File("resultado.html");
   FileWriter escribir=new FileWriter(archivo,true);

  
  try (BufferedReader reader = new BufferedReader(new InputStreamReader(google.openStream()))) {
    String inputLine = null;
   while ((inputLine = reader.readLine()) != null) {
    escribir.write(inputLine);
    
   }
   escribir.close();
   br.close();
   
  } catch (IOException x) {
   System.err.println(x);
   
  }
 }
 
}