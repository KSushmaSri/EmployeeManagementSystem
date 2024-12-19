package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.Employee;

public class EmployeeService {
	private Connection conn;

	public EmployeeService(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean addEmployee(Employee emp) {
		boolean f=false;
		try {
			String sql="insert into employee (rollnumber,employeename,email,address,pincode,phonenumber,gender) values (?,?,?,?,?,?,?)";
			PreparedStatement pmst=conn.prepareStatement(sql);
			pmst.setString(1, emp.getRollnumber());
			pmst.setString(2, emp.getEmployeename());
			pmst.setString(3, emp.getEmail());
			pmst.setString(4, emp.getAddress());
			pmst.setInt(5, emp.getPincode());
			pmst.setLong(6, emp.getPhonenumber());
			pmst.setInt(7, emp.getGender());
			pmst.setString(7, emp.getPassword());
			int i=pmst.executeUpdate();
			if(i==1) {
				f=true;
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public List<Employee> getAllEmployees(){
		List<Employee> li = new ArrayList<Employee>();
		Employee e=null;
		try {
			String sql="select * from employee";
			PreparedStatement pmst=conn.prepareStatement(sql);
			ResultSet rs=pmst.executeQuery();
			while(rs.next()) {
				e=new Employee();
				e.setRollnumber(rs.getString(1));
				e.setEmployeename(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setAddress(rs.getString(4));
				e.setPincode(rs.getInt(5));
				e.setPhonenumber(rs.getLong(6));
				e.setGender(rs.getInt(7));
				e.setPassword(rs.getString(8));
				li.add(e);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return li;
	}
	public Employee getbyemail(String email) {
		Employee s=null;
		try {
			String sql="select * from employee where email=?";
			PreparedStatement pmst=conn.prepareStatement(sql);
			pmst.setString(1, email);
			ResultSet rs=pmst.executeQuery();
			while(rs.next()) {
				s=new Employee();
				s.setRollnumber(rs.getString(1));
				s.setEmployeename(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setAddress(rs.getString(4));
				s.setPincode(rs.getInt(5));
				s.setPhonenumber(rs.getLong(6));
				s.setGender(rs.getInt(7));
				s.setPassword(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	public boolean updateemployee(Employee e1) {
		boolean f=false;
		try {
			String sql="update employee set rollnumber=?,employeename=?,email=?,address=?,pincode=?,phonenumber=?,gender=? where email=?";
			PreparedStatement pmst=conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			pmst.setString(1, e1.getRollnumber());
			pmst.setString(2, e1.getEmployeename());
			pmst.setString(3, e1.getEmail());
			pmst.setString(4, e1.getAddress());
			pmst.setInt(5, e1.getPincode());
			pmst.setLong(6, e1.getPhonenumber());
			pmst.setInt(7, e1.getGender());
			pmst.setString(8, e1.getPassword());
			if(i==1) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public boolean deletebyrollnumber(String rollnumber) {
		boolean f=false;
		try {
			String sql="delete from employee where rollnumber=?";
			PreparedStatement pmst=conn.prepareStatement(sql);
			pmst.setString(1, rollnumber);
			int i = pmst.executeUpdate();
			if(i==1) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public boolean login(String email,String password) {
		boolean f=false;
		try {
			String sql="select * from employee where email=? and password=?";
			PreparedStatement pmst=conn.prepareStatement(sql);
			pmst.setString(1, email);
			pmst.setString(2, password);
			ResultSet rs=pmst.executeQuery();
			while(rs.next()) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
