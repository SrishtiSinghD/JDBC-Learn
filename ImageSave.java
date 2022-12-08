import java.sql.*;
import java.io.*;

class ImageSave
{
	public static void main(String args[])
	{
		try 
		{
			//Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/jdbclearn";
			String username = "root";
			String password = "1234";
			Connection conn = DriverManager.getConnection(url,username,password);

			if(conn.isClosed())
			{
				System.out.println("Connection is Closed");
			}
			else 
			{
				System.out.println("Connection is Established...");

				String query_insert_image = "INSERT INTO images (image) values(?)";

				PreparedStatement pstmt = conn.prepareStatement(query_insert_image);

				FileInputStream file = new FileInputStream("butterfly.jpg"); 
				pstmt.setBinaryStream(1,file,file.available());

				pstmt.executeUpdate();
				System.out.println("Image Updated...");

				conn.close();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}