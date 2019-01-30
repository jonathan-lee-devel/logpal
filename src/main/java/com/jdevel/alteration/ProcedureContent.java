package com.jdevel.alteration;

import java.util.ArrayList;

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

    public ProcedureContent() {

    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public boolean addBody(String body) {
        return this.bodies.add(body);
    }

    public boolean removeBody(String body) {
        return this.bodies.remove(body);
    }

    public ArrayList<String> getBodies() {
        return this.bodies;
    }

    public void setBodies(ArrayList<String> bodies) {
        this.bodies = bodies;
    }

}
