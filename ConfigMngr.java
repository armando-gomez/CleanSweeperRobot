import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;
import java.util.Iterator;


public class ConfigMngr {

	private JSONParser parser;
	private JSONObject o;
	private JSONArray jArray;
	private FileReader in;
	private String fileName;
	private Layout layout;
	private Cell[] cell;
	private Iterator<JSONObject> iterator;

	public ConfigMngr(String s) { 
		this.fileName = s;
		parser = new JSONParser();
		layout = new Layout();
		try {
			in = new FileReader(s);
			o = (JSONObject) parser.parse(in);
			layout.setNumRows( (long) o.get("numRows") );	
			layout.setNumCols( (long) o.get("numCols") );	
			jArray = (JSONArray) o.get("cells");
			iterator = jArray.iterator();
			long l = layout.getNumRows() * layout.getNumCols();
			cell = new Cell[(int) l];
			int i = 0;
			while (iterator.hasNext()) {
				JSONObject n = iterator.next();
				cell[i] = new Cell((Boolean) n.get("forward"),(Boolean) n.get("back"),(Boolean)  n.get("right"),(Boolean)  n.get("left"), (Long) n.get("dirt"), (String) n.get("type"));
				i++;
			}
			layout.populateGrid(cell);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}


}
