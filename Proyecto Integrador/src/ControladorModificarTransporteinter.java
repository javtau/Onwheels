
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SpinnerListModel;
import javax.swing.table.DefaultTableModel;

public class ControladorModificarTransporteinter implements ActionListener, WindowListener {
	VistaDatos vd = null;
	VistaModificarTransporteinter vmti = null;
	OracleAcces bdd = null;
	int cod_transnin;
	String nom;
	String direc;
	String cuenta;
	String inter;
	int fila;
	ArrayList<String> interprete = new ArrayList<String>();
	ArrayList<Integer> cinterprete = new ArrayList<Integer>();
	
	

	public ControladorModificarTransporteinter(VistaDatos vd, VistaModificarTransporteinter vmti, OracleAcces bdd,
			int cod_transnin, String nom, String direc, String cuenta, String inter, int fila) {
		super();
		this.vd = vd;
		this.vmti = vmti;
		this.bdd = bdd;
		this.cod_transnin = cod_transnin;
		this.nom = nom;
		this.direc = direc;
		this.cuenta = cuenta;
		this.inter = inter;
		this.fila = fila;
	}

	public void inicializar() {
		vmti.textCod.setText("" + cod_transnin);
		vmti.textNomb.setText(nom);
		vmti.textDireccion.setText(direc);
		vmti.textCuenta.setText(cuenta);
		bdd.rellenarArray(interprete,cinterprete,"NOMBRE ||' '|| APELLIDOS","COD_INTERPRETE","INTERPRETE");
		vmti.spinter.setModel(new SpinnerListModel(interprete));
		vmti.spinter.setValue(inter);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vmti.btnModificar) {
			if (vmti.textNomb.getText().equals("") || vmti.textDireccion.getText().equals("") || vmti.textCuenta.getText().equals("")) {
				JOptionPane.showMessageDialog(vmti, "Debe de rellenar todos los campos");
			} else {
				    int ci =cinterprete.get(interprete.indexOf(vmti.spinter.getValue()));
				  bdd.introducirCeldaS(cod_transnin, "NOMBRE", "COD_TRANSPORTE", "TRANSPORTEINTERNACIONAL ",(String) vmti.textNomb.getText());
					bdd.introducirCeldaS(cod_transnin, "DIRECCION", "COD_TRANSPORTE", "TRANSPORTEINTERNACIONAL ",(String) vmti.textDireccion.getText());
					bdd.introducirCeldaS(cod_transnin, "DATOSBANCARIOS", "COD_TRANSPORTE", "TRANSPORTEINTERNACIONAL ",(String) vmti.textCuenta.getText());
					bdd.introducirCelda(cod_transnin, "COD_INTERPRETE", "COD_TRANSPORTE", "TRANSPORTEINTERNACIONAL ",ci);
					DefaultTableModel tablamodelo = (DefaultTableModel) vd.tableTransinter.getModel();
					tablamodelo.setValueAt(vmti.textNomb.getText(), fila, 1);
					tablamodelo.setValueAt(vmti.textDireccion.getText(), fila, 2);
					tablamodelo.setValueAt(vmti.textCuenta.getText(), fila, 3);
					tablamodelo.setValueAt(vmti.spinter.getValue(), fila, 4);
					
					vd.setEnabled(true);
					vmti.dispose();
				
			}
		} else if (obj == vmti.btnCancelar) {
			vd.setEnabled(true);
			vmti.dispose();
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
		vd.setEnabled(true);
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
