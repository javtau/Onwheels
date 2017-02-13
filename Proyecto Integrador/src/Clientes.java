
public class Clientes {
	private int cod_cliente;
	private String ubicacion;
	private String correo;
	private String datos_bancarios;
	private String nombre;
	private String apellidos;
	private int telefono;
	private String dni;
	public int getCod_cliente() {
		return cod_cliente;
	}
	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDatos_bancarios() {
		return datos_bancarios;
	}
	public void setDatos_bancarios(String datos_bancarios) {
		this.datos_bancarios = datos_bancarios;
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
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Clientes(int cod_cliente, String ubicacion, String correo, String datos_bancarios, String nombre,
			String apellidos, int telefono, String dni) {
		super();
		this.cod_cliente = cod_cliente;
		this.ubicacion = ubicacion;
		this.correo = correo;
		this.datos_bancarios = datos_bancarios;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.dni = dni;
	}

	public Clientes() {
		super();
	}

}
