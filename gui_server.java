import java.lang.*;
import java.util.*;
import java.io.*;
import java.net.*;
import java.text.*;
import java.util.stream.*;
import java.util.function.*;



 class Main
{
	public static int count=0;
}



class gui_server
{
	
	
	public static void main(String ar[]) throws IOException
	{
	
	
	 
	ServerSocket ss = new ServerSocket(6766);
	serverTreading st;
	QueueJob q = new QueueJob();
	int k=0;
	server_side s1= new server_side();
	s1.cnt_of_no_usr.setText(Integer.toString(Main.count));
	s1.frame.revalidate();
	s1.frame.repaint();
	
	do
	{
		
		Socket s = ss.accept();
		System.out.println("\nCONNECTION IS ESTABULISH SUCCESSFULLY....");
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());

		
		int i = q.return_size();
		
		int data=0;
		if((q.return_size())<3)
		{	
			st = new serverTreading(s,q,s1);
			if(i==0)
			{
				q.add(0);
			}
			else
			{
				data = q.get_data((i-1));
				List<String> queue_list=(q.add((data+1))).stream()
				.map(sn->String.valueOf(sn))
				.collect(Collectors.toList());
				
				String text="";
				for(int min=0; min<q.return_size();min++)
				{
					text+=queue_list.get(min)+",";
				}
				
				s1.queue_display1.setVisible(true);
				s1.queue_display.setText("{ "+text+" }");
				s1.frame.revalidate();
				s1.frame.repaint();
			}
		
				st.start();	
				Main.count++;
				s1.cnt_of_no_usr.setText(Integer.toString(Main.count));
				s1.frame.revalidate();
				s1.frame.repaint();
				
		}
		
		
	}while(Thread.activeCount()>1);
	
	}
	}

	class serverTreading extends Thread
	{
		QueueJob q1=null;
		Socket ss= null;
		server_side ser_side =null;
		
		int flag =0;
		serverTreading(Socket s ,QueueJob q , server_side ser_side1)
		{
			ss = s;
			q1 =q;
			ser_side = ser_side1;
		}
		public void run()
		{
			try
			{
				
				Scanner sc = new Scanner(System.in);
				DataInputStream dis = new DataInputStream(ss.getInputStream());
				DataOutputStream dos = new DataOutputStream(ss.getOutputStream());
				ObjectOutputStream oos = new ObjectOutputStream(ss.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(ss.getInputStream());

				JSplitPaneExample c = new JSplitPaneExample();
				oos.writeObject(c);
				
				
				String file_name=null;
				String thread_name= Thread.currentThread().getName();
				String [] split_thread_name_check = thread_name.split("-");
				int thread_no = Integer.parseInt(split_thread_name_check[1]);
				Status_log sl = new Status_log();
				if(thread_no>2)
				{
					
					thread_no=3;
					File f = new File(sl.check_exist_file(thread_no-3));
					if(f.exists() && !f.isDirectory())
					{
						
						File f1 = new File(sl.check_exist_file(thread_no-2));
						if(f1.exists() && !f1.isDirectory())
						{
						
							File f2 = new File(sl.check_exist_file(thread_no-1));
							if(f2.exists() && !f2.isDirectory())
							{
								
							}
							else
							{
								
								file_name = "Thread"+"-2"+".txt";
							}
						}
						else
						{
							
							file_name = "Thread"+"-1"+".txt";
						}

					}
					else
					{
						
						file_name = "Thread"+"-0"+".txt";
					}
					
				}
				else
				{
					
					file_name=sl.check_exist_file(thread_no);
				}
				
				
				
				if((ser_side.user_1.getText()).equals(""))
				{
					ser_side.user_1.setText(thread_name);
				}
				else if((ser_side.user_2.getText()).equals(""))
				{
					ser_side.user_2.setText(thread_name);
				}
				else if((ser_side.user_3.getText()).equals(""))
				{
					ser_side.user_3.setText(thread_name);
				}
				else
				{
					
				}
				
				ser_side.frame.revalidate();
				ser_side.frame.repaint();
				
				String text="";
				
				File file = new File(file_name);
				while(true)
				{
				if(file.exists() && !file.isDirectory())
				{
					String [] split_file_name = file_name.split("-");
					String [] split_count = split_file_name[1].split("[.]");
					
				int flag=0;
				for(int i=0;i<(q1.return_size());i++)
				{
					if((q1.get_data(i)) == (Integer.parseInt(split_count[0])))
					{
						flag=1;
						break;
					}
					
				}
				
				if(flag==1)
				{
					text="";
				
					List<String> queue_list=q1.re_data((Integer.parseInt(split_count[0]))).stream()
					.map(sn->String.valueOf(sn))
					.collect(Collectors.toList());

				
				for(int min=0; min<queue_list.size();min++)
				{
					text+=queue_list.get(min)+",";

				}
				
				ser_side.queue_display.setText("{ "+text+" }");
				ser_side.frame.revalidate();
				ser_side.frame.repaint();
					
					
				}
				else
				{
					text="";
					List<String> queue_list=q1.re_data((Integer.parseInt(split_count[0]))).stream()
					.map(sn->String.valueOf(sn))
					.collect(Collectors.toList());

				
					for(int min=0; min<queue_list.size();min++)
					{
					text+=queue_list.get(min)+",";

					}
				
				ser_side.queue_display.setText("{ "+text+" }");
				ser_side.frame.revalidate();
				ser_side.frame.repaint();
				}
				
				file.delete();
				
				
					if(Main.count==0)
					{
						Main.count=0;
					}
					else
					{
						Main.count =Main.count-1;
					}
					
					if(!(ser_side.user_1.getText()).equals(""))
					{
						ser_side.user_1.setText("");
					}
					else if(!(ser_side.user_2.getText()).equals(""))
					{
						ser_side.user_2.setText("");
					}
					else if(!(ser_side.user_3.getText()).equals(""))
					{
						ser_side.user_3.setText("");
					}
					else{}
					
					 if(text.equals(""))
					{
						ser_side.queue_display.setText("");
						ser_side.queue_display1.setText("");
					}	
					ser_side.cnt_of_no_usr.setText(Integer.toString(Main.count));
					ser_side.frame.revalidate();
					ser_side.frame.repaint();
					
				}	
				
				}
			
	}
	catch(Exception e)
	{
				
	}
			
		
	}
	

}
