package com.glxt.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewUtils {
	//��ʼ��table
	public static void initJTable(JTable jtable, String[][] rowdata) {
		//��ȡtable��model
		DefaultTableModel tableModel = (DefaultTableModel) jtable.getModel();
		//���table������
		tableModel.setRowCount(0);
		//ʹ��ѭ�����������
		for (int i = 0; i < rowdata.length; i++) {
			tableModel.addRow(rowdata[i]);
		}
		//����table
		jtable.invalidate();
	}
	
	//��ʼ��������
	public static void initJComboBox(JComboBox jComboBox, String[] item) {
		//ȫ�����������ԭ����item
		jComboBox.removeAllItems();
		//���ӵ�һ���յ�item
		jComboBox.addItem("");
		//ʹ��ѭ�����item
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
