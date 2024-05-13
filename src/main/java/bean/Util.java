package bean;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

public class Util implements java.io.Serializable{
	 public Teacher getUser(HttpServletRequest request) {
	        // ユーザー情報を取得するロジックを実装
		 
		 
	        // 例えば、セッションからユーザー情報を取得するなど

	        // この部分は適切なロジックに置き換えてください
	        return null;
	    }
     public void setClassNumSet(HttpServletRequest request)throws ServletException, IOException{
    	// ここにsetClassNumSetメソッドの処理を記述してください
         // reqを使って必要な操作を実装してください
         // 例えば、データベースへのクエリ実行やリクエストパラメータの取得など

         // この部分は適切なロジックに置き換えてください
        }
     public void setEntYearSet(HttpServletRequest request)throws ServletException, IOException {
    	// ここにメソッドの処理を記述してください
         // reqを使って必要な操作を実装してください
         // 例えば、データベースへのクエリ実行やリクエストパラメータの取得など

         // この部分は適切なロジックに置き換えてください
     }
     
     public void setSubjects(HttpServletRequest request)throws ServletException, IOException{
    	 
     }
     
     public void setNumSet(HttpServletRequest request)throws ServletException,IOException{
    	 
     }
     
     
}