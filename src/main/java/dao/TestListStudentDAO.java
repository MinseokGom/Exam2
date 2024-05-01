package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.TestListStudent;


public class TestListStudentDAO extends DAO{
    private String baseSql;
    //list<TestListStudent>
    public List<TestListStudent> PostFilter(set<ResultSet>resultSet){
    	//postFilter メソッドの実装
    	return new ArrayList<>();
    }
    
    public List<TestListStudent> filter(Student student){
    	//filter メソッドの実装
    	return new ArrayList<>();
    }
    
}
