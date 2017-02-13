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
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class VistaModificarLineaPedido extends JFrame {

	private JPanel contentPane;
	JTextField textCod;
	JSpinner spProd;
	JDateChooser dcFecha;
	JButton btnModificar;
	JButton btnCancelar;
	JTextField textCoste;
	JSpinner spCant;
	JSpinner spProve;

	/**
	 * Create the frame.
	 */
	public VistaModificarLineaPedido() {
		setTitle("Modificar linea de pedido");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 457, 266);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigoDeCompra = new JLabel("Codigo de compra");
		lblCodigoDeCompra.setBounds(12, 26, 129, 16);
		contentPane.add(lblCodigoDeCompra);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setBounds(12, 89, 88, 16);
		contentPane.add(lblProducto);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(12, 118, 56, 16);
		contentPane.add(lblCantidad);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(12, 174, 56, 16);
		contentPane.add(lblFecha);
		
		textCod = new JTextField();
		textCod.setEditable(false);
		textCod.setBounds(135, 23, 165, 22);
		contentPane.add(textCod);
		textCod.setColumns(10);
		
		spProd = new JSpinner();
		String[] producto= {"Monopatin","Bici","Patin"}; //array que contendra los productos disponibles en la bae de datos
		spProd.setModel(new SpinnerListModel(producto));
		spProd.setBounds(135, 86, 165, 22);
		contentPane.add(spProd);
		
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(135, 174, 165, 22);
		dcFecha.setCalendar(Calendar.getInstance());
		contentPane.add(dcFecha);
		
		btnModificar = new JButton("Modificar");
		
		btnModificar.setBounds(323, 128, 97, 25);
		contentPane.add(btnModificar);
		
				
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(323, 170, 97, 25);
		contentPane.add(btnCancelar);
		
		textCoste = new JTextField();
		textCoste.setEditable(false);
		textCoste.setColumns(10);
		textCoste.setBounds(135, 141, 165, 24);
		contentPane.add(textCoste);
		
		
		JLabel lblCoste = new JLabel("Coste");
		lblCoste.setBounds(12, 145, 56, 16);
		contentPane.add(lblCoste);
		
		spCant = new JSpinner();
		spCant.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spCant.setBounds(135, 115, 165, 22);
		contentPane.add(spCant);
		
		spProve = new JSpinner();
		String[] proveedores= {"WongExport","LianjuSkates","Xingmotions"}; //array que contendra los productos disponibles en la bae de datos
		spProve.setModel(new SpinnerListModel(proveedores));
		spProve.setBounds(135, 55, 165, 22);
		contentPane.add(spProve);
		
		JLabel labelProveedor = new JLabel("Proveedor");
		labelProveedor.setBounds(12, 58, 88, 16);
		contentPane.add(labelProveedor);
		
		
	}
	
	public void setControlador(ControladorModificarLineaPedido c) {

		btnModificar.addActionListener(c);
		btnCancelar.addActionListener(c);
		spProd.addChangeListener(c);
		spCant.addChangeListener(c);
		addWindowListener(c);
	}

}
