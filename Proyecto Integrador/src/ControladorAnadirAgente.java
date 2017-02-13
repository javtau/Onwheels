
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

public class ControladorAnadirAgente implements ActionListener, WindowListener {
	VistaDatos vd = null;
	VistaAnadirAgente vaa = null;
	OracleAcces bdd = null;
	ArrayList<AgenteAduanas> agen = new ArrayList<AgenteAduanas>();
	int cod_agente;

	public ControladorAnadirAgente(VistaDatos vd, VistaAnadirAgente vaa, OracleAcces bdd, ArrayList<AgenteAduanas> agen,
			int cod_agente) {
		super();
		this.vd = vd;
		this.vaa = vaa;
		this.bdd = bdd;
		this.agen = agen;
		this.cod_agente = cod_agente;
		
	}

	public void inicializar() {
		vaa.textCod.setText("" + cod_agente);
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vaa.btnAnadir) {
		if (vaa.textNomb.getText().equals("")|| vaa.textApell.getText().equals("") ||vaa.textSede.getText().equals("")
				||vaa.textDni.getText().equals("")|| vaa.textCuenta.getText().equals("")){
				JOptionPane.showMessageDialog(vaa, "Debe de rellenar todos los campos");
			} else if (bdd.buscar(vaa.textDni.getText(), "DNI", "AGENTEADUANAS")) {
				JOptionPane.showMessageDialog(vaa, "El Dni introducido ya se encuentra en la tabla");
			}
			else {
				
					String agenteaduanas = (cod_agente + ",'" + vaa.textNomb.getText() + "','" + vaa.textApell.getText() + "','"
							+ vaa.textSede.getText() +"','"+vaa.textDni.getText()+"','"+vaa.textCuenta.getText()+"'");
					bdd.introducirFila(agenteaduanas, "AGENTEADUANAS");
					DefaultTableModel tablamodelo = (DefaultTableModel) vd.tableAgen.getModel();
					tablamodelo.addRow(new Object[] { cod_agente, vaa.textNomb.getText(), vaa.textApell.getText(),
							vaa.textSede.getText(),vaa.textDni.getText(),vaa.textCuenta.getText()});
					AgenteAduanas agenteadu = new AgenteAduanas(cod_agente, vaa.textNomb.getText(), vaa.textApell.getText(),
							vaa.textSede.getText(),vaa.textDni.getText(),vaa.textCuenta.getText());
					agen.add(agenteadu);
					ControladorDatos.incrementarCodagen();
					vd.setEnabled(true);
					vaa.dispose();
				
			}
		} else if (obj == vaa.btnCancelar) {
			vd.setEnabled(true);
			vaa.dispose();
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
