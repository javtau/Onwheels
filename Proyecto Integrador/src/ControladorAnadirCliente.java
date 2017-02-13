
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

public class ControladorAnadirCliente implements ActionListener, WindowListener {
	VistaDatos vd = null;
	VistaAnadirCliente vac = null;
	OracleAcces bdd = null;
	ArrayList<Clientes> cli = new ArrayList<Clientes>();
	int cod_cli;

	public ControladorAnadirCliente(VistaDatos vd, VistaAnadirCliente vac, OracleAcces bdd, ArrayList<Clientes> cli,
			int cod_cli) {
		super();
		this.vd = vd;
		this.vac = vac;
		this.bdd = bdd;
		this.cli = cli;
		this.cod_cli = cod_cli;
	}

	public void inicializar() {
		vac.textCod.setText("" + cod_cli);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vac.btnAnadir) {
			if (vac.textApell.getText().equals("") || vac.textCorreo.getText().equals("")
					|| vac.textDirec.getText().equals("") || vac.textDni.getText().equals("")
					|| vac.textNomb.getText().equals("") || vac.textTel.getText().equals("")
					|| vac.textCuenta.getText().equals("")) {
				JOptionPane.showMessageDialog(vac, "Debe de rellenar todos los campos");
			} else if (bdd.buscar(vac.textDni.getText(), "DNI", "CLIENTE")) {
				JOptionPane.showMessageDialog(vac, "El Dni introducido ya se encuentra en la tabla");
			} else {
				try {
					String cliente = (cod_cli + ",'" + vac.textDirec.getText() + "','" + vac.textCorreo.getText()
							+ "','" + vac.textCuenta.getText() + "','" + vac.textNomb.getText() + "','"
							+ vac.textApell.getText() + "'," + Integer.parseInt(vac.textTel.getText()) + ",'"
							+ vac.textDni.getText() + "'");
					bdd.introducirFila(cliente, "CLIENTE");
					DefaultTableModel tablamodelo = (DefaultTableModel) vd.tableCli.getModel();
					tablamodelo.addRow(new Object[] { cod_cli, vac.textDni.getText(), vac.textNomb.getText(),
							vac.textApell.getText(), Integer.parseInt(vac.textTel.getText()),
							Integer.parseInt(vac.textTel.getText()), vac.textDirec.getText(),
							vac.textCuenta.getText() });
					Clientes ncli = new Clientes(cod_cli, vac.textDirec.getText(), vac.textCorreo.getText(),
							vac.textCuenta.getText(), vac.textNomb.getText(), vac.textApell.getText(),
							Integer.parseInt(vac.textTel.getText()), vac.textDni.getText());
					cli.add(ncli);
					ControladorDatos.incrementarCodcli();
					vd.setEnabled(true);
					vac.dispose();
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "El formato del telofono no es correcto");
				}

			}
		} else if (obj == vac.btnCancelar) {
			vd.setEnabled(true);
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
