package src.main.java.com.groupseven.floorPlan;

public class Cell {
<<<<<<< HEAD
	private boolean north;
	private boolean south;
	private boolean east;
	private boolean west;
=======

	private String name;

	// variables to simulate if a cell is blocke in any direction
	private Boolean forward;
	private Boolean back;
	private Boolean right;
	private Boolean left;

	//  amount of dirt present in cell and what type of floor in cell
>>>>>>> f8f808240502be57c9a36a4018c671aaea097880
	private int dirt;
	private String type;
	private boolean hasChargingStation;
	private boolean hasRobot;

<<<<<<< HEAD
	public Cell(boolean north, boolean south, boolean east, boolean west, int dirt, String type) {
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
		this.dirt = dirt;
		this.type = type;
		this.hasChargingStation = false;
		this.hasRobot = false;
	}

	public Cell() {
		this.hasChargingStation = false;
		this.hasRobot = false;
=======
	// constructor
	public Cell(Boolean forward, Boolean back, Boolean right, Boolean left, int dirt, String type) {
		setForward(forward);
		setBack(back);
		setRight(right);
		setLeft(left);
		setDirt(dirt);
		setType(type);
	}

	// getters and setters, with checks
	public void setName(int i, int j) {
		name = "(" + Integer.toString(i);
		name += "," + Integer.toString(j) + ")";
>>>>>>> f8f808240502be57c9a36a4018c671aaea097880
	}

	public int getDirt() {
		return this.dirt;
	}

<<<<<<< HEAD
	public void setDirt(int dirt) {
		this.dirt = dirt;
=======
	//quick get of matrix coordinates
	public Point getCoords(String name) {
		char[] c = name.toCharArray();
		Point p = new Point(Character.getNumericValue(c[1]), Character.getNumericValue(c[3]));
		return p;
	}

	public void setForward(Boolean f) {
		this.forward = f;
>>>>>>> f8f808240502be57c9a36a4018c671aaea097880
	}

	public boolean getNorth() {
		return this.north;
	}

	public void setNorth(boolean north) {
		this.north = north;
	}

<<<<<<< HEAD
	public boolean getSouth() {
		return this.south;
	}

	public void setSouth(boolean south) {
		this.south = south;
	}

	public boolean getEast() {
		return this.east;
=======
	public Boolean getBack() {
		return this.back;
	}

	public void setRight(Boolean r) {
		this.right = r;
	}

	public Boolean getRight() {
		return this.right;
>>>>>>> f8f808240502be57c9a36a4018c671aaea097880
	}

	public void setEast(boolean east) {
		this.east = east;
	}

	public boolean getWest() {
		return this.west;
	}

<<<<<<< HEAD
	public void setWest(boolean west) {
		this.west = west;
	}
=======
	// method to be able change the amount of dirt in cell to change in simulation or on creation
	public void setDirt(int d) {
		try {
			if (d >= 0)
				dirt = d;
			else {
				throw new InvalidEntryException("Incorrect entry");
			}
		} catch (InvalidEntryException i) {
>>>>>>> f8f808240502be57c9a36a4018c671aaea097880

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

<<<<<<< HEAD
	public boolean checkHasChargingStation() {
		return this.hasChargingStation;
	}
=======
	public void setType(String t) {
		try {
			if (t.equals("bare") || t.equals("low") || t.equals("high"))
				type = t;
			else {
				throw new InvalidEntryException("Incorrect entry");
			}
		} catch (InvalidEntryException i) {
>>>>>>> f8f808240502be57c9a36a4018c671aaea097880

	public void setHasChargingStation(boolean chargingStation) {
		this.hasChargingStation = chargingStation;
	}

	public boolean checkHasRobot() {
		return this.hasRobot;
	}

<<<<<<< HEAD
	public void setHasRobot(boolean robot) {
		this.hasRobot = robot;
=======
	// toString() for logging and debugging
	@Override
	public String toString() {
		String b = "grid[";
		Point p = getCoords(name);
		b += Double.toString(p.getX()) + "][";
		b += Double.toString(p.getY()) + "]";
		String result = "Cell : " + this.name + " , forward : " + Boolean.toString(this.forward) +
				" , back : " + Boolean.toString(this.back) + " , left : " + Boolean.toString(this.left) +
				" , right : " + Boolean.toString(this.right) + " , dirt : " + Long.toString(this.dirt) +
				" , type : " + this.type + ", with coordinnates of " + b;
		return result;
>>>>>>> f8f808240502be57c9a36a4018c671aaea097880
	}

}
