package bean;

public class Student implements java.io.Serializable {
   
	private String no;
	private String name;
	private int ent_year;
	private String class_num;
	
	public String getNo() {
		return no ;
	}
	
	public String getName() {
		return name;
	}
	
	public int getEnt_year() {
		return ent_year;
	}
//	ここまで出来た
	public School getSchool() {
		return school;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public void setSchool(School school) {
		this.school=school;
	}
	
}