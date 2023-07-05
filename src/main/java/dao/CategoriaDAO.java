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
import modelo.Categoria;

/**
 *
 * @author Usuario
 */
public class CategoriaDAO {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private ConexionBD conexion = new ConexionBD();

    public List<Categoria> listarCategorias() {
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
            System.err.println("Ocurrió un error en el método listarCategorias");
        } finally {
            conexion.disconnect(cnn);
        }
        return lista;
    }
}
