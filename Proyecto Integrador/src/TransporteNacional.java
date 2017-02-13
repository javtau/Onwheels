
public class TransporteNacional {
	private int cod_trasporte;
	private String datosbancarios;
	private String direccion;
	private String nombre;
	
	public TransporteNacional() {
		super();
	}

	public TransporteNacional(int cod_trasporte, String datosbancarios,
			String direccion, String nombre) {
		super();
		this.cod_trasporte = cod_trasporte;
		this.datosbancarios = datosbancarios;
		this.direccion = direccion;
		this.nombre = nombre;
	}

	public int getCod_trasporte() {
		return cod_trasporte;
	}

	public void setCod_trasporte(int cod_trasporte) {
		this.cod_trasporte = cod_trasporte;
	}

	public String getDatosbancarios() {
		return datosbancarios;
	}

	public void setDatosbancarios(String datosbancarios) {
		this.datosbancarios = datosbancarios;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
