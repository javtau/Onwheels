
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

public class ControladorModificarInterprete implements ActionListener, WindowListener {
	VistaDatos vd = null;
	VistaModificarInterprete vmi = null;
	OracleAcces bdd = null;
	Interprete interpr = null;
	int cod_interprete;
	int fila;

	public ControladorModificarInterprete(VistaDatos vd, VistaModificarInterprete vmi, OracleAcces bdd,
			Interprete interpr, int cod_interprete, int fila) {
		super();
		this.vd = vd;
		this.vmi = vmi;
		this.bdd = bdd;
		this.interpr = interpr;
		this.cod_interprete = cod_interprete;
		this.fila = fila;
	}

	public void inicializar() {
		vmi.textCod.setText("" + cod_interprete);
		vmi.textDni.setText(interpr.getDni());
		vmi.textNomb.setText(interpr.getNombre());
		vmi.textApell.setText(interpr.getApellidos());
		vmi.textTel.setText("" + interpr.getTelefono());
		vmi.textDireccion.setText(interpr.getDireccion());
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vmi.btnModificar) {
			if (vmi.textDni.getText().equals("") || vmi.textNomb.getText().equals("")
					|| vmi.textApell.getText().equals("") || vmi.textTel.getText().equals("")
					|| vmi.textDireccion.getText().equals("")) {
				JOptionPane.showMessageDialog(vmi, "Debe de rellenar todos los campos");
			} else {
				bdd.introducirCeldaS(cod_interprete, "DNI", "COD_INTERPRETE", "INTERPRETE",  vmi.textDni.getText());
				bdd.introducirCeldaS(cod_interprete, "NOMBRE", "COD_INTERPRETE", "INTERPRETE",  vmi.textNomb.getText());
				bdd.introducirCeldaS(cod_interprete, "APELLIDOS", "COD_INTERPRETE", "INTERPRETE",  vmi.textApell.getText());
				bdd.introducirCeldaS(cod_interprete, "TELEFONO", "COD_INTERPRETE", "INTERPRETE",  vmi.textTel.getText());
				bdd.introducirCeldaS(cod_interprete, "DIRECCION", "COD_INTERPRETE", "INTERPRETE",  vmi.textDireccion.getText());
				DefaultTableModel tablamodelo = (DefaultTableModel) vd.tableInter.getModel();
				tablamodelo.setValueAt(cod_interprete, fila, 0);
				tablamodelo.setValueAt(vmi.textDni.getText(), fila, 1);
				tablamodelo.setValueAt(vmi.textNomb.getText(), fila, 2);
				tablamodelo.setValueAt(vmi.textApell.getText(), fila, 3);
				tablamodelo.setValueAt(vmi.textTel.getText(), fila, 4);
				tablamodelo.setValueAt(vmi.textDireccion.getText(), fila, 5);
				vd.setEnabled(true);
				vmi.dispose();

			}
		} else if (obj == vmi.btnCancelar) {
			vd.setEnabled(true);
			vmi.dispose();
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
