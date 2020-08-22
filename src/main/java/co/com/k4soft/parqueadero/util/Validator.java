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
}
