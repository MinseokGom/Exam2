package bean;

public class Teacher implements java.io.Serializable {
   
	private int id;
	private String login;
	private String password;
	private School school;
	
	public int getId() {
		return id ;
	}
	
	public String getLogin() {
		return login ;
	}
	
	public String getPassword() {
		return password;
	}
	
	public School getschool() {
		return school;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setLogin(String login) {
		this.login=login;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public void setSchool(Strnig school) {
		this.school=school;
	}
	
}