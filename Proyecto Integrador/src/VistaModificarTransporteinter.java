import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.border.EmptyBorder;

public class VistaModificarTransporteinter extends JFrame {

	private JPanel contentPane;
	JTextField textCod;
	JTextField textNomb;
	JButton btnModificar;
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
	public VistaModificarTransporteinter() {
		setTitle("Modificar transporte internacional");
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
		textCod.setBounds(103, 26, 177, 22);
		contentPane.add(textCod);
		textCod.setColumns(10);

		textNomb = new JTextField();
		textNomb.setBounds(103, 54, 177, 22);
		contentPane.add(textNomb);
		textNomb.setColumns(10);
		String[] transportes = { "Transati.S.A", "Intraxa.S.L", "Martrans" };
		String[] t = { "online", "Telefono", "Tienda" };

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(308, 89, 97, 25);
		contentPane.add(btnModificar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(308, 131, 97, 25);
		contentPane.add(btnCancelar);

		textDireccion = new JTextField();
		textDireccion.setBounds(103, 84, 177, 22);
		contentPane.add(textDireccion);
		textDireccion.setColumns(10);

		textCuenta = new JTextField();
		textCuenta.setColumns(10);
		textCuenta.setBounds(103, 111, 177, 22);
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
		spinter.setBounds(103, 140, 177, 22);
		contentPane.add(spinter);

	}
	public void setControlador (ControladorModificarTransporteinter c){
		btnModificar.addActionListener(c);
		btnCancelar.addActionListener(c);
		addWindowListener(c);
	}
}
