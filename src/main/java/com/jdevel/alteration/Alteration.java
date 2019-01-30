package com.jdevel.alteration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.UUID;

/**
 * Defines an alteration performed on a system,
 * contains information about the alteration such as date and time that it was performed
 */
public class Alteration {

    /**
     * Unique identifier for the alteration, intended to be set by the SystemLog as it is being added
     */
    private UUID id;

    /**
     * Date & time at which the alteration was performed
     */
    private LocalDateTime dateTime;

    /**
     * Title or name for the alteration
     */
    private String title;

    /**
     * Type of alteration, for example 'installation' or 'configuration'
     */
    private String type;

    /**
     * Detailed procedure involved to perform the alteration
     */
    private Procedure procedure;

    /**
     * List of ids which the alteration may reference, for example an 'uninstallation' may refer to the original 'installation'
     */
    private ArrayList<UUID> references;

    /*
     * List Access Methods
     */

    /**
     * Add a reference to the references ArrayList
     * @param reference reference to be added to the list
     * @return success flag
     */
    public boolean addReference(UUID reference) {
        return this.getReferences().add(reference);
    }

    /**
     * Remove a reference from the references ArrayList
     * @param reference reference to be removed from the references ArrayList
     * @return success flag
     */
    public boolean removeReference(UUID reference) {
        return this.getReferences().remove(reference);
    }

    /**
     * Getter for ListIterator for the references ArrayList
     * @return ListIterator for the references ArrayList
     */
    public ListIterator<UUID> getReferencesIterator() {
        return this.getReferences().listIterator();
    }

    /*
     * Getters and Setters
     */

    /**
     * Getter for id
     * @return id
     */
    public UUID getId() {
        return id;
    }

    /**
     * Setter for id
     * @param id id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Getter for dateTime
     * @return dateTime
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Setter for dateTime
     * @param dateTime dateTime to set
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Getter for title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for title
     * @param title title to be set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for type
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for type
     * @param type type to be set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter for procedure
     * @return procedure
     */
    public Procedure getProcedure() {
        return this.procedure;
    }

    /**
     * Setter for procedure
     * @param procedure procedure to set
     */
    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    /**
     * Getter for references
     * @return references
     */
    private ArrayList<UUID> getReferences() {
        return references;
    }

    /**
     * Setter for references
     * @param references references to be set
     */
    private void setReferences(ArrayList<UUID> references) {
        this.references = references;
    }

}
