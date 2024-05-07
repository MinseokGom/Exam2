package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Test;

public class TestDAO extends DAO{
	public Test get(Student student, Subject subject,School school, int no) 
			throws Exception{
	  Student stuudent = new Student();
	  Subject subject = new Subject();
	  School school = new School();
	  
	  Connection con= getConnection();
	  
	  PreparedStatement st;
	  st = con.prepareStatement("serect * from student where ent_year=? and class_num=? ");
	  st = con.prepareStatement("serect * from subject where  ");
	}
	
	public List<Test> postFilter(ResultSet rSet, School school){
		List<Test> filteredResults = new ArrayList<>();
		
		try {
			while (rSet.next()) {
				Test test = new Test();
				test.setId(rSet.getInt("id"));
				test.setName(rSet.getString("name"));
				if(test.getSchool().equals(school)) {
					filteredResults.add(test);
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return filteredResults;
	}
	
	public List<Test> filter(int entYear, String classNum, Subject subject, int num, School school){
		return new ArrayList<>();
	}
	
	public boolean save(List<Test> list) {
		return true;
	}
	
	public boolean save(Test test,Connection connection) {
		try {
			
			String sql = "INSERT INTO tests(id, name ,score) VALUSE(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(3, test.getPoint());
            int rowsAffected = preparedStatement.executeUpdate();		
            return rowsAffected();
		}catch(SQLException e ) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean rowsAffected() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	public boolean delete(List<Test> list) {
		return true;
	}
	
	public boolean delete(Test test, Connection connection) {
		try {
			String sql = "DELETE FROM tests WHERE id = ?";
			PreparedStatement preparedStatement= connection.perpareStatement(sql);
			preparedStatement.setInt(1, test.getId());
			int rowsAffected = preparedStatement.executeUpdate();
			
             return rowsAffected == 1;
		}catch (SQLException e ) {
			e.printStackTrace();
			return false;
		}
	}
}


