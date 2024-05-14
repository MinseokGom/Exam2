package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;

public class StudentDAO extends DAO {

    public Student get(String cd, String school) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Student student = null;

        try {
            con = getConnection();
            String sql = "SELECT NO, NAME, ENT_YEAR, CLASS_NUM, IS_ATTEND, SCHOOL_CD FROM student WHERE NO = ? AND SCHOOL_CD = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cd);
            pstmt.setString(2, school);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.setNo(rs.getString("NO"));
                student.setName(rs.getString("NAME"));
                student.setEntYear(rs.getInt("ENT_YEAR"));
                student.setClassNum(rs.getString("CLASS_NUM"));
                student.setIsAttend(rs.getBoolean("IS_ATTEND"));
            }
        } catch (SQLException e) {
            throw new Exception("Studentの取得に失敗しました。", e);
        } finally {
            if (rs != null) { rs.close(); }
            if (pstmt != null) { pstmt.close(); }
            if (con != null) { con.close(); }
        }

        return student;
    }

    public List<Student> postfilter(ResultSet rs, School school, String classNum) throws Exception {
        List<Student> students = new ArrayList<>();

        while (rs.next()) {
            Student stu = new Student();
            stu.setNo(rs.getString("NO"));
            stu.setName(rs.getString("NAME"));
            stu.setEntYear(rs.getInt("ENT_YEAR"));
            stu.setClassNum(classNum);
            stu.setIsAttend(rs.getBoolean("IS_ATTEND"));
            stu.setSchool(school);

            students.add(stu);
        }
        return students;
    }

    public List<Student> filter(int entYear, String classNum, School school) throws Exception {
        List<Student> students = new ArrayList<>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            String sql = "SELECT NO, NAME, ENT_YEAR, IS_ATTEND " +
                         "FROM student " +
                         "WHERE SCHOOL_CD = ? AND ENT_YEAR = ? AND CLASS_NUM = ?";
            st = con.prepareStatement(sql);
            st.setString(1, school.getCd());
            st.setInt(2, entYear);
            st.setString(3, classNum);
            rs = st.executeQuery();

            students = postfilter(rs, school, classNum);
        } catch (SQLException e) {
            throw new Exception("Failed to filter students.", e);
        } finally {
            if (rs != null) { rs.close(); }
            if (st != null) { st.close(); }
            if (con != null) { con.close(); }
        }

        return students;
    }
}
