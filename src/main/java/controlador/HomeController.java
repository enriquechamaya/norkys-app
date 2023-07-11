/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
            
            request.setAttribute("username", username);
            request.setAttribute("id", id);
            request.setAttribute("rol", rol);

            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/vistas/base/header.jsp");
            dispatcher.forward(request, response);
        }else{
            response.sendRedirect("/vistas/login/login.jsp");
        }
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
