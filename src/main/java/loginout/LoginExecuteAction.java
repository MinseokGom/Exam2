package loginout;

import bean.Teacher;
import dao.TeacherDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

//ActionにLoginActionを継承する
public class LoginExecuteAction extends Action{
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
			return "../menu.jsp";
		}
		else {
			return "login-error.jsp";
		}		
	}
}
