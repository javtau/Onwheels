
public class Proveedores {
	private int cod_proveedor;
	private String nombre;
	private int telefono;
	private String ubicacion;
	private String nif;
	private String cod_cuenta;
	private String perscontacto;
	public Proveedores() {
		super();
	}
	public Proveedores(int cod_proveedor, String nombre, int telefono, String ubicacion, String nif, String cod_cuenta,
			String perscontacto) {
		super();
		this.cod_proveedor = cod_proveedor;
		this.nombre = nombre;
		this.telefono = telefono;
		this.ubicacion = ubicacion;
		this.nif = nif;
		this.cod_cuenta = cod_cuenta;
		this.perscontacto = perscontacto;
	}
	public int getCod_proveedor() {
		return cod_proveedor;
	}
	public void setCod_proveedor(int cod_proveedor) {
		this.cod_proveedor = cod_proveedor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getCod_cuenta() {
		return cod_cuenta;
	}
	public void setCod_cuenta(String cod_cuenta) {
		this.cod_cuenta = cod_cuenta;
	}
	public String getPerscontacto() {
		return perscontacto;
	}
	public void setPerscontacto(String perscontacto) {
		this.perscontacto = perscontacto;
	}
	
	
	
	
	
	
	
	
	
	
	

}
