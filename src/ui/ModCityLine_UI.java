package ui;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import persistence.AddCityLine_PER;
import persistence.ModCityLine_PER;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModCityLine_UI {

	private JFrame frame;
	private JTextField textField;
	private JTextField money;
	private JTextField alltime;
	private JTextField begintime;
	private JTextField endtime;
	private JComboBox<String> begincity;
	private JComboBox<String> endcity;
	private JTextField dis1;
	private JComboBox<String> vel;
	private Dialog d1,d2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModCityLine_UI window = new ModCityLine_UI();
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
	public ModCityLine_UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 830, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u4FEE \u6539 \u4FE1 \u606F");
		label.setFont(new Font("方正舒体", Font.BOLD, 30));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u9009\u62E9\u8981\u4FEE\u6539\u7684\u57CE\u5E02\u533A\u95F4");
		lblNewLabel.setFont(new Font("方正舒体", Font.BOLD, 20));
		
		String[] city=AddCityLine_PER.FindCity();
		begincity = new JComboBox<String>(city);
		
		JLabel label_1 = new JLabel("\u5230");
		
		endcity = new JComboBox<String>(city);
		
		JLabel label_2 = new JLabel("\u4EA4\u901A\u5DE5\u5177");
		label_2.setFont(new Font("方正舒体", Font.BOLD, 20));
		
		JLabel label_3 = new JLabel("\u8D39 \u7528");
		label_3.setFont(new Font("方正舒体", Font.BOLD, 20));
		
		JLabel label_4 = new JLabel("\u5F00\u59CB\u65F6\u95F4");
		label_4.setFont(new Font("方正舒体", Font.BOLD, 20));
		
		JLabel label_5 = new JLabel("\u5230\u8FBE\u65F6\u95F4");
		label_5.setFont(new Font("方正舒体", Font.BOLD, 20));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		money = new JTextField();
		money.setColumns(10);
		
		JLabel label_6 = new JLabel("\u5168\u7A0B\u65F6\u95F4");
		label_6.setFont(new Font("方正舒体", Font.BOLD, 20));
		
		alltime = new JTextField();
		alltime.setColumns(10);
		
		String[] a= {"火车","飞机"};
		vel = new JComboBox<String>(a);
		
		JLabel lblRmb = new JLabel("RMB");
		
		JLabel lblmin = new JLabel("\uFF08min\uFF09");
		
		begintime = new JTextField();
		begintime.setColumns(10);
		
		endtime = new JTextField();
		endtime.setColumns(10);
		
		JLabel lblXxxxxxxxxxxx = new JLabel("\u5E74/\u6708/\u65E5 \u65F6:\u5206:\u79D2");
		
		JButton button2 = new JButton("\u786E\u8BA4");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int begin,end;
				begin=AddCityLine_PER.FindCityNum(begincity.getSelectedItem().toString());
				end=AddCityLine_PER.FindCityNum(endcity.getSelectedItem().toString());
				if(begin==end||money.getText().isEmpty()||begintime.getText().isEmpty()||endtime.getText().isEmpty()||alltime.getText().isEmpty()) {
					d2.setVisible(true);//提示错误
				}else {
					int i=ModCityLine_PER.ModCityLine(begin,end,Double.parseDouble(dis1.getText()),vel.getSelectedItem().toString(), begintime.getText(), endtime.getText(), money.getText(), alltime.getText());
					if(i==1) {
						d1.setVisible(true);//提示成功
					}else {
						d2.setVisible(true);//提示错误
					}
				}
			}
		});
		
		JLabel dis = new JLabel("\u8DDD\u79BB");
		dis.setFont(new Font("方正舒体", Font.BOLD, 20));
		
		dis1 = new JTextField();
		dis1.setColumns(10);
		
		JLabel lblKm = new JLabel("km");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(34)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(label_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
										.addComponent(label_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(label_5, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(endtime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(begintime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblXxxxxxxxxxxx, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(money, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblRmb, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
											.addComponent(vel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))))
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(begincity, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(endcity, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(button2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
												.addComponent(dis, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_6))
											.addGap(18)
											.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(dis1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(alltime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
									.addGap(18)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(lblKm, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblmin, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(47)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(128, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(57)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(begincity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(endcity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6)
						.addComponent(alltime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(vel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblmin))
					.addGap(30)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(money, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRmb)
						.addComponent(dis)
						.addComponent(dis1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKm))
					.addGap(28)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(begintime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblXxxxxxxxxxxx)
						.addComponent(button2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label_5)
						.addComponent(endtime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		
		//添加成功提示框
				d1=new Dialog(frame,"成功",true);//创建对话框
				d1.setBounds(400,500,300,130); //设置对话框的大小和位置
				d1.setLayout(new FlowLayout());//使用流式布局管理器
				JLabel l1=new JLabel("--------修改成功--------");
				d1.add(l1);
				JButton b1=new JButton("确认");
				d1.add(b1);
				b1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						d1.setVisible(false);
						frame.setVisible(false);
						new GLYGuanLi();
					}
				});
				
				//添加失败提示框
				d2=new Dialog(frame,"错误",true);//创建对话框
				d2.setBounds(400,500,300,130); //设置对话框的大小和位置
				d2.setLayout(new FlowLayout());//使用流式布局管理器
				JLabel l2=new JLabel("--------修改错误--------");
				d2.add(l2);
				JButton b3=new JButton("返回");
				d2.add(b3);
				b3.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						d2.setVisible(false);
						frame.setVisible(false);
						new GLYGuanLi();
					}
				});
		panel_1.setLayout(gl_panel_1);
		frame.setVisible(true);
	}
}
