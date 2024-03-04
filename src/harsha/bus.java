package harsha;
import javax.swing.*;
import java.sql.*;
import java.awt.Color;
import java.awt.event.*;
public class bus {
	JFrame f;
	JLabel l1,l2,l3,l4;
	JLabel l5,l6,l7,l8,l9,l10;
	JLabel l11,l12;
	JTextField t1,name,age;

	JButton b1,b2,b3,b4;
	String pn=" ",pa=" ",time;
	int s;
	int m =0;int j=0;
	String book_id;
	String status = "Confirmed";
	int checke ;
    bus(String b,int a,String d,int h,String t,String bp,int sohan,int c){
    	
    	s =h;
    	time = t;
    	book_id = bp;
    	m = sohan;
    	System.out.println(book_id);
    	f = new JFrame("passenger details");
    	l5 = new JLabel("From:");l5.setBounds(30,30,50,30);f.add(l5);
    	l9 = new JLabel("");l9.setBounds(70,30,100,30);f.add(l9);
    	l6 = new JLabel("To:");l6.setBounds(300,30,50,30);f.add(l6);
    	l10 = new JLabel("");l10.setBounds(340,30,100,30);f.add(l10);
    	l7 = new JLabel("Date:");l7.setBounds(30,60,50,30);f.add(l7);
    	l11 = new JLabel("");l11.setBounds(70,60,180,30);f.add(l11);
    	l11.setText(d);
    	l8 = new JLabel("Time:");l8.setBounds(300,60,50,30);f.add(l8);
    	l12 = new JLabel("");l12.setBounds(340,60,160,30);f.add(l12);
    	l12.setText(time);
    	l2 = new JLabel("Passenger Details");
    	l2.setBounds(10,0,120,30);
    	f.add(l2);
    
    	 try {
	    		
	  		  Class.forName("org.postgresql.Driver");
	  	  }
	  	  catch(Exception ch){
	  		  System.out.println(ch.getMessage());
	  	  }
	  	  try {
    	Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
		  Statement statement = con.createStatement();
	     String sql = "select * from bus where bid =?";
	     PreparedStatement pre = con.prepareStatement(sql);
	     pre.setInt(1,a);
	    ResultSet  g  = pre.executeQuery();
	    while(g.next()) {
	    	String st = g.getString("start");
	    	String de = g.getString("dest");
	    	l9.setText(st);
	    	l10.setText(de);
	    }
	    con.close();
	  	 }
			catch(Exception ch) {
				System.out.println(ch.getMessage());
			}
	  	
    	l3 = new JLabel("Name:");
    	l3.setBounds(30,120,80,30);
    	l4= new JLabel("Age:");
    	l4.setBounds(30,150,80,30);
    	name= new JTextField();
    	name.setBounds(80,120,200,30);
    	age= new JTextField();
    	age.setBounds(80,150 ,200,30);
    	
		
		ActionListener add = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(m<(s-1)) {
    				m++;
    			new bus(b,a,d,s,time,book_id,m,checke);}
    			else {
    				JOptionPane.showMessageDialog(f,"You can enter only "+s+" details","Alert",JOptionPane.WARNING_MESSAGE);
    			}
    			
    		}
    	};
    	ActionListener book = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(m==s-1) {
    			new seat(b,a,d,s,time,book_id);}
    			else {
    				JOptionPane.showMessageDialog(f,"You have to enter more details","Alert",JOptionPane.WARNING_MESSAGE);
    			}
    		}
    	};
    	b1 = new JButton("Add Passenger");
    	b1.setBounds(120,210,120,30);
    	b1.addActionListener(add);
    	b2 = new JButton("book");
    	b2.setBounds(320,210,90,30);
    	b2.addActionListener(book);
    	b3= new JButton("save");
    	b3.setBounds(30,210,100,30);
    	
    	ActionListener save = new ActionListener() {
    	 public void actionPerformed(ActionEvent e) {
    		 pn = name.getText();
    		 pa = age.getText();
    		 try {
    	    		
    	  		  Class.forName("org.postgresql.Driver");
    	  	  }
    	  	  catch(Exception ch){
    	  		  System.out.println(ch.getMessage());
    	  	  }
    		 try {
    			 Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
      			  Statement statement = con.createStatement();
      		     String sql = "select max(pnr) from book";
      		     ResultSet re = statement.executeQuery(sql);
      		    while(re.next()) {
      		    	int a = re.getInt("max");
      		    	a++;
      		    	j = a;
      		    }
    		 }
    		 catch(Exception che)
    		 {
    			 
    		 }
    	  	  try {
    	  		  if((pn.isEmpty())||(pa.isEmpty())) {
    	  			  JOptionPane.showMessageDialog(f,"Fill the details","Alert",JOptionPane.WARNING_MESSAGE);
    	  		  }
    	  		  else {
    	  		  if((pn.length()<=32)||(pa.length()<=3)) {
    	  		Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
    			  Statement statement = con.createStatement();
    		     String sql = "insert into book values(?,?,?,?,?,?,?,?,?)";
    		     PreparedStatement pre = con.prepareStatement(sql);
    		     pre.setString(1,b);
    		     pre.setInt(2,a);
    		     pre.setString(3,d);
    		     pre.setString(4,pn);
    		     pre.setString(5,pa);
    		     pre.setString(6,bp);
    		     pre.setString(7,t);
    		     pre.setString(8,status);
    		     pre.setInt(9,j);
    		     //System.out.println(pn+pa);
    		    int g  = pre.executeUpdate();
    		    con.close();}
    	  		  else {
    	  			JOptionPane.showMessageDialog(f,"name can't exceed 32 characters and age can't exceed 3 digits","Alert",JOptionPane.WARNING_MESSAGE);
    	  		  }
    	  		  
    	  	  }
    	  	  }
    				catch(Exception ch) {
    					System.out.println(ch.getMessage());
    				}
    	}
    	};
    	b3.addActionListener(save);
    	
       f.setSize(500,300);
        
       // f.add(b4);
    	f.add(l3);
	  	  f.add(l2);
    	f.add(l4);
    	f.add(name);
       f.add(age);
	  	f.add(b1);f.add(b2);f.add(b3);
    	
    	f.setLayout(null);
    	f.setVisible(true);
    }
    public static void main(String[] args) {
    	new bus("sohan sirashapalli",1710,"29-12-2003",3,"8.00pm","9",0,0);
    }
}

