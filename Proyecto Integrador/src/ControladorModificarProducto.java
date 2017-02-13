
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

public class ControladorModificarProducto implements ActionListener, WindowListener {
	VistaDatos vd = null;
	VistaModificarProducto vmp = null;
	OracleAcces bdd = null;
	ArrayList<Productos> prod = new ArrayList<Productos>();
	int cod_prod;
	int fila;
	float coste;
	String nom;
	String tip;

	

	

	public ControladorModificarProducto(VistaDatos vd, VistaModificarProducto vmp, OracleAcces bdd,
			ArrayList<Productos> prod, int cod_prod, int fila, float coste, String nom, String tip) {
		super();
		this.vd = vd;
		this.vmp = vmp;
		this.bdd = bdd;
		this.prod = prod;
		this.cod_prod = cod_prod;
		this.fila = fila;
		this.coste = coste;
		this.nom = nom;
		this.tip = tip;
	}

	public void inicializar() {
		vmp.textCod.setText("" + cod_prod);
		vmp.spPrecio.setValue(coste);
		vmp.textDesc.setText(nom);
		vmp.textTipo.setText(tip);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vmp.btnModificar) {
			if (vmp.textDesc.getText().equals("") || vmp.textTipo.getText().equals("") ){
				JOptionPane.showMessageDialog(vmp, "Debe de rellenar todos los campos");
			}
			else {
				try {
					float precio =  (Float) vmp.spPrecio.getValue();
					bdd.introducirCelda(cod_prod, "PRECIO", "COD_PRODUCTO", "PRODUCTOS ", precio);
					bdd.introducirCeldaS(cod_prod, "DESCRIPCION", "COD_PRODUCTO", "PRODUCTOS ", (String) vmp.textDesc.getText());
					bdd.introducirCeldaS(cod_prod, "TIPO", "COD_PRODUCTO", "PRODUCTOS ", (String) vmp.textTipo.getText());
					DefaultTableModel tablamodelo = (DefaultTableModel) vd.tableProd.getModel();
					tablamodelo.setValueAt(cod_prod, fila, 0);
					tablamodelo.setValueAt(vmp.textDesc.getText(), fila, 1);
					tablamodelo.setValueAt(vmp.textTipo.getText(), fila, 2);
					tablamodelo.setValueAt(precio, fila, 3);
					vd.setEnabled(true);
					vmp.dispose();
				} catch (NumberFormatException ne) {
					JOptionPane.showMessageDialog(vmp, "El formato del precio no es correcto");
				}
			}
		} else if (obj == vmp.btnCancelar) {
			//vd.setEnabled(true);
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
