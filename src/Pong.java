import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Pong extends GameObject {

	Handler handler;

	public Pong(String ref,float x, float y, ID id, Handler handler) {
		super(ref,x, y, id);
		this.handler = handler;
	}

	public void tick() {
		y -= velY; // Negative velY because the top of the screen is 0
		y = Game.Clamp((int)y, 0, Game.HEIGHT-169);
	}

	public void render(Graphics g) {
		Graphics2D g2d =(Graphics2D) g;
		g.setColor(Color.green);
		g2d.draw(getBounds());
		g.setColor(Color.red);
		g2d.draw(getBounds2());
		g.setColor(Color.white);
		g2d.draw(getBounds3());
		
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, 12, 90);
	}

	private void collision() {

	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y+7 , 12,74 );
	}
	public Rectangle getBounds2() {
		return new Rectangle((int)x, (int)y , 12, 7);
	}
	public Rectangle getBounds3() {
		return new Rectangle((int)x, (int)y+82 , 12, 8);
	}




}