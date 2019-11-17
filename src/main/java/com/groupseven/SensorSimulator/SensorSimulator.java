package com.groupseven.SensorSimulator;

import com.groupseven.floorPlan.Layout;

import java.awt.*;

import static com.groupseven.CleanSweeperRobot.loggerFactory;
import static com.groupseven.CleanSweeperRobot.logger;

public final class SensorSimulator implements AskPermission{

    private static SensorSimulator s;
    private static Layout layout;
    private AskPermission asker;
    private AskPermissionFactory askFact = new AskPermissionFactory();


    public static SensorSimulator getInstance(Layout l) {
        if (s == null)
            s = new SensorSimulator(l);
        return s;
    }

    private SensorSimulator(Layout layout) {
        this.layout = layout;
        logger = loggerFactory.build('m');
        logger.log("making Singleton Sensor Simulator", "SensorSimulator");
    }

    public String askType(Point p) {
        return layout.getCellType(p);
    }

    //  interface methods --- AskPermission
    public Boolean askDir(Point p, String dir) {
        asker = askFact.build(dir);
        return asker.askDir(p, dir);
    }

    public int currDirt(Point p) {
        return layout.getCellDirt(p);
    }

    public String getCellString(Point p) {
        return layout.getCellString(p);
    }

    public void updateDirt(Point p) {
        layout.setCellDirt(p, -1);
        return;
    }

    public int width() {
         return (int) layout.getNumCols();
    }

    public int height() {
        return (int) layout.getNumRows();
    }
}
