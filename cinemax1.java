import java.lang.*;
import java.util.*;
import java.io.*;
import java.text.*;


public class cinemax1 implements Serializable
{
	
			//private int size;

			private static class Node  //inner class
			{
				char element;
				Node next;
				Node prev;
				String phon;	
			}
			
				static Node[] row = new Node[10];

		public cinemax1()  //constructer 
		{
				//size = 0;
	
				for(int i=0;i<10;i++)		//intialized all node to null
				{
						row[i] = null;   	
				}	
		}
		
		static Scanner sc = new Scanner(System.in);  //scanner class usedto get input from user
		
		
		public static ArrayList<Integer> row_name()  //arraylist it will show the name of rows
		{
			ArrayList<Integer> array = new ArrayList<Integer>();
			char x = 'J';
			for(int i=0;i<=10;i++)
			{
				int data = x - '0';
				array.add(data);
				x--;
			}
			return array;
		}
		
		public String [] date_time()
		{
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
			String strDate = dateFormat.format(date);
			String strTime = timeFormat.format(date);
			
			String [] datetime = new String[2];
			datetime[0]=strDate;
			datetime[1]=strTime;
			
			return datetime;
		}
		
		public static void settingdata()  //here  create the linked list and set all seat to available that is 'A'
		{
			Node p = new Node();
			Node q = new Node();		//create object of type node class
			Node temp1 = new Node();
			 
			
			
			for(int i=0;i<10;i++)
			{
			
				
				for(int j=0;j<9;j++)
				{
						Node temp = new Node();
						temp.element='A';
						temp.next=null;
						
					if(row[i]==null)
					{
						row[i]=temp;
						
					}
					else
					{
						
						p = row[i];
						while(p.next != null)
						{
							p = p.next;
						}
						p.next = temp;
						temp.prev = p;
						q = temp;
					}
				}
				
				q.next = row[i];
				temp1 = row[i];
				temp1.prev = q;
				
			}
			
		}
		
		
		public  void display()  //displaying the structure of seat or cinemax
		{
			//set_seat_by_db();
			
			Node temp = new Node();
			char r = 'J';
			System.out.println("\t A -> AVAILABLE \t B -> BOOKED ");
			System.out.print("------------------------------------------PLATINIUM---------------------------------------");
			System.out.println();
			for(int i=0;i<3;i++)
			{
				System.out.println();
				int cnt = 1;
				temp = row[i];
				System.out.print("ROW "+r+" ");
				while(temp.next != row[i])
				{
					System.out.print("\t|"+cnt+" "+temp.element+"|  ");
					temp = temp.next;
					cnt++;
				}r--;
			}
			System.out.println();
			System.out.print("\n----------------------------------------GOLD-----------------------------------------------");
			System.out.println();
			for(int i=3;i<7;i++)
			{
				System.out.println();
				temp = row[i];
				int cnt = 1;
				System.out.print("ROW "+r+" ");
				while(temp.next != row[i])
				{
					System.out.print("\t|"+cnt+" "+temp.element+"|  ");
					temp = temp.next;
					cnt++;	
				}r--;	
			}
			System.out.println();
			System.out.print("\n-----------------------------------SILVER--------------------------------------------------");
			System.out.println();
			for(int i=7;i<10;i++)
			{
				System.out.println();
				System.out.print("ROW "+r+" ");
		
				temp = row[i];
				int cnt = 1;
		
		
				while(temp.next != row[i])
				{			
					System.out.print("\t|"+cnt+" "+temp.element+"|  ");
					temp = temp.next;
					cnt++;			
				}r--;
			}				
		}
		
		
		void set_seat_by_db(String method)
		{
			Database db = new Database();
			String [] rowncol = db.getrowncol(method);
			int [] rowdata = new int [(rowncol.length)];
			ArrayList<Integer> array = row_name();
			
			
			for(int i=0;i<rowncol.length;i=i+2)
			{
				if(rowncol[i]==null)
				{
					break;
				}
				else
				{
					
					char data =(rowncol[i]).charAt(0);
					rowdata[i]=data-'0';
					rowdata[i+1] = Integer.parseInt(rowncol[i+1]);
				}
			}
			int r=0;
			for(int i=0;i<rowdata.length;i=i+2)
			{
				if(rowdata[i]==0)
				{
					break;
				}
				else
				{
				for(int k=0;k<10;k++)
						{
							
							if(array.get(k)== rowdata[i])
							{
								r = k;
							}
					
						}
						
						Node temp = new Node();
						temp = row[r];
						
						
						int d = rowdata[i+1];
						for(int j=0;j<d-1;j++)
						{
							temp = temp.next;
						}
						if(method == "B")
						{
							if(temp.element == 'A')   
							{
								temp.element = 'B';
							
							}
						}
						else
						{
								if(temp.element == 'B')   
								{
									temp.element = 'A';
							
								}
						}	
				}		
			}
				
		}
		
	
		public String [] Book()
		{
			set_seat_by_db("B");
			
			String[] datetime = date_time(); 
			
			ArrayList<Integer> array = row_name();  //arraylist which display the row name 
			Queue<Integer> row_data = new LinkedList<Integer>(); // queue in which row names  will insert when user enter the row name at the of booking  the seat
			Queue<Integer> col_data = new LinkedList<Integer>();  // queue in which columns number will insert when user enter the column number at the time of bookig the seat 
			Vector <String> msg = new Vector<String>();     // vector which strore the message 
			
			msg.add("ENTER THE NUMBER OF SEATS YOU WANT TO BOOK : ");
			msg.add("ENTER THE ROW  NAME AND COLUMN NUMBER OF THE SEAT YOU WANT TO BOOK : ");
			msg.add("SEAT IS ALREADY BOOKED,\n PLEASE TRY FOR OTHER SEAT");
			msg.add("ENTER YOUR MOBILE NUMBER (REQUIRED IF SEAT IS TO BE CANCELLED :");
			msg.add("SEAT BOOKED !!");
			msg.add("ENTER VALID ROW NAME!!!!");
			msg.add("ENTER VALID COLUMN NUMBER!!!!");

			int col,n;
			int r=0;
			int d = 0;
			//String returndata=null;
			char rr;
			System.out.println("\n"+msg.get(0));
			n=sc.nextInt();
			String [] data = new String[(6*n)];
			
			
			for(int i=0;i<n;i++)
			{
				System.out.println("\n"+msg.get(1));
				rr= sc.next().charAt(0);
				int rdata = rr - '0';
				col=sc.nextInt();
				sc.nextLine();
				
					row_data.add(rdata);  //inserting to row queue
					col_data.add(col);  //inserting to column queue
				
			}
			
			for(int i=0;i<n;i++)
			{
				
				int rdata = row_data.remove();
				col = col_data.remove();
				
				if(rdata > 26)
				{
					
					System.out.println("\n"+msg.get(5));
					
				}
				else if(col > 8)
				{
					System.out.println("\n"+msg.get(6));
				}
				else
				{
					
						for(int k=0;k<10;k++)
						{
					
							if(array.get(k)== rdata)
							{
								r = k;
							}
					
						}	
						Node temp = new Node();
						temp = row[r];
						
						
						for(int j=0;j<col-1;j++)
						{
							temp = temp.next;
						}
						if(temp.element == 'B')   //here checking that the seat is already book or not
						{
							System.out.println("\n"+msg.get(2));
						}
						else
						{	
							System.out.println("\n"+msg.get(3)); 
							 int x=0;
							
							do
							{
							temp.phon= sc.nextLine(); 
							if (temp.phon.length() <= 10 && temp.phon.length() >=10 )     // if not then we take mobile number from user
							{	x=1;
								temp.element = 'B'; 			
							}
							else{
								x=0;
								System.out.println("\nEntre valid Contact Number");
							}
							}while(x == 0);
							
						
							String phone =temp.phon;	
							//BackLog b = new BackLog();
							//b.adddata(rdata,col,phone,"true");
							String rowchar = Integer.toString(rdata);
							String colchar = Integer.toString(col);
							data[d] = rowchar;
							data[d+1] = colchar;
							data[d+2] = phone;
							data[d+3] = "true";
							data[d+4] = datetime[0];
							data[d+5] = datetime[1];
							System.out.println("\n\n"+msg.get(4));
							
						}
						d= d+6;
						
							
				}
				
			}
			
			display();
			return data;
		}

