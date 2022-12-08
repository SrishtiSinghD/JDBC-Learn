//How to make connection in java jdbc

import java.sql.*;
import java.lang.*;

class InsertJDBC
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

				String name = "Pam";
				String city = "Stranton";

				//Make a Insert Query

				//Write sql insert query
				String query = "INSERT INTO Student (name,city) values('"+name+"','"+city+"')";

				//Make query statement from string (as string has no semicolon)
				Statement stmt = con.createStatement();

				//Then statement executes query : here it is an update query
				stmt.executeUpdate(query);


				System.out.println("Student entered in Student table");

				//close database connection
				con.close();

			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}