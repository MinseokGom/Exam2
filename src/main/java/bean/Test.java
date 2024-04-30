package bean;

public class Test implements java.io.Serializable{

	private Student student;
	private String classNum;
	private Subject subject;
	private School school;
	private int no;
	private int point;
	
	public Student getStudent() {
		return student;
	}
	
	public String getClassNum() {
		return classNum;
	}

	public Subject getSubject() {
		return subject;
	}
	
	public School getSchool() {
		return school;
	}
	
}
