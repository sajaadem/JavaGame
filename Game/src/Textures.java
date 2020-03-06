import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class Textures {
	
	Controller c;

	private SpriteSheet ss;
	private SpriteSheet ss2;
	private SpriteSheet ss3;
	//private SpriteSheet ss4;
	BufferedImage images[] = new BufferedImage[10];
	SpriteSheet imagesSprite[] = new SpriteSheet[10];
	int width1[]= {100,80,100,100,100,100,64,80,80,80};
	int height1[]= {100,80,100,100,50,100,64,80,80,80};
	String[] arr = {"book","door","table","roof","sky","fly","pen","window","car","teacher","bag","",""};

	int width2[]=  {80,80,80,80,80,80,80,80,80,80};
	int height2[]= {80,80,80,80,80,80,80,80,80,80};

	int width3[]= {80,80,80,80,80,80,80,80,80,80};
	int height3[]= {80,80,80,80,80,80,80,80,80,80};
	public int in =0 ;


	Game game;
	Timer t = new Timer( );
	Timer t2 = new Timer( );

	int i =0;
	Word w;
	public boolean is7;
	private LinkedList<BufferedImage> wd = new LinkedList<BufferedImage>();


	public BufferedImage player ,bullet ,word,photo;

  public Textures(Game game) throws IOException {
  
    // ss4 =new  SpriteSheet(game.getSpritSheet3());
	     ss =new  SpriteSheet(game.getSpritSheet());
	     ss2 =new  SpriteSheet(game.getSpritSheet2());
	     ss3 =new  SpriteSheet(game.getSpritSheet3());
	     
	
}
  public Textures() throws IOException {
	   
		
	}
  public void createImages(Graphics g) throws IOException {
	 	BufferedImageLoader loader = new BufferedImageLoader();

	 	if(Game.state == Game.STATE.Game) {
		     images[0] = loader.loadImage("/book2.png");
		     images[1] = loader.loadImage("/door2.png");
		     images[2] = loader.loadImage("/table2.png");
		     images[3] = loader.loadImage("/roof.png");
		     images[4] = loader.loadImage("/sky.jpeg");
		     images[5] = loader.loadImage("/bird.png");
		     images[6] = loader.loadImage("/pen.png");
		     images[7] = loader.loadImage("/window.png");
		     images[8] = loader.loadImage("/teacher.png");
		     images[9] = loader.loadImage("/bag.png");
		     
		     //images[13] = loader.loadImage("/rock.png");
	 	}else if(Game.state == Game.STATE.Normal) {
	 		 images[0] = loader.loadImage("/wheelchair.png");
		     images[1] = loader.loadImage("/town.png");
		     images[2] = loader.loadImage("/graduated.png");
		     images[3] = loader.loadImage("/cough.png");
		     images[4] = loader.loadImage("/accident.png");
		     images[5] = loader.loadImage("/bird.png");
		     images[6] = loader.loadImage("/pen.png");
		     images[7] = loader.loadImage("/window.png");
		     images[8] = loader.loadImage("/teacher.png");
		     images[9] = loader.loadImage("/bag.png");
		 
	 	}else if (Game.state == Game.STATE.hard) {
	 		 images[0] = loader.loadImage("/wheelchair.png");
		     images[1] = loader.loadImage("/town.png");
		     images[2] = loader.loadImage("/graduated.png");
		     images[3] = loader.loadImage("/cough.png");
		     images[4] = loader.loadImage("/accident.png");
		     images[5] = loader.loadImage("/bird.png");
		     images[6] = loader.loadImage("/pen.png");
		     images[7] = loader.loadImage("/window.png");
		     images[8] = loader.loadImage("/teacher.png");
		     images[9] = loader.loadImage("/bag.png");
		
	 	}
		
		     imagesSprite[0] =new  SpriteSheet(images[0]);
		     imagesSprite[1] =new  SpriteSheet(images[1]);
		     imagesSprite[2] =new  SpriteSheet(images[2]);
		     imagesSprite[3] =new  SpriteSheet(images[3]);
		     imagesSprite[4] =new  SpriteSheet(images[4]);
		     imagesSprite[5] =new  SpriteSheet(images[5]);
		     imagesSprite[6] =new  SpriteSheet(images[6]);
		     imagesSprite[7] =new  SpriteSheet(images[7]);
		     imagesSprite[8] =new  SpriteSheet(images[8]);
		     imagesSprite[9] =new  SpriteSheet(images[9]);
	

	     
	     getTextures(g);
  }
  public void getTextures(Graphics g) {
	   
		player = ss.grabImage(1, 1, 64, 64);
		bullet = ss2.grabImage(1, 1, 24, 24);
		word = ss3.grabImage3(1, 1, 80, 80);
		int width = 64,hight=64;
		for(int i=0;i<images.length ; i++) {
			if( Game.state == Game.STATE.Game) {
					images[i] = imagesSprite[i].grabImage(1, 1, width1[i], height1[i]);
			images[i] = imagesSprite[i].grabImage(1, 1, width1[i], height1[i]);}
			else if(Game.state == Game.STATE.Normal) {
				images[i] = imagesSprite[i].grabImage(1, 1, width2[i], height2[i]);

			}else if(Game.state == Game.STATE.hard) {
				images[i] = imagesSprite[i].grabImage(1, 1, width3[i], height3[i]);

			}else {
				
			}
			}
		for(int i=0;i<images.length ; i++) {
	     wd.add(images[i]);
		}
		if(Game.state == Game.STATE.Game) {

		t.scheduleAtFixedRate(new TimerTask() {

		    @Override
		    public void run() {
		    	if(i<10) {
		      //System.out.println("Hey"+in );
			  photo = wd.get(i);
	    	  is7 = true;

			  i++;

		    	}

		    }
		}, 0,7000);
	    is7 = false;

		t2.scheduleAtFixedRate(new TimerTask() {
	        
		    @Override
		    public void run() {
		    		 Game.state = Game.STATE.win;	    	}
		    
		}, 77000,77000);
		}
  }
}