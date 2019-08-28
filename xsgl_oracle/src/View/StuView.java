/*
 * StuView.java
 *
 * Created on __DATE__, __TIME__
 */

package View;

import java.awt.Container;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.glxt.jdbc.Jdbc;
import com.glxt.jdbc.OperateOracle;
import com.glxt.model.Course;
import com.glxt.model.Student;
import com.glxt.model.User;
import com.glxt.util.ClientConnect;

/**
 *
 * @author  __USER__
 */
public class StuView extends javax.swing.JFrame {

	/** Creates new form StuView */
	Student student = null;

	public StuView(Student stu) {
		System.out.println("new 界面");
		this.student = stu;
		initComponents();
		ImageIcon img = new ImageIcon("img/stu.jpg");
		//要设置的背景图片  
		JLabel imgLabel = new JLabel(img);
		//将背景图放在标签里。  
		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		//将背景标签添加到jfram的LayeredPane面板里。  
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		//设置背景标签的位置  
		Container contain = this.getContentPane();
		((JPanel) contain).setOpaque(false);
		this.setLocationRelativeTo(null);
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {

		}
		jLabel1.setText(student.getName() + "同学，欢迎您");
		init();
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		jTable1.setDefaultRenderer(Object.class, r);
		jTable2.setDefaultRenderer(Object.class, r);
		jTable1.getTableHeader().setDefaultRenderer(r);
		jTable2.getTableHeader().setDefaultRenderer(r);
		this.setVisible(true);
	}

