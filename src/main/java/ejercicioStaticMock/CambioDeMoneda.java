package ejercicioStaticMock;

public class CambioDeMoneda {

    public String cambio(double monto, String origen, String cambio){
        double resultado = 0;
        if(monto>=1){
            double convert=TipoDeCambio.convert(origen,cambio);
            resultado=monto*convert;
            return "La cantidad convertida fue :"+resultado+" "+cambio;
        }else{
            return "Cantidad incorrecta";
        }

    }
}
