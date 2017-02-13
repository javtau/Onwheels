
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

public class ControladorLineaCompra implements ActionListener, MouseListener, WindowListener {
	VistaLineaCompra vlc = null;
	VistaCompra vc = null;
	OracleAcces bdd = null;
	ArrayList<LineaCompra> lc = new ArrayList<LineaCompra>();
	ArrayList<Compra> comp = new ArrayList<Compra>();
	int cod_compra;
	static int cod_linea;
	int fila;

	public ControladorLineaCompra(VistaLineaCompra vlc, VistaCompra vc, OracleAcces bdd, ArrayList<Compra> comp,
			int cod_compra, int fila) {
		super();
		this.vlc = vlc;
		this.vc = vc;
		this.bdd = bdd;
		this.comp = comp;
		this.cod_compra = cod_compra;
		this.fila = fila;
	}

	public void rellenarTabla() {

		// TODO Auto-generated method stub
		bdd.leerTablaLineaCompra(lc, cod_compra);
		DefaultTableModel tablamodelo = (DefaultTableModel) vlc.table.getModel();

		for (LineaCompra c : lc) {
			String nom = bdd.consultar(c.getCod_producto(), "DESCRIPCION", "COD_PRODUCTO", "PRODUCTOS");
			tablamodelo
					.addRow(new Object[] { c.getCod_linea(), nom, c.getCantidad(), c.getCoste(), c.getFecha_envio() });
		}
		vlc.table.setRowSorter(new TableRowSorter<TableModel>(tablamodelo));

	}

	public void inicializar() {
		cod_linea = bdd.CogerCodigo("COD_LINEA", "LINEACOMPRA") + 1;
		vlc.setTitle("Lineas de compra " + cod_compra);
	}

	public static void incrementarCodlinea() {
		cod_linea++;

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vlc.btnModificar) {

			VistaModificarLineaCompra vmlc = new VistaModificarLineaCompra();
			int fila = vlc.table.getSelectedRow();
			int c_p = (Integer) vlc.table.getValueAt(fila, 0);
			int cant = (Integer) vlc.table.getValueAt(fila, 2);
			ControladorModificarLineaCompra controlmlc = new ControladorModificarLineaCompra(vlc, vmlc, bdd, lc,
					cod_compra, c_p, (String) vlc.table.getValueAt(fila, 1), cant,
					vlc.table.convertRowIndexToModel(fila), (String) vlc.table.getValueAt(fila, 4));
			vmlc.setControlador(controlmlc);
			vmlc.setVisible(true);
			controlmlc.inicializar();
			vlc.table.clearSelection();
			vlc.btnBorrar.setVisible(false);
			vlc.btnModificar.setVisible(false);

		} else if (obj == vlc.btnAnadir) {
			VistaAnadirLineaCompra valc = new VistaAnadirLineaCompra();
			ControladorAnadirLineaCompra controlalc = new ControladorAnadirLineaCompra(vlc, valc, bdd, lc, cod_compra,
					cod_linea);
			valc.setControlador(controlalc);
			valc.setVisible(true);
			controlalc.inicializar();
			vlc.setEnabled(false);
			vlc.table.clearSelection();
			vlc.btnBorrar.setVisible(false);
			vlc.btnModificar.setVisible(false);
		} else if (obj == vlc.btnBorrar) {
			if (JOptionPane.showConfirmDialog(null, "Esta seguro de que desea borrar esta compra?", "Atención",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				DefaultTableModel tablamodelo = (DefaultTableModel) vlc.table.getModel();
				int fila = vlc.table.convertRowIndexToModel(vlc.table.getSelectedRow());
				bdd.borrarFila(lc.get(fila).getCod_linea(), "COD_LINEA", "LINEACOMPRA");
				tablamodelo.removeRow(fila);
				lc.remove(fila);
			}
			vlc.table.clearSelection();
			vlc.btnBorrar.setVisible(false);
			vlc.btnModificar.setVisible(false);
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
		float coste = bdd.sumarColumna(cod_compra, "COSTE", "COD_COMPRA", "LINEACOMPRA");
		bdd.introducirCelda(cod_compra, "COSTE", "COD_COMPRA", "COMPRA ", coste);
		comp.get(fila).setCoste(coste);
		DefaultTableModel tablamodelo = (DefaultTableModel) vc.table.getModel();
		tablamodelo.setValueAt(coste, fila, 2);
		vc.setEnabled(true);

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
		vlc.btnBorrar.setVisible(true);
		vlc.btnModificar.setVisible(true);
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