	public StuView() {
		initComponents();
		ImageIcon img = new ImageIcon("img/stu.jpg");
		//要设置的背景图片  
		JLabel imgLabel = new JLabel(img);
		//将背景图放在标签里。  
		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		//将背景标签添加到jfram的LayeredPane面板里。  
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		//设置背景标签的位置  
		Container contain = this.getContentPane();
		((JPanel) contain).setOpaque(false);
		this.setLocationRelativeTo(null);
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();

		} catch (Exception e) {

		}
		this.setVisible(true);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton9 = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jButton6 = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jPasswordField1 = new javax.swing.JPasswordField();
		jPasswordField2 = new javax.swing.JPasswordField();
		jPasswordField3 = new javax.swing.JPasswordField();
		jButton7 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 22));
		jLabel1
				.setText("\u5434\u67f1\u8c6a\u540c\u5b66\uff0c\u6b22\u8fce\u4f60");

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null } }, new String[] {
						"课程编号", "课程名称", "任教老师", "余量", "类型", "状态" }));
		jScrollPane1.setViewportView(jTable1);

		jButton3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jButton3.setText("\u9009\u5b9a");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jButton4.setText("\u8be6\u60c5");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jButton5.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jButton5.setText("\u5237\u65b0");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jButton9.setText("\u67e5\u627e\u8bfe\u7a0b");
		jButton9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton9ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												605,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(32, 32, 32)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jButton3,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																81,
																Short.MAX_VALUE)
														.addComponent(
																jButton9,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jButton5,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																81,
																Short.MAX_VALUE)
														.addComponent(
																jButton4,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																81,
																Short.MAX_VALUE))
										.addContainerGap()));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				363,
																				Short.MAX_VALUE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				35,
																				35,
																				35)
																		.addComponent(
																				jButton9)
																		.addGap(
																				32,
																				32,
																				32)
																		.addComponent(
																				jButton3)
																		.addGap(
																				42,
																				42,
																				42)
																		.addComponent(
																				jButton5)
																		.addGap(
																				35,
																				35,
																				35)
																		.addComponent(
																				jButton4)))
										.addContainerGap()));

		jTabbedPane1.addTab("\u9009\u8bfe", jPanel1);

		jTable2.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "课程编号",
						"课程名称", "任教老师", "分数" }));
		jScrollPane2.setViewportView(jTable2);

		jButton6.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jButton6.setText("\u5237\u65b0");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollPane2,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												623, Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jButton6,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												82,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout.createSequentialGroup().addGap(166, 166, 166)
						.addComponent(jButton6).addContainerGap()).addGroup(
				jPanel2Layout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane2,
								javax.swing.GroupLayout.DEFAULT_SIZE, 331,
								Short.MAX_VALUE).addGap(46, 46, 46)));

		jTabbedPane1.addTab("\u67e5\u770b\u6210\u7ee9", jPanel2);

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel3.setText("\u8bf7\u8f93\u5165\u539f\u59cb\u5bc6\u7801\uff1a");

		jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel4.setText("\u8bf7\u8f93\u5165\u4fee\u6539\u5bc6\u7801\uff1a");

		jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel5.setText("\u8bf7\u518d\u6b21\u8f93\u5165\u5bc6\u7801\uff1a");

		jButton7.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jButton7.setText("\u786e\u5b9a\u4fee\u6539");
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		jButton8.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jButton8.setText("\u91cd\u7f6e");
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout
				.setHorizontalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel3Layout
										.createSequentialGroup()
										.addGap(237, 237, 237)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel3Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(
																				jPanel3Layout
																						.createSequentialGroup()
																						.addComponent(
																								jLabel3)
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(
																								jPasswordField1,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								179,
																								Short.MAX_VALUE))
																		.addGroup(
																				jPanel3Layout
																						.createSequentialGroup()
																						.addGroup(
																								jPanel3Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																										.addComponent(
																												jLabel4)
																										.addComponent(
																												jLabel5))
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																						.addGroup(
																								jPanel3Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																										.addComponent(
																												jPasswordField3,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												179,
																												Short.MAX_VALUE)
																										.addComponent(
																												jPasswordField2,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												179,
																												Short.MAX_VALUE))))
														.addGroup(
																jPanel3Layout
																		.createSequentialGroup()
																		.addGap(
																				9,
																				9,
																				9)
																		.addComponent(
																				jButton7)
																		.addGap(
																				81,
																				81,
																				81)
																		.addComponent(
																				jButton8,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				97,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				20,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(203, 203, 203)));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addGap(117, 117, 117)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel3)
														.addComponent(
																jPasswordField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel4)
														.addComponent(
																jPasswordField2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel5)
														.addComponent(
																jPasswordField3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(43, 43, 43)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton7)
														.addComponent(jButton8))
										.addContainerGap(125, Short.MAX_VALUE)));

		jTabbedPane1.addTab("\u4fee\u6539\u5bc6\u7801", jPanel3);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(263,
						Short.MAX_VALUE).addComponent(jTabbedPane1,
						javax.swing.GroupLayout.PREFERRED_SIZE, 741,
						javax.swing.GroupLayout.PREFERRED_SIZE).addGap(162,
						162, 162)).addGroup(
				layout.createSequentialGroup().addGap(210, 210, 210)
						.addComponent(jLabel1).addContainerGap(758,
								Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(120,
						Short.MAX_VALUE).addComponent(jLabel1).addGap(18, 18,
						18).addComponent(jTabbedPane1,
						javax.swing.GroupLayout.PREFERRED_SIZE, 422,
						javax.swing.GroupLayout.PREFERRED_SIZE).addGap(85, 85,
						85)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
		String input = JOptionPane.showInputDialog("请输入课程编号，课程名称或者课程类别");
		ArrayList<Course> courses = null;
		if (input != null) {
			try {
				Integer.parseInt(input);
				courses = new OperateOracle().SelectCourse(input, true);
			} catch (Exception e) {
				courses = new OperateOracle().SelectCourse(input, false);
			}
			if (courses != null) {
				student.setCourses(courses);
				init();
			} else
				JOptionPane.showMessageDialog(this, "课程id不存在！");
		}
	}

	//确认修改按钮事件
	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		String pass1 = new String(jPasswordField1.getPassword());
		String pass2 = new String(jPasswordField2.getPassword());
		String pass3 = new String(jPasswordField2.getPassword());
		if (pass2.equals(pass3)) {
			if (student.getPw().equals(pass1)) {
				if (!checkPassword(pass2)) {
					JOptionPane.showMessageDialog(null, "密码必须为6-13的数字或者数字字母混合");
					return;
				}
				try {
					if (new OperateOracle().setpw(student.getPw(), pass2, student.getId(),false)) {
						JOptionPane.showMessageDialog(this, "修改成功");
						student.setPw(pass2);
						jPasswordField1.setText("");
						jPasswordField2.setText("");
						jPasswordField3.setText("");
					} else {
						JOptionPane.showMessageDialog(this, "修改失败！");
						jPasswordField1.setText("");
						jPasswordField2.setText("");
						jPasswordField3.setText("");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			} else
				JOptionPane.showMessageDialog(this, "原始密码错误");
		} else
			JOptionPane.showMessageDialog(this, "两次密码不一致");
	}

	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
		jPasswordField1.setText("");
		jPasswordField2.setText("");
		jPasswordField3.setText("");
	}

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			student.setScores(new OperateOracle().getAllScore(student.getId()));
			init();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		int row[] = jTable1.getSelectedRows();
		String cou[] = new String[2];
		if (row.length == 0) {
			JOptionPane.showMessageDialog(this, "没有选中课程！");
		} else if (row.length == 1) {
			cou[0] = jTable1.getValueAt(row[0], 0).toString();
			cou[1] = jTable1.getValueAt(row[0], 4).toString();
			String course[] = ClientConnect.getDeltail(student, cou);
			new StuDetails(course);
		} else
			JOptionPane.showMessageDialog(this, "不能同时选定两个以上的课程！");
	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			this.student.setCourses(new OperateOracle().getAllCourse());
			this.student.setScores(new OperateOracle().getAllScore(student.getId()));
			init();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			if (ClientConnect.selectCourse(student, jTable1)) {
				int row[] = jTable1.getSelectedRows();
				jTable1.setValueAt("已选", row[0], 5);
				jTable1.invalidate();
				DefaultTableModel tableMode2 = (DefaultTableModel) jTable2
						.getModel();
				String data[] = new String[4];
				data[0] = jTable1.getValueAt(row[0], 0).toString();
				data[1] = jTable1.getValueAt(row[0], 1).toString();
				data[2] = jTable1.getValueAt(row[0], 2).toString();
				data[3] = "成绩未公布";
				tableMode2.addRow(data);
				jTable2.invalidate();
				for (int i = 0; i < student.getCourses().size(); i++) {
					if ((student.getCourses().get(i).getCourse_id() + "")
							.equals(data[0])) {
						student.getCourses().get(i).setNumber(
								student.getCourses().get(i).getNumber() + 1);
						break;
					}
				}
				JOptionPane.showMessageDialog(this, "选课成功");
			} else
				JOptionPane.showMessageDialog(this, "选课失败");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper
							.launchBeautyEyeLNF();

				} catch (Exception e) {

				}
				new StuView().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JButton jButton9;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPasswordField jPasswordField1;
	private javax.swing.JPasswordField jPasswordField2;
	private javax.swing.JPasswordField jPasswordField3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;

	// End of variables declaration//GEN-END:variables
	public void init() {
		initJTable(jTable1, ClientConnect.getstutable1(student));
		initJTable(jTable2, ClientConnect.getstutable2(student));
	}

	public void initJTable(JTable jtable, String[][] rowdata) {
		DefaultTableModel tableModel = (DefaultTableModel) jtable.getModel();
		tableModel.setRowCount(0);
		for (int i = 0; i < rowdata.length; i++) {
			tableModel.addRow(rowdata[i]);
		}
		jTable1.invalidate();
	}

	//正则表达式检测密码是不是六位以上
	public static boolean checkPassword(String pw) {
		boolean flag = false;
		try {
			String check = "^[\\d|A-Za-z]{6,13}$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(pw);
			flag = matcher.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}