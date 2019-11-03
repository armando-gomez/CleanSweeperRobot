package com.groupseven.exceptions;

public class CanNotMoveException extends Exception {

    public CanNotMoveException(String s) {
        System.out.println("Robot can not move.\n Shutting down");
        System.exit(-1);
    }
}
