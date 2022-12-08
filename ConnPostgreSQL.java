import java.sql.*;

class ConnPostgreSQL
{
	public static void main(String args[])
	{
		try 
		{
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String username = "postgres";
			String password = "1234";
			Connection conn = DriverManager.getConnection(url,username,password);

			if(conn.isClosed())
			{
				System.out.println("Connection is closed");
			}
			else 
			{
				System.out.println("Connection is Established...");

				String query = ("INSERT INTO Student (sID,name,city) values (1,'Srishti','Haldwani')");

				Statement stmt = conn.createStatement();

				stmt.executeUpdate(query);

				System.out.println("Student saved in database...");

				conn.close();
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}

	}
}