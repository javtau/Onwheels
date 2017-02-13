
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorModificarTransportenac implements ActionListener, WindowListener {
	VistaDatos vd = null;
	VistaModificarTransportenac vmtn = null;
	OracleAcces bdd = null;
	TransporteNacional transnac = null;
	int cod_transnac;
	int fila;
	public ControladorModificarTransportenac(VistaDatos vd, VistaModificarTransportenac vmtn, OracleAcces bdd,
			TransporteNacional transnac, int cod_transnac,int fila) {
		super();
		this.vd = vd;
		this.vmtn = vmtn;
		this.bdd = bdd;
		this.transnac = transnac;
		this.cod_transnac = cod_transnac;
		this.fila =fila;
	}

	public void inicializar() {
		vmtn.textCod.setText("" + cod_transnac);
		vmtn.textNomb.setText(transnac.getNombre());
		vmtn.textDireccion.setText(transnac.getDireccion());
		vmtn.textCuenta.setText(transnac.getDatosbancarios());
		
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vmtn.btnModificar) {
			if (vmtn.textNomb.getText().equals("") || vmtn.textDireccion.getText().equals("") || vmtn.textCuenta.getText().equals("")) {
				JOptionPane.showMessageDialog(vmtn, "Debe de rellenar todos los campos");
			} else {
				
					String tranna = (cod_transnac + ",'" + vmtn.textCuenta.getText() + "','" + vmtn.textDireccion.getText()
							+ vmtn.textNomb.getText() + "'");
					bdd.introducirCeldaS(cod_transnac, "DATOSBANCARIOS", "COD_TRANSPORTE_NA", "TRANSPORTENACIONAL ",(String) vmtn.textCuenta.getText());
					bdd.introducirCeldaS(cod_transnac, "DIRECCION", "COD_TRANSPORTE_NA", "TRANSPORTENACIONAL ",(String) vmtn.textDireccion.getText());
					bdd.introducirCeldaS(cod_transnac, "NOMBRE", "COD_TRANSPORTE_NA", "TRANSPORTENACIONAL ",(String) vmtn.textNomb.getText());
					DefaultTableModel tablamodelo = (DefaultTableModel) vd.tableTransnac.getModel();
					tablamodelo.setValueAt(vmtn.textNomb.getText(), fila, 1);
					tablamodelo.setValueAt(vmtn.textDireccion.getText(), fila, 2);
					tablamodelo.setValueAt(vmtn.textCuenta.getText(), fila, 3);
					
					vd.setEnabled(true);
					vmtn.dispose();
				
			}
		} else if (obj == vmtn.btnCancelar) {
			vd.setEnabled(true);
			vmtn.dispose();
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
