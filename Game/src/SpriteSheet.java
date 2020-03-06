import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class SpriteSheet {
	private LinkedList<BufferedImage> wd = new LinkedList<BufferedImage>();

	private BufferedImage image ;
	public SpriteSheet(BufferedImage image) {
		this.image = image;
	}
	public BufferedImage grabImage(int col ,int row, int width,int height) {
		BufferedImage img = image.getSubimage((col*64)-64,( row*64)-64, width, height);
		return img;
	}
	public BufferedImage grabImage2(int col ,int row, int width,int height) {
		BufferedImage img = image.getSubimage((col*64)-64,( row*64)-64, width, height);
		return img;
	}
	public BufferedImage grabImage3(int col ,int row, int width,int height) {
		BufferedImage img = image.getSubimage((col*80)-80,( row*80)-80, width, height);
		return img;
	}
	public BufferedImage grabImage5(int col ,int row, int width,int height) {
		BufferedImage img = image.getSubimage((col*200)-200,( row*289)-289, width, height);
		return img;
	}
	public void addS(BufferedImage Block) {
		wd.add(Block);
		
	}
	public void removeS(BufferedImage Block) {
		wd.remove(Block);
	}	
}
