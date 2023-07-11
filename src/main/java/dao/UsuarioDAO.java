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
import modelo.Usuario;

/**
 *
 * @author Usuario
 */
public class UsuarioDAO {

    Logger logger = Logger.getLogger(this.getClass().getName());

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private ConexionBD conexion = new ConexionBD();

    public Usuario login(String username, String password) {
        logger.info("*** incio login ***");
        Connection cnn = conexion.connect();

        Usuario usuario = new Usuario();
        try {
            ps = cnn.prepareStatement("select * from usuario where usu_nombre = ? and usu_contraseña= ?;");
            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();
            while (rs.next()) {
                usuario.setId(rs.getInt("usu_id"));
                usuario.setNombre(rs.getString("usu_nombre"));
                usuario.setEstado(rs.getString("usu_estado"));
                usuario.setFechaRegistro(rs.getDate("usu_fecharegistro"));
                usuario.setRolId(rs.getInt("rol_id"));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Ocurri\u00f3 un error en el m\u00e9todo login {0}", e);
        } finally {
            conexion.disconnect(cnn);
        }
        logger.info("*** fin login ***");
        return usuario;
    }

    public Boolean validarUserName(Usuario usuario) {
        logger.info("*** inicio validarUserName ***");
        Connection cnn = conexion.connect();
        Boolean encontrado = false;
        try {
            ps = cnn.prepareStatement("select * from usuario where usu_nombre = ?;");
            ps.setString(1, usuario.getNombre());
            rs = ps.executeQuery();
            encontrado = (!rs.next());
            ps.close();
            rs.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Ocurri\u00f3 un error en el m\u00e9todo login {0}", e);
        } finally {
            conexion.disconnect(cnn);
        }
        logger.info("*** fin validarUserName ***");
        return encontrado;
    }

    public int registrar(Usuario usuario) {
        logger.info("*** inicio registrar ***");
        Connection cnn = conexion.connect();
        int status = 0;
        try {
            ps = cnn.prepareStatement("insert into usuario (usu_nombre,usu_contraseña,usu_estado,usu_fecharegistro,rol_id)"
                    + "values ('" + usuario.getNombre() + "','" + usuario.getContrasena() + "','" + usuario.getEstado() + "',now(),'" + usuario.getRolId() + "' )");
            status = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Ocurri\u00f3 un error en el m\u00e9todo login {0}", e);
        } finally {
            conexion.disconnect(cnn);
        }
        logger.info("*** fin registrar ***");
        return status;
    }

}
