package com.glxt.jdbc;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.ArrayList;

import com.glxt.model.Course;
import com.glxt.model.Student;
import com.glxt.model.Teacher;
import com.glxt.modelData.Stu_Score;

public class OperateOracle {

    public static void main(String[] args) {
//        new OperateOracle().callProcedure();
    }
    // 定义连接所需的字符串
    // 192.168.0.X是本机地址(要改成自己的IP地址)，1521端口号，XE是精简版Oracle的默认数据库名
    private static String USERNAMR = "C##SCOTT";
    private static String PASSWORD = "123123";
    private static String DRVIER = "oracle.jdbc.OracleDriver";
    private static String URL = "jdbc:oracle:thin:@localhost:1521:mldn";

    // 创建一个数据库连接
    Connection connection = null;
    // 创建预编译语句对象，一般都是用这个而不用Statement
    PreparedStatement pstm = null;
    // 创建一个结果集对象
    ResultSet rs = null;


    /**
     * 获取Connection对象
     *
     * @return
     */
    public Connection getConnection() {
        try {
            Class.forName(DRVIER);
            connection = DriverManager.getConnection(URL, USERNAMR, PASSWORD);
            System.out.println("成功连接数据库");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("class not find !", e);
        } catch (SQLException e) {
            throw new RuntimeException("get connection error!", e);
        }

        return connection;
    }

