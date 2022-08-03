import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectWhereTest_1 {
	public static void main(String[] args) {
		
		//1. WE KNOW THE DRIVER - org.hsqldb.jdbc.JDBCDriver.class
		//2. REGISTER THIS DRIVER
		try {
			System.out.println("Registering driver...");    
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver registered....");
			
			System.out.println("Trying to connect to the DB");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
			
			System.out.println("Connected to the DB : "+conn);
			
			System.out.println("trying to make a statment");
			Statement statement = conn.createStatement();
			System.out.println("Statement created : "+statement);
			
			System.out.println("Trying to execute the statement....");
			
			Scanner sc =new Scanner(System.in);
			int nrollno=sc.nextInt();
			
			ResultSet rs = statement.executeQuery("SELECT * FROM STUDENT WHERE ROLLNO="+nrollno);
			System.out.println("Statement executed, got the result....");
			
			

			
				
			if(rs.next()) {
				int rollno = rs.getInt(1) ; // get the first column (int type) output
				String studentName = rs.getString(2) ;
				String birthDate = rs.getString(3) ;
				int phyM = rs.getInt(4);
				int chemM = rs.getInt(5);
				int mathM = rs.getInt(6);
				int totalM = rs.getInt(7);
				String grade = rs.getString(8) ;
				System.out.println("------------------------");
				
				System.out.println("ROLL NO   : "+rollno);
				System.out.println("STUDENT NAME : "+studentName);
				System.out.println("BIRTHDATE  : "+birthDate);

				System.out.println("PHYSICS MARKS : "+phyM);
				System.out.println("CHEMISTRY MARKS : "+chemM);
				System.out.println("MATHS MARKS : "+mathM);

				System.out.println("TOTAL MARKS: "+totalM);
				System.out.println("GRADE : "+grade);

				System.out.println("------------------------");
			}else {
				throw new StudentNotFoundException(nrollno+" Student Not Found");
			}
			rs.close();	statement.close();	conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		    
	}
}




