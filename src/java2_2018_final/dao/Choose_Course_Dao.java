package java2_2018_final.dao;

import java.util.List;

import java2_2018_final.model.Choose_Course;

public interface Choose_Course_Dao {
	List<String> getSidByCourse(String c_id);
	List<String> getCidByStudent(String s_id);
	void save(Choose_Course choose_course);
	Choose_Course get(String s_id, String c_id);
	void remove(String c_id, String s_id);
}
