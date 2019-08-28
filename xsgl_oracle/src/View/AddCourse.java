/*
 * AddCourse.java
 *
 * Created on __DATE__, __TIME__
 */

package View;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.glxt.jdbc.Jdbc;
import com.glxt.jdbc.OperateOracle;
import com.glxt.model.Course;
import com.glxt.util.ClientConnect;
import com.glxt.util.ViewUtils;

/**
 *
 * @author  __USER__
 */
public class AddCourse extends javax.swing.JFrame {

	/** Creates new form AddCourse */
	String tea_id = null;
	TeaView teaview = null;

	public AddCourse(String tea_id, TeaView teaview) {
		this.tea_id = tea_id;
		this.teaview = teaview;
		initComponents();
		ImageIcon img = new ImageIcon("img/yu.jpg");
		ViewUtils.initJComboBox(jComboBox2, Jdbc.getItem());
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
	}

	public AddCourse() {
		initComponents();
		ImageIcon img = new ImageIcon("img/yu.jpg");
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
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jTextField5 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jComboBox1 = new javax.swing.JComboBox();
		jLabel7 = new javax.swing.JLabel();
		jTextField4 = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		jTextField6 = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		jTextField7 = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		jTextField8 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jLabel11 = new javax.swing.JLabel();
		jComboBox2 = new javax.swing.JComboBox();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel1.setText(" \u8bfe \u7a0b I D\uff1a");

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel2.setText("\u8bfe\u7a0b\u540d\u79f0 \uff1a");

		jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel4.setText("    \u5b66   \u5206\uff1a");

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel3.setText("\u8bfe\u7a0b\u65f6\u95f4 \uff1a");

		jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel5.setText("\u4e0a\u8bfe\u65f6\u95f4\uff1a");

		jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel6.setText("\u4eba\u6570\u4e0a\u9650\uff1a");

		jComboBox1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"周一", "周二", "周三", "周四", "周五" }));

		jLabel7.setText("--");

		jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel8.setText("\u5468");

		jLabel9.setText("--");

		jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel10.setText("\u8282");

		jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jButton1.setText("\u63d0\u4ea4");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jButton2.setText("\u91cd\u7f6e");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jLabel11.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel11.setText("\u8bfe\u7a0b\u7c7b\u578b\uff1a");

		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "" }));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout
										.createSequentialGroup()
										.addGap(261, 261, 261)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel1)
																						.addComponent(
																								jLabel2))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								jTextField1)
																						.addComponent(
																								jTextField2,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								149,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jLabel4)
																						.addComponent(
																								jLabel3)
																						.addComponent(
																								jLabel5)
																						.addComponent(
																								jLabel6)
																						.addComponent(
																								jLabel11))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addGroup(
																												layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING,
																																false)
																														.addComponent(
																																jTextField5)
																														.addComponent(
																																jTextField3,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																64,
																																Short.MAX_VALUE)
																														.addComponent(
																																jComboBox1,
																																0,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addGroup(
																												layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addGroup(
																																layout
																																		.createSequentialGroup()
																																		.addComponent(
																																				jLabel7)
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																		.addComponent(
																																				jTextField4,
																																				javax.swing.GroupLayout.DEFAULT_SIZE,
																																				63,
																																				Short.MAX_VALUE)
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																		.addComponent(
																																				jLabel8))
																														.addGroup(
																																layout
																																		.createSequentialGroup()
																																		.addComponent(
																																				jTextField6,
																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																				29,
																																				javax.swing.GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																		.addComponent(
																																				jLabel9)
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																		.addComponent(
																																				jTextField7,
																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																				29,
																																				javax.swing.GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																		.addComponent(
																																				jLabel10))))
																						.addGroup(
																								layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING,
																												false)
																										.addComponent(
																												jComboBox2,
																												javax.swing.GroupLayout.Alignment.LEADING,
																												0,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												jTextField8,
																												javax.swing.GroupLayout.Alignment.LEADING,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												146,
																												Short.MAX_VALUE)))))
										.addGap(213, 213, 213)).addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addContainerGap(
										315, Short.MAX_VALUE).addComponent(
										jButton1).addGap(32, 32, 32)
										.addComponent(jButton2).addGap(252,
												252, 252)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(171, 171, 171)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(
																jTextField2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel3)
														.addComponent(jLabel7)
														.addComponent(jLabel8)
														.addComponent(
																jTextField3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel4)
														.addComponent(
																jTextField5,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel5)
														.addComponent(
																jComboBox1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField6,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel9)
														.addComponent(
																jTextField7,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel10))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel6)
														.addComponent(
																jTextField8,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel11)
														.addComponent(
																jComboBox2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(11, 11, 11)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE,
																false)
														.addComponent(jButton2)
														.addComponent(jButton1))
										.addGap(187, 187, 187)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void formWindowClosing(java.awt.event.WindowEvent evt) {
		teaview.flush();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		try {

			String cou_id = jTextField1.getText();
			String cou_name = jTextField2.getText();
			String cou_term = jTextField3.getText() + "-"
					+ jTextField4.getText() + "周";
			String credit = jTextField5.getText();
			String cou_time = jComboBox1.getSelectedItem().toString()
					+ jTextField6.getText() + "-" + jTextField7.getText() + "节";
			String max = jTextField8.getText();
			String type = jComboBox2.getSelectedItem().toString();
			if (isEmpty(cou_id)) {
				JOptionPane.showMessageDialog(this, "课程id不能为空！");
			} else if (isEmpty(cou_name)) {
				JOptionPane.showMessageDialog(this, "课程名称不能为空！");
			} else if (isEmpty(jTextField3.getText())
					|| isEmpty(jTextField4.getText())) {
				JOptionPane.showMessageDialog(this, "课程时间不能为空！");
			} else if (isEmpty(jTextField5.getText())) {
				JOptionPane.showMessageDialog(this, "学分不能为空！");
			} else if (isEmpty(jTextField6.getText())
					|| isEmpty(jTextField7.getText())) {
				JOptionPane.showMessageDialog(this, "上课时间不能为空！");
			} else if (isEmpty(jTextField8.getText())) {
				JOptionPane.showMessageDialog(this, "人数上限不能为空！");
			} else {
				try {
					Course course = new Course(Integer.parseInt(cou_id),
							cou_name, cou_term, cou_time, Integer
									.parseInt(credit), Integer.parseInt(max), 0);
					course.setType(type);
					if (new OperateOracle().addCourse(teaview.teacher.getId(), course
							.getCourse_id()
							+ "", course.getName(), course.getTerm(), course
							.getTime(), course.getCredit() + "", course
							.getMax()
							+ "",type)) {
						Reset();
						JOptionPane.showMessageDialog(this, "添加成功！");
					} else {
						JOptionPane.showMessageDialog(this, "课程id已存在！");
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "ID、学分和人数上限只能为数字！");
				}
			}
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
				new AddCourse().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JComboBox jComboBox2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	private javax.swing.JTextField jTextField7;
	private javax.swing.JTextField jTextField8;

	// End of variables declaration//GEN-END:variables
	public void Reset() {
		jTextField1.setText("");
		jTextField2.setText("");
		jTextField3.setText("");
		jTextField4.setText("");
		jTextField5.setText("");
		jTextField6.setText("");
		jTextField7.setText("");
		jTextField8.setText("");
		jComboBox1.setSelectedIndex(0);
	}

	public boolean isEmpty(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		return false;
	}
}