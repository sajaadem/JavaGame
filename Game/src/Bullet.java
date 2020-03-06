import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet extends GameObject implements Entity{

	
	private Textures tex;
	Controller c;
	private Game game;

	private BufferedImage bullet ;
	
	public Bullet(double x , double y ,Textures tex ,Game game) {
		super(x,y);
		this.tex = tex; 
		this.game = game;
		
		//SpriteSheet ss = new SpriteSheet(game.getSpritSheet2());
		//bullet = ss.grabImage(1, 1, 24, 24);
		
	}
	public void tick(){
	    y -=10;
	   
	}
	public void render(Graphics g){
		g.drawImage(tex.bullet, (int)x , (int)y ,null);
	}
	public double getY() {
		return y;
	}

	public double getX() {
		return y;
	}
	
}
