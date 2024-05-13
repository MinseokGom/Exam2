package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Subject;

public class SubjectDAO extends DAO {

	public Subject get(List<Subject> woo) throws Exception {
            Connection con = getConnection();
            

            PreparedStatement st=con.prepareStatement(
    				"SELECT * FROM subjects WHERE cd = ? AND school = ?");
            st.setString(1, cd);
            st.setSchool(2, school);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                // 結果からSubjectオブジェクトを生成
                Subject subj = new Subject();
                subj.setCd(rs.getString("cd"));
                subj.setName(rs.getString("name"));
                subj.setSchool(school);
                // 他の属性も同様に設定
            }
        
         rs.close(); 
         con.close();
        
        return subjects;
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
