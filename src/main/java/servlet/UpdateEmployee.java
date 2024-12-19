package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnections.EmployeeDbconnection;
import models.Employee;
import services.EmployeeService;

@WebServlet("/update")
public class UpdateEmployee extends HttpServlet{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  String rollnumber=req.getParameter("rollnumber");
		String employeename=req.getParameter("employeename");
		String email=req.getParameter("email");
		String address=req.getParameter("address");
		int pincode=Integer.parseInt(req.getParameter("pincode"));
		long phonenumber=Long.parseLong(req.getParameter("phonenumber"));
		int gender=Integer.parseInt(req.getParameter("gender"));
		String password=req.getParameter("password");
		Employee e = new Employee(rollnumber,employeename,email,address,pincode,phonenumber,gender,password);
		EmployeeService service= new EmployeeService(EmployeeDbconnection.getConnection());
		boolean f=service.updateemployee(e);
		if(f) {
			resp.sendRedirect("");
		}
		else {
			resp.sendRedirect("");
		}
}
}
