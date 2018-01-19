package java2_2018_final.daoimpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java2_2018_final.dao.StudentDao;
import java2_2018_final.model.Student;


@Component
public class HBMStudentDao implements StudentDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Student get(String s_id) {
		// TODO Auto-generated method stub
		return (Student) sessionFactory.getCurrentSession().get(Student.class, s_id);
	}
	
	@Override
	public boolean checkPwd(String s_id, String s_pwd) {
		List<String> studentIds = sessionFactory.getCurrentSession().createQuery("SELECT s_id FROM Student").list();
		for(int i = 0; i < studentIds.size(); i++)
		{
			System.out.println(studentIds.get(i));
			if(studentIds.get(i).equals(s_id))
			{
				List<String> pwd = sessionFactory.getCurrentSession().createQuery("SELECT s_pwd FROM Student WHERE s_id = '"+s_id+"'").list();
				if(pwd.get(0).equals(s_pwd))
					return true;
			}
		}
		
		return false;
	}

	@Override
	public void update(String s_id, String email, String phone) {
		Query q =sessionFactory.getCurrentSession().createQuery("UPDATE Student SET s_email='"+email+"', s_phone='" + phone + "' WHERE s_id = '" + s_id + "'");
		q.executeUpdate();
	}

	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long s_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> search(Map<String, String> conditions) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Student> getAllStudents(){
		
		List<Student> list = sessionFactory.getCurrentSession().createQuery("FROM Student").list();
		return list;
	}
	
	@Override
	public String getName(String s_id) {
		List<String> list = sessionFactory.getCurrentSession().createQuery("SELECT s_name FROM Student WHERE s_id ='" + s_id + "'").list();
		return list.get(0);
	}
	
}
