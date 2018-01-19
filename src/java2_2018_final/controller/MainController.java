package java2_2018_final.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java2_2018_final.dao.CartDao;
import java2_2018_final.dao.Choose_Course_Dao;
import java2_2018_final.dao.CourseDao;
import java2_2018_final.dao.DepartmentDao;
import java2_2018_final.dao.StudentDao;
import java2_2018_final.model.Cart;
import java2_2018_final.model.Choose_Course;
import java2_2018_final.model.Course;
import java2_2018_final.model.Student;

import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class MainController {
	
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private Choose_Course_Dao choose_course_Dao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@RequestMapping("studentresult")
	@Transactional
	public String updatStudentInfo(@RequestParam("email") String email, @RequestParam("phone") String phone, Model model, HttpSession session){
		if(session.getAttribute("s_id") == null)
			return "redirect:login";
		
		
		String sid = (String)session.getAttribute("s_id");
		studentDao.update(sid,email,phone);
		Student me = studentDao.get(sid);
		
		model.addAttribute("me", me);
		return "student_result";
	}
	
	@RequestMapping("student")
	@Transactional
	public String showStudentInfo(Model model, HttpSession session){
		if(session.getAttribute("s_id") == null)
			return "redirect:login";
		
		String sid = (String)session.getAttribute("s_id");
		Student me = studentDao.get(sid);
		
		model.addAttribute("me", me);
		return "student";
	}
	
	@RequestMapping(value = "filtercourses_list", method=RequestMethod.POST)
	@Transactional
	public String filter_courses_list(@RequestParam("d_name") String d_name, Model model, HttpSession session) throws JSONException{
		if(session.getAttribute("s_id") == null)
			return "redirect:login";
		
		String sid = (String)session.getAttribute("s_id");
		
		List<Course> courses = courseDao.selectCourseByDepName(d_name);
		model.addAttribute("courses", courses);		
		return "filter_course_list";
	}
	
	@RequestMapping(value = "filtercourses", method=RequestMethod.POST)
	@Transactional
	public String filter_courses(@RequestParam("d_name") String d_name, Model model, HttpSession session) throws JSONException{
		if(session.getAttribute("s_id") == null)
			return "redirect:login";
		
		String sid = (String)session.getAttribute("s_id");
		
		List<Course> courses = courseDao.selectCourseByDepName(d_name);
		model.addAttribute("courses", courses);		
		return "filter_course";
	}
	
	@RequestMapping("studentlist")
	@Transactional
	public String showStudentList(@RequestParam("c_id") String c_id, Model model, HttpSession session) throws JSONException{
		if(session.getAttribute("s_id") == null)
			return "redirect:login";
		
		
		String sid = (String)session.getAttribute("s_id");
		
		List<String> studentIds = choose_course_Dao.getSidByCourse(c_id);
		List<Student> students = new ArrayList<Student>();
		
		for(int i = 0; i < studentIds.size(); i++) 
		{
			Student st = studentDao.get(studentIds.get(i));
			students.add(st);
		}
		
		model.addAttribute("students", students);
		
		return "course_list";
	}
	
	@RequestMapping("deleteFromCart")
	@Transactional
	public String removeCart(@RequestParam("c_id") String c_id, Model model, HttpSession session) throws JSONException{
		if(session.getAttribute("s_id") == null)
			return "redirect:login";
		
		String sid = (String)session.getAttribute("s_id");
		
		cartDao.remove(c_id, sid);
		
		return "redirect:cart";
	}
	
	@RequestMapping("deleteFromChoose")
	@Transactional
	public String removeChoose(@RequestParam("c_id") String c_id, Model model, HttpSession session) throws JSONException{
		if(session.getAttribute("s_id") == null)
			return "redirect:login";
		
		String sid = (String)session.getAttribute("s_id");
		
		choose_course_Dao.remove(c_id, sid);
		
		return "redirect:elective";
	}
	
	@RequestMapping("cart")
	@Transactional
	public String showCart(Model model, HttpSession session) throws JSONException{
		if(session.getAttribute("s_id") == null)
			return "redirect:login";
		
		String sid = (String)session.getAttribute("s_id");
		
		List<String> myCartCourses = cartDao.getCidByStudent(sid);
		List<Course> myCartCourseList = new ArrayList<Course>();
		
		
		for(int i = 0; i < myCartCourses.size(); i++)
		{
			myCartCourseList.add(courseDao.get(myCartCourses.get(i)));
		}
		List<String> myCartCourseSessions = getChineseCourseSession(myCartCourseList);
		model.addAttribute("myCartCourseSessions", myCartCourseSessions);
		model.addAttribute("myCartCourses", myCartCourseList);		
		return "choose";
	}
	
	@RequestMapping(value = "/addtocollection", method=RequestMethod.POST)
	@Transactional
	public String addToCart(@RequestParam("c_id") String c_id, Model model, HttpSession session){
		if(session.getAttribute("s_id") == null)
			return "redirect:login";
		
		
		System.out.println("878787");
		String sid = (String)session.getAttribute("s_id");
		
		List<String> nowCart = cartDao.getCidByStudent(sid);
		
		for(int i = 0; i < nowCart.size(); i++)
		{
			if(nowCart.get(i).equals(c_id))
			{
				model.addAttribute("result", "repeated");		
				return "add_to_cart_result";
			}
		}
		
		Cart cart = new Cart();
		cart.setC_id(c_id);
		cart.setS_id(sid);
		
		cartDao.save(cart);
		
		model.addAttribute("result", "success");		
		return "add_to_cart_result";
	}
	
	
	@RequestMapping(value = "/addtochoosegeneral", method=RequestMethod.POST)
	@Transactional
	public String addToChooseGeneral(@RequestParam("c_id") String c_id, Model model, HttpSession session) throws JSONException{
		if(session.getAttribute("s_id") == null)
			return "redirect:login";
		
		if(c_id.equals("none"))
			return "redirect:elective";
		
		String sid = (String)session.getAttribute("s_id");
		
		List<String> nowChoose = choose_course_Dao.getCidByStudent(sid);
		Course newCourse = courseDao.get(c_id);
		int score = 0;
		for(int i = 0; i < nowChoose.size(); i++)
		{
			Course thisCourse =  courseDao.get(nowChoose.get(i));
			score += thisCourse.getC_score();
		}
		if(score + newCourse.getC_score() > 25)
		{
			model.addAttribute("result", "filled");		
			return "elective";
		}
		
		for(int i = 0; i < nowChoose.size(); i++)
		{
			if(nowChoose.get(i).equals(c_id))
			{
				System.out.print(nowChoose.get(i));
				model.addAttribute("result", "repeated");		
				return "elective";
			}
			Course thisCourse =  courseDao.get(nowChoose.get(i));
			if(checkRush(newCourse.getC_session(), thisCourse.getC_session()))
			{
				model.addAttribute("result", "rush");		
				return "elective";
			}
		}
		
		Choose_Course cc = new Choose_Course();
		cc.setC_id(c_id);
		cc.setS_id(sid);
		
		choose_course_Dao.save(cc);
		
		model.addAttribute("result", "success");		
		return "redirect:elective";
	}
	
	@RequestMapping(value = "/addtochoose", method=RequestMethod.POST)
	@Transactional
	public String addToChoose(@RequestParam("c_id") String c_id, Model model, HttpSession session) throws JSONException{
		if(session.getAttribute("s_id") == null)
			return "redirect:login";
		
		if(c_id.equals("none"))
			return "elective";
		
		String sid = (String)session.getAttribute("s_id");
		Course newCourse = courseDao.get(c_id);
		List<String> nowChoose = choose_course_Dao.getCidByStudent(sid);
		System.out.print(nowChoose.toString());
		
		int score = 0;
		for(int i = 0; i < nowChoose.size(); i++)
		{
			Course thisCourse =  courseDao.get(nowChoose.get(i));
			score += thisCourse.getC_score();
		}
		if(score + newCourse.getC_score() > 25)
		{
			model.addAttribute("result", "filled");		
			return "add_to_choose_result";
		}
		
		for(int i = 0; i < nowChoose.size(); i++)
		{
			if(nowChoose.get(i).equals(c_id))
			{
				System.out.print(nowChoose.get(i));
				model.addAttribute("result", "repeated");		
				return "add_to_choose_result";
			}
			Course thisCourse =  courseDao.get(nowChoose.get(i));
			if(checkRush(newCourse.getC_session(), thisCourse.getC_session()))
			{
				model.addAttribute("result", "rush");		
				return "add_to_choose_result";
			}
		}
		
		Choose_Course cc = new Choose_Course();
		cc.setC_id(c_id);
		cc.setS_id(sid);
		
		choose_course_Dao.save(cc);
		
		model.addAttribute("result", "success");		
		return "add_to_choose_result";
	}
	
	@RequestMapping("/")
	@Transactional
	public String showIndex(Model model, HttpSession session){
		if(session.getAttribute("s_id") == null)
			return "redirect:login";
		
		String sid = (String)session.getAttribute("s_id");
		model.addAttribute("s_name", studentDao.getName(sid));		
		return "index";
	}
    
    @RequestMapping("/course_content")
	@Transactional
	public String showCourseContent(@RequestParam(value="c_id", defaultValue="") String c_id, Model model) throws SQLException, JSONException {
		Course thisCourse = courseDao.get(c_id);
		model.addAttribute("course", thisCourse);
    	return "course_content";
	}
    
    @RequestMapping("/elective")
	@Transactional
	public String doElective(Model model, HttpSession session) throws SQLException, JSONException {
//		
    	System.out.println("@@@@@@@@@@@@");
    	if(session.getAttribute("s_id") != null)
    	{
    		String sid = (String) session.getAttribute("s_id");
    		System.out.println(sid);
        	
        	List<String> list = choose_course_Dao.getCidByStudent(sid);
        	List<Course> courses = new ArrayList<Course>();
        	int score = 0;
        	for(int i = 0; i < list.size(); i++) {
        		String c_id = list.get(i);
        		Course thisCourse = courseDao.get(c_id);
        		courses.add(thisCourse);
        		score += thisCourse.getC_score();
        	}
        	List<String> classSessions;
    		classSessions = getChineseCourseSession(courses);    		
    		List<String> depList = departmentDao.getAllDepartmentName();
    		
    		
        	model.addAttribute("myScore", score);
    		model.addAttribute("departments", depList);
        	model.addAttribute("courses", courses);
        	model.addAttribute("courseSessions", classSessions);
        	
    	}    	
    	
    	else
    	{

    		return "redirect:login";
    	}
    	
    	return "elective";
	}    
    
	
	@RequestMapping("/course")
	@Transactional
	public String showCourse(Model model, HttpSession session) throws SQLException, JSONException {
		List<Course> courses = courseDao.getAllCourses();
		System.out.println(courses.get(0).getC_score());
		List<String> classSessions;
		classSessions = getChineseCourseSession(courses);
		
		List<String> depList = departmentDao.getAllDepartmentName();
    	
		model.addAttribute("departments", depList);
		model.addAttribute("courses",courses);
		model.addAttribute("courseSessions",classSessions);		
		return "course";
	}
	
	@RequestMapping("login")
	@Transactional
	public String showLogin(Model model){
		
		return "login";
	}
	
	@RequestMapping("logout")
	@Transactional
	public String doLogout(Model model, HttpSession session){
		session.removeAttribute("s_id");
		return "redirect:/";
	}
		
	@RequestMapping(value = "/checklogin", method=RequestMethod.POST)
	@Transactional
	public String dologin(@RequestParam("s_id") String s_id, @RequestParam("s_pwd") String s_pwd, Model model, HttpSession session) throws SQLException, JSONException {
		
		if(studentDao.checkPwd(s_id, s_pwd))
		{
			session.setAttribute("s_id",s_id);
			return "redirect:/";
		}
			
		else
			return "redirect:login_error";
	}
	
	@RequestMapping("login_error")
	@Transactional
	public String loginError(Model model) {
		return "login_error";
	}
	
	List<String> getChineseCourseSession(List<Course> courses) throws JSONException{
		List<String> classSessions = new ArrayList<String>();
		for(int i = 0; i < courses.size(); i++)
		{
				System.out.println(courses.get(i).getC_name());
				JSONObject root = new JSONObject(courses.get(i).getC_session());
				
				JSONArray a = root.getJSONArray("time");
				
				String courseSession = "星期";
				
				int nowDay = 0;
				 for (int n = 0; n < a.length(); n++) 
				 {
					 JSONObject result = (JSONObject)a.get(n);
					 int day = (int)(result.get("day"));
					 int session = (int)result.get("session");
					 
					 if(day == nowDay)
					 {
						 courseSession = courseSession + "," + session;
					 }
					 else
					 {
						 nowDay = day;
						 if(n != 0)
							 courseSession = courseSession + "節<br>星期";
						 courseSession = courseSession + toChineseNumber(day) + "：第" + session; 
					 }
				 }
				 courseSession = courseSession + "節";
				 classSessions.add(courseSession);
		}
		return classSessions;
	}
	
	@RequestMapping(value="/login_check", method=RequestMethod.POST)
	public String checkLogin(Model model) throws SQLException {		
		return "course";
	}
	
	boolean checkRush(String session1, String session2) throws JSONException 
	{
		JSONObject root = new JSONObject(session1);
		JSONArray a = root.getJSONArray("time");
		
		JSONObject root2 = new JSONObject(session2);
		JSONArray b = root2.getJSONArray("time");
		
		for (int n = 0; n < a.length(); n++) 
		 {
			 JSONObject result = (JSONObject)a.get(n);
			 int day = (int)(result.get("day"));
			 int sess = (int)result.get("session");
			 
			 for(int k = 0; k < b.length(); k++)
			 {
				 JSONObject result2 = (JSONObject)b.get(k);
				 int day2 = (int)(result2.get("day"));
				 int sess2 = (int)result2.get("session");
				 if(day == day2 && sess == sess2)
					 return true;
			 }
		 }
		
		return false;
	}
	
	String toChineseNumber(int num) {
		if(num == 1)
			return "一";
		else if(num == 2)
			return "二";
		else if(num == 3)
			return "三";
		else if(num == 4)
			return "四";
		else if(num == 5)
			return "五";
		else if(num == 6)
			return "六";
		else if(num == 7)
			return "日";
		else
			return "無";
	}
}