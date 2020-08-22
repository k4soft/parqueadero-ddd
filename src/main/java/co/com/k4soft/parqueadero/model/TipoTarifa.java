package co.com.k4soft.parqueadero.model;

import co.com.k4soft.parqueadero.model.exception.BusinessException;
import co.com.k4soft.parqueadero.util.Validator;

public class TipoTarifa {

    public static final String ID_VACIO = "El id tarifa no puede ser nulo";
    public static final String NOMBRE_VACIO = "El nombre no puede ser vacío";
    public static final String VALOR_TARIFA_NO_VALID = "El valor de la tarifa no puede ser 0";

    private Integer idTarifa;
    private String nombreTarifa;
    private double valor;
    private boolean activo;


    private TipoTarifa(){
        super();
    }

    public static class TipoTarifaBuilder{

        private Integer idTarifa;
        private String nombreTarifa;
        private double valor;
        private boolean activo;


        public TipoTarifaBuilder setIdTarifa(Integer idTarifa) {
            this.idTarifa = idTarifa;
            return this;
        }

        public TipoTarifaBuilder setNombreTarifa(String nombreTarifa) {
            this.nombreTarifa = nombreTarifa;
            return this;
        }

        public TipoTarifaBuilder setValor(double valor) {
            this.valor = valor;
            return this;
        }

        public TipoTarifaBuilder setActivo(boolean activo) {
            this.activo = activo;
            return this;
        }

        public TipoTarifa build() throws BusinessException {
            TipoTarifa tipoTarifa = new TipoTarifa();
            Validator.valorNulo(idTarifa,ID_VACIO);
            tipoTarifa.idTarifa = idTarifa;
            Validator.valorNulo(nombreTarifa,NOMBRE_VACIO);
            tipoTarifa.nombreTarifa = nombreTarifa;
            Validator.valorCero(valor,VALOR_TARIFA_NO_VALID);
            tipoTarifa.valor = valor;
            tipoTarifa.activo = activo;
            return tipoTarifa;
        }

    }



    public Integer getIdTarifa() {
        return idTarifa;
    }

    public String getNombreTarifa() {
        return nombreTarifa;
    }

    public double getValor() {
        return valor;
    }

    public boolean isActivo() {
        return activo;
    }
}
