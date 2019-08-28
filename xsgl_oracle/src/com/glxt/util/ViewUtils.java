package com.glxt.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewUtils {
	//初始化table
	public static void initJTable(JTable jtable, String[][] rowdata) {
		//获取table的model
		DefaultTableModel tableModel = (DefaultTableModel) jtable.getModel();
		//清空table的内容
		tableModel.setRowCount(0);
		//使用循环添加行内容
		for (int i = 0; i < rowdata.length; i++) {
			tableModel.addRow(rowdata[i]);
		}
		//更新table
		jtable.invalidate();
	}
	
	//初始化下拉框
	public static void initJComboBox(JComboBox jComboBox, String[] item) {
		//全部情况下拉框原来的item
		jComboBox.removeAllItems();
		//增加第一个空的item
		jComboBox.addItem("");
		//使用循环添加item
		for (int i = 0; i < item.length; i++) {
			jComboBox.addItem(item[i]);
		}
	}
	
	public static boolean checkPassword(String pw){
		boolean flag = false;
		try{
		String check = "^[\\d|A-Za-z]{6,13}$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(pw);
		flag = matcher.matches();
		}catch(Exception e){
		flag = false;
		}
		return flag;
	}
}
