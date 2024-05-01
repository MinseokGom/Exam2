package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.TestListSubject;


public class TestListSubjectDAO {
  
	public List<TestListSubject> postFilter(String baseSql){
		return null;
	}
	
	public List<TestListSubject> postFilter(ResultSet rSet){
		List<TestListSubject>filteredResults = new ArrayList<>();
		
		try {
			while(rSet.next()) {
				TestListSubject subject=new TestListSubject();
				subject.setId(rSet.getInt("id"));
				subject.setName(rSet.getString("name"));
				filteredResults.add(subject);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public List<TestListSubject> filter(int entYear, String classNum, Subject subject,School school){
		List<TestListSubject> filteredResults = new ArryList<>();
		return filteredResults;
		
	}
}
