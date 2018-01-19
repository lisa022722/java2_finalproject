package java2_2018_final.model;

import com.mysql.jdbc.Driver;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@Column(length=50)
	private String c_id;
	@Column(length=50)
	private String c_org;
	@Column(length=50)
	private String c_name;
	@Column(length=50)
	private String c_teacher;
	@Column(length=50)
	private String c_grade;
	@Column(length=50)
	private String c_dep;
	@Column(length=50)
	private String c_time;
	@Column(length=50)
	private String c_class;
	@Column(length=50)
	private String c_session;
	@Column(length=50)
	private String c_classify;
	@Column(length = 65535, columnDefinition = "text")
	private String c_ps;
	@Column(length = 65535, columnDefinition = "text")
	private String c_target;
	@Column(length = 65535, columnDefinition = "text")
	private String c_content;

	@Column(length=100)
	private String c_books;
	@Column
	private int c_limit;
	@Column
	private int c_score;

	
	public int getC_score() {
		return c_score;
	}

	public void setC_score(int c_score) {
		this.c_score = c_score;
	}

	public String getC_org() {
		return c_org;
	}

	public void setC_org(String c_org) {
		this.c_org = c_org;
	}

	public String getC_teacher() {
		return c_teacher;
	}

	public String getC_dep() {
		return c_dep;
	}

	public void setC_dep(String c_dep) {
		this.c_dep = c_dep;
	}

	public String getC_time() {
		return c_time;
	}

	public void setC_time(String c_time) {
		this.c_time = c_time;
	}

	public void setC_teacher(String c_teacher) {
		this.c_teacher = c_teacher;
	}

	public String getC_grade() {
		return c_grade;
	}

	public void setC_grade(String c_grade) {
		this.c_grade = c_grade;
	}

	public String getC_class() {
		return c_class;
	}

	public void setC_class(String c_class) {
		this.c_class = c_class;
	}

	public String getC_session() {
		return c_session;
	}

	public void setC_session(String c_session) {
		this.c_session = c_session;
	}

	public String getC_classify() {
		return c_classify;
	}

	public void setC_classify(String c_classify) {
		this.c_classify = c_classify;
	}

	public String getC_ps() {
		return c_ps;
	}

	public void setC_ps(String c_ps) {
		this.c_ps = c_ps;
	}

	public String getC_target() {
		return c_target;
	}

	public void setC_target(String c_target) {
		this.c_target = c_target;
	}

	public String getC_content() {
		return c_content;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}

	public String getC_books() {
		return c_books;
	}

	public void setC_books(String c_books) {
		this.c_books = c_books;
	}	

	public int getC_limit() {
		return c_limit;
	}

	public void setC_limit(int c_limit) {
		this.c_limit = c_limit;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	
	
}
