package com.glxt.model;

import java.util.ArrayList;

public class Teacher extends User {
	private String name;
	private String sex;
	private int age;
	private ArrayList<Course> courses;
	private ArrayList<Student> student;
	private String[][] teachers;
	public Teacher(String id, String pw,String name,String sex,int age) {
		super(id, pw);
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public ArrayList<Course> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	public ArrayList<Student> getStudent() {
		return student;
	}
	public void setStudent(ArrayList<Student> student) {
		this.student = student;
	}
	public String[][] getTeachers() {
		return teachers;
	}
	public void setTeachers(String[][] teachers) {
		this.teachers = teachers;
	}
}
