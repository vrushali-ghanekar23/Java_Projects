import java.sql.*;
import java.util.*;
import java.io.*;
public class Database implements Serializable
{
		String return_string;
		
	public static Connection getConnection() throws Exception 
	{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/cinemax_booking?autoReconnect=true&useSSL=false";
		String username = "root";
		String password = "vrushali@123";

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		
    return conn;
  }
  
  
  public int getcount(String method) 
  {
	  int row=0 ;
		try {
				Connection  conn = getConnection();
	  
	  
				Statement st = conn.createStatement();
				ResultSet rs = null;
				if(method == "B")
				{
					rs = st.executeQuery("select count(id)from cinemax");
				}
				else
				{
					rs = st.executeQuery("select count(id)from Back_up_cinemax");

				}
				
				rs.next();
		        row= rs.getInt(1);
			} 
			
		catch (Exception e)
			{
				e.printStackTrace();
				System.exit(1);
			} 
		return row;
  }
  
  public String [] getrowncol(String method)
  {
	  int count = getcount(method);
	  String [] ronco = new String[(count*2)]; 
	 
	  try {
				Connection  conn = getConnection();
				
	  
				Statement st = conn.createStatement();
				ResultSet rs = null;
				if(method == "B")
				{
					
					 rs = st.executeQuery("select Row_Name,Column_number from cinemax");
				}
				else
				{
					 rs = st.executeQuery("select Row_Name,Column_number from Back_up_cinemax");

				}
					
					int i=0;
				while(rs.next())
				{
					ronco[i]=rs.getString("Row_Name");
					i++;
					ronco[i]=Integer.toString(rs.getInt("Column_number"));
					i++;
				}
			} 
			
		catch (Exception e)
			{
				e.printStackTrace();
				System.exit(1);
			} 
		return ronco;
  
  }
  
  
  
  
		public void db_Booked(String row,int col,String phon,String status,String strdate,String strtime)
  {
	  try
	  {
		 Connection  conn = getConnection();
		
		 
		String insert_query = "insert into cinemax(Row_Name,Column_number, Mobile_number,Status,Date,Time)"+"values(?,?,?,?,?,?)";

		PreparedStatement pre_st = conn.prepareStatement(insert_query);
		
		pre_st.setString(1,row);
		pre_st.setInt(2,col);
		pre_st.setString(3,phon);
		pre_st.setString(4,status);
		pre_st.setString(5,strdate);
		pre_st.setString(6,strtime);
		
		pre_st.execute();
		
		

		//System.out.println("\n\nDATA ADDED INTO DATABASE SUCCESSFULLY....");
		
		String [] backup_data = getrowncol("C");
		for(int i=0;i<backup_data.length;i=i+2)
		{
			if(row.equals(backup_data[i]))
			{
				if(col == Integer.parseInt(backup_data[i+1]))
				{
					String delete_query = "delete from Back_up_cinemax where Row_Name =? and Column_number = ?"; 	
					PreparedStatement ps1 = conn.prepareStatement(delete_query);
				
					ps1.setString(1,row);
					ps1.setInt(2,col);
					ps1.execute();
				}
				
				
			}
		}
		
		conn.close();
	  }
	  catch(Exception e)
	  {
		  
	  }
  }
  
		
		void deletedata(char row,int col,String phon,String status,String strdate,String strtime)
		{
			 try {
				Connection  conn = getConnection();
				String row1 = String.valueOf(row);  //typecasting char to string
				
				String select_query=("select id from cinemax where Row_Name= ? and Column_number = ?");
				PreparedStatement ps =  conn.prepareStatement(select_query);
				
				ps.setString(1,row1);
				ps.setInt(2,col);
				ResultSet rs = ps.executeQuery();
				int id=0;
				while(rs.next())
				{
					id = rs.getInt(1);
				}
				
				String delete_query = ("delete from cinemax where id = ?");
				PreparedStatement ps1 = conn.prepareStatement(delete_query);
				
				ps1.setInt(1,id);
				ps1.execute();
				
				String insert_query1 = "insert into Back_up_cinemax(Row_Name,Column_number, Mobile_number,Status,Date,Time)"+"values(?,?,?,?,?,?)";
				PreparedStatement pre_st = conn.prepareStatement(insert_query1);
		
				pre_st.setString(1,row1);
				pre_st.setInt(2,col);
				pre_st.setString(3,phon);
				pre_st.setString(4,status);
				pre_st.setString(5,strdate);
				pre_st.setString(6,strtime);
		
				pre_st.execute();
				
				//System.out.println("\n\n DATA DELETED FROM DATABASE SUCCESSFULLY....");
				
			
			
			} 
			
		catch (Exception e)
			{
				e.printStackTrace();
				System.exit(1);
			} 
		
			
		}
		
