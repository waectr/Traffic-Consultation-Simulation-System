package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

import persistence.AddCityLine_PER;
import persistence.AddCity_PER;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QuerLineWithTime {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private String start;
	private String end;
	private int val;
	private Stack<Integer> Lucheng;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuerLineWithTime window = new QuerLineWithTime(null,null,0,null);
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
	public QuerLineWithTime(String start,String end,int val,Stack<Integer> Lucheng) {
		this.start=start;
		this.end=end;
		this.Lucheng=Lucheng;
		this.val=val;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 886, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(138, 43, 226));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		//获得城市信息
		String s="";
		while(!Lucheng.isEmpty()) {
			int count=Lucheng.pop();
			String name=AddCity_PER.Getcity(count);
			s=s+name+" ";
			if(count==AddCityLine_PER.FindCityNum(end)) {
				break;
			}
			s=s+"->";
		}
		JLabel label = new JLabel("\u5DF2\u4E3A\u60A8\u89C4\u5212\u6700\u7701\u65F6\u95F4\u7684\u51FA\u884C\u8DEF\u7EBF");
		label.setForeground(new Color(255, 255, 0));
		label.setFont(new Font("方正舒体", Font.BOLD, 30));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new UserUse_UI();
			}
		});
		
		
		JButton button_1 = new JButton("\u6781\u901F\u4F53\u9A8C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new UserUse_UI();
			}
		});
		
		JLabel label_1 = new JLabel("\u8DEF\u7EBF\u4E3A");
		label_1.setFont(new Font("方正舒体", Font.BOLD, 20));
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(175, 238, 238));
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setText(s);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setText(start);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setText(end);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setText(val+" ");
		JLabel label_2 = new JLabel("\u603B\u65F6\u95F4");
		
		JLabel label_3 = new JLabel("\u5230");
		
		JLabel label_4 = new JLabel("\u4E86\u89E3\u6CBF\u9014\u57CE\u5E02\u7684\u98CE\u5149\u5427");
		
		ImageIcon im=new ImageIcon("F:\\workspace\\Map\\12.jpg");
		
		JLabel lblNewLabel = new JLabel(im);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(140)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(55)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(10)
										.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
										.addComponent(label_2)
										.addGap(18)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap(553, Short.MAX_VALUE)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addGap(93))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(81)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
							.addComponent(label_4))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(59))
		);
		panel_1.setLayout(gl_panel_1);
		frame.setVisible(true);
	}
}
