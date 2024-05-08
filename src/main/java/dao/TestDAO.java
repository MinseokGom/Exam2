package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Test;


public class TestDAO extends DAO{
	
	public List<Test> postfilter(ResultSet rSet, School school, String classNum)throws Exception{
		List<Test> list = new ArrayList<>();
		
		while (rSet.next()) {
			Test t=new Test();
			Student stu=new Student();
			stu.setNo(rSet.getString("student.no"));
			stu.setName(rSet.getString("student.name"));
			stu.setEntYear(rSet.getInt("student.ent_year"));
			stu.setClassNum(classNum);
			stu.setIsAttend(rSet.getBoolean("student.is_attend"));
			stu.setSchool(school);
			
			Subject sbj=new Subject();
			sbj.setSchool(school);
			sbj.setCd(rSet.getString("subject.cd"));
			sbj.setName(rSet.getString("subject.name"));
			
			t.setStudent(stu);
			t.setClassNum(classNum);
			t.setSubject(sbj);
			t.setSchool(school);
            t.setNo(rSet.getInt("no"));
            t.setPoint(rSet.getInt("point"));
            
		}
		return list;
	}
	
	public List<Test> filter(int entYear, String classNum, Subject subject ,int num , School school)throws Exception{
		List<Test>list= new ArrayList<>();
		Connection con=getConnection();
		
		String target= num ==1 ? "a.no.as no, a.point as point ":"b.no as no,b.point as point ";
//		ここ考える
		PreparedStatment st=con.preparedStatement("select student.no , student.name, ")
		
	    st.setString(1,school.getCd());
		st.setInt(2, entYear);
		st.setString(3,classNum);
		st.setString(4,subject.getCD());
		ResultSet rs=st.executeQuery();
		
		list = postfilter(rs.school,classNum);
		
		st.close();
		con.close();

		return list;
	}
	
	private boolean save (Test test, Connection con)throws Exception{
		PreparedStatement st1=con.prepareStatement("Select * from test where student_no = ? and subject_cd = ? and school_cd = ?");
	    st1.setString(1, test.getStudent().getNo());
		st1.setString(2, test.getSubject().getCd());
		st1.setInt(3, test.getNo());
		st1.setString(4, test.getSchool().getCd());
	
		
		ResultSet rs1=st1.executeQeary();
		
		if(rs1.next()) {
			PreparedStatement st2=con.prepareStatement("update test set point = ? where student ");
			st2.setInt(1,test.getPoint());
			st2.setString(2,test.getStudent(),getNo());
			st2.setString(3,test.getSubject(),getCd());
			st2.setInt(4,test.getNo());
			st2.setString(5,test.getSchool().getCd());
			return st2.executeUpdate() == 1;
		}else {
			PraparedStatement st2=con.preparStatement("insert into test valuse(???)");
		
			st2.setString(1, test.getStudent(),getNo());
			st2.setString(2, test.getSubject(),getCd());
			st2.setString(3, test.getSchool().getCd());
			st2.setInt(4, test.getNo());
			st2.setInt(5,test.getPoint());
			st2.setString(6,test.getClassNum());
			return st2.executeUpdate() == 1;
		}

	}
	public boolean save(List<Test>list)throws Exception{
		Connection con= getConnection();
		boolean isError = false;
		for(Test test : list) {
			if(!save(test,con)) {
				isError = true;
				break;
			}
		}
		return isError;
	}
}
	
	
	
//	public Test get(Student student, Subject subject,School school, int no) 
//			throws Exception{
//	  Student stuudent = new Student();
//	  Subject subject = new Subject();
//	  School school = new School();
//	  
//	  Connection con= getConnection();
//	  
//	  PreparedStatement st;
//	  st = con.prepareStatement(
//			  "serect * from student where ent_year=? and class_num=? ");
//	  PreparedStatement su;
//	  su = con.prepareStatement(
//			  "serect * from subject where name=? ");
//	  
//	  
//	  st.setString(1,ent_year);
//	  su.setString(2,class_num);
//	  su.setString(3,name);
//	  
//	  ResultSet rs = st.executeQuery();
//	  ResultSet rs = su.executeQuery();
//	  
//	  if (rs)
//	  
//	}
//	
//	public List<Test> postFilter(ResultSet rSet, School school){
//		List<Test> filteredResults = new ArrayList<>();
//		
//		try {
//			while (rSet.next()) {
//				Test test = new Test();
//				test.setEnt_year(rSet.getInt("ent_year"));
//				test.setName(rSet.getString("name"));
//				
//				if(test.getSchool().equals(school)) {
//					filteredResults.add(test);
//				}
//			}
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return filteredResults;
//	}
//	
//	public List<Test> filter(int entYear, String classNum, Subject subject, int num, School school){
//		return new ArrayList<>();
//	}
//	
//	public boolean save(List<Test> list) {
//		return true;
//	}
//	
//	public boolean save(Test test,Connection connection) {
//		try {
//			
//			String sql = "INSERT INTO tests(id, name ,score) VALUSE(?,?,?)";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setDouble(3, test.getPoint());
//            int rowsAffected = preparedStatement.executeUpdate();		
//            return rowsAffected();
//		}catch(SQLException e ) {
//			e.printStackTrace();
//			return false;
//		}
//	}
//	
//	private boolean rowsAffected() {
//		// TODO 自動生成されたメソッド・スタブ
//		return false;
//	}
//
//	
//    
//}