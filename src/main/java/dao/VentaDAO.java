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
import java.util.Random;
import modelo.Venta;

/**
 *
 * @author Usuario
 */
public class VentaDAO {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private ConexionBD conexion = new ConexionBD();

    public int registroVenta(Venta v) {
        int estadoRegistro = 0;
        Connection cnn = conexion.connect();
        try {
            ps = cnn.prepareStatement("insert into venta (Ven_NumDoc, "
                    + "Ven_TipoDoc, Ven_SubTotal, Ven_Igv, Ven_Total, "
                    + "Ven_FechaPedido, Ped_Numero, Cli_Id, Usu_Id) "
                    + "values (?,?,?,?,?,now(),?,?,?)");

            ps.setInt(1, generarNumeroDocumentoVenta());
            ps.setString(2, "COMPROBANTE DE PAGO");
            ps.setDouble(3, v.getSubtotal());
            ps.setDouble(4, v.getIgv());
            ps.setDouble(5, v.getTotal());
            ps.setString(6, v.getPedidoId());
            ps.setInt(7, v.getClienteId());
            ps.setInt(8, v.getUsuarioId());

            estadoRegistro = ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            System.err.println("Ocurrió un error en el método registroVenta: " + e);
        } finally {
            conexion.disconnect(cnn);
        }

        return estadoRegistro;
    }

    private int generarNumeroDocumentoVenta() {
        Random random = new Random();
        return random.nextInt(90000000) + 10000000;
    }

}
