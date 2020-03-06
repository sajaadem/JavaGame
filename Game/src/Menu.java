import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	
	public Rectangle btn1 = new Rectangle(Game.width/2+120 ,150,150,50);
	public Rectangle btn2 = new Rectangle(Game.width/2+120 ,250,150,50);
	public Rectangle btn3 = new Rectangle(Game.width/2+120 ,350,150,50);
	public Rectangle btn4 = new Rectangle(Game.width/2+120 ,450,150,50);


	public void render(Graphics g) {
		Font font = new  Font("arial",Font.BOLD,50);
		Font font2 = new  Font("arial",Font.BOLD,30);

		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("English Game", Game.width/2, 100);
		
		Graphics2D g2D = (Graphics2D)g;
		g.setFont(font2);
		g.drawString("Easy", btn1.x+35, btn1.y+35);
		g2D.draw(btn1);
		g.drawString("Normal", btn2.x+25, btn2.y+35);
		g2D.draw(btn2);
		g.drawString("Difficult", btn3.x+25, btn3.y+35);
		g2D.draw(btn3);
		g.drawString("Quit", btn4.x+35, btn4.y+35);
		g2D.draw(btn4);
	}
}
