package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Test;


public  class ClassNumDao extends DAO{
	public List<Test> filter(School school)throws Exception{
		List<Test>list= new ArrayList<>();
		Connection con=getConnection();
		
		
//		ここ考える
		String query = "SELECT * FROM your_table WHERE class_num = ?";
	    PreparedStatement st = con.prepareStatment(quary);
		st.setString(1,school.getClassNum());
		
		ResultSet rs=st.executeQuery();
		
		while(rs.next()) {
			Test test = new Test();
			
			list.add(test);
		}
		 st.close();
    } catch (SQLException e) {
        throws new Exception("取得に失敗しました",e);
    } finally {
    	 try {
             if (rs != null) { .close(); }
         } catch (SQLException e) {
             throw new Exception("Failed to close resources.", e);
         }
    }

    return list;
}
}
