package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import bean.School;
import bean.Subject;

public class SubjectDAO extends DAO {

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
    }
	}



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
