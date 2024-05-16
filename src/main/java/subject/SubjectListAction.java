package subject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class SubjectListAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "subject_list.jsp";
	}

}