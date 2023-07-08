/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.ClienteDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Cliente;

/**
 *
 * @author Usuario
 */
public class ClienteController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        if (accion.equals("registrar")) {
            Cliente cliente = new Cliente();
            cliente.setNombre(request.getParameter("nombres"));
            cliente.setApellido(request.getParameter("apellidos"));
            cliente.setDni(request.getParameter("dni"));
            cliente.setCorreo(request.getParameter("correo"));

            ClienteDAO clienteDAO = new ClienteDAO();
            int clienteId = clienteDAO.registrarCliente(cliente);

            response.getWriter().write(String.valueOf(clienteId));
        }

        processRequest(request, response);
    }

}
