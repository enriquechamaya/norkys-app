/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;
import dao.UsuarioDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author Dylan
 */

public class HomeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        if(request.getSession(false)!= null ){
            HttpSession session =request.getSession();
            String username = (String)session.getAttribute("username");  
            Integer id = (Integer) session.getAttribute("id");
            Integer rol = (Integer) session.getAttribute("rol");    
            
            System.out.println(username);
            request.setAttribute("username", username);
            request.setAttribute("id", id);
            request.setAttribute("rol", rol);
            System.out.println(request.getAttribute("username"));
            /*RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/vistas/menu/menuPrincipal.jsp");
            dispatcher.forward(request, response);
            response.sendRedirect("/norkys-app-utp/vistas/menu/menuPrincipal.jsp");*/
            
            
            /*request.getRequestDispatcher("/vistas/menu/menuPrincipal.jsp").forward(request,response);            
            session.setAttribute("username",username);
            response.sendRedirect("/vistas/menu/menuPrincipal.jsp");*/

            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/vistas/base/header.jsp");
            dispatcher.forward(request, response);
        }else{
            response.sendRedirect("/norkys-app-utp/vistas/login/login.jsp");
        }
     
        /*try{
            HttpSession session=request.getSession(false);
            String username = (String)session.getAttribute("username");  
            String id = (String)session.getAttribute("id");
            String rol = (String)session.getAttribute("rol");    
            
            request.setAttribute("username", username);
            request.setAttribute("id", id);
            request.setAttribute("rol", rol);
            
            request.getRequestDispatcher("/norkys-app-utp/vistas/menu/menuPrincipal.jsp").forward(request, response);            
            request.getRequestDispatcher("/norkys-app-utp/vistas/login/login.jsp").forward(request, response);
            response.sendRedirect("/norkys-app-utp/vistas/menu/menuPrincipal.jsp");
        }catch (IOException e) {
            response.sendRedirect("/norkys-app-utp/vistas/login/login.jsp");
        }*/
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
