//How to make connection in java jdbc

import java.sql.*;
import java.lang.*;

class ConJDBC
{
	public static void main(String args[])
	{
		try
		{
			//load the driver on main(RAM) Memory
			Class.forName("com.mysql.cj.jdbc.Driver");

			//Make a connection with the db
			String url = "jdbc:mysql://localhost:3306/jdbclearn";
			String username = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url,username,password);

			if(con.isClosed())
			{
				System.out.println("Connection is Closed");
			}
			else 
			{
				System.out.println("Connection is Open...");

				//close db connection
				con.close();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}