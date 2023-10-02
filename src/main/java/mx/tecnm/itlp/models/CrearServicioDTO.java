package mx.tecnm.itlp.models;

public class CrearServicioDTO {
	int IdUsuario;
	int IdUAsignado;
	int IdCliente;
	int Factura; 
	int HojaServicio; 
	String Descripcion; 
	int HojaRemision; 
	int EmpresaPoliza; 
	String TituloServicio;
	
	public int getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}
	public int getIdUAsignado() {
		return IdUAsignado;
	}
	public void setIdUAsignado(int idUAsignado) {
		IdUAsignado = idUAsignado;
	}
	public int getIdCliente() {
		return IdCliente;
	}
	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}
	public int getFactura() {
		return Factura;
	}
	public void setFactura(int factura) {
		Factura = factura;
	}
	public int getHojaServicio() {
		return HojaServicio;
	}
	public void setHojaServicio(int hojaServicio) {
		HojaServicio = hojaServicio;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public int getHojaRemision() {
		return HojaRemision;
	}
	public void setHojaRemision(int hojaRemision) {
		HojaRemision = hojaRemision;
	}
	public int getEmpresaPoliza() {
		return EmpresaPoliza;
	}
	public void setEmpresaPoliza(int empresaPoliza) {
		EmpresaPoliza = empresaPoliza;
	}
	public String getTituloServicio() {
		return TituloServicio;
	}
	public void setTituloServicio(String tituloServicio) {
		TituloServicio = tituloServicio;
	}
	
}
