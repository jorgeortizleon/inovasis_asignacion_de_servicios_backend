package mx.tecnm.itlp.util.reportes;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import mx.tecnm.itlp.models.Cliente;

public class ClienteExporterPDF {
	
	private List<Cliente> listaEmpleados;

	public ClienteExporterPDF(List<Cliente> listaEmpleados) {
		super();
		this.listaEmpleados = listaEmpleados;
	}
	
	public void escribirCabeceraDeLaTabla(PdfPTable tabla){
		PdfPCell celda = new PdfPCell();
		celda.setBackgroundColor(Color.BLUE);
		celda.setPadding(5);

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
		fuente.setColor(Color.WHITE);

		celda.setPhrase(new Phrase("Id", fuente));
		tabla.addCell(celda);
		
		celda.setPhrase(new Phrase("Razon Social", fuente));
		tabla.addCell(celda);
		
		celda.setPhrase(new Phrase("Codigo", fuente));
		tabla.addCell(celda);
		
		celda.setPhrase(new Phrase("Correo", fuente));
		tabla.addCell(celda);
		
		celda.setPhrase(new Phrase("Telefono", fuente));
		tabla.addCell(celda);
		
		celda.setPhrase(new Phrase("Estado", fuente));
		tabla.addCell(celda);
		
		celda.setPhrase(new Phrase("Fecha Registro", fuente));
		tabla.addCell(celda);
		
		celda.setPhrase(new Phrase("Activo", fuente));
		tabla.addCell(celda);
	}
	
	public void escribirDatosDeLaTabla(PdfPTable tabla) {
		for(Cliente cliente : listaEmpleados) {
			tabla.addCell(String.valueOf(cliente.getIdCliente()));
			tabla.addCell(cliente.getRazonSocial());
			tabla.addCell(cliente.getCodigo());
			tabla.addCell(cliente.getCorreo());
			tabla.addCell(cliente.getTelefono());
			String estado = cliente.getEstado() == 1 ? "Activo" : "No Activo";
		    tabla.addCell(estado);
			tabla.addCell(cliente.getFechaRegistro());
			String actividad = cliente.getActivo() == 1 ? "No Eliminado" : "Eliminado";
	        tabla.addCell(actividad);
		}
	}
	
	public void exportar(HttpServletResponse response) throws DocumentException, IOException {
		Document documento = new Document(PageSize.A4);
		PdfWriter.getInstance(documento, response.getOutputStream());

		documento.open();

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fuente.setColor(Color.BLUE);
		fuente.setSize(18);

		Paragraph titulo = new Paragraph("Lista de clientes", fuente);
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		documento.add(titulo);

		PdfPTable tabla = new PdfPTable(8);
		tabla.setWidthPercentage(100);
		tabla.setSpacingBefore(15);
		tabla.setWidths(new float[] { 1f, 4f, 2.3f, 4f, 2.9f, 2.2f, 2.9f, 2.2f });
		tabla.setWidthPercentage(110);

		escribirCabeceraDeLaTabla(tabla);
		escribirDatosDeLaTabla(tabla);

		documento.add(tabla);
		documento.close();
	}

}
