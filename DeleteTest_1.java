import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest_1 {
	public static void main(String[] args) throws StudentNotFoundException
	{
		
		//1. WE KNOW THE DRIVER - org.hsqldb.jdbc.JDBCDriver.class
		//2. REGISTER THIS DRIVER
		try {
			System.out.println("Registering driver...");    
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver registered....");
			
			System.out.println("Trying to connect to the DB");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
			
			System.out.println("Connected to the DB : "+conn);
		
			
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Enter student number : ");
			int nrollno = scan1.nextInt();
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from student where nrollno="+nrollno);
			
			if(rs.next()) {
				
				
				System.out.println("trying to make a Prepared statment");
				PreparedStatement pst = conn.prepareStatement("DELETE FROM STUDENT WHERE ROLLNO=?");
				System.out.println("Prepared Statement created : "+pst);
		
			
				pst.setInt(1, nrollno);//fill up the question mark with its value
				System.out.println("Trying to execute the prepared statement....");
				int rows = pst.executeUpdate();
				
				System.out.println("Prepred Statement executed, deleted the records :..."+rows);
				
			}
			else {
				StudentNotFoundException ex = new StudentNotFoundException("This student number does not exists : "+nrollno);
				throw ex;
			}
					
			
	
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		    
	}
}