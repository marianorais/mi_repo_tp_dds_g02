package validaciones;

import Excepciones.ValidadorContraseñaException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidadorContraseña {
    private static String[] top10000ContraseñasDebil;

    public ValidadorContraseña() {
        try {
            top10000ContraseñasDebil = obtenerTop10000ContraseniasDebil();
        } catch (IOException e) {
            System.out.println("Error al obtener la lista de las 10,000 contraseñas más comunes.");
            e.printStackTrace();
        }
    }

    private String[] obtenerTop10000ContraseniasDebil() throws IOException {
        String filePath = "documentacion/top-10000-weak-passwords.txt";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
        Scanner scanner = new Scanner(inputStream);
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNext()) {
            stringBuilder.append(scanner.next()).append("\n");
        }
        scanner.close();
        return stringBuilder.toString().split("\n");
    }

    private boolean esContraseñaDebil(String password) {

        return Arrays.asList(top10000ContraseñasDebil).contains(password);

    }

    private boolean esContraseñaFuerte(String password) {
        // Longitud mínima de 8 caracteres y maxima de 64
        int passwordLength = password.length();

        if (passwordLength < 8 || passwordLength > 64) {
            return false;
        }
        // Al menos un carácter en minúscula, uno en mayúscula y uno numérico
        if (!Pattern.compile("[a-z]").matcher(password).find() ||
                !Pattern.compile("[A-Z]").matcher(password).find() ||
                !Pattern.compile("[0-9]").matcher(password).find())
        {
            return false;
        }

        return true;
    }

    public boolean validarContrasenia(String password) throws ValidadorContraseñaException {

        boolean esContraseñaDebil = esContraseñaDebil(password);
        boolean esContraseñaFuerte = esContraseñaFuerte(password);

        if (esContraseñaFuerte && !esContraseñaDebil) {
            return true;
        } else {
            throw new ValidadorContraseñaException("La contraseña no cumple con los requisitos de seguridad.");
        }
    }
}
