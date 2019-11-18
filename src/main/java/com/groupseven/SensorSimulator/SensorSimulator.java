package com.groupseven.sensorsimulator;

import com.groupseven.floorplan.Layout;

import java.awt.*;

<<<<<<< HEAD
public class SensorSimulator {
	private static SensorSimulator sim;
	private Layout layout;

	public static SensorSimulator getInstance(Layout layout) {
		if(sim == null) {
			sim = new SensorSimulator(layout);
		}
		return sim;
	}

	private SensorSimulator(Layout layout) {
		this.layout = layout;
	}

	public Point getStartingPos() {
		return layout.getRobotStartingPos();
	}

	public boolean canMove(Point p, String dir) {
		return layout.getCellNeighbor(p, dir);
	}

	public String askType(Point p) {
		return layout.getCellType(p);
	}

	public boolean cellHasDirt(Point p) {
		return layout.cellHasDirt(p);
	}

	public void updateDirt(Point p) {
		layout.updateDirt(p, -1);
		return;
	}

	public int currDirt(Point p) {
		return layout.getDirt(p);
	}

	public int width() {
		return layout.getNumCols();
	}

	public int height() {
		return layout.getNumRows();
	}
=======
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
        layout.setCellDirt(p, layout.getCellDirt(p)-1);
        return;
    }

    public int width() {
         return (int) layout.getNumCols();
    }

    public int height() {
        return (int) layout.getNumRows();
    }

    public void getGrid() {
        layout.getGrid();
    }
}
