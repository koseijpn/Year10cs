package firsttry;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Random;

public class StartMenu extends Canvas implements KeyListener {
	
	Font myFont = new Font ("Arial", 1, 50);
	
	public StartMenu(){
		this.setSize(600,400);
		this.addKeyListener(this);
		this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.setFont(myFont);
		g.setColor(Color.black);
		g.drawString("Fighting Game", 10, 10);
		g.drawString("Press Enter to Continue", 10, 100);
		
	}
	
	
	
	

public void keyPressed1(KeyEvent e) {
		
		if (e.getKeyCode() == 10) {
			System.exit(0);
		}
	}





public void keyTyped1(KeyEvent e) {
	// TODO Auto-generated method stub
	
}





public void keyReleased1(KeyEvent e) {
	// TODO Auto-generated method stub
	
}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public Component getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}
}
