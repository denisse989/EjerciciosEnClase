package ejercicioStaticMockTest;

import ejercicioStaticMock.CambioDeMoneda;
import ejercicioStaticMock.TipoDeCambio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class CambioDeMonedaStaticTest {
    @BeforeAll
    public static void before(){
        MockedStatic<TipoDeCambio> mocked = Mockito.mockStatic(TipoDeCambio.class);
        mocked.when(()->TipoDeCambio.convert("dolares", "bolivianos")).thenReturn(7.0);
        mocked.when(()->TipoDeCambio.convert("bolivianos", "dolares")).thenReturn(0.15);
    }

    @Test
    public void verifyCambioBolivianos(){
        CambioDeMoneda cambioDeMoneda=new CambioDeMoneda();
        Assertions.assertEquals("La cantidad convertida fue :700.0 bolivianos",
                cambioDeMoneda.cambio(100,"dolares","bolivianos"),
                "ERROR es incorrecto");
    }

    @Test
    public void verifyCambioDolares(){
        CambioDeMoneda cambioDeMoneda=new CambioDeMoneda();
        Assertions.assertEquals("La cantidad convertida fue :105.0 dolares",
                cambioDeMoneda.cambio(700,"bolivianos","dolares"),
                "ERROR es incorrecto");
    }

    @Test
    public void verifyMontoIncorrecto(){
        CambioDeMoneda cambioDeMoneda=new CambioDeMoneda();
        Assertions.assertEquals("Cantidad incorrecta",
                cambioDeMoneda.cambio(-100,"dolares","bolivianos"),
                "ERROR es incorrecto");
    }
}