		public String retun_phon(int row,int col)
		{
			String phon=null;
			try
			{
				Connection  conn = getConnection();
				
				

				char temp1 = (char)(row+'0');
				String row1 = String.valueOf(temp1);  //typecasting char to string
				
				String select_query=("select Mobile_number from cinemax where Row_Name= ? and Column_number = ?");
				PreparedStatement ps =  conn.prepareStatement(select_query);
				
				ps.setString(1,row1);
				ps.setInt(2,col);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					phon = rs.getString(1);
				}
			}
			catch(Exception e)
			{
				
			}
			return phon;
		}
		
		String [] retrived_data_pericular_cutomer(String mobile)
		{
			Scanner sc = new Scanner(System.in);

			//String mobile=null;
			
			//System.out.println("\nEnter your Mobile number which you enter while booking seat(s)");
			//mobile=sc.nextLine();
			
			String b_seats[] = new String[(6*(getcount("B")))];
			try {
					Connection  conn = getConnection();
					
					String select_query=("select * from cinemax where Mobile_number = ?");
					PreparedStatement ps =  conn.prepareStatement(select_query);
				
					ps.setString(1,mobile);

					ResultSet rs = ps.executeQuery();
					
										
					int i=0;
				while(rs.next())
				{
					b_seats[i]=rs.getString("Row_Name");
					i++;
					b_seats[i]=Integer.toString(rs.getInt("Column_number"));
					i++;
					b_seats[i]=rs.getString("Mobile_number");
					i++;
					b_seats[i]=rs.getString("Status");
					i++;
					b_seats[i]=rs.getString("Date");
					i++;
					b_seats[i]=rs.getString("Time");
					i++;
		
				}
			} 
			
		catch (Exception e)
			{
				e.printStackTrace();
				System.exit(1);
			} 
		return b_seats;
			
		}
		
		String [] retrived_all_data(String method)
		{
			
			
			int count =0;
			
			String [] data ;
			
			
			
			if(method=="B")
			{
				
				count = getcount("B");
				 data = new String[(count*6)]; 
	 
			}
			else
			{
				count = getcount("C");
				 data = new String[(count*6)]; 
			}
			
			try {
					Connection  conn = getConnection();
					Statement st = conn.createStatement();
					ResultSet rs =null;
					
					if(method == "B")
					{
					 rs = st.executeQuery("select * from cinemax order by Row_name,Column_number");
					}
					else
					{
					 rs = st.executeQuery("select * from Back_up_cinemax order by Row_name,Column_number");
					}
										
					int i=0;
				while(rs.next())
				{
					data[i]=rs.getString("Row_Name");
					i++;
					data[i]=Integer.toString(rs.getInt("Column_number"));
					i++;
					data[i]=rs.getString("Mobile_number");
					i++;
					data[i]=rs.getString("Status");
					i++;
					data[i]=rs.getString("Date");
					i++;
					data[i]=rs.getString("Time");
					i++;
				
				}
			} 
			
		catch (Exception e)
			{
				e.printStackTrace();
				System.exit(1);
			} 
		return data;
		}
		
		public static void main(String ar[])
		{
			Database d = new Database();
			
			
		}
		
}