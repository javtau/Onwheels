
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

public class ControladorAnadirLineaCompra implements ActionListener, WindowListener,ChangeListener {
	VistaLineaCompra  vlc = null;
	VistaAnadirLineaCompra valc = null;
	OracleAcces bdd = null;
	ArrayList<LineaCompra> lc= new ArrayList<LineaCompra>();
	int cod_compra;
	int cod_linea;
	ArrayList<String> productos = new ArrayList<String>();
	ArrayList<Integer> cproducto = new ArrayList<Integer>();
	ArrayList<Float> costeproducto = new ArrayList<Float>();

	



	public ControladorAnadirLineaCompra(VistaLineaCompra vlc, VistaAnadirLineaCompra valc, OracleAcces bdd,
			ArrayList<LineaCompra> lc, int cod_compra, int cod_linea) {
		super();
		this.vlc = vlc;
		this.valc = valc;
		this.bdd = bdd;
		this.lc = lc;
		this.cod_compra = cod_compra;
		this.cod_linea = cod_linea;
	}

	public void inicializar(){
		valc.textCod.setText(""+cod_linea);
		bdd.rellenarArray3(productos,cproducto,costeproducto,"DESCRIPCION","COD_PRODUCTO","PRECIO","PRODUCTOS");
		valc.textCoste.setText(""+costeproducto.get(0));
		valc.spProd.setModel(new SpinnerListModel(productos));
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == valc.btnAnadir) {
			String fecha =""+valc.dcFecha.getCalendar().get(Calendar.DAY_OF_MONTH)+"/"+valc.dcFecha.getCalendar().get(Calendar.MONTH)+"/"+valc.dcFecha.getCalendar().get(Calendar.YEAR);
			int cp = cproducto.get(productos.indexOf((String) valc.spProd.getValue()));
			float precio = Float.parseFloat(valc.textCoste.getText());
			int cant =  (Integer) valc.spCant.getValue();
			String lcompra=(cod_linea+", "+cant+","+precio+",'"+fecha+"',"+cp+","+cod_compra);
			bdd.introducirFila(lcompra,"LINEACOMPRA");
			DefaultTableModel tablamodelo= (DefaultTableModel) vlc.table.getModel();
			tablamodelo.addRow(new Object []{cod_linea,(String) valc.spProd.getValue(),cant,precio,fecha});
			LineaCompra nlc = new LineaCompra(cod_linea,cant,precio,fecha,cp,cod_compra);
			lc.add(nlc);
			ControladorLineaCompra.incrementarCodlinea();
			vlc.setEnabled(true);
			valc.dispose();
		} else if (obj == valc.btnCancelar) {
			vlc.setEnabled(true);
			valc.dispose();
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
		Object obj = e.getSource();
		if (obj == valc.spProd) {
			float p = costeproducto.get(productos.indexOf(valc.spProd.getValue()));
			int c=(Integer) valc.spCant.getValue();
			valc.textCoste.setText(""+p*c);
		} else if (obj == valc.spCant) {
			float p = costeproducto.get(productos.indexOf(valc.spProd.getValue()));
			int c=(Integer) valc.spCant.getValue();
			valc.textCoste.setText(""+p*c);
		}
	}

}
