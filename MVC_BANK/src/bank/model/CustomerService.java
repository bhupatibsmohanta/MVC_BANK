package bank.model;

import bank.db.Customer;

public class CustomerService 
{

	public static int doDepositAmount(Customer c) 
	{
		int status=0;
		double balance=CustomerDAO.getBalance(c);
		if(balance==-1)
			return -1;
		double amount=balance+c.getAmount();
		c.setAmount(amount);
		status=CustomerDAO.upadateDeposit(c);
		
		return status;
	}

}
