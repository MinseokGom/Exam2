package bean;
import java.util.HashMap;
import java.util.Map;

public class TestListSubject {
    private int entYear;
    private String studentNo;
    private String studentName;
    private String classNum;
    private Map<Integer, Integer> points;

    // Constructor
    public TestListSubject() {
        points = new HashMap<>();
    }

    // Getters and Setters
    public int getEntYear() {
        return entYear;
    }

    public void setEntYear(int entYear) {
        this.entYear = entYear;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public Map<Integer, Integer> getPoints() {
        return points;
    }

    public void setPoints(Map<Integer, Integer> points) {
        this.points = points;
    }

    // Additional Methods
    public String getPoint(int key) {
        return points.containsKey(key) ? String.valueOf(points.get(key)) : null;
    }

    public void putPoint(int key, int value) {
        points.put(key, value);
    }
}

//
//import java.util.HashMap;
//import java.util.Map;
//
//public class TestListSubject implements java.io.Serializable {
//   
//	
//	private int entYear;
//	private String studentNo;
//	private String studentName;
//	private String classNum;
//	private Map<Integer, Integer> points;
//	
//	
//
//	public int getEntYear() {
//		return entYear;
//	}
//	
//	public String getStudentNo() {
//		return studentNo;
//	}
//	
//	public String getStudentName() {
//		return studentName;
//	}
//	
//	public String getClassNum() {
//		return classNum;
//	}
//	
//	public Integer getPoints() {
//        points = new HashMap<>();
//    }
//	
//	public void setSubjectList(String subjectList) {
//		this.subjectList=subjectList;
//	}
//	
//	public void setEntYear(int entYear) {
//		this.entYear=entYear;
//	}
//	
//	public void setStudentNo(String studentNo) {
//		this.studentNo=studentNo;
//	}
//	
//	public void setStudentNum(String studentName) {
//		this.studentName=studentName;
//	}
//	
//	public void setClassNum(String classNum) {
//		this.classNum=classNum;
//	}
//	
//	public void setPoints(Map<Integer,Integer> point) {
//		
//	}
//	
//	public void putPoint();
//}
