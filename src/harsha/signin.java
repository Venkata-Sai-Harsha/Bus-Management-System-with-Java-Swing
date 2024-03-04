package harsha;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class signin implements ActionListener{
	JFrame f1;
	JLabel l1;JTextField t1,t2;
	JLabel l2;
	JLabel l3;JPasswordField v ;
	JButton b1;JButton b2,b3;
	String email=" ",pass =" ";int y=0,rt=0;
	signin(){
	f1 = new JFrame("bus_management_system");
	l2 = new JLabel("Signin");
	l2.setBounds(200, 10,60, 30);
	l1 = new JLabel("Email Address:");
	l1.setBounds(50,50,100,30);
	
	 t1 = new JTextField();
	t1.setBounds(150,50,200,30);
	t2 = new JTextField();
	l3 = new JLabel("Password:");
	l3.setBounds(50,100,100,30);
	 v = new JPasswordField();
	v.setBounds(150,100,200,30);
	
	b1 = new JButton("LOGIN");
	b1.setBounds(200,150,80,30);
	b1.setActionCommand("next_login");
	b1.addActionListener(this);
	
	b2 = new JButton("REGISTER");
	b2.setBounds(190,190,100,30);
	b2.addActionListener(this);
	b2.setActionCommand("register");
	
	ActionListener show = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    String a = b3.getText();
		    String c = new String(v.getPassword());
		   JPasswordField p1 = new JPasswordField();
		    if(a.equals("show")){
		    	b3.setText("hide");
		    	
		    	t2.setText(c);
		    	t2.setBounds(150,100,200,30);
		    	f1.add(t2);
		    }
		    if(a.equals("hide")) {
		    	b3.setText("show");
		    	p1.setBounds(150,100,200,30);
		    	f1.add(p1);
		    	p1.setText(c);
		    	f1.remove(t2);
		    }
		}
	};
	b3 = new JButton("show");
	b3.setBounds(350,100,70,30);
	b3.addActionListener(show);
	f1.add(b3);
	f1.add(l1);f1.add(t1);f1.add(l2);
    f1.add(l3);f1.add(v);f1.add(b1);
    f1.add(b2);
    f1.setBounds(0,0,500,300);
    f1.setLayout(null);
    f1.setVisible(true);
	}
    public void actionPerformed(ActionEvent e) {
    	 if(e.getActionCommand()=="register") {
			 f1.setVisible(false);
			 new signup();
		 }
		 if(e.getActionCommand()=="next_login") {
			 try {
					Class.forName("org.postgresql.Driver");}
				catch(ClassNotFoundException ch) {
					System.out.println("class not found");
				}
			 email = t1.getText();
			 pass = new String(v.getPassword());
				try {
					
				if((email.isEmpty())&&(pass.isEmpty())){
					
					f1.setVisible(true);
					JOptionPane.showMessageDialog(f1,"Fill all details","Alert",JOptionPane.WARNING_MESSAGE);
				
				}
				else
				{
					Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","Sai@15442");
					  Statement statement = con.createStatement();
					  String sql = "select * from login";
					  ResultSet result = statement.executeQuery(sql);
					  int r=0;int p=0;
					  while(result.next()) {
						  
						  String u = result.getString("email");
						  String pa = result.getString("password");
						  if(u.equalsIgnoreCase(email)) {
							  r = 1;
						  }
						  if(pa.equalsIgnoreCase(pass)) {
							  p=1;
						  }
						  if((r==1)&&(p==1)) {
							  y=1;
							 
							  }
						  }
					  con.close();
					  }
						if((y==1)){
							
							JOptionPane.showMessageDialog(f1,"You are logined successfully");
							f1.setVisible(false);
							new homepage(email);
							
						}
						else {
							JOptionPane.showMessageDialog(f1,"Invalid Credentials","Alert",JOptionPane.WARNING_MESSAGE);
							f1.setVisible(true);
						
						}
						 
					  
				}
				catch(Exception gh) {
					System.out.println(gh.getMessage());
				}
		 }
    }
    public static void main(String[] args) {
    	new signin();
    }
   
}
    

