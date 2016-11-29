import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
* Window
* <br>
* <table><tr><td> 
*  <table summary="">
*   <tr>
*      <td>Routine name|</td><td>In|</td><td>Out|</td><td>Exceptions</td>
*      <tr>
*      <td>KeyInput</td><td>Handler</td><td>-</td><td>-</td>
*      </tr>
*      <tr>
*      <td>keyPressed</td><td>KeyEvent</td><td>-</td><td>-</td>
*      </tr>
*      <tr>
*      <td>keyReleased</td><td>KeyEvent</td><td>-</td><td>-</td>
*      </tr>
*   </tr>
* </table>
* <br>
* Assumptions: No Assumptions <br><br>
* 
* State Variables: 
* <br>
* handler: Handler <br>
* keyDown: boolean[]<br>
* key: int<br>
* tempObject: GameObject<br>
* e: KeyEvent<br>
* 
* Environment  Variables: <br>
* Keyboard: Input Device<br>
* 
* Access Routine Semantics:<br><br> 
* keyInput(handler):<br>
* transition: Initializes handler and keyDown array<br>
* keyPressed(e):<br>
* transition: When  key 'a' pressed player goes left. When key 'd' pressed player goes right. <br>
* keyReleased(e):<br>
* transition: When  key 'a' respective released sets keyDown boolean value to false. When  key 'd' released sets respective keyDown boolean value to false. <br>
* 
* 
*/
public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private boolean[] keyDown = new boolean[5];
	private static float dx;
	private static float dy;
	private long lastShot = 0;
	private static int displacement = 8;

	private void try2Shoot() {
		long wait = 500;
		if (System.currentTimeMillis() - lastShot < wait) {
			// Do nothing if wait is not satisfied
		}
		else {
			lastShot = System.currentTimeMillis();
			handler.addObject(new Bullet("sprites/bullet.gif",dx+8,Game.HEIGHT-75,ID.Bullet, handler));
		}
	}
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
		keyDown[4] = false;
	}
	
	public void keyPressed(KeyEvent e) {
		int key =e.getKeyCode();
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);

		for (int i = 0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			dx = tempObject.x;
			dy = tempObject.y;

			if (tempObject.getId() == ID.Player) {
				// Key events for the ship
				if(key == KeyEvent.VK_SPACE) {try2Shoot(); keyDown[0] = true;}
				if(key == KeyEvent.VK_A) {tempObject.setVelX(-displacement); dx -= displacement; keyDown[1] = true;}
				if(key == KeyEvent.VK_D) {tempObject.setVelX(displacement);  dx += displacement; keyDown[2] = true;}
			}

			if (tempObject.getId() == ID.Pong) {
				// Key events for Pong paddle
				if(key == KeyEvent.VK_W) {tempObject.setVelY(displacement);  dy += displacement; keyDown[3] = true;}
				if(key == KeyEvent.VK_S) {tempObject.setVelY(-displacement); dy -= displacement; keyDown[4] = true;}
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Player) {
				// Key events for the ship
				if(key == KeyEvent.VK_SPACE) keyDown[0] = false;//tempObject.setVelY(0);
				if(key == KeyEvent.VK_A) keyDown[1] = false;//tempObject.setVelX(0);
				if(key == KeyEvent.VK_D) keyDown[2] = false;//tempObject.setVelY(0);

				// When nothing is pressed default velocity of x is 0
				if (!keyDown[1] && !keyDown[2]) tempObject.setVelX(0);
			}

			if (tempObject.getId() == ID.Pong) {
				// Key events for Pong paddle
				if(key == KeyEvent.VK_W) keyDown[3] = false;
				if(key == KeyEvent.VK_S) keyDown[4] = false;

				// When nothing is pressed default velocity of y is 0
				if (!keyDown[3] && !keyDown[4]) tempObject.setVelY(0);
			}
		}
	}
}
