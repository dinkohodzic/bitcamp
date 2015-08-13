package ba.bitcamp.gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Communication{
	
	
	 static Socket socket;
	 static BufferedReader reader;
	 static BufferedWriter writer;
	 
	 public static void connectToServer(String ip, int port){
		 try {
			socket = new Socket(ip, port);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	 }
	 public static void sendMessage(Msg message){
		 try {
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	 }
	 
	 
	 

}
