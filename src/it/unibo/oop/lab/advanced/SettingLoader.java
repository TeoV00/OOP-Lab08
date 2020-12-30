package it.unibo.oop.lab.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SettingLoader {

    private static final String COLON = ":";
    private static final String SPACE = " ";
    private static final String MIN_TAG = "minimum";
    private static final String MAX_TAG = "maximum";
    private static final String ATTEMP_TAG = "attempts";
    private int min;
    private int max;
    private int attemps;

    public SettingLoader(){
        final InputStream inStream = ClassLoader.getSystemResourceAsStream("config.yml");
        
        try ( BufferedReader in = new BufferedReader(new InputStreamReader(inStream))) {
            String line = in.readLine();
            while (line != null) {
                if(line.startsWith(MIN_TAG)) {
                    this.min = this.getValueFromLine(line, MIN_TAG);
                }
                if(line.startsWith(MAX_TAG)) {
                    this.max = this.getValueFromLine(line, MAX_TAG);
                }
                if(line.startsWith(ATTEMP_TAG)) {
                    this.attemps = this.getValueFromLine(line, ATTEMP_TAG);
                }
                line = in.readLine();
            }
        }
        catch (IOException ioExc) {
            ioExc.printStackTrace();
        }
        System.out.println("min: " + this.min + ", max: " + this.max + ", attemps: " + this.attemps);
    }

    private int getValueFromLine(final String line, final String targetTag) {
        return Integer.parseInt(line.replace(targetTag + COLON, "").replaceAll(SPACE, ""));
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
