package mx.tecnm.itlp.util.reportes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import mx.tecnm.itlp.models.Cliente;

public class ClienteExporterExcel {

	private XSSFWorkbook libro;
	private XSSFSheet hoja;

	private List<Cliente> listaClientes;

	public ClienteExporterExcel(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
		libro = new XSSFWorkbook();
		hoja = libro.createSheet("Clientes");
	}

	private void escribirCabeceraDeTabla() {
		Row fila = hoja.createRow(0);

		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setBold(true);
		fuente.setFontHeight(16);
		estilo.setFont(fuente);

		Cell celda = fila.createCell(0);
		celda.setCellValue("ID");
		celda.setCellStyle(estilo);

		celda = fila.createCell(1);
		celda.setCellValue("Razon Social");
		celda.setCellStyle(estilo);

		celda = fila.createCell(2);
		celda.setCellValue("Codigo");
		celda.setCellStyle(estilo);

		celda = fila.createCell(3);
		celda.setCellValue("Correo");
		celda.setCellStyle(estilo);

		celda = fila.createCell(4);
		celda.setCellValue("Telefono");
		celda.setCellStyle(estilo);

		celda = fila.createCell(5);
		celda.setCellValue("Estado");
		celda.setCellStyle(estilo);

		celda = fila.createCell(6);
		celda.setCellValue("Fecha Registro");
		celda.setCellStyle(estilo);

		celda = fila.createCell(7);
		celda.setCellValue("Activo");
		celda.setCellStyle(estilo);
	}

	private void escribirDatosDeLaTabla() {
		int nueroFilas = 1;

		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setFontHeight(14);
		estilo.setFont(fuente);

		for (Cliente cliente : listaClientes) {
			Row fila = hoja.createRow(nueroFilas++);

			Cell celda = fila.createCell(0);
			celda.setCellValue(cliente.getIdCliente());
			hoja.autoSizeColumn(0);
			celda.setCellStyle(estilo);

			celda = fila.createCell(1);
			celda.setCellValue(cliente.getRazonSocial());
			hoja.autoSizeColumn(1);
			celda.setCellStyle(estilo);

			celda = fila.createCell(2);
			celda.setCellValue(cliente.getCodigo());
			hoja.autoSizeColumn(2);
			celda.setCellStyle(estilo);

			celda = fila.createCell(3);
			celda.setCellValue(cliente.getCorreo());
			hoja.autoSizeColumn(3);
			celda.setCellStyle(estilo);

			celda = fila.createCell(4);
			celda.setCellValue(cliente.getTelefono());
			hoja.autoSizeColumn(4);
			celda.setCellStyle(estilo);

			String estado = cliente.getEstado() == 1 ? "Activo" : "No Activo";
			celda = fila.createCell(5);
			celda.setCellValue(estado);
			hoja.autoSizeColumn(5);
			celda.setCellStyle(estilo);

			celda = fila.createCell(6);
			celda.setCellValue(cliente.getFechaRegistro());
			hoja.autoSizeColumn(6);
			celda.setCellStyle(estilo);

			String actividad = cliente.getActivo() == 1 ? "No Eliminado" : "Eliminado";
			celda = fila.createCell(7);
			celda.setCellValue(actividad);
			hoja.autoSizeColumn(7);
			celda.setCellStyle(estilo);
		}
	}

	public void exportar(HttpServletResponse response) throws IOException {
		escribirCabeceraDeTabla();
		escribirDatosDeLaTabla();

		ServletOutputStream outPutStream = response.getOutputStream();
		libro.write(outPutStream);

		libro.close();
		outPutStream.close();
	}

}
