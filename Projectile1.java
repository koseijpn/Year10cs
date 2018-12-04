package firsttry;

import java.awt.Image;
import java.awt.Toolkit;

public class Projectile1 {
	
	private int xCoord = 0;
	private int yCoord = 0;
	private int width = 100;
	private int height = 100;
	private Image img;
	
	public Projectile1() {
		setxCoord(10);
		setyCoord(10);
		setWidth(100);
		setHeight(100);
		setImg("images/hadouken1.png");
	}
	
	// overloaded constructor to give adv. users more control
	public Projectile1(int x, int y, int w, int h, String imgpath) {
		setxCoord(x);
		setyCoord(y);
		setWidth(w);
		setHeight(h);
		setImg(imgpath);
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
}
	
