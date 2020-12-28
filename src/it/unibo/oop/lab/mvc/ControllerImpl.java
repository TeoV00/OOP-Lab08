package it.unibo.oop.lab.mvc;

import java.util.ArrayList;
import java.util.List;

public final class ControllerImpl implements Controller {

    private final List<String> history;
    private String nextToPrint;

    public ControllerImpl() {
        this.history = new ArrayList<>();
        this.nextToPrint = null;
    }

    @Override
    public void setNextString(final String nextString) {
        if (nextString != null) {
            this.nextToPrint = nextString;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String getStringToPrint() {
        return this.nextToPrint;
    }

    @Override
    public List<String> getPrintHistory() {
        return new ArrayList<>(this.history);
    }

    @Override
    public void printCurrentString() {
        if (this.nextToPrint != null) {
        System.out.println(this.nextToPrint);
        this.history.add(this.nextToPrint);
        } else {
            throw new IllegalStateException();
        }
    }

}
