<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<center><font size="15" color="red">
		<%
			String status=request.getParameter("status");
			if(status != null)
			{
				if(status.equals("-1"))
					out.println("Actno doesn't exists....");
				else if(status.equals("0"))
					out.println("Error in updation....");
				else
					out.println("Amount Updated Sucessfully....");
			}
		%>
		</font></center><br><br>
		
	<center><h2>Enter Account Details....</h2>
	<form action="bank.controller.Deposit">
		
			Actno	:	<input type="text" name="actno"><br><br><br>
			
			Amount	:	<input type="text" name="amount"><br><br><br>
					<input type="submit" value="Deposit">
		</center>
	</form>
</body>
</html>