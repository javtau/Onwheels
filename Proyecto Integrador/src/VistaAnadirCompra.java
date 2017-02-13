import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import java.util.Calendar;

public class VistaAnadirCompra extends JFrame {

	private JPanel contentPane;
	JTextField textCod;
	JSpinner spTrans;
	JSpinner spTipo;
	JDateChooser dcFecha;
	JButton btnAnadir;
	JButton btnCancelar;
	
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VistaAnadirCompra() {
		setTitle("Añadir nueva Compra");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 460, 192);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigoDeCompra = new JLabel("Codigo de compra");
		lblCodigoDeCompra.setBounds(12, 26, 129, 16);
		contentPane.add(lblCodigoDeCompra);
		
		JLabel lblTransprte = new JLabel("Transporte");
		lblTransprte.setBounds(12, 55, 88, 16);
		contentPane.add(lblTransprte);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(12, 84, 56, 16);
		contentPane.add(lblTipo);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(12, 113, 56, 16);
		contentPane.add(lblFecha);
		
		textCod = new JTextField();
		textCod.setEditable(false);
		textCod.setBounds(135, 23, 144, 22);
		contentPane.add(textCod);
		textCod.setColumns(10);
		
		spTrans = new JSpinner();
		
		spTrans.setBounds(135, 52, 144, 22);
		contentPane.add(spTrans);
		
		spTipo = new JSpinner();
		
		spTipo.setBounds(135, 81, 144, 22);
		contentPane.add(spTipo);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(135, 113, 144, 22);
		dcFecha.setCalendar(Calendar.getInstance());
		contentPane.add(dcFecha);
		
		btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.setBounds(303, 62, 97, 25);
		contentPane.add(btnAnadir);
		
				
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(303, 104, 97, 25);
		contentPane.add(btnCancelar);
		
	
		
		
		
		
		
	}
	public void setControlador(ControladorAnadirCompra c) {
		
		btnAnadir.addActionListener(c);
		btnCancelar.addActionListener(c);
		addWindowListener(c);
	}
}
