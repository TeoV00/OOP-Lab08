package it.unibo.oop.lab.advanced;

import java.io.IOException;

public class SettingLoader {

    private int min;
    private int max;
    private int attemps;

    public SettingLoader(final String configFilePath){
        try(){
            
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
