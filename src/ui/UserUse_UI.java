package ui;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTable;

import other.Disjkstra;
import persistence.AddCityLine_PER;
import persistence.AddCity_PER;
import persistence.FindLine_PER;
import persistence.UserUse_PER;
import person.DijkLine;
import person.FindLineTest;
import person.Line;

import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserUse_UI {

	private JFrame frame;
	private JTable table;
	private JComboBox begincity;
	private JComboBox endcity;
	private Dialog d;//提示用户要选择的信息
	private Dialog d1;
	private Dialog d2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserUse_UI window = new UserUse_UI();
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
	public UserUse_UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 897, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		ImageIcon icon=new ImageIcon("F:\\workspace\\Map\\2.jpg");
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 883, 43);
		panel_1.setBackground(Color.LIGHT_GRAY);
		
		JLabel label = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u4EA4\u901A\u54A8\u8BE2\u7CFB\u7EDF");
		label.setFont(new Font("方正舒体", Font.BOLD, 30));
		panel_1.add(label);
		panel.add(panel_1);
		
		String[] city=AddCityLine_PER.FindCity();
		begincity = new JComboBox(city);
		begincity.setBounds(154, 137, 84, 30);
		panel.add(begincity);
		
		JLabel label_1 = new JLabel("\u5230");
		label_1.setBounds(259, 145, 19, 15);
		panel.add(label_1);
		
		endcity = new JComboBox(city);
		endcity.setBounds(288, 137, 84, 30);
		panel.add(endcity);
		
		JLabel label_2 = new JLabel("\u8BF7\u9009\u62E9\u4F60\u8981\u67E5\u8BE2\u7684\u57CE\u5E02");
		label_2.setFont(new Font("方正舒体", Font.BOLD, 20));
		label_2.setBounds(50, 79, 264, 30);
		panel.add(label_2);
		
		JButton b1 = new JButton("\u67E5\u8BE2");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(0==AddCityLine_PER.FindYON(begincity.getSelectedItem().toString(), endcity.getSelectedItem().toString())) {
					d2.setVisible(true);
				}else {
					d.setVisible(true);
				}
			}
		});
		b1.setFont(new Font("方正舒体", Font.BOLD, 20));
		b1.setBounds(455, 137, 104, 30);
		panel.add(b1);
		
		JButton b2 = new JButton("\u7545\u6E38\u534E\u590F");
		
		//畅游华夏的按钮
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new ShowChina_UI();
			}
		});
		b2.setFont(new Font("方正舒体", Font.BOLD, 24));
		b2.setBounds(670, 349, 165, 65);
		panel.add(b2);
		
		//导入信息
		List<Line> list=UserUse_PER.GetCityLine();
		Object[][] data=new Object[list.size()][8];
		for(int i=0;i<list.size();i++) {
			data[i][0]=AddCity_PER.Getcity(list.get(i).getBegincity());
			data[i][1]=AddCity_PER.Getcity(list.get(i).getEndcity());
			data[i][2]=list.get(i).getDis();
			data[i][3]=list.get(i).getVehicle();
			data[i][4]=list.get(i).getBegintime();
			data[i][5]=list.get(i).getEndtime();
			data[i][6]=list.get(i).getMoney();
			data[i][7]=list.get(i).getAlltime();
		}
		String[] top= {"起点","终端","距离(KM)","工具","开始","结束","费用(RMB)","时间(min)"};
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 210, 620, 254);
		panel.add(scrollPane);
		
		table = new JTable(data,top);
		table.setBackground(SystemColor.window);
		table.setFont(new Font("楷体", Font.BOLD, 9));
		
		d=new Dialog(frame,"请输入验证码",true);//创建对话框
		d.setBounds(400,500,300,130); //设置对话框的大小和位置
		d.setLayout(new FlowLayout());//使用流式布局管理器
		JLabel l=new JLabel("----------请选择需要查询的方式-----------");
		d.add(l);
		JButton b4=new JButton("最省钱的路线");
		d.add(b4);
		JButton b5=new JButton("最省时间的路线");
		d.add(b5);
		
		//城市重复
		d1=new Dialog(frame,"错误",true);//创建对话框
		d1.setBounds(400,500,300,130); //设置对话框的大小和位置
		d1.setLayout(new FlowLayout());//使用流式布局管理器
		JLabel l1=new JLabel("不能查询相同的城市");
		d1.add(l1);
		JButton b6=new JButton("返回");
		d1.add(b6);
		b6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d.setVisible(false);
				d1.setVisible(false);
			}
		});
		
		d2=new Dialog(frame,"错误",true);//创建对话框
		d2.setBounds(400,500,300,130); //设置对话框的大小和位置
		d2.setLayout(new FlowLayout());//使用流式布局管理器
		JLabel l2=new JLabel("未查到相关线路的信息");
		d2.add(l2);
		JButton b7=new JButton("返回");
		d2.add(b7);
		b7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				d2.setVisible(false);
			}
		});
		
		//最省钱的出行
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				
				int[][] ver=FindLine_PER.GetCityTuMon();//获得以钱为权重的矩阵
				int i=FindLine_PER.GetCityNum();
				int[] count=new int[i];
				for(int j=0;j<i;j++) {
					count[j]=j;
				}
				int begin,end;
				begin=AddCityLine_PER.FindCityNum(begincity.getSelectedItem().toString());
				end=AddCityLine_PER.FindCityNum(endcity.getSelectedItem().toString());
				if(begin==end) {
					d1.setVisible(true);
				}
				Disjkstra d=new Disjkstra(ver,count);
				List<DijkLine> list=d.Dijkstra(begin,end);
				for(int z=0;z<list.size();z++) {//最大搜索时间为20次
					if(list.get(z).getY()==end) {
						String start=AddCity_PER.Getcity(list.get(z).getX());
						String endl=AddCity_PER.Getcity(list.get(z).getY());
						UserUse_UI.this.d.setVisible(false);
						frame.setVisible(false);
						new QuerLineWithTime(start,endl,list.get(z).getVal(),list.get(z).getLuCheng());
					}
				}
			}
		});
		//最省时间的出行
		b5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int[][] ver=FindLine_PER.GetCityTuTime();//获得以时间为权重的矩阵
				int i=FindLine_PER.GetCityNum();
				int[] count=new int[i];
				for(int j=0;j<i;j++) {
					count[j]=j;
				}
				//获得所选择的额值
				int begin,end;
				begin=AddCityLine_PER.FindCityNum(begincity.getSelectedItem().toString());
				end=AddCityLine_PER.FindCityNum(endcity.getSelectedItem().toString());
				if(begin==end) {
					d1.setVisible(true);
				}
				Disjkstra d=new Disjkstra(ver,count);
				List<DijkLine> list=d.Dijkstra(begin,end);
				for(int z=0;z<list.size();z++) {//最大搜索时间为20次
					if(list.get(z).getY()==end) {
						String start=AddCity_PER.Getcity(list.get(z).getX());
						String endl=AddCity_PER.Getcity(list.get(z).getY());
						UserUse_UI.this.d.setVisible(false);
						frame.setVisible(false);
						System.out.println(start+" "+endl+" "+list.get(z).getVal()+" "+list.get(z).getLuCheng()+" ");
						new QueryLine(start,endl,list.get(z).getVal(),list.get(z).getLuCheng());
					}
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("\u9000\u51FA\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Login_UI();
			}
		});
		button.setBounds(770, 429, 113, 35);
		panel.add(button);
		
		ImageIcon im=new ImageIcon("F:\\workspace\\Map\\3.jpg");
		JLabel picture = new JLabel(im);
		picture.setBounds(618, 44, 265, 284);
		panel.add(picture);
		
		JButton btnNewButton = new JButton("\u65F6\u523B\u8868");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new TimeTable_UI();
			}
		});
		btnNewButton.setBounds(618, 429, 113, 35);
		panel.add(btnNewButton);
		frame.setVisible(true);
	}
}
