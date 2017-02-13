
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorModificarAgente implements ActionListener, WindowListener {
	VistaDatos vd = null;
	VistaModificarAgente vma = null;
	OracleAcces bdd = null;
	AgenteAduanas agen = null;
	int cod_agente;
	int fila;
	public ControladorModificarAgente(VistaDatos vd, VistaModificarAgente vma, OracleAcces bdd,
			AgenteAduanas agen, int cod_agente,int fila) {
		super();
		this.vd = vd;
		this.vma = vma;
		this.bdd = bdd;
		this.agen = agen;
		this.cod_agente = cod_agente;
		this.fila =fila;
	}

	public void inicializar() {
		vma.textCod.setText("" + cod_agente);
		vma.textNomb.setText(agen.getNombre());
		vma.textApell.setText(agen.getApellidos());
		vma.textSede.setText(agen.getSede());
		vma.textDni.setText(agen.getDni());
		vma.textCuenta.setText(agen.getDatosbancarios());
		
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vma.btnModificar) {
			if (vma.textNomb.getText().equals("") || vma.textApell.getText().equals("")
					|| vma.textSede.getText().equals("") || vma.textDni.getText().equals("")
					|| vma.textCuenta.getText().equals("")) {
				JOptionPane.showMessageDialog(vma, "Debe de rellenar todos los campos");
			} else {
				
					String agenteadu = (cod_agente + ",'" + vma.textNomb.getText() + "','" + vma.textApell.getText()
							+ "','" + vma.textSede.getText() + "','" + vma.textDni.getText() + "','"
							+ vma.textCuenta.getText() + "'");
					bdd.introducirCeldaS(cod_agente, "NOMBRE", "COD_AGENTE", "AGENTEADUANAS ",(String) vma.textNomb.getText());
					bdd.introducirCeldaS(cod_agente, "APELLIDOS", "COD_AGENTE", "AGENTEADUANAS ",(String) vma.textApell.getText());
					bdd.introducirCeldaS(cod_agente, "SEDE", "COD_AGENTE", "AGENTEADUANAS ",(String) vma.textSede.getText());
					bdd.introducirCeldaS(cod_agente, "DNI", "COD_AGENTE", "AGENTEADUANAS ",(String) vma.textDni.getText());
					bdd.introducirCeldaS(cod_agente, "DATOSBANCARIOS", "COD_AGENTE", "AGENTEADUANAS ",(String) vma.textCuenta.getText());
					DefaultTableModel tablamodelo = (DefaultTableModel) vd.tableAgen.getModel();
					tablamodelo.setValueAt(vma.textNomb.getText(), fila, 1);
					tablamodelo.setValueAt(vma.textApell.getText(), fila, 2);
					tablamodelo.setValueAt(vma.textSede.getText(), fila, 3);
					tablamodelo.setValueAt(vma.textDni.getText(), fila, 4);
					tablamodelo.setValueAt(vma.textCuenta.getText(), fila, 5);
					vd.setEnabled(true);
					vma.dispose();
				
			}
		} else if (obj == vma.btnCancelar) {
			vd.setEnabled(true);
			vma.dispose();
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
