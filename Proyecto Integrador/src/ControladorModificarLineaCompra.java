
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class ControladorModificarLineaCompra implements ActionListener, WindowListener, ChangeListener {
	VistaLineaCompra vlc = null;
	VistaModificarLineaCompra vmlc = null;
	OracleAcces bdd = null;
	ArrayList<LineaCompra> lineasCompra = null;
	String np = null;
	int cant = 0;
	int cod_compra;
	int cod_linea;
	ArrayList<String> productos = new ArrayList<String>();
	ArrayList<Integer> codProducto = new ArrayList<Integer>();
	ArrayList<Float> costeProducto = new ArrayList<Float>();
	int fila;
	String fecha=null;

	public ControladorModificarLineaCompra(VistaLineaCompra vlc, VistaModificarLineaCompra vmlc, OracleAcces bdd,
			ArrayList<LineaCompra> lineasCompra, int cod_compra, int cod_linea, String np, int cant, int fila,String fecha) {
		super();
		this.vlc = vlc;
		this.vmlc = vmlc;
		this.bdd = bdd;
		this.lineasCompra = lineasCompra;
		this.cod_compra = cod_compra;
		this.cod_linea = cod_linea;
		this.np = np;
		this.cant = cant;
		this.fila = fila;
		this.fecha=fecha;
	}

	public void inicializar() {
		bdd.rellenarArray3(productos, codProducto, costeProducto, "DESCRIPCION", "COD_PRODUCTO", "PRECIO", "PRODUCTOS");
		vmlc.textCod.setText("" + cod_linea);
		vmlc.spCant.setValue(cant);
		float p = costeProducto.get(productos.indexOf(np)) * cant;
		vmlc.textCoste.setText("" + p);
		vmlc.spProd.setModel(new SpinnerListModel(productos));
		vmlc.spProd.setValue(np);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			cal.setTime(sdf.parse(fecha));
			vmlc.dcFecha.setCalendar(cal);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vmlc.btnModificar) {
			String fecha = "" + vmlc.dcFecha.getCalendar().get(Calendar.DAY_OF_MONTH) + "/"
					+ vmlc.dcFecha.getCalendar().get(Calendar.MONTH) + "/"
					+ vmlc.dcFecha.getCalendar().get(Calendar.YEAR);
			int cp = codProducto.get(productos.indexOf((String) vmlc.spProd.getValue()));
			float precio = Float.parseFloat(vmlc.textCoste.getText());
			int cant = (Integer) vmlc.spCant.getValue();
			bdd.introducirCelda(cod_linea, "COD_PRODUCTO", "COD_LINEA", "LINEACOMPRA ", cp);
			bdd.introducirCelda(cod_linea, "CANTIDAD", "COD_LINEA", "LINEACOMPRA ", cant);
			bdd.introducirCelda(cod_linea, "COSTE", "COD_LINEA", "LINEACOMPRA ", precio);
			bdd.introducirCeldaS(cod_linea, "FECHA_ENVIO", "COD_LINEA", "LINEACOMPRA ", fecha);
			DefaultTableModel tablamodelo = (DefaultTableModel) vlc.table.getModel();
			tablamodelo.setValueAt(vmlc.spProd.getValue(), fila, 1);
			tablamodelo.setValueAt(cant, fila, 2);
			tablamodelo.setValueAt(precio, fila, 3);
			tablamodelo.setValueAt(fecha, fila, 4);
			vlc.setEnabled(true);
			vmlc.dispose();
		} else if (obj == vmlc.btnCancelar) {
			vlc.setEnabled(true);
			vmlc.dispose();
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
		vlc.setEnabled(true);
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
		float p = costeProducto.get(productos.indexOf(vmlc.spProd.getValue()));
		int c = (Integer) vmlc.spCant.getValue();
		vmlc.textCoste.setText("" + p * c);

	}

}
