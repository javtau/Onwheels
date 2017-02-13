
public class TransporteInternacional {
	private int cod_transporte;
	private String nombre;
	private String direccion;
	private String datos_bancarios;
	private int interprete;
	public TransporteInternacional() {
		super();
	}
	public TransporteInternacional(int cod_transporte, String nombre, String direccion, String datos_bancarios,
			int interprete) {
		super();
		this.cod_transporte = cod_transporte;
		this.nombre = nombre;
		this.direccion = direccion;
		this.datos_bancarios = datos_bancarios;
		this.interprete = interprete;
	}
	public int getCod_transporte() {
		return cod_transporte;
	}
	public void setCod_transporte(int cod_transporte) {
		this.cod_transporte = cod_transporte;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDatos_bancarios() {
		return datos_bancarios;
	}
	public void setDatos_bancarios(String datos_bancarios) {
		this.datos_bancarios = datos_bancarios;
	}
	public int getInterprete() {
		return interprete;
	}
	public void setInterprete(int interprete) {
		this.interprete = interprete;
	}

	
	
	
	
	
	
	
	
	
}
