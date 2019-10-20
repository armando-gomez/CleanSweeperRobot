
public class Layout {

	private long numRows;
	private long numCols;
	Cell[][] grid;

	{
		System.out.println("Initializing layout");
	}

	public void setNumRows(long rows) {
		try {
			if ( rows > 0 ) {
				numRows = rows;
			}
			else { 
				throw new InvalidEntryException("Invlid entry");
			}
				
		} catch (InvalidEntryException e) {
			e.printStackTrace();
		}
	}

	public long getNumRows() {
		return this.numRows;
	
	}

	public void setNumCols(long cols) {
		try {
			if ( cols > 0 )
				numCols = cols;
			else { 
				throw new InvalidEntryException("Invlid entry");
			}
		} catch (InvalidEntryException e) {
			e.printStackTrace();
		}
	}

	public long getNumCols() {
		return this.numCols;
	
	}
}
