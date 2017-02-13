
public class LineaCompra {
	private int cod_linea; 
	private int cantidad;
	private float coste;
	private String fecha_envio;
	private int cod_producto;
	private int cod_compra;
	public LineaCompra() {
	}
	
	public LineaCompra(int cod_linea, int cantidad, float coste, String fecha_envio, int cod_producto,
			int cod_compra) {
		super();
		this.cod_linea = cod_linea;
		this.cantidad = cantidad;
		this.coste = coste;
		this.fecha_envio = fecha_envio;
		this.cod_producto = cod_producto;
		this.cod_compra = cod_compra;
	}

	public int getCod_linea() {
		return cod_linea;
	}

	public void setCod_linea(int cod_linea) {
		this.cod_linea = cod_linea;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getCoste() {
		return coste;
	}

	public void setCoste(float coste) {
		this.coste = coste;
	}

	public String getFecha_envio() {
		return fecha_envio;
	}

	public void setFecha_envio(String fecha_envio) {
		this.fecha_envio = fecha_envio;
	}

	public int getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(int cod_producto) {
		this.cod_producto = cod_producto;
	}

	public int getCod_compra() {
		return cod_compra;
	}

	public void setCod_compra(int cod_compra) {
		this.cod_compra = cod_compra;
	}
	
	
	
}