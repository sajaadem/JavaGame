	import java.awt.Color;
	import java.awt.Font;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class Start2 {
	private SpriteSheet ss;
	Game game;
	public BufferedImage player;


	public Rectangle btn1 = new Rectangle(Game.width/2+120+50 ,360-20,150,50);

		  public Start2(Game game) throws IOException {
			  
			    // ss4 =new  SpriteSheet(game.getSpritSheet3());
				     ss =new  SpriteSheet(game.getSpritSheet5());
				
				     
				
			}
		public void render(Graphics g) {
			
			//player = ss.grabImage(1, 1, 200, 289);

			Font font = new  Font("arial",Font.BOLD,80);
			Font font2 = new  Font("arial",Font.BOLD,20);
			Font font3 = new  Font("arial",Font.BOLD,20);
			Graphics2D g2D = (Graphics2D)g;

			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString("English Game", Game.width/2 -100, 100);
			g.setColor(Color.red);
			g.setFont(font2);

			g.drawString("many of English words will fall down ,you have to choose", Game.width/2+20, 210);
			g.drawString("the word that matches the photo on the top left of ", Game.width/2+30, 230);
			g.drawString("game screen the more correct words you haunt the", Game.width/2+50, 250);
			g.drawString("more you get score! ", Game.width/2+170, 270);

			g.setFont(font3);
			//g.setColor(Color.red);


			g2D.draw(btn1);
			g.setColor(Color.WHITE);

			g.drawString("Next", Game.width/2+170+50, 395-20);


		
	}

}
