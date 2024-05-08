package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Subject;

public class SubjectDAO extends DAO {

	public Subject get(List<Subject> woo) throws Exception {
            Connection con = getConnection();
            PreparedStatement st=con.prepareStatement(
    				"SELECT * FROM subject WHERE cd = ? AND school = ?");
            st.setString(1, cd);
            st.setString(2, school);
            ResultSet rs = st.executeQuery();

           
                // 結果からSubjectオブジェクトを生成
                School sch =  Subject.getSchool();
                sch.setCd(rs.getString("cd"));
                sch.setName(rs.getString("name"));
            
        
         rs.close(); 
         con.close();
        
        
		return Subject;
    }


	private List<Subject> subjects = new ArrayList<>();

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
