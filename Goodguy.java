package firsttry;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Goodguy {
	
	private int xCoord = 0;
	private int yCoord = 0;
	private int width = 10;
	private int height = 10;
	private Image img;
	public static boolean FaceRight = true;
	
	public Goodguy() {
		setxCoord(10);
		setyCoord(10);
		setWidth(30);
		setHeight(30);
		setImg("/images/naruto.png");
		
	}
	public static boolean Faceright() {
		return FaceRight;
	}

	public void setFaceRight(boolean faceRight) {
		FaceRight = faceRight;
	}

	public Goodguy(int x, int y, int w, int h, String imgpath) {
		setxCoord(x);
		setyCoord(y);
		setWidth(w);
		setHeight(h);
		setImg(imgpath);
	}
	
	public void moveIt(int direction, int w, int h) {
		int speed = 20;
		int x = getxCoord();
		int y = getyCoord();
		
		if (direction == 39) {
			x = x + speed;
			if (x > w) {x = x - speed * 3;}
			setxCoord(x);
			setImg("images/narutoright.png");
			FaceRight = true;
		} else if (direction == 37) { 
			if (x < 0) {x = x + speed * 3;}
			x = x - speed;
			setxCoord(x);
			setImg("images/narutoleft.png");
			FaceRight = false;
		} else if (direction == 38) {
			if (y < 0) {y = y + speed * 3;}
			y = y - speed;
			setyCoord(y);
			setImg("images/narutoup.png");
		} else if (direction == 40) { 
			if ( y > h - 10) {y = y - speed * 3;}
			y = y + speed;
			setyCoord(y);
			setImg("images/narutodown.png");
		}
	}
	
public void setImg(String imgpath) {
	this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
}

public int getxCoord() {
	return this.xCoord;
}

public void setxCoord(int x) {
	this.xCoord = x;
}

public int getyCoord() {
	return this.yCoord;
}

public void setyCoord(int y) {
	this.yCoord = y;
}

public int getWidth() {
	return width;
}

public void setWidth(int width) {
	this.width = width;
}

public int getHeight() {
	return height;
}

public void setHeight(int height) {
	this.height = height;
}

public Image getImg() {
	return img;
}
public void remove(Rectangle a) {
	// TODO Auto-generated method stub
	
}



	
}
