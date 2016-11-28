import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pong extends GameObject {

	Handler handler;

	public Pong(String ref,float x, float y, ID id, Handler handler) {
		super(ref,x, y, id);
		this.handler = handler;
	}

	public void tick() {
		y -= velY; // Negative velY because the top of the screen is 0
		y = Game.Clamp((int)y, 0, Game.HEIGHT-90);
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, 12, 90);
	}

	private void collision() {

	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y , 12, 90);
	}

}