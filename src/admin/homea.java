package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import staff.chart;
import staff.home;
import staff.signins;
import staff.updates;
import staff.views;

public class homea {
	String fullname =" ";
    String password =" ";
    JFrame f3 ;
    JTextField t9;
    JLabel l1,l2 ;
    JMenu m,jm1,jm2,jm3,jm4,jm5,jm6,jm7,jm8,jm9,jm10,jm11;
    JMenuBar mb;
    JMenuItem m4,m1,m2,m3,m5,m6,m7,m8;
    JMenuItem m14,m11,m12,m13,m15,m16,m17;
    JMenuItem m24,m21,m22,m23,m25;
    String old_pass, new_pass,con_pass;
    JButton b1;
	homea(String u){
		f3 = new JFrame();
		f3.setVisible(true);
		f3.setLayout(null);
		f3.setSize(600,600);
		l1 = new JLabel("Welcome ");
		l1.setBounds(10,10,60,30);
		l2 = new JLabel();
		l2.setBounds(70,10,200,30);
		l2.setText(fullname);
		f3.add(l1);
		f3.add(l2);
		try {
			Class.forName("org.postgresql.Driver");}
		catch(ClassNotFoundException ch) {
			System.out.println("class not found");
		}
		try {
		
		Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
		  Statement statement = con.createStatement();
	     String sql = "select * from login where email = ?";
	  PreparedStatement preparedstatement = con.prepareStatement(sql);
	   preparedstatement.setString(1,u);
	   ResultSet rest = preparedstatement.executeQuery();
	   while(rest.next()) {
		   fullname = rest.getString("fullname");
		   password = rest.getString("password");
		   l2.setText(fullname);
	   }
	  con.close();
 }
		catch(Exception ch) {
			System.out.print(ch.getMessage());
		}
		ActionListener chart = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new charta(fullname);
			}
		};
		
		mb = new JMenuBar();
		f3.setJMenuBar(mb);
     
		JLabel l1 = new JLabel("'The world is a book and those who do not travel read only one page.keeping travelling with RedBus'");
		
		
		
		
		jm3 = new JMenu(" ticket details   ");
		mb.add(jm3);
		m6 = new JMenuItem("view tickets");
		m6.addActionListener(chart);
		jm3.add(m6);
		ActionListener addst = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addst(u);
			}
		};
		ActionListener addbu = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addbu(u);
			}
		};
		ActionListener rebu = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String reb = JOptionPane.showInputDialog(f3,"enter bus id");
				int bn = Integer.parseInt(reb);
				 try {
	     				Class.forName("org.postgresql.Driver");}
	     			catch(ClassNotFoundException ch) {
	     				System.out.println("class not found");
	     			}
	     			try {
	     			Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
	     			 Statement statement = con.createStatement();
	     			 String sql = "delete from bus where bid =? ";
	     			  PreparedStatement preparedstatement = con.prepareStatement(sql);
	     			preparedstatement.setInt(1,bn);
	     			  int q = preparedstatement.executeUpdate();
	     			 System.out.println(q);
	     			  JOptionPane.showMessageDialog(f3,"Removed","ALERT",JOptionPane.WARNING_MESSAGE);
	     			  new homea(u);
	    		 }
	     			catch(Exception ce) {
	     				System.out.println(ce.getMessage());
	     			}
			}
		};
		ActionListener rest = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String reb = JOptionPane.showInputDialog(f3,"enter staff email address");
				//int bn = Integer.parseInt(reb);
				 try {
	     				Class.forName("org.postgresql.Driver");}
	     			catch(ClassNotFoundException ch) {
	     				System.out.println("class not found");
	     			}
	     			try {
	     			Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
	     			 Statement statement = con.createStatement();
	     			 String sql = "delete from login where email =? and type = ?or type = ?";
	     			  PreparedStatement preparedstatement = con.prepareStatement(sql);
	     			preparedstatement.setString(1,reb);
	     			preparedstatement.setString(2,"conducter");
	     			preparedstatement.setString(3,"driver");
	     			  int q = preparedstatement.executeUpdate();
	     			 System.out.println(q);
	     			  JOptionPane.showMessageDialog(f3,"Removed","ALERT",JOptionPane.WARNING_MESSAGE);
	     			  new homea(u);
	    		 }
	     			catch(Exception ce) {
	     				System.out.println(ce.getMessage());
	     			}
			}
		};
		ActionListener recu = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String reb = JOptionPane.showInputDialog(f3,"enter customer email address");
				//int bn = Integer.parseInt(reb);
				 try {
	     				Class.forName("org.postgresql.Driver");}
	     			catch(ClassNotFoundException ch) {
	     				System.out.println("class not found");
	     			}
	     			try {
	     			Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
	     			 Statement statement = con.createStatement();
	     			 String sql = "delete from login where email =? and type is null";
	     			  PreparedStatement preparedstatement = con.prepareStatement(sql);
	     			preparedstatement.setString(1,reb);
	     			  int q = preparedstatement.executeUpdate();
	     			 System.out.println(q);
	     			  JOptionPane.showMessageDialog(f3,"Removed","ALERT",JOptionPane.WARNING_MESSAGE);
	     			  new homea(u);
	    		 }
	     			catch(Exception ce) {
	     				System.out.println(ce.getMessage());
	     			}
			}
		};
		jm4 = new JMenu("ADD/REMOVE");
		mb.add(jm4);
		m11 = new JMenuItem("Add bus");
		m11.addActionListener(addbu);
		m12 = new JMenuItem("Add staff");
		m12.addActionListener(addst);
		m13 = new  JMenuItem("remove bus");
		m13.addActionListener(rebu);
		m14 = new JMenuItem("remove staff");
		m14.addActionListener(rest);
		m15 = new JMenuItem("remove customer");
		m15.addActionListener(recu);
		jm4.add(m11);jm4.add(m12);jm4.add(m13);jm4.add(m14);jm4.add(m15);
		mb.add(jm4);
		m6.addActionListener(chart);
		jm3.add(m6);
		ActionListener view = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new viewa(fullname);
				f3.setVisible(false);
			}
		};
		ActionListener update = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new updatea(fullname);
				f3.setVisible(false);
			}
		};
		ActionListener log = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new signina();
				f3.setVisible(false);
			}
		};
		ActionListener pass = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				 old_pass=JOptionPane.showInputDialog(f3, "old password");
				 if(old_pass.equals(password)) {
				 new_pass=JOptionPane.showInputDialog(f3, "new password");
				 con_pass=JOptionPane.showInputDialog(f3, "confirm password");
				 if(new_pass.equals(con_pass)) {
			    	 try {
							Class.forName("org.postgresql.Driver");}
						catch(ClassNotFoundException ch) {
							System.out.println("class not found");
						}
						try {
						
						Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
						  Statement statement = con.createStatement();
					     String sql = "update login set password = ? where fullname = ?";
					  PreparedStatement preparedstatement = con.prepareStatement(sql);
					   preparedstatement.setString(1,new_pass);
					  preparedstatement.setString(2,fullname);
					  int i = preparedstatement.executeUpdate();
					  JOptionPane.showMessageDialog(f3,"password update successfully");
					  con.close();
				 }
						catch(Exception ch) {
							System.out.print(ch.getMessage());
						}
				 }
				 else {
					 JOptionPane.showMessageDialog(f3, " wrong confirmation","warning",JOptionPane.WARNING_MESSAGE);
				 }
				 }
				 else
				 {
					 System.out.println(password+" "+old_pass);
					 JOptionPane.showMessageDialog(f3, "wrong password","warning",JOptionPane.WARNING_MESSAGE);
				 }
			
		}};
		ActionListener delete = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				String pass= JOptionPane.showInputDialog(f3,"enter password");
				try {
					Class.forName("org.postgresql.Driver");}
				catch(ClassNotFoundException ch) {
					System.out.println("class not found");
				}
				try {
				Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","sohan2003");
				  Statement statement = con.createStatement();
				  String sql = "delete from login where fullname = ?";
				  PreparedStatement preparedstatement = con.prepareStatement(sql);
				  preparedstatement.setString(1,fullname);
				  if(pass.equals(password)) {
				  int i = preparedstatement.executeUpdate();
				  if(i!=0) {
				  JOptionPane.showMessageDialog(f3,"your account is deleted successfully");
				  f3.setVisible(false);
				  new signina();
				  }}
				  else {
					  JOptionPane.showMessageDialog(f3,"wrong password","warning",JOptionPane.WARNING_MESSAGE);
				  }
				  con.close();
				 
			}
				catch(Exception ch) {
					System.out.print(ch.getMessage());
				}
	    	}
		};
		
		
		m = new JMenu(" Profile ");
		m5 = new JMenuItem("change password");
       m5.addActionListener(pass);
		 m4 = new JMenuItem("view profile");
		 m4.addActionListener(view);
		m1= new JMenuItem("update profile");
	m1.addActionListener(update);
		 m2= new JMenuItem("delete account");
		 m2.addActionListener(delete);
		m3= new JMenuItem("Log out");
	 m3.addActionListener(log);
		m.add(m4);m.add(m1);m.add(m2);m.add(m5);m.add(m3);
		mb.add(m);
		
	}
   public static void main(String[] args) {
	   new homea("nag1978@gmail.com");
   }
}
