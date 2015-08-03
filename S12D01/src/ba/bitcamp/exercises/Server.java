package ba.bitcamp.exercises;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;

import org.codehaus.jackson.map.ObjectMapper;

public class Server {

	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();

		ArrayList<Msg> msgs = new ArrayList<Msg>();

		byte[] buffer = new byte[1024];
		File f = new File("/users/dinko.hodzic/Desktop/msg.json");

		ServerSocket server;

		try {

			server = new ServerSocket(8000);
			System.out.println("Waiting");

			Socket inputSocket = server.accept();

			InputStream reader = inputSocket.getInputStream();

			FileOutputStream fileWriter = new FileOutputStream(f);
			int read;
			while ((read = reader.read(buffer, 0, 1024))>0) {
				fileWriter.write(buffer, 0, read);
				fileWriter.flush();
			}

			reader.close();
			fileWriter.close();

			msgs = mapper.readValue(f, ArrayList.class);
			msgs.add(new Msg("Dinko", "" + Calendar.getInstance().getTime(), "Jedan je Hasib! Hasib se prepeko'"));
			System.out.println(msgs);

			mapper.writeValue(f, msgs);
			System.out.println("File ready");

			Socket outputSocket = new Socket("10.0.82.70", 8000);

			OutputStream os = outputSocket.getOutputStream();

			FileInputStream fis = new FileInputStream(f);
			byte[] buffer2 = new byte[1024];
			int howmuch;
			while ((howmuch = fis.read(buffer2, 0, 1024))>0) {
				os.write(buffer2, 0, howmuch);
				os.flush();
			}
			System.out.println("Done");

			os.close();
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
