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

public class VistaAnadirPedido extends JFrame {

	private JPanel contentPane;
	JTextField textCod;
	JTextField textCoste;
	JSpinner spTrans;
	JSpinner spAgente;
	JDateChooser dcFecha;
	JButton btnAnadir;
	JButton btnCancelar;

	/**
	 * Create the frame.
	 */
	public VistaAnadirPedido() {
		setTitle("Añadir nuevo pedido");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 460, 256);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCodigoDePedido = new JLabel("Codigo de pedido");
		lblCodigoDePedido.setBounds(12, 26, 129, 16);
		contentPane.add(lblCodigoDePedido);

		JLabel lblTransprte = new JLabel("Transporte");
		lblTransprte.setBounds(12, 55, 88, 16);
		contentPane.add(lblTransprte);

		JLabel lblCoste = new JLabel("Coste");
		lblCoste.setBounds(12, 113, 56, 16);
		contentPane.add(lblCoste);

		JLabel lblAgente = new JLabel("Agente");
		lblAgente.setBounds(12, 84, 56, 16);
		contentPane.add(lblAgente);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(12, 142, 56, 16);
		contentPane.add(lblFecha);

		textCod = new JTextField();
		textCod.setBounds(135, 23, 116, 22);
		textCod.setEditable(false);
		contentPane.add(textCod);
		textCod.setColumns(10);

		textCoste = new JTextField();
		textCoste.setEditable(false);
		textCoste.setText("0");
		textCoste.setBounds(135, 110, 116, 22);
		contentPane.add(textCoste);
		textCoste.setColumns(10);

		spTrans = new JSpinner();
		String[] transportes = { "Transati.S.A", "Intraxa.S.L", "Martrans" }; // array que contendra los transportes que alla en la tabla
		spTrans.setModel(new SpinnerListModel(transportes));
		spTrans.setBounds(135, 52, 116, 22);
		contentPane.add(spTrans);

		spAgente = new JSpinner();
		String[] agentes = { "Pedro", "Luis", "Lorena" }; // array que contendra  los agentes que alla en la tabla
		spAgente.setModel(new SpinnerListModel(agentes));
		spAgente.setBounds(135, 80, 116, 24);
		contentPane.add(spAgente);

		dcFecha = new JDateChooser();
		dcFecha.setBounds(135, 142, 116, 22);
		dcFecha.setCalendar(Calendar.getInstance());
		contentPane.add(dcFecha);

		btnAnadir = new JButton("A\u00F1adir");

		btnAnadir.setBounds(303, 96, 97, 25);
		contentPane.add(btnAnadir);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(303, 138, 97, 25);
		contentPane.add(btnCancelar);

	}

	public void setControlador(ControladorAnadirPedido c) {

		btnAnadir.addActionListener(c);
		btnCancelar.addActionListener(c);
		addWindowListener(c);
	}

}
