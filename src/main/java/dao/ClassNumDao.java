package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dao.DAO;
import bean.School;

public  class classNumDao extends DAO{
	public List<Test> filter(School school)throws Exception{
		List<Test>list= new ArrayList<>();
		Connection con=getConnection();
		
		School school= new school;
		
//		ここ考える
		PreparedStatement st=con.prepareStatement("");
		
	    st.setString(classNum);
		ResultSet rs=st.executeQuery();
		
		list = postfilter(rs.school,classNum);
		
		st.close();
		con.close();

		return list;
	}
}