package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Test;

public class TestDAO {

    private String baseSql = "SELECT * FROM tests";

    public Test get(Student student, Subject subject, School school, int no) throws SQLException {
        String sql = baseSql + " WHERE student_no = ? AND subject_id = ? AND school_id = ? AND test_no = ?";
        Connection connection;
		try {
			connection = DAO.getConnection();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
            PreparedStatement pstmt = connection.prepareStatement("select student.no,student.name,student.ent_year, student.is_attend, subject.cd ,subject.name ,a.no, a.point, b.no,b.point, as point from student inner join subject on student .school_cd = subject.school_cd left outer join test as a left join test as b on  a.student_no = b.studen_no and a.subject_cd and a.no<>b.no on student.no = a.student_no and subject_cd = a.subject_cd  where (a.no = 1 or (a.no = 2 and b.no id null ))and student.school_cd = ? and studen.ent_year = ? and student.class_num = ? and subject.cd = ?"); {
            pstmt.setString(1, student.getNo());
            pstmt.setString(2, subject.getCd());
            pstmt.setString(3, school.getCd());
            pstmt.setInt(4, no);
            ResultSet rSet = pstmt.executeQuery();
            if (rSet.next()) {
                return mapResultSetToTest(rSet);
            }
        }
        return null;
    }

   

	public List<Test> postFilter(ResultSet rSet, School school) throws SQLException {
        List<Test> tests = new ArrayList<>();
        while (rSet.next()) {
            Test test = mapResultSetToTest(rSet);
            if (test.getSchool().equals(school)) {
                tests.add(test);
            }
        }
        return tests;
    }

    private Test mapResultSetToTest(ResultSet rSet) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public List<Test> filter(int entYear, String classNum, Subject subject, int num, School school) throws SQLException {
        String sql = baseSql + " WHERE ent_year = ? AND class_num = ? AND subject_id = ? AND num = ? AND school_id = ?";
        List<Test> tests = new ArrayList<>();
        try(Connection connection = DAO.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("")) {
            pstmt.setInt(1, entYear);
            pstmt.setString(2, classNum);
            pstmt.setString(3, subject.getCd());
            pstmt.setInt(4, num);
            pstmt.setString(5, school.getCd());
            ResultSet rSet = pstmt.executeQuery();
            while (rSet.next()) {
                tests.add(mapResultSetToTest(rSet));
            }
        } catch (SQLException e) {
            throw new Exception("Failed to retrieve all students.", e);
		}
        return tests;
    }




	public boolean save(List<Test> list) throws SQLException {
        boolean success = true;
        try(Connection connection = DAO.getConnection()){
            for (Test test : list) {
                if (!save(test, connection)) {
                    success = false;
                }
            }
        }
        return success;
    }

    public boolean save(Test test, Connection connection) throws SQLException {
        String sql = "INSERT INTO tests (student_no, subject_id, school_id, test_no, score) VALUES (?, ?, ?, ?, ?)"
                + "ON DUPLICATE KEY UPDATE score = ?";
        PreparedStatement pstmt = connection.prepareStatement(""); {
            pstmt.setString(1, test.getStudent().getNo());
            pstmt.setString(2, test.getSubject().getCd());
            pstmt.setString(3, test.getSchool().getCd());
            pstmt.setInt(4, test.getNo());
            pstmt.setInt(5, test.getPoint());
            pstmt.setString(6, test.getClassNum());
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean delete(List<Test> list) throws SQLException {
        boolean success = true;
        try(Connection Connection = DAO.getConnection()){
            for (Test test : list) {
                if (!delete(test, Connection)) {
                    success = false;
                }
            }
        }
        return success;
    }
    public boolean delete(Test test, Connection connection) throws SQLException {
        String sql = "DELETE FROM tests WHERE student_no = ? AND subject_id = ? AND school_id = ? AND test_no = ?";
        try (PreparedStatement pstmt = connection.prepareStatement("")) {
            pstmt.setString(1, test.getStudent().getNo());
            pstmt.setString(2, test.getSubject().getCd());
            pstmt.setString(3, test.getSchool().getCd());
            pstmt.setInt(4, test.getNo());
            return pstmt.executeUpdate() > 0;
        }
    }

    
}

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//import bean.School;
//import bean.Student;
//import bean.Subject;
//import bean.Test;
//
//
//public class TestDAO extends DAO{
//	
//	public List<Test> postfilter(ResultSet rSet, School school, String classNum)throws Exception{
//		List<Test> list = new ArrayList<>();
//		
//		while (rSet.next()) {
//			Test t=new Test();
//			Student stu=new Student();
//			stu.setNo(rSet.getString("student.no"));
//			stu.setName(rSet.getString("student.name"));
//			stu.setEntYear(rSet.getInt("student.ent_year"));
//			stu.setClassNum(classNum);
//			stu.setIsAttend(rSet.getBoolean("student.is_attend"));
//			stu.setSchool(school);
//			
//			Subject sbj=new Subject();
//			sbj.setSchool(school);
//			sbj.setCd(rSet.getString("subject.cd"));
//			sbj.setName(rSet.getString("subject.name"));
//			
//			t.setStudent(stu);
//			t.setClassNum(classNum);
//			t.setSubject(sbj);
//			t.setSchool(school);
//            t.setNo(rSet.getInt("no"));
//            t.setPoint(rSet.getInt("point"));
//            
//		}
//		return list;
//	}
//	
//	public List<Test> filter(int entYear, String classNum, Subject subject ,int num , School school)throws Exception{
//		List<Test>list= new ArrayList<>();
//		Connection con=getConnection();
//		
//		String target= num ==1 ? "a.no.as no, a.point as point ":"b.no as no,b.point as point ";
////		ここ考える
//		PreparedStatement st=con.prepareStatement("select student.no,student.name,student.ent_year, student.is_attend, subject.cd ,subject.name ,a.no, a.point, b.no,b.point, as point from student inner join subject on student .school_cd = subject.school_cd left outer join test as a left join test as b on  a.student_no = b.studen_no and a.subject_cd and a.no<>b.no on student.no = a.student_no and subject_cd = a.subject_cd  where (a.no = 1 or (a.no = 2 and b.no id null ))and student.school_cd = ? and studen.ent_year = ? and student.class_num = ? and subject.cd = ?");
//	    st.setString(1,school.getCd());
//		st.setInt(2, entYear);
//		st.setString(3,classNum);
//		st.setString(4,subject.getCd());
//		ResultSet rs=st.executeQuery();
//		list = postfilter(rs.school,classNum);
//		
//		st.close();
//		con.close();
//
//		return list;
//	}
//	
//	private boolean save (Test test, Connection con)throws Exception{
//		PreparedStatement st1=con.prepareStatement("Select * from test where student_no = ? and subject_cd = ? and school_cd = ?");
//	    st1.setString(1, test.getStudent().getNo());
//		st1.setString(2, test.getSubject().getCd());
//		st1.setInt(3, test.getNo());
//		st1.setString(4, test.getSchool().getCd());
//	
//		
//		ResultSet rs1=st1.executeQuery();
//		
//		if(rs1.next()) {
////			ここのSQL文考える。
//
//			PreparedStatement st2=con.prepareStatement(			
//					"SELECT test.no, test.point, student.no, student.name, student.ent_year, subject.cd, subject.nameFROM testINNER JOIN student ON test.student_no = student.no INNER JOIN subject ON test.subject_cd = subject.cd WHERE student.school_cd = ? AND student.ent_year = ? AND student.class_num = ? AND subject.cd = ?");
////			st2.setInt(1,test.getPoint());
//			st2.setString(2,test.getStudent(),getNo());
//			st2.setString(3,test.getSubject(),getCd());
////			st2.setInt(4,test.getNo());
//			st2.setString(5,test.getSchool().getCd());
//			return st2.executeUpdate() == 1;
//		}else {
////			ここもSQL文考える。
//			UPDATE test
//			SET point = ?
//			WHERE student_no = ? AND subject_cd = ? AND no = ? AND school_cd = ?"+"
//			INSERT INTO test (student_no, subject_cd, school_cd, no, point, class_num)
//		    VALUES (?, ?, ?, ?, ?, ?)
//
//
//			PreparedStatement st2=con.prepareStatement("insert into test valuse(???)");
//		
//			st2.setString(1, test.getStudent(),getNo());
//			st2.setString(2, test.getSubject(),getCd());
//			st2.setString(3, test.getSchool().getCd());
//			st2.setInt(4, test.getNo());
//			st2.setInt(5,test.getPoint());
//			st2.setString(6,test.getClassNum());
//			return st2.executeUpdate() == 1;
//		}
//
//	}
//	public boolean save(List<Test>list)throws Exception{
//		Connection con= getConnection();
//		boolean isError = false;
//		for(Test test : list) {
//			if(!save(test,con)) {
//				isError = true;
//				break;
//			}
//		}
//		return isError;
//	}
//}
//	
//	
//	
