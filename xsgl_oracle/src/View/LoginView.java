/*
 * LoginView.java
 *
 * Created on __DATE__, __TIME__
 */

package View;

import java.awt.Container;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.glxt.jdbc.Jdbc;
import com.glxt.jdbc.OperateOracle;
import com.glxt.model.Student;
import com.glxt.model.Teacher;
import com.glxt.model.User;
import com.glxt.util.ClientConnect;

/**
 *
 * @author  __USER__
 */
public class LoginView extends javax.swing.JFrame {

	/** Creates new form LoginView */
	public LoginView() {
		initComponents();
		this.jPasswordField1.setEchoChar('\0');
		ImageIcon img = new ImageIcon("img/login.jpg");
		JLabel imgLabel = new JLabel(img);
		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		Container contain = this.getContentPane();
		((JPanel) contain).setOpaque(false);
		this.setLocationRelativeTo(null);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		buttonGroup2 = new javax.swing.ButtonGroup();
		jButton1 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jPasswordField1 = new javax.swing.JPasswordField();
		jRadioButton1 = new javax.swing.JRadioButton();
		jRadioButton2 = new javax.swing.JRadioButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u5b66\u751f\u9009\u8bfe\u7cfb\u7edf");
		setForeground(new java.awt.Color(51, 153, 255));

		jButton1.setBackground(new java.awt.Color(0, 102, 204));
		jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jButton1.setForeground(new java.awt.Color(0, 102, 204));
		jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/loginB.jpg"))); // NOI18N
		jButton1.setText("\u767b\u9646");
		jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jButton1entered(evt);
			}
		});
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel1.setForeground(new java.awt.Color(0, 102, 204));
		jLabel1.setText("\u7528\u6237\u540d\uff1a");

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel2.setForeground(new java.awt.Color(0, 102, 204));
		jLabel2.setText("\u5bc6   \u7801\uff1a");

		jTextField1.setText("\u8bf7\u8f93\u5165\u7528\u6237\u540d");
		jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				jTextField1FocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				jTextField1FocusLost(evt);
			}
		});

		jPasswordField1.setText("\u8bf7\u8f93\u5165\u5bc6\u7801");
		jPasswordField1.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				jPasswordField1FocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				jPasswordField1FocusLost(evt);
			}
		});

		buttonGroup1.add(jRadioButton1);
		jRadioButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jRadioButton1.setForeground(new java.awt.Color(0, 102, 204));
		jRadioButton1.setText("\u5b66\u751f");

		buttonGroup1.add(jRadioButton2);
		jRadioButton2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jRadioButton2.setForeground(new java.awt.Color(0, 102, 204));
		jRadioButton2.setText("\u8001\u5e08");

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
										.addContainerGap(489, Short.MAX_VALUE)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(
																jButton1,
																javax.swing.GroupLayout.Alignment.LEADING,
																0, 0,
																Short.MAX_VALUE)
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel1)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jTextField1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												169,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel2)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jPasswordField1,
																												0,
																												0,
																												Short.MAX_VALUE)))
																		.addGroup(
																				layout
																						.createSequentialGroup()
																						.addGap(
																								45,
																								45,
																								45)
																						.addComponent(
																								jRadioButton1)
																						.addGap(
																								43,
																								43,
																								43)
																						.addComponent(
																								jRadioButton2))))
										.addGap(458, 458, 458)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(232, 232, 232)
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
																jPasswordField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jRadioButton1)
														.addComponent(
																jRadioButton2))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jButton1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(320, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton1entered(java.awt.event.MouseEvent evt) {
		if (jRadioButton1.isSelected()) {
			System.out.println("学生");
		} else if (jRadioButton2.isSelected()) {

		} else {
			this.jButton1.setToolTipText("请选择用户类型");
		}
	}

	private void jPasswordField1FocusLost(java.awt.event.FocusEvent evt) {
		if (jPasswordField1.getPassword() == null
				|| jPasswordField1.getPassword().length == 0) {
			jPasswordField1.setText("请输入密码");
			jPasswordField1.setEchoChar('\0');
		}
	}

	private void jPasswordField1FocusGained(java.awt.event.FocusEvent evt) {
		if ((new String(jPasswordField1.getPassword())).equals("请输入密码")) {
			jPasswordField1.setText("");
			jPasswordField1.setEchoChar('*');
		}
	}

	private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {
		if (jTextField1.getText() == null
				|| jTextField1.getText().length() == 0) {
			jTextField1.setText("请输入用户名");

		}
	}

	private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {
		if (jTextField1.getText().equals("请输入用户名")) {
			jTextField1.setText("");
		}
	}

	//登陆按钮事件
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		String id = jTextField1.getText();
		String pw = new String(jPasswordField1.getPassword());
		System.out.println(id);
		System.out.println(pw);
		if (id.equals("请输入用户名")) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
		} else if (pw.equals("请输入密码")) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
		} else if (!checkPassword(pw)) {
			JOptionPane.showMessageDialog(null, "密码必须为6-13的数字或者数字字母混合");
		} else {
			//选择了学生单选
			if (jRadioButton1.isSelected()) {
				User user = new User(id, pw);
				user.setType(1);
				try {
					Student response1 = new OperateOracle().stu_Login(id, pw);
					if (response1.getType() == 1) {
						new StuView(response1);
						this.dispose();
					} else if (response1.getType() == 0) {
						JOptionPane.showMessageDialog(null, "密码错误");
					} else if (response1.getType() == -1) {
						JOptionPane.showMessageDialog(null, "账号不存在");
					}

				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(this, e.getMessage());
				}
			}
			//选择了老师单选
			else if (jRadioButton2.isSelected()) {
				try {
					//进入数据库登陆操作
					User response1 = new OperateOracle().tea_Login(id, pw);
					//type为1就是登陆成功
					if (response1.getType() == 1) {
						Teacher teacher = (Teacher) response1;
						new TeaView(teacher);
						this.dispose();
					}
					//type为0就是密码错误
					else if (response1.getType() == 0) {
						JOptionPane.showMessageDialog(null, "密码错误");
					}
					//type为-1就是账号不存在
					else if (response1.getType() == -1) {
						JOptionPane.showMessageDialog(null, "账号不存在");
					}

				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(this, e.getMessage());
				}
			} else {
				JOptionPane.showMessageDialog(null, "请选择用户类型");
			}

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
				new LoginView().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.ButtonGroup buttonGroup2;
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPasswordField jPasswordField1;
	private javax.swing.JRadioButton jRadioButton1;
	private javax.swing.JRadioButton jRadioButton2;
	private javax.swing.JTextField jTextField1;

	// End of variables declaration//GEN-END:variables
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