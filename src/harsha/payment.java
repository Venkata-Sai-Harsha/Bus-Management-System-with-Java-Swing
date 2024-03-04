package harsha;
import javax.swing.*;
import java.sql.*;
import java.awt.Color;
import java.awt.event.*;
   
public class payment {
	JFrame f,f1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3,b4;
	JComboBox cb,cb1;
	int pid;
	String pidd;
	int amt;
     payment(String book_id,int h,String fullname) {  
    	 amt = h*500;
    	 f = new JFrame();
    	 l1 = new JLabel("Payment Details");
    	 l1.setBounds(120,30,200,30);
    	 f.add(l1);
    	 JRadioButton r1 = new JRadioButton("Debit card/ credit card");
    	 r1.setBounds(30,70,200,30);
    	 JRadioButton r2 = new JRadioButton("Online Payment");
    	 r2.setBounds(30,110,200,30);
    	 JRadioButton r3 = new JRadioButton("UPI");
    	 r3.setBounds(30,150,200,30);
    	 ButtonGroup bg = new ButtonGroup();
    	 try {
    	 Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
		 Statement statement = con.createStatement();
		 String sql = "select max(id) from payment";
		  ResultSet result = statement.executeQuery(sql);
		  while(result.next()) {
			  int b = result.getInt("max");
			  b++;
			  pid = b;
		  }
		
		 con.close();
		 }
    	 catch(Exception e) {
    		 
    	 }
    	 
    	
    	 ActionListener ff = new ActionListener() {
    		 public void actionPerformed(ActionEvent e) {
    			 if(r1.isSelected()) {
    				 f.setVisible(false);
    				 new card(h,pid,amt,book_id,fullname);
    			 }
    			 if(r2.isSelected()) {
                     f.setVisible(false);
                      new online(h,pid,amt,book_id,fullname);
    			 }
    			 if(r3.isSelected()) {
                     f.setVisible(false);
    				 new upi(h,pid,amt,book_id,fullname);
    			 }
    		 }
    	 };
    	 b1 = new JButton("Next");
    	 b1.setBounds(100,190,100,30);
    	 b1.addActionListener(ff);
    	 f.add(b1);
    	 
    	 bg.add(r1); bg.add(r2);bg.add(r3);
    	 f.add(r1);f.add(r2);f.add(r3);
    	 f.setLayout(null);
    	 f.setSize(400,300);
    	 f.setVisible(true);
     }
     public static void main(String[] args) {
    	 new payment("9",3,"sohan");
     }
}

