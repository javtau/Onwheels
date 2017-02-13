
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

public class ControladorAnadirPedido implements ActionListener, WindowListener {
	VistaPedido vPedido = null;
	VistaAnadirPedido vap = null;
	Pedido p = null;
	OracleAcces bdd = null;
	ArrayList<Pedido> ped = new ArrayList<Pedido>(); // array que contendra los transportes incluidos en la tabla
	int cod_pedido;
	ArrayList<String> transportes = new ArrayList<String>();
	ArrayList<Integer> ctransporte = new ArrayList<Integer>();
	
	ArrayList<String> agente = new ArrayList<String>();
	ArrayList<Integer> cagente = new ArrayList<Integer>();
 
	public ControladorAnadirPedido(VistaPedido vPedido, VistaAnadirPedido vap, Pedido p, OracleAcces bdd,
			ArrayList<Pedido> ped, int cod_pedido) {
		super();
		this.vPedido = vPedido;
		this.vap = vap;
		this.p = p;
		this.bdd = bdd;
		this.ped = ped;
		this.cod_pedido = cod_pedido;
	}



	public void inicializar(){
		vap.textCod.setText(""+cod_pedido);
		bdd.rellenarArray(transportes,ctransporte,"NOMBRE","COD_TRANSPORTE","TRANSPORTEINTERNACIONAL");
		vap.spTrans.setModel(new SpinnerListModel(transportes));
		bdd.rellenarArray(agente, cagente,"NOMBRE", "COD_AGENTE", "AGENTEADUANAS");
		vap.spAgente.setModel(new SpinnerListModel(agente));
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vap.btnAnadir) {
			String fecha =""+vap.dcFecha.getCalendar().get(Calendar.DAY_OF_MONTH)+"/"+vap.dcFecha.getCalendar().get(Calendar.MONTH)+"/"+vap.dcFecha.getCalendar().get(Calendar.YEAR);
			int tr = ctransporte.get(transportes.indexOf((String) vap.spTrans.getValue()));
			int ca = cagente.get(agente.indexOf((String) vap.spAgente.getValue()));
			String pedido=(cod_pedido+", "+tr+",0,'"+ca+"','"+fecha+"'");
			bdd.introducirFila(pedido,"PEDIDO");
			p=new Pedido(cod_pedido,tr,ca,0f,fecha);
			DefaultTableModel tablamodelo= (DefaultTableModel) vPedido.table.getModel();
			tablamodelo.addRow(new Object []{p.getCod_pedido(),(String) vap.spAgente.getValue(),(String) vap.spTrans.getValue(),p.getFecha(),p.getCoste()});
			ped.add(p);
			ControladorPedido.incrementarCodpedido();
			vPedido.setEnabled(true);
			vap.dispose();
		} else if (obj == vap.btnCancelar) {
			vPedido.setEnabled(true);
			vap.dispose();
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
		vPedido.setEnabled(true);
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
