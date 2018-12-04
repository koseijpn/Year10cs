package firsttry;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class GameCharacter2 {
	
	private int xCoord = 0;
	private int yCoord = 0;
	private int width = 10;
	private int height = 10;
	private Image img;
	public static boolean FaceRight1= true;
	
	public GameCharacter2() {
		setxCoord(10);
		setyCoord(10);
		setWidth(30);
		setHeight(30);
		setImg("../images/ryu1.png");
		
	}
	
	public static boolean Faceright() {
		return FaceRight1;
	}

	public void setFaceRight(boolean faceRight) {
		FaceRight1 = faceRight;
	}
	
	public GameCharacter2(int x, int y, int w, int h, String imgpath) {
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
		
		if (direction == 68) {
			x = x + speed;
			if (x > w) {x = x - speed * 3;}
			setxCoord(x);
			setImg("images/ryuleft.png");
			FaceRight1 = true;
		} else if (direction == 65) { 
			if (x < 0) {x = x + speed * 3;}
			x = x - speed;
			setxCoord(x);
			setImg("images/ryuright.png");
			FaceRight1 = false;
		} else if (direction == 87) {
			if (y < 0) {y = y + speed * 3;}
			y = y - speed;
			setyCoord(y);
			setImg("images/ryuup.png");
		} else if (direction == 83) { 
			if ( y > h - 10) {y = y - speed * 3;}
			y = y + speed;
			setyCoord(y);
			setImg("images/ryudown.png");
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
	

