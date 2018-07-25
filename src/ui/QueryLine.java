package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import persistence.AddCityLine_PER;
import persistence.AddCity_PER;

import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class QueryLine {

	private JFrame frame;
	private String start;
	private String end;
	private int val;
	private Stack<Integer> Lucheng;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryLine window = new QueryLine(null,null,0,null);
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
	public QueryLine(String start,String end,int val,Stack<Integer> Lucheng) {
		this.end=end;
		this.Lucheng=Lucheng;
		this.val=val;
		this.start=start;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 849, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u5DF2\u4E3A\u60A8\u89C4\u5212\u6700\u7701\u94B1\u7684\u8DEF\u7EBF");
		label.setFont(new Font("方正舒体", Font.BOLD, 30));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.info);
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		
		//获得城市信息
		String s="";
		while(!Lucheng.isEmpty()) {
			int count=Lucheng.pop();
			String name=AddCity_PER.Getcity(count);
			s=s+name+" ";
			if(count==AddCityLine_PER.FindCityNum(end)) {
				break;
			}
			s=s+"-> ";
		}
		JLabel label_1 = new JLabel("\u8DEF\u7EBF\u4E3A:");
		label_1.setFont(new Font("方正舒体", Font.BOLD, 20));
		
		JTextArea Luxian = new JTextArea();
		Luxian.setFont(new Font("方正舒体", Font.BOLD, 23));
		Luxian.setForeground(new Color(0, 0, 0));
		Luxian.setBackground(new Color(124, 252, 0));
		Luxian.setText(s);
		
		JButton button = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u9875");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new UserUse_UI();
			}
		});
		button.setFont(new Font("方正舒体", Font.BOLD, 12));
		
		JButton button_1 = new JButton("\u6781\u901F\u4E86\u89E3");
		button_1.setFont(new Font("方正舒体", Font.BOLD, 12));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new UserUse_UI();
			}
		});
		
		JLabel label_2 = new JLabel("\u70B9\u51FB\u6765\u4E86\u89E3\u6CBF\u9014\u57CE\u5E02");
		label_2.setFont(new Font("方正舒体", Font.BOLD, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setText(start);
		
		JLabel label_3 = new JLabel("->");
		label_3.setFont(new Font("宋体", Font.BOLD, 12));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setText(end);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setText(val+"");
		
		JLabel label_4 = new JLabel("\u5168\u7A0B\u603B\u8D39\u7528\u4E3A");
		
		JLabel lblRmb = new JLabel("RMB");
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(537, Short.MAX_VALUE)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addGap(123))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(78)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addComponent(Luxian, GroupLayout.PREFERRED_SIZE, 489, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblRmb, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(112, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(84)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(lblRmb))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(Luxian, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
					.addComponent(label_2)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(49))
		);
		panel_1.setLayout(gl_panel_1);
		frame.setVisible(true);
	}
}
