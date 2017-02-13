import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.toedter.calendar.JDateChooser;

import javax.swing.SpinnerNumberModel;

public class VistaModificarProveedor extends JFrame {

	private JPanel contentPane;
	JTextField textCod;
	JTextField textTel;
	JButton btnModificar;
	JButton btnCancelar;
	JTextField textUbicacion;
	JTextField textNombre;
	JTextField textNif;
	JTextField textCuenta;
	JTextField textContacto;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VistaModificarProveedor() {
		setTitle("Modificar proveedor");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 460, 285);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigoDeProveedor = new JLabel("Codigo ");
		lblCodigoDeProveedor.setBounds(12, 26, 129, 16);
		contentPane.add(lblCodigoDeProveedor);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 55, 88, 16);
		contentPane.add(lblNombre);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(12, 84, 72, 16);
		contentPane.add(lblTelefono);
		
		JLabel lblUbicacion = new JLabel("Ubicaci\u00F3n");
		lblUbicacion.setBounds(12, 113, 56, 16);
		contentPane.add(lblUbicacion);
		
		textCod = new JTextField();
		textCod.setEditable(false);
		textCod.setBounds(135, 23, 116, 22);
		contentPane.add(textCod);
		textCod.setColumns(10);
		
		textTel = new JTextField();
		textTel.setBounds(135, 80, 116, 24);
		contentPane.add(textTel);
		textTel.setColumns(10);
		String[] transportes= {"Transati.S.A","Intraxa.S.L","Martrans"};
		String[] t= {"online","Telefono","Tienda"};
		
		btnModificar = new JButton("Modificar");
		
		btnModificar.setBounds(303, 149, 97, 25);
		contentPane.add(btnModificar);
		
				
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(303, 191, 97, 25);
		contentPane.add(btnCancelar);
		
		textUbicacion = new JTextField();
		textUbicacion.setColumns(10);
		textUbicacion.setBounds(135, 110, 116, 24);
		contentPane.add(textUbicacion);
		
		textNombre = new JTextField();
		textNombre.setBounds(135, 52, 116, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNif = new JLabel("NIF");
		lblNif.setBounds(12, 142, 56, 16);
		contentPane.add(lblNif);
		
		JLabel lblCodigoDeCuenta = new JLabel("Codigo de cuenta");
		lblCodigoDeCuenta.setBounds(12, 171, 116, 16);
		contentPane.add(lblCodigoDeCuenta);
		
		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setBounds(12, 200, 56, 16);
		contentPane.add(lblContacto);
		
		textNif = new JTextField();
		textNif.setBounds(135, 139, 116, 22);
		contentPane.add(textNif);
		textNif.setColumns(10);
		
		textCuenta = new JTextField();
		textCuenta.setBounds(135, 168, 116, 22);
		contentPane.add(textCuenta);
		textCuenta.setColumns(10);
		
		textContacto = new JTextField();
		textContacto.setBounds(135, 197, 116, 22);
		contentPane.add(textContacto);
		textContacto.setColumns(10);
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	public void setControlador (ControladorModificarProveedor c){
		btnModificar.addActionListener(c);
		btnCancelar.addActionListener(c);
		addWindowListener(c);
	}
}

