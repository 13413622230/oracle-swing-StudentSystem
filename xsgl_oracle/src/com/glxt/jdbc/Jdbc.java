package com.glxt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.glxt.model.Course;
import com.glxt.model.Student;
import com.glxt.model.Teacher;
import com.glxt.modelData.Stu_Score;

public class Jdbc {
	//这里可以设置数据库名称
    private final static String URL = "jdbc:mysql://localhost:3306/xsgl" ;  
    private static final String USER="root";
    private static final String PASSWORD="123123";
    
    //静态代码块（将加载驱动、连接数据库放入静态块中）
    
    private static Connection con=null;
    //静态代码块（将加载驱动、连接数据库放入静态块中）
    static{
        try {
            //1.加载驱动程序
        	Class.forName("com.mysql.jdbc.Driver") ;
            //2.获得数据库的连接
            con=(Connection)DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //对外提供一个方法来获取数据库连接
    public static Connection getConnection(){
        return con;
    }
	//学生登陆功能
	public static Student login(String id,String pw){
		
		String sql = "select * from students where stu_id="+id+";";
		try{
			Statement stat = con.createStatement();
			ResultSet re = stat.executeQuery(sql);
			if(re.next()){
				if(re.getString("stu_pw").equals(pw)){
					Student student = new Student(re.getInt("stu_id")+"", re.getString("stu_pw"), re.getString("stu_name"), re.getString("stu_sex"), re.getInt("stu_age"), re.getString("stu_major"), re.getString("stu_class"));
					student.setType(1);
					return student;
				}
				else{
					Student student = new Student(null, null, null, null, 0, null, null);
					student.setType(0);
					return student;
				}
			}
			else{
				Student student = new Student(null, null,null, null, 0, null, null);
				student.setType(-1);
				re.close();
				return student;
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("有错");
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//教师登陆功能
	public static Teacher tea_login(String id,String pw){
		
		String sql = "select * from teachers where tea_id="+id+";";
		try{
			Statement stat = con.createStatement();
			ResultSet re = stat.executeQuery(sql);
			if(re.next()){
				if(re.getString("tea_pw").equals(pw)){
					Teacher teacher = new Teacher(re.getInt("tea_id")+"", re.getString("tea_pw"), re.getString("tea_name"), re.getString("tea_sex"),re.getInt("tea_age"));
					teacher.setType(1);
					return teacher;
				}
				else{
					Teacher teacher = new Teacher(null, null, null, null, 0);
					teacher.setType(0);
					re.close();
					return teacher;
				}
			}
			else{
				Teacher teacher = new Teacher(null, null, null, null, 0);
				teacher.setType(-1);
				re.close();
				return teacher;
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("有错");
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	//教师刷新功能
	public static Teacher Flush(String id){
		
		String sql = "select * from teachers where tea_id="+id+";";
		try{
			Statement stat = con.createStatement();
			ResultSet re = stat.executeQuery(sql);
			if(re.next()){
				Teacher teacher = new Teacher(re.getInt("tea_id")+"", re.getString("tea_pw"), re.getString("tea_name"), re.getString("tea_sex"),re.getInt("tea_age"));
				teacher.setType(1);
				return teacher;
			}
			else{
				Teacher teacher = new Teacher(null, null, null, null, 0);
				teacher.setType(-1);
				re.close();
				
				return teacher;
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("有错");
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	//获取该学生全部课程信息和课程分数
	public static ArrayList<Stu_Score> getnumber(String id){
		Connection con =getConnection();
		String sql = "select c.*,sc.cou_num,t.tea_name " +
				"from students s, score sc , courses c,teachers t " +
				"where s.stu_id = sc.stu_id and sc.cou_id = c.cou_id and " +
				"t.tea_id=c.tea_id and s.stu_id="+id+";";
		try {
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			ArrayList<Stu_Score> scores = new ArrayList<Stu_Score>();
			while(rs.next()){
				Stu_Score score = new Stu_Score();
				score.setCourse_id(rs.getInt("cou_id"));
				score.setCourseName(rs.getString("cou_name"));
				if(rs.getString("cou_num")==null||rs.getString("cou_num").length()==0){
					score.setScore(-1);
				}
				else{
					score.setScore(rs.getDouble("cou_num"));
				}
				score.setStudent_id(Integer.parseInt(id));
				score.setTeacherName(rs.getString("tea_name"));
				scores.add(score);
			}
			rs.close();
			
			return scores;
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//查看全部课程
	public static ArrayList<Course> see_cou(){
		Connection con =getConnection();
		String sql = "select c.*,t.tea_name,type_.name type__ from courses c,teachers t,type_ where c.state = '授课中' and t.tea_id=c.tea_id and c.t_id = type_.id;";
		Statement stat;
		try{
			stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			ArrayList<Course> courses = new ArrayList<Course>();
			while(rs.next()){
				Course course = new Course();
				course.setTeacher_id(rs.getString("tea_id"));
				course.setTeacher_name(rs.getString("tea_name"));
				course.setCourse_id(rs.getInt("cou_id"));
				course.setMax(rs.getInt("cou_snum"));
				course.setName(rs.getString("cou_name"));
				course.setNumber(rs.getInt("cou_lnum"));
				course.setCredit(rs.getInt("cou_fen"));
				course.setTerm(rs.getString("cou_time"));
				course.setTime(rs.getString("cou_ctime"));
				course.setState(rs.getString("state"));
				course.setType(rs.getString("type__"));
				courses.add(course);
			}
			return courses;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static String[] getItem(){
		Connection con =getConnection();
		String sql = "select * from type_;";
		Statement stat;
		try{
			stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			rs.last();
			String[] courses = new String[rs.getRow()];
			rs.beforeFirst();
			int i =0;
			while(rs.next()){
				courses[i] = rs.getString("name");
				i++;
			}
			return courses;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	//学生选课模块选定课程
	public static boolean selectCourse(String cou_id,String id,String cou_lnum){
		Connection con =getConnection();
		String sql = "insert into score(stu_id,cou_id) values("+id+","+cou_id+");";
		String sql_ = "update courses set cou_lnum = cou_lnum+1 where cou_id="+cou_id+";";
		Statement stat;
		try {
			stat = con.createStatement();
			if(stat.executeUpdate(sql)==1){
				if(stat.executeUpdate(sql_)==1){
					return true;
				}
				else
					return false;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//学生修改密码
	public static boolean setpw(String stu_pw,String newpw,String id){
		Connection con =getConnection();
		String sql = "select * from students where stu_id="+id+";";
		String sql_ = "update students set stu_pw ='"+newpw+"' where stu_id="+id+";";
		Statement stat;
		try {
			stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			rs.next();
			if(rs.getString("stu_pw").equals(stu_pw)){
				if(stat.executeUpdate(sql_)==1){
					return true;
				}
				else{
					return false;
				}
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//教师修改密码
	public static boolean setTeapw(String tea_pw,String newpw,String id){
		Connection con =getConnection();
		String sql = "select * from teachers where tea_id="+id+";";
		String sql_ = "update teachers set tea_pw ='"+newpw+"' where tea_id="+id+";";
		Statement stat;
		try {
			stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			rs.next();
			if(rs.getString("tea_pw").equals(tea_pw)){
				if(stat.executeUpdate(sql_)==1){
					return true;
				}
				else{
					return false;
				}
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//获取该教师的全部课程
	public static ArrayList<Course> getCourse(String id){
		Connection con =getConnection();
		String sql="select *,type_.name type__ from courses,type_ where courses.tea_id="+id+" and courses.t_id = type_.id;";
		Statement stat;
		try{
			stat=con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			ArrayList<Course> courses = new ArrayList<Course>();
			while(rs.next()){
				Course course = new Course(rs.getInt("cou_id"), rs.getString("cou_name"), 
						rs.getString("cou_time"), rs.getString("cou_ctime"), rs.getInt("cou_fen")
						, rs.getInt("cou_snum"), rs.getInt("cou_lnum"));
				course.setState(rs.getString("state"));
				course.setType(rs.getString("type__"));
				courses.add(course);
			}
			return courses;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	//查看课程里面全部学生
	public static ArrayList<Student> getStudent(String teacher_id){
		Connection con =getConnection();
		String sql = "select * " +
				"from students where stu_id in " +
				"(select sc.stu_id from score sc , courses c,teachers t " +
				"where sc.cou_id = c.cou_id and t.tea_id=c.tea_id and t.tea_id = " +
				teacher_id+" group by sc.stu_id);";
		System.out.println(sql);
//		String sql="select s.*" +
//				" from students s, score sc , courses c,teachers t " +
//				"where s.stu_id = sc.stu_id and sc.cou_id = c.cou_id and " +
//				"t.tea_id=c.tea_id and t.tea_id="+teacher_id+" group by sc.stu_id;";
		Statement stat;
		try{
			stat=con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			ArrayList<Student> students = new ArrayList<Student>();
			while(rs.next()){
				Student stu = new Student(rs.getString("stu_id"), null, 
						rs.getString("stu_name"),rs.getString("stu_sex"), 
						rs.getInt("stu_age"), rs.getString("stu_major"), 
						rs.getString("stu_Class"));
				students.add(stu);
			}
			return students;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	//查看课程里面全部学生
	public static ArrayList<Student> getAllStudent(){
		Connection con =getConnection();
		String sql = "select * from students;";
		Statement stat;
		try{
			stat=con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			ArrayList<Student> students = new ArrayList<Student>();
			while(rs.next()){
				Student stu = new Student(rs.getString("stu_id"), null, 
						rs.getString("stu_name"),rs.getString("stu_sex"), 
						rs.getInt("stu_age"), rs.getString("stu_major"), 
						rs.getString("stu_Class"));
				students.add(stu);
			}
			return students;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	//获取选该老师并且
	public static ArrayList<Stu_Score> getnumber(String id,String tea_id){
		Connection con =getConnection();
		String sql = "select c.*,sc.cou_num,t.tea_name " +
				"from students s, score sc , courses c,teachers t " +
				"where s.stu_id = sc.stu_id and sc.cou_id = c.cou_id and " +
				"t.tea_id=c.tea_id and s.stu_id="+id+" and t.tea_id="+tea_id+";";
		System.out.println("=====");
		System.out.println(sql);
		try {
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			ArrayList<Stu_Score> scores = new ArrayList<Stu_Score>();
			while(rs.next()){
				Stu_Score score = new Stu_Score();
				score.setCourse_id(rs.getInt("cou_id"));
				score.setCourseName(rs.getString("cou_name"));
				if(rs.getString("cou_num")==null||rs.getString("cou_num").length()==0){
					score.setScore(-1);
				}
				else{
					score.setScore(rs.getDouble("cou_num"));
				}
				score.setStudent_id(Integer.parseInt(id));
				score.setTeacherName(rs.getString("tea_name"));
				scores.add(score);
			}
			rs.close();
			
			return scores;
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//增加课程
	public static boolean addCourse(String tea_id,String cou_id,String cou_name,
			String cou_time,String cou_ctime,String cou_fen,
			String cou_snum,String type){
		Connection con =getConnection();
		String sql_ = "select * from courses where cou_id="+cou_id+";";
		String sql = "insert into courses(tea_id,cou_id,cou_name," +
				"cou_time,cou_ctime,cou_fen,cou_snum,cou_lnum,state,t_id) " +
				"values("+tea_id+","+cou_id+",'"+cou_name+"','"+
				cou_time+"','"+cou_ctime+"','"+cou_fen+"',"+cou_snum+",0,'"+"授课中"+
				"',(select id from type_ where name = '"+type+"'));";
		Statement stat;
		try{
			stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql_);
			if(rs.next()){
				return false;
			}
			else if(stat.executeUpdate(sql)==1){
				return true;
			}
			else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	//删除课程，在界面获取课程id进行课程的删除
	public static boolean deleteCourse(String cou_id){
		Connection con =getConnection();
		String sql_ = "delete from courses where cou_id="+cou_id+";";
		String sql = "delete from score where cou_id="+cou_id+";";
		Statement stat;
		try{
			stat = con.createStatement();
			int a = stat.executeUpdate(sql);
			int b = stat.executeUpdate(sql_);
			if(a!=0||b!=0){
				return true;
			}
			else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	//用课程id来查找课程
	public static ArrayList<Course> SelectCourse(String cou_id,boolean boo){
		Connection con =getConnection();
		String sql = "select *,type_.name type__,teachers.tea_name from" +
				" courses,type_,teachers where teachers.tea_id = courses.tea_id and type_.id =courses.t_id " +
				"and courses.cou_id="+cou_id+";";
		if(!boo){
			sql = "select *,type_.name as type__,teachers.tea_name from" +
					" courses,type_,teachers where teachers.tea_id = courses.tea_id and type_.id =courses.t_id " +
					"and (courses.cou_name = '"+cou_id+
					"' or type_.name = '"+cou_id+"');";
		}
		System.out.println(sql);
		Statement stat;
		try{
			stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			ArrayList<Course> courses = new ArrayList<Course>();
			while(rs.next()){
				Course course = null;
				course = new Course(rs.getInt("cou_id"), rs.getString("cou_name"), 
						rs.getString("cou_time"), rs.getString("cou_ctime"), rs.getInt("cou_fen")
						, rs.getInt("cou_snum"), rs.getInt("cou_lnum"));
				course.setState(rs.getString("state"));
				course.setTeacher_name(rs.getString("tea_name"));
				course.setType(rs.getString("type__"));
				courses.add(course);
			}
			return courses;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	//修改课程信息
	public static boolean setCourse(Course course){
		Connection con =getConnection();
		PreparedStatement sql;
//		ResultSet rs;
		String sqlS = "update courses set cou_name = ?,cou_time = ?,cou_ctime = ?," +
				"cou_fen = ?,cou_snum = ?" +
				" where cou_id = ?;";
//		Statement stat;
		try {
//			stat = con.createStatement();
			sql = con.prepareStatement(sqlS);
			sql.setString(1, course.getName());
			sql.setString(2, course.getTerm());
			sql.setString(3, course.getTime());
			sql.setInt(4, course.getCredit());
			sql.setInt(5, course.getMax());
			sql.setInt(6, course.getCourse_id());
			if(sql.executeUpdate()==1){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//修改课程信息
	public static boolean setCourse(int cou_id,String state){
		Connection con =getConnection();
		PreparedStatement sql;
//		ResultSet rs;
		String sqlS = "update courses set state = ?" +
				" where cou_id = ?;";
//		Statement stat;
		try {
//			stat = con.createStatement();
			sql = con.prepareStatement(sqlS);
			sql.setString(1, state);
			sql.setInt(2, cou_id);
			if(sql.executeUpdate()==1){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//删除成绩
	public static boolean DelScore(int cou_id,int stu_id){
		Connection con =getConnection();
		PreparedStatement sql;
//		ResultSet rs;
		String sqlS = "update score set cou_num = null" +
				" where cou_id = ? and stu_id = ?;";
//		Statement stat;
		try {
//			stat = con.createStatement();
			sql = con.prepareStatement(sqlS);
			sql.setInt(1, cou_id);
			sql.setInt(2, stu_id);
			if(sql.executeUpdate()==1){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//修改成绩
	public static boolean SetScore(int cou_id,int stu_id,double score){
		Connection con =getConnection();
		PreparedStatement sql;
//		ResultSet rs;
		String sqlS = "update score set cou_num = ?" +
				" where cou_id = ? and stu_id = ?;";
//		Statement stat;
		try {
//			stat = con.createStatement();
			sql = con.prepareStatement(sqlS);
			sql.setDouble(1, score);
			sql.setInt(2, cou_id);
			sql.setInt(3, stu_id);
			if(sql.executeUpdate()==1){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//增加学生
	public static boolean addStudent(Student student){
		Connection con =getConnection();
		PreparedStatement sql;
		String sqlS = "insert students (stu_id,stu_pw,stu_name,stu_sex,stu_age,stu_major,stu_class)" +
				" values (?,?,?,?,?,?,?)";
		try {
			sql = con.prepareStatement(sqlS);
			sql.setInt(1, Integer.parseInt(student.getId()));
			sql.setString(2, student.getPw());
			sql.setString(3, student.getName());
			sql.setString(4, student.getSex());
			sql.setInt(5, student.getAge());
			sql.setString(6, student.getMajor());
			sql.setString(7, student.getClasses());
			if(sql.executeUpdate()==1){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//获取全部教师
	public static String[][] getAllTeacher(String id){
		Connection con =getConnection();
		String sql = "select * from teachers;";
		if(id.length()!=0){
			sql = "select * from teachers where tea_id = '"+id+"';";
		}
		Statement stat;
		String[][] teachers = null;
		try{
			stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			rs.last();
			teachers = new String[rs.getRow()][4];
			rs.beforeFirst();
			int i =0;
			while(rs.next()){
				teachers[i][0] = rs.getString("tea_id"); 
				teachers[i][1] = rs.getString("tea_name"); 
				teachers[i][2] = rs.getString("tea_sex"); 
				teachers[i][3] = rs.getString("tea_age"); 
				i++;
			}
			return teachers;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	//删除教师，在界面获取课程id进行课程的删除
	public static boolean deleteTeacher(String tea_id){
		Connection con =getConnection();
		String sql = "delete from score where cou_id in " +
				"(select cou_id from courses where tea_id = '"+
				tea_id+"');";
		String sql_ = "delete from courses where tea_id= '"+tea_id+"';";
		String sql2 = "delete from teachers where tea_id = '"+tea_id+"';";
		Statement stat;
		try{
			stat = con.createStatement();
			int a = stat.executeUpdate(sql);
			int b = stat.executeUpdate(sql_);
			int c = stat.executeUpdate(sql2);
			if(c!=0){
				return true;
			}
			else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	//增加教师
	public static boolean addTeacher(Teacher teacher){
		Connection con =getConnection();
		PreparedStatement sql;
		String sqlS = "insert teachers (tea_id,tea_pw,tea_name,tea_sex,tea_age)" +
				" values (?,?,?,?,?)";
		try {
			sql = con.prepareStatement(sqlS);
			sql.setString(1, teacher.getId());
			sql.setString(2, teacher.getPw());
			sql.setString(3, teacher.getName());
			sql.setString(4, teacher.getSex());
			sql.setInt(5, teacher.getAge());
			if(sql.executeUpdate()==1){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//更改教师信息
	public static boolean UpdateTeacher(Teacher teacher){
		Connection con =getConnection();
		PreparedStatement sql;
		String sqlS = "update teachers set tea_pw = ?,tea_name = ?" +
				",tea_sex = ?,tea_age = ? where tea_id = ?;";
		try {
			sql = con.prepareStatement(sqlS);
			
			sql.setString(1, teacher.getPw());
			sql.setString(2, teacher.getName());
			sql.setString(3, teacher.getSex());
			sql.setInt(4, teacher.getAge());
			sql.setString(5, teacher.getId());
			if(sql.executeUpdate()==1){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static void main(String[] args) {
//		Course course = new Course(104, "大数据123", "1-18周","周五8-9节", 4, 100, 0);
//		setCourse(course);
		setTeapw("123qwe", "123", "101");
	}
}
