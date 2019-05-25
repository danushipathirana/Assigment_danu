package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User 
{

	public String login(String userN, String passW)
	{
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		String userNameDB = "";
		String passwordDB = "";

		try
		{
			con = DBConnect.createConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery("select nameUsers, passUsers");
			
			while(resultSet.next())
			{
				userNameDB = resultSet.getString("nameUsers");
				passwordDB = resultSet.getString("passUsers");
				
				if(userN.equals(userNameDB) && passW.equals(passwordDB))
				{
					return "SUCCESS";
				}

			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return "Invalid...";

	

}

}