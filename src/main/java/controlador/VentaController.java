/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dao.PedidoDAO;
import dao.ProductoDAO;
import dao.VentaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.math.RoundingMode;
import modelo.Producto;
import modelo.Venta;

/**
 *
 * @author Usuario
 */
public class VentaController extends HttpServlet {

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

            Venta venta = new Venta();

            venta.setSubtotal(Double.parseDouble(request.getParameter("subtotal")));
            venta.setIgv(Double.parseDouble(request.getParameter("igv")));
            venta.setTotal(Double.parseDouble(request.getParameter("total")));

            venta.setPedidoId(request.getParameter("pedidoId"));
            venta.setClienteId(Integer.parseInt(request.getParameter("clienteId")));
            venta.setUsuarioId(Integer.parseInt(request.getParameter("usuarioId")));

            // registrar venta
            VentaDAO ventaDAO = new VentaDAO();
            int estadoRegistro = ventaDAO.registroVenta(venta);

            if (estadoRegistro > 0) {
                actualizarEstadoPedido(venta.getPedidoId(), request, response);
            } else {
                response.getWriter().write(String.valueOf(0));
            }
        }

        processRequest(request, response);
    }

    private void actualizarEstadoPedido(String nroPedido, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PedidoDAO pedidoDAO = new PedidoDAO();
        int estadoEditarPedido = pedidoDAO.editarEstadoPedido(nroPedido, "PAGADO");
        if (estadoEditarPedido > 0) {
            actualizarStockProducto(request, response);
        }
    }

    private void actualizarStockProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JsonArray productosGson = new Gson().fromJson(request.getParameter("productos"), JsonArray.class);

        int productosActualizados = 0;
        for (JsonElement obj : productosGson) {
            JsonObject gsonObj = obj.getAsJsonObject();

            int productoId = gsonObj.get("productoId").getAsInt();
            int stock = gsonObj.get("stock").getAsInt();
            int cantidad = gsonObj.get("cantidad").getAsInt();
            int nuevoStock = stock - cantidad;

            Producto producto = new Producto();
            producto.setId(productoId);
            producto.setStock(nuevoStock);

            ProductoDAO productoDAO = new ProductoDAO();
            int estadoEditarProducto = productoDAO.editarStock(producto);
            if (estadoEditarProducto > 0) {
                productosActualizados++;
            } else {
                response.getWriter().write(String.valueOf(0));
            }
        }

        if (productosActualizados == productosGson.size()) {
            response.getWriter().write(String.valueOf(productosActualizados));
        } else {
            response.getWriter().write(String.valueOf(0));
        }
    }

}
