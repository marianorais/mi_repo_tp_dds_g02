package importaciones;

import DatosDePersonas.Documento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class CSVimportacion {

    public void importData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String separator = ",";
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] data = line.split(separator);

                String documento =  data[0]; //Enum tipo documento
                String nroDoc = data[1];
                String nombre = data[2];
                String apellido = data[3];
                String email = data[4];
                String fecha = data[5]; //Datetime fecha agregado
                String donacion = data[6]; //Tipo de donacion
                String cantidad = data[7]; //Cantidad donacion

                //Normalizo datos
                Documento documentoEnum = Documento.valueOf(documento.toUpperCase());
                LocalDate fechaRegistro = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                int cantidadTotal = Integer.parseInt(cantidad);

                // Imprimir todos los datos
                System.out.println(Arrays.toString(data));

                //TODO GUARDADO DE DATOS
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
