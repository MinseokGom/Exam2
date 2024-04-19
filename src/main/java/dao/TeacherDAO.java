package dao;

import bean.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeacherDao extends DAO {
    public Teacher search(String id, String password)
        throws Exception {
        Teacher teacher = null;
        
        Connection con = getConnection(); // getConnection() を呼び出す
        
        PreparedStatement st;
        st = con.prepareStatement(
             "select * from teacher where login=? and password=? ");
        st.setString(1, id);
        st.setString(2, password);
        ResultSet rs = st.executeQuery();
        
        if (rs.next()) { // 結果セットが空でない場合のみ処理
            teacher = new Teacher();
            teacher.setId(rs.getInt("id"));
            teacher.setName(rs.getString("name"));
            teacher.setPassword(rs.getString("password"));
            teacher.setSchool(rs.getSchool("school"));
        }
        
        st.close();
        con.close();
        return teacher;
    }
}



//package dao;
//
//import bean.Teacher;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//
//
//public class TeacherDAO  {
//	public Teacher search(String login, String password)
//		throws Exception {
//		Teacher teacher=null;
//
//		Connection con=getConnection();
//
//		PreparedStatement st;
//		st=con.prepareStatement(
//			"select * from teacher where login=? and password=?");
//		st.setString(1, login);
//		st.setString(2, password);
//		ResultSet rs=st.executeQuery();
//
//		while (rs.next()) {
//			teacher=new Teacher();
//			teacher.setId(rs.getInt("id"));
//			teacher.setLogin(rs.getString("login"));
//			teacher.setPassword(rs.getString("password"));
//			teacher.setSchool(rs.getSchool("school"));
//		}
//
//		st.close();
//		con.close();
//		return teacher;
//	}
//}


//package dao;

//import bean.Teacher;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//public class TeacherDAO extends DAO {
//	public Teacher search(String login, String password)
//	    throws Exception {
//		Teacher teacher=null;
//		
//		Connection con=getConnection;
//		
//		PreparedStatement st;
//		st=con.prepareStatement(
//			 "select * from teacher where login=? and password=? ");
//		st.setString(1,login);
//		st.setString(2, password);
//		ResultSet rs=st.executeQuery();
//		
//		while (rs.next()) {
//			teacher=new Teacher();
//			teacher.setId(rs.getInt("id"));
//			teacher.setLogin(rs.getString("login"));
//			teacher.setPassword(rs.getString("password"));
//		}
//		
//		st.close();
//		con.close();
//		return teacher;
//
//	}
//
//}
