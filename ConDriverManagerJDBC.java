// Create a connection with mySQL database using driver managers

import java.sql.*;

class ConDriverManagerJDBC
{
	public static void main(String args[])
	{
		try 
		{
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);

			String url = "jdbc:mysql://localhost:3306/jdbclearn";
			String username = "root";
			String password = "1234";

			Connection conn = DriverManager.getConnection(url,username,password);

			if(conn.isClosed())
			{
				System.out.println("Connection is closed");
			}
			else
			{
				System.out.println("Connection Established...");

				conn.close();
;
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
}