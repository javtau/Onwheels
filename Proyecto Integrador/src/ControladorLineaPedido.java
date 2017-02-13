
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

public class ControladorLineaPedido implements ActionListener, MouseListener, WindowListener {
	VistaLineaPedido vlp = null;
	VistaPedido vp = null;
	OracleAcces bdd = null;
	ArrayList<LineaPedido> lp = new ArrayList<LineaPedido>();
	ArrayList<Pedido> ped = new ArrayList<Pedido>();
	ControladorLineaPedido clp;
	int cod_pedido;
	static int cod_lineapedido;
	int fil;

	public ControladorLineaPedido(VistaLineaPedido vlp, VistaPedido vp, OracleAcces bdd, ArrayList<Pedido> ped,
			int cod_pedido, int fil) {
		super();
		this.vlp = vlp;
		this.vp = vp;
		this.bdd = bdd;
		this.lp = lp;
		this.ped = ped;
		this.cod_pedido = cod_pedido;
		this.fil = fil;

	}

	public void rellenarTabla() {

		// TODO Auto-generated method stub
		bdd.leerTablaLineaPedido(lp, cod_pedido);
		DefaultTableModel tablamodelo = (DefaultTableModel) vlp.table.getModel();
		for (LineaPedido c : lp) {
			String nom = bdd.consultar(c.getCod_producto(), "DESCRIPCION", "COD_PRODUCTO", "PRODUCTOS");
			String prov = bdd.consultar(c.getCod_proveedor(), "NOMBRE", "COD_PROVEEDOR", "PROVEEDORES");
			tablamodelo.addRow(new Object[] { c.getCod_lineapedido(), nom, prov, c.getCantidad(), c.getCoste(),
					c.getFecha_envio() });
		}
		vlp.table.setRowSorter(new TableRowSorter<TableModel>(tablamodelo));

	}

	public void inicializar() {
		cod_lineapedido = bdd.CogerCodigo("COD_LINEAPEDIDO", "LINEAPEDIDO") + 1;
		vlp.setTitle("Lineas del pedido " + cod_pedido);
	}

	public static void incrementarCodlinea() {
		cod_lineapedido++;

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vlp.btnModificar) {

			VistaModificarLineaPedido vp = new VistaModificarLineaPedido();
			int fila = vlp.table.getSelectedRow();
			int c_p = (Integer) vlp.table.getValueAt(fila, 0);
			int cant = (Integer) vlp.table.getValueAt(fila, 3);
			ControladorModificarLineaPedido controlmlc = new ControladorModificarLineaPedido(vlp, vp, bdd, lp,
					cod_pedido, c_p, (String) vlp.table.getValueAt(fila, 1), cant,
					vlp.table.convertRowIndexToModel(fila), (String) vlp.table.getValueAt(fila, 2));
			vp.setControlador(controlmlc);
			vp.setVisible(true);
			// controlmlc.inicializar();
			vlp.table.clearSelection();
			vlp.btnBorrar.setVisible(false);
			vlp.btnModificar.setVisible(false);

		} else if (obj == vlp.btnAnadir) {
			VistaAnadirLineaPedido valp = new VistaAnadirLineaPedido();
			ControladorAnadirLineaPedido controlalp = new ControladorAnadirLineaPedido(vlp, valp, bdd, lp, cod_pedido,
					cod_lineapedido);
			valp.setControlador(controlalp);
			valp.setVisible(true);
			controlalp.inicializar();
			vlp.setEnabled(false);
			vlp.table.clearSelection();
			vlp.btnBorrar.setVisible(false);
			vlp.btnModificar.setVisible(false);
		} else if (obj == vlp.btnBorrar) {
			if (JOptionPane.showConfirmDialog(null, "Esta seguro de que desea borrar este pedido?", "Atención",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				DefaultTableModel tablamodelo = (DefaultTableModel) vlp.table.getModel();
				int fila = vlp.table.convertRowIndexToModel(vlp.table.getSelectedRow());
				bdd.borrarFila(lp.get(fila).getCod_lineapedido(), "COD_LINEAPEDIDO", "LINEAPEDIDO");
				tablamodelo.removeRow(fila);
				lp.remove(fila);
			}
			vlp.table.clearSelection();
			vlp.btnBorrar.setVisible(false);
			vlp.btnModificar.setVisible(false);
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
		if (vlp.table.getRowCount() > 0) {
			float coste = bdd.sumarColumna(cod_pedido, "COSTE", "COD_PEDIDO", "LINEAPEDIDO");
			bdd.introducirCelda(cod_pedido, "COSTE", "COD_PEDIDO", "PEDIDO ", coste);
			ped.get(fil).setCoste(coste);
			DefaultTableModel tablamodelo = (DefaultTableModel) vp.table.getModel();
			tablamodelo.setValueAt(coste, fil, 4);
		}
		vp.setEnabled(true);

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
		vlp.btnBorrar.setVisible(true);
		vlp.btnModificar.setVisible(true);
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
