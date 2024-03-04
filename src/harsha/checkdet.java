package harsha;
import javax.swing.*;
import java.sql.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
public class checkdet {
	JFrame f,f2;
	String button[],book_id;
	String naem[];
	String age[];
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
	JLabel l14,l15,l16,l17,l18;
	JLabel l19,l20;
	JTextField t1,t2;
	JTable tb;
	JButton butt,ok;
	JButton ju[],jum[];
	int c =0;
	int k;int ikl=0;int hji =0;
	checkdet(String b, int a,String d,int h,String t,String[] bu,String bp){
	   book_id = bp;
		button = new String[30];
		for(int i=0;i<30;i++) {
			button[i] = bu[i];
		}
		 
		f = new JFrame("check details");
	
		l1 = new JLabel("check details:");
		l1.setBounds(200,0,80,30);
		
		l14 = new JLabel("To:");
		l14.setBounds(30,30,50,30);
		l15 = new JLabel("From:");
		l15.setBounds(300,30,50,30);
		f.add(l15);f.add(l14);
		
		l16 = new JLabel();
		l16.setBounds(80,30,80,30);
		l17 = new JLabel();
		l17.setBounds(360,30,80,30);
		f.add(l17);f.add(l16);
		l2 = new JLabel("Bus_id:");
		l2.setBounds(30,60,50,30);
		l3 = new JLabel("time:");
		l3.setBounds(300,60,50,30);
		l4 =new JLabel("date:");
		l4.setBounds(30,90,50,30);
		l5 = new JLabel("book_id:");
		l5.setBounds(300,90,50,30);
		
		l13 = new JLabel(" ");
		l6 = new JLabel("");
		l6.setBounds(80,60,60,30);
		l7 = new JLabel("");
		l7.setBounds(360,60,80,30);
		l8 = new JLabel("");
		l8.setBounds(80,90,80,30);
		l9 =new JLabel("");
		l9.setBounds(360,90,80,30);
		l10 = new JLabel("Passenger_Name");
		l10.setBounds(30,150,200,30);
		l11 = new JLabel("Age");
		l11.setBounds(260,150,200,30);
		l12 = new JLabel("Seat_number");
		l12.setBounds(420,150,180,30);
		
		butt = new JButton("Make Payment");
		ActionListener payment = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
			 	new payment(book_id,h,b); 
			}
		};
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
    			 
    			  String ql = "select count(book_id) from book where book_id =?";
     			 PreparedStatement prep = con.prepareStatement(ql);
         		  prep.setString(1,bp);
     			  ResultSet resd = prep.executeQuery();
     			  
     			 while(resd.next()) {
     				 int qw = resd.getInt("count");
     				 k = qw;
     			 }
     	        naem = new String[k];
     	        age= new String[k];
    			  String sql = "select * from book where book_id =?";
    			 PreparedStatement pre = con.prepareStatement(sql);
        		  pre.setString(1,bp);
    			  ResultSet r = pre.executeQuery();
    			  int i=0;
    			 while(r.next()) {
    			String n = r.getString("pass_name");
    			String df = r.getString("age");
    			li1.addElement(df);
    			age[i] = df;
    			String m = r.getString("bus");
    			l6.setText(m);
    			String p = r.getString("time");
    			l7.setText(p);
    			String q= r.getString("date");
    			l8.setText(q);
    			String s = r.getString("book_id");
    			l9.setText(s);
    			l.addElement(n); 
    			naem[i] = n;
    			i++;
    			ikl = i;}
    	  }
    	  catch(Exception er) {
    	  }
    			 ActionListener change = new ActionListener() {
    				 public void actionPerformed(ActionEvent e) {
    					 for(int o =0;o<k;o++) {
    					 if(e.getSource()==ju[o]) {
    						   int rt =o;
    							  String nrr = JOptionPane.showInputDialog(f,"enter Name");
    							  System.out.println(nrr);
    							  if(nrr.isEmpty()) {
    								 
    							  }
    							  else {
    								  try {
    									  Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
        				    			  Statement statement = con.createStatement();
        				    			 
        				    			  String ql = "update book set pass_name =? where book_id =? and pass_name =?";
        				     			 PreparedStatement prep = con.prepareStatement(ql);
        				         		  prep.setString(1,nrr);
        				         		  prep.setString(2,book_id);
        				         		  prep.setString(3,naem[rt]);
        				     			  int resd = prep.executeUpdate();
    								  }
    								  catch(Exception chee) {
    									  
    								  }
    								  hji =1;
    								  
    							  }
    					 }}}};	
    					 if (hji == 1) {
    						 new checkdet(b,a,d,h,t,bu,bp);
    					 }
    					 ActionListener chset = new ActionListener() {
    	    				 public void actionPerformed(ActionEvent e) {
    	    					 for(int o =0;o<k;o++) {
    	    					 if(e.getSource()==jum[o]) {
    	    						   int rt =o;
    	    						   String nrre = JOptionPane.showInputDialog(f,"enter age");
    	    							  System.out.println(nrre);
    	    							  if(nrre.isEmpty()) {
    	    								 
    	    							  }
    	    							  else {
    	    								  try {
    	    									  Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
    	        				    			  Statement statement = con.createStatement();
    	        				    			 
    	        				    			  String ql = "update book set age =? where book_id =? and pass_name =? and age =?";
    	        				     			 PreparedStatement prep = con.prepareStatement(ql);
    	        				         		  prep.setString(1,nrre);
    	        				         		  prep.setString(2,book_id);
    	        				         		  prep.setString(3,naem[rt]);
    	        				         		 prep.setString(4,age[rt]);
    	        				         		 System.out.println(nrre+" "+book_id+" "+naem[rt]+" "+age[rt]);
    	        				     			  int resd = prep.executeUpdate();
    	    								  }
    	    								  catch(Exception chee) {
    	    									  
    	    								  }
    	    								  new checkdet(b,a,d,h,t,bu,bp);
    	    							  }
    	    							  
    	    					 }}}};				
    			ju = new JButton[ikl];
    			jum = new JButton[ikl];
    			for(int j=0;j<ikl;j++) {
    				ju[j] = new JButton("change");
    				jum[j] = new JButton("change");
    				f.add(jum[j]);
    				f.add(ju[j]);
    				ju[j].setBounds(150,180+(j*18),80,18);
    				jum[j].setBounds(330,180+(j*18),80,18);
    				ju[j].addActionListener(change);
    				jum[j].addActionListener(chset);
    			}
    			 try {
       			  Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
       			  Statement statement = con.createStatement();
    			 String rql = "select * from seat where book_id =?";
    			 PreparedStatement prepe = con.prepareStatement(rql);
        		  prepe.setString(1,bp);
    			  ResultSet s = prepe.executeQuery();
    			  while(s.next()) {
    				  int n = s.getInt("seats");
    				  String hu = Integer.toString(n);
    				  li2.addElement(hu);}
    			  JList<String>list = new JList<>(l);
    			  JList<String>list1 = new JList<>(li1);
    			  JList<String>list2 = new JList<>(li2);
    			  list.setBounds(30,180,120,ikl*20);
    			  list1.setBounds(250,180,80,ikl*20);
    			  list2.setBounds(420,180,80,ikl*20);
    			  butt.setBounds(150,210+(ikl*20),200,30);
    			  butt.addActionListener(payment);
    			  f.add(list);
    			  f.add(list1);
    			  f.add(list2);
    			  f.add(butt);
    			  con.close();
    	  }
    	 catch(Exception e) {
    		 System.out.print(e.getMessage());
    	 }
    	  try {
   			  Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
   			  Statement statement = con.createStatement();
   			 
   			  String ql = "select * from bus where bid =?";
    			 PreparedStatement prep = con.prepareStatement(ql);
    			 String aa = l6.getText();
    			 int bb = Integer.parseInt(aa);
        		  prep.setInt(1,bb);
    			  ResultSet resd = prep.executeQuery();
    			 while(resd.next()) {
    				 String st = resd.getString("start");
    				 l16.setText(st);
    				String des = resd.getString("dest");
    				l17.setText(des);
    			 }
			 }
    	      catch(Exception e) {
    	    	  
    	      }
		f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l12);
	     f.add(l6);f.add(l7);f.add(l8);f.add(l9);f.add(l10);f.add(l11);f.add(l13);
		f.setSize(550,600);
		f.setLayout(null);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		String a[] = new String[30];
		for(int i=0;i<30;i++) {
			a[i]="none";
		}
		 new checkdet("sohan sirashapalli",1710,"29-12-2003",3," ",a,"1");}
  
 }

