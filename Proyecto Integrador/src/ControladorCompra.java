
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ControladorCompra implements ActionListener, MouseListener, WindowListener {
	VistaCompra vCompra = null;
	Compra c = null;
	OracleAcces bdd = null;
	ArrayList<Compra> comp = new ArrayList<Compra>();
	static int cod_compra;

	public ControladorCompra(VistaCompra vCompra, Compra c, OracleAcces bdd, ArrayList<Compra> comp) {
		super();
		this.vCompra = vCompra;
		this.c = c;
		this.bdd = bdd;
		this.comp = comp;
	}

	public void rellenarTabla() {
		// TODO Auto-generated method stub
		cod_compra = bdd.leerTablaCompra(comp) + 1;
		DefaultTableModel tablamodelo = (DefaultTableModel) vCompra.table.getModel();

		for (Compra c : comp) {
			String nom = bdd.consultar(c.getCod_transporte(), "NOMBRE", "COD_TRANSPORTE_NA", "TRANSPORTENACIONAL");
			tablamodelo.addRow(new Object[] { c.getCod_compra(), nom, c.getCoste(), c.getTipo(), c.getFecha() });
		}
		vCompra.table.setRowSorter(new TableRowSorter<TableModel>(tablamodelo));
	}

	public static void incrementarCodcompra() {
		cod_compra++;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vCompra.btnVer) {
			int fila = vCompra.table.getSelectedRow();
			int codigo = (Integer) vCompra.table.getValueAt(vCompra.table.getSelectedRow(), 0);
			VistaLineaCompra vlc = new VistaLineaCompra();
			ControladorLineaCompra clc = new ControladorLineaCompra(vlc, vCompra, bdd, comp, codigo,
					vCompra.table.convertRowIndexToModel(fila));
			vlc.setVisible(true);
			vlc.setControlador(clc);
			clc.inicializar();
			clc.rellenarTabla();
			vCompra.setEnabled(false);
			vCompra.table.clearSelection();
			vCompra.btnBorrar.setVisible(false);
			vCompra.btnVer.setVisible(false);

		} else if (obj == vCompra.btnAnadir) {
			VistaAnadirCompra vac = new VistaAnadirCompra();
			ControladorAnadirCompra cACompra = new ControladorAnadirCompra(vCompra, vac, c, bdd, comp, cod_compra);
			vac.setControlador(cACompra);
			vac.setVisible(true);
			cACompra.inicializar();
			vCompra.setEnabled(false);
			vCompra.table.clearSelection();
			vCompra.btnBorrar.setVisible(false);
			vCompra.btnVer.setVisible(false);
		} else if (obj == vCompra.btnBorrar) {
			if (JOptionPane.showConfirmDialog(null, "Esta seguro de que desea borrar esta compra?", "Atención",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				DefaultTableModel tablamodelo = (DefaultTableModel) vCompra.table.getModel();
				int fila = vCompra.table.convertRowIndexToModel(vCompra.table.getSelectedRow());
				bdd.borrarFila(comp.get(fila).getCod_compra(), "COD_COMPRA", "COMPRA");
				tablamodelo.removeRow(fila);
				comp.remove(fila);
			}
			vCompra.table.clearSelection();
			vCompra.btnBorrar.setVisible(false);
			vCompra.btnVer.setVisible(false);
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
		VistaPrincipal vp = new VistaPrincipal();
		ControladorPrincipal Controlprincipal = new ControladorPrincipal(vp);
		vp.setControlador(Controlprincipal);
		vp.setVisible(true);

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

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		vCompra.btnBorrar.setVisible(true);
		vCompra.btnVer.setVisible(true);
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
