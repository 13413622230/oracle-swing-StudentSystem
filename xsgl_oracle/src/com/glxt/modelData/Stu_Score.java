package com.glxt.modelData;

import com.glxt.model.Score;
public class Stu_Score extends Score{
	private String courseName;
	private String teacherName;
	public Stu_Score(int courseId, int studentId, int score, String courseName,
			String teacherName) {
		super(courseId, studentId, score);
		this.courseName = courseName;
		this.teacherName = teacherName;
	}
	public Stu_Score() {
		super(0, 0, 0);
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
}
