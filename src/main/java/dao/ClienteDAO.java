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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;

/**
 *
 * @author Usuario
 */
public class ClienteDAO {

    Logger logger = Logger.getLogger(this.getClass().getName());

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private ConexionBD conexion = new ConexionBD();

    public int registrarCliente(Cliente c) {
        logger.info("*** incio registrarCliente ***");
        int clienteId = 0;
        Connection cnn = conexion.connect();
        try {
            ps = cnn.prepareStatement("insert into cliente (Cli_Nombre, Cli_Apellido, "
                    + "Cli_Dni, Cli_Correo, Cli_FechaRegistro) values (?,?,?,?, now());",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getDni());
            ps.setString(4, c.getCorreo());

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                clienteId = rs.getInt(1);
            }

            ps.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Ocurri\u00f3 un error en el m\u00e9todo registrarCliente: {0}", e);
        } finally {
            conexion.disconnect(cnn);
        }
        logger.info("*** fin registrarCliente ***");
        return clienteId;
    }

}
