package com.groupseven.logger;

import com.groupseven.floorPlan.Layout;

import java.awt.*;

import static com.groupseven.CleanSweeperRobot.pr;
import static com.groupseven.floorPlan.ConfigMngr.getDate;


public interface Logger {

    void log(String txt, String loc);
}


class LoggerDirtyImpl implements Logger{
    public void log(String txt, String loc) {
        String[] ss = txt.split(",");
        Point p = new Point();
        p.x = Integer.parseInt(ss[0]);
        p.y = Integer.parseInt(ss[1]);
        pr.println(loc + " updated " + ss[2] + " unit(s) of dirt to " + Layout.getInstance().getCellName(p) + " on " + getDate());
        System.out.println(loc + " updated " + ss[2] + " units of dirt to " + Layout.getInstance().getCellName(p) + " on " + getDate());
    }
}

class LoggerMakingImpl implements Logger{
    public void log(String txt, String loc) {
        pr.println(loc + " initialized " + txt + " on " + getDate());
        System.out.println(loc + " initialized " + txt + " on " + getDate());
    }
}

class LoggerMaking2Impl implements Logger {
    public void log(String txt, String loc) {
        String[] ss = txt.split(",");
        if (ss.length > 0) {
            String txt2 = "";
            for (int i = 2; i < (Integer.parseInt(ss[0]) * 2) + 2; i++) {
                Double d = Double.parseDouble(ss[i]);
                txt2 += "(" + d.intValue() + ",";
                i++;
                d = Double.parseDouble(ss[i]);
                txt2 += d.intValue() + "),";
            }
            pr.println(loc + " initialized " + ss[1] + " on Cells " + txt2 + " on " + getDate());
            System.out.println(loc + " initialized " + ss[1] + " on Cells " + txt2 + " on " + getDate());
        } else {
            pr.println(loc + " initialized " + txt + " on " + getDate());
            System.out.println(loc + " initialized " + txt + " on " + getDate());
        }
    }
}


class LoggerReadingImpl implements Logger {
    public void log(String txt, String loc) {
        pr.println(loc + " is reading " + txt + " on " + getDate());
        System.out.println(loc + " is reading " + txt + " on " + getDate());
    }
}
class LoggerPowerChangeImpl implements Logger {
    public void log(String txt, String loc) {
        pr.println(loc + " is changing power from " + txt + " on " + getDate());
        System.out.println(loc + " is changing power from "  + txt + " on " + getDate());
    }
}
class LoggerShutdownImpl implements Logger {
    public void log(String txt, String loc) {
        pr.println(loc + " is shutting down " + txt + " on " + getDate() + "\n\nEnd\n\n");
        System.out.println(loc + " is shutting down " + txt + " on " + getDate() + "\n\n");
    }
}

class LoggerDoorChangeImpl implements Logger {
    public void log(String txt, String loc) {
        pr.println(loc + " is changing door  " + txt + " on " + getDate());
        System.out.println(loc + " is changing door " + txt + " on " + getDate());
    }
}

class LoggerNotImpl implements Logger{
    public void log(String txt, String loc) {
        pr.println("nothing");
        System.out.println("nothing");
    }
}

class LoggerMoveImpl implements Logger{
    public void log(String txt, String loc) {
        pr.println(loc + " is moving from " + txt + " on " + getDate());
        System.out.println(loc + " is moving" + txt + " on " + getDate());
    }
}