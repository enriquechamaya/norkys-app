/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import modelo.Pedido;
import response.VistaDetallePedido;
import response.VistaPedidos;

/**
 *
 * @author Usuario
 */
public class PedidoDAO {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private ConexionBD conexion = new ConexionBD();

    public String registrarPedido(Pedido p) {
        int estadoRegistro = 0;
        String nroPedido = "";
        Connection cnn = conexion.connect();
        try {
            nroPedido = generarCodigo();
            ps = cnn.prepareStatement("insert into pedido (Ped_Numero, "
                    + "Ped_Estado, "
                    + "Ped_FechaPedido, "
                    + "Ped_Tipo, "
                    + "Mes_Id, "
                    + "Cli_Id) "
                    + "values (?,"
                    + "'PENDIENTE',"
                    + "NOW(),"
                    + "'CONSUMO EN RESTAURANT',"
                    + "1,?);");

            ps.setString(1, nroPedido);
            ps.setInt(2, p.getCliId());

            estadoRegistro = ps.executeUpdate();
            if (estadoRegistro > 0) {
                return nroPedido;
            }
            ps.close();
        } catch (SQLException e) {
            System.err.println("Ocurrió un error en el método registrarPedido: " + e);
        } finally {
            conexion.disconnect(cnn);
        }

        return nroPedido;
    }

    public List<VistaPedidos> listarPedidos(String nroPedido) {
        List<VistaPedidos> lista = new ArrayList<>();
        Connection cnn = conexion.connect();
        try {
            ps = cnn.prepareStatement("select p.Ped_Numero, p.Ped_Estado, p.Ped_FechaPedido, concat(c.Cli_Apellido, ' ', c.Cli_Nombre) AS cliente from pedido p "
                    + "inner join cliente c on p.Cli_Id = c.Cli_Id "
                    + "where p.Ped_Numero like ?;");
            ps.setString(1, "%" + nroPedido + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                VistaPedidos pedido = new VistaPedidos();
                pedido.setNroPedido(rs.getString("Ped_Numero"));
                pedido.setEstado(rs.getString("Ped_Estado"));
                pedido.setFecha(rs.getString("Ped_FechaPedido"));
                pedido.setCliente(rs.getString("cliente"));
                lista.add(pedido);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.err.println("Ocurrió un error en el método listarPedidos " + e);
        } finally {
            conexion.disconnect(cnn);
        }
        return lista;
    }

    public List<VistaDetallePedido> listarDetallePedido(String nroPedido) {
        List<VistaDetallePedido> lista = new ArrayList<>();
        Connection cnn = conexion.connect();
        try {
            ps = cnn.prepareStatement("select p.Pro_Nombre as Producto, dp.Cantidad, dp.PrecioUnitario, (dp.PrecioUnitario * dp.Cantidad) AS Subtotal from detalle_pedido dp "
                    + "inner join producto p on dp.Pro_Id = p.Pro_Id "
                    + "where dp.Ped_Numero = ?;");
            ps.setString(1, nroPedido);
            rs = ps.executeQuery();
            while (rs.next()) {
                VistaDetallePedido pedido = new VistaDetallePedido();
                pedido.setProducto(rs.getString("Producto"));
                pedido.setCantidad(rs.getString("Cantidad"));
                pedido.setPrecio(rs.getString("PrecioUnitario"));
                pedido.setSubtotal(rs.getString("Subtotal"));
                lista.add(pedido);
            }
            System.out.println("nropeid === " + nroPedido);
            System.out.println("sizee === " + lista.size());
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.err.println("Ocurrió un error en el método listarDetallePedido " + e);
        } finally {
            conexion.disconnect(cnn);
        }
        return lista;
    }

    private String generarCodigo() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(900) + 100;
        String codigo = "P" + numeroAleatorio;
        return codigo;
    }

    public int editarEstadoPedido(String nroPedido, String estado) {
        int estadoEditar = 0;
        Connection cnn = conexion.connect();
        try {
            ps = cnn.prepareStatement("update pedido set Ped_Estado = ? "
                    + "where Ped_Numero = ?");
            ps.setString(1, estado);
            ps.setString(2, nroPedido);

            estadoEditar = ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            System.err.println("Ocurrió un error en el método editarEstadoPedido " + e);
        } finally {
            conexion.disconnect(cnn);
        }

        return estadoEditar;
    }
}
