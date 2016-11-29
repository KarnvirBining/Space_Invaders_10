import java.awt.*;
public class Ball extends GameObject {

	Handler handler;

	public Ball(String ref,float x, float y, ID id, Handler handler) {
		super(ref,x, y, id);
		this.handler = handler;
	}

	public void tick() {
		x += velX;
		y -= velY; // Negative velY because the top of the screen is 0
		// x = Game.Clamp((int)x, 3, Game.WIDTH-39);		// Should the ball be clamped?
		y = Game.Clamp((int)y, 0, Game.HEIGHT-169);
	}

	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillOval((int)x, (int)y, 15, 15);
	}

	private void collision() {

	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 15, 15);
	}
}