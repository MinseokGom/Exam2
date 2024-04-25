
package student;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class StudentListAction extends Action{
	public String execute(
		HttpServletRequest request,HttpServletResponse response
			)throws Exception{
		
		return "ここ何が入るの？";
	}
}