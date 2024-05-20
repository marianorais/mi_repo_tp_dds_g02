package Usuario;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidadorContraseña {
    private static String[] top10000PasswordsWeak;

    public ValidadorContraseña() {
        try {
            top10000PasswordsWeak = getTop10000Passwords();
        } catch (IOException e) {
            System.out.println("Error al obtener la lista de las 10,000 contraseñas más comunes.");
            e.printStackTrace();
        }
    }

    private String[] getTop10000Passwords() throws IOException {
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

    private boolean isWeakPassword(String password) {

        return Arrays.asList(top10000PasswordsWeak).contains(password);

    }

    private boolean isStrongPassword(String password) {
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

    public boolean validarContrasenia(String password){
        boolean isWeakPassword = isWeakPassword(password);
        boolean isStrongPassword = isStrongPassword(password);

        return isStrongPassword && !isWeakPassword;

        //if (isWeakPassword) {
        //    System.out.println("La contraseña es débil, por favor elija una más segura.");
        //} else if (!isStrongPassword) {
        //    System.out.println("La contraseña no cumple con los requisitos de seguridad.");
        //} else {
        //    System.out.println("La contraseña es segura.");
    }
}
