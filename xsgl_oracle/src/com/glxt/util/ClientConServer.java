package com.glxt.util;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.jws.soap.SOAPBinding.Use;

import com.glxt.model.Course;
import com.glxt.model.Score;
import com.glxt.model.Student;
import com.glxt.model.Teacher;
import com.glxt.model.User;

public class ClientConServer extends Thread{
	public Socket socket = null;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	public void init(){
		try {
			socket = new Socket("127.0.0.1",8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public User login(User user){
		try {
			init();
			oos.writeObject(user);
			oos.flush();
			oos.writeObject(null);
			System.out.println(888);
			oos.flush();
			ois = new ObjectInputStream(socket.getInputStream());
			User response = (User) ois.readObject();
			System.out.println(response.getId());
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void run(){
		try {
			init();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void test(User user){
		try {
			oos.writeObject(user);
			oos.writeObject(null);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean selectCourse(User request,String course_id,int Credit){
		try {
			oos.writeObject(request);
			oos.writeObject(course_id);
			oos.writeObject(Credit+1);
			oos.writeObject(null);
			oos.flush();
			User response = (User) ois.readObject();
			if(response.getType()==1){
				return true;
			}
			else
				return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public User flush(User request){
		User response = null;
		System.out.println("成功进来了呢");
		try {
			oos.writeObject(request);
			oos.writeObject(null);
			oos.flush();
			response = (User) ois.readObject();
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
		
	}
	public boolean setpw(User request,String newpw){
		User response = null;
		try {
			oos.writeObject(request);
			oos.writeObject(newpw);
			oos.writeObject(null);
			oos.flush();
			response = (User) ois.readObject();
			if(response.getType()==1){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean addCourse(User request,Course course){
		User response = null;
		try {
			oos.writeObject(request);
			oos.writeObject(course);
			oos.writeObject(null);
			oos.flush();
			response = (User) ois.readObject();
			if(response.getType()==1){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteCourse(User request,Course course){
		User response = null;
		try {
			oos.writeObject(request);
			oos.writeObject(course);
			oos.writeObject(null);
			oos.flush();
			response = (User) ois.readObject();
			if(response.getType()==1){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public Course SelectCourse(User request,Course course){
		User response = null;
		try {
			oos.writeObject(request);
			oos.writeObject(course);
			oos.writeObject(null);
			oos.flush();
			response = (User) ois.readObject();
			if(response.getType()==1){
				Course response1 = (Course) ois.readObject();
				return response1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean setCourse(User request,Course course){
		User response = null;
		try {
			oos.writeObject(request);
			oos.writeObject(course);
			oos.writeObject(null);
			oos.flush();
			response = (User) ois.readObject();
			if(response.getType()==1){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean setState(User request,Course course){
		User response = null;
		try {
			oos.writeObject(request);
			oos.writeObject(course);
			oos.writeObject(null);
			oos.flush();
			response = (User) ois.readObject();
			if(response.getType()==1){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public User Flush(User request){
		User response = null;
		try {
			oos.writeObject(request);
			oos.writeObject(null);
			oos.flush();
			response = (User) ois.readObject();
			if(response.getType()==1){
				return response;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean DelScore(User request,int cou_id,int stu_id){
		User response = null;
		try {
			oos.writeObject(request);
			oos.writeInt(cou_id);
			oos.writeInt(stu_id);
			oos.writeObject(null);
			oos.flush();
			response = (User) ois.readObject();
			if(response.getType()==1){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean setScore(User request,int cou_id,int stu_id, double score) {
		User response = null;
		try {
			oos.writeObject(request);
			oos.writeInt(cou_id);
			oos.writeInt(stu_id);
			oos.writeDouble(score);
			oos.writeObject(null);
			oos.flush();
			response = (User) ois.readObject();
			if(response.getType()==1){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean setScores(User request, ArrayList<Score> socres) {
		User response = null;
		try {
			oos.writeObject(request);
			oos.writeObject(socres);
			oos.writeObject(null);
			oos.flush();
			response = (User) ois.readObject();
			if(response.getType()==1){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean addStudent(Student request) {
		User response = null;
		try {
			oos.writeObject(request);
			oos.writeObject(null);
			oos.flush();
			response = (User) ois.readObject();
			if(response.getType()==1){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean setTeapw(User request, String newpw) {
		User response = null;
		try {
			oos.writeObject(request);
			oos.writeObject(newpw);
			oos.writeObject(null);
			oos.flush();
			response = (User) ois.readObject();
			if(response.getType()==1){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
