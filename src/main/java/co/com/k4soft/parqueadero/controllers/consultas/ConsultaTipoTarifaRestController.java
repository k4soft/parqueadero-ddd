package co.com.k4soft.parqueadero.controllers.consultas;


import co.com.k4soft.parqueadero.model.TipoTarifa;
import co.com.k4soft.parqueadero.servicio.TipoTarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/consulta")
public class ConsultaTipoTarifaRestController {

    @Autowired
    private TipoTarifaService tipoTarifaService;


    @GetMapping("/health")
    public String getHealth(){
        return "consulta is running";
    }

    @GetMapping("/tarifas")
    public List<TipoTarifa> getTipoTarifa(){
        return tipoTarifaService.getTarifas();
    }


}
