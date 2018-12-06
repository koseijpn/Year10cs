package firsttry;

import java.awt.Image;
import java.awt.Toolkit;

public class badguyone {
	
	private int xCoord = 0;
	private int yCoord = 0;
	private int width = 10;
	private int height = 10;
	private Image img;
	
	public badguyone() {
		setxCoord(10);
		setyCoord(10);
		setWidth(30);
		setHeight(30);
		setImg("../images/monster2.png");
		
	}
	
	public badguyone(int x, int y, int w, int h, String imgpath) {
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

public static badguyone get(int i) {
	// TODO Auto-generated method stub
	return null;
}

public static int size() {
	// TODO Auto-generated method stub
	return 0;
}

}
	
