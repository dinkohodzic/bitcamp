package ba.bitcamp.lectures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {

		while (true) {
			try {

				Socket client = new Socket("10.0.82.113", 7321);
				System.out.println("Connecting....");

				Scanner in = new Scanner(System.in);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
				BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				
				String s = in.nextLine();

				bw.write(s);
				bw.newLine();
				bw.flush();

				System.out.println(br.readLine());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
