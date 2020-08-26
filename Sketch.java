import java.awt.Point;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
/**
 * holds all the shapes 
 * @author ninaparipovic
 *
 */

public class Sketch {
	public TreeMap<Integer, Shape> shapes;
	public Integer currID;
	
	public Sketch() {
		shapes = new TreeMap<Integer, Shape>();
		currID = 0;
	}
	/**
	 * adds shape to sketch and increments ID
	 * @param shape
	 */
	public synchronized void addShape(Shape shape) {
		shapes.put(currID, shape);
		currID +=1;
	}
	/**
	 * 
	 * @param idNumber
	 * @return shape of that idNumber
	 */
	public synchronized Shape getShape(Integer idNumber) {
		return shapes.get(idNumber);
	}
	/**
	 * removes shape from the sketch 
	 * @param idNumber
	 */
	public synchronized void deleteShape(Integer idNumber) {
		shapes.remove(idNumber);
	}
	/**
	 * finds and returns on the shape if the mouse pressed on it 
	 * @param Point p
	 * @return id if clicked on the shape, else null 
	 */
	public synchronized Integer pressedShape(Point p) {
		// set of ID's from largest ID (newest shapes) to smallest ID (older shapes)
		Set<Integer> keySet = shapes.descendingKeySet();
		for (Integer id: keySet) {
			// if shape contains the point, return the ID number
			if (shapes.get(id).contains(p.x, p.y)) {
				return id;
			}
		}
		return null;
	}
	/**
	 * 
	 * @return set of shapes from oldest to newest (draw older ones first)
	 */
	public Set<Integer> drawingIDs(){
		return shapes.navigableKeySet();
	}
	
}
