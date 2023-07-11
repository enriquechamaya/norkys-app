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
import modelo.Categoria;

/**
 *
 * @author Usuario
 */
public class CategoriaDAO {

    Logger logger = Logger.getLogger(this.getClass().getName());

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private ConexionBD conexion = new ConexionBD();

    public List<Categoria> listarCategorias() {
        logger.info("*** incio listarCategorias ***");
        List<Categoria> lista = new ArrayList<>();
        Connection cnn = conexion.connect();
        try {
            ps = cnn.prepareStatement("select * from categoria;");
            rs = ps.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("Cat_Id"));
                categoria.setNombre(rs.getString("Cat_Nombre"));
                categoria.setDescripcion(rs.getString("Cat_Descripcion"));
                categoria.setImagen(rs.getString("Cat_Imagen"));
                lista.add(categoria);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Ocurri\u00f3 un error en el m\u00e9todo listarCategorias: {0}", e);
        } finally {
            conexion.disconnect(cnn);
        }
        logger.info("*** fin listarCategorias ***");
        return lista;
    }
}
