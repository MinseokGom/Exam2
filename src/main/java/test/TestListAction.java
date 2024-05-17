package test;


import java.io.IOException;

import bean.TestListSubject;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TestListAction extends HttpServlet {

    // The main entry point for handling requests
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // Determine action type from request parameter
        String action = req.getParameter("action");

        if ("setTestListSubject".equals(action)) {
            setTestListSubject(req, res);
        } else if ("setTestListStudent".equals(action)) {
            setTestListStudent(req, res);
        } else {
            res.getWriter().write("Invalid action");
        }
    }

    // Handle setting TestListSubject
    public void setTestListSubject(HttpServletRequest req, HttpServletResponse res) throws IOException {
        TestListSubject subject = new TestListSubject();
        subject.setEntYear(Integer.parseInt(req.getParameter("entYear")));
        subject.setStudentNo(req.getParameter("studentNo"));
        subject.setStudentName(req.getParameter("studentName"));
        subject.setClassNum(req.getParameter("classNum"));

        // Example of adding points
        String[] keys = req.getParameterValues("pointsKey");
        String[] values = req.getParameterValues("pointsValue");

        if (keys != null && values != null) {
            for (int i = 0; i < keys.length; i++) {
                subject.putPoint(Integer.parseInt(keys[i]), Integer.parseInt(values[i]));
            }
        }

        // Set the subject in the request scope
        req.setAttribute("subject", subject);

        // Respond to the client
        res.getWriter().write("TestListSubject set successfully");
    }

    // Handle setting TestListStudent (example)
    public void setTestListStudent(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // This method should be implemented according to the specifics of the student details
        // For example purposes, we are simply responding with a success message
        res.getWriter().write("TestListStudent set successfully");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        execute(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        execute(req, res);
    }
}

//import java.io.IOException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import tool.Action;
//
//public class TestListAction extends Action{
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
//		HttpSession session=req.getSession();
//		
//		
//	}
//	
//	public void setTestListSubject(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
//		
//	}
//	
//	public void setTestListStudent(HttpServletRequest req ,HttpServletResponse res)throws ServletException,IOException{
//		
//	}
//}