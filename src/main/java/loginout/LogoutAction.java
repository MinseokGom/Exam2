package loginout;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class LogoutAction extends Action {
    public String execute(
    		HttpServletRequest request, HttpServletResponse response
    		)throws Exception{
    	
    	return "logout-out.jsp";
    }
    
}