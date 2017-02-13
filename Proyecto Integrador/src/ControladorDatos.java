
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ControladorDatos implements ActionListener, MouseListener, WindowListener {
	VistaDatos vDatos = null;
	OracleAcces bdd = null;
	int cod_Productos;
	static int cod_Proveedores;
	static int cod_Clientes;
	static int cod_Agente;
	static int cod_Interprete;
	static int cod_transportenac;
	static int cod_transporteinter;
	ArrayList<Productos> productos = new ArrayList<Productos>();
	ArrayList<Proveedores> proveedores = new ArrayList<Proveedores>();
	ArrayList<Clientes> clientes = new ArrayList<Clientes>();
	ArrayList<Interprete> interprete = new ArrayList<Interprete>();
	ArrayList<AgenteAduanas> agente = new ArrayList<AgenteAduanas>();
	ArrayList<TransporteNacional> transporteNac = new ArrayList<TransporteNacional>();
	ArrayList<TransporteInternacional> transporteInter = new ArrayList<TransporteInternacional>();

	public ControladorDatos(VistaDatos vDatos, OracleAcces bdd) {
		super();
		this.vDatos = vDatos;
		this.bdd = bdd;
	}

	// metodo para incrementar el codigo del producto
	/*
	 * public static void incrementarCodprod() { cod_Productos++; }
	 */

	// metodo para incrementar el codigo del proveedor
	public static void incrementarCodprov() {
		cod_Proveedores++;
	}

	// metodo para incrementar el codigo del cliente
	public static void incrementarCodcli() {
		cod_Clientes++;
	}

	// metodo para incrementar el codigo del agente
	public static void incrementarCodagen() {
		cod_Agente++;
	}

	// metodo para incrementar el codigo del agente
	public static void incrementarCodInter() {
		cod_Interprete++;
	}

	// metodo para incrementar el codigo del transporte nacional
	public static void incrementarCodtransnac() {
		cod_transportenac++;
	}

	// metodo para incrementar el codigo del transporte internacional
	public static void incrementarCodtransinter() {
		cod_transporteinter++;
	}

	// Metodo para rellenar la tabla de productos
	public void rellenarTablaProdutos() {
		// TODO Auto-generated method stub
		cod_Productos = bdd.leerTablaProductos(productos) + 1;
		DefaultTableModel tablamodelo = (DefaultTableModel) vDatos.tableProd.getModel();

		for (Productos p : productos) {
			tablamodelo.addRow(new Object[] { p.getCod_producto(), p.getDescripcion(), p.getTipo(), p.getPrecio() });
		}
		vDatos.tableProd.setRowSorter(new TableRowSorter<TableModel>(tablamodelo));
	}

	// Metodo para rellenar la tabla de proveedores
	public void rellenarTablaProveedores() {
		// TODO Auto-generated method stub
		cod_Proveedores = bdd.leerTablaProveedores(proveedores) + 1;
		DefaultTableModel tablamodelo = (DefaultTableModel) vDatos.tableProv.getModel();
		for (Proveedores p : proveedores) {
			tablamodelo.addRow(new Object[] { p.getCod_proveedor(), p.getNombre(), p.getTelefono(), p.getUbicacion(),
					p.getNif(), p.getCod_cuenta(), p.getPerscontacto() });
		}
		vDatos.tableProv.setRowSorter(new TableRowSorter<TableModel>(tablamodelo));
	}

	// Metodo para rellenar la tabla de Clientes
	public void rellenarTablaClientes() {
		// TODO Auto-generated method stub
		cod_Clientes = bdd.leerTablaClientes(clientes) + 1;
		DefaultTableModel tablamodelo = (DefaultTableModel) vDatos.tableCli.getModel();
		for (Clientes c : clientes) {
			tablamodelo.addRow(new Object[] { c.getCod_cliente(), c.getDni(), c.getNombre(), c.getApellidos(),
					c.getTelefono(), c.getCorreo(), c.getUbicacion(), c.getDatos_bancarios() });
		}
		vDatos.tableCli.setRowSorter(new TableRowSorter<TableModel>(tablamodelo));
	}

	// Metodo para rellenar la tabla de Agentes
	public void rellenarTablaAgente() {
		// TODO Auto-generated method stub
		cod_Agente = bdd.leerTablaAgente(agente) + 1;
		DefaultTableModel tablamodelo = (DefaultTableModel) vDatos.tableAgen.getModel();

		for (AgenteAduanas a : agente) {
			tablamodelo.addRow(new Object[] { a.getCod_agente(), a.getNombre(), a.getApellidos(), a.getSede(),
					a.getDni(), a.getDatosbancarios() });
		}
		vDatos.tableAgen.setRowSorter(new TableRowSorter<TableModel>(tablamodelo));
	}

	// Metodo para rellenar la tabla de Interpretes
	public void rellenarTablaInterprete() {
		// TODO Auto-generated method stub
		cod_Interprete = bdd.leerTablaInterprete(interprete) + 1;
		DefaultTableModel tablamodelo = (DefaultTableModel) vDatos.tableInter.getModel();

		for (Interprete i : interprete) {
			tablamodelo.addRow(new Object[] { i.getCod_interprete(), i.getDni(), i.getNombre(), i.getApellidos(),
					i.getTelefono(), i.getDireccion() });
		}
		vDatos.tableInter.setRowSorter(new TableRowSorter<TableModel>(tablamodelo));
	}

	// Metodo para rellenar la tabla de transporte nacional
	public void rellenarTranportenac() {
		// TODO Auto-generated method stub
		cod_transportenac = bdd.leerTablaTRansportenac(transporteNac) + 1;
		DefaultTableModel tablamodelo = (DefaultTableModel) vDatos.tableTransnac.getModel();

		for (TransporteNacional t : transporteNac) {
			tablamodelo.addRow(
					new Object[] { t.getCod_trasporte(), t.getNombre(), t.getDireccion(), t.getDatosbancarios() });
		}
		vDatos.tableTransnac.setRowSorter(new TableRowSorter<TableModel>(tablamodelo));
	}

	// Metodo para rellenar la tabla de transporte internacional
	public void rellenarTranporteinter() {
		// TODO Auto-generated method stub
		cod_transporteinter = bdd.leerTablaTRansporteinter(transporteInter) + 1;
		DefaultTableModel tablamodelo = (DefaultTableModel) vDatos.tableTransinter.getModel();

		for (TransporteInternacional t : transporteInter) {
			String inter = bdd.consultar(t.getInterprete(), "NOMBRE ||' '|| APELLIDOS", "COD_INTERPRETE", "INTERPRETE");
			tablamodelo.addRow(new Object[] { t.getCod_transporte(), t.getNombre(), t.getDireccion(),
					t.getDatos_bancarios(), inter });
		}
		vDatos.tableTransinter.setRowSorter(new TableRowSorter<TableModel>(tablamodelo));
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		// aciones de los botones de productos
		if (obj == vDatos.btnanadirProd) {
			VistaAnadirProducto vap = new VistaAnadirProducto();
			ControladorAnadirProducto cap = new ControladorAnadirProducto(vDatos, vap, bdd, productos, cod_Productos);
			vap.setControlador(cap);
			vap.setVisible(true);
			cap.inicializar();
			vDatos.setEnabled(false);
			vDatos.tableProd.clearSelection();
			vDatos.btnBorrarProd.setVisible(false);
			vDatos.btnModificarProd.setVisible(false);
		} else if (obj == vDatos.btnBorrarProd) {
			if (JOptionPane.showConfirmDialog(null, "Esta seguro de que desea borrar esta compra?", "Atención",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				DefaultTableModel tablamodelo = (DefaultTableModel) vDatos.tableProd.getModel();
				int fila = vDatos.tableProd.convertRowIndexToModel(vDatos.tableProd.getSelectedRow());
				bdd.borrarFila((Integer) vDatos.tableProd.getValueAt(fila, 0), "COD_PRODUCTO", "PRODUCTOS");
				tablamodelo.removeRow(fila);
				productos.remove(fila);
			}

			vDatos.tableProd.clearSelection();
			vDatos.btnBorrarProd.setVisible(false);
			vDatos.btnModificarProd.setVisible(false);
		} else if (obj == vDatos.btnModificarProd) {
			VistaModificarProducto vmp = new VistaModificarProducto();
			int fila = vDatos.tableProd.getSelectedRow();
			float coste = (Float) vDatos.tableProd.getValueAt(fila, 3);
			String nom = (String) vDatos.tableProd.getValueAt(fila, 1);
			String tip = (String) vDatos.tableProd.getValueAt(fila, 2);
			ControladorModificarProducto cmp = new ControladorModificarProducto(vDatos, vmp, bdd, productos,
					(Integer) vDatos.tableProd.getValueAt(fila, 0), vDatos.tableProd.convertRowIndexToModel(fila), coste, nom, tip);
			vmp.setControlador(cmp);
			vmp.setVisible(true);
			cmp.inicializar();
			vDatos.setEnabled(false);
			vDatos.tableProd.clearSelection();
			vDatos.btnBorrarProd.setVisible(false);
			vDatos.btnModificarProd.setVisible(false);
		}

		// aciones de los botones de Proveedores

		else if (obj == vDatos.btnanadirProv) {
			VistaAnadirProveedor vap = new VistaAnadirProveedor();
			ControladorAnadirProveedor cap = new ControladorAnadirProveedor(vDatos, vap, bdd, proveedores,
					cod_Proveedores);
			vap.setControlador(cap);
			vap.setVisible(true);
			cap.inicializar();
			vDatos.setEnabled(false);
			vDatos.tableProv.clearSelection();
			vDatos.btnBorrarProv.setVisible(false);
			vDatos.btnModificarProv.setVisible(false);
		} else if (obj == vDatos.btnBorrarProv) {
			if (JOptionPane.showConfirmDialog(null, "Esta seguro de que desea borrar esta compra?", "Atención",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				DefaultTableModel tablamodelo = (DefaultTableModel) vDatos.tableProv.getModel();
				int fila = vDatos.tableProv.convertRowIndexToModel(vDatos.tableProv.getSelectedRow());
				bdd.borrarFila((Integer) vDatos.tableProv.getValueAt(fila, 0), "COD_PROVEEDOR", "PROVEEDORES");
				tablamodelo.removeRow(fila);
				proveedores.remove(fila);
			}

			vDatos.tableProv.clearSelection();
			vDatos.btnBorrarProv.setVisible(false);
			vDatos.btnModificarProv.setVisible(false);
		} else if (obj == vDatos.btnModificarProv) {
			VistaModificarProveedor vmp = new VistaModificarProveedor();
			int fila = vDatos.tableProv.getSelectedRow();
			int cod = (Integer) vDatos.tableProv.getValueAt(fila, 0);
			Proveedores prov = new Proveedores(cod, (String) vDatos.tableProv.getValueAt(fila, 1),
					(Integer) vDatos.tableProv.getValueAt(fila, 2), (String) vDatos.tableProv.getValueAt(fila, 3),
					(String) vDatos.tableProv.getValueAt(fila, 4), (String) vDatos.tableProv.getValueAt(fila, 5),
					(String) vDatos.tableProv.getValueAt(fila, 6));

			ControladorModificarProveedor cmc = new ControladorModificarProveedor(vDatos, vmp, bdd, prov, cod, vDatos.tableProv.convertRowIndexToModel(fila));
			vmp.setControlador(cmc);
			vmp.setVisible(true);
			cmc.inicializar();
			vDatos.setEnabled(false);
			vDatos.tableCli.clearSelection();
			vDatos.btnBorrarCli.setVisible(false);
			vDatos.btnModificarCli.setVisible(false);
		}

		// aciones de los botones de clientes

		else if (obj == vDatos.btnanadirCli) {
			VistaAnadirCliente vac = new VistaAnadirCliente();
			ControladorAnadirCliente cac = new ControladorAnadirCliente(vDatos, vac, bdd, clientes, cod_Clientes);
			vac.setControlador(cac);
			vac.setVisible(true);
			cac.inicializar();
			vDatos.setEnabled(false);
			vDatos.tableCli.clearSelection();
			vDatos.btnBorrarCli.setVisible(false);
			vDatos.btnModificarCli.setVisible(false);
		} else if (obj == vDatos.btnBorrarCli) {
			if (JOptionPane.showConfirmDialog(null, "Esta seguro de que desea borrar esta compra?", "Atención",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				DefaultTableModel tablamodelo = (DefaultTableModel) vDatos.tableCli.getModel();
				int fila = vDatos.tableCli.convertRowIndexToModel(vDatos.tableCli.getSelectedRow());
				bdd.borrarFila((Integer) vDatos.tableCli.getValueAt(fila, 0), "COD_CLIENTE", "CLIENTE");
				tablamodelo.removeRow(fila);
				clientes.remove(fila);
			}

			vDatos.tableCli.clearSelection();
			vDatos.btnBorrarCli.setVisible(false);
			vDatos.btnModificarCli.setVisible(false);
		} else if (obj == vDatos.btnModificarCli) {
			VistaModificarCliente vmc = new VistaModificarCliente();
			int fila = vDatos.tableCli.getSelectedRow();
			int cod = (Integer) vDatos.tableCli.getValueAt(fila, 0);
			Clientes cli = new Clientes(cod, (String) vDatos.tableCli.getValueAt(fila, 6),
					(String) vDatos.tableCli.getValueAt(fila, 5), (String) vDatos.tableCli.getValueAt(fila, 7),
					(String) vDatos.tableCli.getValueAt(fila, 2), (String) vDatos.tableCli.getValueAt(fila, 3),
					(Integer) vDatos.tableCli.getValueAt(fila, 4), (String) vDatos.tableCli.getValueAt(fila, 1));

			ControladorModificarCliente cmc = new ControladorModificarCliente(vDatos, vmc, bdd, cli, clientes, cod,
					vDatos.tableCli.convertRowIndexToModel(fila));
			vmc.setControlador(cmc);
			vmc.setVisible(true);
			cmc.inicializar();
			vDatos.setEnabled(false);
			vDatos.tableCli.clearSelection();
			vDatos.btnBorrarCli.setVisible(false);
			vDatos.btnModificarCli.setVisible(false);
		}

		// aciones de los botones de Agentes

		else if (obj == vDatos.btnanadirAgen) {
			VistaAnadirAgente vaa = new VistaAnadirAgente();
			ControladorAnadirAgente caa = new ControladorAnadirAgente(vDatos, vaa, bdd, agente, cod_Agente);
			vaa.setControlador(caa);
			vaa.setVisible(true);
			caa.inicializar();
			vDatos.setEnabled(false);
			vDatos.tableAgen.clearSelection();
			vDatos.btnBorrarAgen.setVisible(false);
			vDatos.btnModificarAgen.setVisible(false);
		} else if (obj == vDatos.btnBorrarAgen) {
			if (JOptionPane.showConfirmDialog(null, "Esta seguro de que desea borrar esta compra?", "Atención",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				DefaultTableModel tablamodelo = (DefaultTableModel) vDatos.tableAgen.getModel();
				int fila = vDatos.tableAgen.convertRowIndexToModel(vDatos.tableAgen.getSelectedRow());
				bdd.borrarFila((Integer) vDatos.tableAgen.getValueAt(fila, 0), "COD_AGENTE", "AGENTEADUANAS");
				tablamodelo.removeRow(fila);
				agente.remove(fila);
			}

			vDatos.tableAgen.clearSelection();
			vDatos.btnBorrarAgen.setVisible(false);
			vDatos.btnModificarAgen.setVisible(false);

		} else if (obj == vDatos.btnModificarAgen) {
			VistaModificarAgente vma = new VistaModificarAgente();
			int fila = vDatos.tableAgen.getSelectedRow();
			int cod = (Integer) vDatos.tableAgen.getValueAt(fila, 0);
			AgenteAduanas agen = new AgenteAduanas(cod, (String) vDatos.tableAgen.getValueAt(fila, 1),
					(String) vDatos.tableAgen.getValueAt(fila, 2), (String) vDatos.tableAgen.getValueAt(fila, 3),
					(String) vDatos.tableAgen.getValueAt(fila, 4), (String) vDatos.tableAgen.getValueAt(fila, 5));

			ControladorModificarAgente cmi = new ControladorModificarAgente(vDatos, vma, bdd, agen, cod, vDatos.tableAgen.convertRowIndexToModel(fila));
			vma.setControlador(cmi);
			vma.setVisible(true);
			cmi.inicializar();
			vDatos.setEnabled(false);
			vDatos.tableAgen.clearSelection();
			vDatos.btnBorrarAgen.setVisible(false);
			vDatos.btnModificarAgen.setVisible(false);
		}

		// aciones de los botones de interpretes

		else if (obj == vDatos.btnanadirInter) {
			VistaAnadirInterprete vai = new VistaAnadirInterprete();
			ControladorAnadirInterprete cai = new ControladorAnadirInterprete(vDatos, vai, bdd, interprete,
					cod_Interprete);
			vai.setControlador(cai);
			vai.setVisible(true);
			cai.inicializar();
			vDatos.setEnabled(false);
			vDatos.tableInter.clearSelection();
			vDatos.btnBorrarInter.setVisible(false);
			vDatos.btnModificarInter.setVisible(false);
		} else if (obj == vDatos.btnBorrarInter) {
			if (JOptionPane.showConfirmDialog(null, "Esta seguro de que desea borrar esta compra?", "Atención",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				DefaultTableModel tablamodelo = (DefaultTableModel) vDatos.tableInter.getModel();
				int fila = vDatos.tableInter.convertRowIndexToModel(vDatos.tableInter.getSelectedRow());
				bdd.borrarFila((Integer) vDatos.tableInter.getValueAt(fila, 0), "COD_INTERPRETE", "INTERPRETE");
				tablamodelo.removeRow(fila);
				interprete.remove(fila);
			}

			vDatos.tableInter.clearSelection();
			vDatos.btnBorrarInter.setVisible(false);
			vDatos.btnModificarInter.setVisible(false);
		} else if (obj == vDatos.btnModificarInter) {
			VistaModificarInterprete vmi = new VistaModificarInterprete();
			int fila = vDatos.tableInter.getSelectedRow();
			int cod = (Integer) vDatos.tableInter.getValueAt(fila, 0);
			Interprete interp = new Interprete(cod, (String) vDatos.tableInter.getValueAt(fila, 1),
					(String) vDatos.tableInter.getValueAt(fila, 2), (String) vDatos.tableInter.getValueAt(fila, 3),
					(String) vDatos.tableInter.getValueAt(fila, 4), (String) vDatos.tableInter.getValueAt(fila, 5));

			ControladorModificarInterprete cmi = new ControladorModificarInterprete(vDatos, vmi, bdd, interp, cod,
					vDatos.tableInter.convertRowIndexToModel(fila));
			vmi.setControlador(cmi);
			vmi.setVisible(true);
			cmi.inicializar();
			vDatos.setEnabled(false);
			vDatos.tableInter.clearSelection();
			vDatos.btnBorrarInter.setVisible(false);
			vDatos.btnModificarInter.setVisible(false);
		}
		// aciones de los botones de transporte nacional

		else if (obj == vDatos.btnanadirTransnac) {
			VistaAnadirTransportenac vatn = new VistaAnadirTransportenac();
			ControladorAnadirTransportenac catn = new ControladorAnadirTransportenac(vDatos, vatn, bdd, transporteNac,
					cod_transportenac);
			vatn.setControlador(catn);
			vatn.setVisible(true);
			catn.inicializar();
			vDatos.setEnabled(false);
			vDatos.tableTransnac.clearSelection();
			vDatos.btnBorrarTransnac.setVisible(false);
			vDatos.btnModificarTransnac.setVisible(false);
		} else if (obj == vDatos.btnBorrarTransnac) {
			if (JOptionPane.showConfirmDialog(null, "Esta seguro de que desea borrar este transporte nacional?",
					"Atención", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				DefaultTableModel tablamodelo = (DefaultTableModel) vDatos.tableTransnac.getModel();
				int fila = vDatos.tableTransnac.convertRowIndexToModel(vDatos.tableTransnac.getSelectedRow());
				bdd.borrarFila((Integer) vDatos.tableTransnac.getValueAt(fila, 0), "COD_TRANSPORTE_NA",
						"TRANSPORTENACIONAL");
				tablamodelo.removeRow(fila);
				transporteNac.remove(fila);
			}

			vDatos.tableTransnac.clearSelection();
			vDatos.btnBorrarTransnac.setVisible(false);
			vDatos.btnModificarTransnac.setVisible(false);
		} else if (obj == vDatos.btnModificarTransnac) {
			VistaModificarTransportenac vmtn = new VistaModificarTransportenac();
			int fila = vDatos.tableTransnac.getSelectedRow();
			int cod = (Integer) vDatos.tableTransnac.getValueAt(fila, 0);
			TransporteNacional tranna = new TransporteNacional(cod, (String) vDatos.tableTransnac.getValueAt(fila, 3),
					(String) vDatos.tableTransnac.getValueAt(fila, 2),
					(String) vDatos.tableTransnac.getValueAt(fila, 1));

			ControladorModificarTransportenac cmtn = new ControladorModificarTransportenac(vDatos, vmtn, bdd, tranna,
					cod, vDatos.tableTransnac.convertRowIndexToModel(fila));
			vmtn.setControlador(cmtn);
			vmtn.setVisible(true);
			cmtn.inicializar();
			vDatos.setEnabled(false);
			vDatos.tableTransnac.clearSelection();
			vDatos.btnBorrarTransnac.setVisible(false);
			vDatos.btnModificarTransnac.setVisible(false);
		}

		// aciones de los botones de Transporte

		else if (obj == vDatos.btnanadirTransinter) {
			VistaAnadirTransporteinter vati = new VistaAnadirTransporteinter();
			ControladorAnadirTransporteinter cati = new ControladorAnadirTransporteinter(vDatos, vati, bdd,
					transporteInter, cod_transporteinter);
			vati.setControlador(cati);
			vati.setVisible(true);
			cati.inicializar();
			vDatos.setEnabled(false);
			vDatos.tableTransinter.clearSelection();
			vDatos.btnBorrarTransinter.setVisible(false);
			vDatos.btnModificarTransinter.setVisible(false);
			;
		} else if (obj == vDatos.btnBorrarTransinter) {
			if (JOptionPane.showConfirmDialog(null, "Esta seguro de que desea borrar este transporte internacional?",
					"Atención", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				DefaultTableModel tablamodelo = (DefaultTableModel) vDatos.tableTransinter.getModel();
				int fila = vDatos.tableTransinter.convertRowIndexToModel(vDatos.tableTransinter.getSelectedRow());
				bdd.borrarFila((Integer) vDatos.tableTransinter.getValueAt(fila, 0), "COD_TRANSPORTE",
						"TRANSPORTEINTERNACIONAL");
				tablamodelo.removeRow(fila);
				transporteInter.remove(fila);
			}

			vDatos.tableTransinter.clearSelection();
			vDatos.btnBorrarTransinter.setVisible(false);
			vDatos.btnModificarTransinter.setVisible(false);
		} else if (obj == vDatos.btnModificarTransinter) {
			VistaModificarTransporteinter vmti = new VistaModificarTransporteinter();
			int fila = vDatos.tableTransinter.getSelectedRow();
			int cod = (Integer) vDatos.tableTransinter.getValueAt(fila, 0);
			ControladorModificarTransporteinter cmti = new ControladorModificarTransporteinter(vDatos, vmti, bdd, cod,
					(String) vDatos.tableTransinter.getValueAt(fila, 1),
					(String) vDatos.tableTransinter.getValueAt(fila, 2),
					(String) vDatos.tableTransinter.getValueAt(fila, 3),
					(String) vDatos.tableTransinter.getValueAt(fila, 4), vDatos.tableTransinter.convertRowIndexToModel(fila));
			vmti.setControlador(cmti);
			vmti.setVisible(true);
			cmti.inicializar();
			vDatos.setEnabled(false);
			vDatos.tableTransnac.clearSelection();
			vDatos.btnBorrarTransnac.setVisible(false);
			vDatos.btnModificarTransnac.setVisible(false);
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
		Object obj = e.getSource();
		if (obj == vDatos.tableProd) {
			vDatos.btnBorrarProd.setVisible(true);
			vDatos.btnModificarProd.setVisible(true);
		} else if (obj == vDatos.tableProv) {
			vDatos.btnBorrarProv.setVisible(true);
			vDatos.btnModificarProv.setVisible(true);
		} else if (obj == vDatos.tableCli) {
			vDatos.btnBorrarCli.setVisible(true);
			vDatos.btnModificarCli.setVisible(true);
		} else if (obj == vDatos.tableAgen) {
			vDatos.btnBorrarAgen.setVisible(true);
			vDatos.btnModificarAgen.setVisible(true);
		} else if (obj == vDatos.tableInter) {
			vDatos.btnBorrarInter.setVisible(true);
			vDatos.btnModificarInter.setVisible(true);
		} else if (obj == vDatos.tableTransnac) {
			vDatos.btnBorrarTransnac.setVisible(true);
			vDatos.btnModificarTransnac.setVisible(true);
		} else if (obj == vDatos.tableTransinter) {
			vDatos.btnBorrarTransinter.setVisible(true);
			vDatos.btnModificarTransinter.setVisible(true);
		}
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
