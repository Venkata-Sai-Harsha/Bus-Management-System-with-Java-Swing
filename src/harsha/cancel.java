package harsha;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class cancel implements ActionListener {
	JFrame f,f1;
	JButton b[];
	String book[];
	JLabel l,l1,l2,l3;
	String start,dest,date,time,bus;
	JButton b1,b2;
	int a;
	int j;
	String full,email; 
      cancel(String fullname){
    	  full = fullname;
     	 f = new JFrame();
     	 f.setVisible(true);
     	try {
    		 Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
			  Statement statement = con.createStatement();
			 
			  String sql = "select email from login where fullname = ?";
			  PreparedStatement preparedstatement = con.prepareStatement(sql);
			  preparedstatement.setString(1,fullname);
			  ResultSet res = preparedstatement.executeQuery();
			  
			  while(res.next()) {
				 email = res.getString("email");
			  }
    	 }
    	 catch(Exception e) {
    		 System.out.println(e.getMessage());
    	 }
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
 			//  System.out.println(j);
 			  con.close();
     	 }
     	 catch(Exception e) {
     		 System.out.println(e.getMessage());
     	 }
     	 if(j==0) {
     		 ActionListener home = new ActionListener() {
     			 public void actionPerformed(ActionEvent e) {
     				 new homepage(email);
     			 }
     		 };
     		l1 = new JLabel("You haven't made any booking "+fullname);
     		l2 = new JLabel("Make your first booking and enjoy shiva travels");
   		 f.add(l1);
   		 f.add(l2);
   		 l2.setBounds(70,70,350,30);
   		 l1.setBounds(70,30,350,30);
   		 l3 = new JLabel();
   		 f.add(l3);
   		b1 = new JButton("ok");
   		b1.setBounds(90,100,30,30);
   		b1.addActionListener(home);
   		 b2 = new JButton();
   		 //f.add(b2);
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
     		 b[i] = new JButton(start+" to "+dest+" on "+date+" "+time);
     		 f.add(b[i]);
     		 b[i].addActionListener(this);
     		 b[i].setBounds(0,30+(i+1)*40,600,30);
     	 }
     	 
     	 f.setLayout(null);
     	 f.setSize(600,200+(j)*40);
     	 f.setVisible(true);
      }
      }
      public void actionPerformed(ActionEvent e) {
    	  String name ="";
     	 for(int i=0;i<j;i++) {
 			if(e.getSource()==b[i]) {
 				
 				String book_id = book[i];
 				
 				try {
		     		 Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
		 			  Statement statement = con.createStatement();
		 			 
		 			  String sql = "select * from book where book_id =?";
		 			  PreparedStatement preparedstatement = con.prepareStatement(sql);
		 			  preparedstatement.setString(1,book_id);
		 			  ResultSet res = preparedstatement.executeQuery();
		 			  while(res.next()) {
		 				  name = res.getString("name");
		 			  }
		 			 con.close();
		     	 }
 				
		     	 catch(Exception ch) {
		     		 System.out.println(ch.getMessage());
		     	 }
				new ticket(book_id,name,0);
 			}
 	      }
      }
      public static void main(String[] args) {
         new cancel("Sohan sirashapalli");
     
      }
}
