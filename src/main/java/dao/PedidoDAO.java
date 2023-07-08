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
import modelo.Pedido;

/**
 *
 * @author Usuario
 */
public class PedidoDAO {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private ConexionBD conexion = new ConexionBD();

    public String registrarPedido(Pedido p) {
        int estadoRegistro = 0;
        String nroPedido = "";
        Connection cnn = conexion.connect();
        try {
            nroPedido = generarCodigo();
            ps = cnn.prepareStatement("insert into pedido (Ped_Numero, "
                    + "Ped_Estado, "
                    + "Ped_FechaPedido, "
                    + "Ped_Tipo, "
                    + "Mes_Id, "
                    + "Cli_Id) "
                    + "values (?,"
                    + "'EN COCINA',"
                    + "NOW(),"
                    + "'CONSUMO EN RESTAURANT',"
                    + "1,?);");

            ps.setString(1, nroPedido);
            ps.setInt(2, p.getCliId());

            estadoRegistro = ps.executeUpdate();
            if (estadoRegistro > 0) {
                return nroPedido;
            }
            ps.close();
        } catch (SQLException e) {
            System.err.println("Ocurrió un error en el método registrarCliente: " + e);
        } finally {
            conexion.disconnect(cnn);
        }

        return nroPedido;
    }

    private String generarCodigo() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(900) + 100;
        String codigo = "P" + numeroAleatorio;
        return codigo;
    }
}
