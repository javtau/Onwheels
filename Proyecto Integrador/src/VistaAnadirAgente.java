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

public class VistaAnadirAgente extends JFrame {

	private JPanel contentPane;
	JTextField textCod;
	JTextField textNomb;
	JButton btnAnadir;
	JButton btnCancelar;
	JTextField textApell;
	JTextField textDni;
	JTextField textSede;
	JTextField textCuenta;
	JLabel lblNombre;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VistaAnadirAgente() {
		setTitle("Añadir nuevo Agente de aduanas");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 460, 251);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCodigoDeProveedor = new JLabel("Codigo ");
		lblCodigoDeProveedor.setBounds(12, 26, 129, 16);
		contentPane.add(lblCodigoDeProveedor);

		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(12, 55, 88, 16);
		contentPane.add(lblDNI);

		textCod = new JTextField();
		textCod.setEditable(false);
		textCod.setBounds(135, 23, 116, 22);
		contentPane.add(textCod);
		textCod.setColumns(10);

		textNomb = new JTextField();
		textNomb.setBounds(135, 80, 116, 24);
		contentPane.add(textNomb);
		textNomb.setColumns(10);
		String[] transportes = { "Transati.S.A", "Intraxa.S.L", "Martrans" };
		String[] t = { "online", "Telefono", "Tienda" };

		btnAnadir = new JButton("A\u00F1adir");

		btnAnadir.setBounds(306, 124, 97, 25);
		contentPane.add(btnAnadir);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(306, 166, 97, 25);
		contentPane.add(btnCancelar);

		textApell = new JTextField();
		textApell.setColumns(10);
		textApell.setBounds(135, 110, 116, 24);
		contentPane.add(textApell);

		textDni = new JTextField();
		textDni.setBounds(135, 52, 116, 22);
		contentPane.add(textDni);
		textDni.setColumns(10);

		textSede = new JTextField();
		textSede.setBounds(135, 141, 116, 22);
		contentPane.add(textSede);
		textSede.setColumns(10);

		textCuenta = new JTextField();
		textCuenta.setColumns(10);
		textCuenta.setBounds(135, 168, 116, 22);
		contentPane.add(textCuenta);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 84, 56, 16);
		contentPane.add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(12, 114, 56, 16);
		contentPane.add(lblApellidos);

		JLabel lblDireccin = new JLabel("Sede");
		lblDireccin.setBounds(12, 144, 56, 16);
		contentPane.add(lblDireccin);

		JLabel lblCuenta = new JLabel("Cuenta");
		lblCuenta.setBounds(12, 171, 56, 16);
		contentPane.add(lblCuenta);
	}
	public void setControlador (ControladorAnadirAgente c){
		btnAnadir.addActionListener(c);
		btnCancelar.addActionListener(c);
		addWindowListener(c);
	}
}
