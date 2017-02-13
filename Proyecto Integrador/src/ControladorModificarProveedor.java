
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorModificarProveedor implements ActionListener, WindowListener {
	VistaDatos vd = null;
	VistaModificarProveedor vmp = null;
	OracleAcces bdd = null;
	Proveedores prov = null;
	int cod_prov;
	int fila;

	public ControladorModificarProveedor(VistaDatos vd, VistaModificarProveedor vmp, OracleAcces bdd,
			Proveedores prov, int cod_prov,int fila) {
		super();
		this.vd = vd;
		this.vmp = vmp;
		this.bdd = bdd;
		this.prov = prov;
		this.cod_prov = cod_prov;
		this.fila = fila;
	}

	public void inicializar() {
		vmp.textCod.setText("" + cod_prov);
		vmp.textUbicacion.setText(prov.getUbicacion());
		vmp.textCuenta.setText(prov.getCod_cuenta());
		vmp.textNombre.setText(prov.getNombre());
		vmp.textTel.setText(""+prov.getTelefono());
		vmp.textNif.setText(prov.getNif());
		vmp.textContacto.setText(prov.getPerscontacto());
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vmp.btnModificar) {
			if (vmp.textCod.getText().equals("") || vmp.textTel.getText().equals("")
					|| vmp.textUbicacion.getText().equals("") || vmp.textNombre.getText().equals("")
					|| vmp.textNif.getText().equals("") || vmp.textCuenta.getText().equals("")
					|| vmp.textContacto.getText().equals("")) {
				JOptionPane.showMessageDialog(vmp, "Debe de rellenar todos los campos");
			} else {
				try {

					
					bdd.introducirCeldaS(cod_prov, "TELEFONO", "COD_PROVEEDOR", "PROVEEDORES ",
							(String) vmp.textTel.getText());
					bdd.introducirCeldaS(cod_prov, "UBICACION", "COD_PROVEEDOR", "PROVEEDORES ",
							(String) vmp.textUbicacion.getText());
					bdd.introducirCeldaS(cod_prov, "NOMBRE", "COD_PROVEEDOR", "PROVEEDORES ",
							(String) vmp.textNombre.getText());
					bdd.introducirCeldaS(cod_prov, "NIF", "COD_PROVEEDOR", "PROVEEDORES ",
							(String) vmp.textNif.getText());
					bdd.introducirCeldaS(cod_prov, "COD_CUENTA", "COD_PROVEEDOR", "PROVEEDORES ",
							(String) vmp.textCuenta.getText());
					bdd.introducirCeldaS(cod_prov, "PERSCONTACTO", "COD_PROVEEDOR", "PROVEEDORES ",
							(String) vmp.textContacto.getText());
					DefaultTableModel tablamodelo = (DefaultTableModel) vd.tableProv.getModel();
					tablamodelo.setValueAt(cod_prov, fila, 0);
					tablamodelo.setValueAt(vmp.textNombre.getText(), fila, 1);
					tablamodelo.setValueAt(vmp.textTel.getText(), fila, 2);
					tablamodelo.setValueAt(vmp.textUbicacion.getText(), fila, 3);
					tablamodelo.setValueAt(vmp.textNif.getText(), fila, 4);
					tablamodelo.setValueAt(vmp.textCuenta.getText(), fila, 5);
					tablamodelo.setValueAt(vmp.textContacto.getText(), fila, 6);
					vd.setEnabled(true);
					vmp.dispose();
				} catch (NumberFormatException ne) {
					JOptionPane.showMessageDialog(vmp, "El formato del telefono no es correcto"); 
				}
			}
		} else if (obj == vmp.btnCancelar) {
			// vd.setEnabled(true);
			vd.setEnabled(true);
			vmp.dispose();
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
