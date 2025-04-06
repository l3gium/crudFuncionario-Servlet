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

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	//desenvolvido por Beatriz Bastos e Miguel Luizatto
        res.setContentType("text/html; charset=UTF-8");
        PrintWriter out = res.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='pt-br'>");
        out.println("<head>");
        out.println("  <meta charset='UTF-8'>");
        out.println("  <title>Atualizar Funcionário</title>");
        out.println("  <style>");
        out.println("    * { margin: 0; padding: 0; box-sizing: border-box; }");
        out.println("    body { font-family: Arial, sans-serif; background: #f7f7f7; color: #333; padding: 20px; }");
        out.println("    header { background: #2c3e50; color: #fff; padding: 20px; text-align: center; border-radius: 5px; margin-bottom: 30px; }");
        out.println("    header h1 { font-size: 24px; }");
        out.println("    main { max-width: 500px; background: #fff; margin: 0 auto; padding: 30px; border-radius: 5px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }");
        out.println("    .form-group { margin-bottom: 15px; }");
        out.println("    .form-group label { display: block; margin-bottom: 5px; font-weight: bold; color: #2c3e50; }");
        out.println("    .form-group input { width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 3px; }");
        out.println("    .submit-btn { width: 100%; padding: 12px; background: #3498db; color: #fff; border: none; border-radius: 3px; font-size: 16px; cursor: pointer; transition: background 0.3s ease; margin-top: 10px; }");
        out.println("    .submit-btn:hover { background: #2980b9; }");
        out.println("  </style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<header>");
        out.println("  <h1>Atualizar Funcionário</h1>");
        out.println("</header>");

        out.println("<main>");

        String sid = req.getParameter("id");
        int id = Integer.parseInt(sid);
        Emp e = EmpDao.getEmployeeById(id);

        out.println("<form action='EditServlet2' method='post'>");

        out.println("  <input type='hidden' name='id' value='" + e.getId() + "' />");

        out.println("  <div class='form-group'>");
        out.println("    <label for='name'>Nome:</label>");
        out.println("    <input type='text' id='name' name='name' value='" + e.getName() + "' required />");
        out.println("  </div>");

        out.println("  <div class='form-group'>");
        out.println("    <label for='password'>Senha:</label>");
        out.println("    <input type='password' id='password' name='password' value='" + e.getPassword() + "' required />");
        out.println("  </div>");

        out.println("  <div class='form-group'>");
        out.println("    <label for='email'>Email:</label>");
        out.println("    <input type='email' id='email' name='email' value='" + e.getEmail() + "' required />");
        out.println("  </div>");

        out.println("  <input type='submit' class='submit-btn' value='Salvar'/>");

        out.println("</form>");
        out.println("</main>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}
