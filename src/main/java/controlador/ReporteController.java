/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import com.google.gson.Gson;
import dao.ReporteDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import response.VistaReporte;

/**
 *
 * @author Usuario
 */
public class ReporteController extends HttpServlet {

    Logger logger = Logger.getLogger(this.getClass().getName());

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion.equals("listar")) {
            String fechaInicio = request.getParameter("fechaInicio");
            String fechaFin = request.getParameter("fechaFin");

            ReporteDAO reporteDAO = new ReporteDAO();
            List<VistaReporte> lista = reporteDAO.listarReporte(fechaInicio, fechaFin);
            String json = new Gson().toJson(lista);
            logger.log(Level.INFO, "json lista reporte {0}", json);

            response.getWriter().write(json);
        } else if (accion.equals("generarExcel")) {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH:mm:ss");
            String fechaActual = format.format(new Date());
            String filename = "ReporteVentas_" + fechaActual + ".xlsx";

            Workbook workbook = new XSSFWorkbook();

            Sheet sheet = workbook.createSheet("Ventas");

            String fechaInicio = request.getParameter("fechaInicio");
            String fechaFin = request.getParameter("fechaFin");

            ReporteDAO reporteDAO = new ReporteDAO();
            List<VistaReporte> lista = reporteDAO.listarReporte(fechaInicio, fechaFin);

            // Crear encabezados de columna
            Row headerRow = sheet.createRow(0);

            Cell headerCell1 = headerRow.createCell(0);
            headerCell1.setCellValue("Nro Venta");

            Cell headerCell2 = headerRow.createCell(1);
            headerCell2.setCellValue("Fecha Venta");

            Cell headerCell3 = headerRow.createCell(2);
            headerCell3.setCellValue("Subtotal");

            Cell headerCell4 = headerRow.createCell(3);
            headerCell4.setCellValue("IGV");

            Cell headerCell5 = headerRow.createCell(4);
            headerCell5.setCellValue("Total");

            Cell headerCell6 = headerRow.createCell(5);
            headerCell6.setCellValue("Cliente");

            Cell headerCell7 = headerRow.createCell(6);
            headerCell7.setCellValue("Usuario");

            int rowNum = 1;
            for (VistaReporte v : lista) {
                Row row = sheet.createRow(rowNum++);

                Cell cell1 = row.createCell(0);
                cell1.setCellValue(v.getNroVenta());

                Cell cell2 = row.createCell(1);
                cell2.setCellValue(v.getFechaVenta());

                Cell cell3 = row.createCell(2);
                cell3.setCellValue(v.getSubtotal());

                Cell cell4 = row.createCell(3);
                cell4.setCellValue(v.getIgv());

                Cell cell5 = row.createCell(4);
                cell5.setCellValue(v.getTotal());

                Cell cell6 = row.createCell(5);
                cell6.setCellValue(v.getCliente());

                Cell cell7 = row.createCell(6);
                cell7.setCellValue(v.getUsuario());
            }

            // Configurar la respuesta HTTP para descargar el archivo
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=" + filename);

            // Escribir el libro de Excel en el flujo de salida de la respuesta
            workbook.write(response.getOutputStream());

        }

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
