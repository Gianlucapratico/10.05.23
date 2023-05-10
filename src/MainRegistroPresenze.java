
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class MainRegistroPresenze {
    public static void main(String[] args) {
        // crea un nuovo oggetto RegistroPresenze
        RegistroPresenze registro = new RegistroPresenze();

        // aggiunge alcune presenze
        registro.aggiungiPresenza("Mario Rossi", 5);
        registro.aggiungiPresenza("Giorgio Bianchi", 7);
        registro.aggiungiPresenza("Gianni Verdi", 7);
        registro.aggiungiPresenza("Gianni Verdi", 7);

        // salva le presenze su un file
        File file = new File("presenze.txt");
        try {
            FileUtils.writeStringToFile(file, registro.toString(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // carica le presenze da un file
        try {
            String fileContents = FileUtils.readFileToString(file, "UTF-8");
            RegistroPresenze registro2 = RegistroPresenze.fromString(fileContents);
            System.out.println(registro2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

