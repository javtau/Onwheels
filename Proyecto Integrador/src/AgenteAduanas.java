
public class AgenteAduanas {
	private int cod_agente;
	private String nombre;
	private String apellidos;
	private String sede;
	private String dni;
	private String datosbancarios;
	public AgenteAduanas() {
		super();
	}
	public AgenteAduanas(int cod_agente, String nombre, String apellidos, String sede, String dni,
			String datosbancarios) {
		super();
		this.cod_agente = cod_agente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sede = sede;
		this.dni = dni;
		this.datosbancarios = datosbancarios;
	}
	public int getCod_agente() {
		return cod_agente;
	}
	public void setCod_agente(int cod_agente) {
		this.cod_agente = cod_agente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDatosbancarios() {
		return datosbancarios;
	}
	public void setDatosbancarios(String datosbancarios) {
		this.datosbancarios = datosbancarios;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
