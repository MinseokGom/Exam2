package test;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class TestListAction extends Action{
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		
	}
	
	public void setTestListSubject(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		return "test_regist.jsp";
	}
	
	public void setTestListStudent(HttpServletRequest req ,HttpServletResponse res)throws ServletException,IOException{
		
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}