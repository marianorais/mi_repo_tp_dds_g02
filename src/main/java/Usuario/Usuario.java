package Usuario;

import Formularios.Pregunta;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    String nombreUsuario;
    String contrasenia;
    //aca iria formulario
    ValidadorContraseña validadorContraseña;

    public Usuario(String nombreUsuario, String contrasenia, ValidadorContraseña validadorContraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.validadorContraseña = validadorContraseña;
    }
}
