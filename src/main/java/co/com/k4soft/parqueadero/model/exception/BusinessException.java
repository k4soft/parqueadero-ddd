package co.com.k4soft.parqueadero.model.exception;

public class BusinessException extends RuntimeException{

    public BusinessException(String mensaje){
        super(mensaje);
    }

}
