package it.unibo.oop.lab.mvcio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import it.unibo.oop.lab.mvcio.Controller;

public class ControllerExtended extends Controller {
    /**
     *
     * @return text reader from file
     * */
    public String getAllText() {
        String text = "";
        try (BufferedReader in = new BufferedReader(new FileReader(this.getFullPath()))) {
            String line = "";
            while ((line = in.readLine()) != null) {
                text = text.concat(line + "\n");
            }
        } catch (IOException exc) {
            exc.printStackTrace();

            final File file = new File(this.getFullPath());
            try {
                file.createNewFile();
            } catch (IOException e) {
               System.out.println("Non è stato possibile creare il file" + this.getFile());
                e.printStackTrace();
            }
        }
        System.out.println(text);
        return text;
    }
}
