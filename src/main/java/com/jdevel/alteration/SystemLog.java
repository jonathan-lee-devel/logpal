package com.jdevel.alteration;

import java.util.ArrayList;

/**
 * Log which contains all of the alterations performed on the system
 */
public class SystemLog {

    /**
     * List of all of the alterations performed
     */
    private ArrayList<Alteration> alterations;

    /**
     * Default constructor, simply initializes the alteration list to an empty list
     */
    public SystemLog() {
        this.setAlterations(new ArrayList<>());
    }

    /**
     * Add an alteration to the log
     * @param alteration to be added to the log
     */
    public void addAlteration(Alteration alteration) {
        this.getAlterations().add(alteration);
    }

    /**
     * Remove an alteration from the log
     * @param alteration to be removed from the log
     */
    public void removeAlteration(Alteration alteration) {
        this.getAlterations().remove(alteration);
    }

    /**
     * Getter for the alterations list
     * @return the alterations list
     */
    public ArrayList<Alteration> getAlterations() {
        return this.alterations;
    }

    /**
     * Setter for the alterations list, simply sets to the parameter passed
     * @param alterations alterations list to be set
     */
    private void setAlterations(ArrayList<Alteration> alterations) {
        this.alterations = alterations;
    }

}
