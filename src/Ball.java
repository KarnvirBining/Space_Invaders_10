import java.awt.*;
public class Ball extends GameObject {

	Handler handler;

	public static boolean AIDefeat = false;
	public static boolean PlayerDefeat = false;

	public Ball(String ref,float x, float y, ID id, Handler handler) {
		super(ref,x, y, id);
		this.handler = handler;
		setY(Game.HEIGHT-100);
		velX = -2;
		velY = 2;
	}

	public void tick() {
		x += velX;
		y -= velY; // Negative velY because the top of the screen is 0
		if(y < 0||y > Game.HEIGHT -75){
			velY = -velY;
		}

		// If the ball passes the player pong paddle, enter game loss
		if(x < -20) {
			handler.removeObject(this);
			PlayerDefeat = true;
		}

		// If the ball passes the AI pong paddle, enable potential to win
		if(x > Game.WIDTH) {
			handler.removeObject(this);
			AIDefeat = true;
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
					Bullet.alienKillCount++;
					
					// Change x-velocity of the ball to go in the opposite direction
					velY = -velY;
				}
			}

			// If tempObject is of ID.Pong, and if the pong paddle intersects the ball, the ball is deflected
			if(tempObject.getId() == ID.Pong) {

				if(getBounds().intersects(tempObject.getBounds())) {

					velX = -velX;
					velY = -velY;
				}
				if(getBounds().intersects(((Pong) tempObject).getBounds2())) {

					velX = -velX;
					velY = (float) (-velY*1.5);
				}
				if(getBounds().intersects(((Pong) tempObject).getBounds3())) {

					velX = -velX;
					velY = (float) (-velY*1.5);
				}
			}
			if(tempObject.getId() == ID.AI) {

				if(getBounds().intersects(tempObject.getBounds())) {

					velX = -velX;
					velY = -velY;
				}
				if(getBounds().intersects(((AI) tempObject).getBounds2())) {

					velX = -velX;
					velY = (float) (-velY*1.5);
				}
				if(getBounds().intersects(((AI) tempObject).getBounds3())) {

					velX = -velX;
					velY = (float) (-velY*1.5);
				}
			}
		}
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 15, 15);
	}
}