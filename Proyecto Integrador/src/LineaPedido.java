
public class LineaPedido {
	private int cod_lineapedido;
	private int cantidad;
	private float coste;
	private int cod_proveedor;
	private String fecha_envio;
	private int cod_pedido;
	private int cod_producto;

	public LineaPedido() {
		super();
	}

	public LineaPedido(int cod_lineapedido, int cantidad, float coste, int cod_proveedor, String fecha_envio,
			int cod_pedido, int cod_producto) {
		super();
		this.cod_lineapedido = cod_lineapedido;
		this.cantidad = cantidad;
		this.coste = coste;
		this.cod_proveedor = cod_proveedor;
		this.fecha_envio = fecha_envio;
		this.cod_pedido = cod_pedido;
		this.cod_producto = cod_producto;
	}

	public int getCod_lineapedido() {
		return cod_lineapedido;
	}

	public void setCod_lineapedido(int cod_lineapedido) {
		this.cod_lineapedido = cod_lineapedido;
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

	public int getCod_proveedor() {
		return cod_proveedor;
	}

	public void setCod_proveedor(int cod_proveedor) {
		this.cod_proveedor = cod_proveedor;
	}

	public String getFecha_envio() {
		return fecha_envio;
	}

	public void setFecha_envio(String fecha_envio) {
		this.fecha_envio = fecha_envio;
	}

	public int getCod_pedido() {
		return cod_pedido;
	}

	public void setCod_pedido(int cod_pedido) {
		this.cod_pedido = cod_pedido;
	}

	public int getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(int cod_producto) {
		this.cod_producto = cod_producto;
	}

	

}