
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class ControladorPrincipal implements ActionListener, WindowListener {
	VistaPrincipal vPrincipal = null;
	OracleAcces bdd=new OracleAcces();
	public ControladorPrincipal(VistaPrincipal vPrincipal) {
		super();
		this.vPrincipal = vPrincipal;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Object obj = e.getSource();
		if (obj == vPrincipal.btnDatos) {
			VistaDatos vd = new VistaDatos();
			ControladorDatos cd = new ControladorDatos(vd,bdd);
			vd.setControlador(cd);
			cd.rellenarTablaProdutos();
			cd.rellenarTablaProveedores();
			cd.rellenarTablaClientes();
			cd.rellenarTablaAgente();
			cd.rellenarTablaInterprete();
			cd.rellenarTranportenac();
			cd.rellenarTranporteinter();
			vPrincipal.setVisible(false);
			vd.setVisible(true);
			
		}
		if (obj == vPrincipal.btnPedidos) {
			VistaPedido vPedido = new VistaPedido();
			Pedido p = new Pedido();
			ArrayList<Pedido> ped= new ArrayList<Pedido>();
			ControladorPedido cp = new ControladorPedido(vPedido, p, bdd, ped);
			vPedido.setControlador(cp);
			cp.rellenarTabla();
			vPrincipal.setVisible(false);
			vPedido.setVisible(true);
		}
		if (obj == vPrincipal.btnCompras) {
			VistaCompra vCompra = new VistaCompra();
			Compra c = new Compra();
			ArrayList<Compra> comp= new ArrayList<Compra>();
			ControladorCompra cCompra = new ControladorCompra(vCompra, c, bdd, comp);
			vCompra.setControlador(cCompra);
			cCompra.rellenarTabla();
			vPrincipal.setVisible(false);
			vCompra.setVisible(true);
		}

	}

	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		bdd.cerrarBBDD();
		
	}

	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
