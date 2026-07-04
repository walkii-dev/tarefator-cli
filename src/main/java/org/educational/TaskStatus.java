package org.educational;

public enum TaskStatus {
    TODO("to do"),
    IN_PROGRESS("in progress"),
    DONE("done");

    public final String description;

    private TaskStatus(String description){
        this.description = description;
    }







}
