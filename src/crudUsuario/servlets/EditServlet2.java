package crudUsuario.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudUsuario.model.Emp;
import crudUsuario.dao.EmpDao;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet
{
	//desenvolvido por Beatriz Bastos e Miguel Luizatto

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        
        Emp e = new Emp();
        e.setId(id);
        e.setName(name);
        e.setPassword(password);
        e.setEmail(email);
        
        int status = EmpDao.update(e);
        
        if(status > 0){
            res.sendRedirect("ViewServlet");
        } else {
            out.println("Erro ao atualizar funcionário. Tente novamente");
            
            out.close();
        }
	}
}
