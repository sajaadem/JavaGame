import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player  extends GameObject{

	private double VelocX ;
	private Textures tex ;
	Game game ;
	public double getVelocX() {
		return VelocX;
	}
	public void setVelocX(double velocX) {
		VelocX = velocX;
	}
	public void setVelocY(double velocY) {
		VelocY = velocY;
	}
	private double VelocY ;
 
	public Player(double x , double y , Textures tex) {
		super(x,y);
		this.tex = tex;
		this.game= game;
		
		//SpriteSheet ss = new SpriteSheet(game.getSpritSheet());
		//player = ss.grabImage(1, 1, 64, 64);
		
	}
	public void tick(){
		x +=VelocX;
		y +=VelocY;
		
		if(x < 0)
			x=0;
		if(y<0) 
			y=0;
		if(y >= 606-128)
			y=606-128;
		if(x>=740-64)
			x=740-64;
		
		
		/*
		for (int i = 0; i < game.bb.size(); i++) {

			Bullet b = game.bb.get(i);
		 if(Phisics.Collision(b, this, 80, 80,24,24)) {
		      //System.out.println("Collision Detected"); 
			 c.removeBullet(b);
		      c.removeWord(this);
		      game.setWord_killed(game.getWord_killed()+1);
		      //Game.score +=10;
		    
		    }
	}*/
	}
	public void render(Graphics g){
		g.drawImage(tex.player, (int)x , (int)y ,null);

	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
}
