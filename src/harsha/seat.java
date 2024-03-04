package harsha;
import javax.swing.*;
import java.sql.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
public class seat{
	JFrame f;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
	JButton b11,b12,b13,b14,b15,b16,b17,b18,b19,b20;   
	JButton b21,b22,b23,b24,b25,b26,b27,b28,b29;
	JButton b30,b31,b32,b33,b34,b35,b36;
	int k =0;
	int s;String u;
	int m =0;
	int jkl;int jerk=0;
	String bu[];JButton butte[];
	String fullname,date,time,book_id;
	int bus;int countp;
     seat(String b, int a,String d,int h,String t,String bp){
    	 book_id = bp;
    	 jkl = Integer.parseInt(book_id);
    	 System.out.print(h);
    	  m =0;
    	  time = t;
    	 fullname = b;
    	 date = d;
    	 bus = a;
    	 s = h;
    	 bu = new String[30];
    	 f = new JFrame("seats");
    	 for(int i=0;i<30;i++) {
    		 bu[i]="none";
     }
    	 try {
	    		
      		  Class.forName("org.postgresql.Driver");
      	  }
      	  catch(Exception ch){
      		  System.out.println(ch.getMessage());
      	  }
      	  try {
      			  Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
      			  Statement statement = con.createStatement();
      			 
      		     String sql = "select * from seat where bus_id =?and date=?and time=?";
      		     PreparedStatement pre = con.prepareStatement(sql);
      		     pre.setInt(1,bus);
      		     pre.setString(2,d);
      		     pre.setString(3,t);
      		     ResultSet result  = pre.executeQuery();
      		     while(result.next()) {
      		    	 int i = result.getInt("seats");
      		     	 bu[i-1] = "red";
      		     }
      		     
      		     for(int i=0;i<30;i++) {
      			    	 System.out.print(bu[i]);
      			     }
      		  con.close();
   	        }
      	  catch(Exception ch) {
      		  System.out.println(ch.getMessage());
      	  }
    	
    	 butte = new JButton[36];
    	 ActionListener click = new ActionListener() {
    		 public void actionPerformed(ActionEvent e) {
    			 for(int i=0;i<30;i++) {
    				 if(e.getSource()==butte[i]) {
    					  bu[i]="green";
    		        	  m++;
    		        	  butte[i].setBackground(Color.green);
    				 }
    			 }
    			 
              	  
                
                if((m)>s) {
              	  m =0;
              	  JOptionPane.showMessageDialog(f,"You can select only "+s+" seats","Alert",JOptionPane.WARNING_MESSAGE);
              	f.setVisible(false);
              	new seat(fullname,bus,date,s,time,book_id);
                }
    		 }
    	 };
    	 
    	 for(int i=0;i<30;i++) {
    		 String u = Integer.toString(i+1);
    		 butte[i] = new JButton(u);
    		 f.add(butte[i]);
    		 if(jkl!=0) {
    		 butte[i].addActionListener(click);}
    	 }
    	 for(int i=0;i<30;i++) {
    		 if(bu[i]=="red") {
    			 butte[i].removeActionListener(click);
    	    	 butte[i].setBackground(Color.RED);
    		 }
    	 }
    	 ActionListener clear = new ActionListener() {
    		 public void actionPerformed(ActionEvent e) {
    			 f.setVisible(false);
    			 new seat(fullname,bus,date,s,time,book_id);
    		 }
    	 };
    	 butte[30]= new JButton();
    	 butte[31]= new JButton();
    	 butte[32]= new JButton();
    	 butte[33]= new JButton();
    	 f.add(butte[30]);f.add(butte[31]);f.add(butte[32]);f.add(butte[33]);
    	 ActionListener next = new ActionListener() {
    		 public void actionPerformed(ActionEvent e) {
    			 if(jkl ==0) {
    				 try {
      		    		
          	    		  Class.forName("org.postgresql.Driver");
          	    	  }
          	    	  catch(Exception ch){
          	    		  System.out.println(ch.getMessage());
          	    	  }
          	    	  try {
          	    			  Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
          	    			  Statement statement = con.createStatement();
          	    		     String sql = "select * from login where fullname =?";
          	    		     PreparedStatement pre = con.prepareStatement(sql);
          	    		     pre.setString(1,fullname);
          	    		     ResultSet result  = pre.executeQuery();
          	    		     while(result.next()) {
          	    		    	 u = result.getString("email");
          	    		     }
          	    		     con.close();
          	    		    
          		  }
          	    	  catch(Exception ch) {
          	    		  System.out.print(ch.getMessage());
          	    	  }
          	    	f.setVisible(false);
    				 new homepage(u);
    			 }
    			 else {
    			 for(int i=0;i<30;i++) {
           		  if(bu[i].equals("green")) {
           			  try {
         		    		
           	    		  Class.forName("org.postgresql.Driver");
           	    	  }
           	    	  catch(Exception ch){
           	    		  System.out.println(ch.getMessage());
           	    	  }
           			 try {
            			 Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
              			  Statement statement = con.createStatement();
              		     String sql = "select max(pnr) from seat";
              		     ResultSet re = statement.executeQuery(sql);
              		    while(re.next()) {
              		    	int a = re.getInt("max");
              		    	a++;
              		    	jerk = a;
              		    }
            		 }
            		 catch(Exception che)
            		 {
            			 
            		 }
           	    	  try {
           	    			  Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
           	    			  Statement statement = con.createStatement();
           	    		     String sql = "insert into seat values (?,?,?,?,?,?,?)";
           	    		     PreparedStatement pre = con.prepareStatement(sql);
           	    		     pre.setString(1,fullname);
           	    		     pre.setInt(2,i+1);
           	    		     pre.setInt(3,bus);
           	    		     pre.setString(4,date);
           	    		     pre.setString(5,time);
           	    		     pre.setString(6,book_id);
           	    		     pre.setInt(7,jerk);
           	    		     ResultSet result  = pre.executeQuery();
           	    		     con.close();
           	    		    
           		  }
           	    	  catch(Exception ch) {
           	    		  System.out.print(ch.getMessage());
           	    	  }
           	    	if(m==s) {
                	      new checkdet(fullname,bus,date,s,time,bu,book_id);}
                	 if(m<s){
                		  JOptionPane.showMessageDialog(f,"You have to select "+s+" seats","Alert",JOptionPane.WARNING_MESSAGE);
                		  }
             }
             }
           	 
    		 }
    		 }
    	 };
    	 try {
	    		
	    		  Class.forName("org.postgresql.Driver");
	    	  }
	    	  catch(Exception ch){
	    		  System.out.println(ch.getMessage());
	    	  }
	    	  try {
	    			  Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
	    			  Statement statement = con.createStatement();
	    		     String sql = "select count(seats) from seat where bus_id =? and date =? and time =?";
	    		     PreparedStatement pre = con.prepareStatement(sql);
	    		     pre.setInt(1,a);
	    		     pre.setString(2,d);
	    		     pre.setString(3,t);
	    		     ResultSet result  = pre.executeQuery();
	    		     while(result.next()) {
	    		    	 
	    		    	 countp = result.getInt("count");
	    		    	System.out.print(countp);
	    		     }
	    		     con.close();
	    		    
		  }
	    	  catch(Exception ch) {
	    		  System.out.print(ch.getMessage());
	    	  }
    	 butte[34] = new JButton("clear");
    	 f.add(butte[34]);
    	 butte[35] = new JButton("Book");
    	 butte[35].addActionListener(next);
    	 if(jkl ==0) {
    		 butte[30].setText("Seats Available");
    		 butte[30].setBackground(Color.yellow);
    		 countp = 30-countp;
    		 String poi = Integer.toString(countp);
    		 butte[31].setText(poi);
    		 butte[31].setBackground(Color.yellow);
    		 butte[35].setText("ok");
    		 butte[34].setText("");
    	 }
    	 else {
    	 butte[34].addActionListener(clear);
    	 }
    	 f.add(butte[35]);
    	 
    	 f.setLayout(new GridLayout(6,5));
    	 f.setVisible(true);
    	 f.setSize(800,800);
    	
     
     }
     public static void main(String[] args) {
    	 new seat("sohan nagaraju",1712,"2-2-2023",2,"1.00pm","1");
     }
}

