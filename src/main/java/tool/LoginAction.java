package tool;

import bean.Teacher;
import dao.TeacherDAO;
import tool.Action;
import jakarta.servlet.http.*;

//ActionにLoginActionを継承する
public class LoginAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
			)throws Exception {
		
		HttpSession session=request.getSession();
		
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		TeacherDAO dao=new TeacherDAO();
		Teacher teacher=dao.search(login,password);
		
		if (teacher!=null) {
			session.setAttribute("teacher",teacher);
			return "login-out.jsp";
		}
		
		return "login-error.jsp"
		
	}
	
  
}