		public  String [] Cancle()
		{
		
			
			int col,r=0;
			int ch;
			String mob;
			char rr;
			set_seat_by_db("C");
			
			Database db = new Database();
			String[] datetime = date_time(); 
			ArrayList<Integer> array = row_name();
			String [] data = new String [6];
			Vector <String> msg = new Vector<String>();
			
			msg.add("ENTER THE ROW AND COLUMN NUMBER OF THE SEAT YOU WANT TO CANCEL : ");
			msg.add("ENTER THE MOBILE ENTERED AT THE TIME OF SEAT BOOKING : ");
			msg.add("MOBILE NUMBER CONFIRMED !!");
			msg.add("DO YOU REALLY WANT TO CANCEL THE BOOKING ?\n PRESS 1 FOR YES !");
			msg.add("SEAT CANCELLATION DONE SUCCESSFULLY !!");
			msg.add("INCORRECT MOBILE NUMBER\n PLEASE TRY AGAIN !");
			msg.add("SEAT NOT BOOKED !!");

			System.out.println("\n"+msg.get(0));
			rr= sc.next().charAt(0);
			int rdata = rr - '0';           //ascii value of 0 is 48 and ascii value of 65
			col=sc.nextInt();
			sc.nextLine();
			
			String db_phon = db.retun_phon(rdata,col);  //calling method in database
			
			for(int i =0;i<10;i++)
			{
				if(array.get(i) == rdata )
				{
					r = i;
				}
			}
			Node temp = new Node();
			
			temp = row[r];
			
			for(int j=0;j<col-1;j++)
			{
				temp =temp.next;
			}
				
			if(temp.element == 'B')  // check the seat is book or not 
			{
				System.out.println("\n"+msg.get(1));
				mob=sc.nextLine();                     //if yes then we get mobile no from user whuch was inserted at the time of booking 
				//String mob1 = temp.phon;
				if(mob.equals(db_phon)== true)       //checking the mobile no
				{
					System.out.println("\n"+msg.get(2));
					System.out.println("\n"+msg.get(3));     // if equal then cancle that seat
					ch=sc.nextInt();
					
					if(ch == 1)			
					{
						temp.element = 'A';
						
						data[0]=Integer.toString(rdata);
						data[1]=Integer.toString(col);
						data[2]=db_phon;
						data[3]="false";
						data[4]=datetime[0];
						data[5]=datetime[1];
					}
				}
				else
				{
				System.out.println("\n"+msg.get(5));  // or not then display the message not match mobile no
				}
			}
			else
			{
				System.out.println("\n"+msg.get(6));
			}
			display();
			System.out.println("\n\n"+msg.get(4));
			return data;
		}
		
}
