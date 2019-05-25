package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Seller {
	

	public String getSeller() 
	{             
		String SellerGrid = null;             
		Connection con = null;             
		Statement st = null;             
		ResultSet rs = null;       
		
		try {       
			con = DBConnect.createConnection();     
			st = con.createStatement();    
			rs = st.executeQuery("select * from seller");     
			
			if (rs.first())       
			{ 
				SellerGrid = "<table border='1' cellspacing='1' cellpadding='1'>"
						+ "<tr>"
						+ "<th>No</th>"
						+ "<th>Name</th>"
						+ "<th>Description</th>"
						+ "<th>Address</th>"
						+ "<th>Phone</th>"
						+ "<th>Edit</th>"
						+ "<th>Delete</th>"
						+ "</tr>"; 
				rs.beforeFirst(); 
				
				while(rs.next())  
				{   
					SellerGrid = SellerGrid + "<tr><td>" + rs.getString(1) + 
							"</td>"      + "<td>" + rs.getString(2) + "</td>"     
							+ "<td>" + rs.getString(3) + "</td>"      
							+ "<td><input id=\"btnEdit\" type=\"button\" name=\"btnEdit\"  param=\"" 
							+ rs.getString(1) + "\" value=\"Edit\"</td>"      
							+ "<td>" + "<input id=\"btnRemove\" type=\"button\" name=\"btnRemove\" param=\"" 
							+ rs.getString(1) + "\" value=\"Remove\"</td></tr>";                        
				} 
				
			}                   
			else                         
				SellerGrid = "There are no sellers...";                   
				SellerGrid = SellerGrid + "</table></br>";             
			}             
		catch (SQLException e) 
		{                   
			e.printStackTrace();             
		}             
		
		return SellerGrid;       
		
		}       
	
		public String saveAnSeller(String SellerName, String SellerDesc, String SellerAddress,String SellerPhone) 
		{
			String res = null;             
			String sql = null;            
			Connection con = null;             
			Statement st = null;             
			try 
			{                   
				con = DBConnect.createConnection();                  
				st = con.createStatement();                  
				sql = "insert into seller(name, description, address, phone) values ('" + SellerName + "', '" + SellerDesc + "','"+SellerAddress+"','"+SellerPhone+"')";                   
				st.executeUpdate(sql);                   
				res = "Successfully inserted...";             
			}             
			catch (SQLException e) 
			{                   
				e.printStackTrace();             
			}             
			
			return res;       
			
		}
}
