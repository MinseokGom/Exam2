package bean;

import java.util.HashMap;
import java.util.Map;

public class TestListSubject implements java.io.Serializable {
   
	
	private int entYear;
	private String studentNo;
	private String studentName;
	private String classNum;
	private Map<Integer, Integer> points;
	
	public String getSubjectList() {
		return subjectList();
	}	
	
	public int getEntYear() {
		return entYear;
	}
	
	public String getStudentNo() {
		return studentNo;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public String getClassNum() {
		return classNum;
	}
	
	public Integer getPoints() {
        points = new HashMap<>();
    }
	
	public void setSubjectList(String subjectList ) {
		this.subjectList=subjectList;
	}
	
	public void setEntYear(int entYear) {
		this.entYear=entYear;
	}
	
	public void setStudentNo(String studentNo) {
		this.studentNo=studentNo;
	}
	
	public void setStudentNum(String studentName) {
		this.studentName=studentName;
	}
	
	public void setClassNum(String classNum) {
		this.classNum=classNum;
	}
	
	public void setPoints(Map<Integer,Integer>) {
		
	}
	
	public void putPoint();
}
