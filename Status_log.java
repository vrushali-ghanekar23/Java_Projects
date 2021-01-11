import java.io.*;
import java.util.*;
import java.text.*;

public class Status_log
{	
			
			
			
		public void adddata(String status,int count)
		{
			
		try
		{
			
			String name="Thread-";
			String count1=Integer.toString(count);
			String file_name=name+count1+".txt"; ;
			
					
		File f = new File(file_name);
		if(f.exists() && !f.isDirectory())
		{
			
			File f1 = new File(check_exist_file(count+1));
				if(f1.exists() && !f1.isDirectory())
				{
					
					File f2 = new File(check_exist_file(count+2));
					
					if(f2.exists() && !f2.isDirectory())
					{
						
						File f3 = new File(check_exist_file(count+3));
						if(f3.exists() && !f3.isDirectory())
						{
							
						}
						else
						{
							 file_name = create_file_name(f2);
						}
					}
					else
					{
						 file_name = create_file_name(f1);
					}
				}
				else
				{
						 file_name = create_file_name(f);
				}
					
		}
			
			
		
			
			FileWriter writer = new FileWriter(file_name,true);
			BufferedWriter bw = new BufferedWriter(writer);

			bw.write(status);
			bw.close();
			
		}
		catch(IOException e)
		{
			System.out.println("An error occured.."+e);
		}
		
}	
			String create_file_name(File f)
			{
						File f1= f;
						String name="Thread-";
						String fname=f1.getName();
						String [] split_file_name = fname.split("-");
						String [] split_count = split_file_name[1].split("[.]");
						int count2 = Integer.parseInt(split_count[0]);
						count2=count2+1;
						String count1=Integer.toString(count2);
						String file_name = name+count1+".txt";
						
				return file_name;
			}
			
			String check_exist_file(int count)
			{
				String name="Thread-";
				String count1=Integer.toString(count);
				String file_name = name+count1+".txt";
				return file_name;
			}
		
			public static void main(String are[])
			{
				Status_log s= new Status_log();
				s.adddata("close",0);
				
			}
}
