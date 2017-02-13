import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import java.util.ArrayList;

public class VistaCompra extends JFrame {

	private JPanel contentPane;
	JTable table;
	JButton btnAnadir;
	JButton btnVer;
	JButton btnBorrar;
	int cod_compra = 0;
	ArrayList<Compra> comp = new ArrayList<Compra>();

	/**
	 * Create the frame.
	 */
	public VistaCompra() {
		
		setTitle("Compra");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 38, 800, 490);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "Cod Compra", "Transporte", "Coste", "Tipo", "Fecha"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Float.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
		DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer(); 
		modelocentrar.setHorizontalAlignment(SwingConstants.CENTER); 
		table.getColumnModel().getColumn(0).setCellRenderer(modelocentrar); 
		table.getColumnModel().getColumn(2).setCellRenderer(modelocentrar); 
		table.getColumnModel().getColumn(4).setCellRenderer(modelocentrar); 
		scrollPane.setViewportView(table);

		btnAnadir = new JButton("A\u00F1adir");

		btnAnadir.setBounds(848, 424, 97, 25);
		contentPane.add(btnAnadir);
		btnVer = new JButton("Ver");
		btnVer.setBounds(848, 464, 97, 25);
		contentPane.add(btnVer);
		btnVer.setVisible(false);
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(848, 502, 97, 25);
		contentPane.add(btnBorrar);
		btnBorrar.setVisible(false);

		
	}

	public void setControlador(ControladorCompra c) {
		btnVer.addActionListener(c);
		btnAnadir.addActionListener(c);
		btnBorrar.addActionListener(c);
		table.addMouseListener(c);
		addWindowListener(c);
	}
}
