

import java.awt.Graphics;
import java.util.LinkedList;
/**
 * Handler
 * <br>
 * <table><tr><td> 
 *  <table summary="">
 *   <tr>
 *      <td>Routine name|</td><td>In</td><td>|Out|</td><td>Exceptions</td>
 *      <tr>
 *      <td>tick</td><td></td><td>-</td><td>-</td>
 *      </tr>
 *      <tr>
 *      <td>render</td><td>Graphics</td><td>-</td><td>-</td>
 *      </tr>
 *      <tr>
 *      <td>addObject</td><td>GameObject</td><td>-</td><td>-</td>
 *      </tr>
 *      <tr>
 *      <td>removeObject</td><td>GameObject</td><td>-</td><td>-</td>
 *      </tr>
 *   </tr>
 * </table>
 * <br>
 * Assumptions: No Assumptions <br><br>
 * 
 * State Variables: 
 * <br>
 * object: LinkedList <br>
 * tempObject: GameObject<br>
 * g: Graphics<br><br>
 * 
 * Environment  Variables: <br>
 * Screen: Display Device<br><br>
 * 
 * Access Routine Semantics:<br><br>
 * tick():<br>
 * transition: Uses game loop to dynamically add game objects in to a linked list.<br>
 * render(g):<br>
 * transition: Renders game objects on to screen.<br>
 * addObject(object):<br>
 * transition: Adds this instance of game object to linked list.<br>
 * removeObject(object):<br>
 * transition: Removes this instance of game object to linked list.<br>
 * 
 * 
 */
public class Handler {

LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick(){
		for (int i = 0; i< object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
			
		}
		
	}
	
	public void reneder (Graphics g){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
		
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
}
