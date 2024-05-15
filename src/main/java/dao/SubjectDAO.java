package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Subject;

public class SubjectDAO extends DAO {

    public List<Subject> filter(School school) throws Exception {
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
    }
}
