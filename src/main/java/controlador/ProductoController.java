/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import com.google.gson.Gson;
import dao.ProductoDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import modelo.Producto;

/**
 *
 * @author Usuario
 */
public class ProductoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        if (accion.equals("listar")) {
            String nombre = request.getParameter("nombre");

            ProductoDAO productoDAO = new ProductoDAO();
            List<Producto> lista = productoDAO.listarProductos(nombre);

            String jsonListaProductos = new Gson().toJson(lista);
            response.getWriter().write(jsonListaProductos);

        } else if (accion.equals("obtener")) {
            ProductoDAO productoDAO = new ProductoDAO();
            int productoId = Integer.parseInt(request.getParameter("productoId"));
            Producto producto = productoDAO.obtenerProducto(productoId);

            String jsonObtenerProducto = new Gson().toJson(producto);
            response.getWriter().write(jsonObtenerProducto);
        } else {
            response.getWriter().write("acción desconocida");
        }

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        if (accion.equals("registrar")) {
            Producto p = new Producto();
            p.setNombre(request.getParameter("nombre"));
            p.setCantidadPorUnidad(Integer.parseInt(request.getParameter("cantidadPorUnidad")));
            p.setPrecioUnitario(Double.parseDouble(request.getParameter("precioUnitario")));
            p.setUnidadMedida(request.getParameter("unidadMedida"));
            p.setStock(Integer.parseInt(request.getParameter("stock")));
            p.setEstado(request.getParameter("estado"));
            p.setCategoriaId(Integer.parseInt(request.getParameter("categoriaId")));

            ProductoDAO productoDAO = new ProductoDAO();
            int estadoRegistro = productoDAO.registrarProducto(p);

            response.getWriter().write(String.valueOf(estadoRegistro));

        } else if (accion.equals("editar")) {
            Producto p = new Producto();
            p.setId(Integer.parseInt(request.getParameter("id")));
            p.setNombre(request.getParameter("nombre"));
            p.setCantidadPorUnidad(Integer.parseInt(request.getParameter("cantidadPorUnidad")));
            p.setPrecioUnitario(Double.parseDouble(request.getParameter("precioUnitario")));
            p.setUnidadMedida(request.getParameter("unidadMedida"));
            p.setStock(Integer.parseInt(request.getParameter("stock")));
            p.setEstado(request.getParameter("estado"));
            p.setCategoriaId(Integer.parseInt(request.getParameter("categoriaId")));

            ProductoDAO productoDAO = new ProductoDAO();
            int estadoEditar = productoDAO.editarProducto(p);

            response.getWriter().write(String.valueOf(estadoEditar));
        } else if (accion.equals("eliminar")) {

        } else {
            response.getWriter().write("acción desconocida");
        }

        processRequest(request, response);
    }

}
