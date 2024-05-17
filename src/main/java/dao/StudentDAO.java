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

    // Retrieves all students
    public List<Student> getAllStudents() throws Exception {
        List<Student> students = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            String sql = "SELECT NO, NAME, ENT_YEAR, CLASS_NUM, IS_ATTEND, SCHOOL_CD FROM student";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setNo(rs.getString("NO"));
                student.setName(rs.getString("NAME"));
                student.setEntYear(rs.getInt("ENT_YEAR"));
                student.setClassNum(rs.getString("CLASS_NUM"));
                student.setIsAttend(rs.getBoolean("IS_ATTEND"));
                School school = getSchoolByCode(rs.getString("SCHOOL_CD")); 
                student.setSchool(school);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new Exception("Failed to retrieve all students.", e);
        } finally {
            if (rs != null) { rs.close(); }
            if (pstmt != null) { pstmt.close(); }
            if (con != null) { con.close(); }
        }

        return students;
    }

    private School getSchoolByCode(String schoolCd) {
        // This method should retrieve the School object based on schoolCd.
        // For simplicity, we assume it returns a dummy School object here.
        School school = new School();
        school.setCd(schoolCd);
        school.setName("Dummy School");
        return school;
    }

    // Method to process the result set and return a list of students
    public List<Student> postfilter(ResultSet rs, School school) throws Exception {
        List<Student> students = new ArrayList<>();

        while (rs.next()) {
            Student student = new Student();
            student.setNo(rs.getString("NO"));
            student.setName(rs.getString("NAME"));
            student.setEntYear(rs.getInt("ENT_YEAR"));
            student.setClassNum(rs.getString("CLASS_NUM"));
            student.setIsAttend(rs.getBoolean("IS_ATTEND"));
            student.setSchool(school);

            students.add(student);
        }
        return students;
    }

    // Filters students based on school, entry year, class number, and attendance status
    public List<Student> filter(School school, int entYear, String classNum, boolean isAttend) throws Exception {
        List<Student> students = new ArrayList<>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            String sql = "SELECT * FROM student WHERE school_cd = ? AND ent_year = ? AND class_num = ? AND is_attend = ?";
            st = con.prepareStatement(sql);
            st.setString(1, school.getCd());
            st.setInt(2, entYear);
            st.setString(3, classNum);
            st.setBoolean(4, isAttend);
            rs = st.executeQuery();

            students = postfilter(rs, school);
        } catch (SQLException e) {
            throw new Exception("Failed to filter students.", e);
        } finally {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (con != null) con.close();
        }

        return students;
    }

    // Filters students based on school, entry year, and attendance status
    public List<Student> filter(School school, int entYear, boolean isAttend) throws Exception {
        List<Student> students = new ArrayList<>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            String sql = "SELECT * FROM student WHERE school_cd = ? AND ent_year = ? AND is_attend = ?";
            st = con.prepareStatement(sql);
            st.setString(1, school.getCd());
            st.setInt(2, entYear);
            st.setBoolean(3, isAttend);
            rs = st.executeQuery();

            students = postfilter(rs, school);
        } catch (SQLException e) {
            throw new Exception("Failed to filter students.", e);
        } finally {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (con != null) con.close();
        }

        return students;
    }

    // Filters students based on school and attendance status
    public List<Student> filter(School school, boolean isAttend) throws Exception {
        List<Student> students = new ArrayList<>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            String sql = "SELECT * FROM student WHERE school_cd = ? AND is_attend = ?";
            st = con.prepareStatement(sql);
            st.setString(1, school.getCd());
            st.setBoolean(2, isAttend);
            rs = st.executeQuery();

            students = postfilter(rs, school);
        } catch (SQLException e) {
            throw new Exception("Failed to filter students.", e);
        } finally {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (con != null) con.close();
        }

        return students;
    }

    // Saves a student to the database
    public boolean save(Student student) throws Exception {
        Connection con = getConnection();
        PreparedStatement st = null;
        try {
            String sql = "INSERT INTO student (NO, NAME, ENT_YEAR, CLASS_NUM, IS_ATTEND, SCHOOL_CD) VALUES (?, ?, ?, ?, ?, ?)";
            st = con.prepareStatement(sql);
            st.setString(1, student.getNo());
            st.setString(2, student.getName());
            st.setInt(3, student.getEntYear());
            st.setString(4, student.getClassNum());
            st.setBoolean(5, student.getIsAttend());
            st.setString(6, student.getSchool().getCd());
            int result = st.executeUpdate();
            return result > 0;
        } finally {
            if (st != null) st.close();
            if (con != null) con.close();
        }
    }

    // Deletes a student from the database
    public boolean delete(Student student) throws Exception {
        Connection con = getConnection();
        PreparedStatement st = null;
        try {
            String sql = "DELETE FROM student WHERE NO = ? AND SCHOOL_CD = ?";
            st = con.prepareStatement(sql);
            st.setString(1, student.getNo());
            st.setString(2, student.getSchool().getCd());
            int result = st.executeUpdate();
            return result > 0;
        } finally {
            if (st != null) st.close();
            if (con != null) con.close();
        }
    }
}
