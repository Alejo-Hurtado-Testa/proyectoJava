package servlets;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet(name = "SvRegistrarse", urlPatterns = {"/SvRegistrarse"})
public class SvRegistrarse extends HttpServlet {

    UsuarioDAO usuariodao = new UsuarioDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String pais = request.getParameter("pais");
        
        try {
            Usuario usuario = new Usuario(nombre, apellido, email, password, pais);
            usuariodao.insertarUsuario(usuario);
            response.sendRedirect("index.html");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("NO SE PUDO GUARDAR EL USUARIO");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
