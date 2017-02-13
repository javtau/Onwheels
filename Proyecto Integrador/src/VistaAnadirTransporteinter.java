import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

public class VistaAnadirTransporteinter extends JFrame {

	private JPanel contentPane;
	JTextField textCod;
	JTextField textNomb;
	JButton btnAnadir;
	JButton btnCancelar;
	JTextField textDireccion;
	JTextField textCuenta;
	JSpinner spinter;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public VistaAnadirTransporteinter() {
		setTitle("Añadir nuevo transporte internacional");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 460, 214);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCodigoDeProveedor = new JLabel("Codigo ");
		lblCodigoDeProveedor.setBounds(12, 26, 129, 16);
		contentPane.add(lblCodigoDeProveedor);

		textCod = new JTextField();
		textCod.setEditable(false);
		textCod.setBounds(103, 23, 177, 22);
		contentPane.add(textCod);
		textCod.setColumns(10);

		textNomb = new JTextField();
		textNomb.setBounds(103, 51, 177, 22);
		contentPane.add(textNomb);
		textNomb.setColumns(10);
		String[] transportes = { "Transati.S.A", "Intraxa.S.L", "Martrans" };
		String[] t = { "online", "Telefono", "Tienda" };

		btnAnadir = new JButton("A\u00F1adir");

		btnAnadir.setBounds(308, 89, 97, 25);
		contentPane.add(btnAnadir);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(308, 131, 97, 25);
		contentPane.add(btnCancelar);

		textDireccion = new JTextField();
		textDireccion.setBounds(103, 81, 177, 22);
		contentPane.add(textDireccion);
		textDireccion.setColumns(10);

		textCuenta = new JTextField();
		textCuenta.setColumns(10);
		textCuenta.setBounds(103, 108, 177, 22);
		contentPane.add(textCuenta);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 55, 56, 16);
		contentPane.add(lblNombre);

		JLabel lblDireccin = new JLabel("Direccion");
		lblDireccin.setBounds(12, 84, 56, 16);
		contentPane.add(lblDireccin);

		JLabel lblCuenta = new JLabel("Cuenta");
		lblCuenta.setBounds(12, 111, 56, 16);
		contentPane.add(lblCuenta);
		
		JLabel lblInterprete = new JLabel("Interprete");
		lblInterprete.setBounds(12, 140, 79, 16);
		contentPane.add(lblInterprete);
		
		spinter = new JSpinner();
		spinter.setModel(new SpinnerListModel(new String[] {"pedro", "juan"}));
		spinter.setBounds(103, 137,177, 22);
		contentPane.add(spinter);

		
	}
	public void setControlador (ControladorAnadirTransporteinter c){
		btnAnadir.addActionListener(c);
		btnCancelar.addActionListener(c);
		addWindowListener(c);
	}
}
