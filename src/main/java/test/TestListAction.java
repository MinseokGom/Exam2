package test;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestListAction extends Action{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		HttpSession session=req.getSession();
		
		
	}
	
	public void setTestListSubject(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
	}
	
	public void setTestListStudent(HttpServletRequest req ,HttpServletResponse res)throws ServletException,IOException{
		
	}
}