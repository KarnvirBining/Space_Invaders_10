import java.awt.*;
/**
 * Uses abstract class GameObject so MIS of GameObject is the same as Alien
 */
public class Alien extends GameObject {

	Handler handler;

	public Alien(String ref, float x, float y, ID id, Handler handler) {
		
		super(ref,x, y, id);
		this.handler = handler;
		velX = 2;
	}
	

	public void tick() {
		x += velX;
		y += velY;

		// If an alien reaches the sides of the window, then invert velX and shift y down
		collision();

		// Game State Change
		if(y >= Game.HEIGHT-100){
			velX = 0;
			x = 32;
		}
	}

	private void collision() {
		if(x <= 0 || x >= Game.WIDTH-38) {
			for(int i = 0; i < handler.object.size(); i++) {
				GameObject tempObject = handler.object.get(i);
				if(tempObject.getId() == ID.Alien) {
					velX = -velX;
					y -= -39;
				}
			}
		}
	}

	public void render(Graphics g) {
		sprite.draw(g,(int) x,(int) y);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x + 4,(int)y ,34, 28);
	}

}
