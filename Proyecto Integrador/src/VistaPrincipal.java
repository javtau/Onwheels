
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaPrincipal extends JFrame {
  
	private JPanel contentPane;
	JButton btnCompras;
	JButton btnPedidos;
	JButton btnDatos;
	

	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		setTitle("OnWheels");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 372, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setBounds(143, 18, 67, 16);
		contentPane.add(lblBienvenido);
		
		JLabel lblQueDesea = new JLabel("\u00BF Que desea gestionar?");
		lblQueDesea.setBounds(107, 52, 139, 16);
		contentPane.add(lblQueDesea);
		
		btnCompras = new JButton("Compras");
		btnCompras.setBounds(118, 194, 118, 39);
		contentPane.add(btnCompras);
		
		btnPedidos = new JButton("Pedidos");
		btnPedidos.setBounds(118, 140, 118, 36);
		contentPane.add(btnPedidos);
		
		btnDatos = new JButton("Datos");
		btnDatos.setBounds(118, 86, 118, 36);
		contentPane.add(btnDatos);
	}
	
	public void setControlador(ControladorPrincipal c){
		btnDatos.addActionListener(c);
		btnPedidos.addActionListener(c);
		btnCompras.addActionListener(c);
		addWindowListener(c);
	}
}
