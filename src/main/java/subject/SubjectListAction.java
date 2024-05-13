package subject;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import bean.Subject;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;


public class SubjectListAction extends Action{
		public String execute(
			HttpServletRequest request,HttpServletResponse response
			)throws Exception{
			
			HttpSession session=request.getSession();

			
			String login=request.getParameter("login");
			String password=request.getParameter("password");
			SubjectDAO dao = new SubjectDAO();
			Subject subj=dao.get(List<Subject> cd,school school);
					
			return "subject_list.jsp";
		}


		
		
		
		if (customer!=null) {
			session.setAttribute("customer", customer);
			return "login-out.jsp";
		}
		return"login-error.jsp";
	}
}
	

