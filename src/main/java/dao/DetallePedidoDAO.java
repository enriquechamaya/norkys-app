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
import modelo.DetallePedido;

/**
 *
 * @author Usuario
 */
public class DetallePedidoDAO {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private ConexionBD conexion = new ConexionBD();

    public int registrarDetallePedido(DetallePedido dp) {
        int estadoRegistro = 0;
        Connection cnn = conexion.connect();
        try {
            ps = cnn.prepareStatement("insert into detalle_pedido (PrecioUnitario, "
                    + "Cantidad, "
                    + "Descuento, "
                    + "Pro_Id, "
                    + "Ped_Numero) "
                    + "values (?,?,0,?,?)");

            ps.setDouble(1, dp.getPrecioUnitario());
            ps.setInt(2, dp.getCantidad());
            ps.setInt(3, dp.getProductoId());
            ps.setString(4, dp.getPedidoId());

            estadoRegistro = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Ocurrió un error en el método registrarCliente: " + e);
        } finally {
            conexion.disconnect(cnn);
        }
        return estadoRegistro;
    }
}
