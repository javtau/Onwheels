
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

public class ControladorAnadirInterprete implements ActionListener, WindowListener {
	VistaDatos vd = null;
	VistaAnadirInterprete vai = null;
	OracleAcces bdd = null;
	ArrayList<Interprete> interpr = new ArrayList<Interprete>();
	int cod_interprete;

	public ControladorAnadirInterprete(VistaDatos vd, VistaAnadirInterprete vai, OracleAcces bdd,
			ArrayList<Interprete> interpr, int cod_interprete) {
		super();
		this.vd = vd;
		this.vai = vai;
		this.bdd = bdd;
		this.interpr = interpr;
		this.cod_interprete = cod_interprete;
	}

	public void inicializar() {
		vai.textCod.setText("" + cod_interprete);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vai.btnAnadir) {
			if (vai.textDni.getText().equals("") || vai.textNomb.getText().equals("")
					|| vai.textApell.getText().equals("") || vai.textTel.getText().equals("")
					|| vai.textDireccion.getText().equals("")) {
				JOptionPane.showMessageDialog(vai, "Debe de rellenar todos los campos");
			} else {
				String interpretes = (cod_interprete + ",'" + vai.textDni.getText() + "','" + vai.textNomb.getText()
						+ "','" + vai.textApell.getText() + "','" + vai.textTel.getText() + "','"
						+ vai.textDireccion.getText() + "'");
				bdd.introducirFila(interpretes, "INTERPRETE");
				DefaultTableModel tablamodelo = (DefaultTableModel) vd.tableInter.getModel();
				tablamodelo.addRow(new Object[] { cod_interprete, vai.textDni.getText(), vai.textNomb.getText(),
						vai.textApell.getText(), vai.textTel.getText(), vai.textDireccion.getText() });
				Interprete interp = new Interprete(cod_interprete, vai.textDni.getText(), vai.textNomb.getText(),
						vai.textApell.getText(), vai.textTel.getText(), vai.textDireccion.getText());
				interpr.add(interp);
				ControladorDatos.incrementarCodInter();
				vd.setEnabled(true);
				vai.dispose();
			}
		} else if (obj == vai.btnCancelar) {
			vd.setEnabled(true);
			vai.dispose();
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
