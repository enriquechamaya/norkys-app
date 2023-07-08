/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dao.ClienteDAO;
import dao.DetallePedidoDAO;
import dao.PedidoDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.DetallePedido;
import modelo.Pedido;

/**
 *
 * @author Usuario
 */
public class PedidoController extends HttpServlet {

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
            // registrar cliente
            Cliente cliente = new Cliente();
            cliente.setNombre(request.getParameter("nombres"));
            cliente.setApellido(request.getParameter("apellidos"));
            cliente.setDni(request.getParameter("dni"));
            cliente.setCorreo(request.getParameter("correo"));

            ClienteDAO clienteDAO = new ClienteDAO();
            int clienteId = clienteDAO.registrarCliente(cliente);

            if (clienteId > 0) {
                registrarPedido(clienteId, request, response);
            }
        }

        processRequest(request, response);
    }

    private void registrarPedido(int clienteId, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        Pedido pedido = new Pedido();
        pedido.setCliId(clienteId);

        PedidoDAO pedidoDAO = new PedidoDAO();
        String nroPedido = pedidoDAO.registrarPedido(pedido);

        if (nroPedido.length() > 0) {
            registrarDetallePedido(nroPedido, request, response);
        }
    }

    private void registrarDetallePedido(String nroPedido, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // registrar detalle pedido
        JsonArray productosGson = new Gson().fromJson(request.getParameter("pedido"), JsonArray.class);

        List<DetallePedido> detallePedidoList = new ArrayList<>();

        for (JsonElement obj : productosGson) {
            JsonObject gsonObj = obj.getAsJsonObject();

            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setPedidoId(nroPedido);
            detallePedido.setProductoId(gsonObj.get("id").getAsInt());
            detallePedido.setCantidad(gsonObj.get("cantidad").getAsInt());
            detallePedido.setPrecioUnitario(gsonObj.get("precio").getAsDouble());
            detallePedidoList.add(detallePedido);
        }

        boolean errorRegistroDetallePedido = false;

        DetallePedidoDAO detallePedidoDAO = new DetallePedidoDAO();

        for (int i = 0; i < detallePedidoList.size(); i++) {
            int estadoRegistro = detallePedidoDAO.registrarDetallePedido(detallePedidoList.get(i));
            if (estadoRegistro > 0) {
                errorRegistroDetallePedido = false;
            } else {
                errorRegistroDetallePedido = true;
                break;
            }
        }

        String json;
        if (errorRegistroDetallePedido) {
            json = new Gson().toJson("");
        } else {
            json = new Gson().toJson(nroPedido);
        }
        response.getWriter().write(json);

    }

}
