package co.com.k4soft.parqueadero.util;

import co.com.k4soft.parqueadero.model.exception.BusinessException;

import java.util.Date;

public class Validator {


    public static void valorNulo(Integer valor, String mensaje) throws BusinessException {
        if(valor == null){
            throw new BusinessException(mensaje);
        }
    }

    public static void valorNulo(String valor, String mensaje) throws BusinessException {
        if(valor == null){
            throw new BusinessException(mensaje);
        }
    }

    public static void valorCero(double valor, String mensaje) throws BusinessException {
        if(valor == 0){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarObjetoNulo(Object object, String mensaje) throws BusinessException {
        if(object == null){
            throw new BusinessException(mensaje);
        }
    }


    public static void validarFechaNula(Date fecha, String mensaje) throws BusinessException {
        if(fecha == null){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarIgualCero(double valor, String mensaje) {
        if(valor == 0){
            throw new BusinessException(mensaje);
        }
    }
}
