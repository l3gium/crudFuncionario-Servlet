package crudUsuario.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudUsuario.dao.EmpDao;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet
{
	//desenvolvido por Beatriz Bastos e Miguel Luizatto

	 protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	 {
		 int id = Integer.parseInt(req.getParameter("id"));
		 EmpDao.delete(id);
		 res.sendRedirect("ViewServlet");
	 }
}
