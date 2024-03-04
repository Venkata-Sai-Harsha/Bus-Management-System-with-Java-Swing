package harsha;
import javax.swing.*;
import java.sql.*;
import java.awt.Color;
import java.awt.event.*;
public class ticket {
	JFrame f,f1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JLabel l11,l12,l13,l14,l15,l16,l17,l18,l19,l20;
	JLabel l21,l22,l23,l24,l25;
	String nameee,email,passew,start,dest,date,time;
	int index;
	JButton b,b1;
	ticket(String book_id,String fullname,int w) {
		f = new JFrame();
		l25 = new JLabel();
		l1 = new JLabel("Ticket details:");
		l1.setBounds(200,0,80,30);
		l2 = new JLabel("Bus_id:");
		l2.setBounds(30,60,50,30);
		l3 = new JLabel("time:");
		l3.setBounds(300,60,50,30);
		l4 =new JLabel("date:");
		l4.setBounds(30,90,50,30);
		l5 = new JLabel("book_id:");
		l5.setBounds(300,90,50,30);
		l13 = new JLabel("Payment_id:");
		l13.setBounds(30,120,80,30);
		l14 = new JLabel("Payment Amount:");
		l14.setBounds(300,120,120,30);
		l15 = new JLabel("Booking Status:");
		l15.setBounds(30,150,120,30);
		l16 = new JLabel("Phone:");
		l16.setBounds(300,150,80,30);
		
		l17 = new JLabel("");
		l17.setBounds(100,120,60,30);
		l18 = new JLabel("");
		l18.setBounds(400,120,80,30);
		l19 = new JLabel("");
		l19.setBounds(120,150,60,30);
		l20 = new JLabel("");
		l20.setBounds(350,150,80,30);
		
		l21 = new JLabel("From:");
		l21.setBounds(30,30,80,30);
		l22 = new JLabel();
		l22.setBounds(80,30,80,30);
		l23 = new JLabel("To:");
		l23.setBounds(300,30,80,30);
		l24 = new JLabel();
		l24.setBounds(330,30,80,30);
		f.add(l21);f.add(l22);f.add(l23);f.add(l24);
		
		
		l6 = new JLabel("");
		l6.setBounds(80,60,60,30);
		l7 = new JLabel("");
		l7.setBounds(340,60,80,30);
		l8 = new JLabel("");
		l8.setBounds(60,90,80,30);
		l9 =new JLabel("");
		l9.setBounds(360,90,80,30);
		l10 = new JLabel("Passenger_Name");
		l10.setBounds(30,210,200,30);
		l11 = new JLabel("Age");
		l11.setBounds(280,210,200,30);
		l12 = new JLabel("Seat_number");
		l12.setBounds(450,210,180,30);
		
		DefaultListModel<String>l = new DefaultListModel<>();
		DefaultListModel<String>li1 = new DefaultListModel<>();
		DefaultListModel<String>li2 = new DefaultListModel<>();
		  try {
	    		
    		  Class.forName("org.postgresql.Driver");
    	  }
    	  catch(Exception ch){
    		  System.out.println(ch.getMessage());
    	  }
    	  try {
    			  Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
    			  Statement statement = con.createStatement();
    			 
    			  String sql = "select * from book where book_id =?";
    			 PreparedStatement pre = con.prepareStatement(sql);
        		  pre.setString(1,book_id);
    			  ResultSet r = pre.executeQuery();
    			  int i=0;
    			 while(r.next()) {
    			String nam = r.getString("name");
    			nameee = nam;
    			String n = r.getString("pass_name");
    			l.addElement(n); 
    			String df = r.getString("age");
    			li1.addElement(df);
    			String m = r.getString("bus");
    			l6.setText(m);
    			String p = r.getString("time");
    			l7.setText(p);
    			String q= r.getString("date");
    			l8.setText(q);
    			String s = r.getString("book_id");
    			l9.setText(s);
    			String st = r.getString("status");
    			l19.setText(st);
    			i++;
    			index =i;}
    			 con.close();
    	  }
    	  catch(Exception e) {
    	    	System.out.print(e.getMessage());
    	    	 }
    	  try {
    		  String hj = l6.getText();
    		  int f = Integer.parseInt(hj);
    		  Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
			  Statement statement = con.createStatement();
    			 String ql = "select * from bus where bid =?";
    			 PreparedStatement prep = con.prepareStatement(ql);
       		  prep.setInt(1,f);
       		  ResultSet re = prep.executeQuery();
       		  while(re.next()) {
       			  String b = re.getString("start");
       			  l22.setText(b);
       			  String c = re.getString("dest");
       			  l24.setText(c);
       		  }
       		 con.close();
    	  }
    	  catch(Exception e) {
  	    	System.out.print(e.getMessage());
  	    	 }
    	  try {
    		  Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
			  Statement statement = con.createStatement();
    			 String ql = "select * from login where fullname =?";
    			 PreparedStatement prep = con.prepareStatement(ql);
        		  prep.setString(1,fullname);
        		  ResultSet re = prep.executeQuery();
        		  while(re.next()) {
        			  String a = re.getString("phone");
        			  email = re.getString("email");
        			  System.out.print(a);
        			  l20.setText(a);
        		  }
        		  con.close();
    	  }
    	  
    	  catch(Exception e) {
    	  }
    	  try {
    		  Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
			  Statement statement = con.createStatement();
    			 String qlr = "select * from seat where book_id =?";
    			 PreparedStatement preper = con.prepareStatement(qlr);
        		  preper.setString(1,book_id);
    			  ResultSet s = preper.executeQuery();
    			  while(s.next()) {
    				  int n = s.getInt("seats");
    				  String hu = Integer.toString(n);
    				  li2.addElement(hu);
    			  }
    			  con.close();
    	  }
    	  catch(Exception e) {
    	    	System.out.print(e.getMessage());
    	    	 }
    	  try {
    		  Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
			  Statement statement = con.createStatement();
    			  String rql = "select * from payment where book_id =?";
     			 PreparedStatement prepe = con.prepareStatement(rql);
         		  prepe.setString(1,book_id);
     			  ResultSet sr = prepe.executeQuery();
     			  while(sr.next()) {
     				  String a = sr.getString("id");
     				  System.out.println("id"+a);
     				  l17.setText(a);
     				   int b = sr.getInt("amount");
     				   String c = Integer.toString(b);
     				   l18.setText(c);
     				   System.out.println("amt"+c);
     			  }
     			 con.close();
    	  }
    	 catch(Exception e) {
    	System.out.print(e.getMessage());
    	 }
    	  
    	  JList<String>list = new JList<>(l);
		  JList<String>list1 = new JList<>(li1);
		  JList<String>list2 = new JList<>(li2);
		  list.setBounds(30,240,150,index*20);
		  list1.setBounds(200,240,180,index*20);
		  list2.setBounds(400,240,180,index*20);
		  ActionListener ok = new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  
				  new homepage(email);
				  f.setVisible(false);
				  System.out.println(email);
			  }
		  };
		  b = new JButton("ok");
			 f.add(b);
			 b.addActionListener(ok);
			 
	      ActionListener cancel = new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    		  String nrr = JOptionPane.showInputDialog(f,"enter Password");
	    		  try {
			     		 Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
			 			  Statement statement = con.createStatement();
			 			 
			 			  String sql = "select * from login where fullname =?";
			 			  PreparedStatement preparedstatement = con.prepareStatement(sql);
			 			  preparedstatement.setString(1,fullname);
			 			  ResultSet res = preparedstatement.executeQuery();
			 			  while(res.next()) {
			 				  email = res.getString("email");
			 				  passew = res.getString("password");
			 				  
			 			  }
			 			 // System.out.print(email);
			 			 con.close();
			     	 }
			     	 catch(Exception ch) {
			     		 System.out.println(ch.getMessage());
			     	 }
					if(passew.equals(nrr)) {
	 				 start = l22.getText();
	 					dest = l24.getText();
	 								time = l7.getText();
	 										 date = l8.getText();
	 				 try {
	 				    Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
		 			  Statement statement = con.createStatement();
	 		 			  String sql = "delete from book where book_id =?";
	 		 			  PreparedStatement preparedstatement = con.prepareStatement(sql);
	 		 			  preparedstatement.setString(1,book_id);
	 		 			  int res = preparedstatement.executeUpdate();
	 		 			con.close();
	 		     	 }
	 				 catch(Exception ch) {
	 		     		 System.out.println(ch.getMessage());
	 		     	 }
	       
	 				
	 		     	 try {
	 		     		 Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
	 		 			  Statement statement = con.createStatement();
	 		 			 
	 		 			  String sql = "delete from seat where book_id =?";
	 		 			  PreparedStatement preparedstatement = con.prepareStatement(sql);
	 		 			  preparedstatement.setString(1,book_id);
	 		 			  int res = preparedstatement.executeUpdate();
	 		 			con.close();
	 		     	 }
	 		     	 catch(Exception ch) {
	 		     		 System.out.println(ch.getMessage());
	 		     	 }
	 		     	try {
			     		 Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
			 			  Statement statement = con.createStatement();
			 			 
			 			  String sql = "delete from payment where book_id =?";
			 			  PreparedStatement preparedstatement = con.prepareStatement(sql);
			 			  preparedstatement.setString(1,book_id);
			 			  int res = preparedstatement.executeUpdate();
			 			 con.close();
			     	 }
			     	 catch(Exception ch) {
			     		 System.out.println(ch.getMessage());
			     	 }  
	 		     	JOptionPane.showMessageDialog(f,"Your ticket from  "+start+" to "+dest+" on "+date+" "+time +" is cancelled successfully","Alert",JOptionPane.WARNING_MESSAGE);
	 		     	new homepage(email);}
	    	  }
	      };
		  if(w==0) {
		 b1 = new JButton("cancel ticket");
		 f.add(b1);
		 b1.setBounds(400,260+(index*20),130,30);
		 b1.addActionListener(cancel);
		}
		  else {
			 
		  }
		  b.setBounds(250,260+(index*20),50,30);
		  f.add(list);
		  f.add(list1);
		  f.add(list2);
		 
		f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l12);
	     f.add(l6);f.add(l7);f.add(l8);f.add(l9);f.add(l10);f.add(l11);f.add(l13);
	     f.add(l14);f.add(l15);f.add(l16);f.add(l17);f.add(l18);f.add(l19);f.add(l20);
		f.setSize(600,600);
		f.add(l25);
		f.setLayout(null);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new ticket("2","sohan nagaraju",0);
	}
}
