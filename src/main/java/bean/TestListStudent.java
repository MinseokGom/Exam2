package bean;

public class TestListStudent implements java.io.Serializable{
   
    private String subjectName;
    private String subjectCd;
    private int num;
    private int point;
    
    public String getSubjectName() {
    	return subjectName;
    }
    
    public String getSubjectCd() {
    	return subjectCd;
    }
    
    public int getNum() {
    	return num;
    }
    
    public int getPoint() {
    	return point;
    }
    
    public void setsubjectName(String subjectName) {
    	this.subjectName=subjectName;
    }
    
    public void setsubjectCd(String subjectCd) {
    	this.subjectCd=subjectCd;
    }
    
    public void setNum(int num) {
    	this.num=num;
    }
    
    public void setPoint(int point) {
    	this.point=point;
    }

	public void add(TestListStudent testListStudent) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
