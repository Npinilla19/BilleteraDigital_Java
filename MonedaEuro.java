package alke_wallet;
// constante valor Euro 
public class MonedaEuro implements ConversorMoneda {

    private static final double VALOR_EURO = 1020; 

    @Override
    public double convertir(double monto) {
        return monto / VALOR_EURO;
    }

    @Override
    public String getMoneda() {
        return "USD";
    }
}
