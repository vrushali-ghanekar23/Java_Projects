import java.util.*;
import java.io.*;
import java.net.*;

class QueueJob
{
	List<Integer> queue = new ArrayList<Integer>();  
	List<Integer> waiting_queue = new ArrayList<Integer>();  
	
	List<Integer> add(int i)
	{
		
			queue.add(i);
			//System.out.println("\nAvailable space in queue is"+(queue.size()-3));
		
		//System.out.println(queue);
		
		return queue;
	}
	
	int return_size()
	{
		
		int return_value=0;
		return_value = queue.size();
		return return_value;
	}
	
	List<Integer> re_data(int i)
	{
		System.out.println(queue);
		if(i==0)
		{
			queue.remove(i);
		}
		else
		{
			if(i>(queue.size()))
			{
				int queue_size = queue.size();
				i=queue_size-1;
			}
			else
			{
				for(int index=0;index<(queue.size());index++)
				{
					if(queue.get(index)==i)
					{
						i=index;
					}
				}
			
			}
			
			queue.remove(i);
		}
		
		//System.out.println("\nAvailable space in queue is :"+(queue.size()-i));
		//System.out.println(queue);
	return queue;
	}
	
	int get_data(int data)
	{
		
		return (queue.get(data));
	}
	
	
}