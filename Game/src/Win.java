import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Win {
	public Rectangle btn1 = new Rectangle(Game.width/2+120 ,190,160,30);

	
	public void render(Graphics g) {
		Font font = new  Font("arial",Font.BOLD,80);
		Font font2 = new  Font("arial",Font.BOLD,50);
		Font font3 = new  Font("arial",Font.BOLD,20);
		Graphics2D g2D = (Graphics2D)g;

		g.setFont(font);
		g.setColor(Color.WHITE);
		
		if(Game.score >10) {
		g.drawString("Congratulations", Game.width/2 -100, 100);
		g.setColor(Color.red);
		g.setFont(font2);

		g.drawString("You won!", Game.width/2+70, 170);
		}else {
			g.drawString("         Game Over", Game.width/2 -100, 100);
			g.setColor(Color.red);
			g.setFont(font2);

			g.drawString("You failed!", Game.width/2+70, 170);	
		}
		g.setFont(font3);

		//g2D.draw(btn1);
		g.setColor(Color.GREEN);
		
		g.drawString("score : "+Game.score, Game.width/2+140, 210);


	}
}
