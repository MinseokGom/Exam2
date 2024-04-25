package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.School;
import bean.Teacher;

public class TestDAO extends DAO {
    public Teacher login(String id, String password)
        throws Exception {
        Teacher teacher = new Teacher();
        School school = new School();
        
        Connection con=getConnection(); // getConnection() を呼び出す
        
        PreparedStatement st;
        st = con.prepareStatement(
             "select * from teacher where id=? and password=? ");
        st.setString(1, id);
        st.setString(2, password);
        ResultSet rs = st.executeQuery();
        
        if (rs.next()) { // 結果セットが空でない場合のみ処理する
            teacher.setId(rs.getString("id"));
            teacher.setName(rs.getString("name"));
            teacher.setPassword(rs.getString("password"));
            school.setCd(rs.getString("name"));
            teacher.setSchool(school);
        }
  
        st.close();
        con.close();
        return teacher;
    }
}