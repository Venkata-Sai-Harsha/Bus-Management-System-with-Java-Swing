package staff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class updates{
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l12;
	JTextField l7,l8,l9,l10,l11;
	String pass,email,ph,name,blood,age,emaill,phe,namee,bloode,agee;
	JButton b;
     updates(String u){
    	 name = u;
    	 f = new JFrame();
    	 f.setSize(500,300);
    	 l1 = new JLabel("Details");
    	 l1.setBounds(200,10,50,30);
    	 l2 = new JLabel("Email Address:");
    	 l2.setBounds(30,50,90,30);
       	 l3 = new JLabel("Full Name:");
    	 l3.setBounds(30,80,70,30);
    	 l4 = new JLabel("Age:");
    	 l4.setBounds(30,110,50,30);
    	 l5 = new JLabel("Blood group:");
    	 l5.setBounds(30,140,80,30);
    	 l12 = new JLabel("phone:");
    	 l12.setBounds(30,170,120,30);
    	 l11 = new JTextField();
    	 l11.setBounds(120,170,200,30);
    	 
    	 l10 = new JTextField();
			l9 = new JTextField();
			l8 = new JTextField();
			l7 = new JTextField();
			 l7.setBounds(120,50,200,30);
			 
	    	 l10.setBounds(120,140,200,30);
	    	 l9.setBounds(120,110,200,30);
	    	 l8.setBounds(120,80,200,30);
 	     l6 = new JLabel();
    	 ActionListener ok = new ActionListener() {
    	 public void actionPerformed(ActionEvent e) {
        	 try {
    				Class.forName("org.postgresql.Driver");}
    			catch(ClassNotFoundException ch) {
    				System.out.println("class not found");
    			}
    			try {
    			Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
    			 Statement statement = con.createStatement();
    			 String sql = "select email from login where fullname = ?";
    			  PreparedStatement preparedstatement = con.prepareStatement(sql);
    			  preparedstatement.setString(1,u);
    			  ResultSet result = preparedstatement.executeQuery();
    			  while(result.next()) {
    				  email = result.getString("email");
    			  }
    			  emaill = l7.getText();
    			  namee = l8.getText();
    			  agee = l9.getText();
    			  bloode = l10.getText();
    			  phe = l11.getText();
    			  if(emaill.isEmpty()) {
    				  
    			  }
    			  else {
        		 String ql = "update login set email = ? where email = ?";
       		     PreparedStatement pre = con.prepareStatement(ql);
       		     pre.setString(1,emaill);
       		     pre.setString(2,email);
       		     int a = pre.executeUpdate();
       		     //System.out.print(email+pass);
                 }
    			  if(namee.isEmpty()) {
    				  
    			  }
    			  else
        	    	 {
        	    	 
        	    	 String ql = "update login set fullname = ? where email= ?";
           		     PreparedStatement pre = con.prepareStatement(ql);
           		     pre.setString(1,namee);
           		     pre.setString(2,email);
           		     int a = pre.executeUpdate();
           		     
           		  String eql = "update book set name = ? where name = ?";
        		     PreparedStatement prep= con.prepareStatement(eql);
        		     prep.setString(1,namee);
        		     prep.setString(2,u);
        		     int b = prep.executeUpdate();
        		     
        		     String seql = "update seat set name = ? where name = ?";
        		     PreparedStatement prepe= con.prepareStatement(seql);
        		     prepe.setString(1,namee);
        		     prepe.setString(2,u);
        		     int c = prepe.executeUpdate();
        	    	 }
    			 if(agee.isEmpty()) {
    				 
    			 }
    			 else{
        	    	
        	    	 String ql = "update login set age = ? where email = ?";
           		     PreparedStatement pre = con.prepareStatement(ql);
           		     pre.setString(1,agee);
           		     pre.setString(2,email);
           		     int a = pre.executeUpdate();
        	     }
    			 if(phe.isEmpty()) {
    				 
    			 }
    			 else{
        	    	
        	    	 String ql = "update login set phone = ? where email = ?";
           		     PreparedStatement pre = con.prepareStatement(ql);
           		     pre.setString(1,phe);
           		     pre.setString(2,email);
           		     int a = pre.executeUpdate();    	    	 
        	     }
    			 if(bloode.isEmpty()) {
    				 
    			 }
    			 else{
        	    	 
        	    	 String ql = "update login set blood_group = ? where email = ?";
           		     PreparedStatement pre = con.prepareStatement(ql);
           		     pre.setString(1,bloode);
           		     pre.setString(2,email);
           		     int a = pre.executeUpdate();
    			 }
    			 if(emaill.isEmpty()) {
    				 new home(email);
    			 }
    			 else {
    				 new home(emaill);
    			 }
        	    	 f.setVisible(false);
        	    	 con.close();
        	     }
    			catch(Exception ch) {
    				System.out.print(ch.getMessage());
    			}
         }};
    	 b = new JButton("ok");
    	 b.setBounds(200,210,50,30);
    	 b.addActionListener(ok);
    	    	 
    	 f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);
    	 f.add(l7);f.add(l8);f.add(l9);f.add(l10);
    	 f.add(l11);f.add(l12);f.add(b);f.add(l6);
    	 f.setVisible(true);
    	 f.setLayout(null);
    	 try {
				Class.forName("org.postgresql.Driver");}
			catch(ClassNotFoundException ch) {
				System.out.println("class not found");
			}
			try {
			Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
			  Statement statement = con.createStatement();
			  String sql = "select password from login where fullname = ?";
			  PreparedStatement preparedstatement = con.prepareStatement(sql);
			  preparedstatement.setString(1,u);
			  ResultSet result = preparedstatement.executeQuery();
			  while(result.next()) {
				  pass = result.getString("password");
			  }
			  
				  //System.out.print(email+name+ph+age+blood);
             }
			catch(Exception e) {
				System.out.print(e.getMessage());
			}
			
     }
     
}

