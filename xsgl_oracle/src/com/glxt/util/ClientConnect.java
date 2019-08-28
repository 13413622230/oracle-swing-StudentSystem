package com.glxt.util;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.glxt.jdbc.Jdbc;
import com.glxt.jdbc.OperateOracle;
import com.glxt.model.Course;
import com.glxt.model.Score;
import com.glxt.model.Student;
import com.glxt.model.Teacher;
import com.glxt.model.User;

public class ClientConnect {
	static ClientConServer ccs = null;
	public static User login(User user){
		ccs = new ClientConServer();
		User response = ccs.login(user);
		//1指登陆成功
		if(response.getType()==1){
			return response;
		}
		//2指密码错误
		else if(response.getType()==0){
			throw new RuntimeException("密码错误");
		}
		//3指用户名不存在
		else if(response.getType()==-1){
			throw new RuntimeException("用户名不存在");
		}
		else
			throw new RuntimeException("程序出错");
	}
	public static String[][] getstutable1(Student stu){
		System.out.println(stu.getCourses().size()+"hahaha ");
		System.out.println(stu.getScores().size());
		String[][] rowdata = new String[stu.getCourses().size()][6];
		for (int i = 0; i < rowdata.length; i++) {
			rowdata[i][0] = stu.getCourses().get(i).getCourse_id()+"";
			rowdata[i][1] = stu.getCourses().get(i).getName();
			rowdata[i][2] = stu.getCourses().get(i).getTeacher_name();
			rowdata[i][3] = stu.getCourses().get(i).getMax()-stu.getCourses().get(i).getNumber()+"";
			rowdata[i][4] = stu.getCourses().get(i).getType();
			rowdata[i][5] = "未选";
			for(int j=0;j<stu.getScores().size();j++){
				System.out.println(stu.getScores().get(j).
						getCourse_id());
				if(stu.getCourses().get(i).getCourse_id()==stu.getScores().get(j).
						getCourse_id()){
					rowdata[i][5] = "已选";
					break;
				}
			}
		}
		return rowdata;
	}
	public static String[][] getstutable2(Student stu){
		String[][] rowdata = new String[stu.getScores().size()][4];
		for (int i = 0; i < rowdata.length; i++) {
			rowdata[i][0] = stu.getScores().get(i).getCourse_id()+"";
			rowdata[i][1] = stu.getScores().get(i).getCourseName();
			rowdata[i][2] = stu.getScores().get(i).getTeacherName();
			if(stu.getScores().get(i).getScore()==-1){
				rowdata[i][3] = "成绩未公布";
			}
			else
				rowdata[i][3] = stu.getScores().get(i).getScore()+"";
		}
		return rowdata;
	}
	public static boolean selectCourse(Student user,JTable jtable){
		int row[] = jtable.getSelectedRows();
		String ch = "";
		String cou_id = "";
		String num = "";
		if (row.length == 0) {
			throw new RuntimeException("没有选中课程！");
		} else if (row.length == 1) {
			ch = jtable.getValueAt(row[0], 5).toString();
			cou_id = jtable.getValueAt(row[0], 0).toString();
			num = jtable.getValueAt(row[0], 3).toString();
			if (ch.equals("已选")) {
				throw new RuntimeException("课程已选定，不能重复选定！");
			} else if (Integer.parseInt(num) <= 0) {
				throw new RuntimeException("人数已达到上限！");
			}
			else{
				User request = new User(user.getId(), null);
				request.setType(3);
				int Credit = 0;
				for(int i=0;i<user.getCourses().size();i++){
					if(cou_id.equals(user.getCourses().get(i).getCourse_id())){
						Credit = user.getCourses().get(i).getCredit();
						break;
					}
				}
				if(new OperateOracle().choiceCourse(cou_id, user.getId(), Credit+"")){
					return true;
				}
				else
					return false;
			}
		}
		else
			throw new RuntimeException("不能同时选定两个以上的 课程！");
	}
	public static User flush(User user){
		User request = new User(user.getId(),user.getPw());
		request.setType(4);
		User response = ccs.flush(request);
		if(response.getType()==1){
			return response;
		}
		else
			throw new RuntimeException("刷新失败");
	}
	public static void test(User user){
		user.setType(3);
		ccs.test(user);
	}
	public static String[] getDeltail(Student student,String[] cou){
		String course[] = new String[10];
		for(int i=0;i<student.getCourses().size();i++){
			if((student.getCourses().get(i).getCourse_id()+"").equals(cou[0])){
				course[0] = student.getCourses().get(i).getCourse_id()+"";
				course[1] = student.getCourses().get(i).getName();
				course[2] = student.getCourses().get(i).getTerm();
				course[3] = student.getCourses().get(i).getTime();
				course[4] = student.getCourses().get(i).getMax()+"";
				course[5] = student.getCourses().get(i).getNumber()+"";
				course[6] = student.getCourses().get(i).getCredit()+"";
				course[7] = student.getCourses().get(i).getTeacher_name();
				course[8] = student.getCourses().get(i).getMax()-
				student.getCourses().get(i).getNumber()+"";
//				course[9] = cou[1];
				course[9] = student.getCourses().get(i).getState();
				break;
			}
		}
		return course;
	}
	public static String[] getStuDeltail(Teacher teacher,String cou_id){
		String course[] = new String[6];
		ArrayList<Student> students = teacher.getStudent();
		for(int i=0;i<students.size();i++){
			if((students.get(i).getId()+"").equals(cou_id)){
				course[0] = students.get(i).getId()+"";
				course[1] = students.get(i).getName();
				course[2] = students.get(i).getSex();
				course[3] = students.get(i).getAge()+"";
				course[4] = students.get(i).getMajor();
				course[5] = students.get(i).getClasses();
				break;
			}
		}
		return course;
	}
	public static String[] getDeltail(Teacher teacher,String[] cou){
		String course[] = new String[10];
		for(int i=0;i<teacher.getCourses().size();i++){
			if((teacher.getCourses().get(i).getCourse_id()+"").equals(cou[0])){
				course[0] = teacher.getCourses().get(i).getCourse_id()+"";
				course[1] = teacher.getCourses().get(i).getName();
				course[2] = teacher.getCourses().get(i).getTerm();
				course[3] = teacher.getCourses().get(i).getTime();
				course[4] = teacher.getCourses().get(i).getMax()+"";
				course[5] = teacher.getCourses().get(i).getNumber()+"";
				course[6] = teacher.getCourses().get(i).getCredit()+"";
				course[7] = teacher.getName();
				course[8] = teacher.getCourses().get(i).getMax()-
				teacher.getCourses().get(i).getNumber()+"";
//				course[9] = cou[1];
				course[9] = teacher.getCourses().get(i).getState();
				break;
			}
		}
		return course;
	}
	public static boolean setpw(String id,String pw,String newpw){
		//写成数据包
		User request = new User(id, pw);
		request.setType(5);
		if(ccs.setpw(request, newpw)){
			return true;
		}
		else
			throw new RuntimeException("修改失败");
	}
	public static String[][] getteatable1(Teacher teacher){
		String[][] rows = new String[teacher.getCourses().size()][6];
		for(int i=0;i<teacher.getCourses().size();i++){
			rows[i][0] = teacher.getCourses().get(i).getCourse_id()+"";
			rows[i][1] = teacher.getCourses().get(i).getName();
			rows[i][2] = teacher.getCourses().get(i).getCredit()+"";
			rows[i][3] = teacher.getCourses().get(i).getTime();
			rows[i][4] = teacher.getCourses().get(i).getState();
			rows[i][5] = teacher.getCourses().get(i).getType();
		}
		return rows;
	}
	public static String[][] getteatable1(ArrayList<Course> course){
		String[][] rows = new String[course.size()][5];
		
		for(int i=0;i<course.size();i++){
			rows[i] = new String[]{
					course.get(i).getCourse_id()+"",
					course.get(i).getName(),
					course.get(i).getCredit()+"",
					course.get(i).getTime(),
					course.get(i).getState(),
					course.get(i).getType()
			};
		}
		return rows;
	}
	public static String[][] getteatable2(Teacher teacher){
		String[][] rows = new String[teacher.getStudent().size()][5];
		for(int i=0;i<teacher.getStudent().size();i++){
			rows[i][0] = teacher.getStudent().get(i).getId();
			rows[i][1] = teacher.getStudent().get(i).getName();
			rows[i][2] = teacher.getStudent().get(i).getSex();
			rows[i][3] = teacher.getStudent().get(i).getMajor();
			rows[i][4] = teacher.getStudent().get(i).getClasses();
		}
		return rows;
	}
	public static String[][] getteatable2(Student student){
		String[][] rows = new String[1][5];
		rows[0] = new String[]{
				student.getId()+"",student.getName(),
				student.getSex(),student.getMajor(),
				student.getClasses()
		};
		return rows;
	}
	public static Student selectStudent(Teacher teacher,String stu_id){
		ArrayList<Student> students = teacher.getStudent();
		Student student = null;
		for(int i=0;i<students.size();i++){
			if(students.get(i).getId().equals(stu_id)){
				student = students.get(i);
				break;
			}
		}
		return student;
	}
	public static String[][] getteatable3(Teacher teacher){
		ArrayList<Student> students = teacher.getStudent();
		int one = 0;
		for(int i=0;i<students.size();i++){
			one += students.get(i).getScores()==null?0:students.get(i).getScores().size();
		}
		String[][] rows = new String[one][5];
		int a = 0;
		for(int i=0;i<students.size();i++){
			for(int j=0;j<students.get(i).getScores().size();j++){
				rows[a][0] = students.get(i).getScores().get(j).getCourse_id()+"";
				rows[a][1] = students.get(i).getScores().get(j).getCourseName();
				rows[a][2] = students.get(i).getScores().get(j).getStudent_id()+"";
				rows[a][3] = students.get(i).getName();
				if(students.get(i).getScores().get(j).getScore()==-1){
					rows[a][4] = "成绩未公布";
				}
				else
					rows[a][4] = students.get(i).getScores().get(j).getScore()+"";
				a++;
			}
		}
		return rows;
	}
	public static String[][] selectScore(Teacher teacher,String stu_id){
		//添加jdbc操作
		ArrayList<Student> students = teacher.getStudent();
		int one = 0;
		for(int i=0;i<students.size();i++){
			one += students.get(i).getScores().size();
		}
		String[][] rows = new String[one][5];
		int a = 0;
		for(int i=0;i<students.size();i++){
			if(stu_id.equals(students.get(i).getId())){
				for(int j=0;j<students.get(i).getScores().size();j++){
					rows[a][0] = students.get(i).getScores().get(j).getCourse_id()+"";
					rows[a][1] = students.get(i).getScores().get(j).getCourseName();
					rows[a][2] = students.get(i).getScores().get(j).getStudent_id()+"";
					rows[a][3] = students.get(i).getName();
					if(students.get(i).getScores().get(j).getScore()==-1){
						rows[a][4] = "成绩未公布";
					}
					else
						rows[a][4] = students.get(i).getScores().get(j).getScore()+"";
					a++;
				}
				break;
			}
		}
		String[][] rows2 = new String[a][5];
		for(int i =0;i<a;i++){
			rows2[i] = rows[i];
		}
		return rows2;
	}
	public static String[][] getteatable3(Teacher teacher,String cou_id){
		ArrayList<Student> students = teacher.getStudent();
		int one = 0;
		for(int i=0;i<students.size();i++){
			one += students.get(i).getScores().size();
		}
		String[][] rows = new String[one][5];
		int a = 0;
		for(int i=0;i<students.size();i++){
			for(int j=0;j<students.get(i).getScores().size();j++){
				if(cou_id.equals(students.get(i).getScores().get(j).getCourse_id()+"")){
					rows[a][0] = students.get(i).getScores().get(j).getCourse_id()+"";
					rows[a][1] = students.get(i).getScores().get(j).getCourseName();
					rows[a][2] = students.get(i).getScores().get(j).getStudent_id()+"";
					rows[a][3] = students.get(i).getName();
					if(students.get(i).getScores().get(j).getScore()==-1){
						rows[a][4] = "成绩未公布";
					}
					else
						rows[a][4] = students.get(i).getScores().get(j).getScore()+"";
					a++;
				}
			}
		}
		String[][] rows2 = new String[a][5];
		for(int i =0;i<a;i++){
			rows2[i] = rows[i];
		}
		return rows2;
	}
	public static boolean addCourse(String tea_id,Course course){
		//写成数据包
		User request = new User(tea_id, null);
		request.setType(6);
		if(ccs.addCourse(request, course)){
			return true;
		}
		else
			throw new RuntimeException("添加失败");
	}
	public static boolean deleteCourse(String cou_id){
		User request = new User(null, null);
		request.setType(7);
		Course course = new Course();
		course.setCourse_id(Integer.parseInt(cou_id));
		if(ccs.deleteCourse(request, course)){
			return true;
		}
		return false;
	}
	public static Course SelectCourse(String cou_id){
		User request = new User(null, null);
		request.setType(8);
		Course course = new Course();
		course.setCourse_id(Integer.parseInt(cou_id));
		return ccs.SelectCourse(request, course);
	}
	public static boolean setCourse(Course course){
		User request = new User(null, null);
		request.setType(9);
		return ccs.setCourse(request, course);
	}
	public static boolean setState(Course course){
		User request = new User(null, null);
		request.setType(10);
		return ccs.setState(request, course);
	}
	public static Teacher Flush(User request){
		request.setType(11);
		return (Teacher) ccs.flush(request);
	}
	public static boolean DelScore(int cou_id,int stu_id){
		User request = new User(null, null);
		request.setType(12);
		return ccs.DelScore(request, cou_id, stu_id);
	}
	public static boolean setScore(int cou_id,int stu_id,double score){
		User request = new User(null, null);
		request.setType(13);
		return ccs.setScore(request,cou_id,stu_id,score);
	}
	public static boolean setScores(ArrayList<Score> socres){
		User request = new User(null, null);
		request.setType(14);
		return ccs.setScores(request,socres);
	}
	public static boolean addStudent(Student student){
		student.setType(15);
		return ccs.addStudent(student);
	}
	public static boolean setTeapw(String id,String pw,String newpw){
		//写成数据包
		User request = new User(id, pw);
		request.setType(16);
		if(ccs.setTeapw(request, newpw)){
			return true;
		}
		else
			throw new RuntimeException("修改失败");
	}
}
