import java.awt.*;   
import javax.swing.*;
import java.awt.event.*; 
import java.util.*; 
import java.sql.*;
import javax.swing.table.*;
import java.io.*;



 
public class BookMovie {  

	
	final JFrame frame;
	private JMenuBar mb;
	private JMenu menu;
	private JMenu submenu;
	private Icon img,img1;
	private JLabel background,l1,l2,imge;
	private JButton btn1;
	private Panel panel1,panel2;
	
	String  btn_name,return_string; 
	JLabel[] btn_icon = new JLabel[80]; 
	Icon icon5,icon6,icon_refresh;
	Color panel1_bck_clr = Color.decode("#E8FFFF");	
	Color panel2_bck_clr = Color.decode("#f3e5f5");	
	Color btn_clr = Color.decode("#E8FFFF");
	Color btn1_clr = Color.decode("#05386B");
	Color text_clr = Color.decode("#05386B");
	
    public BookMovie()
	{  
         icon5 = new ImageIcon("353396-48.png");
		icon6 = new ImageIcon("353396-48 (2).png");
		icon_refresh = new ImageIcon("2044237-48 (1).png");
		
		Database db = new Database();
		cinemax1 c1 = new cinemax1();
		
		String[] datetime = c1.date_time(); 
		
		String [] rowncol=db.getrowncol("B");
		String [] book_sest_db = new String[((rowncol.length)/2)]; 
		int n=0;
		
		
		
		for(int i=0;i<rowncol.length;i=i+2)
		{
			book_sest_db [n] = (rowncol[i]+rowncol[i+1]);
			n++;
		}
		

		 
        frame  = new JFrame("Bookings");  
        frame.setSize(1000, 1000);  
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setLayout(new GridLayout(1,3));
		
		Font font = new Font("Aparajita",Font.BOLD,15);
		Font font1 = new Font("Aparajita",Font.BOLD,20);
		
      
        panel1 = new Panel();  	
		panel1.setLayout(null);
		panel1.setBackground(panel1_bck_clr);
		
		panel2 = new Panel();  
		panel2.setLayout(null);
		
		
		
		JLabel heding = new JLabel("MENU:");
		heding.setFont(font1);
		heding.setForeground(text_clr);
		heding.setBounds(10,30,150,30);
		
		JRadioButton book_seat = new JRadioButton("1.BOOK SEAT");
		JRadioButton cancle_seat = new JRadioButton("2.CANCALL SEAT");
		JRadioButton show_deatls  = new JRadioButton("3.SHOW MY DETAILS");
		
		book_seat.setBounds(10,60,170,30);
		cancle_seat.setBounds(10,90,170,30);
		show_deatls.setBounds(10,120,170,30);
		
		book_seat.setActionCommand("book seat");
		cancle_seat.setActionCommand("cancle seat");
		show_deatls.setActionCommand("show deatils");
		book_seat.setSelected(true);
		
		book_seat.setBackground(panel1_bck_clr);
		cancle_seat.setBackground(panel1_bck_clr);
		show_deatls.setBackground(panel1_bck_clr);
		
		book_seat.setForeground(text_clr);
		cancle_seat.setForeground(text_clr);
		show_deatls.setForeground(text_clr);
		
		book_seat.setFont(font);
		cancle_seat.setFont(font);
		show_deatls.setFont(font);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(book_seat);
		bg.add(cancle_seat);
		bg.add(show_deatls);
		
		JTextField roww = new JTextField("Enter Row Name");
		roww.setBounds(10,200,280,50);
		roww.setForeground(Color.GRAY);
		roww.setFont(font);
		
		
		JTextField coll = new JTextField("Enter Columan Number");
		coll.setBounds(10,290,280,50);
		coll.setForeground(Color.GRAY);
		coll.setFont(font);
		
		
		
		JTextField mobileno_t = new JTextField("Enter Your Mobile Number");
		mobileno_t.setBounds(10,380,280,50);
		mobileno_t.setFont(font);
		mobileno_t.setForeground(Color.GRAY);
		
		JTextField mobileno = new JTextField("Enter Your Mobile Number");
		mobileno.setBounds(10,200,280,50);
		mobileno.setForeground(Color.GRAY);
		mobileno.setColumns(10);
		mobileno.setFont(font);
		
		JButton book= new JButton("Book Seat");
		book.setBounds(10,460,280,50);
		book.setFont(font1);
		book.setForeground(Color.WHITE);
		book.setBackground(btn1_clr);
		
		JButton cancle= new JButton("Cancell Seat");
		cancle.setBounds(10,460,280,50);
		cancle.setFont(font1);
		cancle.setForeground(Color.WHITE);
		cancle.setBackground(btn1_clr);
		
		JButton show= new JButton("Show Details");
		show.setBounds(10,290,280,50);
		show.setFont(font1);
		show.setForeground(Color.WHITE);
		show.setBackground(btn1_clr);
		
		JLabel note1 = new JLabel("NOTE:Your Mobile Number Is Required While");
		note1.setBounds(10,540,280,50);
		note1.setFont(font);
		note1.setForeground(text_clr);
		
		JLabel note2 = new JLabel("Canclling Seat.Before Booking Plz Refresh Page.");
		note2.setBounds(10,560,280,50);
		note2.setFont(font);
		note2.setForeground(text_clr);
		
		
		
		JLabel label_img1 = new JLabel("AVAILABEL SITS");
		label_img1.setIcon(icon5);
		label_img1.setBounds(250,600,250,50);
		label_img1.setForeground(text_clr);
		label_img1.setFont(font);
		panel2.add(label_img1);
		
		
		JLabel label_img2 = new JLabel("BOOKED SITS");
		label_img2.setIcon(icon6);
		label_img2.setBounds(450,600,250,50);
		label_img2.setForeground(text_clr);
		label_img2.setFont(font);
		panel2.add(label_img2);
		
		JButton refresh= new JButton();
		refresh.setBounds(650,610,50,30);
		refresh.setIcon(icon_refresh);
		refresh.setToolTipText("Refresh");
		refresh.setBackground(btn_clr);
		panel2.add(refresh);
		
		
		
		
		panel1.add(heding);
		panel1.add(book_seat);
		panel1.add(cancle_seat);
		panel1.add(show_deatls);
		panel1.add(roww);
		panel1.add(coll);
		panel1.add(mobileno_t);
		panel1.add(book);
		panel1.add(note1);
		panel1.add(note2);
	
		
		
			
			book.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					
					
					if(mobileno_t.getText().equals("Enter Your Mobile Number")|| roww.getText().equals("Enter Row Name") || coll.getText().equals("Enter Columan Number"))
					{
						JOptionPane.showMessageDialog(frame,"Fill all details..","Alert",JOptionPane.WARNING_MESSAGE);	
					
					}
					if(! mobileno_t.getText().equals("Enter Your Mobile Number")|| !roww.getText().equals("Enter Row Name") || !coll.getText().equals("Enter Columan Number"))
					{
						String rowname = roww.getText();
						String collname = coll.getText();
						String mobile = mobileno_t.getText();
						
					if(mobile.length()>10 || mobile.length()<10 || mobile.matches(("^[a-zA-Z]*$")))
					{	
								JOptionPane.showMessageDialog(frame,"Enter valid Mobile Number","Alert",JOptionPane.WARNING_MESSAGE);	
					}
					else if(rowname.length()>1 || rowname.matches(("^[0-9]*$")) || rowname.matches(("^[k-zK-Z]*$")))
					{
						JOptionPane.showMessageDialog(frame,"Enter Valid Row Name","Alert",JOptionPane.WARNING_MESSAGE);	
					}
					else if(collname.length()>1 || collname.matches(("^[a-zA-Z]*$")) || collname.compareTo("8")>0)
					{
						JOptionPane.showMessageDialog(frame,"Enter Valid Coulumn Number","Alert",JOptionPane.WARNING_MESSAGE);	
					}
					
					else
					{
						String name_book_seat = (rowname+collname);
						String[] book_seat_check = getseats("B");
						int flag =0;
						for(int i=0;i<book_seat_check.length;i++)
						{
							if(book_seat_check[i].equals(name_book_seat))
							{
								flag=1;
								break;
							}
						}
						if(flag ==1)
						{
						
						JOptionPane.showMessageDialog(frame,"This seat is alreday BOOK please try for another seat","Alert",JOptionPane.WARNING_MESSAGE);	
						}
						else
						{
							int k=0;
						while(k<btn_icon.length)
						{
							if(name_book_seat.equals((btn_icon[k]).getName()))
							{
									btn_icon[k].setIcon(icon6);
									db.db_Booked(rowname,Integer.parseInt(collname),mobile,"BOOKED",datetime[0],datetime[1]);
									JOptionPane.showMessageDialog(frame,"SEAT SUCCESSFULLY BOOKED.. ","Successs",JOptionPane.QUESTION_MESSAGE);	
							}
							
							k++;
						  }
							
						}
		
						panel2.revalidate();
						panel2.repaint();
						roww.setText("Enter Row Name");
						coll.setText("Enter Columan Number");
						mobileno_t.setText("Enter Your Mobile Number");
						
					}						
					
					}	
				}
			});	
			
			cancle.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(mobileno_t.getText().equals("Enter Your Mobile Number")|| roww.getText().equals("Enter Row Name") || coll.getText().equals("Enter Columan Number"))
					{
						JOptionPane.showMessageDialog(frame,"Fill all details..","Alert",JOptionPane.WARNING_MESSAGE);	
					
					}
					if(! mobileno_t.getText().equals("Enter Your Mobile Number")|| !roww.getText().equals("Enter Row Name") || !coll.getText().equals("Enter Columan Number"))
					{
						String rowname = roww.getText();
						String collname = coll.getText();
						String mobile = mobileno_t.getText();
						
					if(mobile.length()>10 || mobile.length()<10 || mobile.matches(("^[a-zA-Z]*$")))
					{	
								JOptionPane.showMessageDialog(frame,"Enter valid Mobile Number","Alert",JOptionPane.WARNING_MESSAGE);	
					}
					else if(rowname.length()>1 || rowname.matches(("^[0-9]*$")))
					{
						JOptionPane.showMessageDialog(frame,"Enter Valid Row Name","Alert",JOptionPane.WARNING_MESSAGE);	
					}
					else if(collname.length()>1 || collname.matches(("^[a-zA-Z]*$")) || collname.compareTo("8")>0)
					{
						JOptionPane.showMessageDialog(frame,"Enter Valid Coulumn Number","Alert",JOptionPane.WARNING_MESSAGE);	
					}
					else
					{
						String name_book_seat = (rowname+collname);
						String db_phon = db.retun_phon(((rowname.charAt(0))-'0'),Integer.parseInt(collname));
						int k=0;
						while(k<btn_icon.length)
						{
							if(name_book_seat.equals((btn_icon[k]).getName()))
							{
								
								if(icon6.equals((btn_icon[k]).getIcon()))
								{
									if(db_phon.equals(mobile))
									{
										int selection = JOptionPane.showConfirmDialog(null,"MOBILE NUMBER CONFIRMED !! "+"\n"+"DO YOU REALLY WANT TO CANCEL THE BOOKING ?","Confirmation",JOptionPane.YES_NO_OPTION);	
										if(selection == JOptionPane.YES_OPTION)
										{
											btn_icon[k].setIcon(icon5);
											db.deletedata(rowname.charAt(0),Integer.parseInt(collname),mobile,"Canclladed",datetime[0],datetime[1]);
											JOptionPane.showMessageDialog(frame,"SEAT CANSALLATION DONE SUCCESSFULLY.. ","Successs",JOptionPane.QUESTION_MESSAGE);	
										}	
									}
									else
									{
										JOptionPane.showMessageDialog(frame,"INCORRECT MOBILE NUMBER\n PLEASE TRY AGAIN ! ","Alert",JOptionPane.QUESTION_MESSAGE);	
									}
								}
								else
								{
									JOptionPane.showMessageDialog(frame,"SEAT NOT BOOKED !!","Alert",JOptionPane.WARNING_MESSAGE);	

								}
							}
							k++;
						}
						
						panel2.revalidate();
						panel2.repaint();
						roww.setText("Enter Row Name");
						coll.setText("Enter Columan Number");
						mobileno_t.setText("Enter Your Mobile Number");
					}						
					
					}	
				}
			});	
			
			
			show.addActionListener(new ActionListener()
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
						int index=0;
						DefaultTableModel model = new DefaultTableModel();
						JTable tbl = new JTable(model);
						model.addColumn("Row Name");
						model.addColumn("Column NO.");
						model.addColumn("Mobile NO.");
						model.addColumn("Status");
						model.addColumn("Booking Date");
						model.addColumn("Booking Time");
						
						String[]data_based_on_mobile=db.retrived_data_pericular_cutomer(mobile);
						for(int i=0;i<data_based_on_mobile.length;i=i+6)
						{
							model.addRow(new Object[]{data_based_on_mobile[i],data_based_on_mobile[i+1],data_based_on_mobile[i+2],data_based_on_mobile[i+3],data_based_on_mobile[i+4],data_based_on_mobile[i+5]});
						}
							tbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	
							JScrollPane pg = new JScrollPane(tbl);
							tbl.setPreferredScrollableViewportSize(new Dimension(20,50));
							pg.setBounds(2,380,290,150);
							panel1.add(pg);
							
							JOptionPane.showMessageDialog(null,pg);
							mobileno.setText("Enter Your Mobile Number");
							
							
					}						
					
					}	
				}
			});	
			
			refresh.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
				
					
			
					String [] book_sest_db = getseats("B") ; 
					String [] cancle_sest_db = getseats("C") ; 
					int t=0;
					while(t<btn_icon.length)
					{
						
					
						for(int i=0;i<book_sest_db.length;i++)
						{
							if(((btn_icon[t]).getName()).equals(book_sest_db[i]))
							{
								btn_icon[t].setIcon(icon6);
								panel2.revalidate();
								panel2.repaint();
							}
						}
						for(int j=0;j<cancle_sest_db.length;j++)
						{
							if(((btn_icon[t]).getName()).equals(cancle_sest_db[j]))
							{
								btn_icon[t].setIcon(icon5);
								panel2.revalidate();
								panel2.repaint();
							}
						}
							
			
					t++;
					}	
				}
			});	
	
		
		mobileno_t.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent e)
			{
				if (mobileno_t.getText().equals("Enter Your Mobile Number"))
				{
					mobileno_t.setText("");
					mobileno_t.setForeground(Color.BLACK);
					
				}
			}
			
			public void focusLost(FocusEvent e)
			{
				if (mobileno_t.getText().isEmpty())
				{
					mobileno_t.setText("Enter Your Mobile Number");
					mobileno_t.setForeground(Color.GRAY);
				}
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
		
		coll.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent e)
			{
				if (coll.getText().equals("Enter Columan Number"))
				{
					coll.setText("");
					coll.setForeground(Color.BLACK);
					
				}
			}
			
			public void focusLost(FocusEvent e)
			{
				if (coll.getText().isEmpty())
				{
					coll.setText("Enter Columan Number");
					coll.setForeground(Color.GRAY);
				}
			}
		});
		
		roww.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent e)
			{
				if (roww.getText().equals("Enter Row Name"))
				{
					roww.setText("");
					roww.setForeground(Color.BLACK);
					
				}
			}
			
			public void focusLost(FocusEvent e)
			{
				if (roww.getText().isEmpty())
				{
					roww.setText("Enter Row Name");
					roww.setForeground(Color.GRAY);
				}
			}
		});
		
		
			book_seat.addItemListener(new ItemListener()
			{
				public void itemStateChanged(ItemEvent e)
				{
					if(book_seat.isSelected())
					{
						panel1.add(book_seat);
						panel1.add(cancle_seat);
						panel1.add(show_deatls);
						panel1.add(roww);
						panel1.add(coll);
						panel1.add(mobileno_t);
						panel1.add(book);
						panel1.add(note1);
						panel1.add(note2);
						
						panel1.remove(cancle);
						panel1.remove(show);
						panel1.remove(mobileno);
						
						panel1.revalidate();
						panel1.repaint();
					}
					
				}
			});
			
			cancle_seat.addItemListener(new ItemListener()
			{
				public void itemStateChanged(ItemEvent e)
				{
					if(cancle_seat.isSelected())
					{
						panel1.remove(book);
						panel1.remove(show);
						

						
						panel1.add(book_seat);
						panel1.add(cancle_seat);
						panel1.add(show_deatls);
						panel1.add(roww);
						panel1.add(coll);
						panel1.add(mobileno_t);
						panel1.add(note1);
						panel1.add(note2);
						
						panel1.revalidate();
						panel1.repaint();
						panel1.add(cancle);
					}
					
				}
			});
			
			show_deatls.addItemListener(new ItemListener()
			{
				public void itemStateChanged(ItemEvent e)
				{
					if(show_deatls.isSelected())
					{
						panel1.add(book_seat);
						panel1.add(cancle_seat);
						panel1.add(show_deatls);
						
						panel1.remove(roww);
						panel1.remove(coll);
						panel1.remove(mobileno_t);
						panel1.remove(book);
						panel1.remove(note1);
						panel1.remove(note2);
						panel1.remove(cancle);
						panel1.revalidate();
						panel1.repaint();
						
						panel1.add(mobileno);
						panel1.add(show);
						
					}
					
				}
			});
			
			
        JSplitPane splitPane = new JSplitPane(); 
		splitPane.setSize(1000,1000);
		splitPane.setDividerSize(10);
		splitPane.setDividerLocation(300);
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setLeftComponent(panel1);
        splitPane.setRightComponent(panel2);
        frame.getContentPane().add(splitPane);  
		
		panel1.setVisible(true);
		panel2.setVisible(true);
		frame.setVisible(true);  
		
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent evt)
			{
				frame.setVisible(false);
			}
			
		});
		
		
	}
	
	void display()
	{
		
		String [] book_sest_db = getseats("B") ; 
		panel2.setBackground(panel2_bck_clr);
		char r = 'A';
		int top1 = 30;
		
		for(int i=0; i<10;i++)
		{
			JLabel row = new JLabel();
			row.setForeground(text_clr);
			String s = Character.toString(r);
			row.setText(s); 
			row.setBounds(45,top1,50,50);
			panel2.add(row);
			r++;
			top1= top1+55;
		}
		int space1 = 115;
		for(int i= 1;i<9;i++)
		{
			JLabel col = new JLabel();
			col.setForeground(text_clr);
			String s = Integer.toString(i);
			col.setText(s);
			col.setBounds(space1, 0, 50,50);
			panel2.add(col);
			space1 = space1+100;
		}
		
		//JLabel btn_icon=null;				

		int top = 30;	
		int count = 0;
		char rname= 'A';
		String rrname=null;
		//JLabel[] btn_icon = new JLabel[80]; 
		int t=0;
		for(int i=0 ;i<10;i++)
		{
			int space = 10;
			rrname = Character.toString(rname);
			count =1;
			
			for(int j =0 ;j<8;j++)
			{
				
				String c_name = Integer.toString(count);
				String final_name = (rrname+c_name);
				 btn_icon[t] = new JLabel();
				btn_icon[t].setIcon(icon5);
				btn_icon[t].setName(final_name);
				btn_icon[t].setBounds(space*10,top,50,50);
				panel2.add(btn_icon[t]);
				space=space+10;
				
					for(int k=0;k<book_sest_db.length;k++)
						
						{
							if(final_name.equals(book_sest_db[k]) )
							{
						
								btn_icon[t].setIcon(icon6);
								panel2.revalidate();
								panel2.repaint();
						
							}
						}
						
					
				count++;
				t++;
			}
			top = top+55;
			rname++;
			
		}
		
			
	}
		
		String[] getseats(String status)
		{
			Database db = new Database();
		
			String [] rowncol=db.getrowncol(status);
			String [] sest_db = new String[((rowncol.length)/2)]; 
			int n=0;
		
			for(int i=0;i<rowncol.length;i=i+2)
			{
				sest_db [n] = (rowncol[i]+rowncol[i+1]);
				n++;
			}
			return sest_db;
		}
	
	public static void main(String ar[])
	{
		BookMovie j = new BookMovie(); 
		j.display();
	
	}
}
  
      
 
