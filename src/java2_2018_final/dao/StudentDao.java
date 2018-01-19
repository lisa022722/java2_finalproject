package java2_2018_final.dao;

import java.util.List;
import java.util.Map;

import java2_2018_final.model.Student;

public interface StudentDao {
	Student get(String s_id);
	String getName(String s_id);
	void update(String s_id, String email, String phone);
	void delete(Student student);
	void delete(long s_id);
	boolean checkPwd(String s_id, String s_pwd);
	List<Student> search(Map<String,String> conditions);
	List<Student> getAllStudents();
}