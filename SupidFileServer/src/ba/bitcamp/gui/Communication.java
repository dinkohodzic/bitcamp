package ba.bitcamp.gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Communication{
	
	
	private static Socket socket;
	private static ObjectOutputStream output;
	 
	 public static void connectToServer(String ip, int port){
		 try {
			socket = new Socket(ip, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	 }
	 public static void sendMessage(Msg message){
		 try {
			 output = new ObjectOutputStream(socket.getOutputStream());
			 output.writeObject(message);
			 output.flush();
			 output.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	 }
	 
	 public static Socket getSocket(){
		 return socket;
	 }
	 

}
