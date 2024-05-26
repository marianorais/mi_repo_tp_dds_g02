package Excepciones;

public class ValidadorContraseñaException extends Exception{
    public ValidadorContraseñaException(String mensaje) {
        super(mensaje);
    }
}
