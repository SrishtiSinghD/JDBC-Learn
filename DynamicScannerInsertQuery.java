import java.sql.*;
import java.util.*;

class DynamicScannerInsertQuery
{
	public static void main(String args[])
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/jdbclearn";
			String username = "root";
			String password = "1234";

			Connection conn = DriverManager.getConnection(url,username,password);

			if(conn.isClosed())
			{
				System.out.println("Connection is closed!");
			}
			else {
				System.out.println("Connection is Established...");

				Scanner sc = new Scanner(System.in);

				System.out.println("Enter Student name: ");
				String name = sc.nextLine();

				System.out.println("Enter Student City: ");
				String city = sc.nextLine();
				
				String query = "INSERT INTO Student (name,city) values ('"+name+"','"+city+"')";

				Statement stmt = conn.createStatement();

				stmt.executeUpdate(query);

				System.out.println("Student is added to the table");

				conn.close();

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
