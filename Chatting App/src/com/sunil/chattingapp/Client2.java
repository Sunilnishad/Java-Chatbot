package com.sunil.chattingapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Client2 extends JFrame implements ActionListener{
	
	JPanel p1;
	JTextField t0;
	JButton b0;
	static JTextArea a1;
	
	
	static ServerSocket skt;
	static Socket s;
	
	static DataInputStream din;
	static DataOutputStream dout;
	
	Client2(){
		
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(7,94,84));
		p1.setBounds(0,0,450,70);
		add(p1);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/sunil/chattingapp/icons/3.png"));
		Image img = i1.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(img);
		
		JLabel l1 = new JLabel(i3);
		l1.setBounds(5,17,30,30);
		p1.add(l1);
		
		l1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent me) {
				System.exit(0);
			}
		});
		
		ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("com/sunil/chattingapp/icons/2.png"));
		Image  img2 = i2.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		ImageIcon i4 = new ImageIcon(img2);
		JLabel l2 = new JLabel(i4);
		l2.setBounds(40,5,60,60);
		p1.add(l2);
		
		JLabel l5 = new JLabel("Bunty");
		l5.setFont(new Font("Raleway",Font.BOLD,20));
		l5.setForeground(Color.white);
		l5.setBounds(110,15,100,20);
		p1.add(l5);
		
		JLabel l6 = new JLabel("Active Now");
		l6.setFont(new Font("Raleway",Font.BOLD,10));
		l6.setForeground(Color.white);
		l6.setBounds(115,45,100,15);
		p1.add(l6);
		
		ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("com/sunil/chattingapp/icons/video.png"));
		Image  img3 = i5.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(img3);
		JLabel l7 = new JLabel(i6);
		l7.setBounds(260,15,30,40);
		p1.add(l7);
		
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("com/sunil/chattingapp/icons/phone.png"));
		Image  img4 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i8 = new ImageIcon(img4);
		JLabel l8 = new JLabel(i8);
		l8.setBounds(330,15,30,40);
		p1.add(l8);
		
		ImageIcon i9 = new ImageIcon(ClassLoader.getSystemResource("com/sunil/chattingapp/icons/3icon.png"));
		Image  img5 = i9.getImage().getScaledInstance(15, 20, Image.SCALE_DEFAULT);
		ImageIcon i10 = new ImageIcon(img5);
		JLabel l9 = new JLabel(i10);
		l9.setBounds(400,25,15,20);
		p1.add(l9);
		
		a1 = new JTextArea();
		a1.setFont(new Font("Raleway",Font.BOLD,22));
		a1.setEditable(false);
		a1.setLineWrap(true);
		a1.setWrapStyleWord(true);
		a1.setBounds(5,75,440,470);
		add(a1);
		
		t0 = new JTextField();
		t0.setFont(new Font("Arial",Font.PLAIN,20));
		t0.setBounds(5,550,360,40);
		add(t0);
		
		b0 = new JButton("SEND");
		b0.setFont(new Font("Arial",Font.BOLD,10));
		b0.setBackground(new Color(7,94,84));
		b0.setForeground(Color.white);
		b0.setBounds(370,550,70,40);
		add(b0);
		
		b0.addActionListener(this);
		
		getContentPane().setBackground(Color.pink);
		setLayout(null);
		setUndecorated(true);  // Remove the close(x) interface in window
        setLocation(850,50);
		setSize(450,600);
		setVisible(true);
		
		
	}
	
	public static void main(String a[]) {
		
		new Client2().setVisible(true);
		
		
		
		try {
			 s  = new Socket("localhost",3333);
			 
			 din = new DataInputStream(s.getInputStream());
			 dout = new DataOutputStream(s.getOutputStream());
			 
			 String msgInput = "";
			 
			 msgInput = din.readUTF();
			 a1.setText(a1.getText()+ "\n"+ msgInput);
			 
			
			
		}catch(Exception e) {e.printStackTrace();}
	}

	public void actionPerformed(ActionEvent ae) {
		
		try {
		
		String text = t0.getText();
		a1.setText(a1.getText() + "\n\t\t" + text);
		
		t0.setText("");
		
		
		dout.writeUTF(text);
		dout.flush();
		
	
	
		}catch(Exception e){e.printStackTrace();}
		
	}

}


