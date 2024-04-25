package test;


import bean.Student;
import bean.School;
import dao.TestDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class TestListAction {
	public String execute(
			HttpServletRequest request, HttpServletResponse response
			)throws Exception {
		
		HttpSession session=request.getSession();
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		TestDAO dao=new TestDAO();
		Test test=dao.();
		
		if (school!=null) {
			session.setAttribute("test",test);
			return "../menu.jsp";
		}
		else {
			return "login-error.jsp";
		}
		
		
	}
}
