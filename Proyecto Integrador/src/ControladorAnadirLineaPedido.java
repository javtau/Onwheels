
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class ControladorAnadirLineaPedido implements ActionListener, WindowListener,ChangeListener {
	VistaLineaPedido  vlp = null;
	VistaAnadirLineaPedido valp = null;
	OracleAcces bdd = null;
	ArrayList<LineaPedido> lc= new ArrayList<LineaPedido>();
	int cod_pedido;
	int cod_linea;
	ArrayList<String> productos = new ArrayList<String>();
	ArrayList<Integer> cproducto = new ArrayList<Integer>();
	ArrayList<Float> costeproducto = new ArrayList<Float>();
	ArrayList<String> proveedor = new ArrayList<String>();
	ArrayList<Integer> cproveedor= new ArrayList<Integer>();

	public ControladorAnadirLineaPedido(VistaLineaPedido vlp, VistaAnadirLineaPedido valp, OracleAcces bdd, 
			ArrayList<LineaPedido> lc, int cod_pedido, int cod_linea) {
		super();
		this.vlp = vlp;
		this.valp = valp;
		this.bdd = bdd;
		this.lc = lc;
		this.cod_pedido = cod_pedido;
		this.cod_linea = cod_linea;
		
	}

	public void inicializar(){
		valp.textCod.setText(""+cod_linea);
		bdd.rellenarArray3(productos,cproducto,costeproducto,"DESCRIPCION","COD_PRODUCTO","PRECIO","PRODUCTOS");
		bdd.rellenarArray(proveedor,cproveedor,"NOMBRE","COD_PROVEEDOR","PROVEEDORES");
		valp.textCoste.setText(""+costeproducto.get(0));
		valp.spProd.setModel(new SpinnerListModel(productos));
		valp.spProve.setModel(new SpinnerListModel(proveedor));
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == valp.btnAnadir) {
			String fecha =""+valp.dcFecha.getCalendar().get(Calendar.DAY_OF_MONTH)+"/"+valp.dcFecha.getCalendar().get(Calendar.MONTH)+"/"+valp.dcFecha.getCalendar().get(Calendar.YEAR);
			int cp = cproducto.get(productos.indexOf((String) valp.spProd.getValue()));
			int cprov = cproveedor.get(proveedor.indexOf((String) valp.spProve.getValue()));
			float precio = Float.parseFloat(valp.textCoste.getText());
			int cant =  (Integer) valp.spCant.getValue();
			String lpedido=(cod_linea+", "+cant+","+precio+","+cprov+",'"+fecha+"',"+cod_pedido+","+cp);
			bdd.introducirFila(lpedido,"LINEAPEDIDO");
			DefaultTableModel tablamodelo= (DefaultTableModel) vlp.table.getModel();
			tablamodelo.addRow(new Object []{cod_linea,(String) valp.spProd.getValue(), (String) valp.spProve.getValue(),cant,precio,fecha});
			LineaPedido nlc = new LineaPedido(cod_linea,cant,precio,cprov, fecha,cod_pedido,cp);
			lc.add(nlc);
			ControladorLineaPedido.incrementarCodlinea();
			vlp.setEnabled(true);
			valp.dispose();
		} else if (obj == valp.btnCancelar) {
			vlp.setEnabled(true);
			valp.dispose();
			}

	}

	
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		vlp.setEnabled(true);
	}

	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == valp.spProd) {
			float p = costeproducto.get(productos.indexOf(valp.spProd.getValue()));
			int c=(Integer) valp.spCant.getValue();
			valp.textCoste.setText(""+p*c);
		} else if (obj == valp.spCant) {
			float p = costeproducto.get(productos.indexOf(valp.spProd.getValue()));
			int c=(Integer) valp.spCant.getValue();
			valp.textCoste.setText(""+p*c);
		}
	}

}
