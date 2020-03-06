import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class PHOTOS{
	private double x ;
	private double y ;
	

	private double VelocX ;
	private Textures tex ;
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
 
	public PHOTOS(double x , double y , Textures tex) {
		this.x=x;
		this.y = y;
		this.tex = tex;
		
		//SpriteSheet ss = new SpriteSheet(game.getSpritSheet());
		//player = ss.grabImage(1, 1, 64, 64);
		
	}
	public void tick(){
		
	}
	public void render(Graphics g){
		g.drawImage(tex.photo, (int)x , (int)y ,null);

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



