package crudUsuario.dao;

import crudUsuario.model.Emp;
import java.util.*;
import java.sql.*;

public class EmpDao 
{
	//desenvolvido por Beatriz Bastos e Miguel Luizatto
	public static Connection getConnection()
	{
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/cbtswe1?useSSL=false&serverTimezone=UTC";
			String user = "root";
			String password = "admin";
			
			con = DriverManager.getConnection(url, user, password);
		}
		catch (Exception ex) 
		{
			System.out.print("Um erro ocorreu: " + ex);
		}
		
		return con;
	}
	
	public static int save(Emp e) 
	{
		int status = 0;
		
		try
		{
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
				"insert into user(name, password, email) values (?, ?, ?)"
			);
			
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			
			status = ps.executeUpdate();
			con.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		return status;
	}
	
	public static int update(Emp e)
	{
		int status = 0;
		
		try
		{
			Connection con = EmpDao.getConnection();
			
			PreparedStatement ps = con.prepareStatement(
				"update user set name=?, password=?, email=? where id=?"
			);
			
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setInt(4, e.getId());
			
			status = ps.executeUpdate();
			con.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		return status;
	}
	
	public static int delete(Emp e)
	{
		int status = 0;
		
		try
		{
			Connection con = EmpDao.getConnection();
			
			PreparedStatement ps = con.prepareStatement(
				"delete from user where id=?"
			);
			
			ps.setInt(1, e.getId());
			
			status = ps.executeUpdate();
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return status;
	}
	
	public static int delete(int id)
	{
		int status = 0;
		
		try
		{
			Connection con = EmpDao.getConnection();
			
			PreparedStatement ps = con.prepareStatement(
				"delete from user where id=?"
			);
			
			ps.setInt(1, id);
			
			status = ps.executeUpdate();
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return status;
	}
	
	public static Emp getEmployeeById(int id)
	{
		Emp e = new Emp();
		
		try
		{
			Connection con = EmpDao.getConnection();
			
			PreparedStatement ps = con.prepareStatement(
				"select * from user where id=?"
			);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
			}
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return e;
	}
	
	public static List<Emp> getAllEmployees()
	{
		List<Emp> list = new ArrayList<Emp>();
		
		try
		{
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
				"select * from user"
			);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Emp e = new Emp();
				
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				
				list.add(e);
			}
			
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return list;
	}
}
