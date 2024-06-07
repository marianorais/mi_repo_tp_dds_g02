package Excepciones;

public class LimiteDiarioAlcanzadoException extends Exception{
    public LimiteDiarioAlcanzadoException(String mensaje) {
        super(mensaje);
    }
}
