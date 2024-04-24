package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.;
import bean.;

public class StudentDAO extends DAO {
    public Student login(String id, String password)
        throws Exception {
        Student student = new Student();
        School school = new School();
        
        Connection con=getConnection(); // getConnection() を呼び出す
        
        PreparedStatement st;
        st = con.prepareStatement(
             "select * from STUDENT where IS_ATTEND TRUE");
        st.setString(1, id);
        st.setString(2, password);
        ResultSet rs = st.executeQuery();
        
        if (rs.next()) { // 結果セットが空でない場合のみ処理
            student.setId(rs.getString("id"));
            student.setName(rs.getString("name"));
            student.setPassword(rs.getString("password"));
            school.setCd(rs.getString("name"));
            student.setSchool(school);
        }
  
        st.close();
        con.close();
        return student;
    }
}
