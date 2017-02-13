import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaDatos extends JFrame {

	private JPanel contentPane;
	JTabbedPane tpPesta�as;

	// elementos producto
	JTable tableProd;
	JButton btnBorrarProd;
	JButton btnModificarProd;
	JButton btnanadirProd;

	// elementos proveedor
	JTable tableProv;
	JButton btnBorrarProv;
	JButton btnModificarProv;
	JButton btnanadirProv;

	// elementos Cliente
	JTable tableCli;
	JButton btnBorrarCli;
	JButton btnModificarCli;
	JButton btnanadirCli;

	// elementos Agente
	JTable tableAgen;
	JButton btnBorrarAgen;
	JButton btnModificarAgen;
	JButton btnanadirAgen;

	// elementos Interprete
	JTable tableInter;
	JButton btnBorrarInter;
	JButton btnModificarInter;
	JButton btnanadirInter;

	// elementos Tranporte nacional
	JTable tableTransnac;
	JButton btnBorrarTransnac;
	JButton btnModificarTransnac;
	JButton btnanadirTransnac;

	// elementos Transinte internacional
	JTable tableTransinter;
	JButton btnBorrarTransinter;
	JButton btnModificarTransinter;
	JButton btnanadirTransinter;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public VistaDatos() {
		
		
		setTitle("Gestion de tablas");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tpPesta�as = new JTabbedPane(JTabbedPane.TOP);
		tpPesta�as.setBackground(Color.WHITE);
		
		tpPesta�as.setBounds(0, 0, 1000, 553);
		contentPane.add(tpPesta�as);

		// panel productos///

		JPanel pnlProductos = new JPanel();
		pnlProductos.setBackground(new Color(204, 204, 255));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 770, 510);
		pnlProductos.add(scrollPane);

		tableProd = new JTable();
		tableProd.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Codigo", "Descripci�n", "Tipo", "Precio" }){
					Class[] columnTypes = new Class[] {
							Integer.class, Object.class, Object.class , Float.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
		tableProd.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableProd.getColumnModel().getColumn(3).setPreferredWidth(20);
		DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer(); 
		modelocentrar.setHorizontalAlignment(SwingConstants.CENTER); 
		tableProd.getColumnModel().getColumn(0).setCellRenderer(modelocentrar); 
		tableProd.getColumnModel().getColumn(3).setCellRenderer(modelocentrar); 
		scrollPane.setViewportView(tableProd);

		btnBorrarProd = new JButton("Borrar");
		btnBorrarProd.setBounds(841, 485, 97, 25);
		pnlProductos.add(btnBorrarProd);

		btnModificarProd = new JButton("Modificar");
		btnModificarProd.setBounds(841, 447, 97, 25);
		pnlProductos.add(btnModificarProd);

		btnanadirProd = new JButton("A\u00F1adir");
		btnanadirProd.setBounds(841, 407, 97, 25);
		pnlProductos.add(btnanadirProd);

		tpPesta�as.addTab("Productos", null, pnlProductos, "Productos");
		pnlProductos.setLayout(null);
		btnBorrarProd.setVisible(false);
		btnModificarProd.setVisible(false);
		
		
		// panel proveedores///

		JPanel pnlProveedores = new JPanel();
		pnlProveedores.setBackground(new Color(204, 204, 255));

		JScrollPane scrollPaneProv = new JScrollPane();
		scrollPaneProv.setBounds(0, 0, 770, 510);
		pnlProveedores.add(scrollPaneProv);

		tableProv = new JTable();
		tableProv.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Codigo", "Nombre", "Telefono", "Ubicaci�n", "NIF", "Cod cuenta", "Contacto" }){
			Class[] columnTypes = new Class[] {
					Integer.class, Object.class, Integer.class, Object.class, Object.class, Object.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		tableProv.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableProv.getColumnModel().getColumn(0).setCellRenderer(modelocentrar); 
		tableProv.getColumnModel().getColumn(2).setCellRenderer(modelocentrar); 
		scrollPaneProv.setViewportView(tableProv);

		btnBorrarProv = new JButton("Borrar");
		btnBorrarProv.setBounds(841, 485, 97, 25);
		pnlProveedores.add(btnBorrarProv);

		btnModificarProv = new JButton("Modificar");
		btnModificarProv.setBounds(841, 447, 97, 25);
		pnlProveedores.add(btnModificarProv);

		btnanadirProv = new JButton("A\u00F1adir");
		btnanadirProv.setBounds(841, 407, 97, 25);
		pnlProveedores.add(btnanadirProv);

		tpPesta�as.addTab("Proveedores", null, pnlProveedores, "Proveedores");
		pnlProveedores.setLayout(null);
		
		btnBorrarProv.setVisible(false);
		btnModificarProv.setVisible(false);
		

		// panel Clientes///

		JPanel pnlClientes = new JPanel();
		pnlClientes.setBackground(new Color(204, 204, 255));

		JScrollPane scrollPaneCli = new JScrollPane();
		scrollPaneCli.setBounds(0, 0, 770, 510);
		pnlClientes.add(scrollPaneCli);

		tableCli = new JTable();
		tableCli.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Codigo", "DNI", "Nombre", "Apellidos", "Telefono" , "Correo", "Ubicaci�n", "Cod cuenta"}){
			Class[] columnTypes = new Class[] {
					Integer.class, Object.class, Object.class, Object.class, Integer.class, Object.class, Object.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		tableCli.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableCli.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
		tableCli.getColumnModel().getColumn(4).setCellRenderer(modelocentrar);
		scrollPaneCli.setViewportView(tableCli);

		btnBorrarCli = new JButton("Borrar");
		btnBorrarCli.setBounds(841, 485, 97, 25);
		pnlClientes.add(btnBorrarCli);

		btnModificarCli = new JButton("Modificar");
		btnModificarCli.setBounds(841, 447, 97, 25);
		pnlClientes.add(btnModificarCli);

		btnanadirCli = new JButton("A\u00F1adir");
		btnanadirCli.setBounds(841, 407, 97, 25);
		pnlClientes.add(btnanadirCli);

		tpPesta�as.addTab("Clientes", null, pnlClientes, "Clientes");
		pnlClientes.setLayout(null);
		
		btnBorrarCli.setVisible(false);
		btnModificarCli.setVisible(false);
		
		
		// panel Agentes///

				JPanel plnAgentes = new JPanel();
				plnAgentes.setBackground(new Color(204, 204, 255));

				JScrollPane scrollPaneAgen = new JScrollPane();
				scrollPaneAgen.setBounds(0, 0, 770, 510);
				plnAgentes.add(scrollPaneAgen);

				tableAgen = new JTable();
				tableAgen.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Codigo", "Nombre", "Apellidos", "Sede", "DNI", "Cod cuenta" }){
					Class[] columnTypes = new Class[] {
							Integer.class, Object.class, Object.class, Object.class,Object.class, Object.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
				tableAgen.getColumnModel().getColumn(0).setPreferredWidth(20);
				tableAgen.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
				tableAgen.getColumnModel().getColumn(4).setCellRenderer(modelocentrar);
				scrollPaneAgen.setViewportView(tableAgen);
				btnBorrarAgen = new JButton("Borrar");
				btnBorrarAgen.setBounds(841, 485, 97, 25);
				plnAgentes.add(btnBorrarAgen);

				btnModificarAgen = new JButton("Modificar");
				btnModificarAgen.setBounds(841, 447, 97, 25);
				plnAgentes.add(btnModificarAgen);

				btnanadirAgen = new JButton("A\u00F1adir");
				btnanadirAgen.setBounds(841, 407, 97, 25);
				plnAgentes.add(btnanadirAgen);

				tpPesta�as.addTab("Agenentes", null, plnAgentes, "Agentes");
				plnAgentes.setLayout(null);
				
				btnBorrarAgen.setVisible(false);
				btnModificarAgen.setVisible(false);				
				
				// panel Interpretes///

				JPanel plnInterpretes = new JPanel();
				plnInterpretes.setBackground(new Color(204, 204, 255));

				JScrollPane scrollPaneInter = new JScrollPane();
				scrollPaneInter.setBounds(0, 0, 770, 510);
				plnInterpretes.add(scrollPaneInter);

				tableInter = new JTable();
				tableInter.setModel(new DefaultTableModel(new Object[][] {},
						new String[] { "Codigo", "DNI", "Nombre", "Apellidos", "Telefono", "Direcci�n" }){
					Class[] columnTypes = new Class[] {
							Integer.class, Object.class, Object.class, Object.class,Object.class, Object.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
				tableInter.getColumnModel().getColumn(0).setPreferredWidth(20);
				tableInter.getColumnModel().getColumn(1).setPreferredWidth(20);
				tableInter.getColumnModel().getColumn(4).setPreferredWidth(20);
				tableInter.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
				tableInter.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);
				tableInter.getColumnModel().getColumn(4).setCellRenderer(modelocentrar);
				
				scrollPaneInter.setViewportView(tableInter);

				btnBorrarInter = new JButton("Borrar");
				btnBorrarInter.setBounds(841, 485, 97, 25);
				plnInterpretes.add(btnBorrarInter);

				btnModificarInter = new JButton("Modificar");
				btnModificarInter.setBounds(841, 447, 97, 25);
				plnInterpretes.add(btnModificarInter);

				btnanadirInter = new JButton("A\u00F1adir");
				btnanadirInter.setBounds(841, 407, 97, 25);
				plnInterpretes.add(btnanadirInter);

				tpPesta�as.addTab("Interpretes", null, plnInterpretes, "Interpretes");
				plnInterpretes.setLayout(null);
				
				btnBorrarInter.setVisible(false);
				btnModificarInter.setVisible(false);				
				
				// panel Transporte nacional///

				JPanel plnTransnac = new JPanel();
				plnTransnac.setBackground(new Color(204, 204, 255));

				JScrollPane scrollPaneTransnac = new JScrollPane();
				scrollPaneTransnac.setBounds(0, 0, 770, 510);
				plnTransnac.add(scrollPaneTransnac);

				tableTransnac = new JTable();
				tableTransnac.setModel(new DefaultTableModel(new Object[][] {},
						new String[] { "Codigo", "Nombre", "Direcci�n", "Datos bancarios" }){
					Class[] columnTypes = new Class[] {
							Integer.class, Object.class, Object.class, Object.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
				tableTransnac.getColumnModel().getColumn(0).setPreferredWidth(20);
				tableTransnac.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
				scrollPaneTransnac.setViewportView(tableTransnac);

				btnBorrarTransnac = new JButton("Borrar");
				btnBorrarTransnac.setBounds(841, 485, 97, 25);
				plnTransnac.add(btnBorrarTransnac);

				btnModificarTransnac = new JButton("Modificar");
				btnModificarTransnac.setBounds(841, 447, 97, 25);
				plnTransnac.add(btnModificarTransnac);

				btnanadirTransnac = new JButton("A\u00F1adir");
				btnanadirTransnac.setBounds(841, 407, 97, 25);
				plnTransnac.add(btnanadirTransnac);

				tpPesta�as.addTab("Transporte nacional", null, plnTransnac, "Transporte nacional");
				plnTransnac.setLayout(null);
				
				btnBorrarTransnac.setVisible(false);
				btnModificarTransnac.setVisible(false);
				
				
				// panel Transporte internacional///

				JPanel plnTransinter = new JPanel();
				plnTransinter.setBackground(new Color(204, 204, 255));

				JScrollPane scrollPaneTransinter = new JScrollPane();
				scrollPaneTransinter.setBounds(0, 0, 770, 510);
				plnTransinter.add(scrollPaneTransinter);

				tableTransinter = new JTable();
				tableTransinter.setModel(new DefaultTableModel(new Object[][] {},
						new String[] { "Codigo", "Nombre", "Direcci�n", "Datos bancarios", "Interprete" }){
					Class[] columnTypes = new Class[] {
							Integer.class, Object.class, Object.class, Object.class,Object.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
				tableTransinter.getColumnModel().getColumn(0).setPreferredWidth(20);
				tableTransinter.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
				scrollPaneTransinter.setViewportView(tableTransinter);

				btnBorrarTransinter = new JButton("Borrar");
				btnBorrarTransinter.setBounds(841, 485, 97, 25);
				plnTransinter.add(btnBorrarTransinter);

				btnModificarTransinter = new JButton("Modificar");
				btnModificarTransinter.setBounds(841, 447, 97, 25);
				plnTransinter.add(btnModificarTransinter);

				btnanadirTransinter = new JButton("A\u00F1adir");
				btnanadirTransinter.setBounds(841, 407, 97, 25);
				plnTransinter.add(btnanadirTransinter);

				tpPesta�as.addTab("Transporte internacional", null, plnTransinter, "Transporte internacional");
				plnTransinter.setLayout(null);
				
				btnBorrarTransinter.setVisible(false);
				btnModificarTransinter.setVisible(false);
				

	}
	
public void setControlador(ControladorDatos c) {
		// LIstener necesarios para la pesta�a de productos
		btnanadirProd.addActionListener(c);
		btnModificarProd.addActionListener(c);
		btnBorrarProd.addActionListener(c);
		tableProd.addMouseListener(c);
		
		// LIstener necesarios para la pesta�a de proveedores
		btnanadirProv.addActionListener(c);
		btnModificarProv.addActionListener(c);
		btnBorrarProv.addActionListener(c);
		tableProv.addMouseListener(c);
		
		// LIstener necesarios para la pesta�a de clientes
		btnanadirCli.addActionListener(c);
		btnModificarCli.addActionListener(c);
		btnBorrarCli.addActionListener(c);
		tableCli.addMouseListener(c);
		
		// LIstener necesarios para la pesta�a  de agentes de aduanas
		btnanadirAgen.addActionListener(c);
		btnModificarAgen.addActionListener(c);
		btnBorrarAgen.addActionListener(c);
		tableAgen.addMouseListener(c);
		
		// LIstener necesarios para la pesta�a de Interpretes
		btnanadirInter.addActionListener(c);
		btnModificarInter.addActionListener(c);
		btnBorrarInter.addActionListener(c);
		tableInter.addMouseListener(c);
		
		// LIstener necesarios para la pesta�a de transportes nacionales
		btnanadirTransnac.addActionListener(c);
		btnModificarTransnac.addActionListener(c);
		btnBorrarTransnac.addActionListener(c);
		tableTransnac.addMouseListener(c);
		
		// LIstener necesarios para la pesta�a de transportes internacionales
		btnanadirTransinter.addActionListener(c);
		btnModificarTransinter.addActionListener(c);
		btnBorrarTransinter.addActionListener(c);
		tableTransinter.addMouseListener(c);
		
		
		addWindowListener(c);
	}
}
