//How to make connection in java jdbc

import java.sql.*;
import java.lang.*;

class CreateTableJDBC
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

				//Make a Insert Query

				//Write sql insert query
				String query_student_table = "CREATE TABLE Student(sID int(20) primary key auto_increment, name varchar(50) not null, city varchar(400) not null)";
				String query_image_table = "CREATE TABLE Images(imgID int primary key auto_increment,image longblob not null)";;

				//Make query statement from string (as string has no semicolon)

				Statement stmt = con.createStatement();

				//Then statement executes query : here it is an update query
				stmt.executeUpdate(query_image_table);


				System.out.println("Table created in database");

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