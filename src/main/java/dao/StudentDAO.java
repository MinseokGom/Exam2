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

    // Existing methods...

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
                // Assuming you have a method to fetch school details by SCHOOL_CD
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
}
