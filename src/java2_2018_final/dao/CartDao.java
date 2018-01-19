package java2_2018_final.dao;

import java.util.List;

import java2_2018_final.model.Cart;

public interface CartDao {
	void save(Cart cart);
	void remove(String c_id, String s_id);
	List<String> getCidByStudent(String s_id);
}
