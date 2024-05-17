package bean;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

public class Util implements java.io.Serializable{
	private Teacher user;
	
	
	 public Teacher getUser(HttpServletRequest request) {
	        return User;	        
	    }
     public void setClassNumSet(HttpServletRequest request)throws ServletException, IOException{
    	    this.classNumSet=classNumSet;
        }
     public void setEntYearSet(HttpServletRequest request)throws ServletException, IOException {
    	    return entYearSet;
     } 
     
     public void setSubjects(HttpServletRequest request)throws ServletException, IOException{
    	    return subject;
     }
     
     public void setNumSet(HttpServletRequest request)throws ServletException,IOException{
    	    return numSet;
     }
     
     
}