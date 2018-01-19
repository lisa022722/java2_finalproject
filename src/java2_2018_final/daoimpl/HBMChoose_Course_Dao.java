package java2_2018_final.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java2_2018_final.dao.Choose_Course_Dao;
import java2_2018_final.model.Choose_Course;

@Component
public class HBMChoose_Course_Dao implements Choose_Course_Dao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<String> getSidByCourse(String c_id) {
		// TODO Auto-generated method stub
		List<String> list = sessionFactory.getCurrentSession().createQuery("SELECT s_id FROM Choose_Course WHERE c_id = '" + c_id + "'").list();
		return list;
	}

	@Override
	public List<String> getCidByStudent(String s_id) {
		// TODO Auto-generated method stub
		List<String> list = sessionFactory.getCurrentSession().createQuery("SELECT c_id FROM Choose_Course WHERE s_id = '" + s_id + "'").list();

		return list;
	}
	
	@Override
	public void save(Choose_Course choose_course) {
		sessionFactory.getCurrentSession().save(choose_course);
	}

	@Override
	public Choose_Course get(String s_id, String c_id) {
		List<Choose_Course> list = sessionFactory.getCurrentSession().createQuery("FROM Choose_Course WHERE s_id = '" + s_id + "' AND c_id = '" + c_id + "'").list();
		return list.get(0);
	}

	@Override
	public void remove(String c_id, String s_id) {
		Query q = sessionFactory.getCurrentSession().createQuery("DELETE Choose_Course WHERE c_id = '" + c_id + "' AND s_id = '" + s_id + "'");
		q.executeUpdate();
	}
}
