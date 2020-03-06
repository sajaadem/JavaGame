import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
 

public class Word extends GameObject implements Entity{

	private Game game;
    LinkedList<Word> correctWordss = new LinkedList();
	private Textures tex ;
	Random r = new Random();
	Controller c;
	int speed = r.nextInt(3)+1;
	int i=0,i1=0;
	Font font = new  Font("arial",Font.BOLD,80);

	String[] arr = {"book","door","table","roof","sky","fly","pen","window","car","teacher","bag","obstacle ","rain"};
	String[] arr2 = {"wheelchair","skyscraper","graduated","sneeze","injury","fly","bird","bed","window","car","teacher","pen","bag"};
	String[] arr3 = {"book","door","table","roof","sky","fly","bird","bed","window","car","teacher","pen","bag"};

	int index = r.nextInt(10);
	int xx = r.nextInt(700);
	public Word(double x, double y, Textures tex, Game game,Controller  c) {
		super(x,y);
		this.tex = tex;
		this.game=game;
		this.c=c;
	}
	public void tick() {
		y +=speed;
		
		if(y>(Game.height*Game.scale)) {
			 speed = r.nextInt(3)+1;

			x = r.nextInt(640);
			y=-10;

			for (int i = 0; i < arr.length; i++)
			{
	             index = (int) (Math.random() * arr.length);

	            //System.out.print(objects[rand]);

	        }
		}
		for (int i = 0; i < game.bb.size(); i++) {

			Bullet b = game.bb.get(i);
			for(int j = 0; j < correctWordss.size(); j++) {
		 if(Phisics.Collision(b, correctWordss.get(j), 80, 80,24,24)) {
		      //System.out.println("Collision Detected"); 
			  c.removeBullet(b);
		      c.removeWord(this);
		      game.setWord_killed(game.getWord_killed()+1);
		      Game.score +=1;
		    
		    }else {
			      Game.score -=1;

		    }
	}
			}
	
	}
	public void render(Graphics g ) {
		g.setFont(font);
		g.setColor(Color.BLACK);
	    g.drawImage(tex.word,(int)x,(int )y,null);
		Font font = new  Font("arial",Font.BOLD,15);
        g.setFont(font);
        //if(i<arr.length) {
		//System.out.println(arr[index]); 
        if(Game.state == Game.STATE.Game) {
     		g.drawString(arr[index], (int)x+20 , (int)y+45);
     		
     	
    		    		if(arr[index].equals(arr[tex.i])) {
    	     	    		correctWordss.add(new Word(x-20,y-45,tex,game,c));
    	     	    		//tex.is7 = false;
    	     	    	
    		    		
    		    		
    		    		}
    		    		
    	
      	
        }
        else if(Game.state == Game.STATE.Normal)
    	
 		g.drawString(arr2[index], (int)x+20 , (int)y+45);
        else if(Game.state == Game.STATE.hard) {
     		g.drawString(arr2[index], (int)x+20 , (int)y+45);
        }
        //while(!( y==(-10 + speed))) {
        //	System.out.println(arr[index]);  
        //}
 		//g.drawString(arr[index], (int)x+20 , (int)y+45);

		//}
		//i++;
		//index = r.nextInt(3);

	}
	public double getY() {
		return y;
	}

	public double getX() {
		return y;
	}
	
}
