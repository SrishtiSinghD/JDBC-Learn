import java.sql.*;
import java.io.*;

class DynamicUserInputJDBC
{
	public static void main(String args[])
	{
		try 
		{
			//load the driver on main(RAM) Memory
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);

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
				String query = "INSERT INTO Student (name,city) values(?,?)";

				//Get Prepared Statement from string (as string has no semicolon)
				PreparedStatement pstmt = con.prepareStatement(query);

				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

				System.out.println("Enter Student Name: ");
				String name = reader.readLine();

				System.out.println("Enter City Name: ");
				String city = reader.readLine();

				//Set values to queries
				pstmt.setString(1,name);
				pstmt.setString(2,city);

				//Then statement executes query : here it is an update query
				pstmt.executeUpdate();


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