package importaciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVimportacion {

    public void importData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                System.out.println(data[0]);
                System.out.println(data);
            }
        } catch (IOException e) {
            //TODO: MANEJO DE ERRORES
            e.printStackTrace();
        }
    }
}
