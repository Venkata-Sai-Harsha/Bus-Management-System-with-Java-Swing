package harsha;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
public class buus {
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l10,l12,l13,l11;
	JButton b;
	int cw =0;
     buus(String e,int a){
    	 f = new JFrame();
    	 String aa = Integer.toString(a);
    	 l5 = new JLabel(aa);
    	 
    	 System.out.println(aa);
    	 
    	 l5.setBounds(100,30,80,30);
    	 l6 = new JLabel();
    	 l1 = new JLabel("From:");
    	 l1.setBounds(30,60,50,30);
    	 l2 = new JLabel("To:");
    	 l2.setBounds(30,90,50,30);
    	 l3 = new JLabel();
    	 l3.setBounds(100,60,100,30);
    	 l4 = new JLabel();
    	 l4.setBounds(100,90,100,30);
    	 l10 =new JLabel("driver:");
		  l10.setBounds(30,120,80,30);
		  l11 = new JLabel("conducter:");
		  l11.setBounds(30,150,80,30);
		  l12 =new JLabel();
		  l12.setBounds(100,120,80,30);
		  l13 =new JLabel();
		  l13.setBounds(100,150,80,30);
		  
		  f.add(l10);f.add(l11);f.add(l12);f.add(l13);
		  f.add(l4);f.add(l5);f.add(l6);
		  
		  l7 = new JLabel();
		 // l7.setBounds(80,90,80,30);
		  l8 = new JLabel();
		  //l8.setBounds(80,120,80,30);
    	 f.add(l6);f.add(l5);f.add(l4);f.add(l3);f.add(l2);f.add(l1);
    	 try {
	    		
    		  Class.forName("org.postgresql.Driver");
    	  }
    	  catch(Exception ch){
    		  //System.out.println(ch.getMessage());
    	  }
    			  try {
    			  Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
    			  Statement statement = con.createStatement();
    			  String ql = "select * from bus where bid =?";
    			  PreparedStatement preparedstatement = con.prepareStatement(ql);
    			  preparedstatement.setInt(1,a);
    			  ResultSet result = preparedstatement.executeQuery();
    			  while(result.next()) {
    				  String start = result.getString("start");
    				  String dest = result.getString("dest");
    				  String cond = result.getString("conduct");
    				  String driver  = result.getString("driver");
    				  l4.setText(dest);
    				  l3.setText(start);
    				  l12.setText(driver);
    				  l13.setText(cond);
    				  
    			  }
    			
    			  con.close();
    			  }
    			  catch(Exception cge) {
    				  System.out.println("1);");
    			  }
    	
        ActionListener but = new ActionListener() {
        	public void actionPerformed(ActionEvent eh) {
        		new homepage(e);
        	}
        };
    	b = new JButton("ok");
    	b.setBounds(100,200,80,30);
    	f.add(b);
    	b.addActionListener(but);
    	 f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);
    	 f.setVisible(true);
    	 f.setSize(400,400);
    	 f.setLayout(null);
     }
     public static void main(String[] args) {
    	 new buus("sohan.siras@gmail.com",1711);
     }
}
