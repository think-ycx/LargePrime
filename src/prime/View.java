package prime;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View {
	JFrame frame; 
	JPanel panel1,panel2,panel3 ;//三个panel用来作为容器
	JButton bt1;//三个监听按钮
	JButton bt2;
	JButton bt3;
	JTextArea area1,area2,area3;
	JLabel label1,copyright;
	JTextField field;

	
	public View(){
		frame = new JFrame();
		panel1 = new JPanel();
		panel2 =  new JPanel();
		panel3 = new JPanel();

		frame.setLayout(null);
		frame.setBounds(200,200,900,600);
		frame.setTitle("素数判定与生成");
		frame.setResizable(false);
			
		
		panel1.setBounds(0,0, 300, 600);
		panel1.setLayout(null);
		panel1.setBackground(new Color(204,200,255));
		setcontent1();
		frame.add(panel1);
		
		panel2.setBounds(300,0, 300, 600);
		panel2.setLayout(null);
		panel2.setBackground(new Color(204,200,200));
		setcontent2();
		frame.add(panel2);
		
		panel3.setBounds(600,0, 300, 600);
		panel3.setLayout(null);
		setcontent3();
		frame.add(panel3);
		
		frame.setVisible(true);
		
	}
	
//三个setcontent成员变量

private void setcontent3() {
	bt3 = new JButton();
	bt3.setText("验证10000以内哥德巴赫猜想");
	bt3.setBounds(0, 0, 300, 50);
	panel3.add(bt3);
	
	area3 = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(area3,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	scrollPane.setBounds(0, 100, 280, 400);
	area3.setBounds(0,100,300,400);
	panel3.add(scrollPane);
	
	copyright =  new JLabel();
	copyright.setText(" Copyright©2015 Think_ycx All Rights Reserved");
	copyright.setBounds(0, 500, 300, 100);
	panel3.add(copyright);
	//panel3.add(area3);
	
	}



private void setcontent2() {
	bt2 = new JButton();
	bt2.setText("判定是否是素数");
	bt2.setBounds(0, 0, 300, 50);
	panel2.add(bt2);
	
	area2 = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(area2,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	area2.setLineWrap(true);
	scrollPane.setBounds(0,100,300,400);
	panel2.add(scrollPane);
		
	}

private void setcontent1() {
	bt1 = new JButton();
	bt1.setText("生成一个大素数");
	bt1.setBounds(0, 0, 300, 50);
	panel1.add(bt1);
	
	label1 = new  JLabel("长度:");
	label1.setBounds(0, 50, 50, 50);
	panel1.add(label1);

	field = new JTextField();
	field.setBounds(50, 50, 250, 50);
	panel1.add(field);
	
	area1 = new JTextArea();
	area1.setLineWrap(true);
	area1.setBounds(0,100,300,400);
	panel1.add(area1);

}

	public static void main(String[] args) {
		View v = new View();
		v.bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Prime ob = new Prime();//prime对象调用素数生成算法
				
				
				try {
					ob.numDigits=Integer.parseInt(v.field.getText());
					if (ob.numDigits<=0) {
						throw new NumberFormatException();
					}
					
				} catch (NumberFormatException e) {
					// TODO: handle exception
					v.field.setText("请输入一个正整数");
				}
	
				ob.generate();
				
				v.area1.setText(""+ob.results.toString());
				//System.out.println();
				
			}
		});
		
		v.bt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RabinMiller ob = new RabinMiller();
				try {
					
					BigInteger temp=new BigInteger(v.area2.getText());				
					if (temp.compareTo(BigInteger.ZERO)<=0){
						throw new NumberFormatException();
					}

				} catch (NumberFormatException e2) {//输入验证
					v.area2.setText("请输入一个正整数");
				}
					BigInteger temp=new BigInteger(v.area2.getText());
					if(ob.IsPrime(temp)) 
						v.area2.append("->是素数");
					else 
						v.area2.append("->不是素数");
	
			}
		});
		
		v.bt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Goldbach ob = new Goldbach();
				ob.generatePrimes();
				ob.verify();
				for (int i =0;i<ob.results.size();i++)//显示结果
				{
					v.area3.append(ob.results.get(i).toString());	
				}
			}
		});

	}
}


