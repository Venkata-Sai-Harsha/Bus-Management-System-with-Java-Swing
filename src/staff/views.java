package staff;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class views implements ActionListener{

JFrame f;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
String email,name,ph,age="NA",blood="NA";
JButton b;
views(String u){
	 f = new JFrame();
	 f.setSize(500,400);
	 l1 = new JLabel("Details");
	 l1.setBounds(200,10,50,30);
	 l2 = new JLabel("Email Address:");
	 l2.setBounds(30,50,90,30);
	 l7 = new JLabel();
	 l3 = new JLabel("Full Name:");
	 l3.setBounds(30,80,70,30);
	 l8 = new JLabel();
	 l4 = new JLabel("Age:");
	 l4.setBounds(30,110,50,30);
	 l9 = new JLabel();
	 l5 = new JLabel("Blood group:");
	 l5.setBounds(30,140,80,30);
	 l12 = new JLabel("Phone:");
	 l12.setBounds(30,170,80,30);
	 l13 = new JLabel("salary");
	 l13.setBounds(30,200,80,30);
	 f.add(l13);
	 l14 = new JLabel();
	 l14.setBounds(120,200,80,30);
	 f.add(l14);
	 l11 = new JLabel();
	 l11.setBounds(120,170,80,30);
	 l10 = new JLabel();
	 l8.setBounds(120,80,200,30);
	 l9.setBounds(120,110,50,30);
	 l7.setBounds(120,50,200,30);
	 l10.setBounds(120,140,80,30);
	 b = new JButton("ok");
	 b.setBounds(200,240,50,30);
	 b.addActionListener(this);
	 b.setActionCommand("ok");
	 l6 = new JLabel();
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
		  String sql = "select *  from login where fullname = ?";
		  PreparedStatement preparedstatement = con.prepareStatement(sql);
		  preparedstatement.setString(1,u);
		  ResultSet result = preparedstatement.executeQuery();
		  while(result.next()) {
			  email = result.getString("email");
			  name = result.getString("fullname");
			  ph = result.getString("phone");
			  age = result.getString("age");
			  ph = result.getString("phone");
			  int sal = result.getInt("salary");
			  String sall = Integer.toString(sal);
			  l14.setText(sall);
			  if(age==null) {
				  age = "NA";
			  }
			  blood = result.getString("blood_group");
			  if(blood==null) {
				  blood ="NA";
			  }
			  //System.out.print(email+name+ph+age+blood);
		  }
		  con.close();
      }
		catch(Exception e) {
			System.out.print(e.getMessage());
		}
		l7.setText(email);
		l8.setText(name);
		l9.setText(age);
		l10.setText(blood);
		l11.setText(ph);
}
public void actionPerformed(ActionEvent e) {
	 if(e.getActionCommand()=="ok") {
		 f.setVisible(false);
		 new home(email);
		 
	 }
}
}

