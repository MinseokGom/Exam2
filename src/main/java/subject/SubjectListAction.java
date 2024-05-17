package subject;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;


public class SubjectListAction extends Action{
		public String execute(
			HttpServletRequest request,HttpServletResponse response
				)throws Exception{
			
			SubjectDAO dao = new SubjectDAO();
			List<String> subjects = new ArrayList<>();
			
					
			return "subject_list.jsp";
		}
	}
	

/**
 * GETリクエストを受け付けて、DBからデータを取得する
 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
		
    // データベースに接続するための情報
    String url = "jdbc:postgresql://localhost:5432/BlogDB";
    String user = "uhablog";
    String password = "P@ssw0rd";
		
    // 本のタイトルを格納するList
    List<String> books = new ArrayList<>();
		
    // データベースに接続する
    try {
        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();){

            // SQLを実行して、テーブルから本のタイトルを取得する
            ResultSet res = st.executeQuery("SELECT title FROM booksinfo");

            // 取得した件数分繰り返す
            while(res.next()) {
                // リストに本のタイトルを追加
                books.add(res.getString("title"));
            }
		
        } catch(SQLException e) {
            e.printStackTrace();
        }
    } catch(ClassNotFoundException e) {
        e.printStackTrace();
    }
		
    // リクエストスコープへオブジェクト設定する
    request.setAttribute("books", books);
	
    // 次の画面に遷移
    request.getRequestDispatcher("/books-list.jsp").forward(request, response);
}