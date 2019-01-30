package com.jdevel.alteration;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Actual content for the procedure, consisting of a header,
 * as well as a list of strings for the body to allow for multiple lines
 */
public class ProcedureContent {

    /**
     * Header or descriptor for the content, e.g. 'command'
     */
    private String header;

    /**
     * Body of the content, e.g. "git clone git@github.com:jonathan-lee-devel/msal"
     */
    private ArrayList<String> bodies;

    /**
     * Default Constructor, simply initializes members to non-null values
     */
    public ProcedureContent() {
        this.header = "";
        this.bodies = new ArrayList<>();
    }

    /*
     * List Access Methods
     */

    /**
     * Adds body to bodies list
     * @param body body to be added
     * @return success flag
     */
    public boolean addBody(String body) {
        return this.bodies.add(body);
    }

    /**
     * Removes body from bodies list
     * @param body body to be removed
     * @return success flag
     */
    public boolean removeBody(String body) {
        return this.bodies.remove(body);
    }

    /**
     * Getter for ListIterator for bodies ArrayList
     * @return ListIterator for bodies ArrayList
     */
    public ListIterator<String> getBodiesIterator() {
        return this.getBodies().listIterator();
    }

    /*
     * Getters and Setters
     */

    /**
     * Getter for the header
     * @return the header
     */
    public String getHeader() {
        return this.header;
    }

    /**
     * Setter for the header
     * @param header header to be set
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * Getter for bodies ArrayList
     * @return bodies ArrayList
     */
    private ArrayList<String> getBodies() {
        return this.bodies;
    }

    /**
     * Setter for bodies ArrayList
     * @param bodies bodies ArrayList to be set
     */
    private void setBodies(ArrayList<String> bodies) {
        this.bodies = bodies;
    }

}
