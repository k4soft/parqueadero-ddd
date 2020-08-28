package co.com.k4soft.parqueadero.model;

import co.com.k4soft.parqueadero.model.exception.BusinessException;
import co.com.k4soft.parqueadero.util.DateUtil;
import co.com.k4soft.parqueadero.util.Validator;

import java.util.Date;

public class Movimiento {

    public static final String FECHA_INGRESO_REQUERIDA = "La fecha de ingreso es requerida";
    public static final String FECHA_SALIDA_REQUERIDA = "La fecha de salida es requerida";
    public static final String PLACA_REQUERIDA = "La placa es requerida" ;
    public static final String TARIFA_NO_CONFIGURADA = "La tarifa no está configurada";
    public static final String VALOR_TARIFA_ES_REQUERIDO = "El valor de la tarifa es requerido";

    private Integer idMoviento;
    private Date fechaIngreso;
    private Date fechaSalida;
    private String placa;
    private TipoTarifa tipoTarifa;
    private double totalPagar;


    private Movimiento(){
        super();
    }


    public static class MovimientoBuilder{


        private Integer idMoviento;
        private Date fechaIngreso;
        private Date fechaSalida;
        private String placa;
        private TipoTarifa tarifa;
        private double totalPagar;

        public MovimientoBuilder setIdMoviento(Integer idMoviento) {
            this.idMoviento = idMoviento;
            return this;
        }

        public MovimientoBuilder setFechaIngreso(Date fechaIngreso) {
            this.fechaIngreso = fechaIngreso;
            return this;
        }

        public MovimientoBuilder setFechaSalida(Date fechaSalida) {
            this.fechaSalida = fechaSalida;
            return this;
        }

        public MovimientoBuilder setPlaca(String placa) {
            this.placa = placa;
            return this;
        }

        public MovimientoBuilder setTipoTarifa(TipoTarifa tarifa) {
            this.tarifa = tarifa;
            return this;
        }

        public Movimiento build() throws BusinessException {
            Movimiento movimiento = new Movimiento();
            movimiento.idMoviento = this.idMoviento;
            Validator.validarFechaNula(fechaIngreso,FECHA_INGRESO_REQUERIDA);
            movimiento.fechaIngreso = this.fechaIngreso;
            Validator.validarFechaNula(fechaSalida,FECHA_SALIDA_REQUERIDA);
            movimiento.fechaSalida = this.fechaSalida;
            Validator.valorNulo(placa,PLACA_REQUERIDA);
            Validator.valorNulo(placa,PLACA_REQUERIDA);
            movimiento.placa = this.placa;
            Validator.validarObjetoNulo(tarifa,TARIFA_NO_CONFIGURADA);
            Validator.validarIgualCero(tarifa.getValor(),VALOR_TARIFA_ES_REQUERIDO);
            movimiento.tipoTarifa = this.tarifa;
            movimiento.totalPagar = movimiento.calcularValorTotal();
            return movimiento;
        }

    }




    public double calcularValorTotal() {
        double horas = (DateUtil.minutesDiff(fechaIngreso,fechaSalida));
        return  tipoTarifa.getValor() * (horas < 1?1:horas);
    }

    public Integer getIdMoviento() {
        return idMoviento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public String getPlaca() {
        return placa;
    }

    public TipoTarifa getTipoTarifa() {
        return tipoTarifa;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    
}
