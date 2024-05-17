package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.TestListStudent;

public class TestListStudentDAO{

    private String baseSql = "SELECT * FROM test_list_students";

    // Assume that TestListStudent, Student, Subject, School classes exist

    public List<TestListStudent> postFilter(ResultSet rSet) throws SQLException {
        List<TestListStudent> testListStudent = new ArrayList<>();
        while (rSet.next()) {
            TestListStudent ts = new TestListStudent();
            testListStudent.add( ts);
        }
        return testListStudent;
    }

    public TestListStudent filter(Student student) throws Exception {
        String sql = baseSql + " WHERE student_no = ?";
        TestListStudent testListStudent = new ArrayList<>();
         try(Connection connection = DAO.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT student.no")){
            pstmt.setString(1, student.getNo());
            ResultSet rSet = pstmt.executeQuery();
            while (rSet.next()) {
                testListStudent=new testListStudent();}
            }catch (SQLException e) {
                throw new Exception("Failed to retrieve all students.", e);
        }finally {
            if (testListStudent != null) { testListStudent.close(); }
           
        return testListStudent;
    }

    
}

//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//import bean.Student;
//import bean.TestListStudent;
//
//
//public class TestListStudentDAO extends DAO{
//    private String baseSql;
//    //list<TestListStudent>
//    public List<TestListStudent> PostFilter(ResultSet rSet)throws Exception{
//    	//postFilter メソッドの実装
//    	List<TestListStudent> list = new ArrayList<>();
//    	
//    	while (rSet.next()) {
//    	    
//    	    Student st = new Student();
//    	    st.setNo(rSet.getString("student.no"));
//			st.setName(rSet.getString("student.name"));
//			st.setEntYear(rSet.getInt("student.ent_year"));
//			st.setIsAttend(rSet.getBoolean("student.is_attend"));
//    	    
//    	    TestListStudent ts = new TestListStudent();
//    	    ts.setSubjectName(rSet.getString("testliststudent.subjectName"));
//    	    ts.setSubjectCd(rSet.getString("testliststudent.subjectCd"));
//    	    ts.setNum(rSet.getInt("testliststudent.num"));
//    	    ts.setPoint(rSet.getInt("testliststudent.point"));
//    	    
//    	}
//    	
//    }
////    絞り込み
//    public List<TestListStudent> filter(Student student){
//    	//filter メソッドの実装
//    	return new ArrayList<>();
//    }
//    
//}
