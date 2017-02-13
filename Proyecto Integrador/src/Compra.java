
public class Compra {
	private int cod_compra;
	private int cod_transporte;
	private float coste;
	private String tipo;
	private String fecha;
	public Compra() {
		super();
	}
	public Compra(int cod_compra, int cod_transporte, float coste, String tipo, String fecha) {
		super();
		this.cod_compra = cod_compra;
		this.cod_transporte = cod_transporte;
		this.coste = coste;
		this.tipo = tipo;
		this.fecha = fecha;
	}
	public int getCod_compra() {
		return cod_compra;
	}
	public void setCod_compra(int cod_compra) {
		this.cod_compra = cod_compra;
	}
	public int getCod_transporte() {
		return cod_transporte;
	}
	public void setCod_transporte(int cod_transporte) {
		this.cod_transporte = cod_transporte;
	}
	public float getCoste() {
		return coste;
	}
	public void setCoste(float coste) {
		this.coste = coste;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
