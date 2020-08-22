package co.com.k4soft.parqueadero.model;

import co.com.k4soft.parqueadero.model.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TipoTarifaTest {



    @Test
    public void requerirIdentificador(){
        try{
            TipoTarifa tipoTarifa = new TipoTarifa.TipoTarifaBuilder().build();
        }catch (BusinessException ex){
            assertEquals(TipoTarifa.ID_VACIO,ex.getMessage());
        }
    }


    @Test
    public void requerirNombreTarifa(){
        try{
            TipoTarifa tipoTarifa = new TipoTarifa.TipoTarifaBuilder()
                    .setIdTarifa(1)
                    .build();
        }catch (BusinessException ex){
            assertEquals(TipoTarifa.NOMBRE_VACIO,ex.getMessage());
        }
    }

    @Test
    public void requerirValorTarifa(){
        try{
            TipoTarifa tipoTarifa = new TipoTarifa.TipoTarifaBuilder()
                    .setIdTarifa(1)
                    .setNombreTarifa("Bicicleta")
                    .build();
        }catch (BusinessException ex){
            assertEquals(TipoTarifa.VALOR_TARIFA_NO_VALID,ex.getMessage());
        }
    }


}