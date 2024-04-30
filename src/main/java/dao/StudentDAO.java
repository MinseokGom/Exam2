package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Student;

public class StudentDAO extends DAO {

	public Student get(String cd,String school) throws Exception {
//		↑すこしいじる
        // データベース接続とSQL文の準備
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Student student = null;


        try {
            con = getConnection(); // DAOクラスから継承したgetConnectionメソッドを使用
            String sql = "SELECT * FROM subjects WHERE id = ? AND school = ?";
//            ↑少しいじる
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cd);
            pstmt.setString(2, school);

            // SQLの実行と結果の取得
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // 結果からStudentオブジェクトを生成
                student = new Student();
//                ↓少しいじる
                student.setCd(rs.getString("id"));
                student.setName(rs.getString("name"));
                // 他の属性も同様に設定
            }
        } catch (SQLException e) {
            throw new Exception("Studentの取得に失敗しました。", e);
        } finally {
            // リソースの解放
            if (rs != null) { rs.close(); }
            if (pstmt != null) { pstmt.close(); }
            if (con != null) { con.close(); }
        }

        return student;
    }


	private List<Student> student = new ArrayList<>();

	public boolean saveStudent student) {
    // Subjectを保存するロジックを実装
    // 例: subjectsリストに新しいSubjectを追加
		return student.add(student);
	}

	public boolean delete(Student student) {
    // Subjectを削除するロジックを実装
    // 例: subjectsリストから該当するSubjectを削除
		return student.remove(student);
	}

}