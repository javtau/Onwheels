
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
public class ControladorAnadirProveedor implements ActionListener, WindowListener{
	VistaDatos vd = null;
	VistaAnadirProveedor vap = null;
	OracleAcces bdd = null;
	ArrayList<Proveedores> prov = new ArrayList<Proveedores>();
	int cod_prov;
	
	public ControladorAnadirProveedor(VistaDatos vd, VistaAnadirProveedor vap, OracleAcces bdd, ArrayList<Proveedores> prov,
			int cod_prov) {
		super();
		this.vd = vd;
		this.vap = vap;
		this.bdd = bdd;
		this.prov = prov;
		this.cod_prov = cod_prov;
	}
	
	public void inicializar() {
		vap.textCod.setText("" + cod_prov);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vap.btnAnadir) {
			if (vap.textCod.getText().equals("") || vap.textTel.getText().equals("") || vap.textUbicacion.getText().equals("") || vap.textNombre.getText().equals("") || vap.textNif.getText().equals("") || vap.textCuenta.getText().equals("") || vap.textContacto.getText().equals("")){
				JOptionPane.showMessageDialog(vap, "Debe de rellenar todos los campos");
			} else if (bdd.buscar(vap.textNif.getText(), "NIF", "PROVEEDORES")) {
				JOptionPane.showMessageDialog(vap, "El nif introducido ya se encuentra en la tabla");
			}
			else {
				try {
					String proveedor = (cod_prov + ",'"
							 + vap.textNombre.getText() + "',"
							 + Integer.parseInt(vap.textTel.getText()) + ",'" 
							 + vap.textUbicacion.getText() + "','"
							 + vap.textNif.getText() + "','"
							 + vap.textCuenta.getText() + "','"
							 + vap.textContacto.getText() + "'");
					bdd.introducirFila(proveedor, "PROVEEDORES");
					DefaultTableModel tablamodelo = (DefaultTableModel) vd.tableProv.getModel();
					tablamodelo.addRow(new Object[] { cod_prov, vap.textNombre.getText(),
							vap.textTel.getText(),
							vap.textUbicacion.getText(),
							vap.textNif.getText(),
							vap.textCuenta.getText(),
							vap.textContacto.getText()});
					Proveedores nprov = new Proveedores(cod_prov,
							vap.textNombre.getText(),
							Integer.parseInt(vap.textTel.getText()),
							vap.textUbicacion.getText(),
							vap.textNif.getText(),
							vap.textCuenta.getText(),
							vap.textContacto.getText());
					prov.add(nprov);
					ControladorDatos.incrementarCodprov();
					vd.setEnabled(true);
					vap.dispose();
				} catch (NumberFormatException ne) {
					JOptionPane.showMessageDialog(vap, "El formato del telefono no es correcto");
				}
			}
		} else if (obj == vap.btnCancelar) {
			vd.setEnabled(true);
			vap.dispose();
		}

	}
	
	public void windowActivated(WindowEvent arg0) {
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