    /**
     * 释放资源
     */
    public void ReleaseResource() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    //学生登陆
    public Student stu_Login(String id,String pw){
    	try {
            String sql = "{call login_package.login(?,?,?,?,?,?)}";
            connection = getConnection();
            CallableStatement stat = connection.prepareCall(sql);
            stat.setString(1,id);
            stat.setString(2,pw);
            stat.registerOutParameter(3, OracleTypes.NUMBER);
            stat.registerOutParameter(4, oracle.jdbc.OracleTypes.CURSOR);
            stat.registerOutParameter(5, oracle.jdbc.OracleTypes.CURSOR);
            stat.registerOutParameter(6, oracle.jdbc.OracleTypes.CURSOR);
            stat.execute();
            int tip = stat.getInt(3);
            System.out.println(tip);
            if(tip!=1){
            	Student student = new Student(null, null,null, null, 0, null, null);
				student.setType(tip);
				return student;
            }
            else{
                ResultSet rs = (ResultSet) stat.getObject(4);
                rs.next();
                Student student = new Student(rs.getInt("stu_id")+"", rs.getString("stu_pw"), rs.getString("stu_name"), rs.getString("stu_sex"), rs.getInt("stu_age"), rs.getString("stu_major"), rs.getString("stu_class"));
				student.setType(1);
                ResultSet rs1 = (ResultSet) stat.getObject(5);
                ArrayList<Course> courses = new ArrayList<Course>();
    			while(rs1.next()){
    				Course course = new Course();
    				course.setTeacher_id(rs1.getString("tea_id"));
    				course.setTeacher_name(rs1.getString("tea_name"));
    				course.setCourse_id(rs1.getInt("cou_id"));
    				course.setMax(rs1.getInt("cou_snum"));
    				course.setName(rs1.getString("cou_name"));
    				course.setNumber(rs1.getInt("cou_lnum"));
    				course.setCredit(rs1.getInt("cou_fen"));
    				course.setTerm(rs1.getString("cou_time"));
    				course.setTime(rs1.getString("cou_ctime"));
    				course.setState(rs1.getString("state"));
    				course.setType(rs1.getString("type__"));
    				courses.add(course);
    			}
    			student.setCourses(courses);
                ResultSet rs2 = (ResultSet) stat.getObject(6);
                ArrayList<Stu_Score> scores = new ArrayList<Stu_Score>();
    			while(rs2.next()){
    				Stu_Score score = new Stu_Score();
    				score.setCourse_id(rs2.getInt("cou_id"));
    				score.setCourseName(rs2.getString("cou_name"));
    				if(rs2.getString("cou_num")==null||rs2.getString("cou_num").length()==0){
    					score.setScore(-1);
    				}
    				else{
    					score.setScore(rs2.getDouble("cou_num"));
    				}
    				score.setStudent_id(Integer.parseInt(id));
    				score.setTeacherName(rs2.getString("tea_name"));
    				scores.add(score);
    			}
    			System.out.println(id);
    			System.out.println(scores.size());
    			student.setScores(scores);
    			return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReleaseResource();
        }
		return null;
	}
    
    // 教师登陆
    public Teacher tea_Login(String id, String pw) {
        try {
            String sql = "{call login_package.tea_login(?,?,?,?,?,?,?,?)}";
            connection = getConnection();
            CallableStatement stat = connection.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
//            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            stat.setString(1,id);
            stat.setString(2,pw);
            stat.registerOutParameter(3, OracleTypes.NUMBER);
            stat.registerOutParameter(4, oracle.jdbc.OracleTypes.CURSOR);
            stat.registerOutParameter(5, oracle.jdbc.OracleTypes.CURSOR);
            stat.registerOutParameter(6, oracle.jdbc.OracleTypes.CURSOR);
            stat.registerOutParameter(7, oracle.jdbc.OracleTypes.CURSOR);
            stat.registerOutParameter(8, oracle.jdbc.OracleTypes.CURSOR);
            stat.execute();
            int tip = stat.getInt(3);
            System.out.println(tip);
            if(tip!=1){
            	Teacher teacher = new Teacher(null, null, null, null, 0);
				teacher.setType(tip);
				return teacher;
            }
            else{
                ResultSet rs = (ResultSet) stat.getObject(4);
                rs.next();
                Teacher teacher = new Teacher(rs.getInt("tea_id")+"", rs.getString("tea_pw"), rs.getString("tea_name"), rs.getString("tea_sex"),rs.getInt("tea_age"));
				teacher.setType(tip);
                rs = (ResultSet) stat.getObject(5);
                ArrayList<Course> courses = new ArrayList<Course>();
    			while(rs.next()){
    				Course course = new Course(rs.getInt("cou_id"), rs.getString("cou_name"), 
    						rs.getString("cou_time"), rs.getString("cou_ctime"), rs.getInt("cou_fen")
    						, rs.getInt("cou_snum"), rs.getInt("cou_lnum"));
    				course.setState(rs.getString("state"));
    				course.setType(rs.getString("type__"));
    				courses.add(course);
    			}
    			teacher.setCourses(courses);
                rs = (ResultSet) stat.getObject(6);
                ArrayList<Student> students = new ArrayList<Student>();
    			while(rs.next()){
    				Student stu = new Student(rs.getString("stu_id"), null, 
    						rs.getString("stu_name"),rs.getString("stu_sex"), 
    						rs.getInt("stu_age"), rs.getString("stu_major"), 
    						rs.getString("stu_Class"));
    				stu.setScores(new ArrayList<Stu_Score>());
    				students.add(stu);
    			}
    			teacher.setStudent(students);
    			
                rs = (ResultSet) stat.getObject(7);
                while (rs.next()) {
                	for (int i = 0; i < teacher.getStudent().size(); i++) {
                		if(teacher.getStudent().get(i).getScores()==null){
                			teacher.getStudent().get(i).setScores(
                					new ArrayList<Stu_Score>());
            			}
                		if(teacher.getStudent().get(i).getId().equals(rs.getInt("stu_id")+"")){
                			Stu_Score score = new Stu_Score();
            				score.setCourse_id(rs.getInt("cou_id"));
            				score.setCourseName(rs.getString("cou_name"));
            				if(rs.getString("cou_num")==null||rs.getString("cou_num").length()==0){
            					score.setScore(-1);
            				}
            				else{
            					score.setScore(rs.getDouble("cou_num"));
            				}
            				score.setStudent_id(rs.getInt("stu_id"));
            				score.setTeacherName(rs.getString("tea_name"));
            				ArrayList<Stu_Score> so = teacher.getStudent().
        					get(i).getScores();
            				so.add(score);
                			teacher.getStudent().get(i).setScores(so);
                		}
    				}
                }
                rs = (ResultSet) stat.getObject(8);
                ArrayList<String[]> temp = new ArrayList<String[]>();
                while(rs.next()){
                	temp.add(new String[]{rs.getString("tea_id"),rs.getString("tea_name")
                			,rs.getString("tea_sex"),rs.getString("tea_age")});
    			}
                String[][] teachers = new String[temp.size()][4];
    			int i =0;
    			for(String[] s:temp){
    				teachers[i] = s;
    				i++;
    			}
    			teacher.setTeachers(teachers);
    			return teacher;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReleaseResource();
        }
        return null;
    }
    
    // 调用存储过程
    public void callProcedure2() {
        try {
            String sql = "{call login_package.login(?,?,?,?,?,?)}";
            connection = getConnection();
            CallableStatement stat = connection.prepareCall(sql);
            stat.setString(1,"12312");
            stat.setString(2,"123123123");
            stat.registerOutParameter(3, OracleTypes.NUMBER);
            stat.registerOutParameter(4, oracle.jdbc.OracleTypes.CURSOR);
            stat.registerOutParameter(5, oracle.jdbc.OracleTypes.CURSOR);
            stat.registerOutParameter(6, oracle.jdbc.OracleTypes.CURSOR);
            stat.execute();
            int tip = stat.getInt(3);
            System.out.println(tip);
            if(tip!=1){
            	
            }
            else{
                ResultSet rs = (ResultSet) stat.getObject(4);
                while (rs.next()) {
                    System.out.println(rs.getString(1) + "/t" + rs.getString(2) + "/t"
                            + rs.getString(3));

                }
                System.out.println("======================");
                ResultSet rs1 = (ResultSet) stat.getObject(5);
                while (rs1.next()) {
                    System.out.println(rs1.getString(1) + "/t" + rs1.getString(2) + "/t"
                            + rs1.getString(3));
                }
                System.out.println("======================");
                ResultSet rs2 = (ResultSet) stat.getObject(6);
                while (rs2.next()) {
                    System.out.println(rs2.getString(1) + "/t" + rs2.getString(2) + "/t"
                            + rs2.getString(3));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReleaseResource();
        }
    }
    
    //用课程id、课程名称、课程类别查找课程
	public ArrayList<Course> SelectCourse(String cou_id,boolean boo){
		try {
            String sql = "{call courses_package.get_courses(?,?,?)}";
            connection = getConnection();
            CallableStatement stat = connection.prepareCall(sql);
            if(boo){
            	stat.setString(1,"stu_cou_id");
            }
            else{
            	stat.setString(1,"stu_");
            }
            stat.setString(2,cou_id);
            stat.registerOutParameter(3, oracle.jdbc.OracleTypes.CURSOR);
            stat.execute();
            ResultSet rs = (ResultSet) stat.getObject(3);
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReleaseResource();
        }
		return new ArrayList<Course>();
	}
	
	//教师版用课程id、课程名称、课程类别查找课程
	public ArrayList<Course> SelectTeaCourse(String val,int boo){
		try {
            String sql = "{call courses_package.get_courses(?,?,?)}";
            connection = getConnection();
            CallableStatement stat = connection.prepareCall(sql);
            if(boo==0){
            	stat.setString(1,"tea_tea_id");
            }
            else if(boo==1){
            	stat.setString(1,"tea_cou_id");
            }
            else{
            	stat.setString(1,"tea_");
            }
            System.out.println("==================="+boo);
            stat.setString(2,val);
            stat.registerOutParameter(3, oracle.jdbc.OracleTypes.CURSOR);
            stat.execute();
            ResultSet rs = (ResultSet) stat.getObject(3);
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReleaseResource();
        }
		return new ArrayList<Course>();
	}
	
	//获取全部课程
	public ArrayList<Course> getAllCourse(){
		try {
            String sql = "{call courses_package.get_courses(?,?,?)}";
            connection = getConnection();
            CallableStatement stat = connection.prepareCall(sql);
            stat.setString(1,null);
            stat.setString(2,null);
            stat.registerOutParameter(3, oracle.jdbc.OracleTypes.CURSOR);
            stat.execute();
            ResultSet rs = (ResultSet) stat.getObject(3);
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReleaseResource();
        }
		return new ArrayList<Course>();
		
		
	}
	
	//学生选课模块选定课程
	public boolean choiceCourse(String cou_id,String id,String cou_lnum){
		try {
			String inset_sql = "insert into score(stu_id,cou_id) values("+id+","+cou_id+")";
            System.out.println(inset_sql);
			String sql = "{? = call fun_package.upordel_func(?)}";
            connection = getConnection();
            CallableStatement stat = connection.prepareCall(sql);
            stat.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            stat.setString(2,inset_sql);
            stat.execute();
            int result = stat.getInt(1);
            if(result!=1){
            	return false;
            }
            else{
            	return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ReleaseResource();
        }
		
	}
	
    //学生获取自己全部成绩：stu_all
	public ArrayList<Stu_Score> getAllScore(String id) {
		try {
            String sql = "{call score_package.get_score(?,?,?,?)}";
            connection = getConnection();
            CallableStatement stat = connection.prepareCall(sql);
            stat.setString(1,"stu_all");
            stat.setString(2,null);
            stat.setString(3,id);
            stat.registerOutParameter(4, oracle.jdbc.OracleTypes.CURSOR);
            stat.execute();
            ResultSet rs = (ResultSet) stat.getObject(4);
            ArrayList<Stu_Score> Stu_Score = new ArrayList<Stu_Score>();
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
				Stu_Score.add(score);
			}
			return Stu_Score;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReleaseResource();
        }
		return new ArrayList<Stu_Score>();
	}
	
	//修改密码
	public boolean setpw(String stu_pw,String newpw,String id,boolean boo){
		try {
			String col = "stu_pw";
			String select_sql = "select * from students where students.stu_id = "+id+"";
			String update_sql = "update students set stu_pw = '"+newpw+"' where stu_id = "+id+"";
//			String select_fun = "{? = call fun_package.select_func(?)}";
//			String update_fun = "{? = call fun_package.upordel_func(?)}";
			if(boo){
				col = "tea_pw";
				select_sql = "select * from teachers where teachers.tea_id = "+id+"";
				update_sql = "update teachers set tea_pw = '"+newpw+"' where tea_id = "+id+"";
			}
            connection = getConnection();
            Statement stat = connection.createStatement();
//            stat.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
//            stat.setString(2,select_sql);
            ResultSet rs = stat.executeQuery(select_sql);
            rs.next();
			if(rs.getString(col).equals(stu_pw)){
	            int a = stat.executeUpdate(update_sql);
				if(a==1){
					return true;
				}
				else{
					return false;
				}
			}
			else{
				return false;
			}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReleaseResource();
        }
		return false;
	}
	
	//增加课程
	public boolean addCourse(String tea_id,String cou_id,String cou_name,
			String cou_time,String cou_ctime,String cou_fen,
			String cou_snum,String type){
		String select_sql = "select * from courses where cou_id = "+cou_id;
		String update_sql = "insert into courses (tea_id,cou_id,cou_name," +
				"cou_time,cou_ctime,cou_fen,cou_snum,cou_lnum,state,t_id) " +
				"values ("+tea_id+","+cou_id+",'"+cou_name+"','"+
				cou_time+"','"+cou_ctime+"',"+cou_fen+","+cou_snum+",0,"+"'授课中'"+
				",(select id from type_ where name_ = '"+type+"'))";
		System.out.println(update_sql);
		System.out.println(select_sql);
		String select_fun = "{? = call fun_package.select_func(?)}";
		String update_fun = "{? = call fun_package.upordel_func(?)}";
		connection = getConnection();
		try{
			CallableStatement stat = connection.prepareCall(select_fun);
			stat.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
	        stat.setString(2,select_sql);
	        stat.execute();
	        rs = (ResultSet) stat.getObject(1);
			if(rs.next()){
				return false;
			}
			else{
				stat = connection.prepareCall(update_fun);
				stat.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
		        stat.setString(2,update_sql);
		        stat.execute();
		        System.out.println(stat.getInt(1));
		        if(stat.getInt(1)!=0){
		        	return true;
		        }
		        else{
		        	return false;
		        }
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	//修改课程信息
	public boolean setCourse(Course course){
		Connection con =getConnection();
		PreparedStatement sql;
		String sqlS = "update courses set cou_name = ?,cou_time = ?,cou_ctime = ?," +
				"cou_fen = ?,cou_snum = ?" +
				" where cou_id = ?";
		try {
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
	
	//删除课程，在界面获取课程id进行课程的删除
	public boolean deleteCourse(String cou_id){
		Connection con =getConnection();
		String sql_ = "delete from courses where cou_id = "+cou_id+"";
//		String sql = "delete from score where cou_id = "+cou_id+";";
		Statement stat;
		try{
			stat = con.createStatement();
//			int a = stat.executeUpdate(sql);
			int b = stat.executeUpdate(sql_);
			if(b!=0){
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
	
	//修改课程信息
	public boolean setCourse(int cou_id,String state){
		Connection con =getConnection();
		PreparedStatement sql;
		String sqlS = "update courses set state = ?" +
				" where cou_id = ?";
		try {
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
			e.printStackTrace();
			return false;
		}
	}
	
	//查找学生
	public ArrayList<Student> selectStudent(String val,int boo){
		try {
            String sql = "{call student_package.get_student(?,?,?)}";
            connection = getConnection();
            CallableStatement stat = connection.prepareCall(sql);
            if(boo==0){
            	stat.setString(1,null);
            }
            else if(boo==1){
            	stat.setString(1,"tea_stu_id");
            }
            else{
            	stat.setString(1,"couallstu");
            }
            stat.setString(2,val);
            stat.registerOutParameter(3, oracle.jdbc.OracleTypes.CURSOR);
            stat.execute();
            ResultSet rs = (ResultSet) stat.getObject(3);
			ArrayList<Student> students = new ArrayList<Student>();
			while(rs.next()){
				Student stu = new Student(rs.getString("stu_id"), null, 
						rs.getString("stu_name"),rs.getString("stu_sex"), 
						rs.getInt("stu_age"), rs.getString("stu_major"), 
						rs.getString("stu_Class"));
				stu.setScores(new ArrayList<Stu_Score>());
				students.add(stu);
			}
			return students;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReleaseResource();
        }
		return new ArrayList<Student>();
	}
	
	public ArrayList<Student> selectScore(String teaVal,String stuVal,int boo){
		try {
			ArrayList<Student> students = selectStudent(teaVal, 0);
			String sql = "{call score_package.get_score(?,?,?,?)}";
	        connection = getConnection();
	        CallableStatement stat = connection.prepareCall(sql);
	        if(boo==0){
	        	stat.setString(1,"tea_all");
	        }
	        else{
	        	stat.setString(1,"tea_stu_id");
	        }
	        stat.setString(2,teaVal);
	        stat.setString(3,stuVal);
	        stat.registerOutParameter(4, oracle.jdbc.OracleTypes.CURSOR);
	        stat.execute();
			rs = (ResultSet) stat.getObject(4);
	        while (rs.next()) {
	        	for (int i = 0; i < students.size(); i++) {
	        		if(students.get(i).getScores()==null){
	        			students.get(i).setScores(
	        					new ArrayList<Stu_Score>());
	    			}
	        		if(students.get(i).getId().equals(rs.getInt("stu_id")+"")){
	        			Stu_Score score = new Stu_Score();
	    				score.setCourse_id(rs.getInt("cou_id"));
	    				score.setCourseName(rs.getString("cou_name"));
	    				if(rs.getString("cou_num")==null||rs.getString("cou_num").length()==0){
	    					score.setScore(-1);
	    				}
	    				else{
	    					score.setScore(rs.getDouble("cou_num"));
	    				}
	    				score.setStudent_id(rs.getInt("stu_id"));
	    				score.setTeacherName(rs.getString("tea_name"));
	    				ArrayList<Stu_Score> so = students.
						get(i).getScores();
	    				so.add(score);
	    				students.get(i).setScores(so);
	        		}
				}
	        }
	        return students;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReleaseResource();
        }
		return new ArrayList<Student>();
		
	}
	
	//删除成绩
	public boolean DelScore(int cou_id,int stu_id){
		Connection con =getConnection();
		PreparedStatement sql;
//		ResultSet rs;
		String sqlS = "update score set cou_num = null" +
				" where cou_id = ? and stu_id = ?";
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
	public boolean SetScore(int cou_id,int stu_id,double score){
		Connection con =getConnection();
		PreparedStatement sql;
//		ResultSet rs;
		String sqlS = "update score set cou_num = ?" +
				" where cou_id = ? and stu_id = ?";
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
	
	//查找教师
	public String[][] selectTeacher(String id){
		try {
            String sql = "{call teacher_package.get_teacher(?,?,?)}";
            connection = getConnection();
            CallableStatement stat = connection.prepareCall(sql);
            if(id==null||id.length()==0){
            	stat.setString(1,"tea_all");
            }
            else{
            	stat.setString(1,"tea_id");
            }
            stat.setString(2,id);
            stat.registerOutParameter(3, oracle.jdbc.OracleTypes.CURSOR);
            stat.execute();
            rs = (ResultSet) stat.getObject(3);
            ArrayList<String[]> temp = new ArrayList<String[]>();
            while(rs.next()){
            	temp.add(new String[]{rs.getString("tea_id"),rs.getString("tea_name")
            			,rs.getString("tea_sex"),rs.getString("tea_age")});
			}
            String[][] teachers = new String[temp.size()][4];
			int i =0;
			for(String[] s:temp){
				teachers[i] = s;
				i++;
			}
			return teachers;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReleaseResource();
        }
		return null;
	}
	
	//增加教师
	public boolean addTeacher(Teacher teacher){
		Connection con =getConnection();
		PreparedStatement sql;
		String sqlS = "insert into teachers (tea_id,tea_pw,tea_name,tea_sex,tea_age)" +
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
	
	//删除教师，在界面获取课程id进行课程的删除
	public boolean deleteTeacher(String tea_id){
		Connection con =getConnection();
//		String sql = "delete from score where cou_id in " +
//				"(select cou_id from courses where tea_id = '"+
//				tea_id+"');";
//		String sql_ = "delete from courses where tea_id= '"+tea_id+"';";
		String sql2 = "delete from teachers where tea_id = '"+tea_id+"'";
		Statement stat;
		try{
			stat = con.createStatement();
//			int a = stat.executeUpdate(sql);
//			int b = stat.executeUpdate(sql_);
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
	
	//更改教师信息
	public boolean UpdateTeacher(Teacher teacher){
		Connection con =getConnection();
		PreparedStatement sql;
		String sqlS = "update teachers set tea_pw = ?,tea_name = ?" +
				",tea_sex = ?,tea_age = ? where tea_id = ?";
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
	
	//增加学生
	public boolean addStudent(Student student){
		Connection con =getConnection();
		PreparedStatement sql;
		String sqlS = "insert into students (stu_id,stu_pw,stu_name,stu_sex,stu_age,stu_major,stu_class)" +
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
}
