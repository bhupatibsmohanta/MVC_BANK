package bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.db.Customer;
import bank.model.CustomerService;

@WebServlet("/bank.controller.Deposit")
public class Deposit extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		int actno=Integer.parseInt(request.getParameter("actno"));
		double amount=Double.parseDouble(request.getParameter("amount"));
		
		Customer c=new Customer();
		c.setActno(actno);
		c.setAmount(amount);
		
		int status=CustomerService.doDepositAmount(c);
		response.sendRedirect("index.jsp?status="+status);
		
	}

}

