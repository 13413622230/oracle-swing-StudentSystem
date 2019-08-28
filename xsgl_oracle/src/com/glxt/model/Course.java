package com.glxt.model;

import java.io.Serializable;

public class Course implements Serializable{
	private String teacher_id;
	private int course_id;
	private String name;
	private String term;
	private String time;
	private int credit;
	private int max;
	private int number;
	private String teacher_name;
	private String state;
	private String type;
	public Course(int courseId, String name, String term, String time,
			int credit, int max, int number) {
		course_id = courseId;
		this.name = name;
		this.term = term;
		this.time = time;
		this.credit = credit;
		this.max = max;
		this.number = number;
	}
	public Course(String teacherId, int courseId, String name, String term,
			String time, int credit, int max, int number, String teacherName) {
		teacher_id = teacherId;
		course_id = courseId;
		this.name = name;
		this.term = term;
		this.time = time;
		this.credit = credit;
		this.max = max;
		this.number = number;
		teacher_name = teacherName;
	}
	public Course() {
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacherId) {
		teacher_id = teacherId;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int courseId) {
		course_id = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacherName) {
		teacher_name = teacherName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
