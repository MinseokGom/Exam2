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
		PreparedStatement st=con.prepareStatement("select student.no , student.name ,student.ent_year ,subject.name ,test.point ,test.no " );
		
	    st.setString(1,school.getCd());
		st.setInt(2, entYear);
		st.setString(3,classNum);
		st.setString(4,subject.getCd());
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
	
		
		ResultSet rs1=st1.executeQuery();
		
		if(rs1.next()) {
//			ここのSQL文考える。
			SELECT test.no, test.point, student.no, student.name, student.ent_year, subject.cd, subject.name
			FROM test
			INNER JOIN student ON test.student_no = student.no
			INNER JOIN subject ON test.subject_cd = subject.cd
			WHERE student.school_cd = ? AND student.ent_year = ? AND student.class_num = ? AND subject.cd = ?

			PreparedStatement st2=con.prepareStatement("update test set point = ? where student ");
			st2.setInt(1,test.getPoint());
			st2.setString(2,test.getStudent(),getNo());
			st2.setString(3,test.getSubject(),getCd());
			st2.setInt(4,test.getNo());
			st2.setString(5,test.getSchool().getCd());
			return st2.executeUpdate() == 1;
		}else {
//			ここもSQL文考える。
			UPDATE test
			SET point = ?
			WHERE student_no = ? AND subject_cd = ? AND no = ? AND school_cd = ?"+"
			INSERT INTO test (student_no, subject_cd, school_cd, no, point, class_num)
		    VALUES (?, ?, ?, ?, ?, ?)


			PreparedStatement st2=con.prepareStatement("insert into test valuse(???)");
		
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
	
	public List<Test> filter(int entYear, String classNum, Subject subject, int num, School school){
		return new ArrayList<>();
	}
	

