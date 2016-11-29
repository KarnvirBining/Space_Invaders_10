import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * Uses abstract class GameObject so MIS of GameObject is the same as Alien
 */
public class Alien extends GameObject {

	Handler handler;

	public Alien(String ref, float x, float y, ID id) {
		
		super(ref,x, y, id);
		velX = 2;
	}
	

	public void tick() {
			x += velX;
			y += velY;

			// If an alien reaches the sides of the window, then invert velX and shift y down
			if(x <= 0 || x >= Game.WIDTH-38) {
				velX = -velX;
				y -= -39;
			}
			// Game State Change
			if(y >= Game.HEIGHT-100){
				velX = 0;
				x = 32;
			}
	}

	public void render(Graphics g) {
		//g.setColor(Color.white);
		//g.fillRect((int)x, (int)y, 16, 16);
		sprite.draw(g,(int) x,(int) y);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x + 4,(int)y ,34, 28);
	}

}
