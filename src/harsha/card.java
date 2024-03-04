package harsha;
import javax.swing.*;
import java.sql.*;
import java.awt.Color;
import java.awt.event.*;
   
public class card {
	JFrame f1;
	JLabel l9,l10,l11,l12,l7,l13;
	JTextField t3,t4,t5;
	JButton b4;
	JComboBox cb1;
     card(int h,int pid,int amt,String book_id,String fullname){
    	 f1 = new JFrame();
		 l9 = new JLabel("Cards");l9.setBounds(140,30,100,30);f1.add(l9);
		 l10 = new JLabel("Type");l10.setBounds(30,70,80,30);f1.add(l10);
		 l11= new JLabel("Card number");l11.setBounds(30,110,80,30);f1.add(l11);
		 l12= new JLabel("cvv");l12.setBounds(30,150,80,30);f1.add(l12);
		 l13= new JLabel("expiry date");l13.setBounds(30,190,80,30);f1.add(l13);
		 b4 = new JButton("pay "+(500*h)+" rupees");
		 b4.setBounds(90,250,150,30);f1.add(b4);
		 ActionListener cr = new ActionListener() {
    		 public void actionPerformed(ActionEvent e) {
    			String a = t3.getText();
    			String b = t4.getText();
    			String c = t5.getText();
    			if((a.isEmpty())||(b.isEmpty())||(c.isEmpty())) {
    				 JOptionPane.showMessageDialog(f1,"enter card details","Alert",JOptionPane.WARNING_MESSAGE);
    				
    			}
    			else {
    				if((a.length()==12)&&(b.length()==3)&&(c.length()==5)) {
    					Connection con;
    				try {
      					  con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
     	    			  Statement statement = con.createStatement();
     	    			  String ql = "insert into payment values(?,?,?)";
     	    			 PreparedStatement pre = con.prepareStatement(ql);
   	    		     pre.setInt(1,pid);
   	    		     pre.setString(2,book_id);
   	    		     pre.setInt(3, amt);
     	    			  int s = pre.executeUpdate();
     	    			  System.out.println(s);
     	    			 con.close();
    				}
      				 catch(Exception ch) {
      					 System.out.println(ch.getMessage());
      				 }
    				 new ticket(book_id,fullname,1);
    				}
    				else {
    					 JOptionPane.showMessageDialog(f1,"Invaild card details","Alert",JOptionPane.WARNING_MESSAGE);
    				}
    			}
    		 }
    	 };
		 b4.addActionListener(cr);
		 t3 = new JTextField();
		 t3.setBounds(120,110,200,30);f1.add(t3);
		 t4 = new JTextField();
		 t4.setBounds(120,150,200,30);f1.add(t4);
		 t5 = new JTextField();
		 t5.setBounds(120,190,200,30);f1.add(t5);
		 String t[] = {"Credit Card","Debit Card"};
		 cb1 = new JComboBox(t);
		 f1.add(cb1);
		 cb1.setBounds(120,70,200,30);
		 l7 = new JLabel();
		 f1.add(l7);
		 f1.setVisible(true);
		 f1.setLayout(null);
		 f1.setSize(400,350);
     }
     public  static void main(String[] args) {
    	 new card(2,4,1000,"50","sohan nagaraju");
     }
}
