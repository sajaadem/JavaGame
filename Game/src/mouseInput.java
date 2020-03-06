import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class mouseInput implements MouseListener{
    PHOTOS ph ;
    private Textures tex;
    Game game;
    boolean c = false;
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int mx = e.getX();
		int my= e.getY();
		
			tex = Game.tex;
		
  

			
			if(mx > Game.width/2+120+50 && mx<Game.width/2+120+50+150 ) {
				if(my>380-20 && my<380-20+50) {
				   Game.state = Game.STATE.start2;
				
				}
			}
	}
			/*if(mx > Game.width/2+120+50 && mx<Game.width/2+120+50+150  && Game.state == Game.STATE.start2) 
			{ 
				if(my>380-20 && my<380-20+50)
			{ 
					Game.state = Game.STATE.Menu; 
			} 
				}
			if(Game.state  == Game.STATE.Menu) {
			
		
		if(mx > Game.width/2 +120 && mx<Game.width/2 +270) {
			if(my>150 && my<200) {
			   Game.state = Game.STATE.Game;
			   try {
				tex.createImages(Game.g);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			}
		}

		if(mx > Game.width/2 +120 && mx<Game.width/2 +270) {
			if(my>250 && my<300) {
			   Game.state = Game.STATE.Normal;
			   System.out.println("nono");
			   try {
					tex.createImages(Game.g);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		if(mx > Game.width/2 +120 && mx<Game.width/2 +270) {
			if(my>350 && my<400) {
			   Game.state = Game.STATE.hard;
			   try {
					tex.createImages(Game.g);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
			}
		}
		if(mx > Game.width/2 +120 && mx<Game.width/2 +270) {
			if(my>450 && my<500) {
			   System.exit(1);
			}
		}
		}
		
	}*/

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
