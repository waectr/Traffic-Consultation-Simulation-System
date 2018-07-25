package ui;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

import persistence.AddCity_PER;

import javax.swing.JButton;

public class AddCity_UI {

	private JFrame frame;
	private JTextField textField;
	private Dialog d1,d2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCity_UI window = new AddCity_UI();
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
	public AddCity_UI() {
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
		panel.setBackground(Color.ORANGE);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u4F60\u8981\u6DFB\u52A0\u7684\u57CE\u5E02");
		label.setFont(new Font("��������", Font.BOLD, 30));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton Button = new JButton("ȷ��");
		d1=new Dialog(frame,"�ɹ�",true);//�����Ի���
		d1.setBounds(400,500,300,130); //���öԻ���Ĵ�С��λ��
		d1.setLayout(new FlowLayout());//ʹ����ʽ���ֹ�����
		JLabel l1=new JLabel("--------��ӳɹ�--------");
		d1.add(l1);
		JButton b1=new JButton("���ع������");
		d1.add(b1);
		JButton b2=new JButton("�������");
		d1.add(b2);
		
		//��Ӵ��󵯿�
		d2=new Dialog(frame,"����",true);//�����Ի���
		d2.setBounds(400,500,300,130); //���öԻ���Ĵ�С��λ��
		d2.setLayout(new FlowLayout());//ʹ����ʽ���ֹ�����
		JLabel l2=new JLabel("--------��Ӵ���--------");
		d2.add(l2);
		JButton b3=new JButton("����");
		d2.add(b3);
		//��ӳ���ȷ�ϰ�ť
		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().isEmpty()) {
					int i=AddCity_PER.Addcity(textField.getText());
					if(i==1) {
						d1.setVisible(true);
					}else {
						d2.setVisible(true);
					}
				}else {
					d2.setVisible(true);
				}
			}
		});
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d2.setVisible(false);
				frame.setVisible(false);
				new AddCity_UI();
			}
		});
		//����
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				d1.setVisible(false);
				new GLYGuanLi();
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				d1.setVisible(false);
				new AddCity_UI();
			}
		});
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new GLYGuanLi();
			}
		});
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(188)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addGap(71)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(Button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(238, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(127)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(Button, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
					.addGap(71)
					.addComponent(button)
					.addContainerGap(100, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		frame.setVisible(true);
	}
}
