package harsha;
import javax.swing.*;
import java.sql.*;
import java.awt.Color;
import java.awt.event.*;
   
public class upi {
	JFrame f1;
	JLabel l2,l5,l4;
	JTextField t1;
	JButton b2;
   upi(int h,int  pid,int amt,String book_id,String fullname){
	   f1 = new JFrame();
		 l2 = new JLabel("UPI");
		 l2.setBounds(150,30,50,30);
		 f1.add(l2);
		 l5 = new JLabel("UPI:");
		 l5.setBounds(30,80,80,30);
		 l4 = new JLabel();
		 f1.add(l5);
		 t1 = new JTextField();
		 t1.setBounds(70,80,200,30);
		 f1.add(t1);
		 b2 = new JButton("pay "+(500*h)+" rupees");
		 b2.setBounds(90,130,150,30);
		 ActionListener upi = new ActionListener() {
    		 public void actionPerformed(ActionEvent e) {
    			 String a = t1.getText();
    			 if(a.isEmpty()) {
    				 JOptionPane.showMessageDialog(f1,"enter UPI","Alert",JOptionPane.WARNING_MESSAGE);
    				
    			 }
    			 else {
    				 try {
    					 Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
   	    			  Statement statement = con.createStatement();
   	    			  String ql = "insert into payment values(?,?,?)";
   	    			 PreparedStatement pre = con.prepareStatement(ql);
	    		     pre.setInt(1,pid);
	    		     pre.setString(2,book_id);
	    		     pre.setInt(3, amt);
   	    			  int s = pre.executeUpdate();
   	    			con.close();
    				 }
    				 catch(Exception ch) {
    					 System.out.println(ch.getMessage());
    				 }
    				 f1.setVisible(false);
    				 new ticket(book_id,fullname,1);
    			 }
    		 }
    	 };
		 b2.addActionListener(upi);
		 f1.add(b2);
		 f1.add(l4);
		 f1.setVisible(true);
		 f1.setLayout(null);
		 f1.setSize(400,300);
   }
}
