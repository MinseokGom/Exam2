package tool;

import bean.Teacher;
import dao.TeacherDAO;
import tool.Action;
import java.servlet.http.*;

//ActionにLoginActionを継承する
public class LoginAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
			)throws Exception {
		
		HttpSession session=request.getSession();
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		TeacherDAO dao=new TeacherDAO();
		Teacher teacher=dao.login(id,password);
		
		if (teacher!=null) {
			session.setAttribute("teacher",teacher);
			return "login-out.jsp";
		}
		
		return "login-error.jsp";
		
	}
	
  
}
