package ba.bitcamp.exercises;

public class Student {
	
	private int id;
	private String name;
	private String faculty;
	private int semester;	
	
	public Student() {
		id = 0;
		name = null;
		faculty = null;
		semester = 0;
	}
	
	public Student(int id, String name, String faculty, int semester) {
		super();
		this.id = id;
		this.name = name;
		this.faculty = faculty;
		this.semester = semester;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFaculty() {
		return faculty;
	}
	
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	
	public int getSemester() {
		return semester;
	}
	
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	
	
	
	
	
	

}
