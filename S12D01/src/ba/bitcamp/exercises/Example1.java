package ba.bitcamp.exercises;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;

public class Example1 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
				
		list.add("Sarajevo je sampion");
		list.add("Zeljo je sampion");
		
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			mapper.writeValue(new File("/Users/dinko.hodzic/Desktop/Lista.json"), list);
			System.out.println("It worked!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
