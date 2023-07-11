/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import com.google.gson.Gson;
import dao.UsuarioDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import modelo.Usuario;

/**
 *
 * @author Dylan
 */
public class RegistroUsuarioController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        response.sendRedirect("vistas/usuarios/registrarUsuario.jsp");        
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Map<String, String> map = new HashMap<>();
        Gson json = new Gson();
        String jsonData;
        
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        String apellidos = request.getParameter("apellidos");
        String dni = request.getParameter("dni");
        String username = request.getParameter("usuario");
        
        Usuario usuario = new Usuario();
        usuario.setNombre(username);
        usuario.setContrasena(password);
        usuario.setEstado("1");
        usuario.setFechaRegistro(new Date());
        usuario.setRolId(1);
        
        if(usuarioDao.validarUserName(usuario)){
            int status = usuarioDao.registrar(usuario);
            if(status == 1){
                map.put("data","Nuevo usuario registrado");
                map.put("css","success");
            }else{
                map.put("data","Ocurrio un error al guardar los datos");
                map.put("css","danger");
            }
        }else{
            map.put("data","Nombre de usuario ya registrado");
            map.put("css","danger");
        }
        
        jsonData = json.toJson(map);
        
        response.getWriter().write(jsonData);
        processRequest(request, response);
    }
}
