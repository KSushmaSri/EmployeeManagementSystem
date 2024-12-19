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

@WebServlet("/delete")
public class DeleteEmployee extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String rollnumber=req.getParameter("rollnumber");
	EmployeeService service = new EmployeeService(EmployeeDbconnection.getConnection());
	boolean f=service.deletebyrollnumber(rollnumber);
	if(f) {
		resp.sendRedirect("");
	}
	else {
		resp.sendRedirect("");
	}
}
}
