package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Subject;

public class SubjectDAO extends DAO {

	public Subject get(String cd,String school) throws Exception {
		
        // データベース接続とSQL文の準備
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Subject subject = null;


        try {
            con = getConnection(); // DAOクラスから継承したgetConnectionメソッドを使用
            String sql = "SELECT * FROM subjects WHERE id = ? AND school = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cd);
            pstmt.setString(2, school);

            // SQLの実行と結果の取得
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // 結果からSubjectオブジェクトを生成
                subject = new Subject();
                subject.setCd(rs.getString("id"));
                subject.setName(rs.getString("name"));
                // 他の属性も同様に設定
            }
        } catch (SQLException e) {
            throw new Exception("Subjectの取得に失敗しました。", e);
        } finally {
            // リソースの解放
            if (rs != null) { rs.close(); }
            if (pstmt != null) { pstmt.close(); }
            if (con != null) { con.close(); }
        }

        return subject;
    }


	private List<Subject> subjects = new ArrayList<>();

	public boolean save(Subject subject) {
    // Subjectを保存するロジックを実装
    // 例: subjectsリストに新しいSubjectを追加
		return subjects.add(subject);
	}

	public boolean delete(Subject subject) {
    // Subjectを削除するロジックを実装
    // 例: subjectsリストから該当するSubjectを削除
		return subjects.remove(subject);
	}

}
//test












