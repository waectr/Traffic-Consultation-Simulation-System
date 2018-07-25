package ui;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import persistence.AddCityLine_PER;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class AddCityLine_UI {

	private JFrame frame;
	private JTextField money;
	private JTextField alltime;
	private JTextField Lucheng;
	private JComboBox begincity;
	private JComboBox endcity;
	private JComboBox vehicle;
	private JComboBox nian;
	private JComboBox yue;
	private JComboBox ri;
	private JComboBox shi;
	private JComboBox fen;
	private Dialog d1;//添加成功提示栏
	private Dialog d2;//添加失败提示栏
	private String test="xxxx-xx-xx xx:xx:xx";
	private String s;
	private String s2;//用来获取选择框中的选择信息

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCityLine_UI window = new AddCityLine_UI();
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
	public AddCityLine_UI() {
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
		panel.setBackground(Color.CYAN);
		panel.setForeground(Color.CYAN);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u6DFB \u52A0 \u8DEF \u7EBF");
		label.setFont(new Font("方正舒体", Font.BOLD, 25));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JLabel label_1 = new JLabel("\u8D77 \u59CB \u57CE \u5E02");
		label_1.setFont(new Font("方正舒体", Font.BOLD, 20));
		
		JLabel label_2 = new JLabel("\u5230 \u8FBE \u57CE \u5E02");
		label_2.setFont(new Font("方正舒体", Font.BOLD, 20));
		
		String[] city=AddCityLine_PER.FindCity();
		begincity = new JComboBox(city);
		
		endcity = new JComboBox(city);
		
		JLabel label_3 = new JLabel("\u4EA4 \u901A \u5DE5 \u5177");
		label_3.setFont(new Font("方正舒体", Font.BOLD, 20));
		
		String[] vehicle1= {"飞机","火车"};
		vehicle = new JComboBox(vehicle1);
		
		JLabel label_4 = new JLabel("\u5F00 \u59CB \u65F6 \u95F4");
		label_4.setFont(new Font("方正舒体", Font.BOLD, 20));
		
		JLabel label_6 = new JLabel("\u8D39 \u7528");
		label_6.setFont(new Font("方正舒体", Font.BOLD, 20));
		
		money = new JTextField();
		money.setColumns(10);
		
		JLabel label_7 = new JLabel("\u5168 \u7A0B \u65F6 \u95F4");
		label_7.setFont(new Font("方正舒体", Font.BOLD, 20));
		
		alltime = new JTextField();
		alltime.setColumns(10);
		
		JLabel lblmin = new JLabel("\uFF08min\uFF09");
		lblmin.setFont(new Font("宋体", Font.BOLD, 12));
		
		JButton button = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		
		
		
		
		//创建确认按钮的响应器
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int begin,end;
				begin=AddCityLine_PER.FindCityNum(begincity.getSelectedItem().toString());
				end=AddCityLine_PER.FindCityNum(endcity.getSelectedItem().toString());
				if(begin==end) { //城市信息错误
					d2.setVisible(true);
				}else if(AddCityLine_PER.FindYON(begincity.getSelectedItem().toString(), endcity.getSelectedItem().toString())==1||Double.parseDouble(Lucheng.getText())==0||money.getText().isEmpty()||alltime.getText().isEmpty()) {
					d2.setVisible(true);
				}else {
					  SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					  try {
						s2=nian.getSelectedItem().toString()+"/"+yue.getSelectedItem().toString()+"/"+ri.getSelectedItem().toString()+" "+shi.getSelectedItem().toString()+":"+fen.getSelectedItem().toString()+":00";
						Date start=sdf.parse(s2);
						Date endl=new Date(start.getTime()+Integer.parseInt(alltime.getText())*60*1000);
						s=sdf.format(endl);
					} catch (ParseException e1) {
						throw new RuntimeException(e1);
					}
					//System.out.println(begintime.getText()+" "+s);
					//System.out.println(begincity.getSelectedItem().toString()+"||"+endcity.getSelectedItem().toString()+"||"+Lucheng.getText()+"||"+vehicle.getSelectedItem()+"||"+begintime.getText()+"||"+endtime.getText()+"||"+money.getText()+"||"+alltime.getText());
					int line=AddCityLine_PER.Memory(begin,end,Double.parseDouble(Lucheng.getText()),vehicle.getSelectedItem().toString(),s2,s,money.getText(),alltime.getText());
					if(line==1) {
						d1.setVisible(true);
					}else {
						d2.setVisible(true);
					}
				}
			}
		});
		
		//添加成功提示框
		d1=new Dialog(frame,"成功",true);//创建对话框
		d1.setBounds(400,500,300,130); //设置对话框的大小和位置
		d1.setLayout(new FlowLayout());//使用流式布局管理器
		JLabel l1=new JLabel("--------添加成功--------");
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
		d2.setBounds(400,400,300,130); //设置对话框的大小和位置
		d2.setLayout(new FlowLayout());//使用流式布局管理器
		JLabel l2=new JLabel("--------添加错误--------");
		d2.add(l2);
		JLabel l3=new JLabel("可能是添加了重复的路线或者有选框的信息没有填写完整,请返回重新填写");
		JButton b3=new JButton("返回");
		d2.add(b3);
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d2.setVisible(false);
				frame.setVisible(false);
				new AddCityLine_UI();
			}
		});
		
		JLabel Dist = new JLabel("距离");
		Dist.setFont(new Font("方正舒体", Font.BOLD, 16));
		
		Lucheng = new JTextField();
		Lucheng.setColumns(10);
		
		JLabel lblkm = new JLabel();
		lblkm.setFont(new Font("方正舒体", Font.BOLD, 12));
		
		nian = new JComboBox();
		nian.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019", "2020", "2021"}));
		
		JLabel label_5 = new JLabel("\u5E74");
		
		String[] y= {"01","02","03","04","05","06","07","08","09","10","11","12"};
		yue = new JComboBox(y);
		
		
		JLabel label_8 = new JLabel("\u6708");
		
		String[] r= {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		ri = new JComboBox(r);
		
		JLabel label_9 = new JLabel("\u65E5");
		
		shi = new JComboBox();
		shi.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		
		JLabel label_10 = new JLabel("\u65F6");
		
		fen = new JComboBox();
		fen.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		
		JLabel label_11 = new JLabel("\u5206");
		
		JButton button_1 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u9875");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GLYGuanLi();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
						.addComponent(label_2)
						.addComponent(label_4))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(vehicle, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(endcity, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(begincity, 0, 80, Short.MAX_VALUE))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(144)
									.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(116)
									.addComponent(label_7))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(138)
									.addComponent(Dist, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
							.addGap(37)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(alltime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblmin, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
								.addComponent(money, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(Lucheng, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblkm, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(115, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(4)
							.addComponent(nian, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(yue, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(ri, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
									.addGap(43)
									.addComponent(shi, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(label_10)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(fen, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(label_11, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
									.addGap(56))
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
							.addGap(79))))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(639, Short.MAX_VALUE)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(64)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(begincity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6)
						.addComponent(money, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(endcity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7)
						.addComponent(alltime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblmin))
					.addGap(29)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(vehicle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Dist)
						.addComponent(Lucheng, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblkm))
					.addGap(28)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(nian, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(yue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(ri, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_9)
						.addComponent(label_8)
						.addComponent(shi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_10)
						.addComponent(fen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_11))
					.addGap(18)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(button_1)
					.addGap(33))
		);
		panel_1.setLayout(gl_panel_1);
		frame.setVisible(true);
	}
}
