package ba.bitcamp.exercises;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;

public class ExampleRead {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			ArrayList<Student> list = mapper.readValue(new File("/Users/dinko.hodzic/Desktop/Lista.json"), ArrayList.class);
			System.out.println("It worked!");

			System.out.println(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
