

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ModifyTest_1 {
	public static void main(String[] args)
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
			
			System.out.println("trying to make a Prepared statment");
			PreparedStatement pst = conn.prepareStatement("UPDATE STUDENT SET STUDENTNAME=?, BIRTHDATE=?, PHYM=?, CHEMM=?, MATHM=?,TOTALM=?, GRADE=? WHERE ROLLNO=?");
			System.out.println("Prepared Statement created : "+pst);
			
			
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Enter Student roll number : ");
			int rollno = scan1.nextInt();
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from student where rollno="+rollno);
			
			if(rs.next()) {
			
				Scanner scan2 = new Scanner(System.in);
				System.out.println("Enter student name   : ");
				String studentName = scan2.next();
				
				Scanner scan3 = new Scanner(System.in);
				System.out.println("Enter birth date : ");
				String birthDate  = scan3.next();
				
				Scanner scan4 = new Scanner(System.in);
				System.out.println("Enter birth date : ");
				int phyM= scan4.nextInt();
				
				Scanner scan5 = new Scanner(System.in);
				System.out.println("Enter birth date : ");
				int chemM = scan5.nextInt();
				
				Scanner scan6 = new Scanner(System.in);
				System.out.println("Enter maths marks : ");
				int mathM  = scan6.nextInt();
				
				Scanner scan7 = new Scanner(System.in);
				System.out.println("Enter total marks : ");
				int totalM = scan7.nextInt();
				
				Scanner scan8 = new Scanner(System.in);
				System.out.println("Enter grade : ");
				String grade  = scan8.next();
				
				pst.setInt(8, rollno);//fill up the question mark with its value
				pst.setString(1, studentName);
				pst.setString(2, birthDate);
				pst.setInt(3, phyM);
				pst.setInt(4, chemM);
				pst.setInt(5, mathM);
				pst.setInt(6, totalM);
				pst.setString(7, grade);
				
				System.out.println("Trying to execute the prepared statement....");
				int rows = pst.executeUpdate();
				
				System.out.println("Prepred Statement executed, updated the records :..."+rows);
				
			}
			else {
				StudentNotFoundException ex = new StudentNotFoundException("This student roll number does not exists : "+rollno);
				throw ex;
			}
			
			
				
			
			pst.close();	conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		    
	}
}
/*


File handling
	- Object Serialization
	
		Object
			|
		----------
		|		|
		file	Database
		|			|
serialization		Persistence



1		Database software
		|MYSQL / HSQL 
		|
2		Database Driver - HSQLDB.JAR 
		|
3		Java Program
		to connect to the DB
		|
		interact with the db
		
		
	following diagram is NOT of inheritance
	
	
			   Driver.class <-- interface
				|  |
				|  HSQLDB.jar (1. KNOW YOUR DB DRIVER)
				|    ( org.hsqldb.jdbc.JDBCDriver.class)
				|			implementation of the interface
				|
				|
			DriverManager
				|    - load the driver (2. LOAD IT )
				|    - connect to the database (3. CONNECT TO THE DB)				
			Connection
				|
	--------------------------------
	|3. MAKE A STATEMENT
	Statement
	|4. RUN THE STATEMENT
	|5. ACQUIRE THE RESULT 
	|6. PROCESS THE RESULT
	|7. CLOSE THE RESULT, STATEMENT, CONNECTION
				
			


*/









