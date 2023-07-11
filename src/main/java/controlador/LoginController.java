/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.UsuarioDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author Dylan
 */
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        HttpSession sesion = request.getSession();

        if (accion != null) {
            if (accion.equals("logout")) {
                if (sesion.getAttribute("username") != null) {
                    sesion.invalidate();

                    response.setHeader("Pragma", "no-cache");
                    response.setHeader("Cache-Control", "no-store");
                    response.setHeader("Expires", "0");
                    response.setDateHeader("Expires", -1);

                    response.sendRedirect("/norkys-app-utp/vistas/login/login.jsp");
                }
            }
        } else {
            if (sesion.getAttribute("username") != null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/vistas/menu/menuPrincipal.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect("/norkys-app-utp/vistas/login/login.jsp");
            }
        }

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("usuario");
        String password = request.getParameter("password");

        UsuarioDAO usuarioDao = new UsuarioDAO();
        Usuario usuario = usuarioDao.login(user, password);

        if (usuario.exists()) {
            HttpSession session = request.getSession();
            session.setAttribute("user", usuario.getNombre());
            session.setAttribute("id", usuario.getId());
            session.setAttribute("rol", usuario.getRolId());

            session.setAttribute("username", usuario.getNombre());
            session.setAttribute("usernameId", usuario.getId());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/vistas/menu/menuPrincipal.jsp");
            dispatcher.forward(request, response);

        } else {
            response.sendRedirect("/norkys-app-utp/LoginController");
        }

        processRequest(request, response);
    }
}
