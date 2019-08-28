package com.glxt.model;

import java.io.Serializable;

public class Score implements Serializable{
	private int course_id;
	private int student_id;
	private double score;
	public Score(int courseId, int studentId, double score) {
		course_id = courseId;
		student_id = studentId;
		this.score = score;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int courseId) {
		course_id = courseId;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int studentId) {
		student_id = studentId;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double d) {
		this.score = d;
	}
	
}
