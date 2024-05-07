package dao;

import java.util.ArrayList;
import java.util.List;

public class ClassNumDao extends DAO {
   public static void main(String[] args) {
	   List<String> schoolList = new ArrayList<>();
	   
	
	   List<String> filteredSchools = filterSchools(schoolList);
       System.out.println(filteredSchools);
   }
   
   public static List<String> filterSchools(List<String> schools) {
       List<String> filtered = new ArrayList<>();
       for (String school : schools) {
           if (school.contains("School")) {
               filtered.add(school);
           }
       }
       return filtered;
   }
   
}
