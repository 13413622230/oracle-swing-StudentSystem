/*
 * AddTeacher.java
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
import com.glxt.model.Teacher;
import com.glxt.util.ViewUtils;

/**
 *
 * @author  __USER__
 */
public class AddTeacher extends javax.swing.JFrame {

	/** Creates new form AddTeacher */
	public AddTeacher() {
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
		this.setVisible(true);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel9 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jTextField1 = new javax.swing.JTextField();
		jPasswordField1 = new javax.swing.JPasswordField();
		jTextField3 = new javax.swing.JTextField();
		jComboBox1 = new javax.swing.JComboBox();
		jButton3 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14));
		jLabel9.setText("\u5bc6\u7801\uff1a");

		jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14));
		jLabel8.setText("\u5e74\u9f84\uff1a");

		jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14));
		jLabel7.setText("\u6027\u522b\uff1a");

		jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14));
		jLabel4.setText("  ID \uff1a");

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14));
		jLabel3.setText("\u59d3\u540d\uff1a");

		jTextField2
				.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14));

		jTextField1
				.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14));

		jPasswordField1.setFont(new java.awt.Font("Microsoft YaHei UI Light",
				1, 14));

		jTextField3
				.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14));

		jComboBox1
				.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14));
		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"男", "女" }));

		jButton3.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14));
		jButton3.setText("\u786e\u8ba4\u6dfb\u52a0");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(182, 182, 182)
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
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jLabel8)
																						.addComponent(
																								jLabel7))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(
																								jTextField3,
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jComboBox1,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								64,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel4)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jTextField2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				178,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel3)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jTextField1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				178,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel9)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jPasswordField1,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				178,
																				Short.MAX_VALUE))
														.addComponent(
																jButton3,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																228,
																Short.MAX_VALUE))
										.addGap(192, 192, 192)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(128, 128, 128)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextField2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel4))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel3))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jComboBox1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																23,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel7))
										.addGap(9, 9, 9)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel8)
														.addComponent(
																jTextField3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel9)
														.addComponent(
																jPasswordField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(34, 34, 34).addComponent(
												jButton3).addContainerGap(167,
												Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		String tea_name = jTextField1.getText();
		String tea_id = jTextField2.getText();
		String tea_pw = new String(jPasswordField1.getPassword());
		String tea_sex = jComboBox1.getSelectedItem().toString();
		int tea_age = 0;
		try {
			Integer.parseInt(tea_id);
			tea_age = Integer.parseInt(jTextField3.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "学号和年龄不能为空并且必须是数字！");
		}
		if (tea_name == null || tea_name.isEmpty()) {
			JOptionPane tip = new JOptionPane();
			JOptionPane.showMessageDialog(this, "姓名不能为空！");
			tip.setVisible(true);
		} else if (tea_id == null || tea_id.isEmpty()) {
			JOptionPane tip = new JOptionPane();
			JOptionPane.showMessageDialog(this, "学号不能为空！");
			tip.setVisible(true);
		} else if (tea_pw == null || tea_pw.isEmpty()) {
			JOptionPane tip = new JOptionPane();
			JOptionPane.showMessageDialog(this, "密码不能为空！");
			tip.setVisible(true);
		} else if (!ViewUtils.checkPassword(tea_pw)) {
			JOptionPane.showMessageDialog(null, "密码必须为6-13的数字或者数字字母混合");
		} else {
			Teacher teacher = new Teacher(tea_id, tea_pw, tea_name, tea_sex,
					tea_age);
			if (new OperateOracle().addTeacher(teacher)) {
				JOptionPane.showMessageDialog(this, "添加教师成功！");
			} else
				JOptionPane.showMessageDialog(this, "添加教师失败，请检查ID是否正确！");
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AddTeacher().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton3;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPasswordField jPasswordField1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	// End of variables declaration//GEN-END:variables

}