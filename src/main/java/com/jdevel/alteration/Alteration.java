package com.jdevel.alteration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Alteration {

    /**
     * Unique identitfier for the alteration
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
     * List of ids which the alteration may reference, for example an 'uninstallation' may refer to the original 'installation'
     */
    private ArrayList<UUID> references;

    // private ... procedure;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<UUID> getReferences() {
        return references;
    }

    public void setReferences(ArrayList<UUID> references) {
        this.references = references;
    }

}
