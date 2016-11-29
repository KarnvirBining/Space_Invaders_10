import java.awt.*;
public class Bullet extends GameObject {

	Handler handler;

	public Bullet(String ref,float x, float y, ID id, Handler handler) {
		super(ref,x, y, id);
		this.handler = handler;
	}

	public void tick() {
		//x += velX;
		y += -5;
		if(y <= 20) {
			handler.removeObject(this);
		}
		collision();
	}

	public void render(Graphics g) {
		sprite.draw(g,(int) x,(int) y);
	}

	private void collision() {
		for(int i= 0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			// If tempObject is of ID.Alien, and if the alien intersects the bullet, it is deleted
			if(tempObject.getId() == ID.Alien) {

				if(getBounds().intersects(tempObject.getBounds())) {

					handler.removeObject(tempObject);
					handler.removeObject(this);
				}
			}
		}
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x +1, (int) y ,10, 17);
	}
}