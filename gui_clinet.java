import java.lang.*;
import java.util.*;
import java.io.*;
import java.net.*;

class gui_clinet
{
	public static void main(String ar[])
	{
		try{
		
		
		System.out.println("\nNOTE: Wait for 2 seconds if nothing is happen plz trye after some time...");
		Socket s = new Socket("localhost",6766);
		System.out.println("\nCONNECTION IS ESTABULISH SUCCESSFULLY....");
		QueueJob q= new QueueJob();
		
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		DataInputStream dis = new DataInputStream(s.getInputStream());
		ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
		ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
		int f=1;
		
		JSplitPaneExample c1;
		c1 =(JSplitPaneExample)ois.readObject();
		c1.main_frame();
		
		
	  }
	  catch(Exception e)
	  {
			System.out.println(e);
	  }
	}
}
