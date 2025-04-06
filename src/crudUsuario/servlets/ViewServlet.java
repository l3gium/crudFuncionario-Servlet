package crudUsuario.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudUsuario.dao.EmpDao;
import crudUsuario.model.Emp;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet 
{
	//desenvolvido por Beatriz Bastos e Miguel Luizatto

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
    {
        
        res.setContentType("text/html; charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html lang='pt-br'>");
        out.println("<head>");
        out.println("  <meta charset='UTF-8'>");
        out.println("  <title>Lista de Empregados</title>");
        
        out.println("  <style>");
        out.println("    * { margin: 0; padding: 0; box-sizing: border-box; }");
        out.println("    body { font-family: Arial, sans-serif; background: #f7f7f7; color: #333; padding: 20px; }");
        out.println("    header { display: flex; justify-content: space-between; align-items: center; background: #2c3e50; color: #fff; padding: 20px; border-radius: 5px; margin-bottom: 30px; }");
        out.println("    header h1 { font-size: 24px; }");
        out.println("    .new-employee { color: #fff; text-decoration: none; font-weight: bold; background: #3498db; padding: 10px 20px; border-radius: 4px; transition: background 0.3s; }");
        out.println("    .new-employee:hover { background: #2980b9; }");
        out.println("    main { background: #fff; padding: 20px; border-radius: 5px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }");
        out.println("    table { width: 100%; border-collapse: collapse; margin-top: 10px; }");
        out.println("    thead { background: #3498db; color: #fff; }");
        out.println("    th, td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }");
        out.println("    tr:hover { background-color: #f2f2f2; }");
        out.println("    .action-links a { margin-right: 15px; color: #3498db; text-decoration: none; font-weight: bold; }");
        out.println("    .action-links a:hover { color: #2980b9; }");
        out.println("  </style>");
        
        out.println("</head>");
        out.println("<body>");
        
        out.println("<header>");
        out.println("  <h1>Lista de Empregados</h1>");
        out.println("  <a class='new-employee' href='index.html'>Adicionar novo funcionário</a>");
        out.println("</header>");
        
        out.println("<main>");
        
        List<Emp> list = EmpDao.getAllEmployees();
        
        out.println("<table>");
        out.println("  <thead>");
        out.println("    <tr>");
        out.println("      <th>Id</th>");
        out.println("      <th>Nome</th>");
        out.println("      <th>Senha</th>");
        out.println("      <th>Email</th>");
        out.println("      <th>Ações</th>");
        out.println("    </tr>");
        out.println("  </thead>");
        out.println("  <tbody>");
        
        for(Emp e : list) 
        {
            out.println("<tr>");
            out.println("  <td>" + e.getId() + "</td>");
            out.println("  <td>" + e.getName() + "</td>");
            out.println("  <td>" + e.getPassword() + "</td>");
            out.println("  <td>" + e.getEmail() + "</td>");
            out.println("  <td class='action-links'>");
            out.println("    <a href='EditServlet?id=" + e.getId() + "'>Editar</a>");
            out.println("    <a href='DeleteServlet?id=" + e.getId() + "'>Excluir</a>");
            out.println("  </td>");
            out.println("</tr>");
        }
        
        out.println("  </tbody>");
        out.println("</table>");
        
        out.println("</main>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
}
