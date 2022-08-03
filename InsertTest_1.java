

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	public class InsertTest_1 {
		public static void main(String[] args) throws StudentAlreadyExistsException
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
				PreparedStatement pst = conn.prepareStatement("INSERT INTO STUDENT VALUES (?,?,?,?,?,?,?,?);");
				System.out.println("Prepared Statement created : "+pst);
				
				Scanner scan1 = new Scanner(System.in);
				System.out.println("Enter Student roll number : ");
				int rollNo = scan1.nextInt();
				
				Statement st= conn.createStatement();
				ResultSet rs = st.executeQuery("select * from student where rollno="+rollNo);

				if(rs.next()) {
					StudentAlreadyExistsException Ex= new StudentAlreadyExistsException("Student already exists");
					throw Ex;
				}
				
				Scanner scan2 = new Scanner(System.in);
				System.out.println("Enter Student name   : ");
				String studentName = scan2.next();
				
				Scanner scan3 = new Scanner(System.in);
				System.out.println("Enter Student BirthDate : ");
				String birthDate = scan3.next();
				
				Scanner scan4 = new Scanner(System.in);
				System.out.println("Enter Physics marks   : ");
				int phyM = scan4.nextInt();
				
				Scanner scan5 = new Scanner(System.in);
				System.out.println("Enter Chemistry marks : ");
				int chemM = scan5.nextInt();
				
				Scanner scan6 = new Scanner(System.in);
				System.out.println("Enter Maths marks  : ");
				int mathM = scan6.nextInt();
				
				Scanner scan7 = new Scanner(System.in);
				System.out.println("Enter Total Marks : ");
				int totalM = scan7.nextInt();
				
				Scanner scan8 = new Scanner(System.in);
				System.out.println("Enter Grade : ");
				String grade = scan8.next();
				
				pst.setInt(1, rollNo);//fill up the question mark with its value
				pst.setString(2, studentName);
				pst.setString(3, birthDate);
				pst.setInt(4, phyM);
				pst.setInt(5, chemM);
				pst.setInt(6, mathM);
				pst.setInt(7, totalM);
				pst.setString(8, grade);				
				
				
				
				System.out.println("Trying to execute the prepared statement....");
				int rows = pst.executeUpdate();
				
				System.out.println("Prepred Statement executed, inserted the records :..."+rows);
					
				
				pst.close();	conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			    
		}

		
	}