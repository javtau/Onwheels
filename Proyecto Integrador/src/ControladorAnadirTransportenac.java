
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

public class ControladorAnadirTransportenac implements ActionListener, WindowListener {
	VistaDatos vd = null;
	VistaAnadirTransportenac vatn = null;
	OracleAcces bdd = null;
	ArrayList<TransporteNacional> transnac = new ArrayList<TransporteNacional>();
	int cod_transnac;

	public ControladorAnadirTransportenac(VistaDatos vd, VistaAnadirTransportenac vatn, OracleAcces bdd, ArrayList<TransporteNacional> transnac,
			int cod_transnac) {
		super();
		this.vd = vd;
		this.vatn = vatn;
		this.bdd = bdd;
		this.transnac = transnac;
		this.cod_transnac = cod_transnac;
		
	}

	public void inicializar() {
		vatn.textCod.setText("" + cod_transnac);
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vatn.btnAnadir) {
		if (vatn.textNomb.getText().equals("")|| vatn.textDireccion.getText().equals("") ||vatn.textCuenta.getText().equals("")){
				JOptionPane.showMessageDialog(vatn, "Debe de rellenar todos los campos");
			} else if (bdd.buscar(vatn.textNomb.getText(), "NOMBRE", "TRANSPORTENACIONAL")) {
				JOptionPane.showMessageDialog(vatn, "La empresa introducida ya se encuentra en la tabla");
			}
			else {
				
					String transportenac = (cod_transnac + ",'" + vatn.textCuenta.getText() + "','" + vatn.textDireccion.getText() + "','"
							+ vatn.textNomb.getText() +"'");
					bdd.introducirFila(transportenac, "TRANSPORTENACIONAL");
					DefaultTableModel tablamodelo = (DefaultTableModel) vd.tableTransnac.getModel();
					tablamodelo.addRow(new Object[] { cod_transnac, vatn.textNomb.getText(), vatn.textDireccion.getText(),vatn.textCuenta.getText()});
					TransporteNacional transna = new TransporteNacional(cod_transnac, vatn.textCuenta.getText(), vatn.textDireccion.getText(),
							vatn.textNomb.getText());
					transnac.add(transna);
					ControladorDatos.incrementarCodtransnac();
					vd.setEnabled(true);
					vatn.dispose();
				
			}
		} else if (obj == vatn.btnCancelar) {
			vd.setEnabled(true);
			vatn.dispose();
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
