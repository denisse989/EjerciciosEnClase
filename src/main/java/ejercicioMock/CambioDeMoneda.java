package ejercicioMock;


public class CambioDeMoneda {
    TipoDeCambio tipoDeCambio;

    public CambioDeMoneda(TipoDeCambio objetoMockeado) {
        tipoDeCambio=objetoMockeado;
    }

    public String cambio(double monto, String origen, String cambio){
        double resultado = 0;
        if(monto>=1){
            double convert= tipoDeCambio.convert(origen,cambio);
            resultado=monto*convert;
            return "La cantidad convertida fue :"+resultado+" "+cambio;
        }else{
            return "Cantidad incorrecta";
        }

    }
}
