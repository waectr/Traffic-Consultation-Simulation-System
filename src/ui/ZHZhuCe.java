package ui;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import persistence.ZHZhuCe_PER;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
/*
 * ʵ��ע�Ṧ��
 * �û���������6��15λ
 * ����������8-15λ
 */
public class ZHZhuCe {

	private JFrame frame;
	private JTextField zhanghao;
	private JTextField mima;
	private JTextField mima2;
	private JTextField phonenum;
	private Dialog d;
	private Dialog d1;//���û����������ʽ����ʱ
	private Dialog d2;//���ֻ��Ÿ�ʽ����ʱ
	private Dialog d3;//��ע��ɹ�ʱ����
	private Dialog d4;//��ע�����ظ�ʱ
	private Dialog d5;//��ע��ʧ��ʱ
	private String yzm;
	private JTextField yzm1;
	private int y;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZHZhuCe window = new ZHZhuCe();
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
	public ZHZhuCe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//������֤��
		Random r=new Random();
		y=r.nextInt(9999-1000+1)+1000;//���������λ��
		yzm="������������֤��:"+y+"";
		d=new Dialog(frame,"��������֤��",true);//�����Ի���
		d.setBounds(400,500,300,130); //���öԻ���Ĵ�С��λ��
		d.setLayout(new FlowLayout());//ʹ����ʽ���ֹ�����
		JLabel l=new JLabel(yzm);
		yzm1=new JTextField(20);
		JButton q=new JButton("ȷ��");
		d.add(l);
		d.add(yzm1);
		d.add(q);
		
		//�����û������������ʾ��
		d1=new Dialog(frame,"����",true);//�����Ի���
		d1.setBounds(400,500,400,130); //���öԻ���Ĵ�С��λ��
		d1.setLayout(new FlowLayout());//ʹ����ʽ���ֹ�����
		JLabel l1=new JLabel("��������ȷ��ʽ���û��������룬 �û���������6��15λ������������8-15λ");
		d1.add(l1);
		JButton b=new JButton("��֪����");
		d1.add(b);
		//����˳�������ʾ�����Ӧ
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d1.setVisible(false);
			}
		});
		
		//����ֻ��Ŵ�����ʾ��
		d2=new Dialog(frame,"����",true);//�����Ի���
		d2.setBounds(400,500,400,130); //���öԻ���Ĵ�С��λ��
		d2.setLayout(new FlowLayout());//ʹ����ʽ���ֹ�����
		JLabel l2=new JLabel("��������ȷ��ʽ���ֻ��ţ�11λ�����ֻ��Ž������һ�����");
		d2.add(l2);
		JButton b2=new JButton("��֪����");
		d2.add(b2);
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d2.setVisible(false);
			}
		});
		
		//ע��ɹ�����ʾ��
		d3=new Dialog(frame,"�ɹ�",true);//�����Ի���
		d3.setBounds(400,500,400,130); //���öԻ���Ĵ�С��λ��
		d3.setLayout(new FlowLayout());//ʹ����ʽ���ֹ�����
		JLabel l3=new JLabel("ע��ɹ�����ȥ��¼��");
		d3.add(l3);
		JButton b3=new JButton("��֪����");
		d3.add(b3);
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				d3.setVisible(false);
				new Login_UI();
			}
		});
		
		//��ע���û����ظ�ʱ
		d4=new Dialog(frame,"����",true);//�����Ի���
		d4.setBounds(400,500,400,130); //���öԻ���Ĵ�С��λ��
		d4.setLayout(new FlowLayout());//ʹ����ʽ���ֹ�����
		JLabel l4=new JLabel("�û����ظ��ˣ���һ����");
		d4.add(l4);
		JButton b4=new JButton("��֪����");
		d4.add(b4);
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d4.setVisible(false);
				frame.setVisible(false);
				new ZHZhuCe();
			}
		});
		
		//��ע��ʧ��ʱ
		d5=new Dialog(frame,"����",true);//�����Ի���
		d5.setBounds(400,500,400,130); //���öԻ���Ĵ�С��λ��
		d5.setLayout(new FlowLayout());//ʹ����ʽ���ֹ�����
		JLabel l5=new JLabel("ע��ʧ���ˣ��������԰�");
		d5.add(l5);
		JButton b5=new JButton("��֪����");
		d5.add(b5);
		b5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d5.setVisible(false);
				new ZHZhuCe();
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u8D26\u53F7\u6CE8\u518C");
		label.setFont(new Font("��������", Font.BOLD, 30));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		
		JLabel label_1 = new JLabel("\u8D26\u53F7");
		label_1.setFont(new Font("����", Font.BOLD, 20));
		
		JLabel label_2 = new JLabel("\u5BC6\u7801");
		label_2.setFont(new Font("����", Font.BOLD, 20));
		
		JLabel label_3 = new JLabel("\u91CD\u590D\u5BC6\u7801");
		label_3.setFont(new Font("����", Font.BOLD, 18));
		
		JLabel label_4 = new JLabel("\u624B\u673A\u53F7");
		label_4.setFont(new Font("����", Font.BOLD, 20));
		
		zhanghao = new JTextField();
		zhanghao.setColumns(10);
		
		mima = new JTextField();
		mima.setColumns(10);
		
		mima2 = new JTextField();
		mima2.setColumns(10);
		
		phonenum = new JTextField();
		phonenum.setColumns(10);
		
		JButton button = new JButton("\u786E\u8BA4");
		
		//ע��ȷ�ϰ�ť
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(zhanghao.getText().length()>15||zhanghao.getText().length()<6||mima.getText().length()<8||mima.getText().length()>15||!mima.getText().equals(mima2.getText())) { //�����˺Ÿ�ʽ�������
					d1.setVisible(true);
				}else if(phonenum.getText().length()!=11){//�ֻ��Ÿ�ʽ���
					d2.setVisible(true);                     
				}else {
					d.setVisible(true);//������֤��
				}
			}
		});
		
		//��֤�뵯���е�ȷ��
		q.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i=0;
				if(yzm1.getText().equals(y+"")) {
					d.setVisible(false);
					if(ZHZhuCe_PER.Check(zhanghao.getText())==1) {
						i=ZHZhuCe_PER.Add(zhanghao.getText(),mima.getText(), phonenum.getText());//ֱ�ӽ���Ϣ����洢�ĺ�����
					}else {
						d4.setVisible(true);
					}
					
					if(i==1) {   //���ע��ɹ�������ʾ
						d3.setVisible(true);
					}else {
						d5.setVisible(true);
					}
				}
			}
		});
		
		JLabel label_5 = new JLabel("\u7528\u4E8E\u627E\u56DE\u5BC6\u7801");
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Login_UI();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(165)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(mima)
								.addComponent(zhanghao, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(150)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(label_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(phonenum, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
								.addComponent(mima2))))
					.addGap(28)
					.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(193, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(165, Short.MAX_VALUE)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(69)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(308))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(52)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(zhanghao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(mima, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(mima2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(phonenum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5))
					.addGap(37)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(135, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		frame.setVisible(true);
	}

}
