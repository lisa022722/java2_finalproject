package java2_2018_final.dao;

import java.util.List;

import java2_2018_final.model.Course;

public interface CourseDao {
	Course get(String c_id);
	List<Course> getAllCourses();
	List<Course> selectCourseByDepName(String d_name);
}
