package com.groupseven.SensorSimulator;

import com.groupseven.floorPlan.Layout;

import java.awt.*;

public interface AskPermission {

    Boolean askDir(Point p, String dir);


}

class AskPermissionFactory {

    public AskPermission build( String dir) {
        char[] cs = dir.toCharArray();
        char d = cs[0];
        switch (d) {
            case 'l' :
                return new AskPermissionLeftImpl();
            case 'r' :
                return new AskPermissionRightImpl();
            case 'f' :
                return new AskPermissionForwardImpl();
            case 'b' :
                return new AskPermissionBackImpl();
            default:
                return new AskPermissionInvalidImpl();
        }
    }

}

class AskPermissionRightImpl implements AskPermission {

    public Boolean askDir(Point p, String dir) {
        return Layout.getInstance().getCellRight(p);
    }
}

class AskPermissionLeftImpl implements AskPermission {

    public Boolean askDir(Point p, String dir) {
        return Layout.getInstance().getCellLeft(p);
    }
}

class AskPermissionForwardImpl implements AskPermission {

    public Boolean askDir(Point p, String dir) {
        return Layout.getInstance().getCellForward(p);
    }

}

class AskPermissionBackImpl implements AskPermission {

    public Boolean askDir(Point p, String dir) {
        return Layout.getInstance().getCellBack(p);
    }
}

class AskPermissionInvalidImpl implements AskPermission {

    public Boolean askDir(Point p, String dir) {
        return false;
    }
}

