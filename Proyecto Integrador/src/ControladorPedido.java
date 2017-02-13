
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

public class ControladorPedido implements ActionListener, MouseListener, WindowListener {
	VistaPedido vPedido = null;
	Pedido c = null;
	OracleAcces bdd = null;
	ArrayList<Pedido> ped = new ArrayList<Pedido>();
	static int cod_pedido;

	public ControladorPedido(VistaPedido vPedido, Pedido c, OracleAcces bdd, ArrayList<Pedido> ped) {
		super();
		this.vPedido = vPedido;
		this.c = c;
		this.bdd = bdd;
		this.ped = ped;
	}

	public void rellenarTabla() {
		// TODO Auto-generated method stub
		cod_pedido = bdd.leerTablaPedido(ped) + 1;
		DefaultTableModel tablamodelo = (DefaultTableModel) vPedido.table.getModel();

		for (Pedido c : ped) {
			String nom = bdd.consultar(c.getCod_transporte(), "NOMBRE", "COD_TRANSPORTE", "TRANSPORTEINTERNACIONAL");
			String nomag = bdd.consultar(c.getCod_agente(), "NOMBRE", "COD_AGENTE", "AGENTEADUANAS");
			tablamodelo.addRow(new Object[] { c.getCod_pedido(), nomag, nom, c.getFecha(), c.getCoste() });
		}
		vPedido.table.setRowSorter(new TableRowSorter<TableModel>(tablamodelo));

	}

	public static void incrementarCodpedido() {
		cod_pedido++;
	}

	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		VistaPrincipal vp = new VistaPrincipal();
		ControladorPrincipal Controlprincipal = new ControladorPrincipal(vp);
		vp.setControlador(Controlprincipal);
		vp.setVisible(true);
	}

	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		vPedido.btnVer.setVisible(true);
		vPedido.btnBorrar.setVisible(true);
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

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == vPedido.btnVer) {
			int fila = vPedido.table.getSelectedRow();
			int codigo = (Integer) vPedido.table.getValueAt(fila, 0);
			VistaLineaPedido vlp = new VistaLineaPedido();
			ControladorLineaPedido clp = new ControladorLineaPedido(vlp, vPedido, bdd, ped, codigo,
					vPedido.table.convertRowIndexToModel(fila));
			vlp.setControlador(clp);
			vlp.setVisible(true);
			clp.inicializar();
			clp.rellenarTabla();
			vPedido.setEnabled(false);
			vPedido.table.clearSelection();
			vPedido.btnBorrar.setVisible(false);
			vPedido.btnVer.setVisible(false);

		} else if (obj == vPedido.btnAnadir) {
			VistaAnadirPedido vac = new VistaAnadirPedido();
			ControladorAnadirPedido cAPedido = new ControladorAnadirPedido(vPedido, vac, c, bdd, ped, cod_pedido);
			vac.setControlador(cAPedido);
			vac.setVisible(true);
			cAPedido.inicializar();
			vPedido.setEnabled(false);
			vPedido.table.clearSelection();
			vPedido.btnBorrar.setVisible(false);
			vPedido.btnVer.setVisible(false);
		} else if (obj == vPedido.btnBorrar) {
			if (JOptionPane.showConfirmDialog(null, "Esta seguro de que desea borrar esta compra?", "Atención",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				DefaultTableModel tablamodelo = (DefaultTableModel) vPedido.table.getModel();
				int fila = vPedido.table.convertRowIndexToModel(vPedido.table.getSelectedRow());
				bdd.borrarFila(ped.get(fila).getCod_pedido(), "COD_PEDIDO", "PEDIDO");
				tablamodelo.removeRow(fila);
				ped.remove(fila);
			}
			vPedido.table.clearSelection();
			vPedido.btnBorrar.setVisible(false);
			vPedido.btnVer.setVisible(false);
		}

	}

}
