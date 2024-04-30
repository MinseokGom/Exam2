package bean;

public class Student implements java.io.Serializable {
   
	private String no;
	private String name;
	private int entyear;
	private String classNum;
	private Boolean attend;
	private School school;
	private int schoolYear;
	
	public String getNo() {
		return no ;
	}
	
	public String getName() {
		return name;
	}
	
	public int getEntYear() {
		return entyear;
	}
	
	public String getClassNum() {
		return classNum;
	}
	
	public boolean isAttend() {
		return attend;
	}
	
	public School getSchool() {
		return school;
	}
	
	public School getSchoolYear() {
		return school;
	}
//	ここまで出来た
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setNo(String no) {
		this.no=no;
	}
	
	public void setEntyear(int entYear) {
		this.entyear=entyear;
	}
	
	public void setClassNum(String classNum) {
		this.classum=classnum;
	}
	
	public void setAttend(Boolean attend) {
		this.attend=attend;
	}
	
	public void setSchool(School school) {
		this.school=school;
	}
}