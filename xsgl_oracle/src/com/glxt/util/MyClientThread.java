package com.glxt.util;

import java.io.*;
import java.net.*;

import com.glxt.model.User;

public class MyClientThread extends Thread {
	Socket socket = null;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	User user = null;
//	BufferedReader br = null;
//	PrintWriter pw = null;
	public MyClientThread(Socket socket, User user){
		this.socket = socket;
		this.user = user;
	}
	public void run(){
		try {
//			br = new BufferedReader(new InputStreamReader(System.in));
//			pw = new PrintWriter(socket.getOutputStream(),true);
//			String m;
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(user);
			oos.flush();
			oos.writeObject(null);
//			while(true){
//				m = br.readLine();
//				pw.println(m);
//			}
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
}
