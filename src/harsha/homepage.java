package harsha;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class homepage {
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
    int cw =0;
    homepage(String u){
    	f3 = new JFrame("Homepage");
    	f3.setSize(600,600);
    	f3.setLayout(null);
    	f3.setVisible(true);
    	 try {
				Class.forName("org.postgresql.Driver");}
			catch(ClassNotFoundException ch) {
				System.out.println("class not found");
			}
			try {
			
			Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","Sai@15442");
			  Statement statement = con.createStatement();
			  String sql = "select * from login where email = ?";
			  PreparedStatement preparedstatement = con.prepareStatement(sql);
			  preparedstatement.setString(1,u);
			  ResultSet result = preparedstatement.executeQuery();
			  while(result.next()) {
				  fullname = result.getString("fullname");
				  password = result.getString("password");
			  }
			  con.close();
			}
			catch(Exception e) {
				System.out.print(e.getMessage());
			}
		
			l1 = new JLabel("Welcome ");
			l1.setBounds(10,10,60,30);
			l2 = new JLabel();
			l2.setBounds(70,10,200,30);
			l2.setText(fullname);
			f3.add(l1);
			f3.add(l2);
			
			ActionListener ticket = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new addticket(fullname);
				}
			};
			ActionListener cancel= new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new cancel(fullname);
				}
			};
			ActionListener seta = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new viewseat(fullname);
				}
			};
			mb = new JMenuBar();
			f3.setJMenuBar(mb);
	        t9 = new JTextField("Search bus number");
			ActionListener buuss = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String yut = t9.getText();
					int op = Integer.parseInt(yut);
					try {
		    			  Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","Sai@15442");
		    			  Statement statement = con.createStatement();
		    			  String ql = "select count(bid) from bus where bid =?";
		    			  PreparedStatement preparedstatement = con.prepareStatement(ql);
		    			  preparedstatement.setInt(1,op);
		    			  ResultSet result = preparedstatement.executeQuery();
		    			  while(result.next()) {
		    				 cw = result.getInt("count");
		    			  }
		    			
		    			  con.close();
		    			  }
		    			  catch(Exception cge) {
		    				  System.out.println("1);");
		    			  }
		    	
					if(cw==0) {
			    		JOptionPane.showMessageDialog(f3,"NO buses with bus_id "+op,"ALERT",JOptionPane.WARNING_MESSAGE);
			    	}
					else {
					new buus(u,op);}
				}
			};
			
			t9.setBounds(0,0,200,30);
			t9.addActionListener(buuss);
			JLabel l1 = new JLabel("'The world is a book and those who do not travel read only one page.keeping travelling with RedBus'");
			l1.setBounds(10,50,570,30);
			f3.add(l1);
			mb.add(t9);
			
			
			
			jm3 = new JMenu(" ticket details   ");
			mb.add(jm3);
			m6 = new JMenuItem("view tickets");
			m6.addActionListener(ticket);
			jm3.add(m6);
			
			
			jm2 = new JMenu(" seat availability ");
			mb.add(jm2);
			m8 = new JMenuItem("view seats");
			jm2.add(m8);
			m8.addActionListener(seta);
			jm1 = new JMenu("  cancel ticket");
			mb.add(jm1);
			m7= new JMenuItem("cancel tickets");
			m7.addActionListener(cancel);
			jm1.add(m7);
			b1 = new JButton("Book Tickets");
		
			b1.setBounds(200,100,200,30);
			ActionListener book = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new booking(fullname);
					f3.setVisible(false);
				}
			};
			b1.addActionListener(book);
			f3.add(b1);
			
			
			
			ActionListener view = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new view(fullname);
					f3.setVisible(false);
				}
			};
			ActionListener update = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new update(fullname);
					f3.setVisible(false);
				}
			};
			ActionListener log = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new signin();
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
							
							Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","Sai@15442");
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
					Connection con = DriverManager.getConnection ( "jdbc:postgresql://localhost:5432/bus_management", "postgres","Sai@15442");
					  Statement statement = con.createStatement();
					  String sql = "delete from login where fullname = ?";
					  PreparedStatement preparedstatement = con.prepareStatement(sql);
					  preparedstatement.setString(1,fullname);
					  if(pass.equals(password)) {
					  int i = preparedstatement.executeUpdate();
					  if(i!=0) {
					  JOptionPane.showMessageDialog(f3,"your account is deleted successfully");
					  f3.setVisible(false);
					  new signin();}}
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
    	new homepage("sai@gmail.com");
    }
}



