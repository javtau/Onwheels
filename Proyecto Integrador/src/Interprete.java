public class Interprete {
	private int cod_interprete;
	private String dni;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String direccion;
	public Interprete() {
		super();
	}
	public Interprete(int cod_interprete, String dni, String nombre,
			String apellidos, String telefono, String direccion) {
		super();
		this.cod_interprete = cod_interprete;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	public int getCod_interprete() {
		return cod_interprete;
	}
	public void setCod_interprete(int cod_interprete) {
		this.cod_interprete = cod_interprete;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}