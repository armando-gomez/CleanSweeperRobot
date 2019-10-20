
public class Cell {

	private String name;	

	// variables to simulate if a cell is blocke in any direction
	private Boolean forward;
	private Boolean back;
	private Boolean right;
	private Boolean left;

	//  amount of dirt present in cell and what type of floor in cell
	private int dirt;
	private String type;

	// constructor
	public Cell( Boolean forward, Boolean back, Boolean right, Boolean left,
			int dirt, String type) {
		setForward(forward);
		setBack(back);
		setRight(right);
		setLeft(left);
		setDirt(dirt);
		setType(type);
	}

	// getters and setters, with checks
	public void setName(int i, int j) {
		name += Integer.toString(i);
		name += Integer.toString(j);
	}

	public String getName() {
		return this.name;
	}
	public void setForward(Boolean f) {
		try {
			if(true || false) 
				forward = f;
			else {
				throw new InvalidEntryException("Incorrect entry");
			}
		} catch (InvalidEntryException i) {

			i.printStackTrace();
		}
	}

	public Boolean getForward() {
		return this.forward;
	}

	public void setBack(Boolean b) {
		try {
			if(true || false) 
				back = b;
			else {
				throw new InvalidEntryException("Incorrect entry");
			}
		} catch (InvalidEntryException i) {

			i.printStackTrace();
		}
	}

	public Boolean getBack() {

		return this.back;
	}
	public void setRight(Boolean r) {
		try {
			if(true || false) 
				right = r;
			else {
				throw new InvalidEntryException("Incorrect entry");
			}
		} catch (InvalidEntryException i) {

			i.printStackTrace();
		}
	}

	public Boolean geRight() {

		return this.right;
	}

	public void setLeft(Boolean l) {
		try {
			if(true || false) 
				left = l;
			else {
				throw new InvalidEntryException("Incorrect entry");
			}
		} catch (InvalidEntryException i) {

			i.printStackTrace();
		}
	}

	public Boolean getLeft() {

		return this.left;
	}
	public void setDirt(int d) {
		try {
			if(d >= 0) 
				dirt = d;
			else {
				throw new InvalidEntryException("Incorrect entry");
			}
		} catch (InvalidEntryException i) {

			i.printStackTrace();
		}
	}

	public int getDirt() {

		return this.dirt;
	}
	public void setType(String t) {
		try {
			if(t.equals("bare") || t.equals("low") || t.equals("high")) 
				type = t;
			else {
				throw new InvalidEntryException("Incorrect entry");
			}
		} catch (InvalidEntryException i) {

			i.printStackTrace();
		}
	}

	public String getType() {

		return this.type;
	}

	// toString() for logging and debugging
	@Override
	public String toString() {
		String result = "Cell : " + name + " ,forward : " + Boolean.toString(forward) + 
			" ,back : " + Boolean.toString(back) + " ,left : " + Boolean.toString(left) + 
			" ,right : "+ Boolean.toString(right) + " ,dirt : " + Integer.toString(dirt) +
			" ,type : " + type;
		return result; 
	}

}
