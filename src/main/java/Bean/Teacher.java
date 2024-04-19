package bean;

public class Teacher implements java.io.Serializable {
   
	private int id;
	private String name;
	private String password;
	private School school;
	
	public int getId() {
		return id ;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public School getSchool() {
		return school;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public void setSchool(Strnig school) {
		this.school=school;
	}
	
}
