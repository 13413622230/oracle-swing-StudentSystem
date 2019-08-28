package com.glxt.model;

import java.util.ArrayList;

import com.glxt.modelData.Stu_Score;

public class Student extends User {
	private String name;
	private String sex;
	private int age;
	private String major;
	private String Classes;
	private ArrayList<Course> courses;
	private ArrayList<Stu_Score> scores;
	public Student(String id, String pw,String name,String sex,int age,String major,String Classes) {
		super(id, pw);
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.major = major;
		this.Classes = Classes;
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
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getClasses() {
		return Classes;
	}
	public void setClasses(String classes) {
		Classes = classes;
	}
	public ArrayList<Course> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	public ArrayList<Stu_Score> getScores() {
		return scores;
	}
	public void setScores(ArrayList<Stu_Score> scores) {
		this.scores = scores;
	}
}

