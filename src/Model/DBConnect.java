package Model;

	import java.sql.Connection;
	import java.sql.DriverManager;

	public class DBConnect {
		
		public static Connection createConnection()
		{
			Connection con = null;
			String url="jdbc:mysql://localhost:3306/sellnbye";
			String username="root";
			String password="";
		
		
		try
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Printing conection " + con);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
		
		}


	}

	
	

