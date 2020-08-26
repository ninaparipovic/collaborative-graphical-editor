import java.awt.Color;
/**
 * takes string commands and makes changes to sketches
 * @author ninaparipovic
 *
 */

public class StringConverter {
	Sketch sketch;
	Integer dragID = -1;
	

	public StringConverter(Sketch sketch) {
		this.sketch = sketch;
	}
	/**
	 * takes a string command and alters the sketch 
	 * @param str
	 */
	public void updateSketch(String str) {
		String[] tokens = str.split(" ");
		
		// drag the shape
		if (tokens[0].equals("drag")) {
			System.out.println(str);
			int dragId = Integer.parseInt(tokens[1]);
			int pX = Integer.parseInt(tokens[2]); int pY = Integer.parseInt(tokens[3]);
			int moveFromX = Integer.parseInt(tokens[4]); int moveFromY = Integer.parseInt(tokens[5]);
			System.out.println(sketch.getShape(dragId).toString());
			sketch.getShape(dragId).moveBy(pX - moveFromX, pY - moveFromY);
		}
		// add the shape to the sketch
		if (tokens[0].equals("add")) {
			if (tokens[1].equals("rectangle")) {
				int x1 = Integer.parseInt(tokens[2]); int y1 = Integer.parseInt(tokens[3]);
				int x2 = Integer.parseInt(tokens[4]); int y2 = Integer.parseInt(tokens[5]);
				Color color = new Color(Integer.parseInt(tokens[6]));
				Shape rectangle = new Rectangle(x1, y1, x2, y2, color);
				sketch.addShape(rectangle);
			}
			else if (tokens[1].equals("ellipse")) {
				int x1 = Integer.parseInt(tokens[2]); int y1 = Integer.parseInt(tokens[3]);
				int x2 = Integer.parseInt(tokens[4]); int y2 = Integer.parseInt(tokens[5]);
				Color color = new Color(Integer.parseInt(tokens[6]));
				Shape ellipse = new Ellipse(x1, y1, x2, y2, color);
				sketch.addShape(ellipse);
			}
			else if (tokens[1].equals("segment")) {
				int x1 = Integer.parseInt(tokens[2]); int y1 = Integer.parseInt(tokens[3]);
				int x2 = Integer.parseInt(tokens[4]); int y2 = Integer.parseInt(tokens[5]);
				Color color = new Color(Integer.parseInt(tokens[6]));
				Shape segment = new Segment(x1, y1, x2, y2, color);
				sketch.addShape(segment);
			}
		}
		// change the color of the shape 
		if (tokens[0].equals("color")) {
			int id = Integer.parseInt(tokens[1]);
			Color color = new Color(Integer.parseInt(tokens[2]));
			sketch.getShape(id).setColor(color);
			System.out.println("here");

		}
		// remove the shape
		if (tokens[0].equals("delete")) {
			int id = Integer.parseInt(tokens[1]);
			sketch.deleteShape(id);
		}
	}	
}
