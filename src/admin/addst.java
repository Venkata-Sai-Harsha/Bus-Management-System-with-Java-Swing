package admin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class addst {
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5,t7;
	JButton b;
     addst(String u){
    	 f = new JFrame();
    	 l6 = new JLabel("ADD");
    	 l6.setBounds(200,10,80,30);
    	 l1 = new JLabel("Email");
    	 l1.setBounds(30,30,80,30);
    	 l2= new JLabel("Fullname");
    	 l2.setBounds(30,60,80,30);
    	 l3 = new JLabel("Password");
    	 l3.setBounds(30,90,80,30);
    	 l4 = new JLabel("Phone");
    	 l4.setBounds(30,120,80,30);
    	 l5 = new JLabel("salary");
    	 l5.setBounds(30,150,80,30);
    	 l7= new JLabel("Type");
    	 l7.setBounds(30,180,80,30);
    	 f.add(l7);
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
    	 t7.setBounds(120,180,200,30);
    	 f.add(t7);
    	 JTextField t6 = new JTextField();
    	 ActionListener ok = new ActionListener() {
    		 public void actionPerformed(ActionEvent e) {
    			String email = t1.getText();
    			String fullname = t2.getText();
    			String password = t3.getText();
    			String phone = t4.getText();
    			String salary = t5.getText();
    			int sa = Integer.parseInt(salary);
    			String type = t7.getText();
    			System.out.println(email+" "+fullname+" "+password+" "+phone+" "+salary+" "+type);
    			 try {
     				Class.forName("org.postgresql.Driver");}
     			catch(ClassNotFoundException ch) {
     				System.out.println("class not found");
     			}
     			try {
     			Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
     			 Statement statement = con.createStatement();
     			 String sql = "insert into login(email,fullname,password,phone,salary,type) values(?,?,?,?,?,?)";
     			  PreparedStatement preparedstatement = con.prepareStatement(sql);
     			  preparedstatement.setString(1,email);
     			 preparedstatement.setString(2,fullname);
     			preparedstatement.setString(3,password);
     			preparedstatement.setString(4,phone);
     			preparedstatement.setInt(5,sa);
     			preparedstatement.setString(6,type);
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
    	 b.setBounds(150,240,80,30);
    	 f.add(t1);f.add(t2);f.add(t3);f.add(t4);f.add(t5);f.add(t6);
    	 f.setVisible(true);
    	 f.setLayout(null);
    	 f.setSize(400,400);
     }
     public static void main(String[] args) {
    	 new addst("nag1978@gmail.com");
     }
}
