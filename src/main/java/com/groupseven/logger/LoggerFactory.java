package com.groupseven.logger;

public class LoggerFactory {

    public Logger build(char c) {
        switch(c) {
            case 'm' :
                return new LoggerMakingImpl();
            default :
                return new LoggerNotImpl();
        }
    }
}
