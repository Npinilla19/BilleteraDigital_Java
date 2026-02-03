package alke_wallet;
//Interface para usar las constantes de cambio de moneda 
public interface ConversorMoneda {
	
	double convertir(double monto);
    String getMoneda();

}
