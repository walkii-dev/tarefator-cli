package org.educational;

public enum TaskStatus {
    TODO("to do"),
    IN_PROGRESS("in progress"),
    DONE("done");

    public final String description;

    private TaskStatus(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public static TaskStatus byDescription(String description) {
        for (TaskStatus status : values()){
            if (status.description.contains(description)){
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid description: "+description);
    }




}
