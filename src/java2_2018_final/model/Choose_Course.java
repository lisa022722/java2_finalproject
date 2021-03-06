package java2_2018_final.model;

import com.mysql.jdbc.Driver;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="choose_course")
public class Choose_Course {

	@Id
	@Column(length=50)
	private String s_id;
	
	@Column(length=30)
	private String c_id;
	
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	
}
