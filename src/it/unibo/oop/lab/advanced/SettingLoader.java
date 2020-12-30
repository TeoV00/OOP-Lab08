package it.unibo.oop.lab.advanced;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SettingLoader {

    private int min;
    private int max;
    private int attemps;

    public SettingLoader(){
        try(InputStream in = new BufferedInputStream(ClassLoader.getSystemResourceAsStream("res/config.yml"))){
            while 
        }
        catch (IOException ioExc) {
            ioExc.printStackTrace();
        }
    }

    public int getAttempts() {
        return this.attemps;
    }
    
    public int getMax() {
        return this.max;
    }
    
    public int getMin() {
        return this.min;
    }
    
}
