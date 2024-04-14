package validaciones;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordValidator {
    private static String[] top10000Passwords;

    public PasswordValidator() {
        try {
            top10000Passwords = getTop10000Passwords();
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

    public boolean isWeakPassword(String password) {

        return Arrays.asList(top10000Passwords).contains(password);

    }

    public boolean isStrongPassword(String password) {
        // Longitud mínima de 8 caracteres y maxima de 64
        int passwordLength = password.length();

        if (passwordLength < 8 || passwordLength > 64) {
            return false;
        }
        // Al menos un carácter en minúscula, uno en mayúscula y uno numérico
        boolean passwordIsValid = Pattern.compile("[a-zA-Z0-9]").matcher(password).find();

        if (!passwordIsValid) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la contraseña: ");
        String password = scanner.nextLine().trim();

        boolean isWeakPassword = validator.isWeakPassword(password);
        boolean isStrongPassword = validator.isStrongPassword(password);

        if (isWeakPassword) {
            System.out.println("La contraseña es débil, por favor elija una más segura.");
        } else if (!isStrongPassword) {
            System.out.println("La contraseña no cumple con los requisitos de seguridad.");
        } else {
            System.out.println("La contraseña es segura.");
        }
        scanner.close();
    }
}