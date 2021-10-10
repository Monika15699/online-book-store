package BookShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerReg 
{
	Scanner sc1 = new Scanner(System.in);
   void customerRegistration() throws ClassNotFoundException, SQLException
   {
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","root");
	   PreparedStatement stmt = con1.prepareStatement("insert into customer_details values(?,?,?,?,?)");
	   System.out.println("enter Your Name");
	   stmt.setString(1,sc1.next());
	   System.out.println("enter your email ID");
	   stmt.setString(2,sc1.next());
	   System.out.println("enter Mobile number");
	   stmt.setInt(3,sc1.nextInt());
	   System.out.println("Create your password");
	   stmt.setString(4,sc1.next());
	   System.out.println("Confirm password");
	   stmt.setString(5,sc1.next());
	   int i = stmt.executeUpdate();
	   System.out.println("**************************your registration is completed successfully*************************************");
	   con1.close();
 
  }
   void customerLogin() throws ClassNotFoundException, SQLException
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
   void retriveBookdetails() throws ClassNotFoundException, SQLException
   {
	   
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","root");
	   PreparedStatement ps = con.prepareStatement("select * from adminbookdetails");
	   ResultSet rs = ps.executeQuery();
	   while(rs.next())
	   {
		   System.out.println(rs.getString(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"    "+rs.getString(4)+"    "+rs.getString(5));
	   }
   }
   void orderBook() throws ClassNotFoundException, SQLException
   {
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","root");
	   PreparedStatement stmt = con1.prepareStatement("insert into customer_orders values(?,?)");
	   System.out.println("enter the book name");
	   stmt.setString(1,sc1.next());
	   System.out.println("enter how many books you want?");
	   stmt.setInt(2,sc1.nextInt());
	   
	   System.out.println("**************************your order placed successfully*************************************");
	   con1.close();
 
    
   }
   void cancelorder() throws ClassNotFoundException, SQLException
   {
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","root");
	   PreparedStatement stmt = con.prepareStatement("delete from customer_orders where bookname=?");
	   System.out.println("enter the name of the book which  you want to cancel");
	   stmt.setString(1,sc1.next());
	   int i = stmt.executeUpdate();
	   System.out.println("................................Your order canceled...................");
	   con.close();
   }
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		CustomerReg cb = new CustomerReg();
		Scanner sc2 = new Scanner(System.in);
		    while(true)
		    {
		    	System.out.println("-----------Already Do you have a account in Royal book shop(yes(1)/no(2)-------------");
		    	int ch1= sc2.nextInt();
		    	switch(ch1)
		    	{
		    case 1:
				cb.customerLogin();
				break;
			case 2:
				cb.customerRegistration();
				break;
		    	}
			while(true)
			{
				
				
				System.out.println("------------3.View the books which are available in our shop-------------------");
				System.out.println("-------------------4.Order book---------------------------");
				System.out.println("--------------------5.cancel the order----------------------------");
				System.out.println("----------------------6.exit------------------------------------");
				int ch = sc2.nextInt();
				switch(ch)
				{
				
				case 3:
					cb.retriveBookdetails();
					break;
				case 4:
					cb.orderBook();
					break;
				case 5:
					cb.cancelorder();
					break;
				case 6:
					System.exit(0);
				default:
					System.out.println("-----------------Invalid entry------------------");
				}
			}
	}
	}
}
