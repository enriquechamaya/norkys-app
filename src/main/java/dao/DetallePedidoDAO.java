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
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.DetallePedido;

/**
 *
 * @author Usuario
 */
public class DetallePedidoDAO {
    Logger logger = Logger.getLogger(this.getClass().getName());

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private ConexionBD conexion = new ConexionBD();

    public int registrarDetallePedido(DetallePedido dp) {
        logger.info("*** incio registrarDetallePedido ***");
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
            logger.log(Level.SEVERE, "Ocurri\u00f3 un error en el m\u00e9todo registrarCliente: {0}", e);
        } finally {
            conexion.disconnect(cnn);
        }
        logger.info("*** fin registrarDetallePedido ***");
        return estadoRegistro;
    }
}
