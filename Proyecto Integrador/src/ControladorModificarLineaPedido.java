
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class ControladorModificarLineaPedido implements ActionListener, WindowListener, ChangeListener {
	VistaLineaPedido vlp = null;
	VistaModificarLineaPedido vmlp = null;
	OracleAcces bdd = null;
	ArrayList<LineaPedido> lineasPedido = null;
	String np = null;
	int cant = 0;
	int cod_pedido;
	int cod_linea;
	ArrayList<String> productos = new ArrayList<String>();
	ArrayList<Integer> codProducto = new ArrayList<Integer>();
	ArrayList<Float> costeProducto = new ArrayList<Float>();
	int fila;
	ArrayList<String> proveedor = new ArrayList<String>();
	ArrayList<Integer> cproveedor = new ArrayList<Integer>();
	String nomprov;
	

	public ControladorModificarLineaPedido(VistaLineaPedido vlp, VistaModificarLineaPedido vmlc, OracleAcces bdd,
			ArrayList<LineaPedido> lineasPedido, int cod_pedido, int cod_linea, String np, int cant, int fila, String nomprov) {
		super();
		this.vlp = vlp;
		this.vmlp = vmlp;
		this.bdd = bdd;
		this.lineasPedido = lineasPedido;
		this.cod_pedido = cod_pedido;
		this.cod_linea = cod_linea;
		this.np = np;
		this.cant = cant;
		this.fila = fila;
		this.nomprov = nomprov;
	}

	public void inicializar() {
		bdd.rellenarArray3(productos, codProducto, costeProducto, "DESCRIPCION", "COD_PRODUCTO", "PRECIO", "PRODUCTOS");
		bdd.rellenarArray(proveedor, cproveedor,"NOMBRE","COD_PROVEEDOR","PROVEEDORES");
		System.out.println(cod_linea+" "+cant+" "+nomprov);

		
		
		vmlp.spProve.setModel(new SpinnerListModel(proveedor));
		vmlp.spProve.setValue(nomprov);
		float p = costeProducto.get(productos.indexOf(np)) * cant;
		vmlp.textCoste.setText("" + p);
		vmlp.spProd.setModel(new SpinnerListModel(productos));
		vmlp.spProd.setValue(np);
		vmlp.textCod.setText(""+cod_linea);
		vmlp.spCant.setValue(cant);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vmlp.btnModificar) {
			String fecha = "" + vmlp.dcFecha.getCalendar().get(Calendar.DAY_OF_MONTH) + "/"
					+ vmlp.dcFecha.getCalendar().get(Calendar.MONTH) + "/"
					+ vmlp.dcFecha.getCalendar().get(Calendar.YEAR);
			int cp = codProducto.get(productos.indexOf((String) vmlp.spProd.getValue()));
			int cprov = cproveedor.get(proveedor.indexOf((String) vmlp.spProd.getValue()));
			float precio = Float.parseFloat(vmlp.textCoste.getText());
			int cant = (Integer) vmlp.spCant.getValue();
			bdd.introducirCelda(cod_linea, "COD_PRODUCTO", "COD_LINEA", "LINEAPEDIDO ", cp);
			bdd.introducirCelda(cod_linea, "CANTIDAD", "COD_LINEA", "LINEAPEDIDO ", cant);
			bdd.introducirCelda(cod_linea, "COSTE", "COD_LINEA", "LINEAPEDIDO ", precio);
			bdd.introducirCeldaS(cod_linea, "FECHA_ENVIO", "COD_LINEA", "LINEAPEDIDO ", fecha);
			bdd.introducirCelda(cod_linea, "COD_PROVEEDOR", "COD_LINEA", "LINEAPEDIDO ", cprov);
			DefaultTableModel tablamodelo = (DefaultTableModel) vlp.table.getModel();
			tablamodelo.setValueAt(vmlp.spProd.getValue(), fila, 1);
			tablamodelo.setValueAt(vmlp.spProd.getValue(), fila, 2);
			tablamodelo.setValueAt(cant, fila, 3);
			tablamodelo.setValueAt(precio, fila, 4);
			tablamodelo.setValueAt(fecha, fila, 5);
			vlp.setEnabled(true);
			vmlp.dispose();
		} else if (obj == vmlp.btnCancelar) {
			vlp.setEnabled(true);
			vmlp.dispose();
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
		float p = costeProducto.get(productos.indexOf(vmlp.spProd.getValue()));
		int c = (Integer) vmlp.spCant.getValue();
		vmlp.textCoste.setText("" + p * c);

	}

}