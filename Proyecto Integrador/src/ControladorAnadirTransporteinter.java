
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

public class ControladorAnadirTransporteinter implements ActionListener, WindowListener {
	VistaDatos vd = null;
	VistaAnadirTransporteinter vati = null;
	OracleAcces bdd = null;
	ArrayList<TransporteInternacional> transnac = new ArrayList<TransporteInternacional>();
	int cod_transnac;
	ArrayList<String> interprete = new ArrayList<String>();
	ArrayList<Integer> cinterprete = new ArrayList<Integer>();

	public ControladorAnadirTransporteinter(VistaDatos vd, VistaAnadirTransporteinter vati, OracleAcces bdd,
			ArrayList<TransporteInternacional> transnac, int cod_transnac) {
		super();
		this.vd = vd;
		this.vati = vati;
		this.bdd = bdd;
		this.transnac = transnac;
		this.cod_transnac = cod_transnac;

	}

	public void inicializar() {
		vati.textCod.setText("" + cod_transnac);
		bdd.rellenarArray(interprete, cinterprete, "NOMBRE ||' '|| APELLIDOS", "COD_INTERPRETE", "INTERPRETE");
		vati.spinter.setModel(new SpinnerListModel(interprete));
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vati.btnAnadir) {
			if (vati.textNomb.getText().equals("") || vati.textDireccion.getText().equals("")
					|| vati.textCuenta.getText().equals("")) {
				JOptionPane.showMessageDialog(vati, "Debe de rellenar todos los campos");
			} else if (bdd.buscar(vati.textNomb.getText(), "NOMBRE", "TRANSPORTEINTERNACIONAL")) {
				JOptionPane.showMessageDialog(vati, "La empresa introducida ya se encuentra en la tabla");
			} else {
				int ci = cinterprete.get(interprete.indexOf(vati.spinter.getValue()));
				String transportenac = (cod_transnac + ",'" + vati.textNomb.getText() + "','"
						+ vati.textDireccion.getText() + "','" + vati.textCuenta.getText() + "'," + ci);
				bdd.introducirFila(transportenac, "TransporteInternacional");
				DefaultTableModel tablamodelo = (DefaultTableModel) vd.tableTransinter.getModel();
				tablamodelo.addRow(new Object[] { cod_transnac, vati.textNomb.getText(), vati.textDireccion.getText(),
						vati.textCuenta.getText(), vati.spinter.getValue() });
				TransporteInternacional transinter = new TransporteInternacional(cod_transnac, vati.textNomb.getText(),
						vati.textDireccion.getText(), vati.textCuenta.getText(), ci);
				transnac.add(transinter);
				ControladorDatos.incrementarCodtransnac();
				vd.setEnabled(true);
				vati.dispose();

			}
		} else if (obj == vati.btnCancelar) {
			vd.setEnabled(true);
			vati.dispose();
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
