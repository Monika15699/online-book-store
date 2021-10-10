package BookShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Admin extends CustomerReg
{

	Scanner sc1 = new Scanner(System.in);
	  void loginAdmin()
	  {
		  int s1=12345 ,s2=12345;
		  int userName,password;
		  System.out.println("enter user name");
		  userName=sc1.nextInt();
		  System.out.println("Enter password");
		  password=sc1.nextInt();
		  if((userName==s1)&&(password==s2))
		  {
			  System.out.println("***************************login successful*****************************");
		  }
		  else {
			  System.out.println("--------------------------Invalid userId or password--------------------");
			  System.exit(0);
		  }
		  
		  
	  }
	   void RetriveBookDetails() throws ClassNotFoundException, SQLException
	   {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","root");
		   PreparedStatement ps = con.prepareStatement("select * from adminbookdetails");
		   ResultSet rs = ps.executeQuery();
		   while(rs.next())
		   {
			   System.out.println(rs.getString(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"$"+"  "+rs.getString(4)+"    "+rs.getString(5));
		   }
	   }
	  void insertBookDetails() throws ClassNotFoundException, SQLException
	  {
		  String bookName,authorName;
		  int sno,price,available;
		  System.out.println("enter serial Number");
		  sno=sc1.nextInt();
		  
		  System.out.println("enter Book Name");
		  sc1.next();
		  bookName=sc1.next();
		  
		  System.out.println("enter Author of the book name");
		  sc1.next();
		  authorName=sc1.next();
		  
		  System.out.println("enter price of the book");
		  sc1.nextInt();
		  price=sc1.nextInt();
		 
		  System.out.println("enter the Availability of book");
		  sc1.nextInt();
		  available=sc1.nextInt();
		  
		  Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","root");
		   PreparedStatement stmt = con.prepareStatement("insert into adminbookdetails values(?,?,?,?,?)");
		   stmt.setInt(1,sno);
		   stmt.setString(2,bookName);
		   stmt.setString(3,authorName);
		   stmt.setInt(4,price);
		   stmt.setInt(5,available);
		   int i = stmt.executeUpdate();
		   System.out.println(i+"record inserted");
		   con.close();
	  }
	  void deleteBookDetails() throws ClassNotFoundException, SQLException
	  {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","root");
		   PreparedStatement stmt = con.prepareStatement("delete from adminbookdetails where name=?");
		   System.out.println("enter which record you want to delete");
		   stmt.setString(1,sc1.next());
		   int i = stmt.executeUpdate();
		   System.out.println(i+"record deleted");
		   con.close();
	  }
	  void updateBookDetails() throws ClassNotFoundException, SQLException
	  {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","root");
		   PreparedStatement stmt = con.prepareStatement("update adminbookdetails set Rollno=? where name=?");
		   System.out.println("enter which record you want to update");
		   stmt.setString(1,sc1.next());
		   System.out.println("enter the Name where you want to update ");
		   stmt.setString(2,sc1.next());
		   int i = stmt.executeUpdate();
		   System.out.println(i+"record updated");
		   con.close();
	  }
	  void customerDetails() throws ClassNotFoundException, SQLException
	  {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","root");
		   PreparedStatement ps = con.prepareStatement("select * from customer_details");
		   ResultSet rs = ps.executeQuery();
		   while(rs.next())
		   {
			   System.out.println(rs.getString(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"    "+rs.getString(4)+"    "+rs.getString(5));
		   }
	  }
	  void orderDetails() throws ClassNotFoundException, SQLException
	  {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","root");
		   PreparedStatement ps = con.prepareStatement("select * from customer_orders");
		   ResultSet rs = ps.executeQuery();
		   while(rs.next())
		   {
			   System.out.println(rs.getString(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"    "+rs.getString(4)+"    "+rs.getString(5));
		   }  
	  }
		public static void main(String[] args) throws ClassNotFoundException, SQLException
		{
			Scanner sc2 = new Scanner(System.in);
			Admin sc = new Admin();
			sc.loginAdmin();
			while(true)
			{
				
				System.out.println("1.Insert book details");
				System.out.println("2.delete book details");
				System.out.println("3.update book details");
				System.out.println("4.retrive book details");
				System.out.println("5.retrive customer details");
				System.out.println("6.Customer order details");
				System.out.println("7.Exit");
				System.out.println();
				System.out.println("choose which operation you want to perform");
				int ch = sc2.nextInt();
				switch(ch)
				{
				case 1:
					sc.insertBookDetails();
					break;
				case 2:
					sc.deleteBookDetails();
					break;
				case 3:
					sc.updateBookDetails();
					break;
				case 4:
					sc.RetriveBookDetails();
					break;
				case 5:
					sc.customerDetails();
					break;
				case 6:
					sc.orderDetails();
					break;
				case 7:
					System.exit(0);
				}
			}

	}

}
