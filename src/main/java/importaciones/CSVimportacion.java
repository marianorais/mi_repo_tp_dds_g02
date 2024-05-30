package importaciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CSVimportacion {

    public void importData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String separator = ",";
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] data = line.split(separator);

                System.out.println(data[0]);
                // Imprimir todos los datos
                System.out.println(Arrays.toString(data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
