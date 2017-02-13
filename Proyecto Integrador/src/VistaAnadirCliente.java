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

public class VistaAnadirCliente extends JFrame {

	private JPanel contentPane;
	JTextField textCod;
	JTextField textNomb;
	JButton btnAnadir;
	JButton btnCancelar;
	JTextField textApell;
	JTextField textDni;
	JTextField textTel;
	JTextField textDirec;
	JTextField textCorreo;
	JTextField textCuenta;
	JLabel lblNombre;
	JLabel lblApellidos;
	JLabel lblTelefono;
	JLabel lblDireccin;
	JLabel lblCorreo;
	JLabel lblCuenta;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VistaAnadirCliente() {
		setTitle("Añadir nuevo Cliente");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 460, 310);
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
		String[] transportes= {"Transati.S.A","Intraxa.S.L","Martrans"};
		String[] t= {"online","Telefono","Tienda"};
		
		btnAnadir = new JButton("A\u00F1adir");
		
		btnAnadir.setBounds(303, 181, 97, 25);
		contentPane.add(btnAnadir);
		
				
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(303, 223, 97, 25);
		contentPane.add(btnCancelar);
		
		textApell = new JTextField();
		textApell.setColumns(10);
		textApell.setBounds(135, 110, 116, 24);
		contentPane.add(textApell);
		
		textDni = new JTextField();
		textDni.setBounds(135, 52, 116, 22);
		contentPane.add(textDni);
		textDni.setColumns(10);
		
		textTel = new JTextField();
		textTel.setBounds(135, 139, 116, 22);
		contentPane.add(textTel);
		textTel.setColumns(10);
		
		textDirec = new JTextField();
		textDirec.setBounds(135, 168, 116, 22);
		contentPane.add(textDirec);
		textDirec.setColumns(10);
		
		textCorreo = new JTextField();
		textCorreo.setBounds(135, 197, 116, 22);
		contentPane.add(textCorreo);
		textCorreo.setColumns(10);
		
		textCuenta = new JTextField();
		textCuenta.setColumns(10);
		textCuenta.setBounds(135, 226, 116, 22);
		contentPane.add(textCuenta);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 84, 56, 16);
		contentPane.add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(12, 114, 56, 16);
		contentPane.add(lblApellidos);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(12, 142, 56, 16);
		contentPane.add(lblTelefono);
		
		lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(12, 171, 56, 16);
		contentPane.add(lblDireccin);
		
		lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(12, 200, 56, 16);
		contentPane.add(lblCorreo);
		
		lblCuenta = new JLabel("Cuenta");
		lblCuenta.setBounds(12, 229, 56, 16);
		contentPane.add(lblCuenta);
		
	
	}
	public void setControlador(ControladorAnadirCliente c) {
		btnAnadir.addActionListener(c);
		btnCancelar.addActionListener(c);
		addWindowListener(c);
	}

}
