package harsha;
import javax.swing.*;
import java.sql.*;
import java.awt.Color;
import java.awt.event.*;

public class addticket implements ActionListener {
    JFrame f,f1;
	JButton b[];
	String book[];
	JLabel l,l1;
	JButton b1,b2;
	String start,dest,date,time,bus,email;
	int a;
	int j;
	String full;
    addticket(String fullname){
    	 full = fullname;
    	 f = new JFrame();
    	 f.setLayout(null);
    	 f.setVisible(true);
    	 try {
    		 Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
			  Statement statement = con.createStatement();
			 
			  String sql = "select count(distinct book_id) from book where name = ?";
			  PreparedStatement preparedstatement = con.prepareStatement(sql);
			  preparedstatement.setString(1,fullname);
			  ResultSet res = preparedstatement.executeQuery();
			  
			  while(res.next()) {
				 j = res.getInt("count");
			  }
			  
			  System.out.println(j);
			  con.close();
    	 }
    	 catch(Exception e) {
    		 System.out.println(e.getMessage());
    	 }
    	 ActionListener bok = new ActionListener() {
    		 public void actionPerformed(ActionEvent e) {
    			 new booking(fullname);
    		 }
    	 };
    	 if(j==0) {
    		 l1 = new JLabel("Make your first booking "+fullname+", enjoy shiva travels");
    		 f.add(l1);
    		 l1.setBounds(70,30,350,30);
    		 b1 = new JButton("Book Ticket");
    		 b1.setBounds(100,90,200,30);
    		 b1.addActionListener(bok);
    		 f.add(b1);
    		 f.setSize(500,300);
    	 }
    	 else {
    	 l = new JLabel("Booked Tickets");
    	 l.setBounds(250,20,300,30);
    	 f.add(l);
    	 book = new String[j];
    	 b = new JButton[j];
    	 try {
    		 Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
			  Statement statement = con.createStatement();
			 
			  String sql = "select distinct (book_id) from book where name = ? order by book_id desc";
			  PreparedStatement preparedstatement = con.prepareStatement(sql);
			  preparedstatement.setString(1,fullname);
			  ResultSet res = preparedstatement.executeQuery();
			  int y=0;
			  while(res.next()) {
				   book[y] = res.getString("book_id");
				   y++;
			  }
			  
			  System.out.println(j);
			  for(int k=0;k<j;k++) {
				  System.out.println(book[k]);
			  }
			  con.close();
    	 }
    	 catch(Exception e) {
    		 System.out.println(e.getMessage());
    	 }
        int ji=0;
    	 for(int i=0;i<j;i++) {
    		 try {
    			 Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
   			  Statement statement = con.createStatement();
   			 
   			  String sql = "select * from book where book_id = ?";
   			  PreparedStatement preparedstatement = con.prepareStatement(sql);
   			  preparedstatement.setString(1,book[i]);
   			  ResultSet res = preparedstatement.executeQuery();
   			  while(res.next()) {
   				   time = res.getString("time");
   				   date  = res.getString("date");
   				    a  = res.getInt("bus");
   				    bus = Integer.toString(a);
   			  }
   			con.close();
    		 }
    		 catch(Exception e) {
        		 System.out.println(e.getMessage());
        	 }
   			  try {
   				 Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
      			  Statement statement = con.createStatement();
   			 String ql = "select * from bus where bid= ?";
  			  PreparedStatement pre= con.prepareStatement(ql);
  			  pre.setInt(1,a);
  			  ResultSet re = pre.executeQuery();
  			  while(re.next()) {
  				     start= re.getString("start");
  				   dest  = re.getString("dest");
  				    
  			  }
   			  con.close();
        	 }
        	 catch(Exception e) {
        		 System.out.println(e.getMessage());
        	 }
   			try {
  				 Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
     			  Statement statement = con.createStatement();
  			 String ql = "select * from login where fullname = ?";
 			  PreparedStatement pre= con.prepareStatement(ql);
 			  pre.setString(1,fullname);
 			  ResultSet re = pre.executeQuery();
 			  while(re.next()) {
 				    email = re.getString("email");
 				    
 			  }
  			  con.close();
       	 }
       	 catch(Exception e) {
       		 System.out.println(e.getMessage());
       	 }
    		 b[i] = new JButton(start+" to "+dest+" on "+date+" "+time);
    		 f.add(b[i]);
    		 b[i].addActionListener(this);
    		 b[i].setBounds(0,30+(i+1)*40,600,30);
    		 ji = i;
    	 }
    	 ActionListener ome = new ActionListener() {
    		 public void actionPerformed(ActionEvent e) {
    			new homepage(email);
    		 }
    	 };
    	 f.setSize(600,250+(j)*40);
    	 b2 = new JButton("ok");
    	 b2.setBounds(260,90+(ji+1)*40,60,30);
    	 f.add(b2);
    	 b2.addActionListener(ome);
    	 
     }
     }
     public void actionPerformed(ActionEvent e) {
    	 for(int i=0;i<j;i++) {
			if(e.getSource()==b[i]) {
				new ticket(book[i],full,1);
			}
	 }
     }
     public static void main(String[] args) {
        new addticket("sohan nagaraju");
     }
}
