package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import bean.School;
import bean.Subject;

public class SubjectDAO extends DAO {

<<<<<<< HEAD
	public Subject get(List<Subject> woo) throws Exception {
            Connection con = getConnection();
            
            for (Subject subject:woo) {
            PreparedStatement st=con.prepareStatement(
    			"SELECT * FROM subject WHERE school_cd = ? AND cd = ? AND  name = ?");
            School sch = Subject.getSchool();
            st.setString(1,sch.getCd());
            st.setString(2, Subject.getCd());
            st.setString(3,Subject.getName());
            ResultSet rs = st.executeQuery();
        
         rs.close(); 
         con.close();
        
		return Subject;
=======
    public List<Subject> get(School school) throws Exception {
        List<Subject> subjects = new ArrayList<>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            String sql = "SELECT * FROM subject WHERE school_cd = ?";
            st = con.prepareStatement(sql);
            st.setString(1, school.getCd());
            rs = st.executeQuery();

            while (rs.next()) {
                Subject subject = new Subject();
                subject.setCd(rs.getString("cd"));
                subject.setName(rs.getString("name"));
                subject.setSchool(school);
                subjects.add(subject);
            }
        } catch (SQLException e) {
            throw new Exception("Failed to filter subjects.", e);
        } finally {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (con != null) con.close();
        }

        return subjects;
>>>>>>> branch 'master' of https://github.com/MinseokGom/Exam2.git
    }
<<<<<<< HEAD
	}

=======
//	public Subject get(List<Subject> woo) throws Exception {
//            Connection con = getConnection();
//            
//            for (Subject subject:woo) {
//            PreparedStatement st=con.prepareStatement(
//    			"SELECT * FROM subject WHERE school_cd = ? AND cd = ? AND  name = ?");
//            School sch = Subject.getSchool();
//            st.setString(1,sch.getCd());
//            st.setString(2, Subject.getCd());
//            st.setString(3,Subject.getName());
//            ResultSet rs = st.executeQuery();
//        
//         rs.close(); 
//         con.close();
//        
//		return Subject;
//    }
//	}
//	public List<Subject> getAllSubjects() throws Exception {
//	    List<Subject> subjects = new ArrayList<>();
//	    Connection con = null;
//	    PreparedStatement pstmt = null;
//	    ResultSet rs = null;
//
//	    try {
//	        con = getConnection();
//	        String sql = "SELECT school_cd,cd,name  FROM subject";
//	        pstmt = con.prepareStatement(sql);
//	        rs = pstmt.executeQuery();
//
//	        while (rs.next()) {
//	            Subject subject = new Subject();
//
//	            subject.setCd(rs.getString("CD"));
//	            subject.setName(rs.getString("NAME"));
//	            subject.setSchool(rs.getSchool("school"));
//	            // 学校コードから学校の詳細を取得するメソッドがあると仮定します
//	            School school = getSchoolByCode(rs.getString("SCHOOL_CD")); 
//	            subject.setSchool(school);
//	            subjects.add(subject);
//	        }
//	    } catch (SQLException e) {
//	        throw new Exception("すべての科目を取得できませんでした。", e);
//	    } finally {
//	        if (rs != null) { rs.close(); }
//	        if (pstmt != null) { pstmt.close(); }
//	        if (con != null) { con.close(); }
//	    }
//
//	    return subjects;
//	}
//
>>>>>>> branch 'master' of https://github.com/MinseokGom/Exam2.git


	public List<Subject> filter(School school) throws Exception {
		
	}

	public boolean save(Subject subject) throws Exception {
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"insert into product values(null,?,?");
		st.setString(1, product.getName());
		st.setInt(2, product.getPrice());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return subjects.add(subject);
	}

	public boolean delete(Subject subject) {
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"insert into product values(null,?,?");
		st.setString(1, product.getName());
		st.setInt(2, product.getPrice());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return subjects.remove(subject);
	}

}
