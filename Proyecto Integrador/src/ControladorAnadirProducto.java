
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

public class ControladorAnadirProducto implements ActionListener, WindowListener {
	VistaDatos vd = null;
	VistaAnadirProducto vap = null;
	OracleAcces bdd = null;
	ArrayList<Productos> prod = new ArrayList<Productos>();
	int cod_prod;

	public ControladorAnadirProducto(VistaDatos vd, VistaAnadirProducto vap, OracleAcces bdd, ArrayList<Productos> prod,
			int cod_prod) {
		super();
		this.vd = vd;
		this.vap = vap;
		this.bdd = bdd;
		this.prod = prod;
		this.cod_prod = cod_prod;
	}

	public void inicializar() {
		vap.textCod.setText("" + cod_prod);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vap.btnAnadir) {
			if (vap.textDesc.getText().equals("") || vap.textTipo.getText().equals("")) {
				JOptionPane.showMessageDialog(vap, "Debe de rellenar todos los campos");
			} else if (bdd.buscar(vap.textDesc.getText(), "DESCRIPCION", "PRODUCTOS")) {
				JOptionPane.showMessageDialog(vap, "El Producto introducido ya se encuentra en la tabla");
			} else {
				try {
					String producto = (cod_prod + "," + vap.spPrecio.getValue() + ",'" + vap.textDesc.getText() + "','"
							+ vap.textTipo.getText() + "'");
					bdd.introducirFila(producto, "PRODUCTOS");
					DefaultTableModel tablamodelo = (DefaultTableModel) vd.tableProd.getModel();
					tablamodelo.addRow(new Object[] { cod_prod, vap.textDesc.getText(), vap.textTipo.getText(),
							vap.spPrecio.getValue() });
					Productos nprod = new Productos(cod_prod, (Float) vap.spPrecio.getValue(), vap.textDesc.getText(),
							vap.textTipo.getText());
					prod.add(nprod);
					cod_prod++;
					// ControladorDatos.incrementarCodprod();
					vd.setEnabled(true);
					vap.dispose();
				} catch (NumberFormatException ne) {
					JOptionPane.showMessageDialog(vap, "El formato del precio no es correcto");
				}
			}
		} else if (obj == vap.btnCancelar) {
			vd.setEnabled(true);
			vap.dispose();
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
