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
import modelo.Producto;

/**
 *
 * @author Usuario
 */
public class ProductoDAO {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private ConexionBD conexion = new ConexionBD();

    public List<Producto> listarProductos(String nombre) {
        List<Producto> lista = new ArrayList<>();
        Connection cnn = conexion.connect();
        try {
            ps = cnn.prepareStatement("select * from producto where Pro_Nombre like ?;");
            ps.setString(1, "%" + nombre + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("Pro_Id"));
                producto.setNombre(rs.getString("Pro_Nombre"));
                producto.setCantidadPorUnidad(Integer.parseInt(rs.getString("Pro_CantidadPorUnidad")));
                producto.setPrecioUnitario(Double.parseDouble(rs.getString("Pro_PrecioUnitario")));
                producto.setUnidadMedida(rs.getString("Pro_UnidadMedida"));
                producto.setStock(Integer.parseInt(rs.getString("Pro_Stock")));
                producto.setEstado(rs.getString("Pro_Estado"));
                producto.setFechaRegistro(rs.getDate("Pro_FechaRegistro"));
                producto.setCategoriaId(Integer.parseInt(rs.getString("Cat_Id")));
                lista.add(producto);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.err.println("Ocurrió un error en el método listarProductos " + e);
        } finally {
            conexion.disconnect(cnn);
        }
        return lista;
    }

    public Producto obtenerProducto(int id) {
        Producto producto = new Producto();
        Connection cnn = conexion.connect();
        try {
            ps = cnn.prepareStatement("select * from producto where Pro_Id = ?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto.setId(rs.getInt("Pro_Id"));
                producto.setNombre(rs.getString("Pro_Nombre"));
                producto.setCantidadPorUnidad(Integer.parseInt(rs.getString("Pro_CantidadPorUnidad")));
                producto.setPrecioUnitario(Double.parseDouble(rs.getString("Pro_PrecioUnitario")));
                producto.setUnidadMedida(rs.getString("Pro_UnidadMedida"));
                producto.setStock(Integer.parseInt(rs.getString("Pro_Stock")));
                producto.setEstado(rs.getString("Pro_Estado"));
                producto.setFechaRegistro(rs.getDate("Pro_FechaRegistro"));
                producto.setFechaActualizacion(rs.getDate("Pro_FechaActualizacion"));
                producto.setCategoriaId(Integer.parseInt(rs.getString("Cat_Id")));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.err.println("Ocurrió un error en el método obtenerProducto " + e);
        } finally {
            conexion.disconnect(cnn);
        }
        return producto;
    }

    public int registrarProducto(Producto p) {
        int estadoRegistro = 0;
        Connection cnn = conexion.connect();
        try {
            ps = cnn.prepareStatement("insert into producto (Pro_Nombre, Pro_CantidadPorUnidad, "
                    + "Pro_PrecioUnitario, Pro_UnidadMedida, Pro_Stock, Pro_Estado, "
                    + "Pro_FechaRegistro, Pro_FechaActualizacion, Cat_Id) "
                    + "values (?,?,?,?,?,?,now(),now(),?)");

            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getCantidadPorUnidad());
            ps.setDouble(3, p.getPrecioUnitario());
            ps.setString(4, p.getUnidadMedida());
            ps.setInt(5, p.getStock());
            ps.setString(6, p.getEstado());
            ps.setInt(7, p.getCategoriaId());

            estadoRegistro = ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            System.err.println("Ocurrió un error en el método registrarProducto: " + e);
        } finally {
            conexion.disconnect(cnn);
        }

        return estadoRegistro;
    }

    public int editarProducto(Producto p) {
        int estadoEditar = 0;
        Connection cnn = conexion.connect();
        try {
            ps = cnn.prepareStatement("update producto set Pro_Nombre=?, Pro_CantidadPorUnidad=?, "
                    + "Pro_PrecioUnitario=?, Pro_UnidadMedida=?, Pro_Stock=?, Pro_Estado=?, "
                    + "Pro_FechaActualizacion=now(), Cat_Id=? "
                    + "where Pro_Id=?");

            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getCantidadPorUnidad());
            ps.setDouble(3, p.getPrecioUnitario());
            ps.setString(4, p.getUnidadMedida());
            ps.setInt(5, p.getStock());
            ps.setString(6, p.getEstado());
            ps.setInt(7, p.getCategoriaId());
            ps.setInt(8, p.getId());

            estadoEditar = ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            System.err.println("Ocurrió un error en el método editarProducto " + e);
        } finally {
            conexion.disconnect(cnn);
        }

        return estadoEditar;
    }

}
