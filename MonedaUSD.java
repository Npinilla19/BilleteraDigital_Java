package alke_wallet;
// constante valor dolar 
public class MonedaUSD implements ConversorMoneda {

    private static final double VALOR_DOLAR = 870; 

    @Override
    public double convertir(double monto) {
        return monto / VALOR_DOLAR;
    }

    @Override
    public String getMoneda() {
        return "USD";
    }
}
