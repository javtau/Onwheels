
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

public class ControladorModificarCliente implements ActionListener, WindowListener {
	VistaDatos vd = null;
	VistaModificarCliente vmc = null;
	OracleAcces bdd = null;
	Clientes cliente=null;
	ArrayList<Clientes> cli= new ArrayList<Clientes>();
	int cod_cli;
	int fila;
	
	

	public ControladorModificarCliente(VistaDatos vd, VistaModificarCliente vmc, OracleAcces bdd, Clientes cliente,
			ArrayList<Clientes> cli, int cod_cli, int fila) {
		super();
		this.vd = vd;
		this.vmc = vmc;
		this.bdd = bdd;
		this.cliente = cliente;
		this.cli = cli;
		this.cod_cli = cod_cli;
		this.fila = fila;
	}

	public void inicializar() {
		vmc.textCod.setText("" + cod_cli);
		vmc.textDirec.setText(cliente.getUbicacion());
		vmc.textCorreo.setText(cliente.getCorreo());
		vmc.textCuenta.setText(cliente.getDatos_bancarios());
		vmc.textNomb.setText(cliente.getNombre());
		vmc.textApell.setText(cliente.getApellidos());
		vmc.textTel.setText(""+cliente.getTelefono());
		vmc.textDni.setText(cliente.getDni());
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vmc.btnModificar) {
			if (vmc.textApell.getText().equals("") || vmc.textCorreo.getText().equals("") || vmc.textDirec.getText().equals("")|| vmc.textDni.getText().equals("")|| vmc.textNomb.getText().equals("")|| vmc.textTel.getText().equals("") || vmc.textCuenta.getText().equals("")){
				JOptionPane.showMessageDialog(vmc, "Debe de rellenar todos los campos");
			}
			else {
				try {
					//float precio =  (Float) vmc.spPrecio.getValue();
					bdd.introducirCeldaS(cod_cli, "UBICACION", "COD_CLIENTE", "CLIENTE ", vmc.textDirec.getText());
					bdd.introducirCeldaS(cod_cli, "CORREO", "COD_CLIENTE", "CLIENTE ", vmc.textCorreo.getText());
					bdd.introducirCeldaS(cod_cli, "DATOSBANCARIOS", "COD_CLIENTE", "CLIENTE ", vmc.textCuenta.getText());
					bdd.introducirCeldaS(cod_cli, "NOMBRE", "COD_CLIENTE", "CLIENTE ", vmc.textNomb.getText());
					bdd.introducirCeldaS(cod_cli, "APELLIDOS", "COD_CLIENTE", "CLIENTE ", vmc.textApell.getText());
					bdd.introducirCelda(cod_cli, "TELEFONO", "COD_CLIENTE", "CLIENTE ", Integer.parseInt(vmc.textTel.getText()));
					bdd.introducirCeldaS(cod_cli, "DNI", "COD_CLIENTE", "CLIENTE ", vmc.textDni.getText());
					DefaultTableModel tablamodelo = (DefaultTableModel) vd.tableCli.getModel();
					tablamodelo.setValueAt(cod_cli, fila, 0);
					tablamodelo.setValueAt(vmc.textDni.getText(), fila, 1);
					tablamodelo.setValueAt(vmc.textNomb.getText(), fila, 2);
					tablamodelo.setValueAt(vmc.textApell.getText(), fila, 3);
					tablamodelo.setValueAt(vmc.textTel.getText(), fila, 4);
					tablamodelo.setValueAt(vmc.textCorreo.getText(), fila, 5);
					tablamodelo.setValueAt(vmc.textDirec.getText(), fila, 6);
					tablamodelo.setValueAt(vmc.textCuenta.getText(), fila, 7);
					vd.setEnabled(true);
					vmc.dispose();
				} catch (NumberFormatException ne) {
					JOptionPane.showMessageDialog(vmc, "El formato del precio no es correcto");
				}
			}
		} else if (obj == vmc.btnCancelar) {
			//vd.setEnabled(true);
			vd.setEnabled(true);
			vmc.dispose();
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
