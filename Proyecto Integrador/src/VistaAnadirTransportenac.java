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

public class VistaAnadirTransportenac extends JFrame {

	private JPanel contentPane;
	JTextField textCod;
	JTextField textNomb;
	JButton btnAnadir;
	JButton btnCancelar;
	JTextField textDireccion;
	JTextField textCuenta;
	JLabel lblNombre;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VistaAnadirTransportenac() {
		setTitle("Añadir nuevo transporte nacional");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 460, 193);
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
		textCod.setBounds(135, 23, 116, 22);
		contentPane.add(textCod);
		textCod.setColumns(10);

		textNomb = new JTextField();
		textNomb.setBounds(135, 51, 116, 24);
		contentPane.add(textNomb);
		textNomb.setColumns(10);
		String[] transportes = { "Transati.S.A", "Intraxa.S.L", "Martrans" };
		String[] t = { "online", "Telefono", "Tienda" };

		btnAnadir = new JButton("A\u00F1adir");

		btnAnadir.setBounds(307, 63, 97, 25);
		contentPane.add(btnAnadir);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(307, 105, 97, 25);
		contentPane.add(btnCancelar);

		textDireccion = new JTextField();
		textDireccion.setBounds(135, 81, 116, 22);
		contentPane.add(textDireccion);
		textDireccion.setColumns(10);

		textCuenta = new JTextField();
		textCuenta.setColumns(10);
		textCuenta.setBounds(135, 108, 116, 22);
		contentPane.add(textCuenta);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 55, 56, 16);
		contentPane.add(lblNombre);

		JLabel lblDireccin = new JLabel("Direccion");
		lblDireccin.setBounds(12, 84, 56, 16);
		contentPane.add(lblDireccin);

		JLabel lblCuenta = new JLabel("Cuenta");
		lblCuenta.setBounds(12, 111, 56, 16);
		contentPane.add(lblCuenta);

		
	}
	public void setControlador (ControladorAnadirTransportenac c){
		btnAnadir.addActionListener(c);
		btnCancelar.addActionListener(c);
		addWindowListener(c);
	}

}
