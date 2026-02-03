package alke_wallet;

public class Cuenta {
	
	// atributos de la clase cuente (todos los datos necesarios que debe tener una cuenta asociada a un usuario)
	
	private String nombreCuenta;
	private String banco;
	private String tipoCuenta;
	private String numeroCuenta;
	private double saldo;
	private Usuario usuario;
	
	
	// metodo constructor de la clase cuenta
	
	public Cuenta(String nombreCuenta, Usuario usuario, String banco, String tipoCuenta, String numeroCuenta) {
		
		this.nombreCuenta = nombreCuenta;
		this.usuario = usuario;
		this.banco = banco;
		this.tipoCuenta = tipoCuenta;
		this.saldo = 0.0;
		this.numeroCuenta = numeroCuenta;
		
		
	}
	
	//getters
	
	public String getNombreCuenta() {
	    return nombreCuenta;
	}
	
	public String getNumeroCuenta() {
        return numeroCuenta;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public String getBanco() {
	    return banco;
	}

	public String getTipoCuenta() {
	    return tipoCuenta;
	}
        
	
	// ingresamos el metodo para depositar a la cuenta 
	
	public boolean depositar(double monto) {
	    if (monto > 0) {
	        saldo += monto;
	        return true;
	    }
	    return false;
	}
	// metodo para retirar dinero de la cuenta 
	
	public boolean girar(double monto) {
	    if (monto > 0 && monto <= saldo) {
	        saldo -= monto;
	        return true;
	    }
	    return false;
	}
		
	//metodo para consultar Saldo 
		
	public void obtenerInformacion() {
		
		System.out.println("Cliente: " + usuario.getNombre());
		
		System.out.println("Cuenta: " + nombreCuenta + " | Número : " + numeroCuenta);
		
		System.out.println("Saldo Actual : " + saldo);
	
	}
	 
	// convertir moneda, no modifica los datos de la cuenta, solo muestra la conversion en consola 
	
	public void mostrarSaldoConvertido(ConversorMoneda nuevoConversor) {
        double saldoConvertido = nuevoConversor.convertir(saldo);
        System.out.println("Saldo convertido: " + saldoConvertido + " " + nuevoConversor.getMoneda());
    }
	
	
			
		
}
