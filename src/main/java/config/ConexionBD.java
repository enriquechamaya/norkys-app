/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ConexionBD {

    Logger logger = Logger.getLogger(this.getClass().getName());

//    private static final String URL = "jdbc:mysql://db4free.net:3306/bd_pedidos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
//    private static final String USER = "integrador2";
//    private static final String PASSWORD = "integrador2";
    private static final String URL = "jdbc:mysql://10.100.50.118:3306/bd_pedidos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "MAYamq36299";

    public Connection connect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            logger.info("Conexión exitosa a la base de datos.");
        } catch (SQLException | ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Error al conectar a la base de datos: {0}", e.getMessage());
        }
        return connection;
    }

    public void disconnect(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                logger.info("Desconexión exitosa de la base de datos.");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al desconectar de la base de datos: {0}", e.getMessage());
        }
    }

}
