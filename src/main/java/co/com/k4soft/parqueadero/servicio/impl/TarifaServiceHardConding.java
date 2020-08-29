package co.com.k4soft.parqueadero.servicio.impl;


import co.com.k4soft.parqueadero.model.TipoTarifa;
import co.com.k4soft.parqueadero.servicio.TipoTarifaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarifaServiceHardConding implements TipoTarifaService {
    @Override
    public List<TipoTarifa> getTarifas() {
        List<TipoTarifa> listaTarifas = new ArrayList<>();
        listaTarifas.add(getTipoTarifa1());
        listaTarifas.add(getTipoTarifa2());
        listaTarifas.add(getTipoTarifa3());
        return listaTarifas;
    }

    private TipoTarifa getTipoTarifa3() {
        return new TipoTarifa.TipoTarifaBuilder()
                .setIdTarifa(2)
                .setNombreTarifa("AUTOÓVIL")
                .setValor(2000)
                .setActivo(true).build();
    }

    private TipoTarifa getTipoTarifa2() {
        return new TipoTarifa.TipoTarifaBuilder()
                .setIdTarifa(2)
                .setNombreTarifa("MOTOCICLETA")
                .setValor(1500)
                .setActivo(true).build();
    }

    private TipoTarifa getTipoTarifa1() {
        return new TipoTarifa.TipoTarifaBuilder()
                .setIdTarifa(1)
                .setNombreTarifa("BICICLETE")
                .setValor(1000)
                .setActivo(true).build();
    }
}
