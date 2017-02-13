import javax.swing.JOptionPane;

public class Principal {
	public static void main (String [] args){
		VistaPrincipal vp =new VistaPrincipal();
		//OracleAcces bdd=new OracleAcces();
		//while (!JOptionPane.showInputDialog(null, "Introduzca su usuario", "").equalsIgnoreCase("javi"));
		ControladorPrincipal Controlprincipal= new ControladorPrincipal(vp);
		vp.setControlador(Controlprincipal);
		vp.setVisible(true);
	}

}
