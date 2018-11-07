package bank.model;

import java.sql.*;

import bank.db.Customer;
import bank.db.Provider;

public class CustomerDAO 
{

	public static double getBalance(Customer c) 
	{
		double balance=0.0;
		try
		{
			Connection con=Provider.getConnection();
			String sql="Select amount from Customer where actno=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, c.getActno());
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				balance=rs.getDouble(1);
			}
			else
			{
				return -1;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return balance;
	}

	public static int upadateDeposit(Customer c) 
	{
		int status=0;
		try
		{
			Connection con=Provider.getConnection();
			String sql="update Customer set amount=? where actno=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setDouble(1, c.getAmount());
			pst.setInt(2, c.getActno());
			status=pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}

	

}
