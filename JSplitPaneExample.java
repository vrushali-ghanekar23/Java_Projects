import java.awt.*;   
import javax.swing.*;
import java.awt.event.*;  
import java.io.*;

public class JSplitPaneExample implements Serializable {  

	private JMenuItem i1,i2,i3,i4,i5;
	 JFrame frame;
	private JMenuBar mb;
	private JMenu menu;
	private JMenu submenu;
	private Icon img,img1;
	private JLabel background,l1,l2,l3,l4,l5,imge;
	private JButton btn1;
	private Panel panel1,panel2;
  static int feedback;
        void main_frame()
		{
			
		Color panel2_bck_clr = Color.decode("#ff0000");
		Color mycolor = Color.decode("#80deea");
		Color btn_color = Color.decode("#E8175D");	 
		 
        frame  = new JFrame("Home");  
        frame.setSize(1000, 1000);  
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
        frame.getContentPane().setLayout(new GridLayout(1,3));
      
		img = new ImageIcon("PinClipart.com_theater-curtains-clip-art_2084343.png");
		background = new JLabel(img);
		background.setBounds(0,0,900,650);
	  
	  
	    img1 = new ImageIcon("cinema-film-popcorn-4e21914b966daa59865616cd17c99537.png");
		imge = new JLabel(img1,JLabel.CENTER);
		imge.setBounds(200,100,500,500);
	  
	  
         panel1 = new Panel();  
		panel1.setBackground(mycolor);
		panel1.add(background);
		panel1.add(imge);
		panel1.setLayout(null);
		
		
		Font f = new Font("Algerian",Font.BOLD,25);
		l1 = new JLabel("WELCOME");
		l1.setFont(f);
		l1.setForeground(Color.WHITE);
		l1.setBounds(100,0,500,70);
		
		l3 = new JLabel("TO");
		l3.setFont(f);
		l3.setForeground(Color.WHITE);
		l3.setBounds(150,50,500,70);
		
		l4 = new JLabel("CINEMAX BOOKING");
		l4.setFont(f);
		l4.setForeground(Color.WHITE);
		l4.setBounds(70,100,500,70);
		
		l5 = new JLabel("-----------------------------------");
		l5.setFont(f);
		l5.setForeground(Color.WHITE);
		l5.setBounds(30,150,500,70);
		
		l2 = new JLabel("CLICK ON BUTTON TO ENER INTO THE SYSTEM.");
		l2.setForeground(Color.WHITE);
		l2.setBounds(50,210,700,50);
		
		Icon icon = new ImageIcon("giphy (2).gif");
		JLabel gif_label = new JLabel(icon);
		gif_label.setBounds(2,270,350,330);
		
		btn1 = new JButton("LETS' GO");
		btn1.setBounds(125,620,150,30);
		btn1.setBackground(btn_color);
		btn1.setForeground(Color.WHITE);
	
		
	
		panel2 = new Panel();  
        panel2.setSize(300,1000);	
		panel2.setBackground(panel2_bck_clr);
		panel2.add(l1);
		panel2.add(l2);	
		panel2.add(l3);
		panel2.add(l4);
		panel2.add(l5);
		panel2.add(gif_label);
		panel2.add(btn1);
		panel2.setLayout(null);
		
		
		
		
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				BookMovie b= new BookMovie();
				b.display();
				
			}
			
		});
		
		
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent evt)
			{
				frame.dispose();
				Status_log sl = new Status_log();
				String status="close";
				int i=0;
				sl.adddata(status,i);
				i++;
				System.exit(0);
				
			}
			
			
		});
		
		
		
		
        JSplitPane splitPane = new JSplitPane(); 
		splitPane.setSize(1000,1000);
		splitPane.setDividerSize(10);
		splitPane.setDividerLocation(900);
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setLeftComponent(panel1);
        splitPane.setRightComponent(panel2);
        frame.getContentPane().add(splitPane);  
		
		  panel1.setVisible(true);
		  panel2.setVisible(true);
		  frame.setVisible(true);  
		  
		  
		}	  
	
	
		
		
	
	public static void main(String ar[])
	{
		JSplitPaneExample j = new JSplitPaneExample();
		j.main_frame();
		
		
	}
}
  
 
 