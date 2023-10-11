package mx.tecnm.itlp.models;

public class ServicioDTO {
	int IdServicio;
	String CodigoServicio;
	String RazonSocial;
	String UsuarioCreado;
	String UsuarioAsignado;
	String Fecha;
	String tituloservicio;
	String Estado;
	String Descripcion;
	String Observaciones;
	int Factura;
	int HojaServicio;
	int HojaRemision;
	public String getObservaciones() {
		return Observaciones;
	}
	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}
	int EmpresaPoliza;
	
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
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public int getIdServicio() {
		return IdServicio;
	}
	public void setIdServicio(int idServicio) {
		IdServicio = idServicio;
	}
	public String getCodigoServicio() {
		return CodigoServicio;
	}
	public void setCodigoServicio(String codigoServicio) {
		CodigoServicio = codigoServicio;
	}
	public String getRazonSocial() {
		return RazonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		RazonSocial = razonSocial;
	}
	public String getUsuarioCreado() {
		return UsuarioCreado;
	}
	public void setUsuarioCreado(String usuarioCreado) {
		UsuarioCreado = usuarioCreado;
	}
	public String getUsuarioAsignado() {
		return UsuarioAsignado;
	}
	public void setUsuarioAsignado(String usuarioAsignado) {
		UsuarioAsignado = usuarioAsignado;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public String getTituloservicio() {
		return tituloservicio;
	}
	public void setTituloservicio(String tituloservicio) {
		this.tituloservicio = tituloservicio;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	
	
	
	
	
}
