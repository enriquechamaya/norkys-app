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
import java.util.logging.Level;
import java.util.logging.Logger;
import response.VistaReporte;

/**
 *
 * @author Usuario
 */
public class ReporteDAO {

    Logger logger = Logger.getLogger(this.getClass().getName());

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private ConexionBD conexion = new ConexionBD();

    public List<VistaReporte> listarReporte(String fechaInicio, String FechaFin) {
        logger.info("*** incio listarReporte ***");
        List<VistaReporte> lista = new ArrayList<>();
        Connection cnn = conexion.connect();
        try {
            ps = cnn.prepareStatement("select v.Ven_NumDoc as nroVenta, v.Ven_FechaPedido as fechaVenta, "
                    + "v.Ven_SubTotal as subtotal, v.Ven_Igv as igv, v.Ven_Total as total, "
                    + "concat(c.Cli_Nombre,' ', c.Cli_Apellido) as cliente, u.Usu_Nombre as usuario "
                    + "from venta v "
                    + "inner join cliente c on v.Cli_Id = c.Cli_Id "
                    + "inner join usuario u ON v.Usu_Id = u.Usu_Id "
                    + "where date_format(v.Ven_FechaPedido, '%d/%m/%Y') between ? and ? ;");

            ps.setString(1, fechaInicio);
            ps.setString(2, FechaFin);

            rs = ps.executeQuery();

            while (rs.next()) {
                VistaReporte reporte = new VistaReporte();
                reporte.setNroVenta(rs.getString("nroVenta"));
                reporte.setFechaVenta(rs.getString("fechaVenta"));
                reporte.setSubtotal(rs.getString("subtotal"));
                reporte.setIgv(rs.getString("igv"));
                reporte.setTotal(rs.getString("total"));
                reporte.setCliente(rs.getString("cliente"));
                reporte.setUsuario(rs.getString("usuario"));
                lista.add(reporte);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Ocurri\u00f3 un error en el m\u00e9todo listarReporte: {0}", e);
        } finally {
            conexion.disconnect(cnn);
        }
        logger.info("*** fin listarReporte ***");
        return lista;
    }

}
