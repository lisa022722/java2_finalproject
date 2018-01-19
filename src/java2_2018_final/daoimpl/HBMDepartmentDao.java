package java2_2018_final.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java2_2018_final.dao.DepartmentDao;

@Component
public class HBMDepartmentDao implements DepartmentDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<String> getAllDepartmentName() {
		// TODO Auto-generated method stub
		List<String> list = sessionFactory.getCurrentSession().createQuery("SELECT d_name FROM Department").list();
		return list;
	}

}
