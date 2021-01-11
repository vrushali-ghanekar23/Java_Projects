import java.awt.*;   
import javax.swing.*;
import java.awt.event.*; 
import java.util.*; 
import java.sql.*;
import javax.swing.table.*;
import java.io.*;



 
class server_side {  

	
	 JFrame frame;
	private JMenuBar mb;
	private JMenu menu;
	private JMenu submenu;
	private Icon img,img1;
	private JLabel background,l1,l2,imge;
	private JButton btn1;
	private Panel panel1,panel2,panel3,panel4;
	private JButton btn_icon;
	String  btn_name; 
	JLabel cnt_of_no_usr,user_1,user_2,user_3,queue_display,queue_display1;
	JWindow w;
	JScrollPane pg=null;
	
	
    public server_side()
	{  
         
		
		
		Database db = new Database();
		

		 
        frame  = new JFrame("Welcome to server_side");  
        frame.setSize(1000, 1000);  
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
		
		Font font1 = new Font("TimesNewRoman",Font.BOLD,20);
		Font font2 = new Font("Modern No. 20",Font.BOLD,15);
		Font font3 = new Font("Modern No. 20",Font.BOLD,20);
		
		Color panel1_bck_clr = Color.decode("#5dade2");	
		
        panel1 = new Panel(); 
		//panel1.setBackground(panel1_bck_clr);
		panel1.setLayout(null);
		
		panel2 = new Panel();  
		panel2.setLayout(null);
		
		panel3 = new Panel();  
		panel3 .setLayout(null);
		
		panel4 = new Panel();  
		panel4 .setLayout(null);
		
		
		JLabel heding = new JLabel("INFORMATION ABOUT DATABASE");
		heding.setBounds(10,30,350,30);
		heding.setFont(font1);
		panel1.add(heding);
		
		JLabel type_of_db = new JLabel("Type Of Database : MYSQL");
		type_of_db.setBounds(10,70,280,30);
		type_of_db.setForeground(Color.BLACK);
		type_of_db.setFont(font2);
		panel1.add(type_of_db);
		
		JLabel name_of_db = new JLabel("Name Of Databse : CINEMAX");
		name_of_db.setBounds(10,110,280,30);
		name_of_db.setForeground(Color.BLACK);
		name_of_db.setFont(font2);
		panel1.add(name_of_db);
		
		JLabel no_of_tbl = new JLabel("Number Of Table : 2");
		no_of_tbl.setBounds(10,150,280,30);
		no_of_tbl.setForeground(Color.BLACK);
		no_of_tbl.setFont(font2);
		panel1.add(no_of_tbl);
		
		JLabel name_of_tbl = new JLabel("Name Of Table : CINEMAX,BACK_UP_CINEMAX");
		name_of_tbl.setBounds(10,190,380,30);
		name_of_tbl.setForeground(Color.BLACK);
		name_of_tbl.setFont(font2);
		panel1.add(name_of_tbl);
	
		
		JLabel heading_server = new JLabel("INFORMATION ABOUT SERVER");
		heading_server.setBounds(250,30,350,30);
		heading_server.setFont(font1);
		panel3.add(heading_server);
		
		
		JLabel name_of_server = new JLabel("Name Of Server : LAPTOP-2GT6EOE0(LOCALHOST)");
		name_of_server.setBounds(260,70,380,30);
		name_of_server.setForeground(Color.BLACK);
		name_of_server.setFont(font2);
		panel3.add(name_of_server);
		
		JLabel ip_add_of_server = new JLabel("IP Address Of Server : 172.0.0.0");
		ip_add_of_server.setBounds(260,110,380,30);
		ip_add_of_server.setForeground(Color.BLACK);
		ip_add_of_server.setFont(font2);
		panel3.add(ip_add_of_server);
		
		JLabel typ_of_server = new JLabel("Type Of Server : MULTIUSER(MULTITHREADED)");
		typ_of_server.setBounds(260,150,380,30);
		typ_of_server.setForeground(Color.BLACK);
		typ_of_server.setFont(font2);
		panel3.add(typ_of_server);
		
		JLabel max_range_of_user = new JLabel("Maximum Range Of User : 3");
		max_range_of_user.setBounds(260,190,380,30);
		max_range_of_user.setForeground(Color.BLACK);
		max_range_of_user.setFont(font2);
		panel3.add(max_range_of_user);
		
		
		JLabel heading_abt_user = new JLabel("INFORMATION ABOUT JOIN USER");
		heading_abt_user.setBounds(10,30,380,30);
		heading_abt_user.setFont(font1);
		panel2.add(heading_abt_user);
		
		JLabel no_of_usr = new JLabel("Currently Joined Number Of User :");
		no_of_usr.setBounds(10,70,250,30);
		no_of_usr.setForeground(Color.BLACK);
		no_of_usr.setFont(font2);
		panel2.add(no_of_usr);
		

		
		cnt_of_no_usr = new JLabel("");
		cnt_of_no_usr.setBounds(260,70,380,30);
		cnt_of_no_usr.setForeground(Color.RED);
		cnt_of_no_usr.setFont(font3);
		panel2.add(cnt_of_no_usr);
		
		
		JLabel name_of_usr = new JLabel("Joined User's Name :");
		name_of_usr.setBounds(10,110,250,30);
		name_of_usr.setForeground(Color.BLACK);
		name_of_usr.setFont(font3);
		panel2.add(name_of_usr);
		
		user_1 = new JLabel("");
		user_1.setBounds(25,140,100,30);
		user_1.setForeground(Color.GREEN);
		user_1.setFont(font3);
		panel2.add(user_1);
		
		user_2 = new JLabel("");
		user_2.setBounds(25,160,100,30);
		user_2.setForeground(Color.GREEN);
		user_2.setFont(font3);
		panel2.add(user_2);
		
		user_3 = new JLabel("");
		user_3.setBounds(25,180,100,30);
		user_3.setForeground(Color.GREEN);
		user_3.setFont(font3);
		panel2.add(user_3);
		
		queue_display1 = new JLabel("Queue:");
		queue_display1.setBounds(25,220,100,30);
		queue_display1.setForeground(Color.BLACK);
		queue_display1.setFont(font3);
		queue_display1.setVisible(false);
		panel2.add(queue_display1);
		
		
		queue_display = new JLabel("");
		queue_display.setBounds(120,220,100,30);
		queue_display.setForeground(Color.BLUE);
		queue_display.setFont(font3);
		panel2.add(queue_display);
		
		
		JLabel heading_db_opt = new JLabel("DATABSE OPERATION");
		heading_db_opt.setBounds(280,30,300,30);
		heading_db_opt.setFont(font1);
		panel4.add(heading_db_opt);
		
		
		JButton book= new JButton("Show Booked Seats");
		book.setBounds(30,150,280,40);
		book.setForeground(Color.WHITE);
		book.setBackground(Color.BLACK);
		book.setFont(font2);
		panel4.add(book);
		
		JButton cancle= new JButton("Show Cancealled Seats");
		cancle.setBounds(30,200,280,40);
		cancle.setForeground(Color.WHITE);
		cancle.setBackground(Color.BLACK);
		cancle.setFont(font2);
		panel4.add(cancle);
		
		
		JButton show= new JButton("Show Details Of Perticular User");
		show.setBounds(30,250,280,40);
		show.setForeground(Color.WHITE);
		show.setBackground(Color.BLACK);
		show.setFont(font2);
		panel4.add(show);
		
		
		
					JTextField mobileno = new JTextField("Enter Your Mobile Number");
					mobileno.setBounds(450,150,280,50);
					mobileno.setForeground(Color.GRAY);
					mobileno.setColumns(10);
					mobileno.setVisible(false);
					panel4.add(mobileno);
					
					JButton submit= new JButton("Submit");
					submit.setBounds(520,230,150,40);
					submit.setForeground(Color.WHITE);
					submit.setBackground(Color.BLACK);
					submit.setFont(font2);
					submit.setVisible(false);
					panel4.add(submit);
					
					JButton clear= new JButton("Clear");
					clear.setBounds(500,340,150,40);
					clear.setForeground(Color.WHITE);
					clear.setBackground(Color.BLACK);
					clear.setFont(font2);
					clear.setVisible(false);
					panel4.add(clear);
					
		
		show.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					mobileno.setVisible(true);
					submit.setVisible(true);
					
				}
			});	
		
			book.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
							String [] book_seat = db.retrived_all_data("B");
							clear.setVisible(true);
							custom_mes_box(table_creation(book_seat));
							w.setVisible(true);					
					
				}
			});
			
			cancle.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					
							String [] cancle_seat = db.retrived_all_data("C");
							clear.setVisible(true);
							custom_mes_box(table_creation(cancle_seat));
							w.setVisible(true);					
					
				}
			});
					
				submit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					
					if(mobileno.getText().equals("Enter Your Mobile Number"))
					{
						JOptionPane.showMessageDialog(frame,"Fill all details..","Alert",JOptionPane.WARNING_MESSAGE);	
					
					}
					if(! mobileno.getText().equals("Enter Your Mobile Number"))
					{
						String mobile = mobileno.getText();
						
					if(mobile.length()>10 || mobile.length()<10 || mobile.matches(("^[a-zA-Z]*$")))
					{	
								JOptionPane.showMessageDialog(frame,"Enter valid Mobile Number","Alert",JOptionPane.WARNING_MESSAGE);	
					}
					else
					{
							mobileno.setVisible(false);
							submit.setVisible(false);
					
							String[]data_based_on_mobile=db.retrived_data_pericular_cutomer(mobile);
							clear.setVisible(true);
							custom_mes_box(table_creation(data_based_on_mobile));
							w.setVisible(true);
							
							mobileno.setText("Enter Your Mobile Number");
						}

						
					}	
				}
			});	
		
		
		clear.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					w.setVisible(false);
					clear.setVisible(false);
				}
			});	
		
		
		
		
		
		
		
		
		
		mobileno.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent e)
			{
				if (mobileno.getText().equals("Enter Your Mobile Number"))
				{
					mobileno.setText("");
					mobileno.setForeground(Color.BLACK);
					
				}
			}
			
			public void focusLost(FocusEvent e)
			{
				if (mobileno.getText().isEmpty())
				{
					mobileno.setText("Enter Your Mobile Number");
					mobileno.setForeground(Color.GRAY);
				}
			}
		});
		
		
			frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent evt)
			{
				System.exit(0);
			}
			
		});
		
		
     
		
		JSplitPane top_pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panel1,panel2);
		top_pane.setOrientation(SwingConstants.HORIZONTAL);
		top_pane.setDividerSize(10);
		top_pane.setDividerLocation(250);
		
		JSplitPane bottom_pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panel3,panel4);
		bottom_pane.setOrientation(SwingConstants.HORIZONTAL);
		bottom_pane.setDividerLocation(250);
		bottom_pane.setDividerSize(10);
		
	
		JSplitPane main_pane =  new JSplitPane(JSplitPane.VERTICAL_SPLIT,top_pane,bottom_pane);
		main_pane.setOrientation(SwingConstants.VERTICAL);
		main_pane.setDividerLocation(380);
		main_pane.setDividerSize(10);
		 frame.add(main_pane);
		 
		
		panel1.setVisible(true);
		panel2.setVisible(true);
		frame.setVisible(true);  
		
		
		
		
	}
	
	void custom_mes_box(JScrollPane p)
	{
		 w = new JWindow();
		w.add(p);
		w.setSize(455,200);
		w.setLocation(750,400);
		w.show();
	}
	
	JScrollPane table_creation(String arg[])
	{
						DefaultTableModel model = new DefaultTableModel();
						JTable tbl = new JTable(model);
						model.addColumn("Row Name");
						model.addColumn("Column NO.");
						model.addColumn("Mobile NO.");
						model.addColumn("Status");
						model.addColumn("Booking Date");
						model.addColumn("Booking Time");
						
						
						for(int i=0;i<arg.length;i=i+6)
						{
							model.addRow(new Object[]{arg[i],arg[i+1],arg[i+2],arg[i+3],arg[i+4],arg[i+5]});
						}
							tbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	
							pg = new JScrollPane(tbl);
							tbl.setPreferredScrollableViewportSize(new Dimension(20,50));
			return pg;
	}
		
	
	public static void main(String ar[])
	{
		server_side j = new server_side();
		
	}
}
  
 
 
  
 
 
