package harsha;
import javax.swing.*;
import java.sql.*;
import java.awt.Color;
import java.awt.event.*;
   
public class online {
	JFrame f1;
	JLabel l6,l7,l8,l3;
	JComboBox cb;
	JTextField t2;
	JButton b3;
      online(int h,int pid,int amt,String book_id,String fullname){
    	  f1 = new JFrame();
			 l6 = new JLabel("Online Payment");
			 l6.setBounds(120,30,120,30);
			 l7 = new JLabel("Type:");
			 l7.setBounds(30,70,80,30);
			 f1.add(l7);
			 String t[] = {"Paytm","Phone pe","Google pay","Amazon pay"};
			 cb = new JComboBox(t);
			 cb.setBounds(100,70,150,30);
			 f1.add(cb);
			 l8 = new JLabel("Phone no:");
			 l8.setBounds(30,110,80,30);
			 f1.add(l8);
			 t2 = new JTextField();
			 t2.setBounds(100,110,150,30);
			 f1.add(t2);
			 b3 = new JButton("pay "+(500*h)+" rupees");
			 b3.setBounds(90,170,150,30);
			 ActionListener nm = new ActionListener() {
	    		 public void actionPerformed(ActionEvent e) {
	    			 String a = t2.getText();
	    			// System.out.println(a);
	    			 if(a.isEmpty()){
	    				 JOptionPane.showMessageDialog(f1,"enter phone number","Alert",JOptionPane.WARNING_MESSAGE);
	    			 }
	    			 else{
	    				 if(a.length()==10) {
	    				 try {
	    					 Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
	   	    			  Statement statement = con.createStatement();
	   	    			  String ql = "insert into payment values(?,?,?)";
	   	    			 PreparedStatement pre = con.prepareStatement(ql);
		    		     pre.setInt(1,pid);
		    		     pre.setString(2,book_id);
		    		     pre.setInt(3,amt);
	   	    			 int s = pre.executeUpdate();
	   	    			 con.close();
	    				 }
	    				 catch(Exception ch) {
	    					 System.out.println(ch.getMessage());
	    				 }
	    				 f1.setVisible(false);
	    				 new ticket(book_id,fullname,1);
	    			 }
	    				 else {
	    					 JOptionPane.showMessageDialog(f1,"Invaild Phone Number","Alert",JOptionPane.WARNING_MESSAGE);
	    				 }
	    			 }
	    		 }
	    	 };
	    	
			 b3.addActionListener(nm);
			 f1.add(b3);
			 l3 = new JLabel();
			 f1.add(l8);f1.add(l6);
			 f1.setVisible(true);
			 f1.setLayout(null);
			 f1.setSize(400,300);
      }
}
