package alke_wallet;
import java.util.ArrayList;

public class BilleteraDigital {
	//clase billetera para ingresar los movimientos de las cuentas y usuario sin la necesidad de modificar el main con Array para mostrar las multiples cuentas
		private Usuario usuario;
		private ArrayList<Cuenta> cuentas;
		
		public BilleteraDigital(Usuario usuario) {
			this.usuario = usuario;
			this.cuentas = new ArrayList<>();
			
		}
		// se guardan los datos de las cuentas creadas 
		public void agregarCuenta(String nombreCuenta,  String banco, String tipoCuenta, String numeroCuenta) {
			cuentas.add(new Cuenta(nombreCuenta, usuario, banco, tipoCuenta, numeroCuenta));
		}
		 // devolvemos para mostrar las cuentas
		public void mostrarCuentas() {
		    if (cuentas.isEmpty()) {
		        System.out.println("No hay cuentas creadas.");
		        return;
		    }

		    for (int i = 0; i < cuentas.size(); i++) {
		        Cuenta c = cuentas.get(i);
		        System.out.println(
		            (i + 1) + ". " +
		            c.getBanco() + " | " +
		            c.getTipoCuenta() +
		            " | N° " + c.getNumeroCuenta() +
		            " | Saldo: $" + c.getSaldo()
		        );
		    }
		}
		
		public Cuenta obtenerCuenta(int indice) {
		    if (indice >= 0 && indice < cuentas.size()) {
		        return cuentas.get(indice);
		    }
		    return null;
		}

}
