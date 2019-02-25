package com.ifpb.control.commands;

public class CommandException extends Exception {

    private int statuscode;

    public CommandException(int statuscode, String message) {
        super(message);
        this.statuscode = statuscode;
    }

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

}
