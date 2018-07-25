package ui;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import persistence.GLYDenLu_PER;
import persistence.UserUse_PER;

import javax.swing.JButton;
import java.awt.SystemColor;

public class Login_UI {

	private JFrame frame;
	private JTextField zhanghao;
	private JPasswordField mima;
	private Dialog d;
	private JPasswordField JTF;
	private Dialog d2;//提示登录失败的窗口
	private Dialog d1;//弹出验证码
	private JTextField yzm1;
	private int y;
	private int count=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_UI window = new Login_UI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 927, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		
		JPanel panel_1 = new JPanel();
		//创建管理员登录时的对话框
		d=new Dialog(frame,"请输入管理员登录号",true);//创建对话框
		d.setBounds(400,500,300,130); //设置对话框的大小和位置
		d.setLayout(new FlowLayout());//使用流式布局管理器
		JButton DLQR=new JButton("确认");
		JTF=new JPasswordField(20);
		d.add(JTF);
		d.add(DLQR);
		JButton b3=new JButton("返回");
		d.add(b3);
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d.setVisible(false);
			}
		});
		
		//创建验证码
		Random r=new Random();
		y=r.nextInt(9999-1000+1)+1000;//随机生成四位数
		String yzm="请输入如下验证码:"+y+"";
		d1=new Dialog(frame,"请输入验证码",true);//创建对话框
		d1.setBounds(400,500,300,130); //设置对话框的大小和位置
		d1.setLayout(new FlowLayout());//使用流式布局管理器
		JLabel l=new JLabel(yzm);
		yzm1=new JTextField(20);
		JButton q=new JButton("确认");
		d1.add(l);
		d1.add(yzm1);
		d1.add(q);
		q.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(yzm1.getText().equals(y+"")) {
					d1.setVisible(false);
				}
			}
		});
		//创建用户名密码错误提示框
		d2=new Dialog(frame,"错误",true);//创建对话框
		d2.setBounds(400,500,400,130); //设置对话框的大小和位置
		d2.setLayout(new FlowLayout());//使用流式布局管理器
		JLabel l1=new JLabel("请输入正确的用户名或密码");
		d2.add(l1);
		JButton b=new JButton("我知道了");
		d2.add(b);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d2.setVisible(false);
			}
		});
				
		
		//管理员登录
		JButton guanliyuandenlu = new JButton("\u7BA1\u7406\u5458\u767B\u5F55");
		guanliyuandenlu.setFont(new Font("方正舒体", Font.BOLD, 12));
		
		ImageIcon im1=new ImageIcon("F:\\workspace\\Map\\4.jpg");
		JLabel p1 = new JLabel(im1);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 913, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(p1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
							.addComponent(guanliyuandenlu)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
							.addComponent(guanliyuandenlu))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(97)
							.addComponent(p1, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))))
		);
		//管理员登录的响应
		guanliyuandenlu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d.setVisible(true);
			}
		});
		//管理员窗口登录验证
		DLQR.addActionListener(new ActionListener() {
			int i=0;
			public void actionPerformed(ActionEvent e) {
				String password=String.valueOf(JTF.getPassword());//获得该框中的信息
				System.out.println("sss"+password);
				i=GLYDenLu_PER.Check(password);		//此处需要调用函数来检索管理员密码
				if(i==1) {
					//GLY gly=GLYDenLu_PER.Xinxi(password);//传信息
					new GLYGuanLi();
					frame.setVisible(false);
					d.setVisible(false);
				}else {
					System.out.println("信息不对");
				}
			}
		});
		
		zhanghao = new JTextField();
		zhanghao.setColumns(10);
		
		mima = new JPasswordField();
		mima.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_1.setFont(new Font("方正舒体", Font.BOLD, 24));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6 \u7801");
		lblNewLabel_2.setFont(new Font("方正舒体", Font.BOLD, 24));
		
		JButton denlu = new JButton("\u767B \u5F55");
		denlu.setFont(new Font("方正舒体", Font.BOLD, 17));
		
		JButton zhuce = new JButton("\u6CE8 \u518C");
		zhuce.setFont(new Font("方正舒体", Font.BOLD, 17));
		
		JButton wangmm = new JButton("\u5FD8\u8BB0\u5BC6\u7801");
		wangmm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WangJiMiMa_UI();            //忘记密码窗口
				frame.setVisible(false);
			}
		});
		wangmm.setFont(new Font("方正舒体", Font.BOLD, 12));
		
		JButton button = new JButton("\u5FEB\u901F\u8FDB\u5165");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new UserUse_UI();
			}
		});
		button.setFont(new Font("方正舒体", Font.BOLD, 12));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addGap(38)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(mima, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
								.addComponent(zhanghao, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(56)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(denlu, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(wangmm, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(zhuce, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))))
					.addGap(88))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(72)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(zhanghao, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(mima, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(51)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(zhuce, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(denlu, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(wangmm)
						.addComponent(button))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("\u4EA4 \u901A \u54A8 \u8BE2 \u7CFB \u7EDF");
		lblNewLabel.setFont(new Font("方正舒体", Font.BOLD, 34));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(292, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE)
					.addGap(186))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
		);
		
		//普通用户注册
		zhuce.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new ZHZhuCe();
			}
		});
		//普通用户登录
		denlu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(count>=3) {
					d1.setVisible(true);
				}
				int i=UserUse_PER.CheckUser(zhanghao.getText(),String.valueOf(mima.getPassword()));
				if(i==1) {//密码正确
					frame.setVisible(false);
					new UserUse_UI();
				}else {//密码错误
					count++;
					d2.setVisible(true);
				}
			}
		});
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}
}
