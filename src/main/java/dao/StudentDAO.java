import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                student.setNo(rs.getString("NO")); // NO 列にマッピング
                student.setName(rs.getString("NAME")); // NAME 列にマッピング
                student.setEntYear(rs.getInt("ENT_YEAR")); // ENT_YEAR 列にマッピング
                student.setClassNum(rs.getString("CLASS_NUM")); // CLASS_NUM 列にマッピング
                student.setAttend(rs.getBoolean("IS_ATTEND")); // IS_ATTEND 列にマッピング
                student.setSchoolCd(rs.getString("SCHOOL_CD")); // SCHOOL_CD 列にマッピング
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

    private List<Student> students = new ArrayList<>();

    public boolean save(Student student) {
        // Studentを保存するロジックを実装
        // 例: studentsリストに新しいStudentを追加
        return students.add(student);
    }

    public boolean delete(Student student) {
        // Studentを削除するロジックを実装
        // 例: studentsリストから該当するStudentを削除
        return students.remove(student);
    }
}
