package crudUsuario.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudUsuario.dao.EmpDao;
import crudUsuario.model.Emp;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet 
{
	//desenvolvido por Beatriz Bastos e Miguel Luizatto

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		Emp e = new Emp();
		
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		
		int status = EmpDao.save(e);
		
		if(status > 0)
		{
			out.print("<p>Funcionário cadastrado com sucesso!</p>");
			req.getRequestDispatcher("index.html").include(req, res);
		} 
		else
		{
			out.print("<p>Houve um erro ao tentar cadastrar o funcionário. Tente novamente.</p>");
		}
		
		out.close();
	}
}
