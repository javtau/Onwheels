import java.awt.Color;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

import javax.swing.SpinnerNumberModel;

public class VistaAnadirLineaCompra extends JFrame {

	private JPanel contentPane;
	JTextField textCod;
	JSpinner spProd;
	JDateChooser dcFecha;
	JButton btnAnadir;
	JButton btnCancelar;
	JTextField textCoste;
	JSpinner spCant;

	/**
	 * Create the frame.
	 */
	public VistaAnadirLineaCompra() {
		setTitle("Añadir nueva linea de compra");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 460, 256);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCodigoDeCompra = new JLabel("Codigo de compra");
		lblCodigoDeCompra.setBounds(12, 26, 129, 16);
		contentPane.add(lblCodigoDeCompra);

		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setBounds(12, 55, 88, 16);
		contentPane.add(lblProducto);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(12, 84, 56, 16);
		contentPane.add(lblCantidad);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(12, 142, 56, 16);
		contentPane.add(lblFecha);

		textCod = new JTextField();
		textCod.setEditable(false);
		textCod.setBounds(135, 23, 156, 22);
		contentPane.add(textCod);
		textCod.setColumns(10);

		spProd = new JSpinner();
		
		spProd.setBounds(135, 52, 156, 22);
		contentPane.add(spProd);

		dcFecha = new JDateChooser();
		dcFecha.setBounds(135, 142, 156, 22);
		dcFecha.setCalendar(Calendar.getInstance());
		contentPane.add(dcFecha);

		btnAnadir = new JButton("A\u00F1adir");

		btnAnadir.setBounds(315, 91, 97, 25);
		contentPane.add(btnAnadir);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(315, 133, 97, 25);
		contentPane.add(btnCancelar);

		textCoste = new JTextField();
		textCoste.setEditable(false);
		textCoste.setColumns(10);
		textCoste.setBounds(135, 109, 156, 24);
		contentPane.add(textCoste);

		JLabel lblCoste = new JLabel("Coste");
		lblCoste.setBounds(12, 113, 56, 16);
		contentPane.add(lblCoste);

		spCant = new JSpinner();
		spCant.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spCant.setBounds(135, 81, 156, 22);
		contentPane.add(spCant);

	}

	public void setControlador(ControladorAnadirLineaCompra c) {

		btnAnadir.addActionListener(c);
		btnCancelar.addActionListener(c);
		spProd.addChangeListener(c);
		spCant.addChangeListener(c);
		addWindowListener(c);
	}

}
