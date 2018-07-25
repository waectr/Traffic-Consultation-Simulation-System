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
import persistence.DelCityLine_PER;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DelCityLine {

	private JFrame frame;
	private JComboBox<String> choice1;
	private JComboBox<String> choice2;
	private JComboBox<String> choice3;
	private Dialog d1;//添加成功提示栏
	private Dialog d2;//添加失败提示栏
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DelCityLine window = new DelCityLine();
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
	public DelCityLine() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u5220 \u9664");
		label.setFont(new Font("方正舒体", Font.BOLD, 30));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JLabel label_1 = new JLabel("\u5982\u679C\u4F60\u60F3\u8981\u5220\u9664\u5DF2\u6709\u7684\u57CE\u5E02\uFF0C\u8BF7\u9009\u62E9");
		label_1.setFont(new Font("方正舒体", Font.BOLD, 18));
		
		String[] city=AddCityLine_PER.FindCity();
		choice1 = new JComboBox<String>(city);
		
		JLabel label_2 = new JLabel(",\u5E76\u4E14\u70B9\u51FB");
		label_2.setFont(new Font("方正舒体", Font.BOLD, 18));
		
		JButton button = new JButton("\u786E\u8BA4");
		
		
		//删除城市信息的按钮,删除该城市需要删除该城市的所有线路
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int num=AddCityLine_PER.FindCityNum(choice1.getSelectedItem().toString());
					DelCityLine_PER.DelCityLine(num);
					int i=DelCityLine_PER.DelCity(choice1.getSelectedItem().toString());
					if(i==1) {
						  d1.setVisible(true);//删除成功
					}else {
						d2.setVisible(true);//删除错误
					}
			}
		});
		button.setFont(new Font("方正舒体", Font.BOLD, 14));
		
		JLabel label_3 = new JLabel("\u5982\u679C\u4F60\u60F3\u5220\u9664");
		label_3.setFont(new Font("方正舒体", Font.BOLD, 18));
		
		choice2 = new JComboBox<String>(city);
		
		JLabel label_4 = new JLabel("\u5230");
		label_4.setFont(new Font("方正舒体", Font.BOLD, 18));
		
		choice3 = new JComboBox<String>(city);
		
		JLabel label_5 = new JLabel("\u4E4B\u95F4\u7684\u8DEF\u7EBF\uFF0C\u8BF7\u70B9\u51FB");
		label_5.setFont(new Font("方正舒体", Font.BOLD, 18));
		
		JButton button_1 = new JButton("\u786E\u8BA4");
		button_1.setFont(new Font("方正舒体", Font.BOLD, 14));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_1)
							.addGap(19)
							.addComponent(choice1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_2)
							.addGap(4)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(choice2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(choice3, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(91, Short.MAX_VALUE))
		);
		//删除路线按钮
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int begin,end;
				begin=AddCityLine_PER.FindCityNum(choice2.getSelectedItem().toString());
				end=AddCityLine_PER.FindCityNum(choice3.getSelectedItem().toString());
				int i=DelCityLine_PER.DelTowCityLine(begin, end);
				if(begin==end||i!=1) {
					d2.setVisible(true);
				}else if(i==1){
					d1.setVisible(true);
				}else {
					d2.setVisible(true);
				}
			}
		});
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(choice1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(button))
					.addGap(105)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_3)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(choice2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_4)
							.addComponent(choice3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_5)
							.addComponent(button_1)))
					.addContainerGap(146, Short.MAX_VALUE))
		);
		//添加成功提示框
		d1=new Dialog(frame,"成功",true);//创建对话框
		d1.setBounds(400,500,300,130); //设置对话框的大小和位置
		d1.setLayout(new FlowLayout());//使用流式布局管理器
		JLabel l1=new JLabel("--------删除成功--------");
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
		JLabel l2=new JLabel("--------删除错误--------");
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
