package admin;
import javax.swing.*;

import java.awt.*;
import java.awt.Color;
import java.awt.event.*; 
import java.sql.*;
public class signupa implements ActionListener{
	JFrame f2;JLabel l8;
	JLabel l9;JTextField t9,t2;
	JLabel l6;JTextField t6;
	JLabel l5;JTextField t5;
	JLabel l7;JPasswordField v1;
	JButton b3;JButton b4,b5;
	String user =" ",fn=" ",pass=" ",ph=" ";
	signupa(){
	    f2 = new JFrame();
	    f2.setBounds(0,0,500,400);
	    l8 = new JLabel("REGISTER");
	    l8.setBounds(200,10,100,30);
	    l9 = new JLabel("Email Address");
		l9.setBounds(50,50,100,30);
		
	     t9 = new JTextField();
		t9.setBounds(150,50,200,30);
		l6 = new JLabel("Full Name");
		l6.setBounds(50,100,100,30);
		 t6 = new JTextField();
		 t6.setBounds(150,100,200,30);
		 l7 = new JLabel ("Password");
		 l7.setBounds(50,150,100,30);
		 v1 = new JPasswordField ();
		 v1.setBounds(150,150,200,30);
		 l5 = new JLabel ("Phone number");
		 l5.setBounds(50,200,200,30);
		 t5 = new JTextField ();
		 t5.setBounds(150,200,200,30);
		 ActionListener show = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    String a = b5.getText();
				    String c = new String(v1.getPassword());
				   JPasswordField p1 = new JPasswordField();
				    if(a.equals("show")){
				    	b5.setText("hide");
				    	t2 = new JTextField();
				    	t2.setText(c);
				    	t2.setBounds(150,150,200,30);
				    	f2.add(t2);
				    }
				    if(a.equals("hide")) {
				    	b5.setText("show");
				    	p1.setBounds(150,150,200,30);
				    	f2.add(p1);
				    	p1.setText(c);
				    	f2.remove(t2);
				    }
				}
			};
	     b5 = new JButton("show");
	     b5.setBounds(350,150,70,30);
	 	b5.addActionListener(show);
	 	f2.add(b5);
		 b3 = new JButton ("REGISTER");
		 b3.setBounds(200,250,100,30);
		 b4 = new JButton ("LOGIN");
		 b4.setBounds(200,300,100,30);
		 f2.add(l9);f2.add(t9);f2.add(l8);
		 f2.add(t6);f2.add(l6);f2.add(v1);f2.add(l7);
		 f2.add(l5);f2.add(t5);
		 f2.add(b3);f2.add(b4);
		 
		 
		 b3.setActionCommand("next_register");
		 b3.addActionListener(this);
		 b4.setActionCommand("login");
		 b4.addActionListener(this);
		 f2.setLayout(null);
		 f2.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		 if(e.getActionCommand()=="login") {
			 f2.setVisible(false);
			 new signina();
		 }
		 if(e.getActionCommand()=="next_register") {
			 int usertt = 0,phert =0,namert =0;
			 f2.setVisible(false);
			 user = t9.getText();
			 fn = t6.getText();
			 ph = t5.getText();
			 try {
					Class.forName("org.postgresql.Driver");}
				catch(ClassNotFoundException ch) {
					System.out.println("class not found");
				}
			
				  pass = new String(v1.getPassword());
					try {
				   
					if((user.isEmpty())||(pass.isEmpty())||(fn.isEmpty())||(ph.isEmpty())){
						f2.setVisible(true);
						JOptionPane.showMessageDialog(f2,"Fill all details","Alert",JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
						  Statement statement = con.createStatement();
						  
						  String sql = "insert into login values(?,?,?,?)";
						  PreparedStatement preparedstatement = con.prepareStatement(sql);
							preparedstatement.setString(1,user);
							preparedstatement.setString(2,fn);
							preparedstatement.setString(3,pass);
							preparedstatement.setString(4,ph);
							int rowsaffected  = preparedstatement.executeUpdate();
							if(rowsaffected !=0) {
								new homea(user);
								JOptionPane.showMessageDialog(f2,"You are registered successfully");
							}
							 con.close();
						
					}
					}catch(Exception gh) {
						System.out.println(gh.getMessage());
					}
			 }
			 
	}
	 
     public static void main(String[] args) {
	new signupa();
}
}

