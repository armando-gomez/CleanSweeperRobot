package com.groupseven.logger;

public class LoggerFactory {

    public Logger build(char c) {
        switch(c) {
            case 'd' :
                return new LoggerDirtyImpl();
            case 'm' :
                return new LoggerMakingImpl();
            case 'z' :
                return new LoggerMaking2Impl();
            case 'r' :
                return new LoggerReadingImpl();
            case 's' :
                return new LoggerShutdownImpl();
            case 'c' :
                return new LoggerDoorChangeImpl();
            case 'p' :
                return new LoggerPowerChangeImpl();
            default :
                return new LoggerNotImpl();
        }
    }
}
