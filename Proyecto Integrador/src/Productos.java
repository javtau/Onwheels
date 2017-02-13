
public class Productos {
	private int cod_producto;
	private float precio;
	private String descripcion;
	private String tipo;
	public Productos() {
		super();
	}
	public Productos(int cod_producto, float precio, String descripcion, String tipo) {
		super();
		this.cod_producto = cod_producto;
		this.precio = precio;
		this.descripcion = descripcion;
		this.tipo = tipo;
	}
	public int getCod_producto() {
		return cod_producto;
	}
	public void setCod_producto(int cod_producto) {
		this.cod_producto = cod_producto;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	
	
	
	
	
	

}
