package co.com.k4soft.parqueadero.model;


import co.com.k4soft.parqueadero.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MovimientoTest {


    @Test
    public void crearMovimientoSinFechaEntrada() throws Exception {

        try {
            Movimiento movimiento = new Movimiento.MovimientoBuilder()
                    .build();

        } catch (Exception e) {
            assertEquals(Movimiento.FECHA_INGRESO_REQUERIDA, e.getMessage());
        }

    }

    @Test
    public void crearMovimientoSinFechaSalida() throws Exception {
        try {
            Movimiento movimiento = new Movimiento.MovimientoBuilder()
                    .setFechaIngreso(new Date())
                    .build();
        } catch (Exception exception) {
            assertEquals(Movimiento.FECHA_SALIDA_REQUERIDA, exception.getMessage());
        }


    }


    @Test
    public void crearMovimientoConPlacaNula() throws Exception {

        try {
            Movimiento movimiento = new Movimiento.MovimientoBuilder()
                    .setFechaIngreso(new Date())
                    .setFechaSalida(new Date())
                    .build();
        } catch (Exception exception) {
            assertEquals(Movimiento.PLACA_REQUERIDA, exception.getMessage());
        }
    }

    @Test
    public void crearMovimientoConPlacaVacia() throws Exception {
        try {
            Movimiento movimiento = new Movimiento.MovimientoBuilder()
                    .setFechaIngreso(new Date())
                    .setFechaSalida(new Date())
                    .setPlaca("")
                    .build();
        } catch (Exception e) {
            assertEquals(Movimiento.TARIFA_NO_CONFIGURADA, e.getMessage());
        }
    }


    @Test
    public void crearMovimientoConTarifaSinConfigurar() throws Exception {

        try {
            Movimiento movimiento = new Movimiento.MovimientoBuilder()
                    .setFechaIngreso(new Date())
                    .setFechaSalida(new Date())
                    .setPlaca("MLG904")
                    .build();
        } catch (Exception exception) {
            assertEquals(Movimiento.TARIFA_NO_CONFIGURADA, exception.getMessage());
        }
    }

    @Test
    public void crearObjetoConTarifaConPrecioCero() throws Exception {
        try {
            TipoTarifa tarifa = new TipoTarifa.TipoTarifaBuilder()
                    .setIdTarifa(1).setNombreTarifa("Motocicletas").setValor(0).build();
            Movimiento movimiento = new Movimiento.MovimientoBuilder()
                    .setFechaIngreso(new Date())
                    .setFechaSalida(new Date())
                    .setPlaca("MLG904")
                    .setTipoTarifa(tarifa)
                    .build();
        } catch (Exception exception) {
            assertEquals(TipoTarifa.VALOR_TARIFA_NO_VALID, exception.getMessage());
        }

    }

    @Test
    public void calcularTarifaMotocicleta() throws Exception {
        Date fechaEntrada = DateUtil.convertStringToDate("2020-02-18 07:00:00");
        Date fechaSalida = DateUtil.convertStringToDate("2020-02-18 08:00:00");

        TipoTarifa tarifa = new TipoTarifa.TipoTarifaBuilder()
                .setIdTarifa(1).setNombreTarifa("Motociletas").setValor(1500).build();

        Movimiento movimiento = new Movimiento.MovimientoBuilder()
                .setFechaIngreso(fechaEntrada)
                .setFechaSalida(fechaSalida)
                .setPlaca("MLG904")
                .setTipoTarifa(tarifa)
                .build();
        double valorReal = movimiento.calcularValorTotal();
        double valorEsperado = 1500;
        assertEquals(valorEsperado, valorReal, 1);

    }

    @Test
    public void calcularTarifaAutomovil() throws Exception {
        Date fechaEntrada = DateUtil.convertStringToDate("2020-02-18 07:00:00");
        Date fechaSalida = DateUtil.convertStringToDate("2020-02-18 09:00:00");
        TipoTarifa tarifa = new TipoTarifa.TipoTarifaBuilder()
                .setIdTarifa(2).setNombreTarifa("Automóvil").setValor(2500).build();
        Movimiento movimiento = new Movimiento.MovimientoBuilder()
                .setFechaIngreso(fechaEntrada)
                .setFechaSalida(fechaSalida)
                .setPlaca("MLG904")
                .setTipoTarifa(tarifa)
                .build();
        double valorReal = movimiento.calcularValorTotal();
        double valorEsperado = 5000;
        assertEquals(valorEsperado, valorReal, 1);
    }


}