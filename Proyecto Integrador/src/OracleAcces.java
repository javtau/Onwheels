
import java.sql.*;
import java.util.ArrayList;

public class OracleAcces {
	// Atributos de la clase
	private String surl = "jdbc:oracle:thin:@localhost:1521:XE";
	private Connection conexion;

	// Constructor que crea la conexión
	public OracleAcces() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(surl, "integrador", "123456");
			System.out.println(" - Conexión con ORACLE establecida -");

		} catch (Exception e) {
			System.out.println(" – Error de Conexión con ORACLE-");
			e.printStackTrace();
		}
	}

	// metodos comunes para todas las clases
	// estos metodos son validos para todas los controladores.
	// Metodo cerraBBDD. nos cierra la base de datos
	public void cerrarBBDD() {
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// metodo introducir fila. nos introduce una nueva fila en la tabla que
	// deseemos
	// como parametros le deveremos pasar los nuevos valores y la tabla
	public void introducirFila(String values, String tabla) {
		String query = "INSERT INTO " + tabla + " VALUES " + "(" + values + ")";
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	// metodo introducir celda. nos introduce un nuevo valor en la celda que
	// queramos la tabla que deseemos
	// como parametros le deveremos pasar el nuevo valor,la columna,el nombre
	// del la columna que contiene el codigo, el codigo y la tabla
	public void introducirCelda(int cod, String col, String nCod, String tabla, float nval) {
		String query = "UPDATE " + tabla + " SET " + col + " = " + nval + " WHERE " + nCod + "=" + cod;
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	// metodo introducir celda. nos introduce un nuevo valor en la celda que
	// queramos la tabla que deseemos
	// como parametros le deveremos pasar el nuevo valor,la columna,el nombre
	// del la columna que contiene el codigo, el codigo y la tabla
	public void introducirCeldaS(int cod, String col, String nCod, String tabla, String nval) {
		String query = "UPDATE " + tabla + " SET " + col + " = '" + nval + "' WHERE " + nCod + "=" + cod;
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	// Metodo consultar. nos devuelve el contenido de una celda en concreto
	// como datos se le debe pasar el codigo del elemento que queremos, la
	// tabla,
	// el nombre de la columna que contiene el codigo y el nombre de la columna
	// que queremos consultar
	public String consultar(int c, String col, String nCod, String tabla) {
		String query = "SELECT " + col + " FROM " + tabla + " WHERE " + nCod + " = " + c;
		String t = "";
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			rset.next();
			t = rset.getString(1);
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return t;
	}

	// Metodo buscar. nos devuelve el contenido de una celda en concreto
	// como datos se le debe pasar el codigo del elemento que queremos, la
	// tabla,
	// el nombre de la columna que contiene el codigo y el nombre de la columna
	// que queremos consultar
	public boolean buscar(String dato, String columna, String tabla) {
		String query = "SELECT *FROM " + tabla + " WHERE " + columna + " = '" + dato+"'";
		boolean existe = false;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			if (rset.next())
				existe = true;
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return existe;
	}

	// Metodo sumar columna. nos devuelve la suma de una columna
	// como datos se le debe pasar el codigo del elemento que queremos, la
	// tabla,
	// el nombre de la columna que contiene el codigo y el nombre de la columna
	// que queremos consultar
	public float sumarColumna(int c, String col, String nCod, String tabla) {
		float r = 0;
		String query = "SELECT SUM(" + col + ") AS " + col + " FROM " + tabla + " WHERE " + nCod + " = " + c;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			rset.next();
			r = Float.parseFloat(rset.getString(col));
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return r;
	}

	// metodo borrar fila. Nos borra la fila que indique el codigo de la tabla
	// que le pasemos
	public void borrarFila(int cod, String nCod, String tabla) {
		String query = "DELETE FROM " + tabla + " WHERE " + nCod + " =" + cod;
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(query);
			stmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	// Metodo rellenar array. nos rellena 2 array list con las columnas que le
	// indiquemos de la tabla que queramos
	public void rellenarArray(ArrayList<String> array, ArrayList<Integer> ct, String col, String col2, String tabla) {
		String query = "SELECT " + col + ", " + col2 + " FROM " + tabla;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {
				array.add(rset.getString(1));
				ct.add(Integer.parseInt(rset.getString(2)));
			}

			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	// Metodo rellenar array3. nos rellena 3 array list con las columnas que le
	// indiquemos de la tabla que queramos
	public void rellenarArray3(ArrayList<String> array1, ArrayList<Integer> array2, ArrayList<Float> array3, String col,
			String col2, String col3, String tabla) {
		String query = "SELECT " + col + ", " + col2 + ", " + col3 + " FROM " + tabla;
		int cod = 0;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {

				array1.add(rset.getString(1));
				array2.add(Integer.parseInt(rset.getString(2)));
				array3.add(Float.parseFloat(rset.getString(3)));

			}

			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	// Metodo CogerCodigo. nos coge el ultimo codigo que indiquemos
	// indiquemos de la tabla que queramos
	public int CogerCodigo(String ncod, String tabla) {
		String query = "SELECT " + ncod + " FROM " + tabla;
		int cod = 0;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {
				cod = Integer.parseInt(rset.getString(ncod));
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return cod;
	}

	// metodos especificos.
	// Estos metodos solo son validos para la tabla que indica elnombre del
	// metodo.

	// Metodo leer tabla compra
	// nos le la tabla compra y nos introduce sus datos en el array list que le
	// pasemos por parametro
	// Este metodo nos devuelve el codigo del ultimo elemento.
	public int leerTablaCompra(ArrayList<Compra> c) {
		int cod = 0;
		String query = "SELECT COD_COMPRA,COD_TRANSPORTE, COSTE, TIPO, TO_CHAR(FECHA, 'DD/MM/YYYY')AS FECHA FROM COMPRA ORDER BY COD_COMPRA ";
		try {

			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {
				cod = Integer.parseInt(rset.getString("COD_COMPRA"));
				c.add(new Compra(cod, Integer.parseInt(rset.getString("COD_TRANSPORTE")),
						Float.parseFloat(rset.getString("COSTE")), rset.getString("TIPO"), rset.getString("FECHA")));
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return cod;
	}

	// Metodo leer tabla peddido
	// nos le la tabla compra y nos introduce sus datos en el array list que le
	// pasemos por parametro
	// Este metodo nos devuelve el codigo del ultimo elemento.
	public int leerTablaPedido(ArrayList<Pedido> c) {
		String query = "SELECT COD_PEDIDO,COD_TRANSPORTE, COSTE, COD_AGENTE, TO_CHAR(FECHA, 'DD/MM/YYYY')AS FECHA FROM PEDIDO ORDER BY COD_PEDIDO ";

		int cod = 0;
		try {

			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {
				cod = Integer.parseInt(rset.getString("COD_PEDIDO"));
				c.add(new Pedido(cod, Integer.parseInt(rset.getString("COD_TRANSPORTE")), rset.getInt("COD_AGENTE"),
						Float.parseFloat(rset.getString("COSTE")), rset.getString("FECHA")));

			}

			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return cod;
	}

	// Metodo leer tabla Linea de compra
	// nos leE la tabla Linea de compra y nos introduce sus datos en el array
	// list
	// pasemos por parametro
	// Este metodo nos devuelve el codigo del ultimo elemento.
	public void leerTablaLineaCompra(ArrayList<LineaCompra> lc, int cod) {
		String query = "SELECT COD_LINEA, CANTIDAD, COSTE, TO_CHAR(FECHA_ENVIO, 'DD/MM/YYYY')AS FECHA_ENVIO, COD_PRODUCTO, COD_COMPRA  FROM LINEACOMPRA WHERE COD_COMPRA ="
				+ cod + " ORDER BY COD_LINEA ";
		int codigo = 0;
		try {

			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {
				codigo = rset.getInt("COD_LINEA");
				lc.add(new LineaCompra(codigo, Integer.parseInt(rset.getString("CANTIDAD")), rset.getFloat("COSTE"),
						rset.getString("FECHA_ENVIO"), Integer.parseInt(rset.getString("COD_PRODUCTO")),
						Integer.parseInt(rset.getString("COD_COMPRA"))));

			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}

	}

	// Metodo leer tabla Linea de pedido
	// nos leE la tabla Linea de compra y nos introduce sus datos en el array
	// list
	// pasemos por parametro
	// Este metodo nos devuelve el codigo del ultimo elemento.
	public void leerTablaLineaPedido(ArrayList<LineaPedido> lp, int cod) {
		String query = "SELECT COD_LINEAPEDIDO, CANTIDAD, COSTE, COD_PROVEEDOR, TO_CHAR(FECHA_ENVIO, 'DD/MM/YYYY')AS FECHA_ENVIO, COD_PEDIDO, COD_PRODUCTO  FROM LINEAPEDIDO WHERE COD_PEDIDO ="
				+ cod + " ORDER BY COD_LINEAPEDIDO ";
		int codigo = 0;
		try {

			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {
				codigo = Integer.parseInt(rset.getString("COD_LINEAPEDIDO"));

				lp.add(new LineaPedido(codigo, rset.getInt("CANTIDAD"), rset.getFloat("COSTE"),
						rset.getInt("COD_PROVEEDOR"), rset.getString("FECHA_ENVIO"), rset.getInt("COD_PEDIDO"),
						rset.getInt("COD_PRODUCTO")));

			}

			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}

	}

	// Metodo leer tabla Productos
	// nos leE la tabla Productos y nos introduce sus datos en el array list que
	// pasemos por parametro
	// Este metodo nos devuelve el codigo del ultimo elemento.
	public int leerTablaProductos(ArrayList<Productos> p) {
		String query = "SELECT * FROM PRODUCTOS ORDER BY COD_PRODUCTO ";
		int codigo = 0;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {
				codigo = Integer.parseInt(rset.getString("COD_PRODUCTO"));
				p.add(new Productos(codigo, Float.parseFloat(rset.getString("PRECIO")), rset.getString("DESCRIPCION"),
						rset.getString("TIPO")));
			}

			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return codigo;
	}

	// Metodo leer tabla Proveedores
	// nos leE la tabla Productos y nos introduce sus datos en el array list que
	// pasemos por parametro
	// Este metodo nos devuelve el codigo del ultimo elemento.
	public int leerTablaProveedores(ArrayList<Proveedores> p) {
		String query = "SELECT * FROM PROVEEDORES ORDER BY COD_PROVEEDOR ";
		int codigo = 0;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {
				codigo = rset.getInt("COD_PROVEEDOR");
				p.add(new Proveedores(codigo, rset.getString("NOMBRE"), rset.getInt("TELEFONO"),
						rset.getString("UBICACION"), rset.getString("NIF"), rset.getString("COD_CUENTA"),
						rset.getString("PERSCONTACTO")));
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return codigo;
	}

	// Metodo leer tabla Clientes
	// nos leE la tabla Productos y nos introduce sus datos en el array list que
	// pasemos por parametro
	// Este metodo nos devuelve el codigo del ultimo elemento.
	public int leerTablaClientes(ArrayList<Clientes> c) {
		String query = "SELECT * FROM CLIENTE ORDER BY COD_CLIENTE ";
		int codigo = 0;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {
				codigo = rset.getInt("COD_CLIENTE");
				c.add(new Clientes(codigo, rset.getString("UBICACION"), rset.getString("CORREO"),
						rset.getString("DATOSBANCARIOS"), rset.getString("NOMBRE"), rset.getString("APELLIDOS"),
						rset.getInt("TELEFONO"), rset.getString("DNI")));
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return codigo;
	}

	// Metodo leer tabla Agegnte
	// nos leE la tabla Productos y nos introduce sus datos en el array list que
	// pasemos por parametro
	// Este metodo nos devuelve el codigo del ultimo elemento.
	public int leerTablaAgente(ArrayList<AgenteAduanas> c) {
		String query = "SELECT * FROM AGENTEADUANAS ORDER BY COD_AGENTE ";
		int codigo = 0;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {
				codigo = rset.getInt("COD_AGENTE");
				c.add(new AgenteAduanas(codigo, rset.getString("NOMBRE"), rset.getString("APELLIDOS"),
						rset.getString("SEDE"), rset.getString("DNI"), rset.getString("DATOSBANCARIOS")));
			}

			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return codigo;
	}

	// Metodo leer tabla Interprete
	// nos leE la tabla Productos y nos introduce sus datos en el array list que
	// pasemos por parametro
	// Este metodo nos devuelve el codigo del ultimo elemento.
	public int leerTablaInterprete(ArrayList<Interprete> c) {
		int codigo = 0;
		try {

			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM INTERPRETE ORDER BY COD_INTERPRETE ");

			while (rset.next()) {
				codigo = rset.getInt("COD_INTERPRETE");

				c.add(new Interprete(codigo, rset.getString("DNI"), rset.getString("NOMBRE"),
						rset.getString("APELLIDOS"), rset.getString("TELEFONO"), rset.getString("DIRECCION")));

			}

			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return codigo;
	}

	// Metodo leer tabla transporte nacional
	// nos leE la tabla Productos y nos introduce sus datos en el array list que
	// pasemos por parametro
	// Este metodo nos devuelve el codigo del ultimo elemento.
	public int leerTablaTRansportenac(ArrayList<TransporteNacional> t) {
		int codigo = 0;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM TRANSPORTENACIONAL ORDER BY COD_TRANSPORTE_NA ");

			while (rset.next()) {
				codigo = rset.getInt("COD_TRANSPORTE_NA");

				t.add(new TransporteNacional(codigo, rset.getString("DATOSBANCARIOS"), rset.getString("DIRECCION"),
						rset.getString("NOMBRE")));

			}

			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return codigo;
	}

	// Metodo leer tabla transporte internacional
	// nos leE la tabla Productos y nos introduce sus datos en el array list que
	// pasemos por parametro
	// Este metodo nos devuelve el codigo del ultimo elemento.
	public int leerTablaTRansporteinter(ArrayList<TransporteInternacional> t) {
		String query = "SELECT * FROM TRANSPORTEINTERNACIONAL ORDER BY COD_TRANSPORTE ";
		int codigo = 0;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {
				codigo = rset.getInt("COD_TRANSPORTE");
				t.add(new TransporteInternacional(codigo, rset.getString("NOMBRE"), rset.getString("DIRECCION"),
						rset.getString("DATOSBANCARIOS"), rset.getInt("COD_INTERPRETE")));

			}

			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return codigo;
	}

}
