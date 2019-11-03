package com.groupseven.logger;

import java.io.IOException;

public interface Logger {

    void log(String txt, String loc);
}

class LoggerMakingImpl implements Logger{

    public void log(String txt, String loc) {
        System.out.println(txt + " in " + loc);
    }
}
class LoggerNotImpl implements Logger{

    public void log(String txt, String loc) {
        System.out.println("nothing");
    }
}