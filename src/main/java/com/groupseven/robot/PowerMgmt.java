package com.groupseven.robot;

import com.groupseven.floorPlan.ConfigMngr;
import com.groupseven.floorPlan.Layout;

import java.awt.*;

import static com.groupseven.CleanSweeperRobot.robot;
import static com.groupseven.floorPlan.ConfigMngr.getValue;

public interface PowerMgmt {
    void changePower(Point p);
}

class PowerMgmtFactory {
    public PowerMgmt build(char c) {
        switch(c) {
            case 'c' :
                return new PowerMgmtCleanImpl();
            case 'm' :
                return new PowerMgmtMoveImpl();
            default :
                return new PowerMgmtImpl();
        }
    }
}

class PowerMgmtCleanImpl implements PowerMgmt {
    public void changePower(Point p) {

        char[] cs = Layout.getInstance().getCellType(p).toCharArray();

        System.out.println(robot.getCharge());
        Double num =  getValue(cs[0]);
        robot.setCharge(robot.getCharge() - num);
        System.out.println(robot.getCharge());
    }
}

class PowerMgmtMoveImpl implements PowerMgmt {
    public void changePower(Point p) {
        Point p2 = robot.getNxtPos();
        char[] cs1 = Layout.getInstance().getCellType(p).toCharArray();
        char[] cs2 = Layout.getInstance().getCellType(p2).toCharArray();

        Double one = getValue(cs1[0]);
        Double two = getValue(cs2[0]);


        System.out.println(robot.getCharge());
        robot.setCharge(robot.getCharge() - ((one + two) / 2.0 ));
        System.out.println(robot.getCharge());
    }
}

class PowerMgmtImpl implements PowerMgmt {
    public void changePower(Point p) {
        System.out.println("Done nothing");
    }
}
