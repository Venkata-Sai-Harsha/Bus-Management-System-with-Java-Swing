package staff;
import javax.swing.*;

import java.sql.*;
import java.awt.event.*;
public class chart {
	JFrame f,f1;
	String email;
	JLabel l1,l2,l3;
	String da[],m[],y[];
	String date,daer,mony,yey,time;
	JComboBox cb4,cb5,cb6,cb;
	JLabel l4,l5,l6,l7,l8,l9;
	JLabel l14,l15,l16,l17;
	JButton b1,b2;
	int a;int j=0;
     chart(String fullname)
     {
    	 String t[] = {"8.00am","1.00pm","5.00pm","8.00pm","1.00am","6.00am"};
    	 f = new JFrame();
    	 l1 = new JLabel("date");
    	 l1.setBounds(30,60,40,30);
    	 f.add(l1);
    	 l2 = new JLabel("time");
    	 l2.setBounds(30,90,40,30);
    	 f.add(l2);
    	 l3 = new JLabel("Details");
    	 l3.setBounds(180,20,80,30);
    	 f.add(l3);
    	 f.setLayout(null);
    	 f.setVisible(true);
    	 f.setSize(400,250);
    	 da = new String[31];
   	  m = new String[12];
   	  y = new String[4];
   	  for(int i=1;i<=31;i++) {
   		  String bn = Integer.toString(i);
   		  da[i-1]=bn;
   	  }
   	  for(int i=1;i<=12;i++) {
   		  String bn = Integer.toString(i);
   		  m[i-1]=bn;
   	  }
   	  int hjo = 2020;
   	  for(int i=0;i<=3;i++) {
   		  String bn = Integer.toString(hjo);
   		  hjo++;
   		  y[i]= bn;
   	  }
   	ActionListener com = new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  time = cb.getItemAt(cb.getSelectedIndex()).toString();
			  
			  //System.out.print(time);
		  }
	  };
   	ActionListener datt= new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  daer = cb4.getItemAt(cb4.getSelectedIndex()).toString();
			  //System.out.print(time);
		  }
	  };
	  ActionListener mon= new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  mony = cb5.getItemAt(cb5.getSelectedIndex()).toString();
			  //System.out.print(time);
		  }
	  };
	  ActionListener year= new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  yey  = cb6.getItemAt(cb6.getSelectedIndex()).toString();
			  //System.out.print(time);
		  }
	  };
	  cb = new JComboBox(t);
	  cb.setBounds(80,90,200,30);
	  cb.addActionListener(com);
	  f.add(cb);
    	 cb4 = new JComboBox(da);
   	  cb4.addActionListener(datt);
   	  cb4.setBounds(80,60,60,30);
         
   	  cb5 = new JComboBox(m);
   	  cb5.addActionListener(mon);
   	 // cb5.setBounds(160,120,30,30);
   	  cb5.setBounds(140,60,60,30);
   	  cb6 = new JComboBox(y);
   	  cb6.addActionListener(year);
   	  cb6.setBounds(200,60,80,30);
   	  f.add(cb4);f.add(cb5);f.add(cb6);
   	  b1 = new JButton("ok");
   	  b1.setBounds(140,140,60,30);
   	  f.add(b1);
    	 try {
				Class.forName("org.postgresql.Driver");}
			catch(ClassNotFoundException ch) {
				System.out.println("class not found");
			}
			try {
			Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
			 Statement statement = con.createStatement();
			 String sql = "select * from bus where driver =? or conduct =?";
			  PreparedStatement preparedstatement = con.prepareStatement(sql);
			  preparedstatement.setString(1,fullname);
			  preparedstatement.setString(2,fullname);
			  ResultSet result = preparedstatement.executeQuery();
			  while(result.next()) {
				   a = result.getInt("bid");
			  }
  
              }
			catch(Exception e) {
				
			}
			try {
				Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
				 Statement statement = con.createStatement();
				 String sql = "select * from login where fullname =?";
				  PreparedStatement preparedstatement = con.prepareStatement(sql);
				  preparedstatement.setString(1,fullname);
				  ResultSet result = preparedstatement.executeQuery();
				  while(result.next()) {
					  email = result.getString("email");
				  }
	  
	              }
				catch(Exception e) {
					
				}
			ActionListener home = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new home(email);
				}
			};
	  ActionListener chart = new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  j =0;
			  f1 = new JFrame();
			  f1.setVisible(true);
			  f1.setLayout(null);
			  f1.setSize(500,500);
			  f.setVisible(false);
			  l4 = new JLabel("date");
			  l4.setBounds(30,90,80,30);
			  l5 = new JLabel("time");
			  l5.setBounds(30,120,80,30);
			  l6 = new JLabel("bus_id");
			  l6.setBounds(30,60,80,30);
			  f1.add(l4);f1.add(l5);f1.add(l6);
			  
			  l7 = new JLabel();
			  l7.setBounds(80,90,80,30);
			  l8 = new JLabel();
			  l8.setBounds(80,120,80,30);
			  l9 = new JLabel();
			  l9.setBounds(80,60,80,30);
			  f1.add(l7);f1.add(l8);f1.add(l9);
			  
			  l14 = new JLabel("Passenger");
			  l14.setBounds(30,150,80,30);
			  l15 = new JLabel("Age");
			  l15.setBounds(160,150,80,30);
			  l16 = new JLabel("Seats");
			  l16.setBounds(270,150,80,30);
			  f1.add(l14);f1.add(l15);f1.add(l16);
			  
			  l17 = new JLabel("CHARTS");
			  l17.setBounds(200,20,80,30);
			 b2 = new JButton("ok");
			  
			  f1.add(b2);
			  f1.add(l17);
			  date = daer+"-"+mony+"-"+yey;
			  try {
					Class.forName("org.postgresql.Driver");}
				catch(ClassNotFoundException ch) {
					System.out.println("class not found");
				}
				try {
				Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
				 Statement statement = con.createStatement();
				 String sql = "select * from bus where driver =? or conduct =?";
				  PreparedStatement preparedstatement = con.prepareStatement(sql);
				  preparedstatement.setString(1,fullname);
				  preparedstatement.setString(2,fullname);
				  ResultSet result = preparedstatement.executeQuery();
				  while(result.next()) {
					   a = result.getInt("bid");
					   String yui = Integer.toString(a);
					   l9.setText(yui);
				  }
				  System.out.print(a+" "+date+" "+time);
				  l7.setText(date);
				  l8.setText(time);
	              }
				catch(Exception che) {
					System.out.print(che.getMessage());
				}
				DefaultListModel<String>li1 = new DefaultListModel<>();
	    	  	DefaultListModel<String>li2 = new DefaultListModel<>();
	    	  	DefaultListModel<String>li3 = new DefaultListModel<>();
	    	  	try {
					Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
					 Statement statement = con.createStatement();
					 String sql = "select * from book inner join seat on seat.pnr = book.pnr where book.date =? and book.time =? and book.bus=? order by seat.seats";
					  PreparedStatement preparedstatement = con.prepareStatement(sql);
					  preparedstatement.setString(1,date);
					  preparedstatement.setString(2,time);
					  preparedstatement.setInt(3,a);
					  ResultSet result = preparedstatement.executeQuery();
					  while(result.next()) {
						   String pass = result.getString("pass_name");
						   String age = result.getString("age");
						   String seat = result.getString("seats");
						   li1.addElement(pass);
						   li2.addElement(age);
						   li3.addElement(seat);
						   j++;
					  }
		  
		              }
					catch(Exception che) {
						System.out.print(che.getMessage());
					}
	    	  	 JList<String>list1 = new JList<>(li1);
	   		  list1.setBounds(30,180,100,j*20);
	   		  
	   		  JList<String>list2 = new JList<>(li2);
	   		  list2.setBounds(160,180,60,j*20);
	   		  
	   		  JList<String>list3 = new JList<>(li3);
	   		  list3.setBounds(270,180,60,j*20);
	   		  f1.add(list1);f1.add(list2);f1.add(list3);
	   		b2.setBounds(200,210+j*20,80,30);
	   		b2.addActionListener(home);
		  }
	  };
	  b1.addActionListener(chart);
     }
     public static void main(String[] args) {
    	 new chart("sohan");
     }
}
