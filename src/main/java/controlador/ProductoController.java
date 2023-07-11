/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import com.google.gson.Gson;
import dao.ProductoDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import modelo.Producto;

/**
 *
 * @author Usuario
 */
@MultipartConfig
public class ProductoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        if (accion.equals("listar")) {
            String nombre = request.getParameter("nombre");

            ProductoDAO productoDAO = new ProductoDAO();
            List<Producto> lista = productoDAO.listarProductos(nombre);

            String jsonListaProductos = new Gson().toJson(lista);
            response.getWriter().write(jsonListaProductos);

        } else if (accion.equals("obtener")) {
            int productoId = Integer.parseInt(request.getParameter("productoId"));

            ProductoDAO productoDAO = new ProductoDAO();
            Producto producto = productoDAO.obtenerProducto(productoId);

            String jsonListaProductos = new Gson().toJson(producto);
            response.getWriter().write(jsonListaProductos);
        } else if (accion.equals("listarPorCategoria")) {
            int categoriaId = Integer.parseInt(request.getParameter("categoriaId"));

            ProductoDAO productoDAO = new ProductoDAO();
            List<Producto> lista = productoDAO.listarProductosPorCategoria(categoriaId);

            String jsonListaProductos = new Gson().toJson(lista);
            response.getWriter().write(jsonListaProductos);
        } else {
            response.getWriter().write("acción desconocida");
        }

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        if (accion.equals("registrar")) {
            Producto p = new Producto();
            p.setNombre(request.getParameter("nombre"));
            p.setCantidadPorUnidad(1);
            p.setPrecioUnitario(Double.parseDouble(request.getParameter("precioUnitario")));
            p.setUnidadMedida(request.getParameter("unidadMedida"));
            p.setStock(Integer.parseInt(request.getParameter("stock")));
            p.setEstado(request.getParameter("estado"));
            p.setImagen(guardarFoto(request));
            p.setCategoriaId(Integer.parseInt(request.getParameter("categoriaId")));

            ProductoDAO productoDAO = new ProductoDAO();
            int estadoRegistro = productoDAO.registrarProducto(p);

            response.getWriter().write(String.valueOf(estadoRegistro));
        } else if (accion.equals("editar")) {
            Producto p = new Producto();
            p.setId(Integer.parseInt(request.getParameter("id")));
            p.setNombre(request.getParameter("nombre"));
            p.setCantidadPorUnidad(Integer.parseInt(request.getParameter("cantidadPorUnidad")));
            p.setPrecioUnitario(Double.parseDouble(request.getParameter("precioUnitario")));
            p.setUnidadMedida(request.getParameter("unidadMedida"));
            p.setStock(Integer.parseInt(request.getParameter("stock")));
            p.setEstado(request.getParameter("estado"));
            p.setCategoriaId(Integer.parseInt(request.getParameter("categoriaId")));

            ProductoDAO productoDAO = new ProductoDAO();
            int estadoEditar = productoDAO.editarProducto(p);

            response.getWriter().write(String.valueOf(estadoEditar));
        } else if (accion.equals("eliminar")) {

        } else {
            response.getWriter().write("acción desconocida");
        }

        processRequest(request, response);
    }

    private String obtenerRuta() {
        String nombreProyecto = "norkys-app";
        String rutaCompleta = getServletContext().getRealPath("");
        int idx = rutaCompleta.indexOf(nombreProyecto);
        String carpetaImagenes = "\\src\\main\\webapp\\img-productos";
        return rutaCompleta.substring(0, idx + nombreProyecto.length()) + carpetaImagenes;
    }

    private String guardarFoto(HttpServletRequest request) throws IOException, ServletException {
        Part img = request.getPart("img");
        String fileName = img.getSubmittedFileName();

        String[] fileNameArray = fileName.split("\\.(?=[^\\.]+$)");
        String name = fileNameArray[0];
        String extension = fileNameArray[1];
        String newFileName = name.concat(generarCodigo()).concat(".").concat(extension);
        String savePath = obtenerRuta();

        BufferedImage resizedImage = resizeImage(img.getInputStream(), 210, 200);

        File directory = new File(savePath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filePath = savePath + File.separator + newFileName;
        File output = new File(filePath);

        ImageIO.write(resizedImage, extension, output);
        return newFileName;
    }

    private String generarCodigo() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(9000) + 100;
        return String.valueOf(numeroAleatorio);
    }

    private BufferedImage resizeImage(InputStream inputStream, int newWidth, int newHeight) throws IOException {
        // Leer la imagen original
        BufferedImage originalImage = ImageIO.read(inputStream);

        // Crear una nueva imagen con las dimensiones deseadas
        Image newImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

        // Copiar la imagen redimensionada en la nueva imagen
        Graphics2D graphics = resizedImage.createGraphics();
        graphics.drawImage(newImage, 0, 0, null);
        graphics.dispose();

        return resizedImage;
    }

}
