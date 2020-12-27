package it.unibo.oop.lab.mvcio;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 */
public class Controller {
    /**
     * 
     */
    private static final String DEFAULT_NAME = "output.txt";
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String USER_HOME = System.getProperty("user.home");

    private String fileName;

    public Controller() {
        this.fileName = DEFAULT_NAME;
    }

    public void setFile(final String fileName) {
        this.fileName = fileName;
    }

    public String getFile() {
        return this.fileName;
    }

    public String getFullPath() {
        return USER_HOME + SEPARATOR + this.fileName;
    }
    /**
     * @param textToSave
     * */
    public void saveOnFile(final String textToSave) throws IOException{
        final FileWriter writer = new FileWriter(this.getFullPath());
        writer.write(textToSave);
        writer.close();
    }
    /*
     * This class must implement a simple controller responsible of I/O access. It
     * considers a single file at a time, and it is able to serialize objects in it.
     * 
     * Implement this class with:
     * 
     * 1) A method for setting a File as current file
     * 
     * 2) A method for getting the current File
     * 
     * 3) A method for getting the path (in form of String) of the current File
     * 
     * 4) A method that gets a String as input and saves its content on the current
     * file. This method may throw an IOException.
     * 
     * 5) By default, the current file is "output.txt" inside the user home folder.
     * A String representing the local user home folder can be accessed using
     * System.getProperty("user.home"). The separator symbol (/ on *nix, \ on
     * Windows) can be obtained as String through the method
     * System.getProperty("file.separator"). The combined use of those methods leads
     * to a software that runs correctly on every platform.
     */

}
