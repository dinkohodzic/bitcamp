package ba.bitcamp.flappyBird;

import java.io.InputStream;

final public class ResLoader {
	/**
	 * This method is used to load the images and make sure they are visible in an extracted jar file
	 * @param path The path of the image
	 * @return the image
	 */
	public static InputStream load(String path) {
		InputStream input = ResLoader.class.getResourceAsStream(path);
		if (input == null) {
			input = ResLoader.class.getResourceAsStream("/" + path);
		}
		return input;
	}
}
