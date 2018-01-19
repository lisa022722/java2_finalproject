package java2_2018_final.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java2_2018_final.dao.CourseDao;
import java2_2018_final.model.Course;
import java2_2018_final.model.Student;

@Component
public class HBMCourseDao implements CourseDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Course get(String c_id) {
		// TODO Auto-generated method stub
		return (Course) sessionFactory.getCurrentSession().get(Course.class, c_id);
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		List<Course> list = sessionFactory.getCurrentSession().createQuery("FROM Course").list();	
		
		return list;
	}

	@Override
	public List<Course> selectCourseByDepName(String d_name) {
		// TODO Auto-generated method stub
		
		List<Course> list = sessionFactory.getCurrentSession().createQuery("FROM Course WHERE c_dep = '" + d_name + "'").list();
		System.out.println(list.get(0).getC_name());
		return list;
	}

}
