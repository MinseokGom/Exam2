package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.TestListStudent;


public class TestListStudentDAO extends DAO{
    private String baseSql;
    //list<TestListStudent>
    public List<TestListStudent> PostFilter(ResultSet rSet)throws Exception{
    	//postFilter メソッドの実装
    	List<TestListStudent> list = new ArrayList<>();
    	
    	while (rSet.next()) {
    	    
    	    Student st = new Student();
    	    st.setNo(rSet.getString("student.no"));
			st.setName(rSet.getString("student.name"));
			st.setEntYear(rSet.getInt("student.ent_year"));
			st.setIsAttend(rSet.getBoolean("student.is_attend"));
    	    
    	    TestListStudent ts = new TestListStudent();
    	    ts.setSubjectName(rSet.getString("testliststudent.subjectName"));
    	    ts.setSubjectCd(rSet.getString("testliststudent.subjectCd"));
    	    ts.setNum(rSet.getInt("testliststudent.num"));
    	    ts.setPoint(rSet.getInt("testliststudent.point"));
    	    
    	}
    	
    }
//    絞り込み
    public List<TestListStudent> filter(Student student){
    	//filter メソッドの実装
    	return new ArrayList<>();
    }
    
}
