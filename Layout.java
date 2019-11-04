
public class Layout {

	private long numRows;
	private long numCols;
	Cell[][] grid;

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
	
	public void populateGrid(Cell[] g) {
		int k = 0;
		for (int z = 0; z < g.length; z++)
		grid = new Cell[(int) numRows][(int) numCols];
		for (int i = (int)numRows-1; i >= 0; i--) {
			for ( int j = 0; j < numCols; j++, k++) {
				g[k].setName(i,j);
				grid[i][j] = g[k];
				System.out.println(grid[i][j].toString());
			}
		}
	}
}
