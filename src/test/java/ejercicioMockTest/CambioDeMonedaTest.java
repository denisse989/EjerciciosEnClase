package ejercicioMockTest;

import ejercicioMock.CambioDeMoneda;
import ejercicioMock.TipoDeCambio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CambioDeMonedaTest {
    TipoDeCambio tipoDeCambioMock=Mockito.mock(TipoDeCambio.class);

    @Test
    public void verifyCambioBolivianos(){
        Mockito.when(tipoDeCambioMock.convert("dolares","bolivianos")).thenReturn(7.0);
        CambioDeMoneda cambioDeMoneda=new CambioDeMoneda(tipoDeCambioMock);
        String actualResult=cambioDeMoneda.cambio(100,"dolares","bolivianos");
        String expectedResult="La cantidad convertida fue :700.0 bolivianos";
        Assertions.assertEquals(expectedResult, actualResult, "ERROR es incorrecto");
        Mockito.verify(tipoDeCambioMock).convert("dolares","bolivianos");
    }

    @Test
    public void verifyCambioDolares(){

        Mockito.when(tipoDeCambioMock.convert("bolivianos","dolares")).thenReturn(0.15);
        CambioDeMoneda cambioDeMoneda=new CambioDeMoneda(tipoDeCambioMock);
        String actualResult=cambioDeMoneda.cambio(700,"bolivianos","dolares");
        String expectedResult="La cantidad convertida fue :105.0 dolares";
        Assertions.assertEquals(expectedResult, actualResult, "ERROR es incorrecto");
        Mockito.verify(tipoDeCambioMock).convert("bolivianos","dolares");
    }

    @Test
    public void verifyMontoIncorrecto(){
        Mockito.when(tipoDeCambioMock.convert("dolares","bolivianos")).thenReturn(7.0);
        CambioDeMoneda cambioDeMoneda=new CambioDeMoneda(tipoDeCambioMock);
        Assertions.assertEquals("Cantidad incorrecta",
                cambioDeMoneda.cambio(-100,"dolares","bolivianos"),
                "ERROR es incorrecto");
    }
}
