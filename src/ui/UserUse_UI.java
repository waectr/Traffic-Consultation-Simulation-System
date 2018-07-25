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
	private Dialog d;//��ʾ�û�Ҫѡ�����Ϣ
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
		label.setFont(new Font("��������", Font.BOLD, 30));
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
		label_2.setFont(new Font("��������", Font.BOLD, 20));
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
		b1.setFont(new Font("��������", Font.BOLD, 20));
		b1.setBounds(455, 137, 104, 30);
		panel.add(b1);
		
		JButton b2 = new JButton("\u7545\u6E38\u534E\u590F");
		
		//���λ��ĵİ�ť
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new ShowChina_UI();
			}
		});
		b2.setFont(new Font("��������", Font.BOLD, 24));
		b2.setBounds(670, 349, 165, 65);
		panel.add(b2);
		
		//������Ϣ
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
		String[] top= {"���","�ն�","����(KM)","����","��ʼ","����","����(RMB)","ʱ��(min)"};
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 210, 620, 254);
		panel.add(scrollPane);
		
		table = new JTable(data,top);
		table.setBackground(SystemColor.window);
		table.setFont(new Font("����", Font.BOLD, 9));
		
		d=new Dialog(frame,"��������֤��",true);//�����Ի���
		d.setBounds(400,500,300,130); //���öԻ���Ĵ�С��λ��
		d.setLayout(new FlowLayout());//ʹ����ʽ���ֹ�����
		JLabel l=new JLabel("----------��ѡ����Ҫ��ѯ�ķ�ʽ-----------");
		d.add(l);
		JButton b4=new JButton("��ʡǮ��·��");
		d.add(b4);
		JButton b5=new JButton("��ʡʱ���·��");
		d.add(b5);
		
		//�����ظ�
		d1=new Dialog(frame,"����",true);//�����Ի���
		d1.setBounds(400,500,300,130); //���öԻ���Ĵ�С��λ��
		d1.setLayout(new FlowLayout());//ʹ����ʽ���ֹ�����
		JLabel l1=new JLabel("���ܲ�ѯ��ͬ�ĳ���");
		d1.add(l1);
		JButton b6=new JButton("����");
		d1.add(b6);
		b6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d.setVisible(false);
				d1.setVisible(false);
			}
		});
		
		d2=new Dialog(frame,"����",true);//�����Ի���
		d2.setBounds(400,500,300,130); //���öԻ���Ĵ�С��λ��
		d2.setLayout(new FlowLayout());//ʹ����ʽ���ֹ�����
		JLabel l2=new JLabel("δ�鵽�����·����Ϣ");
		d2.add(l2);
		JButton b7=new JButton("����");
		d2.add(b7);
		b7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				d2.setVisible(false);
			}
		});
		
		//��ʡǮ�ĳ���
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				
				int[][] ver=FindLine_PER.GetCityTuMon();//�����ǮΪȨ�صľ���
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
				for(int z=0;z<list.size();z++) {//�������ʱ��Ϊ20��
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
		//��ʡʱ��ĳ���
		b5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int[][] ver=FindLine_PER.GetCityTuTime();//�����ʱ��ΪȨ�صľ���
				int i=FindLine_PER.GetCityNum();
				int[] count=new int[i];
				for(int j=0;j<i;j++) {
					count[j]=j;
				}
				//�����ѡ��Ķ�ֵ
				int begin,end;
				begin=AddCityLine_PER.FindCityNum(begincity.getSelectedItem().toString());
				end=AddCityLine_PER.FindCityNum(endcity.getSelectedItem().toString());
				if(begin==end) {
					d1.setVisible(true);
				}
				Disjkstra d=new Disjkstra(ver,count);
				List<DijkLine> list=d.Dijkstra(begin,end);
				for(int z=0;z<list.size();z++) {//�������ʱ��Ϊ20��
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
