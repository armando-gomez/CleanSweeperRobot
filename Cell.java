
public class Cell {

	private String name;	

	// variables to simulate if a cell is blocke in any direction
	private Boolean forward;
	private Boolean back;
	private Boolean right;
	private Boolean left;

	//  amount of dirt present in cell and what type of floor in cell
	private long dirt;
	private String type;

	// constructor
	public Cell( Boolean forward, Boolean back, Boolean right, Boolean left,
			long dirt, String type) {
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
		name += "," + Integer.toString(j)+ ")";
	}

	public String getName() {
		return this.name;
	}
	public void setForward(Boolean f) {
		this.forward = f;
	}

	public Boolean getForward() {
		return this.forward;
	}

	public void setBack(Boolean b) {
		this.back = b;
	}

	public Boolean getBack() {

		return this.back;
	}
	public void setRight(Boolean r) {
				this.right = r;
	}

	public Boolean geRight() {

		return this.right;
	}

	public void setLeft(Boolean l) {
				this.left = l;
	}

	public Boolean getLeft() {

		return this.left;
	}
	public void setDirt(long d) {
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

	public long getDirt() {

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
		System.out.println("printing");
		String result = "Cell : " + this.name + " , forward : " + Boolean.toString(this.forward) + 
			" , back : " + Boolean.toString(this.back) + " , left : " + Boolean.toString(this.left) + 
			" , right : "+ Boolean.toString(this.right) + " , dirt : " + Long.toString(this.dirt) +
			" , type : " + this.type;
		return result; 
	}

}

