import java.awt.*;
public class Ball extends GameObject {

	Handler handler;

	public Ball(String ref,float x, float y, ID id, Handler handler) {
		super(ref,x, y, id);
		this.handler = handler;
		velX = 5;
		velY = 0;
	}

	public void tick() {
		x += velX;
		y -= velY; // Negative velY because the top of the screen is 0
		y = Game.Clamp((int)y, 0, Game.HEIGHT-169);
		if((x <= -20) || (x >= Game.WIDTH+20)) {
			handler.removeObject(this);
		}
		collision();
	}

	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect((int)x, (int)y, 15, 15);
	}

	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			// If tempObject is of ID.Alien, and if the alien intersects the ball, it is deleted
			if(tempObject.getId() == ID.Alien) {

				if(getBounds().intersects(tempObject.getBounds())) {

					handler.removeObject(tempObject);
					handler.removeObject(this);
					Bullet.alienKillCount++;
					// Change x-velocity of the ball to go in the opposite direction
					velX = -velX;
				}
			}

			// If tempObject is of ID.Pong, and if the pong paddle intersects the ball, the ball is deflected
			if(tempObject.getId() == ID.Pong) {

				if(getBounds().intersects(tempObject.getBounds())) {


				}
			}
		}
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 15, 15);
	}
}