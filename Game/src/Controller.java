import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

public class Controller {

	private LinkedList<Bullet> b = new LinkedList<Bullet>();
	public LinkedList<Bullet> getB() {
		return b; 
	}
	public void setB(LinkedList<Bullet> b) {
		this.b = b;
	}
	public LinkedList<Word> getWd() {
		return wd;
	}
	public void setWd(LinkedList<Word> wd) {
		this.wd = wd;
	}
	private LinkedList<Word> wd = new LinkedList<Word>();
    SpriteSheet s;
	Bullet TempBullet;
	Word word;
	Textures tex;
	Game game;
	Random r=new Random();
	public Controller(Game game,Textures tex,Start s) {
		this.game = game;
		this.tex=tex;
		//for(int x=0;x<(Game.width*Game.scale);x+=80){
			//addWord(new Word(r.nextInt(Game.width*Game.scale),0,tex));
		//}
			
	}
	public void tick() {
		for(int i=0 ; i<b.size();i++) {
			TempBullet = b.get(i);
			if(TempBullet.getY() < 0) {
				removeBullet(TempBullet);
			}
			TempBullet.tick();
			
		}
			
			for(int i=0 ; i<wd.size();i++) {
				word = wd.get(i);
			  

				word.tick();
		}
		
		
	}
	public void render(Graphics g) {
		for(int i=0 ; i<b.size();i++) {
			TempBullet = b.get(i);
			TempBullet.render(g);
		}
		for(int i=0 ; i<wd.size();i++) {
			word = wd.get(i);
			word.render(g);
		}
		
	}
	public void addBullet(Bullet Block) {
		b.add(Block);
		
	}
	public void removeBullet(Bullet Block) {
		b.remove(Block);
		
	}
	public void addWord(int  word_count) {
		for(int i=0 ; i<word_count ; i++) {
			wd.add(new Word(r.nextInt(700),-10,tex,game,this));
		}
		//wd.add(Block);
		
	}
	public void removeWord(Word Block) {
		wd.remove(Block);
		
	}
}
