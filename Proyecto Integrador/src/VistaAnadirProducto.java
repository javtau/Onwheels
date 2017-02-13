

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

public class VistaAnadirProducto extends JFrame {

	private JPanel contentPane;
	JTextField textCod;
	JTextField textDesc;
	JButton btnAnadir;
	JButton btnCancelar;
	JTextField textTipo;
	JSpinner spPrecio;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VistaAnadirProducto() {
		setTitle("Añadir nuevo producto");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 460, 193);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigoDeProducto = new JLabel("Codigo de producto");
		lblCodigoDeProducto.setBounds(12, 26, 129, 16);
		contentPane.add(lblCodigoDeProducto);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(12, 55, 88, 16);
		contentPane.add(lblPrecio);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(12, 84, 72, 16);
		contentPane.add(lblDescripcion);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(12, 113, 56, 16);
		contentPane.add(lblTipo);
		
		textCod = new JTextField();
		textCod.setEditable(false);
		textCod.setBounds(135, 23, 116, 22);
		contentPane.add(textCod);
		textCod.setColumns(10);
		
		textDesc = new JTextField();
		textDesc.setBounds(135, 80, 116, 24);
		contentPane.add(textDesc);
		textDesc.setColumns(10);
		String[] transportes= {"Transati.S.A","Intraxa.S.L","Martrans"};
		String[] t= {"online","Telefono","Tienda"};
		
		btnAnadir = new JButton("A\u00F1adir");
		
		btnAnadir.setBounds(303, 62, 97, 25);
		contentPane.add(btnAnadir);
		
				
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(303, 104, 97, 25);
		contentPane.add(btnCancelar);
		
		textTipo = new JTextField();
		textTipo.setColumns(10);
		textTipo.setBounds(135, 110, 116, 24);
		contentPane.add(textTipo);
		
		spPrecio = new JSpinner();
		spPrecio.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spPrecio.setBounds(135, 52, 116, 22);
		contentPane.add(spPrecio);
		
	}
	public void setControlador(ControladorAnadirProducto c) {
		btnAnadir.addActionListener(c);
		btnCancelar.addActionListener(c);
		addWindowListener(c);
	}
}
