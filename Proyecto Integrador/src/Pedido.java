
public class Pedido {
	private int cod_pedido;
	private int cod_transporte;
	private int cod_agente;
	private float coste;
	private String fecha;
	
	public Pedido() {
		super();
	}

	public Pedido(int cod_pedido, int cod_transporte, int cod_agente,float coste,
			String fecha) {
		super();
		this.cod_pedido = cod_pedido;
		this.cod_transporte = cod_transporte;
		this.cod_agente = cod_agente;
		this.coste=coste;
		this.fecha = fecha;
	}

	public int getCod_pedido() {
		return cod_pedido;
	}

	public void setCod_pedido(int cod_pedido) {
		this.cod_pedido = cod_pedido;
	}

	public int getCod_transporte() {
		return cod_transporte;
	}

	public void setCod_transporte(int cod_transporte) {
		this.cod_transporte = cod_transporte;
	}

	public int getCod_agente() {
		return cod_agente;
	}

	public void setCod_agente(int cod_agente) {
		this.cod_agente = cod_agente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public float getCoste() {
		return coste;
	}

	public void setCoste(float coste) {
		this.coste = coste;
	}
	
}
