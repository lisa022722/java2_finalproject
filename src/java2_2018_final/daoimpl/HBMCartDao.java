package java2_2018_final.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java2_2018_final.dao.CartDao;
import java2_2018_final.model.Cart;

@Component
public class HBMCartDao implements CartDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Cart cart) {
		sessionFactory.getCurrentSession().save(cart);
	}
	
	@Override
	public void remove(String c_id, String s_id){
		Query q = sessionFactory.getCurrentSession().createQuery("DELETE Cart WHERE c_id = '" + c_id + "' AND s_id = '" + s_id + "'");
		q.executeUpdate();
	}

	@Override
	public List<String> getCidByStudent(String s_id) {
		List<String> list = sessionFactory.getCurrentSession().createQuery("SELECT c_id FROM Cart WHERE s_id = '" + s_id + "'").list();
		return list;
	}
}
