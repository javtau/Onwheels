
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.SpinnerListModel;
import javax.swing.table.DefaultTableModel;

public class ControladorAnadirCompra implements ActionListener, WindowListener {
	VistaCompra vCompra = null;
	VistaAnadirCompra vac = null;
	Compra c = null;
	OracleAcces bdd = null;
	ArrayList<Compra> comp = new ArrayList<Compra>(); // array que contendra los transportes incluidos en la tabla
	int cod_compra;
	ArrayList<String> transportes = new ArrayList<String>();
	ArrayList<Integer> ctransporte = new ArrayList<Integer>();

	public ControladorAnadirCompra(VistaCompra vCompra, VistaAnadirCompra vac, Compra c, OracleAcces bdd,
			ArrayList<Compra> comp, int cod_compra) {
		super();
		this.vCompra = vCompra;
		this.vac = vac;
		this.c = c;
		this.bdd = bdd;
		this.comp = comp;
		this.cod_compra = cod_compra;
	}



	public void inicializar(){
		vac.textCod.setText(""+cod_compra);
		bdd.rellenarArray(transportes,ctransporte,"NOMBRE","COD_TRANSPORTE_NA","TRANSPORTENACIONAL");
		vac.spTrans.setModel(new SpinnerListModel(transportes));
		String[] tipos = { "online", "Telefono", "Tienda" }; // array que contiene los tipos de compra
		vac.spTipo.setModel(new SpinnerListModel(tipos));
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vac.btnAnadir) {
			String fecha =""+vac.dcFecha.getCalendar().get(Calendar.DAY_OF_MONTH)+"/"+vac.dcFecha.getCalendar().get(Calendar.MONTH)+"/"+vac.dcFecha.getCalendar().get(Calendar.YEAR);
			int tr = ctransporte.get(transportes.indexOf((String) vac.spTrans.getValue()));
			String tip = (String) vac.spTipo.getValue();
			String compra=(cod_compra+", "+tr+",0,'"+tip+"','"+fecha+"'");
			bdd.introducirFila(compra,"COMPRA");
			c=new Compra(cod_compra,tr,0,tip,fecha);
			DefaultTableModel tablamodelo= (DefaultTableModel) vCompra.table.getModel();
			tablamodelo.addRow(new Object []{c.getCod_compra(),(String) vac.spTrans.getValue(),c.getCoste(),c.getTipo(),c.getFecha()});
			comp.add(c);
			ControladorCompra.incrementarCodcompra();
			vCompra.setEnabled(true);
			vac.dispose();
		} else if (obj == vac.btnCancelar) {
			vCompra.setEnabled(true);
			vac.dispose();
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
		vCompra.setEnabled(true);
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

}
