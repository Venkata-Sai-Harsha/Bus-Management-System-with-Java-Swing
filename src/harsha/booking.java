package harsha;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.util.*;
public class booking {
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JTextField t1,t2,t3,t4,t5;
	JButton b;
	int p;
	int a=0;
	String time;
	JComboBox cb,cb1,cb2,cb3,cb4,cb5,cb6;
	int sohan=0;int perty1,perty2;
	String dest=" ",start=" ",date=" ",bp,ser,yey,mony,daer;
	String pass[],m[],da[],y[];
	int h;
	String s[];
	 String d[];int sty;
      booking(String u){
    	  String t[] = {"8.00am","1.00pm","5.00pm","8.00pm","1.00am","6.00am"};
    	  
    	  f = new JFrame();
    	  pass = new String[30];
    	  for(int i=1;i<=30;i++) {
    		  String bn = Integer.toString(i);
    		  pass[i-1]=bn;
    	  }
    	  da = new String[31];
    	  m = new String[12];
    	  y = new String[4];
    	  for(int i=1;i<=31;i++) {
    		  String bn = Integer.toString(i);
    		  da[i-1]=bn;
    	  }
    	  for(int i=1;i<=12;i++) {
    		  String bn = Integer.toString(i);
    		  m[i-1]=bn;
    	  }
    	  int hjo = 2020;
    	  for(int i=0;i<=3;i++) {
    		  String bn = Integer.toString(hjo);
    		  hjo++;
    		  y[i]= bn;
    	  }
    	  ActionListener com = new ActionListener() {
    		  public void actionPerformed(ActionEvent e) {
    			  time = cb.getItemAt(cb.getSelectedIndex()).toString();
    			  
    			  //System.out.print(time);
    		  }
    	  };
    	  ActionListener strt= new ActionListener() {
    		  public void actionPerformed(ActionEvent e) {
    			  start = cb1.getItemAt(cb1.getSelectedIndex()).toString();
    			  //System.out.print(time);
    		  }
    	  };
    	  ActionListener destt= new ActionListener() {
    		  public void actionPerformed(ActionEvent e) {
    			  dest = cb2.getItemAt(cb2.getSelectedIndex()).toString();
    			  //System.out.print(time);
    		  }
    	  };
    	  ActionListener no= new ActionListener() {
    		  public void actionPerformed(ActionEvent e) {
    			  ser = cb3.getItemAt(cb3.getSelectedIndex()).toString();
    			  //System.out.print(time);
    		  }
    	  };
    	  ActionListener datt= new ActionListener() {
    		  public void actionPerformed(ActionEvent e) {
    			  daer = cb4.getItemAt(cb4.getSelectedIndex()).toString();
    			  //System.out.print(time);
    		  }
    	  };
    	  ActionListener mon= new ActionListener() {
    		  public void actionPerformed(ActionEvent e) {
    			  mony = cb5.getItemAt(cb5.getSelectedIndex()).toString();
    			  //System.out.print(time);
    		  }
    	  };
    	  ActionListener year= new ActionListener() {
    		  public void actionPerformed(ActionEvent e) {
    			  yey  = cb6.getItemAt(cb6.getSelectedIndex()).toString();
    			  //System.out.print(time);
    		  }
    	  };
    	  try {
	    		
    		  Class.forName("org.postgresql.Driver");
    	  }
    	  catch(Exception ch){
    		  //System.out.println(ch.getMessage());
    	  }
    			  try {
    			  Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
    			  Statement statement = con.createStatement();
    			  String ql = "select count(distinct(start)) from bus";
    			  ResultSet serr = statement.executeQuery(ql);
    			  while(serr.next()) {
    				  perty1= serr.getInt("count");
    			  }
    			  String rql = "select count(distinct(dest)) from bus";
    			  ResultSet serrt = statement.executeQuery(rql);
    			  while(serrt.next()) {
    				  perty2= serrt.getInt("count");
    			  }
    			  con.close();
    			  }
    			  catch(Exception cge) {
    				  System.out.println("1);");
    			  }
    			  
           s = new String[perty1];
           d = new String[perty2];
           int i=0,j=0;
           try {
 			  Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
 			  Statement statement = con.createStatement();
 			  String ql = "select distinct(start) from bus";
 			  ResultSet serr = statement.executeQuery(ql);
 			  while(serr.next()) {
 				  String a = serr.getString("start");
 				  s[i] = a;
 				  i++;
 			  }
 			  
 			 String rql = "select distinct(dest) from bus";
			  ResultSet serrt = statement.executeQuery(rql);
			  while(serrt.next()) {
				  String a = serrt.getString("dest");
				  d[j] = a;
				  j++;
			  }
 			  con.close();
 			  }
 			  catch(Exception cge) {
 				  //System.out.println("1);");
 			  }
    	  cb = new JComboBox(t);
    	  cb1 = new JComboBox(s);
    	  cb1.addActionListener(strt);
    	  cb2 = new JComboBox(d);
    	  cb2.addActionListener(destt);
    	  cb3 = new JComboBox(pass);
    	  cb3.addActionListener(no);
    	  
    	  cb4 = new JComboBox(da);
    	  cb4.addActionListener(datt);
    	  cb4.setBounds(160,120,60,30);
          
    	  cb5 = new JComboBox(m);
    	  cb5.addActionListener(mon);
    	 // cb5.setBounds(160,120,30,30);
    	  cb5.setBounds(220,120,60,30);
    	  cb6 = new JComboBox(y);
    	  cb6.addActionListener(year);
    	  cb6.setBounds(280,120,80,30);
    	  f.add(cb4);f.add(cb5);f.add(cb6);
    	  //cb4.setBounds(160,120,30,30);
    	  f.add(cb1);
    	  f.add(cb2);
    	  cb.setBounds(160,180,200,30);
    	  cb.addActionListener(com);
    	  f.setSize(700,350);
    	  l1 = new JLabel("Booking");
    	  l1.setBounds(200,10,100,30);
    	  l2 = new JLabel("Starting");
    	  l2.setBounds(30,60,100,30);
    	  l3 = new JLabel("Destination");
    	  l3.setBounds(30,90,100,30);
    	  l4 = new JLabel();
    	  l5 = new JLabel("starting_date");
    	  l5.setBounds(30,120,150,30);
    	  l6 = new JLabel("Number of Passenger");
    	  l6.setBounds(30,150,180,30);
    	  l7 = new JLabel("Time Slot");
    	  l7.setBounds(30,180,150,30);
    	 
    	 /* l9= new JLabel("start");
    	  l9.setBounds(500,60,50,10);
    	  l10 = new JLabel("dest");
    	  l10.setBounds(650,60,50,10);
    	  f.add(l9);f.add(l10);*/
    	 // t1 = new JTextField();
    	  l10 = new JLabel("Buses Available");
    	  l10.setBounds(450,20,150,30);
    	  f.add(l10);
    	  cb1.setBounds(160,60,200,30);
    	 
    	 // t2 = new JTextField();
    	  cb2.setBounds(160,90,200,30);
    	 
    	  
    	 // t3 = new JTextField();
    	 // t3.setBounds(160,120,200,30);
    	
    	  t5 = new JTextField();
    	 // t4 = new JTextField();
    	  cb3.setBounds(160,150,200,30);
    	  f.add(cb3);
    	  
    	  ActionListener bus = new ActionListener() {
    		  public void actionPerformed(ActionEvent e) {
    			//  start  = t1.getText();
    			//  dest = t2.getText();
    			  date = daer+"-"+mony+"-"+yey;
    			  //System.out.println(date);
    			  //String ser = t4.getText();
    			 
    			  //System.out.print(date+" "+start+" "+dest+" "+ser);
    			  try {
    		    		
    	    		  Class.forName("org.postgresql.Driver");
    	    	  }
    	    	  catch(Exception ch){
    	    		  System.out.println(ch.getMessage());
    	    	  }
    	    		  if((start.isEmpty())||(dest.isEmpty())||(date.isEmpty())||(ser.isEmpty()))
        			  {
    	    			  //System.out.println(start+dest+date+ser+time);
        				  JOptionPane.showMessageDialog(f,"fill details","Alert",JOptionPane.WARNING_MESSAGE);
        			  }
    	    		  else {
    	    			  h = Integer.parseInt(ser);
    	    			  System.out.println(h);
    	    			  try {
    	    			  Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
    	    			  Statement statement = con.createStatement();
    	    			  String ql = "select max(book_id) from book";
    	    			  ResultSet s = statement.executeQuery(ql);
    	    			  while(s.next()) {
    	    				  p = s.getInt("max");
    	    			  }
    	    			  p++;
    	    			  bp = Integer.toString(p);
    	    			  System.out.println(bp);
    	    			  con.close();
    	    			  }
    	    			  catch(Exception cge) {
    	    				  System.out.println("1);");
    	    			  }
    	    			  try {
    	    				  Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
        	    			  Statement statement = con.createStatement();
    	    			  String sql = "select * from bus where start =? and dest =?";
    	    		     PreparedStatement pre = con.prepareStatement(sql);
    	    		     pre.setString(1,start);
    	    		     pre.setString(2,dest);
    	    		     ResultSet result  = pre.executeQuery();
    	    		     while(result.next()) {
    	    		    	 String b = result.getString("bid");
    	    		    	  a = Integer.parseInt(b);
    	    		     }
    	    		     con.close();
    	    			  }
    	    			  catch(Exception eft) {
    	    				  System.out.println("2");
    	    			  }
    	    			  try {
    	    				  Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
        	    			  Statement statement = con.createStatement();
    	    			  String sql = "select count(seats) from seat where bus_id =? and date =? and time";
    	    		     PreparedStatement pre = con.prepareStatement(sql);
    	    		     pre.setInt(1,a);
    	    		     pre.setString(2,date);
    	    		     pre.setString(3,time);
    	    		     ResultSet result  = pre.executeQuery();
    	    		     while(result.next()) {
    	    		    	 int b = result.getInt("count");
    	    		    	  b = 30-b;
    	    		    	  if(b<h) {
    	    		    		  sty = 1;
    	    		    	  }
    	    		    	  else
    	    		    	  {
    	    		    		  if(b==0) {
    	    		    			  sty = 2;
    	    		    		  }
    	    		    		  else
    	    		    		  {
    	    		    			  sty =0;
    	    		    		  }
    	    		    	  }
    	    		     }
    	    		     con.close();
    	    			  }
    	    			  catch(Exception eft) {
    	    				  System.out.println("2");
    	    			  }
    	    		     if(a!=0) {

	        				  new bus(u,a,date,h,time,bp,sohan,sty);
	        				  f.setVisible(false);
	        				  }
	        				  else {
	        					  System.out.println(a);
	        					  JOptionPane.showMessageDialog(f,"buses not available","Alert",JOptionPane.WARNING_MESSAGE);
	        				  }
    	    		    
    	    		  }
    	    	  
    				
    	  }
    	  };
    		DefaultListModel<String>li1 = new DefaultListModel<>();
    	  	DefaultListModel<String>li2 = new DefaultListModel<>();
    	  	DefaultListModel<String>li3 = new DefaultListModel<>();
    	  	
    	  //int k =0;
		  try {
 			  Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
 			  Statement statement = con.createStatement();
 			  String ql = "select start from bus";
 			  ResultSet serr = statement.executeQuery(ql);
 			  while(serr.next()) {
 				  String a = serr.getString("start");
 				  li1.addElement(a);
 				  String b = "-->";
 				  li3.addElement(b);
 				//  k++;
 			  }
 			  
 			 String rql = "select  dest from bus";
			  ResultSet serrt = statement.executeQuery(rql);
			  while(serrt.next()) {
				  String a = serrt.getString("dest");
				   li2.addElement(a);
			  }
 			  con.close();
 			  }
 			  catch(Exception cge) {
 				  //System.out.println("1);");
 			  }
		  JList<String>list1 = new JList<>(li1);
		  list1.setBounds(400,60,100,230);
		  
		  JList<String>list2 = new JList<>(li2);
		  list2.setBounds(550,60,100,230);
		  
		  JList<String>list3 = new JList<>(li3);
		  list3.setBounds(500,60,100,230);
		  f.add(list1);f.add(list2);f.add(list3);
    	  b = new JButton("book");
    	  b.setBounds(180,240,90,30);
    	  b.addActionListener(bus);
    	  
    	  f.add(l1); f.add(l2);f.add(l3);
    	  f.add(b);//f.add(t1);f.add(t2);
    	  f.add(l5);//f.add(t3);
    	  f.add(cb);
    	  f.add(l4);f.add(l6);f.add(l7);//f.add(t4);
    	  f.add(t5);
    	  //
    	 
    	  f.setVisible(true);
    	  f.setLayout(null);
      }
      public static void main(String[] args) {
    	  new booking("");
      }
}
