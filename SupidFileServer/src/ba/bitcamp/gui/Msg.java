package ba.bitcamp.gui;

import java.io.Serializable;
import java.util.ArrayList;

public class Msg implements Serializable{
	
	private static final long serialVersionUID = 5334749667698349845L;
	public static final int LOGIN = 1;
	public static final int REGISTER = 2;
	public static final int UPLOAD = 3;
	public static final int DOWNLOAD = 4;
	public static final int DELETE = 5;

	private int id;
	private ArrayList<String> content;

	public Msg(int id, ArrayList<String> content) {
		super();
		this.id = id;
		this.content = content;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the content
	 */
	public ArrayList<String> getContent() {
		return content;
	}

}
