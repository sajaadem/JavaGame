import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int width = 370;
	public static final int height = width/11 * 9;
	public static final int scale = 2;
	public String tiltle = "English Game";
	private boolean running = false ;
	private Thread thread ;
	private BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
	private BufferedImage spriteSheet= null;
	private BufferedImage spriteSheet2= null;
	private BufferedImage spriteSheet3= null;
	private BufferedImage spriteSheet5= null;

	private BufferedImage photo= null;
	private static BufferedImage spriteSheet4= null;
    public static Textures tex;
    PHOTOS ph ;
	private BufferedImage player;
	private Player p ;
	private Start s ;
	private Start2 s2 ;

	private PHOTOS ps ;
    public LinkedList<Word> pp;
    public LinkedList<Bullet> bb;
    public static  int score=30 ;

	private Controller c ;
	public static BufferStrategy bs;
	private boolean is_shooting = false;
	private int word_count = 5;
	public int getWord_killed() {
		return word_killed;
	}
	public void setWord_killed(int word_killed) {
		this.word_killed = word_killed;
	}
	private int word_killed = 5;

	public static Graphics g;
	Menu m ;
	Win w;
	public static enum STATE{
		Menu,
		Game,
		Easy,
		Normal,
		hard, 
		win,start
		,start2
	};
	public static STATE state = STATE.start;


	private   void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
 		
	}
	public void init() throws IOException {
		requestFocus(); 
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
		     spriteSheet = loader.loadImage("/rock.png");
		     spriteSheet2 = loader.loadImage("/bullet.png");
		     spriteSheet4 = loader.loadImage("/bubble.png");
		     spriteSheet3 = loader.loadImage("/space.jpg");
		     spriteSheet5 = loader.loadImage("/astroo.png");

		     //photo = loader.loadImage("/book.jpeg");

		}catch(IOException e) {
			e.printStackTrace();
		}
		//SpriteSheet ss =new SpriteSheet(spriteSheet);
		//player = ss.grabImage(1,1,64,64);
	
		//ps = new PHOTOS(0,440,tex) ;
		
		
		this.addKeyListener(new KeyInput(this));
		this.addMouseListener(new mouseInput3());
		
		
		tex = new Textures(this);
		s = new Start(this);

		p = new Player(200,200,tex) ;
		ps = new PHOTOS(20,20,tex) ;

		c = new Controller(this,tex,s);
		m = new Menu();
		s = new Start(this);
		s2 = new Start2(this);

        w = new Win();
		pp= c.getWd();
		bb=c.getB();

		c.addWord(word_count);
		//ph=new PHOTOS();
	}
	private synchronized void stop() {
		if(!running)
			return;
		running = true;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(1);
		
	}
	public void run() {
		//System.out.println("ddwdededwd");
		try {
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0 ;
		int updates = 0;
		int frames =0;
		long timer = System.currentTimeMillis();

		
		while(running) {

			
			long now = System.nanoTime();
			delta += (now - lastTime )/ns;
			lastTime = now;
			if(delta >=1) {
				tick();
				updates++;
				delta--;
			}
			try {
				render();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			frames++;

			if(System.currentTimeMillis()-timer > 1000) {
				timer +=1000;
				//System.out.println(updates +"ticks" + frames);
				updates = 0; 
				frames =0;
			}
			
		}
		stop();
		
	}
	private void tick() {
		if(state == STATE.Game || state == STATE.Normal) {
		p.tick();
		c.tick();
		if(word_killed >= word_count) {
			//word_count +=1;
			word_killed = 0;
			c.addWord(word_count);
			word_count=2;

					
		}
		}
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(state == STATE.Game || state == STATE.Normal || state == STATE.hard) {

		if(key == e.VK_RIGHT) {
			p.setVelocX(5);
		}else if(key == e.VK_LEFT) {
			p.setVelocX(-5);
		}else if(key == e.VK_UP) {
			p.setVelocY(-5);
		}else if(key == e.VK_DOWN) {
			p.setVelocY(5);
		}else if(key == e.VK_SPACE) {
			is_shooting = true;
			c.addBullet(new Bullet(p.getX(),p.getY(),tex,this));
		}
		
		} 
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(state == STATE.Game || state == STATE.Normal || state == STATE.hard)
		{
		if(key == e.VK_RIGHT) {
			p.setVelocX(0);
		}else if(key == e.VK_LEFT) {
			p.setVelocX(0);
		}else if(key == e.VK_UP) {
			p.setVelocY(0);
		}else if(key == e.VK_DOWN) {
			
			p.setVelocY(0);	
		}
         else if(key == e.VK_DOWN) {
			is_shooting = false;

		}
		} 
	}
	
	private void render() throws IOException {
		 bs = this.getBufferStrategy();
		
		if(bs == null) {
			createBufferStrategy(3);
			return ;
			
		}
		 g = bs.getDrawGraphics();
		////////
		
		g.drawImage(image, 0, 0, getWidth(),getHeight(),this);
		if(Game.state == Game.STATE.start) {

		this.addMouseListener(new mouseInput());
		}
		
		if (Game.state == Game.STATE.start2) {

			this.addMouseListener(new mouseInput2());
		}
		/*
		if (Game.state == Game.STATE.Menu) {

			this.addMouseListener(new mouseInput3());
		}*/
		//g.drawImage(player, 100, 100,this);
		if(state == STATE.start )
		{
			g.drawImage(spriteSheet5, 40, 160,null );

		}	if(state == STATE.start2 )
		{
			g.drawImage(spriteSheet5, 40, 160,null );

		}
		if(mouseInput2.next == true) {
			Game.state = Game.STATE.Menu;
			mouseInput2.next =false;
		}
			
		if(state == STATE.Game || state == STATE.Normal || state == STATE.hard)
		{
			//this.addMouseListener(new mouseInput6());

			
		g.drawImage(spriteSheet3, 0, 0,null );
		
	    g.drawImage(photo,0,( Game.width*Game.scale )- 300,null );
	    g.setColor(Color.GRAY);
		g.fillRect(5, 5, 120, 120);
		p.render(g);
		ps.render(g);
		c.render(g);
		
		g.setColor(Color.GRAY);
		g.fillRect(530, 5, 200, 50);
		
		if(score<=100) {
		g.setColor(Color.green);
		g.fillRect(530 , 5, score, 50);
		}
		g.setColor(Color.white);
		g.drawRect(530, 5, 200, 50);
		}
	
		else if(state == STATE.Menu) {
			m.render(g);

		}
		else if(state == STATE.win) {
			w.render(g);

			g.drawImage(spriteSheet5, 260, 250,null );


		}
		else if(state == STATE.start) {
			s.render(g);

		}
		else if(state == STATE.start2) {
			s2.render(g);

		}
		///////
		g.dispose();
		bs.show();
		  //ph=new PHOTOS();
		
		
	}
	public static void main(String args[]) {

		Game game = new Game();
		JFrame jframe = new JFrame(game.tiltle);
		jframe.setPreferredSize(new Dimension(width*scale , height *scale));
		jframe.setMinimumSize(new Dimension(width*scale , height *scale));
		jframe.setMaximumSize(new Dimension(width*scale , height *scale));
		jframe.add(game);
		jframe.pack();
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false);
		jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        game.start();
	
	}
	public int getWord_count() {
		return word_count;
	}
	public void setWord_count(int word_count) {
		this.word_count = word_count;
	}
	public  BufferedImage getSpritSheet() {
		return spriteSheet;
	}
	public  BufferedImage getSpritSheet2() {
		return spriteSheet2;
	}
	public  static BufferedImage getSpritSheet3() {
		return spriteSheet4;
	}
	public   BufferedImage getSpritSheet5() {
		return spriteSheet5;
	}
}
