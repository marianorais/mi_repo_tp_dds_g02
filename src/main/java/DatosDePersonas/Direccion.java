package DatosDePersonas;

public class Direccion {
    private Integer altura;
    private Calle calle; //Aylu dijo que tener la calle como clase nos va a servir en el futuro para algo que ahora no me acuerdo.


    public Direccion(Integer altura, Calle calle) {
        this.altura = altura;
        this.calle = calle;
    }
}
