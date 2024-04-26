package bean;

public class Student implements java.io.Serializable {
   
	private String no;
	private String name;
	private int entyear;
	private String classnum;
	private boolean attend;
	private School school;
	
	
	public String getNo() {
		return no ;
	}
	
	public void setNo(String no) {
		this.no=no;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public int getEntYear() {
		return entyear;
	}
	
	public void setEntYear(int entyear) {
		this.entyear=entyear;
	}

	public String getClassNum() {
		return classnum;
	}
	
	public void setClassNum(String classnum) {
		this.classnum=classnum;
	}
	
	public boolean isAttend() {
		return attend;
	}
	
	public void setAttend(Boolean attend) {
		this.attend=attend;
	}
	
	public School getSchool() {
		return school;
	}
	
	public void setSchool(School school) {
		this.school=school;
	}
	
	public School getSchoolYear() {
		return school;
	}
	


	

	

	

	

}