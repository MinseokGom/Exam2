package dao;

import bean.Customer;
import java.sql.Connection;
import java.sql.PerparedStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeacherDao extends DAO {
	public Customer search(String login, String passwrd)
	    throws Exception {
		Teacher teacher=null;
		
		Connection con=getConnection;
		
		PreparedStatement st;
		st=con.prepareStatement(
			 "select * from teacher where login=? and password=? ");
		st.setString(1,login);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			teacher=new Teacher();
			teacher.setId(rs.getInt("id"));
			teacher.setLogin(rs.getString("login"));
			teacher.setPassword(rs.getString("password"));
		}
		
		st.close();
		con.close();
		return teacher;

	}

}
