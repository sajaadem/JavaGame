import java.util.LinkedList;

public class Phisics {

	public static boolean Collision(Bullet b,Word correctWord, int width,int height ,int width2,int height2 )  {
		
		///for(int i =0;i<b.size();i++) {
		   if(correctWord.getBounds(width, height).intersects(b.getBounds(width2, height2))) {   //insects(b.get(i).getBounds(width, height))) {	
			   return true;
		}
		   //}
		return false;

	}
	public static boolean Collision( Word correctWord,Bullet b, int width,int height ,int width2,int height2 )  {
		
		//for(int i =0;i<correctWord.size();i++) {
		   if(b.getBounds(width2, height2).intersects(correctWord.getBounds(width2, height2))) {   //insects(b.get(i).getBounds(width, height))) {	
			   return true;
		}
		  // }
		return false;

	}
}
