package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.*;

public class addbu {
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5,t7;
	JButton b;
     addbu(String u){
    	 f = new JFrame();
    	 l6 = new JLabel("ADD");
    	 l6.setBounds(200,10,80,30);
    	 l1 = new JLabel("Bus_Id");
    	 l1.setBounds(30,30,80,30);
    	 l2= new JLabel("From");
    	 l2.setBounds(30,60,80,30);
    	 l3 = new JLabel("To");
    	 l3.setBounds(30,90,80,30);
    	 l4 = new JLabel("Driver");
    	 l4.setBounds(30,120,80,30);
    	 l5 = new JLabel("Conducter");
    	 l5.setBounds(30,150,80,30);
    	 f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);
    	 t1 = new JTextField();
    	 t1.setBounds(120,30,200,30);
    	 t2 = new JTextField();
    	 t2.setBounds(120,60,200,30);
    	 t3 = new JTextField();
    	 t3.setBounds(120,90,200,30);
    	 t4 = new JTextField();
    	 t4.setBounds(120,120,200,30);
    	 t5 = new JTextField();
    	 t5.setBounds(120,150,200,30);
    	 t7= new JTextField();
    	 JTextField t6 = new JTextField();
    	 ActionListener ok = new ActionListener() {
    		 public void actionPerformed(ActionEvent e) {
    			String bid = t1.getText();
    			int sa = Integer.parseInt(bid);
    			String start = t2.getText();
    			String  dest = t3.getText();
    			String driver = t4.getText();
    			String conduct = t5.getText();
    			
    			//System.out.println(email+" "+fullname+" "+password+" "+phone+" "+salary+" "+type);
    			 try {
     				Class.forName("org.postgresql.Driver");}
     			catch(ClassNotFoundException ch) {
     				System.out.println("class not found");
     			}
     			try {
     			Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
     			 Statement statement = con.createStatement();
     			 String sql = "insert into bus values(?,?,?,?,?)";
     			  PreparedStatement preparedstatement = con.prepareStatement(sql);
     			  preparedstatement.setString(1,start);
     			 preparedstatement.setString(2,dest);
     			preparedstatement.setInt(3,sa);
     			preparedstatement.setString(4,driver);
     			preparedstatement.setString(5,conduct);
     			  int q = preparedstatement.executeUpdate();
     			 System.out.println(q);
     			  JOptionPane.showMessageDialog(f,"ADDED","ALERT",JOptionPane.WARNING_MESSAGE);
     			  new homea(u);
    		 }
     			catch(Exception ce) {
     				System.out.println(ce.getMessage());
     			}
    		 }
    	 };
    	 b= new JButton("ok");
    	 b.addActionListener(ok);
    	 f.add(b);
    	 b.setBounds(150,190,80,30);
    	 f.add(t1);f.add(t2);f.add(t3);f.add(t4);f.add(t5);f.add(t6);
    	 f.setVisible(true);
    	 f.setLayout(null);
    	 f.setSize(400,400);
     }
     public static void main(String[] args) {
    	 new addbu("nag1978@gmail.com");
     }
}
