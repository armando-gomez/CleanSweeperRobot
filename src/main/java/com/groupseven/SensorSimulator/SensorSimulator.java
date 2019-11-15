package com.groupseven.SensorSimulator;

import com.groupseven.floorPlan.Layout;

import java.awt.*;

import static com.groupseven.CleanSweeperRobot.loggerFactory;
import static com.groupseven.CleanSweeperRobot.logger;

public final class SensorSimulator implements AskPermission{

    private static SensorSimulator s;
    private static Layout l;
    private AskPermission asker;
    private AskPermissionFactory askFact = new AskPermissionFactory();


    public static SensorSimulator getInstance(Layout l) {
        if (s == null)
            s = new SensorSimulator(l);
        return s;
    }

    private SensorSimulator(Layout l) {
        this.l = l;
        logger = loggerFactory.build('m');
        logger.log("making Singleton Sensor Simulator", "SensorSimulator");
    }


    public String askType(Point p) {
        return l.getCellType(p);
    }

    //  interface methods --- AskPermission
    public Boolean askDir(Point p, String dir) {
        asker = askFact.build(dir);
        return asker.askDir(p, dir);

    }
}
