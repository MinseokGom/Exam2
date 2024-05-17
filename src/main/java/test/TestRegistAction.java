package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TestRegistAction extends HttpServlet {

    // The main entry point for handling requests
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // Determine action type from request parameter
        String action = req.getParameter("action");

        if ("setRequestData".equals(action)) {
            setRequestData(req, res);
        } else {
            res.getWriter().write("Invalid action");
        }
    }

    // Handle setting request data
    public void setRequestData(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // Retrieve parameters from the request
        String param1 = req.getParameter("param1");
        String param2 = req.getParameter("param2");

        // Example of processing the parameters
        // This can be any logic based on the application requirements
        if (param1 != null && param2 != null) {
            // Store the data in the request scope
            req.setAttribute("param1", param1);
            req.setAttribute("param2", param2);

            // Forward to a JSP or another servlet for further processing
            req.getRequestDispatcher("/success.jsp").forward(req, res);
        } else {
            // Handle missing parameters
            res.getWriter().write("Missing parameters");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        execute(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        execute(req, res);
    }
}

//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import tool.Action;
//
//public class TestRegistAction extends Action{
//   public void execute(HttpServletRequest req, HttpServletResponse res) {
//	   
//   }
//   
//   public void setRequestDate(HttpServletRequest req, HttpServletResponse res) {
//	   
//   }
//   
//}
